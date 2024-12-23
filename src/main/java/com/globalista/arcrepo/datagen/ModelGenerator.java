package com.globalista.arcrepo.datagen;

import com.globalista.arcrepo.content.trinkets.Relics;
import com.globalista.arcrepo.util.Keeper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

public class ModelGenerator extends FabricModelProvider {


    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator b) {
        for (Block block : Keeper.Blocks) {
            b.registerSimpleCubeAll(block);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator i) {
        for (Item item : Keeper.Items) {
            i.register(item, Models.GENERATED);
        }

        for (Relics.Builder entry : Keeper.Relics) {
            i.register(entry.getItem(), Models.GENERATED);
        }
    }
}
