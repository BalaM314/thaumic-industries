package balam314.magic.content.blocks;

import arc.Core;
import arc.KeyBinds;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Mathf;
import arc.util.Log;
import balam314.magic.register.Blocks;
import balam314.magic.register.Items;
import balam314.magic.register.Liquids;
import mindustry.game.Team;
import mindustry.graphics.Drawf;
import mindustry.input.Binding;
import mindustry.type.Liquid;
import mindustry.world.Tile;
import mindustry.world.blocks.production.SolidPump;

import static mindustry.Vars.*;


public class VinteumExtractor extends SolidPump {

	public VinteumExtractor(String name){
		super(name);
	}

	@Override
	public boolean canPump(Tile tile) {
		return tile.overlay().name == Blocks.vinteumOre.name;
	}


	@Override
	public void drawPlace(int x, int y, int rotation, boolean valid){
		super.drawPlace(x, y, rotation, valid);

		Tile tile = world.tile(x, y);
		if(tile == null) return;

		float amount = 0f;

		for(Tile other : tile.getLinkedTilesAs(this, tempTiles)){
			if(canPump(other)){
				amount += 1 / (float)(this.size * this.size);
			}
		}

		float width = drawPlaceText(Core.bundle.formatFloat("bar.pumpspeed", amount * pumpAmount * 60f, 1), x, y, valid);
		float dx = x * tilesize + offset - width/2f - 4f, dy = y * tilesize + offset + size * tilesize / 2f + 5, s = iconSmall / 4f;
		Draw.mixcol(Color.darkGray, 1f);
		Draw.rect(result.fullIcon, dx, dy - 1, s, s);
		Draw.reset();
		Draw.rect(result.fullIcon, dx, dy, s, s);
	}

	public boolean canPlaceOn(Tile tile, Team team, int rotation){
		var linkedTiles = tile.getLinkedTilesAs(this, tempTiles);
		for(Tile t : linkedTiles) {
			if (canPump(t)) {
				return true;
			}
		}
		return false;
	}


	/** The class instantiated and updated for every building actually placed in world. Called using getClass magic. */
	public class VinteumExtractorBuild extends SolidPumpBuild {
		@Override
		public void draw(){
			Draw.rect(region, x, y);
			super.drawCracks();

			Drawf.spinSprite(rotatorRegion, x, y, pumpTime * rotateSpeed);
			Draw.rect(topRegion, x, y);
		}


	}


}
