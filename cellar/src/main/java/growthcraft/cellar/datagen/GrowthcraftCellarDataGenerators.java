package growthcraft.cellar.datagen;

import java.util.concurrent.CompletableFuture;

import growthcraft.cellar.datagen.providers.GrowthcraftCellarBlockTags;
import growthcraft.cellar.datagen.providers.GrowthcraftCellarGlobalLootModifiersProvider;
import growthcraft.cellar.datagen.providers.GrowthcraftCellarItemTags;
import growthcraft.cellar.datagen.providers.GrowthcraftCellarLootTableProvider;
import growthcraft.cellar.datagen.providers.GrowthcraftCellarRecipes;
import growthcraft.cellar.shared.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrowthcraftCellarDataGenerators {

	private GrowthcraftCellarDataGenerators() {
		/* Prevent generation of public constructor. */
	}
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		
		GrowthcraftCellarBlockTags blockTags = new GrowthcraftCellarBlockTags(packOutput, lookupProvider, existingFileHelper);
		generator.addProvider(event.includeServer(), blockTags);
		generator.addProvider(event.includeServer(), new GrowthcraftCellarItemTags(packOutput, lookupProvider, blockTags, existingFileHelper));
		generator.addProvider(event.includeServer(), new GrowthcraftCellarRecipes(packOutput));
		generator.addProvider(event.includeServer(), new GrowthcraftCellarLootTableProvider(packOutput));
		generator.addProvider(event.includeServer(), new GrowthcraftCellarGlobalLootModifiersProvider(packOutput));
	}
}
