package growthcraft.cellar.datagen.providers;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import growthcraft.cellar.init.GrowthcraftCellarBlocks;
import growthcraft.cellar.shared.Reference;
import growthcraft.core.init.GrowthcraftTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GrowthcraftCellarBlockTags extends BlockTagsProvider {

	public GrowthcraftCellarBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, Reference.MODID, existingFileHelper);
	}

	@Override 
	protected void addTags(HolderLookup.Provider provider) {
		tag(GrowthcraftTags.Blocks.ROPE)
		.add(GrowthcraftCellarBlocks.HOPS_VINE.get())
		.add(GrowthcraftCellarBlocks.PURPLE_GRAPE_VINE.get())
		.add(GrowthcraftCellarBlocks.PURPLE_GRAPE_VINE_LEAVES.get())
		.add(GrowthcraftCellarBlocks.RED_GRAPE_VINE.get())
		.add(GrowthcraftCellarBlocks.RED_GRAPE_VINE_LEAVES.get())
		.add(GrowthcraftCellarBlocks.WHITE_GRAPE_VINE.get())
		.add(GrowthcraftCellarBlocks.WHITE_GRAPE_VINE_LEAVES.get());
		
		//Vanilla Tags
		tag(BlockTags.MINEABLE_WITH_AXE)
		.add(GrowthcraftCellarBlocks.FERMENTATION_BARREL_OAK.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
		.add(GrowthcraftCellarBlocks.BREW_KETTLE.get())
		.add(GrowthcraftCellarBlocks.FRUIT_PRESS.get())
		.add(GrowthcraftCellarBlocks.FRUIT_PRESS_PISTON.get())
		.add(GrowthcraftCellarBlocks.ROASTER.get());
		
		//SereneSeasons Tags
		tag(GrowthcraftTags.Blocks.SPRING_CROPS)
		.add(GrowthcraftCellarBlocks.PURPLE_GRAPE_VINE.get())
		.add(GrowthcraftCellarBlocks.RED_GRAPE_VINE.get())
		.add(GrowthcraftCellarBlocks.WHITE_GRAPE_VINE.get())
		.add(GrowthcraftCellarBlocks.HOPS_VINE.get());
		
		tag(GrowthcraftTags.Blocks.SUMMER_CROPS)
		.add(GrowthcraftCellarBlocks.PURPLE_GRAPE_VINE.get())
		.add(GrowthcraftCellarBlocks.RED_GRAPE_VINE.get())
		.add(GrowthcraftCellarBlocks.WHITE_GRAPE_VINE.get())
		.add(GrowthcraftCellarBlocks.HOPS_VINE.get());
	}
	
    @Override
    public String getName() {
        return "Growthcraft Cellar Block Tags";
    }
}
