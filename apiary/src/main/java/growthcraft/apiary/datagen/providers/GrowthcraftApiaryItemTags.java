package growthcraft.apiary.datagen.providers;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import growthcraft.apiary.init.GrowthcraftApiaryItems;
import growthcraft.apiary.init.GrowthcraftApiaryTags;
import growthcraft.core.lib.item.GrowthcraftItem;
import growthcraft.core.shared.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GrowthcraftApiaryItemTags extends ItemTagsProvider {

	public GrowthcraftApiaryItemTags (PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(packOutput, lookupProvider, pBlockTagsProvider.contentsGetter(), Reference.MODID, existingFileHelper);
	}

	@Override 
	protected void addTags(HolderLookup.Provider provider) {
		//GC Tags
		tag(GrowthcraftApiaryTags.Items.BEE)
		.add(GrowthcraftApiaryItems.BEE.get());
		tag(GrowthcraftApiaryTags.Items.HONEY_COMB)
		.add(GrowthcraftApiaryItems.HONEY_COMB_EMPTY.get())
		.add(GrowthcraftApiaryItems.HONEY_COMB_FULL.get())
		.add(Items.HONEYCOMB);
		tag(GrowthcraftApiaryTags.Items.BEES_WAX)
		.add(GrowthcraftApiaryItems.BEES_WAX.get());
		
		GrowthcraftApiaryItems.ITEMS.getEntries().forEach(item -> {
			if(item.getId().getPath().contains("bees_wax_")) {
				tag(GrowthcraftApiaryTags.Items.BEES_WAX).add(item.get());
				tag(((@NotNull GrowthcraftItem) item.get()).getDyeColor().getTag()).add(item.get());
			}
		});
	}
	
    @Override
    public String getName() {
        return "Growthcraft Apiary Item Tags";
    }
}
