package growthcraft.cellar.datagen.providers;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import growthcraft.cellar.init.GrowthcraftCellarItems;
import growthcraft.cellar.init.GrowthcraftCellarTags;
import growthcraft.core.init.GrowthcraftTags;
import growthcraft.core.shared.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GrowthcraftCellarItemTags extends ItemTagsProvider{

	public GrowthcraftCellarItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(packOutput, lookupProvider, pBlockTagsProvider.contentsGetter(), Reference.MODID, existingFileHelper);
	}

	@Override 
	protected void addTags(HolderLookup.Provider provider) {
		tag(GrowthcraftCellarTags.Items.TAG_GRAPE_FRUITS)
		.add(GrowthcraftCellarItems.GRAPE_PURPLE.get());
		tag(GrowthcraftCellarTags.Items.TAG_GRAPE_FRUITS)
		.add(GrowthcraftCellarItems.GRAPE_RED.get());
		tag(GrowthcraftCellarTags.Items.TAG_GRAPE_FRUITS)
		.add(GrowthcraftCellarItems.GRAPE_WHITE.get());
		tag(GrowthcraftCellarTags.Items.TAG_GRAPE_SEEDS)
		.add(GrowthcraftCellarItems.GRAPE_PURPLE_SEED.get());
		tag(GrowthcraftCellarTags.Items.TAG_GRAPE_SEEDS)
		.add(GrowthcraftCellarItems.GRAPE_RED_SEEDS.get());
		tag(GrowthcraftCellarTags.Items.TAG_GRAPE_SEEDS)
		.add(GrowthcraftCellarItems.GRAPE_WHITE_SEEDS.get());
		
		//Forge Tags
		//we should check if this is correct
		GrowthcraftCellarItems.ITEMS.getEntries().forEach(grain -> {
			if (grain.getId().getPath().contains("grain")) {
				tag(GrowthcraftCellarTags.Items.TAG_BARLEY)
				.add(grain.get());
				tag(GrowthcraftCellarTags.Items.TAG_GRAIN)
				.add(grain.get());
			}
		});
		
		//SereneSeasons Tags
				tag(GrowthcraftTags.Items.SPRING_CROPS)
				.add(GrowthcraftCellarItems.GRAPE_PURPLE_SEED.get())
				.add(GrowthcraftCellarItems.GRAPE_RED_SEEDS.get())
				.add(GrowthcraftCellarItems.GRAPE_WHITE_SEEDS.get())
				.add(GrowthcraftCellarItems.HOPS_SEED.get());
				
				tag(GrowthcraftTags.Items.SUMMER_CROPS)
				.add(GrowthcraftCellarItems.GRAPE_PURPLE_SEED.get())
				.add(GrowthcraftCellarItems.GRAPE_RED_SEEDS.get())
				.add(GrowthcraftCellarItems.GRAPE_WHITE_SEEDS.get())
				.add(GrowthcraftCellarItems.HOPS_SEED.get());
	}
	
    @Override
    public String getName() {
        return "Growthcraft Cellar Item Tags";
    }
}
