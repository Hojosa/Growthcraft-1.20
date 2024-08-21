package growthcraft.apples.datagen.providers;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import growthcraft.apples.init.GrowthcraftApplesBlocks;
import growthcraft.apples.init.GrowthcraftApplesItems;
import growthcraft.apples.init.GrowthcraftApplesTags;
import growthcraft.core.init.GrowthcraftTags;
import growthcraft.core.shared.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GrowthcraftApplesItemTags extends ItemTagsProvider {

	public GrowthcraftApplesItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(packOutput, lookupProvider, pBlockTagsProvider.contentsGetter(), Reference.MODID, existingFileHelper);
	}

	@Override 
	protected void addTags(HolderLookup.Provider provider) {
		
		tag(GrowthcraftApplesTags.Items.APPLE_WOOD_LOG)
		.add(GrowthcraftApplesBlocks.APPLE_WOOD_LOG.get().asItem())
		.add(GrowthcraftApplesBlocks.APPLE_WOOD_LOG_STRIPPED.get().asItem());
	
		//Vanilla Tags
		tag(ItemTags.WOODEN_BUTTONS)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_BUTTON.get().asItem());
		tag(ItemTags.PLANKS)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK.get().asItem());
		tag(ItemTags.WOODEN_DOORS)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_DOOR.get().asItem());
		tag(ItemTags.WOODEN_SLABS)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_SLAB.get().asItem());
		tag(ItemTags.LOGS)
		.add(GrowthcraftApplesBlocks.APPLE_WOOD_LOG.get().asItem())
		.add(GrowthcraftApplesBlocks.APPLE_WOOD_LOG_STRIPPED.get().asItem());
		tag(ItemTags.WOODEN_STAIRS)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_STAIRS.get().asItem());
		tag(ItemTags.WOODEN_FENCES)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_FENCE.get().asItem());
		tag(Tags.Items.FENCE_GATES_WOODEN)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_FENCE_GATE.get().asItem());
		tag(ItemTags.WOODEN_PRESSURE_PLATES)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_PRESSURE_PLATE.get().asItem());
		tag(ItemTags.WOODEN_TRAPDOORS)
		.add(GrowthcraftApplesBlocks.APPLE_PLANK_TRAPDOOR.get().asItem());
		tag(ItemTags.LEAVES)
		.add(GrowthcraftApplesBlocks.APPLE_TREE_LEAVES.get().asItem());
	
		//SereneSeasons Tags
		tag(GrowthcraftTags.Items.SPRING_CROPS)
		.add(GrowthcraftApplesItems.APPLE_SEEDS.get());
		
		tag(GrowthcraftTags.Items.SUMMER_CROPS)
		.add(GrowthcraftApplesItems.APPLE_SEEDS.get());
	}
	
    @Override
    public String getName() {
        return "Growthcraft Apples Item Tags";
    }
}
