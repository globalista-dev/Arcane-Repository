package com.globalista.arcrepo.util;

import com.globalista.arcrepo.ArcaneRepository;
import com.globalista.arcrepo.content.Gem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class Locator {

    public static Identifier id(String name) {

        return Identifier.of(ArcaneRepository.MOD_ID, name);

    }

    private static Identifier id2(String name) {

        Item item = Registries.ITEM.get(Identifier.of(name));
        Item nullItem = Registries.ITEM.get(Identifier.of("null"));

        if(item != nullItem){
            return Identifier.of(name);
        } else {
            return Identifier.of(ArcaneRepository.MOD_ID, name);
        }

    }

    public static Item getItem(String name) {
        return Registries.ITEM.get(id2(name));
    }

    public static Block getBlock(String name){
        return Registries.BLOCK.get(id2(name));
    }

    public static boolean match(String name){
        return Identifier.of("minecraft", name).equals(Identifier.of(ArcaneRepository.MOD_ID, name));
    }

    public static Gem getGem(String name){
        return switch (name) {
            case "diamond" -> Keeper.Gems.getFirst();
            case "emerald" -> Keeper.Gems.get(1);
            case "quartz" -> Keeper.Gems.get(2);
            case "amethyst" -> Keeper.Gems.get(3);
            case "ruby" -> Keeper.Gems.get(4);
            case "sapphire" -> Keeper.Gems.get(5);
            case "topaz" -> Keeper.Gems.get(6);
            case "jade" -> Keeper.Gems.get(7);
            default -> null;
        };
    }

}
