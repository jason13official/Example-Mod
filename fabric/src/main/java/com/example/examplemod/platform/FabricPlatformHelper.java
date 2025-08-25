package com.example.examplemod.platform;

import com.example.examplemod.platform.services.IPlatformHelper;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public Block constructTorch(SimpleParticleType particle, BlockBehaviour.Properties properties) {
        return new TorchBlock(particle, properties);
    }

    @Override
    public Block constructWallTorch(SimpleParticleType particle, BlockBehaviour.Properties properties) {
        return new WallTorchBlock(particle, properties);
    }

    @Override
    public CreativeModeTab.Builder constructTabBuilder() {
        return FabricItemGroup.builder();
    }
}
