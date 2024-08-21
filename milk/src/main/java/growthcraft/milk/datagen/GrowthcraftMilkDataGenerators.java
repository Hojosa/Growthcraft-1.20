package growthcraft.milk.datagen;

import java.util.concurrent.CompletableFuture;

import growthcraft.milk.datagen.providers.GrowthcraftMilkBlockStateProvider;
import growthcraft.milk.datagen.providers.GrowthcraftMilkBlockTags;
import growthcraft.milk.datagen.providers.GrowthcraftMilkGlobalLootModifiersProvider;
import growthcraft.milk.datagen.providers.GrowthcraftMilkItemTags;
import growthcraft.milk.datagen.providers.GrowthcraftMilkLootTableProvider;
import growthcraft.milk.datagen.providers.GrowthcraftMilkRecipes;
import growthcraft.milk.init.GrowthcraftMilkItems;
import growthcraft.milk.shared.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrowthcraftMilkDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        GrowthcraftMilkBlockTags blockTags = new GrowthcraftMilkBlockTags(packOutput, lookupProvider, existingFileHelper);
		generator.addProvider(event.includeServer(), blockTags);
		generator.addProvider(event.includeServer(),  new GrowthcraftMilkItemTags(packOutput, lookupProvider, blockTags, existingFileHelper));
        generator.addProvider(event.includeServer(), new GrowthcraftMilkLootTableProvider(packOutput));
        generator.addProvider(event.includeClient(), new GrowthcraftMilkBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new GrowthcraftMilkRecipes(packOutput));
		generator.addProvider(event.includeServer(), new GrowthcraftMilkGlobalLootModifiersProvider(packOutput));

    }

    //@SubscribeEvent
    public static void modelBake(ModelEvent.ModifyBakingResult event) {
        GrowthcraftMilkItems.addItemModelProperties();
    }
}
