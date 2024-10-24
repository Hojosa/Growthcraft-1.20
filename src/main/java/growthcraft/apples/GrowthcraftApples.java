package growthcraft.apples;

import growthcraft.apples.init.GrowthcraftApplesBlocks;
import growthcraft.apples.init.GrowthcraftApplesFluids;
import growthcraft.apples.init.GrowthcraftApplesItems;
import growthcraft.apples.init.client.GrowthcraftApplesBlockRenderers;
import growthcraft.apples.init.config.GrowthcraftApplesConfig;
import growthcraft.apples.shared.Reference;
import growthcraft.core.init.GrowthcraftCreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Reference.MODID)
@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrowthcraftApples {
    public static final Logger LOGGER = LogManager.getLogger(Reference.MODID);

    public GrowthcraftApples() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetupEvent);
        modEventBus.addListener(this::buildCreativeTabContents);

        // Config
        GrowthcraftApplesConfig.loadConfig();

        // Blocks, Items, Fluids, Block Entities, Containers
        GrowthcraftApplesBlocks.BLOCKS.register(modEventBus);
        GrowthcraftApplesItems.ITEMS.register(modEventBus);
        GrowthcraftApplesFluids.FLUID_TYPES.register(modEventBus);
        GrowthcraftApplesFluids.FLUIDS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetupEvent(final FMLClientSetupEvent event) {
        GrowthcraftApplesBlockRenderers.setRenderLayers();
    }

    private void setup(final FMLCommonSetupEvent event) {
        GrowthcraftApplesItems.registerCompostables();
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Growthcraft Apples starting up ...");
    }

    public void buildCreativeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == GrowthcraftCreativeModeTabs.CREATIVE_TAB.get()) {
            GrowthcraftApplesItems.ITEMS.getEntries().forEach(itemRegistryObject -> {
                if (!GrowthcraftApplesItems.excludeItemRegistry(itemRegistryObject.getId())) {
                    event.accept(new ItemStack(itemRegistryObject.get()));
                }
            });
        }
    }
}
