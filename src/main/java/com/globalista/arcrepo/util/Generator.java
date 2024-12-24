package com.globalista.arcrepo.util;

import com.globalista.arcrepo.content.Attribute;
import com.globalista.arcrepo.content.Gem;
import com.globalista.arcrepo.content.UpgradeItem;
import com.globalista.arcrepo.content.trinkets.GenericRelic;
import com.globalista.arcrepo.content.trinkets.Relics;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {

    public static void initialize(){}

    public static void generateSimpleItem(String name, Item item){
        Keeper.Items.add(Registry.register(Registries.ITEM, Locator.id(name), item));
    }

    public static void generateSimpleItem(String name){
        Keeper.Items.add(Registry.register(Registries.ITEM, Locator.id(name),
                new Item(new Item.Settings())));
    }

    public static void generateTemplateItem(String name){
        Keeper.Items.add(Registry.register(Registries.ITEM, Locator.id(name),
                new UpgradeItem(name)));
    }

    public static void generateSimpleBlock(String name, Block copy){
        var block = new Block(AbstractBlock.Settings.copy(copy));
        Keeper.Blocks.add(Registry.register(Registries.BLOCK, Locator.id(name), block));
        Registry.register(Registries.ITEM, Locator.id(name), new BlockItem(block, new Item.Settings()));
    }
    public static void generateExperienceBlock(String name, Block copy){
        var block = new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(copy));
        Keeper.Blocks.add(Registry.register(Registries.BLOCK, Locator.id(name), block));
        Registry.register(Registries.ITEM, Locator.id(name), new BlockItem(block, new Item.Settings()));
    }

    public static void generateGem(String name, String attribute, float modifier, EntityAttributeModifier.Operation operation, String cursedAttribute, float cursedModifier, EntityAttributeModifier.Operation cursedOperation){

        generateSimpleItem(name);

        generateSimpleItem("cut_" + name);

        Keeper.Gems.add(new Gem(name, attribute, modifier, operation, cursedAttribute, cursedModifier, cursedOperation,
                Locator.getItem(name)));
    }

    public static void generateGem(String name, String attribute, float modifier, EntityAttributeModifier.Operation operation, String cursedAttribute, float cursedModifier, EntityAttributeModifier.Operation cursedOperation, Item existingItem){

        generateSimpleItem("cut_" + name);

        Keeper.Gems.add(new Gem(name, attribute, modifier, operation, cursedAttribute, cursedModifier, cursedOperation,
                existingItem));
    }

    public static void generateRelic(String name, GenericRelic.Type type, Gem gem) {
        Relics.build(Locator.id(name), type.getRarity(), new Attribute.Lister(List.of(
                new Attribute.Modifier(gem.getAttribute(), gem.getModifier() * type.getMultiplier(), gem.getOperation())
        )));
    }

    public static void generateRelic(String name, GenericRelic.Type type, Gem gem, List<String> attributes, boolean isCursed) {
        List<Attribute.Modifier> modifiers = attributes.stream()
                .map(attribute -> {
                    if (isCursed && attribute.equals(gem.getCursedAttribute())) {
                        return new Attribute.Modifier(attribute, gem.getCursedModifier(), gem.getCursedOperation());
                    } else {
                        return new Attribute.Modifier(attribute, gem.getModifier() * type.getMultiplier(), gem.getOperation());
                    }

                })
                .collect(Collectors.toList());

        modifiers.add(new Attribute.Modifier(Attribute.GENERIC_ARMOR, 1F, EntityAttributeModifier.Operation.ADD_VALUE));

        Relics.build(Locator.id(name), type.getRarity(), new Attribute.Lister(modifiers));
    }

    public static void generateRelic(String name, GenericRelic.Type type, List<String> attributes, List<Float> modifiers, List<EntityAttributeModifier.Operation> operations) {
        if (attributes.size() != modifiers.size() || modifiers.size() != operations.size()) {
            throw new IllegalArgumentException("Attributes, modifiers, and operations lists must have the same size.");
        }

        Relics.build(Locator.id(name), type.getRarity(), new Attribute.Lister(
                IntStream.range(0, attributes.size())
                        .mapToObj(i -> new Attribute.Modifier(
                                attributes.get(i),
                                modifiers.get(i) * type.getMultiplier(),
                                operations.get(i)
                        ))
                        .toList()
        ));
    }

    public static void generateRelicSet(String name, GenericRelic.Kind kind){
        Relics.build(Locator.id(name + "_" + kind.getName()), Rarity.COMMON, new Attribute.Lister(List.of(
                new Attribute.Modifier(Attribute.GENERIC_ARMOR, 1F, EntityAttributeModifier.Operation.ADD_VALUE)
        )));

        for (GenericRelic.Type type : Keeper.Types) {
            for (Gem gem : Keeper.Gems) {
                List<String> attributes = new ArrayList<>();
                attributes.add(gem.getAttribute()); // Add the primary gem attribute

                boolean isCursed = type == GenericRelic.Type.CURSED;
                if (isCursed) {
                    attributes.add(gem.getCursedAttribute()); // Add the cursed attribute if type is CURSED
                }

                generateRelic(
                        type.getName() + "_" + name + "_" + gem.getName() + "_" + kind.getName(),
                        type,
                        gem,
                        attributes,
                        isCursed
                );
            }
        }
    }



}
