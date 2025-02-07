package wiindur.content;

import static mindustry.type.ItemStack.with;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.draw.DrawDefault;
// import mindustry.world.draw.DrawLiquidRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;

public class WBlocks {
   public static Block
   // walls
   templateWall,
   // power generation
   steamTurbine;

   public static void load() {
      final int wallHealthMultiplier = 4;
      templateWall = new Wall("template-wall") {
         {
            this.requirements(Category.defense, ItemStack.with(new Object[]{Items.copper, 6}));
            this.health = 80 * wallHealthMultiplier;
         }
      };

      steamTurbine = new ConsumeGenerator("steam-turbine"){{
         requirements(Category.power, with(Items.copper, 20, Items.lead, 20));
         powerProduction = 1.5f;
         hasLiquids = false;
         hasItems = false;
         size = 3;
         generateEffect = Fx.generatespark;
         ambientSound = Sounds.smelter;
         ambientSoundVolume = 0.06f;

         consumeLiquid(WLiquids.steam, 0.1f);

         drawer = new DrawMulti(
            new DrawDefault(),
            // new DrawWarmupRegion(),
            new DrawRegion("-wings"){{
                rotateSpeed = -4f;
            }}
            // new DrawLiquidRegion()
            );
      }};
   }
}
