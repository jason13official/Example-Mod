package com.example.examplemod.core.registry;

import com.example.examplemod.Constants;
import com.example.examplemod.PlatformHelper;
import com.mojang.datafixers.kinds.Const;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ModTabs {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Constants.MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final Registrar<CreativeModeTab> TAB_REGISTRAR = TABS.getRegistrar();

    public static final RegistrySupplier<CreativeModeTab> TAB = register(TABS, TAB_REGISTRAR, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, Constants.MOD_ID), () -> PlatformHelper.constructTabBuilder()
            .icon(() -> new ItemStack(ModItems.NEW_TORCH.get()))
            .title(Component.literal(Constants.MOD_NAME))
            .displayItems((itemDisplayParameters, output) -> output.accept(ModItems.NEW_TORCH.get()))
            .build());

    public static <T extends CreativeModeTab> RegistrySupplier<T> register(DeferredRegister<CreativeModeTab> register, Registrar<CreativeModeTab> registrar, ResourceLocation path, Supplier<T> block) {
        // return Platform.isForgeLike() ? register.register(path.getPath(), block) : registrar.register(path, block);
        return registrar.register(path, block);
    }

    public static void init() {}
}
