package com.example.examplemod.core.registry;

import com.example.examplemod.Constants;
import com.example.examplemod.platform.Services;
import net.darkhax.bookshelf.common.api.function.CachedSupplier;
import net.darkhax.bookshelf.common.api.registry.IContentProvider;
import net.darkhax.bookshelf.common.api.registry.register.Register;
import net.darkhax.bookshelf.common.api.registry.register.RegisterItem;
import net.darkhax.bookshelf.common.api.registry.register.RegisterItemTab;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class ModContent implements IContentProvider {

    private static final ResourceLocation TORCH_RL = identifier("new_torch");
    private static final ResourceLocation WALL_TORCH_RL = identifier("new_wall_torch");

    public static final Supplier<ItemStack> TAB_ICON = CachedSupplier.cache(() -> BuiltInRegistries.ITEM.get(identifier("new_torch")).getDefaultInstance());

    public static final Block torch = Services.PLATFORM.constructTorch(ParticleTypes.FLAME, BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel((p_50886_) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY));
    public static final Block wallTorch = Services.PLATFORM.constructWallTorch(ParticleTypes.FLAME, BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel((p_152607_) -> 14).sound(SoundType.WOOD).dropsLike(torch).pushReaction(PushReaction.DESTROY));

    @Override
    public void registerBlocks(Register<Block> registry) {

        registry.add(TORCH_RL, torch);

        registry.add(WALL_TORCH_RL, wallTorch);
    }

    @Override
    public void registerItems(RegisterItem registry) {

        registry.add("new_torch", new StandingAndWallBlockItem(torch, wallTorch, new Item.Properties(), Direction.DOWN));
    }

    @Override
    public void registerItemTabs(RegisterItemTab registry) {
        registry.add(Constants.MOD_ID, TAB_ICON, (parameters, output) -> output.accept(torch));
    }

    @Override
    public String contentNamespace() {
        return Constants.MOD_ID;
    }

    public static ResourceLocation identifier(String path) {
        return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path);
    }
}
