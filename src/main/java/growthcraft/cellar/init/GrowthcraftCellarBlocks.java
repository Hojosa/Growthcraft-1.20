package growthcraft.cellar.init;

import java.util.function.Supplier;

import growthcraft.cellar.block.BrewKettleBlock;
import growthcraft.cellar.block.CorkCoasterBlock;
import growthcraft.cellar.block.CorkLog;
import growthcraft.cellar.block.CultureJarBlock;
import growthcraft.cellar.block.FermentationBarrelBlock;
import growthcraft.cellar.block.FruitPressBlock;
import growthcraft.cellar.block.FruitPressPistonBlock;
import growthcraft.cellar.block.GrapeVineCropBlock;
import growthcraft.cellar.block.GrapeVineFruitBlock;
import growthcraft.cellar.block.GrapeVineLeavesCropBlock;
import growthcraft.cellar.block.HopsCropBlock;
import growthcraft.cellar.block.RoasterBlock;
import growthcraft.cellar.shared.Reference;
import growthcraft.cellar.world.feature.tree.CorkTreeGrower;
import growthcraft.lib.block.GrowthcraftLogBlock;
import growthcraft.lib.block.GrowthcraftSaplingBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GrowthcraftCellarBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
            ForgeRegistries.BLOCKS, Reference.MODID
    );

    public static final RegistryObject<Block> BREW_KETTLE = registerBlock(
            Reference.UnlocalizedName.BREW_KETTLE,
            BrewKettleBlock::new
    );

    public static final RegistryObject<Block> CULTURE_JAR = registerBlock(
            Reference.UnlocalizedName.CULTURE_JAR,
            CultureJarBlock::new
    );

    public static final RegistryObject<Block> FERMENTATION_BARREL_OAK = registerBlock(
            Reference.UnlocalizedName.FERMENT_BARREL_OAK,
            FermentationBarrelBlock::new
    );

    public static final RegistryObject<Block> FRUIT_PRESS = registerBlock(
            Reference.UnlocalizedName.FRUIT_PRESS,
            FruitPressBlock::new
    );

    public static final RegistryObject<Block> FRUIT_PRESS_PISTON = registerBlock(
            Reference.UnlocalizedName.FRUIT_PRESS_PISTON,
            FruitPressPistonBlock::new,
            true
    );

    public static final RegistryObject<Block> ROASTER = registerBlock(
            Reference.UnlocalizedName.ROASTER,
            RoasterBlock::new
    );

    // TODO: FRUIT_PRESS_PISTON

    public static final RegistryObject<Block> RED_GRAPE_VINE_FRUIT = registerBlock(
            Reference.UnlocalizedName.RED_GRAPE_VINE_FRUIT,
            GrapeVineFruitBlock::new, true
    );
    public static final RegistryObject<Block> RED_GRAPE_VINE_LEAVES = registerBlock(
            Reference.UnlocalizedName.RED_GRAPE_VINE_LEAVES,
            () -> new GrapeVineLeavesCropBlock((GrapeVineFruitBlock) RED_GRAPE_VINE_FRUIT.get()), true
    );
    public static final RegistryObject<Block> RED_GRAPE_VINE = registerBlock(
            Reference.UnlocalizedName.RED_GRAPE_VINE,
            () -> new GrapeVineCropBlock((GrapeVineLeavesCropBlock) RED_GRAPE_VINE_LEAVES.get()), true
    );

    public static final RegistryObject<Block> PURPLE_GRAPE_VINE_FRUIT = registerBlock(
            Reference.UnlocalizedName.PURPLE_GRAPE_VINE_FRUIT,
            GrapeVineFruitBlock::new, true
    );
    public static final RegistryObject<Block> PURPLE_GRAPE_VINE_LEAVES = registerBlock(
            Reference.UnlocalizedName.PURPLE_GRAPE_VINE_LEAVES,
            () -> new GrapeVineLeavesCropBlock((GrapeVineFruitBlock) PURPLE_GRAPE_VINE_FRUIT.get()), true
    );
    public static final RegistryObject<Block> PURPLE_GRAPE_VINE = registerBlock(
            Reference.UnlocalizedName.PURPLE_GRAPE_VINE,
            () -> new GrapeVineCropBlock((GrapeVineLeavesCropBlock) PURPLE_GRAPE_VINE_LEAVES.get()), true
    );

    public static final RegistryObject<Block> WHITE_GRAPE_VINE_FRUIT = registerBlock(
            Reference.UnlocalizedName.WHITE_GRAPE_VINE_FRUIT,
            GrapeVineFruitBlock::new, true
    );
    public static final RegistryObject<Block> WHITE_GRAPE_VINE_LEAVES = registerBlock(
            Reference.UnlocalizedName.WHITE_GRAPE_VINE_LEAVES,
            () -> new GrapeVineLeavesCropBlock((GrapeVineFruitBlock) WHITE_GRAPE_VINE_FRUIT.get()), true
    );
    public static final RegistryObject<Block> WHITE_GRAPE_VINE = registerBlock(
            Reference.UnlocalizedName.WHITE_GRAPE_VINE,
            () -> new GrapeVineCropBlock((GrapeVineLeavesCropBlock) WHITE_GRAPE_VINE_LEAVES.get()), true
    );

    public static final RegistryObject<Block> HOPS_VINE = registerBlock(
            Reference.UnlocalizedName.HOPS_VINE, HopsCropBlock::new, true
    );
    
    public static final RegistryObject<Block> CORK_TREE_SAPLING = registerBlock(
            Reference.UnlocalizedName.CORK_TREE_SAPLING,
            () -> new GrowthcraftSaplingBlock(
                    new CorkTreeGrower()
            )
    );

    public static final RegistryObject<Block> CORK_WOOD = registerBlock(
            Reference.UnlocalizedName.CORK_WOOD,
            GrowthcraftLogBlock::new
    );

    public static final RegistryObject<Block> CORK_WOOD_LOG = registerBlock(
            Reference.UnlocalizedName.CORK_WOOD_LOG,
            CorkLog::new
    );

    public static final RegistryObject<Block> CORK_WOOD_LOG_STRIPPED = registerBlock(
            Reference.UnlocalizedName.CORK_WOOD_LOG_STRIPPED,
            CorkLog::new
    );

    public static final RegistryObject<Block> CORK_WOOD_STRIPPED = registerBlock(
            Reference.UnlocalizedName.CORK_WOOD_STRIPPED,
            GrowthcraftLogBlock::new
    );
    
    public static final RegistryObject<Block> CORK_TREE_LEAVES = registerBlock(
            Reference.UnlocalizedName.CORK_TREE_LEAVES,
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES))
    );
    
    public static final RegistryObject<Block> CORK_COASTER = registerBlock(
            Reference.UnlocalizedName.CORK_COASTER,
            CorkCoasterBlock::new
    );

    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        return registerBlock(name, block, false);
    }

    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> block, boolean excludeBlockItemRegistry) {
        RegistryObject<Block> registryObject = BLOCKS.register(name, block);
        if (!excludeBlockItemRegistry) {
            registerBlockItem(name, registryObject);
        }
        return registryObject;
    }

    private static void registerBlockItem(String name, RegistryObject<Block> blockRegistryObject) {
        GrowthcraftCellarItems.ITEMS.register(
                name,
                () -> new BlockItem(blockRegistryObject.get(), getDefaultItemProperties())
        );
    }

    private static Item.Properties getDefaultItemProperties() {
        Item.Properties properties = new Item.Properties();
        return properties;
    }

    private GrowthcraftCellarBlocks() {
        /* Disable default public constructor */
    }


}
