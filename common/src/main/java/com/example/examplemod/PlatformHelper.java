package com.example.examplemod;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PlatformHelper {

    @ExpectPlatform
    public static Block constructTorch(SimpleParticleType particle, BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Block constructWallTorch(SimpleParticleType particle, BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static CreativeModeTab.Builder constructTabBuilder() {
        throw new AssertionError();
    }
}
