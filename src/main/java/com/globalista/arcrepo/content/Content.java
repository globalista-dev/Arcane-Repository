package com.globalista.arcrepo.content;

import com.globalista.arcrepo.content.trinkets.GenericRelic;
import com.globalista.arcrepo.util.Generator;
import com.globalista.arcrepo.util.Keeper;
import com.globalista.arcrepo.util.Locator;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;

import static com.globalista.arcrepo.content.Attribute.*;
import static net.minecraft.entity.attribute.EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE;
import static net.minecraft.entity.attribute.EntityAttributeModifier.Operation.ADD_VALUE;

public class Content {

    public static void initialize(){}

    static {
        // Gems
        Generator.generateGem("diamond", GENERIC_ATTACK_DAMAGE, 0.1F, ADD_MULTIPLIED_BASE,
                GENERIC_ATTACK_SPEED, -0.2F, ADD_MULTIPLIED_BASE, Items.DIAMOND);
        Generator.generateGem("emerald", GENERIC_LUCK, 0.1F, ADD_MULTIPLIED_BASE,
                PLAYER_BLOCK_INTERACTION_RANGE, -1F, ADD_VALUE, Items.EMERALD);
        Generator.generateGem("quartz", GENERIC_FALL_DAMAGE_MULTIPLIER, -0.1F, ADD_MULTIPLIED_BASE,
                GENERIC_MAX_HEALTH, -0.2F, ADD_MULTIPLIED_BASE, Items.QUARTZ);
        Generator.generateGem("amethyst", GENERIC_ATTACK_KNOCKBACK, 0.1F, ADD_MULTIPLIED_BASE,
                GENERIC_KNOCKBACK_RESISTANCE, -0.2F, ADD_MULTIPLIED_BASE, Items.AMETHYST_SHARD);
        Generator.generateGem("lapis_lazuli", PLAYER_BLOCK_BREAK_SPEED, 0.1F, ADD_MULTIPLIED_BASE,
                PLAYER_MINING_EFFICIENCY, -0.2F, ADD_MULTIPLIED_BASE, Items.LAPIS_LAZULI);
        Generator.generateGem("ruby", GENERIC_MAX_HEALTH, 2F, ADD_VALUE,
                GENERIC_ATTACK_DAMAGE, -0.2F, ADD_MULTIPLIED_BASE);
        Generator.generateGem("sapphire", GENERIC_OXYGEN_BONUS, 0.1F, ADD_MULTIPLIED_BASE,
                GENERIC_LUCK, -0.2F, ADD_MULTIPLIED_BASE);
        Generator.generateGem("topaz", GENERIC_MOVEMENT_SPEED, 0.1F, ADD_MULTIPLIED_BASE,
                GENERIC_SAFE_FALL_DISTANCE, -0.2F, ADD_MULTIPLIED_BASE);
        Generator.generateGem("jade", GENERIC_ATTACK_DAMAGE, 0.1F, ADD_MULTIPLIED_BASE,
                GENERIC_ATTACK_KNOCKBACK, -0.2F, ADD_MULTIPLIED_BASE);

        // Ore sets
        Generator.generateSimpleBlock("silver_ore", Blocks.IRON_ORE);
        Generator.generateSimpleBlock("deepslate_silver_ore", Blocks.DEEPSLATE_IRON_ORE);
        Generator.generateSimpleBlock("silver_block", Blocks.IRON_BLOCK);
        Generator.generateSimpleBlock("raw_silver_block", Blocks.RAW_IRON_BLOCK);
        Generator.generateSimpleItem("raw_silver");
        Generator.generateSimpleItem("silver_ingot");
        Generator.generateSimpleBlock("ruby_ore", Blocks.NETHER_GOLD_ORE);
        Generator.generateSimpleBlock("ruby_block", Blocks.EMERALD_BLOCK);
        Generator.generateExperienceBlock("sapphire_ore", Blocks.EMERALD_ORE);
        Generator.generateExperienceBlock("deepslate_sapphire_ore", Blocks.DEEPSLATE_EMERALD_ORE);
        Generator.generateSimpleBlock("sapphire_block", Blocks.EMERALD_BLOCK);
        Generator.generateExperienceBlock("jade_ore", Blocks.END_STONE);
        Generator.generateSimpleBlock("jade_block", Blocks.EMERALD_BLOCK);
        Generator.generateExperienceBlock("topaz_ore", Blocks.EMERALD_ORE);
        Generator.generateExperienceBlock("deepslate_topaz_ore", Blocks.DEEPSLATE_EMERALD_ORE);
        Generator.generateSimpleBlock("topaz_block", Blocks.EMERALD_BLOCK);

        // Relics
        Generator.generateRelicSet("silver", GenericRelic.Kind.RING);
        Generator.generateRelicSet("gold", GenericRelic.Kind.RING);
        Generator.generateRelicSet("silver", GenericRelic.Kind.NECKLACE);
        Generator.generateRelicSet("gold", GenericRelic.Kind.NECKLACE);
        Generator.generateRelicSet("silver", GenericRelic.Kind.MASK);
        Generator.generateRelicSet("gold", GenericRelic.Kind.MASK);

    }




}
