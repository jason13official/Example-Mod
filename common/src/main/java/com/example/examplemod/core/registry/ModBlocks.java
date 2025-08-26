package com.example.examplemod.core.registry;

import com.example.examplemod.Constants;
import com.example.examplemod.PlatformHelper;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Constants.MOD_ID, Registries.BLOCK);
    public static final Registrar<Block> BLOCK_REGISTRAR = BLOCKS.getRegistrar();

    public static final RegistrySupplier<Block> NEW_TORCH = register(BLOCKS, BLOCK_REGISTRAR, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "new_torch"),
            () -> PlatformHelper.constructTorch(ParticleTypes.FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH))
    );

    public static final RegistrySupplier<Block> NEW_WALL_TORCH = register(BLOCKS, BLOCK_REGISTRAR, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "new_wall_torch"),
            () -> PlatformHelper.constructWallTorch(ParticleTypes.FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).dropsLike(NEW_TORCH.get()))
    );

    public static <T extends Block> RegistrySupplier<T> register(DeferredRegister<Block> register, Registrar<Block> registrar, ResourceLocation path, Supplier<T> block) {
        // return Platform.isForgeLike() ? register.register(path.getPath(), block) : registrar.register(path, block);
        return registrar.register(path, block);
    }

    public static void init() {}
}
