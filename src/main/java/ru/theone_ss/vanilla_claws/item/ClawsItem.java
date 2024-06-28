package ru.theone_ss.vanilla_claws.item;

import com.google.common.collect.ImmutableMultimap;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.ActionResult;

import java.util.List;

public class ClawsItem extends SwordItem {
    //private final float attackDamage;

    public ClawsItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings.component(DataComponentTypes.TOOL, createToolComponent()));
        //this.attackDamage = damage + material.getAttackDamage();
/*
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, this.attackDamage, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE));
        builder.put(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(-0.75, EntityAttributeModifier.Operation.ADD_VALUE));*/
    }

    private static ToolComponent createToolComponent() {
        return new ToolComponent(
                List.of(
                        ToolComponent.Rule.ofAlwaysDropping(List.of(Blocks.COBWEB), 15.0F),
                        ToolComponent.Rule.of(BlockTags.LEAVES, 15.0F),
                        ToolComponent.Rule.of(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2);
    }

    public static AttributeModifiersComponent createAttributeModifiers(int baseAttackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        new EntityAttributeModifier(
                                BASE_ATTACK_DAMAGE_MODIFIER_ID, (float)baseAttackDamage, EntityAttributeModifier.Operation.ADD_VALUE
                        ),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_SPEED,
                        new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
/*                .add(
                        EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                        new EntityAttributeModifier(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, interactRange, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )*/
                .build();
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        return Items.DIAMOND_HOE.useOnBlock(context);
    }
}
