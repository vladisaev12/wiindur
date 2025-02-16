package wiindur;

import arc.util.Log;
import mindustry.mod.Mod;
import wiindur.content.WBlocks;
import wiindur.content.WLiquids;
import wiindur.content.WPlanets;
// import wiindur.content.WUnitTypes;
import wiindur.content.WTechTree;

public class Main extends Mod {
   public Main() {}

   public void loadContent() {
      WLiquids.load();
      // WUnitTypes.load();
      // Blocks goes after units, items, liquids(and gases),  bullets
      WBlocks.load();
      WPlanets.load();
      WTechTree.load();
      Log.info("Loaded wiindur's Content.");
   }
}
