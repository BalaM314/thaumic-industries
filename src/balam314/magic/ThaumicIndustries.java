package balam314.magic;

import arc.Core;
import arc.Events;
import arc.graphics.g2d.TextureAtlas;
import arc.util.Log;
import arc.util.Log.LogLevel;
import arc.util.Time;
import balam314.magic.register.Blocks;
import balam314.magic.register.Items;
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

    public ThaumicIndustries(){
        // Log.level = LogLevel.debug;
        Log.info(String.format("[%s] Starting...", name));

        
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("hello");
                dialog.cont.add("welcome to mindustry magic mod").row();
                dialog.cont.add("theres nothing here").row();
                dialog.cont.add("have a frog").row();
                dialog.cont.image(getResource("frog")).pad(20f).row();
                dialog.cont.button("ok bye", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    public TextureAtlas.AtlasRegion getResource(String resourceName){
        return Core.atlas.find(modID + "-" + resourceName);
    }

    @Override
    public void loadContent(){
        Log.info("[MagicMod] Loading content.");
        Log.level = LogLevel.debug;

        ContentList[] allContent = {new Items(), new Blocks()};
        for(ContentList list : allContent) {
        	list.load();
        }
        Log.info("[MagicMod] Content loaded!");
        Log.debug("Logging blocks...");
        Log.debug("--------------");
        for(Block block : Vars.content.blocks()) {
            if(block.name.startsWith(modID))
        	Log.debug(block.name + "\t" + block.description);
        }
        Log.debug("--------------");
    }

}
