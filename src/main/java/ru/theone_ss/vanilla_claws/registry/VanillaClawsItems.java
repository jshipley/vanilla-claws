package ru.theone_ss.vanilla_claws.registry;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import ru.theone_ss.vanilla_claws.VanillaClaws;
import ru.theone_ss.vanilla_claws.compat.WinterlyIntegration;
import ru.theone_ss.vanilla_claws.item.ClawsItem;
import ru.theone_ss.vanilla_claws.item.CryomarbleClawsItem;
import ru.theone_ss.vanilla_claws.item.material.VanillaClawsMaterials;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class VanillaClawsItems {
    public static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item NETHERITE_CLAWS = add("netherite_claws", new ClawsItem(VanillaClawsMaterials.NETHERITE, new Item.Settings().attributeModifiers(ClawsItem.createAttributeModifiers(6, 2))));
    public static final Item DIAMOND_CLAWS = add("diamond_claws", new ClawsItem(VanillaClawsMaterials.DIAMOND, new Item.Settings().attributeModifiers(ClawsItem.createAttributeModifiers(5, 2))));
    public static final Item IRON_CLAWS = add("iron_claws", new ClawsItem(VanillaClawsMaterials.IRON, new Item.Settings().attributeModifiers(ClawsItem.createAttributeModifiers(4, 2))));
    public static final Item GOLDEN_CLAWS = add("golden_claws", new ClawsItem(VanillaClawsMaterials.GOLD, new Item.Settings().attributeModifiers(ClawsItem.createAttributeModifiers(4, 2))));
    public static final Item COPPER_CLAWS = add("copper_claws", new ClawsItem(VanillaClawsMaterials.COPPER, new Item.Settings().attributeModifiers(ClawsItem.createAttributeModifiers(3, 2))));
    public static final Item STONE_CLAWS = add("stone_claws", new ClawsItem(VanillaClawsMaterials.STONE, new Item.Settings().attributeModifiers(ClawsItem.createAttributeModifiers(3, 2))));
    public static final Item WOODEN_CLAWS = add("wooden_claws", new ClawsItem(VanillaClawsMaterials.WOOD, new Item.Settings().attributeModifiers(ClawsItem.createAttributeModifiers(2, 2))));

    public static final Item CRYOMARBLE_CLAWS = add("cryomarble_claws", new CryomarbleClawsItem(material("winterly"), new Item.Settings().attributeModifiers(ClawsItem.createAttributeModifiers(5, 2))));

    private static ToolMaterial material(String modId) {
        if(FabricLoader.getInstance().isModLoaded(modId)) {
            if(modId.equals("winterly")) {
                return WinterlyIntegration.getMaterial();
            }
        }
        return VanillaClawsMaterials.IRON;
    }

    private static Item add(String name, Item item) {
        ITEMS.put(VanillaClaws.id(name), item);
        return item;
    }

    public static void init() {
        ITEMS.forEach((id, item) -> Registry.register(Registries.ITEM,id, item));
    }

}
