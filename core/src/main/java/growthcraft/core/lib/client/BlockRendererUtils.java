package growthcraft.core.lib.client;

import java.util.Collection;

import growthcraft.core.lib.utils.ColorUtils;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.registries.RegistryObject;

public class BlockRendererUtils {

    public static void registerBlocks(RegisterColorHandlersEvent.Block handler, BlockColor blockColor, Collection<RegistryObject<Block>> blocks) {
        if (blocks.isEmpty()) return;
        blocks.stream()
                .filter(RegistryObject::isPresent)
                .map(RegistryObject::get)
                .forEach(block -> handler.register(blockColor, block));
    }

    public static void registerBlock(RegisterColorHandlersEvent.Block handler, ColorUtils.GrowthcraftColor color, Block block) {
        handler.getBlockColors().register((blockstate, reader, pos, i) -> color.toIntValue(), block);
    }

}
