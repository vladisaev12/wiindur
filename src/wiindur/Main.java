package wiindur;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

@SuppressWarnings("unused")
public class Main extends Mod{

    public Main(){
        Log.info("Loaded wiindur.");
        Events.on(ClientLoadEvent.class, e -> {
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("wall");
                dialog.cont.add("wall").row();
                dialog.cont.image(Core.atlas.find("wiindur-steam-generator")).pad(20f).row();
                dialog.cont.button("ok", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        Log.info("Loaded wiindur's Content.");
    }

}
