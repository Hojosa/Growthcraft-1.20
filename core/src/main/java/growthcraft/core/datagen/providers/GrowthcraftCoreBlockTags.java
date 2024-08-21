package growthcraft.core.datagen.providers;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import growthcraft.core.init.GrowthcraftBlocks;
import growthcraft.core.init.GrowthcraftTags;
import growthcraft.core.shared.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GrowthcraftCoreBlockTags extends BlockTagsProvider {

	public GrowthcraftCoreBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, Reference.MODID, existingFileHelper);
	}
	
	@Override 
	protected void addTags(HolderLookup.Provider provider) {
		tag(GrowthcraftTags.Blocks.HEATSOURCES)
		.add(Blocks.LAVA)
		.add(Blocks.MAGMA_BLOCK)
		.add(TagEntry.optionalElement(new ResourceLocation("farmersdelight", "stove")))
		.add(TagEntry.optionalElement(new ResourceLocation("decorative_blocks", "bonfire")))
		.add(TagEntry.optionalElement(new ResourceLocation("decorative_blocks", "brazier")))  // would have liked to support additional_lights but their firepits aren't tagged and there's a ton of them.
		.add(TagEntry.tag(BlockTags.CAMPFIRES.location()))
		.add(TagEntry.tag(BlockTags.FIRE.location()));

		tag(GrowthcraftTags.Blocks.ROPE)
		.add(GrowthcraftBlocks.ROPE_LINEN.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_ACACIA_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_BIRCH_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_CRIMSON_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_DARK_OAK_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_JUNGLE_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_NETHER_BRICK_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_OAK_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_SPRUCE_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_WARPED_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_BAMBOO_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_CHERRY_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_MANGROVE_FENCE.get());

		tag(GrowthcraftTags.Blocks.SALT)
		.add(GrowthcraftBlocks.SALT_BLOCK.get());
		
		//Vanilla Tags
		tag(BlockTags.MINEABLE_WITH_AXE)
		.add(GrowthcraftBlocks.ROPE_LINEN_ACACIA_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_BIRCH_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_CRIMSON_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_DARK_OAK_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_JUNGLE_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_NETHER_BRICK_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_OAK_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_SPRUCE_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_WARPED_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_BAMBOO_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_CHERRY_FENCE.get())
		.add(GrowthcraftBlocks.ROPE_LINEN_MANGROVE_FENCE.get());
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
		.add(GrowthcraftBlocks.SALT_ORE.get())
		.add(GrowthcraftBlocks.SALT_ORE_DEEPSLATE.get())
		.add(GrowthcraftBlocks.SALT_ORE_END.get())
		.add(GrowthcraftBlocks.SALT_ORE_NETHER.get());

		tag(BlockTags.NEEDS_STONE_TOOL)
		.add(GrowthcraftBlocks.SALT_ORE.get())
		.add(GrowthcraftBlocks.SALT_ORE_DEEPSLATE.get())
		.add(GrowthcraftBlocks.SALT_ORE_END.get())
		.add(GrowthcraftBlocks.SALT_ORE_NETHER.get());
		
		//Forge Tags
		tag(Tags.Blocks.ORES)
		.add(GrowthcraftBlocks.SALT_ORE.get())
		.add(GrowthcraftBlocks.SALT_ORE_DEEPSLATE.get())
		.add(GrowthcraftBlocks.SALT_ORE_NETHER.get())
		.add(GrowthcraftBlocks.SALT_ORE_END.get());
		tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE)
		.add(GrowthcraftBlocks.SALT_ORE_DEEPSLATE.get());
		tag(Tags.Blocks.ORES_IN_GROUND_NETHERRACK)
		.add(GrowthcraftBlocks.SALT_ORE_NETHER.get());
		tag(Tags.Blocks.ORES_IN_GROUND_STONE)
		.add(GrowthcraftBlocks.SALT_ORE.get());
	}

    @Override
    public String getName() {
        return "Growthcraft Core Block Tags";
    }
}
