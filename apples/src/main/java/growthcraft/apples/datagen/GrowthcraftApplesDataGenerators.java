package growthcraft.apples.datagen;

import java.util.concurrent.CompletableFuture;

import growthcraft.apiary.datagen.GrowthcraftApiaryDataGenerators;
import growthcraft.apples.datagen.providers.GrowthcraftApplesBlockTags;
import growthcraft.apples.datagen.providers.GrowthcraftApplesItemTags;
import growthcraft.apples.datagen.providers.GrowthcraftApplesLootTableProvider;
import growthcraft.apples.datagen.providers.GrowthcraftApplesRecipes;
import growthcraft.apples.shared.Reference;
import growthcraft.core.datagen.providers.GrowthcraftCoreBlockTags;
import growthcraft.core.datagen.providers.GrowthcraftCoreItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrowthcraftApplesDataGenerators {

	private GrowthcraftApplesDataGenerators() {
		/* Prevent generation of public constructor */
	}

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		GrowthcraftApplesBlockTags blockTags = new GrowthcraftApplesBlockTags(packOutput, lookupProvider, existingFileHelper);
		generator.addProvider(event.includeServer(), blockTags);
		generator.addProvider(event.includeServer(),  new GrowthcraftApplesItemTags(packOutput, lookupProvider, blockTags, existingFileHelper));
		generator.addProvider(event.includeServer(), new GrowthcraftApplesRecipes(packOutput));
		generator.addProvider(event.includeServer(), new GrowthcraftApplesLootTableProvider(packOutput));
	}
}
