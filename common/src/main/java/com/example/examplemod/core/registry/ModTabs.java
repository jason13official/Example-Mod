package com.example.examplemod.core.registry;

import com.example.examplemod.Constants;
import com.example.examplemod.platform.Services;
import com.example.examplemod.registration.RegistrationProvider;
import com.example.examplemod.registration.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {

    public static final RegistrationProvider<CreativeModeTab> TABS = RegistrationProvider.get(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    /**
     * Mod loaders prefer to construct creative mode tabs in different ways, so we retrieve the preferred
     * CreativeModeTab.Builder from the mod-loader projects.
     */
    public static final RegistryObject<CreativeModeTab, CreativeModeTab> TAB = TABS.register(Constants.MOD_ID, () -> Services.PLATFORM.constructTabBuilder()
            .icon(() -> new ItemStack(ModItems.NEW_TORCH.get()))
            .title(Component.literal("Example Mod Tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.NEW_TORCH.get());
            })
            .build());

    public static void init() {}
}
