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

    WOOD(79, 2.0F, 2.0F, 1, () -> Ingredient.fromTag(ItemTags.PLANKS)),
    STONE(161, 2.0F, 4.0F, 1, () -> Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS)),
    COPPER(231, 2.0F, 2.0F, 1, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    IRON(320, 2.0F, 6.0F, 1, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    DIAMOND(761, 2.0F, 8.0F, 1, () -> Ingredient.ofItems(Items.DIAMOND)),
    GOLD(72, 12.0F, 12.0F, 26, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    NETHERITE(1131, 2.0F, 9.0F, 1, () -> Ingredient.ofItems(Items.NETHERITE_INGOT));

    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    VanillaClawsMaterials(int durability, float miningSpeed, float damage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.itemDurability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = damage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
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
