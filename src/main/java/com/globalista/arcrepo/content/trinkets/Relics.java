package com.globalista.arcrepo.content.trinkets;


import com.globalista.arcrepo.content.Attribute;
import com.globalista.arcrepo.util.Group;
import com.globalista.arcrepo.util.Locator;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static com.globalista.arcrepo.util.Keeper.Relics;

public class Relics {

    public interface Maker {
        GenericRelic create(Item.Settings settings);
    }

    public static final class Builder {
        private final Identifier id;
        private final Maker maker;
        private final Rarity rarity;
        private final Attribute.Lister attributeLister;
        public GenericRelic item;

        public Builder(Identifier id, Maker maker, Rarity rarity, Attribute.Lister attributeLister) {
            this.id = id;
            this.maker = maker;
            this.rarity = rarity;
            this.attributeLister = attributeLister;
        }

        public Identifier getId() {
            return id;
        }
        public GenericRelic getItem() {
            return item;
        }

        public GenericRelic create(Item.Settings settings) {
            item = maker.create(settings);
            return item;
        }


    }

    public static Builder build(Identifier id, Attribute.Lister config) {
        return build(id, Rarity.COMMON, config);
    }

    public static Builder build(Identifier id, Rarity rarity, Attribute.Lister config) {
        var entry = new Builder(id, GenericRelic::new, rarity, config);
        Relics.add(entry);
        return entry;
    }

    private static final Identifier identifier = Locator.id( "buff");
    public static Attribute.Lister Lister = new Attribute.Lister();
    public static void initialize() {
        for (Relics.Builder relic : Relics) {
            Attribute.Lister listerConfig = relic.attributeLister;
            Lister.StringLister.put(relic.id.toString(), relic.attributeLister);
            AttributeModifiersComponent.Builder attributes = AttributeModifiersComponent.builder();
            for (var modifier : listerConfig.Attributes) {
                var id = Identifier.of(modifier.id);
                var attribute = Registries.ATTRIBUTE.getEntry(id);
                if (attribute.isPresent()) {
                    attributes.add(attribute.get(), new EntityAttributeModifier(identifier, modifier.value, modifier.operation), AttributeModifierSlot.ANY);
                } else { System.err.println("No " + modifier.id + " EntityAttribute found"); }
            }

            var r = relic.create(new Item.Settings().rarity(relic.rarity));
            r.passModifiers(attributes.build());
            Registry.register(Registries.ITEM, relic.getId(), r);

        }

        ItemGroupEvents.modifyEntriesEvent(Group.ARCANE_REPOSITORY_KEY).register((content) -> {
            for (Relics.Builder entry : Relics) {
                content.add(entry.getItem());
            }
        });
    }
}
