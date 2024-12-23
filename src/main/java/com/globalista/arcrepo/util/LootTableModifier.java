package com.globalista.arcrepo.util;

import com.globalista.arcrepo.content.trinkets.Relics;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class LootTableModifier {

    public static void initialize(){

        defaultInclude(Locator.getItem("silver_ring"), 0.03f);
        defaultInclude(Locator.getItem("gold_ring"), 0.03f);
        defaultInclude(Locator.getItem("silver_necklace"), 0.02f);
        defaultInclude(Locator.getItem("gold_necklace"), 0.02f);
        defaultInclude(Locator.getItem("silver_mask"), 0.01f);
        defaultInclude(Locator.getItem("gold_mask"), 0.01f);

        for (Relics.Builder relic : Keeper.Relics) {
            if(relic.getItem().toString().contains("cursed")){
                cursedInclude(relic.getItem(), 0.0005f);
            }

            if(relic.getItem().toString().contains("grand")){
                endgameLootInclude(relic.getItem(), 0.0002f);
            }

            if(relic.getItem().toString().contains("greater")){
                endgameLootInclude(relic.getItem(), 0.0004f);
            }

            if(relic.getItem().toString().contains("lesser")){
                genericLootInclude(relic.getItem(), 0.001f);
            }

            if(relic.getItem().toString().contains("petty")){
                genericLootInclude(relic.getItem(), 0.002f);
            }

        }

    }

    public static void defaultInclude(Item item, float chance) {

        LootTableEvents.MODIFY.register(((key, builder, source, wrapperLookup) -> {

            var value = key.getValue();

            if (VILLAGE_ARMORER.equals(value)) {
                builder.pool(builder(item, chance));
            }

            if (ABANDONED_MINESHAFT.equals(value)) {
                builder.pool(builder(item, chance));
            }

            if (SIMPLE_DUNGEON.equals(value)) {
                builder.pool(builder(item, chance));
            }

        }));

    }

    public static void cursedInclude(Item item, float chance) {
        LootTableEvents.MODIFY.register(((key, builder, source, wrapperLookup) -> {

            var value = key.getValue();

            if (ANCIENT_CITY.equals(value)) {
                builder.pool(builder(item, chance));
            }

            if (ANCIENT_CITY_ICE_BOX.equals(value)) {
                builder.pool(builder(item, chance));
            }

        }));
    }

    public static void genericLootInclude(Item item, float chance){
        LootTableEvents.MODIFY.register(((key, builder, source, wrapperLookup) -> {

            var value = key.getValue();

            if(!item.toString().contains("mask")) {
                if (VILLAGE_ARMORER.equals(value)) {
                    builder.pool(builder(item, chance));
                }

                if(SHIPWRECK_TREASURE.equals(value)) {
                    builder.pool(builder(item, chance));
                }

                if(BURIED_TREASURE.equals(value)) {
                    builder.pool(builder(item, chance));
                }
            }

            if(SIMPLE_DUNGEON.equals(value)) {
                builder.pool(builder(item, chance));
            }

            if(ABANDONED_MINESHAFT.equals(value)) {
                builder.pool(builder(item, chance));
            }

        }));
    }

    public static void endgameLootInclude(Item item, float chance){
        LootTableEvents.MODIFY.register(((key, builder, source, wrapperLookup) -> {

            var value = key.getValue();

            if(PILLAGER_OUTPOST.equals(value)) {
                builder.pool(builder(item, chance));
            }

            if(WOODLAND_MANSION.equals(value)) {
                builder.pool(builder(item, chance));
            }

            if(BASTION_TREASURE.equals(value)) {
                builder.pool(builder(item, 0.002f));
            }

            if(END_CITY_TREASURE.equals(value)) {
                builder.pool(builder(item, 0.003f));
            }

        }));
    }

    public static LootPool.Builder builder(Item item, float chance){

        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance))
                .with(ItemEntry.builder(item))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0f, 1f)).build());

    }

    public static final Identifier ABANDONED_MINESHAFT = Identifier.of("chests/abandoned_mineshaft");
    public static final Identifier ANCIENT_CITY = Identifier.of("chests/ancient_city");
    public static final Identifier ANCIENT_CITY_ICE_BOX = Identifier.of("chests/ancient_city_ice_box");
    public static final Identifier BASTION_BRIDGE = Identifier.of("chests/bastion_bridge");
    public static final Identifier BASTION_HOGLIN_STABLE = Identifier.of("chests/bastion_hoglin_stable");
    public static final Identifier BASTION_OTHER = Identifier.of("chests/bastion_other");
    public static final Identifier BASTION_TREASURE = Identifier.of("chests/bastion_treasure");
    public static final Identifier BURIED_TREASURE = Identifier.of("chests/buried_treasure");
    public static final Identifier DESERT_PYRAMID = Identifier.of("chests/desert_pyramid");
    public static final Identifier END_CITY_TREASURE = Identifier.of("chests/end_city_treasure");
    public static final Identifier IGLOO_CHEST = Identifier.of("chests/igloo_chest");
    public static final Identifier JUNGLE_TEMPLE = Identifier.of("chests/jungle_temple");
    public static final Identifier NETHER_BRIDGE = Identifier.of("chests/nether_bridge");
    public static final Identifier PILLAGER_OUTPOST = Identifier.of("chests/pillager_outpost");
    public static final Identifier RUINED_PORTAL = Identifier.of("chests/ruined_portal");
    public static final Identifier SHIPWRECK_TREASURE = Identifier.of("chests/shipwreck_treasure");
    public static final Identifier SIMPLE_DUNGEON = Identifier.of("chests/simple_dungeon");
    public static final Identifier STRONGHOLD_CORRIDOR = Identifier.of("chests/stronghold_corridor");
    public static final Identifier STRONGHOLD_CROSSING = Identifier.of("chests/stronghold_crossing");
    public static final Identifier STRONGHOLD_LIBRARY = Identifier.of("chests/stronghold_library");
    public static final Identifier UNDERWATER_RUIN_BIG = Identifier.of("chests/underwater_ruin_big");
    public static final Identifier UNDERWATER_RUIN_SMALL = Identifier.of("chests/underwater_ruin_small");
    public static final Identifier WOODLAND_MANSION = Identifier.of("chests/woodland_mansion");
    public static final Identifier VILLAGE_ARMORER = Identifier.of("chests/village_armorer");
    public static final Identifier VILLAGE_TEMPLE = Identifier.of("chests/village/village_temple");
    public static final Identifier VILLAGE_TOOLSMITH = Identifier.of("chests/village/village_toolsmith");
    public static final Identifier VILLAGE_WEAPONSMITH = Identifier.of("chests/village/village_weaponsmith");

}
