package com.globalista.arcrepo.datagen;

import com.globalista.arcrepo.util.Helper;
import com.globalista.arcrepo.util.Keeper;
import com.globalista.arcrepo.util.Locator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LootTableGenerator extends FabricBlockLootTableProvider {
    public LootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        for (Block block : Keeper.Blocks){
            if(block.toString().contains("silver")) {
                addDrop(block, drops(block, Locator.getItem("raw_silver")));
            } else {
                addDrop(block, drops(block, Locator.getItem(Helper.split(block.asItem().toString()))));
            }
        }
    }
}
