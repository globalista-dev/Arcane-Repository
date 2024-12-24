package com.globalista.arcrepo.content;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.List;

public class UpgradeItem extends Item {

    private String name;

    public UpgradeItem(String name) {
        super(new Settings().rarity(Rarity.UNCOMMON));
        this.name = name;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(itemStack, context, tooltip, type);
        tooltip.add(Text.translatable("item.arcrepo.template.tooltip").formatted(Formatting.GRAY));
        tooltip.add(Text.of(""));
        tooltip.add(Text.translatable("item.arcrepo.template.tooltip1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.arcrepo."  + name + ".tooltip").formatted(Formatting.BLUE));
        tooltip.add(Text.translatable("item.arcrepo.template.tooltip2").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.arcrepo.template.tooltip3").formatted(Formatting.BLUE));

    }

}
