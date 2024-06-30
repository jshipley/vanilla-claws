package ru.theone_ss.vanilla_claws.item.material;

import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public enum VanillaClawsMaterials implements ToolMaterial {

    WOOD(79, 10, () -> Ingredient.fromTag(ItemTags.PLANKS)),
    STONE(161, 11, () -> Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS)),
    COPPER(245, 11, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    IRON(344, 15, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    DIAMOND(801, 18, () -> Ingredient.ofItems(Items.DIAMOND)),
    GOLD(77, 26, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    NETHERITE(1331, 24, () -> Ingredient.ofItems(Items.NETHERITE_INGOT));

    private final int itemDurability;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    VanillaClawsMaterials(int durability, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.itemDurability = durability;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return null;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

}
