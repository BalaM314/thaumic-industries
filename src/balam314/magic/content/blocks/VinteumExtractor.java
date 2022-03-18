package balam314.magic.content.blocks;

import arc.Core;
import arc.KeyBinds;
import arc.graphics.g2d.Draw;
import arc.math.Mathf;
import arc.util.Log;
import balam314.magic.register.Blocks;
import balam314.magic.register.Items;
import mindustry.content.Liquids;
import mindustry.game.Team;
import mindustry.graphics.Drawf;
import mindustry.input.Binding;
import mindustry.world.Tile;
import mindustry.world.blocks.production.SolidPump;

import static balam314.magic.ThaumicIndustries.modID;
import static mindustry.world.meta.BlockGroup.liquids;

public class VinteumExtractor extends SolidPump {

    public VinteumExtractor(String name){
        super(name);
        result = Liquids.cryofluid;

    }

    @Override
    public boolean canPump(Tile tile) {
        return tile.overlay().name == Blocks.vinteumOre.name;
    }


    public boolean canPlaceOn(Tile tile, Team team, int rotation){
        var linkedTiles = tile.getLinkedTilesAs(this, tempTiles);
        for(Tile t : linkedTiles) {
            if (canPump(t)) {
                return true;
            }
        }
        Log.debug("Cannot place on " + tile.overlay().name + " because it is not " + Blocks.vinteumOre.name);
        return false;
    }

    public class VinteumExtractorBuild extends SolidPumpBuild {
        @Override
        public void draw(){
            Draw.rect(region, x, y);
            super.drawCracks();

            Drawf.spinSprite(rotatorRegion, x, y, pumpTime * rotateSpeed);
            Draw.rect(topRegion, x, y);
        }

        @Override
        public void updateTile(){
            float fraction = Math.max(validTiles + boost + (attribute == null ? 0 : attribute.env()), 0);

            if(cons.valid() && typeLiquid() < liquidCapacity - 0.001f){
                float maxPump = Math.min(liquidCapacity - typeLiquid(), pumpAmount * delta() * fraction * efficiency());
                liquids.add(result, maxPump);
                lastPump = maxPump;
                warmup = Mathf.lerpDelta(warmup, 1f, 0.02f);
                if(Mathf.chance(delta() * updateEffectChance))
                    updateEffect.at(x + Mathf.range(size * 2f), y + Mathf.range(size * 2f));
            }else{
                warmup = Mathf.lerpDelta(warmup, 0f, 0.02f);
                lastPump = 0f;
            }

            pumpTime += warmup * edelta();

            if(Core.input.keyDown(Binding.boost)) {
                Log.debug("validTiles: " + fraction + " boost: " + boost + " baseEfficiency: " + baseEfficiency);
            }
            dumpLiquid(result);
        }
    }


}
