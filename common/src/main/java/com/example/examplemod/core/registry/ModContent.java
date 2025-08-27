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

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModContent implements IContentProvider {

    private static final ResourceLocation TORCH_RL = identifier("new_torch");
    private static final ResourceLocation WALL_TORCH_RL = identifier("new_wall_torch");

    public static final Supplier<ItemStack> TAB_ICON = CachedSupplier.cache(() -> BuiltInRegistries.ITEM.get(identifier("new_torch")).getDefaultInstance());

    private final Map<ResourceLocation, Block> allTorchesOrdered = new LinkedHashMap<>();

    @Override
    public void registerBlocks(Register<Block> registry) {

        BlockBehaviour.Properties torchProperties = BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel((p_50886_) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY);

        Block torch = Services.PLATFORM.constructTorch(ParticleTypes.FLAME, torchProperties);
        registry.add(TORCH_RL, torch);
        allTorchesOrdered.put(TORCH_RL, torch);

        BlockBehaviour.Properties wallTorchProperties = BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel((p_152607_) -> 14).sound(SoundType.WOOD).dropsLike(torch).pushReaction(PushReaction.DESTROY);

        Block wallTorch = Services.PLATFORM.constructWallTorch(ParticleTypes.FLAME, wallTorchProperties);
        registry.add(WALL_TORCH_RL, wallTorch);
        allTorchesOrdered.put(WALL_TORCH_RL, wallTorch);
    }

    @Override
    public void registerItems(RegisterItem registry) {
        Iterator<Map.Entry<ResourceLocation, Block>> it = allTorchesOrdered.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<ResourceLocation, Block> block = it.next();
            Map.Entry<ResourceLocation, Block> wallBlock = it.next();
            registry.add(block.getKey().getPath(), new StandingAndWallBlockItem(block.getValue(), wallBlock.getValue(), new Item.Properties(), Direction.DOWN));
        }
    }

    @Override
    public void registerItemTabs(RegisterItemTab registry) {
        registry.add(Constants.MOD_ID, TAB_ICON, (parameters, output) -> output.accept(allTorchesOrdered.get(TORCH_RL)));
    }

    @Override
    public String contentNamespace() {
        return Constants.MOD_ID;
    }

    public static ResourceLocation identifier(String path) {
        return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path);
    }
}
