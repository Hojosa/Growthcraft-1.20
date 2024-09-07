package growthcraft.cellar.init;

import growthcraft.cellar.shared.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class GrowthcraftCellarTags {

    public static void init() {
        GrowthcraftCellarTags.Blocks.init();
        GrowthcraftCellarTags.Items.init();
        GrowthcraftCellarTags.Fluids.init();
        GrowthcraftCellarTags.EntityTypes.init();
    }

    public static class Blocks {

        private static void init() {
            // Do nothing, simply instantiate static variables
        }

        //public static final TagKey<Block> HEATSOURCES = tag(Reference.UnlocalizedName.TAG_HEATSOURCES);

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Reference.MODID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> TAG_GRAIN = tag(Reference.UnlocalizedName.GRAIN);
        
        public static final TagKey<Item> TAG_BARLEY = forgeTag(Reference.UnlocalizedName.TAG_BARLEY);
        public static final TagKey<Item> TAG_GRAPE_SEEDS = forgeTag(Reference.UnlocalizedName.TAG_GRAPE_SEEDS);
        public static final TagKey<Item> TAG_GRAPE_FRUITS = forgeTag(Reference.UnlocalizedName.TAG_GRAPE_FRUITS);

        private static void init() {
            // Do nothing, simply instantiate static variables
        }

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Reference.MODID, name));
        }
        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Fluids {

        private static void init() {
            // Do nothing, simply instantiate static variables
        }

        private static TagKey<Fluid> tag(String name) {
            return FluidTags.create(new ResourceLocation(Reference.MODID, name));
        }
    }

    public static class EntityTypes {

        private static void init() {
            // Do nothing, simply instantiate static variables
        }

        //public static final TagKey<EntityType<?>> MILKABLE = tag("milkable");

        //private static TagKey<EntityType<?>> tag(String name) {
        //    return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(Reference.MODID, name));
        //}
    }

}
