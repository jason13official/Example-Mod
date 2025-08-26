package com.example.examplemod.core.registry;

import com.example.examplemod.Constants;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Constants.MOD_ID, Registries.ITEM);
    public static final Registrar<Item> ITEM_REGISTRAR = ITEMS.getRegistrar();

    public static final RegistrySupplier<Item> NEW_TORCH = register(ITEMS, ITEM_REGISTRAR, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "new_torch"), () -> new StandingAndWallBlockItem(ModBlocks.NEW_TORCH.get(), ModBlocks.NEW_WALL_TORCH.get(), new Item.Properties(), Direction.DOWN));

    public static <T extends Item> RegistrySupplier<T> register(DeferredRegister<Item> register, Registrar<Item> registrar, ResourceLocation path, Supplier<T> block) {
        // return Platform.isForgeLike() ? register.register(path.getPath(), block) : registrar.register(path, block);
        return registrar.register(path, block);
    }

    public static void init() {}
}
