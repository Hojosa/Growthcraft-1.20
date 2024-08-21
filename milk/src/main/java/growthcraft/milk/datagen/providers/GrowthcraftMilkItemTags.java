package growthcraft.milk.datagen.providers;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import growthcraft.core.init.GrowthcraftTags;
import growthcraft.core.shared.Reference;
import growthcraft.milk.init.GrowthcraftMilkFluids;
import growthcraft.milk.init.GrowthcraftMilkItems;
import growthcraft.milk.init.GrowthcraftMilkTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GrowthcraftMilkItemTags extends ItemTagsProvider {

	public GrowthcraftMilkItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(packOutput, lookupProvider, pBlockTagsProvider.contentsGetter(), Reference.MODID, existingFileHelper);
	}

	@Override 
	protected void addTags(HolderLookup.Provider provider) {
		tag(GrowthcraftMilkTags.Items.TAG_MILK_BUCKETS)
		.add(GrowthcraftMilkFluids.MILK.bucket.get())
		.add(GrowthcraftMilkFluids.BUTTER_MILK.bucket.get());
		tag(GrowthcraftMilkTags.Items.TAG_MIXING_VAT_TOOLS)
		.add(GrowthcraftMilkItems.CHEESE_CLOTH.get());
		
		//SereneSeasons Tags
		tag(GrowthcraftTags.Items.SUMMER_CROPS)
		.add(GrowthcraftMilkItems.THISTLE_SEED.get());
		
		tag(GrowthcraftTags.Items.AUTUMN_CROPS)
		.add(GrowthcraftMilkItems.THISTLE_SEED.get());
	}
	
    @Override
    public String getName() {
        return "Growthcraft Milk Item Tags";
    }
}
