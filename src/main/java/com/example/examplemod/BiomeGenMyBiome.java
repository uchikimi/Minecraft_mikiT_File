package com.example.examplemod;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.biome.BiomeGenPlains;

/**
 * Created by uchikimi on 16/02/24.
 */
public class BiomeGenMyBiome extends BiomeGenPlains {
    public BiomeGenMyBiome(int biome_id){
        super(biome_id);
        setBiomeName("my_biome");
        this.temperature=1F;
        this.rainfall=1F;

        this.rootHeight=-0.25F;
        this.heightVariation=0.4F;

        this.spawnableCaveCreatureList.add(new BiomeGenMyBiome.SpawnListEntry(EntityVillager.class,30,5,5));
    }
}
