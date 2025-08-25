package com.example.examplemod.platform;

import com.example.examplemod.platform.services.IPlatformHelper;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
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
        return CreativeModeTab.builder().withTabsBefore(CreativeModeTabs.SPAWN_EGGS);
    }
}