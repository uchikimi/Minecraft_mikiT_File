package com.example.examplemod;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created by uchikimi on 16/02/24.
 */
public class MyWorldGenerator implements IWorldGenerator {
    private Block generate_block;
    private int chance;

    public MyWorldGenerator(Block block, int chance_to_spawn) {
        this.generate_block = block;
        this.chance = chance_to_spawn;
    }

    @Override
    public void generate(Random random, int chunk_x, int chunk_z, World world, IChunkProvider chunk_generator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId == 0) {
            this.generateSurface(world,random,chunk_x*16,chunk_z*16);
        }
    }
    private void generateSurface(World world,Random random,int x,int z){
        this.addOreSpawn(world,random,x,z,4+random.nextInt(3),1,50);
    }
    private void addOreSpawn(World world,Random random,int x,int z,int max,int min_y,int max_y){
        int width = max_y-min_y;
        for(int i=0;i<this.chance;i++){
            int center_x=x+random.nextInt(16);
            int center_y=min_y+random.nextInt(width);
            int center_z=z+random.nextInt(16);
            new WorldGenMinable(this.generate_block,max).generate(world,random,center_x,center_y,center_z);
        }
    }
}
