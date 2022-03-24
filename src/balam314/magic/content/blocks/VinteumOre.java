package balam314.magic.content.blocks;

import arc.graphics.g2d.Draw;
import mindustry.Vars;
import mindustry.type.Item;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.OreBlock;

public class VinteumOre extends OreBlock {

	public VinteumOre(String name, Item ore) {
		super(name, ore);
		inEditor = true;
		variants = 0;
		
	}

	@Override
	public void load() {
		super.load();
	}

	@Override
	public void drawBase(Tile tile){
		//if you havent unlocked the magic research display char instead
		super.drawBase(tile);
	}

	

	
}
