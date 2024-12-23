package com.globalista.arcrepo.content;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;

public class Gem {

    public static void initialize(){}

    public String name;
    public String attribute;
    public float modifier;
    public EntityAttributeModifier.Operation operation;
    public Item item;

    public String cursedAttribute;
    public float cursedModifier;
    public EntityAttributeModifier.Operation cursedOperation;



    public Gem(String name, String attribute, float modifier, EntityAttributeModifier.Operation operation, String cursedAttribute, float cursedModifier, EntityAttributeModifier.Operation cursedOperation, Item item) {
        this.name = name;
        this.attribute = attribute;
        this.modifier = modifier;
        this.operation = operation;
        this.cursedAttribute = cursedAttribute;
        this.cursedModifier = cursedModifier;
        this.cursedOperation = cursedOperation;
        this.item = item;
    }

    public EntityAttributeModifier.Operation getOperation() {
        return operation;
    }

    public float getModifier() {
        return modifier;
    }

    public String getName() {
        return name;
    }

    public Item getItem() {
        return item;
    }

    public String getAttribute() {
        return attribute;
    }

    public float getCursedModifier() {
        return cursedModifier;
    }

    public String getCursedAttribute() {
        return cursedAttribute;
    }

    public EntityAttributeModifier.Operation getCursedOperation() {
        return cursedOperation;
    }
}
