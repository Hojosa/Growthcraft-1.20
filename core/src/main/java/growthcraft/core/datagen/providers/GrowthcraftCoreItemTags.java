package growthcraft.core.datagen.providers;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import growthcraft.core.init.GrowthcraftItems;
import growthcraft.core.init.GrowthcraftTags;
import growthcraft.core.shared.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GrowthcraftCoreItemTags extends ItemTagsProvider{

	public GrowthcraftCoreItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(packOutput, lookupProvider, pBlockTagsProvider.contentsGetter(), Reference.MODID, existingFileHelper);
	}
	
	@Override 
	protected void addTags(HolderLookup.Provider provider) {
		tag(GrowthcraftTags.Items.ROASTER_WRENCH)
		.add(GrowthcraftItems.WRENCH.get());
		tag(GrowthcraftTags.Items.SALT)
		.add(GrowthcraftItems.SALT.get());
		
		//Forge Tags
		tag(GrowthcraftTags.Items.DUSTS_SALT)
		.add(GrowthcraftItems.SALT.get());
	}

    @Override
    public String getName() {
        return "Growthcraft Core Item Tags";
    }
}
