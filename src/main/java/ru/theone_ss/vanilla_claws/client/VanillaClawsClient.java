package ru.theone_ss.vanilla_claws.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import ru.theone_ss.vanilla_claws.item.ClawsItem;
import ru.theone_ss.vanilla_claws.registry.VanillaClawsItems;

public class VanillaClawsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        VanillaClawsItems.ITEMS.forEach((identifier, item) -> {
            if (item instanceof ClawsItem) TwoModelsItemRegistry.register(item);
        });

        ModelLoadingPlugin.register(pluginContext -> TwoModelsItemRegistry.ENTRIES.forEach((identifier, item) ->
                pluginContext.addModels(new ModelIdentifier(Identifier.of(identifier + "_in_hand"), ModelIdentifier.INVENTORY_VARIANT).id())));
    }
 }

