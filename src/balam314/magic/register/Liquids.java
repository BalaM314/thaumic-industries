package balam314.magic.register;

import mindustry.ctype.ContentList;
import mindustry.type.Liquid;

public class Liquids implements ContentList {

	public static Liquid vinteumSolution;

	@Override
	public void load(){
		vinteumSolution = new Liquid("vinteum-solution", Items.vinteum.color){{
			temperature = 0.4f;
			viscosity = 0.4f;
			flammability = 0.0f;
			explosiveness = 0.0f;
			heatCapacity = 0.45f;
		}};
	}
}
