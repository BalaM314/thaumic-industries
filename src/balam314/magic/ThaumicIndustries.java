package balam314.magic;

import arc.Core;
import arc.Events;
import arc.graphics.g2d.TextureAtlas;
import arc.util.Log;
import arc.util.Log.LogLevel;
import arc.util.Nullable;
import arc.util.Time;
import balam314.magic.register.Blocks;
import balam314.magic.register.Items;
import balam314.magic.register.Liquids;
import balam314.magic.util.Mode;
import balam314.magic.util.Util;
import mindustry.Vars;
import mindustry.ctype.ContentList;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.world.Block;

public class ThaumicIndustries extends Mod {
    public static final String githubURL = "https://github.com/BalaM314/thaumic-industries";
    public static final String name = "ThaumicIndustries";
    public static final String modID = "thaumic-industries";
    public static final Util util = new Util();

    public static final Mode mode = Mode.normal;

    public ThaumicIndustries(){
        util.log("Starting...");

        if(mode == Mode.debug){
            Log.level = LogLevel.debug;
        } else {
            Log.level = LogLevel.info;
        }

    }

    @Override
    public void loadContent(){
        util.log("Loading content.");

        ContentList[] allContent = {new Items(), new Liquids(), new Blocks()};
        for(ContentList list : allContent) {
        	list.load();
            util.log("Loaded " + list.getClass().getName());
        }
        util.log("Content loaded!");

        if(mode == Mode.debug && false) {
            Log.debug("Logging blocks...");
            Log.debug("--------------");
            for (Block block : Vars.content.blocks()) {
                if (block.name.startsWith(modID))
                    Log.debug(block.name + "\t" + block.description);
            }
            Log.debug("--------------");
        }

    }

}
