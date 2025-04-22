package ru.theone_ss.vanilla_claws.item;

import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import ru.theone_ss.vanilla_claws.VanillaClaws;

import java.util.List;

public class ClawsItem extends ToolItem {

    public ClawsItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings.component(DataComponentTypes.TOOL, createToolComponent()));
    }

    private static ToolComponent createToolComponent() {
        return new ToolComponent(
                List.of(
                        ToolComponent.Rule.ofAlwaysDropping(List.of(Blocks.COBWEB), 22.0F),
                        ToolComponent.Rule.ofAlwaysDropping(TagKey.of(RegistryKeys.BLOCK, Identifier.of(VanillaClaws.MOD_ID, "mineable/claws")), 2.0F),
                        ToolComponent.Rule.of(BlockTags.LEAVES, 15.0F),
                        ToolComponent.Rule.of(BlockTags.WOOL, 8.0F),
                        ToolComponent.Rule.of(List.of(Blocks.VINE, Blocks.GLOW_LICHEN), 2.0F)
                ),
                1.0F,
                1);
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
                .add(
                        EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                        new EntityAttributeModifier(Identifier.of("player.entity_interaction_range"), -0.75, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .build();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        return Items.DIAMOND_HOE.useOnBlock(context);
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
    }
}
