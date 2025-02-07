package wiindur.content;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;

public class Blocks {
   public static Block templateWall;

   public static void load() {
      final int wallHealthMultiplier = 4;
      templateWall = new Wall("template-wall") {
         {
            this.requirements(Category.defense, ItemStack.with(new Object[]{Items.copper, 6}));
            this.health = 80 * wallHealthMultiplier;
         }
      };
   }
}
