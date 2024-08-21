package growthcraft.core.datagen.providers;

import growthcraft.core.lib.loot.AddLootTableModifier;
import growthcraft.core.shared.Reference;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootModifier;

public class GrowthcraftCoreGlobalLootModifiersProvider extends GlobalLootModifierProvider{
	public GrowthcraftCoreGlobalLootModifiersProvider(PackOutput output) {
		super(output, Reference.MODID);
	}
	
	@Override
	protected void start() {
	}
	
	private static LootModifier loot(ResourceLocation id, LootItemCondition... cond) {
		return new AddLootTableModifier(cond, id);
	}
}
