package balam314.magic.register;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class Items implements ContentList {
	
	public static Item vinteum, managlass;
	
	@Override
	public void load() {
		vinteum = new Item("vinteum", Color.valueOf("9b4bc5")) {{
			hardness = 2;
			cost = 1.0f;
		}};
		managlass = new Item("managlass", Color.valueOf("00eeff")) {{
			cost = 1.5f;
		}};
	}

}
