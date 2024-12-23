package com.globalista.arcrepo.content;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attribute {

    public static final String GENERIC_ARMOR = "generic.armor";
    public static final String GENERIC_ARMOR_TOUGHNESS = "generic.armor_toughness";
    public static final String GENERIC_ATTACK_DAMAGE = "generic.attack_damage";
    public static final String GENERIC_ATTACK_KNOCKBACK = "generic.attack_knockback";
    public static final String GENERIC_ATTACK_SPEED = "generic.attack_speed";
    public static final String GENERIC_BLOCK_INTERACTION_RANGE = "generic.block_interaction_range";
    public static final String GENERIC_BURNING_TIME = "generic.burning_time";
    public static final String GENERIC_ENTITY_INTERACTION_RANGE = "generic.entity_interaction_range";
    public static final String GENERIC_EXPLOSION_KNOCKBACK_RESISTANCE = "generic.explosion_knockback_resistance";
    public static final String GENERIC_FALL_DAMAGE_MULTIPLIER = "generic.fall_damage_multiplier";
    public static final String GENERIC_FLYING_SPEED = "generic.flying_speed";
    public static final String GENERIC_FOLLOW_RANGE = "generic.follow_range";
    public static final String GENERIC_GRAVITY = "generic.gravity";
    public static final String GENERIC_JUMP_STRENGTH = "generic.jump_strength";
    public static final String GENERIC_KNOCKBACK_RESISTANCE = "generic.knockback_resistance";
    public static final String GENERIC_LUCK = "generic.luck";
    public static final String GENERIC_MAX_ABSORPTION = "generic.max_absorption";
    public static final String GENERIC_MAX_HEALTH = "generic.max_health";
    public static final String GENERIC_MOVEMENT_EFFICIENCY = "generic.movement_efficiency";
    public static final String GENERIC_MOVEMENT_SPEED = "generic.movement_speed";
    public static final String GENERIC_OXYGEN_BONUS = "generic.oxygen_bonus";
    public static final String GENERIC_SAFE_FALL_DISTANCE = "generic.safe_fall_distance";
    public static final String GENERIC_SCALE = "generic.scale";
    public static final String GENERIC_STEP_HEIGHT = "generic.step_height";
    public static final String GENERIC_WATER_MOVEMENT_EFFICIENCY = "generic.water_movement_efficiency";
    public static final String PLAYER_BLOCK_BREAK_SPEED = "player.block_break_speed";
    public static final String PLAYER_MINING_EFFICIENCY = "player.mining_efficiency";
    public static final String PLAYER_SNEAKING_SPEED = "player.sneaking_speed";
    public static final String PLAYER_SUBMERGED_MINING_SPEED = "player.submerged_mining_speed";
    public static final String PLAYER_SWEEPING_DAMAGE_RATIO = "player.sweeping_damage_ratio";
    public static final String PLAYER_BLOCK_INTERACTION_RANGE = "player.block_interaction_range";



    public static class Modifier { Modifier() { }
        public String id = "";
        public float value = 0;
        public EntityAttributeModifier.Operation operation = EntityAttributeModifier.Operation.ADD_VALUE;

        public Modifier(Identifier id, float value, EntityAttributeModifier.Operation operation) {
            this(id.toString(), value, operation);
        }

        public Modifier(String id, float value, EntityAttributeModifier.Operation operation) {
            this.id = id;
            this.value = value;
            this.operation = operation;
        }
    }

    public static class Lister { public Lister() { }
        public Map<String, Lister> StringLister = new HashMap<>();
        public List<Modifier> Attributes = List.of();
        public Lister(List<Modifier> attributes) {
            this.Attributes = attributes;
        }
    }
}
