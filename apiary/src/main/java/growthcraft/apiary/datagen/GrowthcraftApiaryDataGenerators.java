package growthcraft.apiary.datagen;

import java.util.concurrent.CompletableFuture;

import growthcraft.apiary.datagen.providers.GrowthcraftApiaryBlockTags;
import growthcraft.apiary.datagen.providers.GrowthcraftApiaryGlobalLootModifiersProvider;
import growthcraft.apiary.datagen.providers.GrowthcraftApiaryItemTags;
import growthcraft.apiary.datagen.providers.GrowthcraftApiaryLootTableProvider;
import growthcraft.apiary.datagen.providers.GrowthcraftApiaryRecipes;
import growthcraft.apiary.shared.Reference;
import growthcraft.core.datagen.providers.GrowthcraftCoreBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrowthcraftApiaryDataGenerators {

    private GrowthcraftApiaryDataGenerators() {
        /* Prevent generation of public constructor */
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		GrowthcraftApiaryBlockTags blockTags = new GrowthcraftApiaryBlockTags(packOutput, lookupProvider, existingFileHelper);
		generator.addProvider(event.includeServer(), blockTags);
		generator.addProvider(event.includeServer(),  new GrowthcraftApiaryItemTags(packOutput, lookupProvider, blockTags, existingFileHelper));
	    generator.addProvider(event.includeServer(), new GrowthcraftApiaryRecipes(packOutput));
	    generator.addProvider(event.includeServer(), new GrowthcraftApiaryLootTableProvider(packOutput));
	    generator.addProvider(event.includeServer(), new GrowthcraftApiaryGlobalLootModifiersProvider(packOutput));
	  }
}
