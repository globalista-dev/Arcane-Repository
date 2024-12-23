package com.globalista.arcrepo.datagen;

import com.globalista.arcrepo.content.Gem;
import com.globalista.arcrepo.textures.TextureStitcher;
import com.globalista.arcrepo.util.Helper;
import com.globalista.arcrepo.util.Keeper;
import com.globalista.arcrepo.util.Locator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        cook(exporter, Locator.getItem("raw_silver"), Locator.getItem("silver_ingot"));
        cook(exporter, Locator.getItem("silver_ore"), Locator.getItem("silver_ingot"));
        cook(exporter, Locator.getItem("deepslate_silver_ore"), Locator.getItem("silver_ingot"));
        cook(exporter, Locator.getItem("ruby_ore"), Locator.getItem("ruby"));
        cook(exporter, Locator.getItem("jade_ore"), Locator.getItem("jade"));
        cook(exporter, Locator.getItem("sapphire_ore"), Locator.getItem("sapphire"));
        cook(exporter, Locator.getItem("deepslate_sapphire_ore"), Locator.getItem("sapphire"));
        cook(exporter, Locator.getItem("topaz_ore"), Locator.getItem("topaz"));
        cook(exporter, Locator.getItem("deepslate_topaz_ore"), Locator.getItem("topaz"));

        ring(exporter, "silver");
        ring(exporter, "gold");
        mask(exporter, "silver");
        mask(exporter, "gold");
        necklace(exporter, "silver");
        necklace(exporter, "gold");


    }


    public static void cook(RecipeExporter exporter, Item input, Item output) {
        FabricRecipeProvider.offerSmelting(exporter, List.of(input), RecipeCategory.MISC, output, 0.7f, 200, Helper.split(input.toString()));
        FabricRecipeProvider.offerBlasting(exporter, List.of(input), RecipeCategory.MISC, output, 0.7f, 100, Helper.split(input.toString()));
    }

    public static void ring(RecipeExporter exporter, String material){
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Locator.getItem(material + "_ring"))
                .pattern(" i ")
                .pattern("i i")
                .pattern(" i ")
                .input('i', Locator.getItem(material + "_ingot"))
                .criterion(FabricRecipeProvider.hasItem(Locator.getItem(material + "_ingot")),
                        FabricRecipeProvider.conditionsFromItem(Locator.getItem(material + "_ingot")))
                .offerTo(exporter);

        for (Gem gem : Keeper.Gems) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Locator.getItem("petty_" + material + "_" +gem.getName() + "_ring"))
                    .pattern("r")
                    .pattern("g")
                    .input('r', Locator.getItem(material + "_ring"))
                    .input('g', gem.getItem())
                    .criterion(FabricRecipeProvider.hasItem(Locator.getItem(material + "_ring")),
                            FabricRecipeProvider.conditionsFromItem(Locator.getItem(material + "_ring")))
                    .offerTo(exporter);
        }
    }

    public static void mask(RecipeExporter exporter, String material){
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Locator.getItem(material + "_mask"))
                .pattern(" i ")
                .pattern("iii")
                .pattern("iii")
                .input('i', Locator.getItem(material + "_ingot"))
                .criterion(FabricRecipeProvider.hasItem(Locator.getItem(material + "_ingot")),
                        FabricRecipeProvider.conditionsFromItem(Locator.getItem(material + "_ingot")))
                .offerTo(exporter);

        for (Gem gem : Keeper.Gems) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Locator.getItem("petty_" + material + "_" +gem.getName() + "_mask"))
                    .pattern("grg")
                    .input('r', Locator.getItem(material + "_mask"))
                    .input('g', gem.getItem())
                    .criterion(FabricRecipeProvider.hasItem(Locator.getItem(material + "_mask")),
                            FabricRecipeProvider.conditionsFromItem(Locator.getItem(material + "_mask")))
                    .offerTo(exporter);
        }

    }

    public static void necklace(RecipeExporter exporter, String material){
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Locator.getItem(material + "_necklace"))
                .pattern("iii")
                .pattern("i i")
                .pattern("iii")
                .input('i', Locator.getItem(material + "_ingot"))
                .criterion(FabricRecipeProvider.hasItem(Locator.getItem(material + "_ingot")),
                        FabricRecipeProvider.conditionsFromItem(Locator.getItem(material + "_ingot")))
                .offerTo(exporter);

        for (Gem gem : Keeper.Gems) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Locator.getItem("petty_" + material + "_" +gem.getName() + "_necklace"))
                    .pattern("r")
                    .pattern("g")
                    .input('r', Locator.getItem(material + "_necklace"))
                    .input('g', gem.getItem())
                    .criterion(FabricRecipeProvider.hasItem(Locator.getItem(material + "_necklace")),
                            FabricRecipeProvider.conditionsFromItem(Locator.getItem(material + "_necklace")))
                    .offerTo(exporter);
        }

    }

}
