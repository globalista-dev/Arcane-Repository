package com.globalista.arcrepo.util;

import com.globalista.arcrepo.ArcaneRepository;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class Locator {

    public static Identifier id(String name) {

        Item item = Registries.ITEM.get(Identifier.of(name));
        Item nullItem = Registries.ITEM.get(Identifier.of(name));

        if(item != nullItem){
            return Identifier.of(name);
        } else {
            return Identifier.of(ArcaneRepository.MOD_ID, name);
        }

    }

    public static Item getItem(String name) {
        return Registries.ITEM.get(id(name));
    }

    public static Block getBlock(String name){
        return Registries.BLOCK.get(id(name));
    }

}
