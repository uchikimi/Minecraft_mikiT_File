package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by uchikimi on 16/02/25.
 */
public class BiomeGenIceberg extends BiomeGenBase {
    public BiomeGenIceberg(int biome_id){
        super(biome_id);
        setBiomeName("iceberg");
        this.topBlock= Blocks.ice;
        this.fillerBlock=Blocks.packed_ice;
        this.temperature=0F;
        this.rainfall=1F;
        this.heightVariation=0.75F;
        setEnableSnow();
    }
}
