package growthcraft.rice.datagen.providers;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import growthcraft.core.init.GrowthcraftTags;
import growthcraft.core.shared.Reference;
import growthcraft.rice.init.GrowthcraftRiceItems;
import growthcraft.rice.init.GrowthcraftRiceTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GrowthcraftRiceItemTags extends ItemTagsProvider{

	public GrowthcraftRiceItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(packOutput, lookupProvider, pBlockTagsProvider.contentsGetter(), Reference.MODID, existingFileHelper);
	}

	@Override 
	protected void addTags(HolderLookup.Provider provider) {
		tag(GrowthcraftRiceTags.Items.TAG_CROPS_RICE)
		.add(GrowthcraftRiceItems.RICE.get());
		tag(GrowthcraftRiceTags.Items.TAG_GRAIN_RICE)
		.add(GrowthcraftRiceItems.RICE.get());
		tag(GrowthcraftRiceTags.Items.TAG_SEEDS_RICE)
		.add(GrowthcraftRiceItems.RICE_GRAINS.get());
		tag(GrowthcraftTags.Items.TAG_KNIFE)
		.add(GrowthcraftRiceItems.KNIFE.get());
		
		//SereneSeasons Tags
		tag(GrowthcraftTags.Items.SUMMER_CROPS)
		.add(GrowthcraftRiceItems.RICE_STALK.get());
		
		tag(GrowthcraftTags.Items.AUTUMN_CROPS)
		.add(GrowthcraftRiceItems.RICE_STALK.get());
	}
	
    @Override
    public String getName() {
        return "Growthcraft Rice Item Tags";
    }
}
