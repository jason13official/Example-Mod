package com.example.examplemod.neoforge;

import com.example.examplemod.Constants;
import net.neoforged.fml.common.Mod;

import com.example.examplemod.CommonClass;

@Mod(Constants.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        CommonClass.init();
    }
}
