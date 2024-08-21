package growthcraft.rice.datagen.providers;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import growthcraft.core.init.GrowthcraftTags;
import growthcraft.core.shared.Reference;
import growthcraft.rice.init.GrowthcraftRiceBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GrowthcraftRiceBlockTags extends BlockTagsProvider {

	public GrowthcraftRiceBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, Reference.MODID, existingFileHelper);
	}

	@Override 
	protected void addTags(HolderLookup.Provider provider) {
		tag(BlockTags.MINEABLE_WITH_SHOVEL)
		.add(GrowthcraftRiceBlocks.CULTIVATED_FARMLAND.get());
		
		//SereneSeasons Tags
		tag(GrowthcraftTags.Blocks.SUMMER_CROPS)
		.add(GrowthcraftRiceBlocks.RICE_CROP.get());
		
		tag(GrowthcraftTags.Blocks.AUTUMN_CROPS)
		.add(GrowthcraftRiceBlocks.RICE_CROP.get());
	}

    @Override
    public String getName() {
        return "Growthcraft Rice Block Tags";
    }
}
