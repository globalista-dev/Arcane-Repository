package com.globalista.arcrepo.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;

public class Group {

    public static void initialize(){

        Registry.register(Registries.ITEM_GROUP, ARCANE_REPOSITORY_KEY, ARCANE_REPOSITORY);

        ItemGroupEvents.modifyEntriesEvent(ARCANE_REPOSITORY_KEY).register(itemGroup ->{
            for (Item item : Keeper.Items) {
                itemGroup.add(item);
            }

            for (Block block : Keeper.Blocks) {
                itemGroup.add(block);
            }
        });


    }

    public static final RegistryKey<net.minecraft.item.ItemGroup> ARCANE_REPOSITORY_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Locator.id("arcane_repository"));
    public static final net.minecraft.item.ItemGroup ARCANE_REPOSITORY = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Locator.getItem("ruby")))
            .displayName(Text.translatable("itemGroup.arcane_repository"))
            .build();

}
