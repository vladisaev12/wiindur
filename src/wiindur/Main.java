package wiindur;

import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;
import wiindur.content.Blocks;

public class Main extends Mod {
   public Main() {
      Log.info("Loaded wiindur.");
      Events.on(ClientLoadEvent.class, (e) -> {
         Time.runTask(10.0F, () -> {
            BaseDialog dialog = new BaseDialog("wall");
            dialog.cont.add("wall").row();
            dialog.cont.image(Core.atlas.find("wiindur-template-wall")).pad(20.0F).row();
            dialog.cont.button("I see", dialog::hide).size(100f, 50f);
            dialog.show();
         });
      });
   }

   public void loadContent() {
      Blocks.load();
      Log.info("Loaded wiindur's Content.");
   }
}
