package growthcraft.cellar.lib.fluid;

import java.util.function.Supplier;

import org.jetbrains.annotations.Nullable;

import growthcraft.cellar.init.GrowthcraftCellarBlocks;
import growthcraft.cellar.init.GrowthcraftCellarFluids;
import growthcraft.cellar.init.GrowthcraftCellarItems;
import growthcraft.core.lib.fluid.FluidRegistryContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;

public class GrowthcraftCellarFluidRegistryContainer extends FluidRegistryContainer {



    public GrowthcraftCellarFluidRegistryContainer(
            String name,
            FluidType.Properties typeProperties,
            Supplier<IClientFluidTypeExtensions> clientExtensions,
            @Nullable AdditionalProperties additionalProperties,
            BlockBehaviour.Properties blockProperties,
            Item.Properties itemProperties) {
        super(name, typeProperties, clientExtensions, additionalProperties, blockProperties, itemProperties,
                GrowthcraftCellarFluids.FLUIDS,GrowthcraftCellarFluids.FLUID_TYPES,
                GrowthcraftCellarBlocks.BLOCKS,GrowthcraftCellarItems.ITEMS);
    }

    public GrowthcraftCellarFluidRegistryContainer(
            String name,
            FluidType.Properties typeProperties,
            Supplier<IClientFluidTypeExtensions> clientExtensions,
            BlockBehaviour.Properties blockProperties,
            Item.Properties itemProperties) {
        this(name, typeProperties, clientExtensions, null, blockProperties, itemProperties);
    }
}
