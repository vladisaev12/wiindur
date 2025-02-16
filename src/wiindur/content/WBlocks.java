package wiindur.content;

import static mindustry.type.ItemStack.with;

import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.UnitTypes;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;

public class WBlocks {
   public static Block
   // walls
   templateWall,
   // power generation
   steamTurbine,
   // production
   steamGenerator,
   // storage(and cores)
   coreWild;

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
         ambientSoundVolume = 0.06f;

         consumeLiquid(WLiquids.steam, 30f / 60f);

         drawer = new DrawMulti(
            new DrawDefault(),
            new DrawRegion("-wings"){{
                rotateSpeed = -4f;
            }}
         );
      }};

      steamGenerator = new GenericCrafter("steam-generator"){{
         requirements(Category.crafting, with(Items.copper, 25, Items.lead, 20));
         health = 200;
         size = 2;
         outputLiquid = new LiquidStack(WLiquids.steam, 60f / 60f);

         craftTime = 30f;
         hasLiquids = true;
         hasPower = false;

         consumeItem(Items.coal, 1);
         consumeLiquid(Liquids.water, 6f / 60f);
      }};

      coreWild = new CoreBlock("core-wild"){{
         requirements(Category.effect, with(Items.graphite, 800));
			size = 3;
			health = 2000;
			alwaysUnlocked = true;
			unitType = UnitTypes.alpha;
			itemCapacity = 1000;
			unitCapModifier = 12;
      }};
   }
}
