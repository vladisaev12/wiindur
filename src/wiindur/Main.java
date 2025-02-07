package wiindur;

import arc.util.Log;
import mindustry.mod.Mod;
import wiindur.content.WBlocks;
import wiindur.content.WLiquids;

public class Main extends Mod {
   public Main() {}

   public void loadContent() {
      WLiquids.load();
      WBlocks.load();
      Log.info("Loaded wiindur's Content.");
   }
}
