package wiindur.content;

import static mindustry.type.ItemStack.with;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.UnitTypes;
import mindustry.gen.Sounds;
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

      steamGenerator = new GenericCrafter("steam-generator"){{
         requirements(Category.crafting, with(Items.copper, 25, Items.lead, 20));
         health = 200;
         size = 2;
         outputLiquid = new LiquidStack(WLiquids.steam, 12f / 60f);

         craftTime = 20f;
         hasLiquids = true;
         hasPower = false;

         consumeItem(Items.coal, 1);
         consumeLiquid(Liquids.water, 6f / 60f);
      }};

      coreWild = new CoreBlock("core-wild"){{
         requirements(Category.effect, with(Items.copper, 1000, Items.lead, 800));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = UnitTypes.alpha;
            health = 1100;
            itemCapacity = 4000;
            size = 3;
            buildCostMultiplier = 2f;

            unitCapModifier = 32;
      }};
   }
}
