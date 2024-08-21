package growthcraft.milk.datagen.providers;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import growthcraft.core.init.GrowthcraftTags;
import growthcraft.core.shared.Reference;
import growthcraft.milk.init.GrowthcraftMilkBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GrowthcraftMilkBlockTags extends BlockTagsProvider{

	public GrowthcraftMilkBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, Reference.MODID, existingFileHelper);
	}

	@Override 
	protected void addTags(HolderLookup.Provider provider) {
		//Vanilla Tags
		tag(BlockTags.MINEABLE_WITH_AXE)
		.add(GrowthcraftMilkBlocks.CHURN.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
		.add(GrowthcraftMilkBlocks.CHEESE_PRESS.get())
		.add(GrowthcraftMilkBlocks.MIXING_VAT.get())
		.add(GrowthcraftMilkBlocks.PANCHEON.get());
		
		//SereneSeasons Tags
		tag(GrowthcraftTags.Blocks.SUMMER_CROPS)
		.add(GrowthcraftMilkBlocks.THISTLE_CROP.get());
		
		tag(GrowthcraftTags.Blocks.AUTUMN_CROPS)
		.add(GrowthcraftMilkBlocks.THISTLE_CROP.get());
	}
	
    @Override
    public String getName() {
        return "Growthcraft Milk Block Tags";
    }
}
