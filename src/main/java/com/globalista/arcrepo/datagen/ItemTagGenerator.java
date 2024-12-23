package com.globalista.arcrepo.datagen;

import com.globalista.arcrepo.content.trinkets.Relics;
import com.globalista.arcrepo.util.Keeper;
import com.globalista.arcrepo.util.Locator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider<Item> {


    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    public static final TagKey<Item> RINGS = TagKey.of(RegistryKeys.ITEM, Locator.id("rings"));
    public static final TagKey<Item> NECKLACES = TagKey.of(RegistryKeys.ITEM, Locator.id("necklaces"));
    public static final TagKey<Item> MASKS = TagKey.of(RegistryKeys.ITEM, Locator.id("masks"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        for (Relics.Builder entry : Keeper.Relics){
            if(entry.getId().toString().contains("_ring")){
                getOrCreateTagBuilder(RINGS).add(entry.getItem());
            }

            if(entry.getId().toString().contains("_necklace")){
                getOrCreateTagBuilder(NECKLACES).add(entry.getItem());
            }

            if(entry.getId().toString().contains("_mask")){
                getOrCreateTagBuilder(MASKS).add(entry.getItem());
            }
        }
    }
}
