package com.example.examplemod.neoforge;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PlatformHelperImpl {

    public static Block constructTorch(SimpleParticleType particle, BlockBehaviour.Properties properties) {
        return new TorchBlock(particle, properties);
    }

    public static Block constructWallTorch(SimpleParticleType particle, BlockBehaviour.Properties properties) {
        return new WallTorchBlock(particle, properties);
    }

    public static CreativeModeTab.Builder constructTabBuilder() {
        return CreativeModeTab.builder();
    }
}
