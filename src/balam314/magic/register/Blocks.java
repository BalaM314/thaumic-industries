package balam314.magic.register;

import balam314.magic.content.blocks.VinteumExtractor;
import balam314.magic.content.blocks.VinteumOre;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.world.Block;

import static mindustry.type.ItemStack.with;

public class Blocks implements ContentList {

	public static Block vinteumOre, vinteumExtractor;
	
	@Override
	public void load() {
		vinteumOre = new VinteumOre("vinteum-ore", balam314.magic.register.Items.vinteum);
		vinteumExtractor = new VinteumExtractor("vinteum-extractor"){{
			requirements(Category.production, with(Items.copper, 150, Items.graphite, 175, Items.lead, 115, Items.thorium, 115, Items.silicon, 75));
			result = Liquids.cryofluid;//temp
			updateEffect = Fx.pulverize;
			updateEffectChance = 0.05f;
			pumpAmount = 0.25f;
			size = 2;
			liquidCapacity = 30f;

			consumes.power(4f);
			consumes.liquid(Liquids.water, 0.2f);
		}};
	}


	
	
	
}
