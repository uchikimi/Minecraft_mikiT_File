package com.example.examplemod;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    public static final RainbowAllen happybirthdayallen = new RainbowAllen();
    public static final Block E_A_to_G = new E_A_to_G();
    public static final Block E_H_to_N = new E_H_to_N();
    public static final Block E_O_to_U = new E_O_to_U();
    public static final Block E_V_to_Z = new E_V_to_Z();
    public static final Block E_etc = new E_etc();
    public static final Block J_agyou = new J_agyou();
    public static final Block J_kagyou = new J_kagyou();
    public static final Block J_sagyou = new J_sagyou();
    public static final Block J_tagyou = new J_tagyou();
    public static final Block J_nagyou = new J_nagyou();
    public static final Block J_hagyou = new J_hagyou();
    public static final Block J_magyou = new J_magyou();
    public static final Block J_yagyou = new J_yagyou();
    public static final Block J_ragyou = new J_ragyou();
    public static final Block J_wagyou = new J_wagyou();
    public static final Block J_etc = new J_etc();
    public static final Block SoundBlock = new BlockSound();
    public static final Block myblock2 = new MyBlock_2();
    private BlockLogicAnd blockLogicAnd;
    private ItemHerbicide ItemHerbicide;

    @EventHandler
    public void init(FMLInitializationEvent event) {
//        customBlock();//既存ブロックの改造
//        myrecipe();//マイレシピ
//        setELiteeral();//英字ブロック
//        setJLiteral();//日本語ブロック
//        tipes();//チップスのMOD
        original();//オリジナルMOD
//        textMod();//教科書のMOD
//        customSword();//myItem
//        whitechicken();
//        worldmod();
    }
    public void customBlock(){
        //既存ブロックの設定変更
        Blocks.water.setLightLevel(1.0f);  //水彩度
        //Blocks.dirt.setResistance(10.0f);  //土耐爆性
       // Blocks.dirt.setHardness(100.0f);  //土硬さ
        Blocks.red_flower.setLightLevel(1.0f);  //赤い花彩度
    }  //既存ブロックの改造
    public void customSword() {
        Item sword = new MyItem();
        GameRegistry.registerItem(sword, "my_sword");
        GameRegistry.addRecipe(new ItemStack(sword, 1, 50),
                " B ",
                "BAB",
                " B ",
                'A', new ItemStack(Items.diamond_sword),
                'B', Items.gunpowder);
    }  //マイアイテムの剣
    public void textMod(){
        GameRegistry.registerBlock(new BlockSound(), "blocksound");
        GameRegistry.registerBlock(new BlockRedStoneInput(), "redstone_input");
        GameRegistry.registerBlock(new RedStoneClock(), "redstone_clock");
        GameRegistry.registerBlock(new FootprintsSand(), "footprintssand");  //砂ブロック
        GameRegistry.registerItem(new ItemMySnowball(), "snow_ball");  //雪合戦
        MinecraftForge.EVENT_BUS.register(new BlockBreakEventHandler());  //木こり
    }//教科書のMOD
    public void myrecipe(){
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 50),  //土からスパンエッグ
                "   ",
                " AA",
                "   ",
                'A', new ItemStack(Blocks.dirt, 1, 4));
        GameRegistry.addRecipe(new ItemStack(Blocks.diamond_block),  //土からダイアモンド
                "   ",
                " A ",
                "   ",
                'A', new ItemStack(Items.dye, 1, 3));
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 50),  //土からスパンエッグ
                "   ",
                "AA ",
                "   ",
                'A', Blocks.dirt);
        GameRegistry.addRecipe(new ItemStack(ExampleMod.myblock2),
                "AAA",
                "AAA",
                "CCC",
                'A', new ItemStack(Blocks.diamond_block),
                'C', Blocks.dirt);
    }//マイレシピ
    public void tipes(){
        GameRegistry.registerItem(new ItemLightningSword(), "lightning_sword");    //ライトニングソード
        GameRegistry.registerItem(new Normal_Sword(), "normal_sword");  //オリジナル剣
        GameRegistry.registerItem(new ItemTNTRod(), "tnt_rod");  //tntロッド（いきなり爆発）
        FMLCommonHandler.instance().bus().register(new TickHandler());  //ポーション加速
        MinecraftForge.EVENT_BUS.register(new BouncyTnts());    //ジャンプ
        blockLogicAnd = new BlockLogicAnd();  //NAND回路
        GameRegistry.registerBlock(blockLogicAnd, "logic_and");
        ItemHerbicide = new ItemHerbicide();
        GameRegistry.registerItem(ItemHerbicide, "herbicide");
        //GameRegistry.registerItem(new ItemHerbicide(), "herbicide");
    }//チップスのMOD
    public void setJLiteral(){
        GameRegistry.registerBlock(J_agyou, "MinecraftLiteralA");
        GameRegistry.registerBlock(J_kagyou, "MinecraftLiteralKA");
        GameRegistry.registerBlock(J_sagyou, "MinecraftLiteralSA");
        GameRegistry.registerBlock(J_tagyou, "MinecraftLiteralTA");
        GameRegistry.registerBlock(J_nagyou, "MinecraftLiteralNA");
        GameRegistry.registerBlock(J_hagyou, "MinecraftLiteralHA");
        GameRegistry.registerBlock(J_magyou, "MinecraftLiteralMA");
        GameRegistry.registerBlock(J_yagyou, "MinecraftLiteralYA");
        GameRegistry.registerBlock(J_ragyou, "MinecraftLiteralRA");
        GameRegistry.registerBlock(J_wagyou, "MinecraftLiteralWA");
        GameRegistry.registerBlock(J_etc, "MinecraftLiteraftetc");
    }  //日本語ブロック
    public void setELiteeral(){
        GameRegistry.registerBlock(E_A_to_G, "MinecraftEnglish1");
        GameRegistry.registerBlock(E_H_to_N, "MinecraftEnglish2");
        GameRegistry.registerBlock(E_O_to_U, "MinecraftEnglish3");
        GameRegistry.registerBlock(E_V_to_Z, "MinecraftEnglish4");
        GameRegistry.registerBlock(E_etc, "MinecraftEnglish5");
    }  //英字ブロック
    public void original(){
        GameRegistry.registerBlock(new MyBlock(), "myblock_1");  //マイレシピ
        //GameRegistry.registerBlock(new MyBlock_2(), "myblock_2");  //マイレシピ

        GameRegistry.registerBlock(new MyBlock_3(), "myblock_3");  //マイレシピ
        GameRegistry.registerBlock(new Blocka(), "Blocka");
        GameRegistry.registerBlock(happybirthdayallen, "RainbowAllen");
        GameRegistry.registerBlock(new MyBlockTest1(),"myblocktest1");
        GameRegistry.registerItem(new ItemMyExplodeball(), "explodeball");

    }//オリジナルMOD
    public void whitechicken(){
        PotionEffect[] whitechicken = {
                new PotionEffect(Potion.heal.id,1200,0)
        };
        GameRegistry.registerItem(new AllenModWhiteChicken("whitechicken",10,2.0f,false,whitechicken).setAlwaysEdible(),"whitechicken");
    }
    public void worldmod(){
        GameRegistry.registerBlock(myblock2, "MyBlock2");
        GameRegistry.registerWorldGenerator(new MyWorldGenerator(myblock2, 100), 1);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(new BiomeGenMyBiome(40), 100));
//        BiomeManager.addBiome(BiomeManager.BiomeType.ICY,new BiomeManager.BiomeEntry(new BiomeGenIceberg(41),30));
    }
}
/*
        System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
*/