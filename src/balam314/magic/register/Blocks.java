package balam314.magic.register;

import balam314.magic.content.blocks.VinteumExtractor;
import balam314.magic.content.blocks.VinteumOre;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.meta.Attribute;

import static mindustry.type.ItemStack.with;

public class Blocks implements ContentList {

	public static Block vinteumOre, vinteumExtractor, evaporator;
	
	@Override
	public void load() {
		vinteumOre = new VinteumOre("vinteum-ore", balam314.magic.register.Items.vinteum);

		vinteumExtractor = new VinteumExtractor("vinteum-extractor"){{
			requirements(Category.production, with(Items.lead, 45, Items.silicon, 30, Items.metaglass, 20));
			result = Liquids.vinteumSolution;
			pumpAmount = 0.1f;
			size = 2;
			liquidCapacity = 30f;

			consumes.power(4f);
			consumes.liquid(mindustry.content.Liquids.water, 0.1f);
		}};

		evaporator = new AttributeCrafter("evaporator"){{
			requirements(Category.crafting, with(Items.titanium, 20, Items.copper, 40, Items.lead, 30));
			craftEffect = Fx.steam;
			outputItem = new ItemStack(balam314.magic.register.Items.vinteum, 1);
			craftTime = 300f;
			size = 2;
			hasItems = true;
			hasLiquids = true;
			attribute = Attribute.heat;

			consumes.liquid(Liquids.vinteumSolution, 1f / 30f);
		}};
	}



	
	
	
}
