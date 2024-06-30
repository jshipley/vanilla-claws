package ru.theone_ss.vanilla_claws.item;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Language;

import java.util.List;

public class IntegratedClawsItem extends ClawsItem {
    public String requiredMod;
    public boolean isRequiredModInstalled;

    public IntegratedClawsItem(String requiredMod, ToolMaterial material, Settings settings) {
        super(material, settings);
        this.requiredMod = requiredMod;
        this.isRequiredModInstalled = FabricLoader.getInstance().isModLoaded(requiredMod);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        if(!isRequiredModInstalled) {
            String text = Language.getInstance().get("tooltip.vanilla_claws.requires_mod");
            text = text.replaceAll("%", requiredMod.substring(0, 1).toUpperCase() + requiredMod.substring(1));
            tooltip.add(Text.of(text).copy().formatted(Formatting.GRAY));
        }
    }

}
