package growthcraft.apples.datagen.providers;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import growthcraft.apples.init.GrowthcraftApplesBlocks;
import growthcraft.apples.init.GrowthcraftApplesTags;
import growthcraft.core.init.GrowthcraftTags;
import growthcraft.core.shared.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GrowthcraftApplesBlockTags extends BlockTagsProvider {

	public GrowthcraftApplesBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, Reference.MODID, existingFileHelper);
	}

	@Override 
	protected void addTags(HolderLookup.Provider provider) {
		tag(GrowthcraftApplesTags.Blocks.APPLE_WOOD_LOG)
		.add(GrowthcraftApplesBlocks.APPLE_WOOD_LOG.get())
		.add(GrowthcraftApplesBlocks.APPLE_WOOD_LOG_STRIPPED.get());
		
		tag(GrowthcraftTags.Blocks.ROPE)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_FENCE_ROPE_LINEN.get());
		
		//Vanilla Tags
		tag(BlockTags.WOODEN_BUTTONS)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_BUTTON.get());
		tag(BlockTags.PLANKS)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK.get());
		tag(BlockTags.WOODEN_DOORS)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_DOOR.get());
		tag(BlockTags.WOODEN_SLABS)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_SLAB.get());
		tag(BlockTags.LOGS)
		.add(GrowthcraftApplesBlocks.APPLE_WOOD_LOG.get())
		.add(GrowthcraftApplesBlocks.APPLE_WOOD_LOG_STRIPPED.get())
		.add(GrowthcraftApplesBlocks.APPLE_WOOD.get())
		.add(GrowthcraftApplesBlocks.APPLE_WOOD_STRIPPED.get());
		tag(BlockTags.WOODEN_STAIRS)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_STAIRS.get());
		tag(BlockTags.WOODEN_FENCES)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_FENCE.get());
		tag(BlockTags.FENCE_GATES)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_FENCE_GATE.get());
		tag(BlockTags.WOODEN_PRESSURE_PLATES)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_PRESSURE_PLATE.get());
		tag(BlockTags.WOODEN_TRAPDOORS)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_TRAPDOOR.get());
		tag(BlockTags.LEAVES)
		.add(GrowthcraftApplesBlocks.APPLE_TREE_LEAVES.get());
		
		//SereneSeasons Tags
		tag(GrowthcraftTags.Blocks.SPRING_CROPS)
		.add(GrowthcraftApplesBlocks.APPLE_TREE_SAPLING.get());
		
		tag(GrowthcraftTags.Blocks.SUMMER_CROPS)
		.add(GrowthcraftApplesBlocks.APPLE_TREE_SAPLING.get());
	}
	
    @Override
    public String getName() {
        return "Growthcraft Apples Block Tags";
    }
}
