package growthcraft.apiary.datagen.providers;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import growthcraft.apiary.init.GrowthcraftApiaryBlocks;
import growthcraft.core.shared.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GrowthcraftApiaryBlockTags extends BlockTagsProvider {

	public GrowthcraftApiaryBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, Reference.MODID, existingFileHelper);
	}

	@Override 
	protected void addTags(HolderLookup.Provider provider) {
		//GC Tags
		GrowthcraftApiaryBlocks.BLOCKS.getEntries().forEach(block -> {
			tag(BlockTags.BEEHIVES).add(block.get());
			tag(BlockTags.MINEABLE_WITH_AXE).add(block.get());
		});
	}
	
    @Override
    public String getName() {
        return "Growthcraft Apiary Block Tags";
    }
}
