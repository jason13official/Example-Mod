package com.example.examplemod.core.registry;

import com.example.examplemod.Constants;
import com.example.examplemod.platform.Services;
import com.example.examplemod.registration.RegistrationProvider;
import com.example.examplemod.registration.RegistryObject;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {

    public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(Registries.BLOCK, Constants.MOD_ID);

    /**
     * TorchBlock and WallTorchBlock have `protected` access in Minecraft's vanilla code.
     * Rather than use an Access Transformer to widen the access to `public`, we
     * construct the Torch via a service to create the torch blocks in a mod-loader allowed fashion.
     */
    public static final RegistryObject<Block, TorchBlock> NEW_TORCH = BLOCKS.<TorchBlock>register("new_torch", () ->
            Services.PLATFORM.constructTorch(ParticleTypes.FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH))
    );

    public static final RegistryObject<Block, WallTorchBlock> NEW_WALL_TORCH = BLOCKS.<WallTorchBlock>register("new_wall_torch", () ->
            Services.PLATFORM.constructWallTorch(ParticleTypes.FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).dropsLike(NEW_TORCH.get()))
    );

    public static void init() {}
}
