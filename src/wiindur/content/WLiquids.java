package wiindur.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class WLiquids {
    public static Liquid steam;

    public static void load(){
        steam = new Liquid("steam", Color.gray){{
            // heatCapacity = 10f;
            lightColor = Color.gray;
            gas = true;
            barColor = gasColor = lightColor;
            hidden = false;
        }};
    };
}
