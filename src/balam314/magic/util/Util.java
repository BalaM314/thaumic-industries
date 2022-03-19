package balam314.magic.util;

import arc.Core;
import arc.graphics.g2d.TextureAtlas;
import arc.util.Log;
import arc.util.Nullable;
import balam314.magic.ThaumicIndustries;

public class Util {
    private int debugTimer = 0;
    public void debug(String message){
        if(ThaumicIndustries.mode != Mode.debug) return;
        if(debugTimer > 0){
            debugTimer --;
        }
        if(Core.input.shift() && debugTimer == 0){
            Log.info(message);
            debugTimer = 10;
        }
    }
    public void log(String message){
        Log.info(String.format("[%s] %s", ThaumicIndustries.name, message));
    }

    public TextureAtlas.AtlasRegion getResource(String resourceName, @Nullable String modid){
        if(modid == null) {
            return Core.atlas.find(ThaumicIndustries.modID + "-" + resourceName);
        } else if (modid == "") {
            return Core.atlas.find(resourceName);
        } else {
            return Core.atlas.find(modid + "-" + resourceName);
        }
    }
}
