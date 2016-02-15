package com.example.examplemod;

import net.minecraft.item.ItemSword;

/**
 * Created by uchikimi on 2015/08/28.
 */

public class Normal_Sword extends ItemSword {
    public Normal_Sword() {
        super(ToolMaterial.EMERALD);
        setUnlocalizedName(ExampleMod.MODID + "_normal_sword");
        setTextureName(ExampleMod.MODID + ":normal_sword");
    }
}
