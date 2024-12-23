package com.globalista.arcrepo.content.trinkets;

import com.globalista.arcrepo.util.Keeper;
import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class GenericRelic extends TrinketItem {

    private AttributeModifiersComponent customAttributes = AttributeModifiersComponent.builder().build();

    public GenericRelic(Settings settings) {
        super(settings.maxCount(1));
    }

    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier slotIdentifier) {
        var modifiers = super.getModifiers(stack, slot, entity, slotIdentifier);
        for (var entry : this.customAttributes.modifiers()) {
            modifiers.put(entry.attribute(),
                    new EntityAttributeModifier(slotIdentifier, entry.modifier().value(), entry.modifier().operation()));
        }
        return modifiers;
    }

    public void passModifiers(AttributeModifiersComponent component) {
        this.customAttributes = component;
    }

    public static class Type {
        private float multiplier;
        private Rarity rarity;
        private String name;

        public Type(String name, float multiplier, Rarity rarity) {
            this.name = name;
            this.multiplier = multiplier;
            this.rarity = rarity;
        }

        public float getMultiplier() {
            return multiplier;
        }

        public Rarity getRarity() {
            return rarity;
        }

        public String getName() {
            return name;
        }

        public static final Type PETTY = new Type("petty", 0.5f, Rarity.COMMON);
        public static final Type LESSER = new Type("lesser", 1f, Rarity.UNCOMMON);
        public static final Type GREATER = new Type("greater", 2f, Rarity.RARE);
        public static final Type GRAND = new Type("grand", 3f, Rarity.EPIC);
        public static final Type CURSED = new Type("cursed", 5f, Rarity.EPIC);

        public static void initialize(){
            Keeper.Types.add(PETTY);
            Keeper.Types.add(LESSER);
            Keeper.Types.add(GREATER);
            Keeper.Types.add(GRAND);
            Keeper.Types.add(CURSED);
            Keeper.Kinds.add(Kind.RING);
            Keeper.Kinds.add(Kind.GLOVE);
            Keeper.Kinds.add(Kind.AGLET);
            Keeper.Kinds.add(Kind.MASK);
            Keeper.Kinds.add(Kind.NECKLACE);
        }
    }

    public static class Kind{
        private String name;

        public Kind(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static final Kind RING = new Kind("ring");
        public static final Kind NECKLACE = new Kind("necklace");
        public static final Kind AGLET = new Kind("aglet");
        public static final Kind GLOVE = new Kind("glove");
        public static final Kind MASK = new Kind("mask");
    }

}
