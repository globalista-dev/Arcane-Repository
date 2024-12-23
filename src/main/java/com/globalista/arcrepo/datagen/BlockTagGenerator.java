package com.globalista.arcrepo.datagen;

import com.globalista.arcrepo.util.Keeper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.registry.RegistryKeys.BLOCK;

public class BlockTagGenerator extends FabricTagProvider<Block> {
    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, BLOCK, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        for (Block block : Keeper.Blocks) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);

            if(block.toString().contains("_block")) {
                getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(block);
                getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(block);
            }

            if(block.toString().contains("_ore")){
                getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(block);
            }

        }
    }
}
