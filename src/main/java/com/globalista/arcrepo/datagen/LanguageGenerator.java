package com.globalista.arcrepo.datagen;

import com.globalista.arcrepo.content.trinkets.Relics;
import com.globalista.arcrepo.util.Helper;
import com.globalista.arcrepo.util.Keeper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LanguageGenerator extends FabricLanguageProvider {

    public LanguageGenerator(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataGenerator, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        translationBuilder.add("itemGroup.arcane_repository", "Arcane Repository");
        translationBuilder.add("tag.item.arcrepo.rings", "Rings");

        for (Item item : Keeper.Items) {
            translationBuilder.add(item, Helper.formatName(item.toString()));
        }

        for (Block block : Keeper.Blocks) {
            translationBuilder.add(block.asItem(), Helper.formatName(block.asItem().toString()));
        }

        for (Relics.Builder relic : Keeper.Relics) {
            translationBuilder.add(relic.getItem(), Helper.formatName(relic.getItem().toString()));
        }
    }
}
