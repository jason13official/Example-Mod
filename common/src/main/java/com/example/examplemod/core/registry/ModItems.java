package com.example.examplemod.core.registry;

import com.example.examplemod.Constants;
import com.example.examplemod.registration.RegistrationProvider;
import com.example.examplemod.registration.RegistryObject;
import com.example.examplemod.registration.specialised.ItemRegistrationProvider;
import com.example.examplemod.registration.specialised.ItemRegistryObject;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

/**
 * Using {@link ItemRegistrationProvider} fails in some cases. Specifically in our demonstration: using
 * {@link ItemRegistrationProvider#register(String, Supplier)} to register an instance of {@link StandingAndWallBlockItem}
 * throws `java.lang.NullPointerException: Trying to access unbound value: ResourceKey[minecraft:item / examplemod:new_torch]`
 * when attempting to construct our CreativeModeTab instance. To see this in action, swap the commented code, and attempt
 * to open the creative inventory.
 */
public class ModItems {

//    public static final ItemRegistrationProvider ITEMS = ItemRegistrationProvider.get(Constants.MOD_ID);
//
//    public static final ItemRegistryObject<StandingAndWallBlockItem> NEW_TORCH = ITEMS.register("new_torch", () ->
//            new StandingAndWallBlockItem(ModBlocks.NEW_TORCH.get(), ModBlocks.NEW_WALL_TORCH.get(), new Item.Properties(), Direction.DOWN)
//    );

    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MOD_ID);

    /**
     * Demonstration of using other registered objects.
     */
    public static final RegistryObject<Item, StandingAndWallBlockItem> NEW_TORCH = ITEMS.register("new_torch", () ->
            new StandingAndWallBlockItem(ModBlocks.NEW_TORCH.get(), ModBlocks.NEW_WALL_TORCH.get(), new Item.Properties(), Direction.DOWN)
    );

    public static void init() {}
}
