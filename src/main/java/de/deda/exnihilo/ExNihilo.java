package de.deda.exnihilo;

import de.deda.exnihilo.listener.BlockBreakListener;
import de.deda.exnihilo.listener.BlockPlaceListener;
import de.deda.exnihilo.listener.PlayerBucketListener;
import de.deda.exnihilo.listener.PlayerInteractListener;
import de.deda.exnihilo.utils.ItemBuilder;
import de.deda.exnihilo.utils.RecipeCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.event.Listener;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExNihilo extends JavaPlugin implements Listener {

    private static ExNihilo plugin;

    @Override
    public void onEnable() {
        plugin = this;


        // How to exportieren das Plugin
        // Maven (rechts, ist von oben nach unten geschrieben so: // M
        //                                                        // A
        //                                                        // V
        //                                                        // E
        //                                                        // N)
        // dann auf "LifeCycle" und doppelklick auf "package"
        // Plugin wird automatisch in dne plugin ordner exportiert

        addRecipes();

        // register events
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerBucketListener(), this);


    }

    @Override
    public void onDisable() {

    }

    private void addRecipes() {
        // Crook
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.WOODEN_HOE).setDisplayName("§fCrook").addPersistentData("crook", 1).build(), "crook").setShape("SS ", " S "," S ").setIngredient('S', Material.STICK).getShapedRecipe());
        // Wooden shears
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.SHEARS).setDisplayName("§fWooden shears").addPersistentData("wooden_shears", 1).build(), "wooden_shears_top").setShape(" W ", "W  ","   ").setIngredient('W', new RecipeChoice.MaterialChoice(Tag.PLANKS)).getShapedRecipe());
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.SHEARS).setDisplayName("§fWooden shears").addPersistentData("wooden_shears", 1).build(), "wooden_shears_right").setShape("  W", " W ","   ").setIngredient('W', new RecipeChoice.MaterialChoice(Tag.PLANKS)).getShapedRecipe());
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.SHEARS).setDisplayName("§fWooden shears").addPersistentData("wooden_shears", 1).build(), "wooden_shears_left").setShape("   ", " W ","W  ").setIngredient('W', new RecipeChoice.MaterialChoice(Tag.PLANKS)).getShapedRecipe());
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.SHEARS).setDisplayName("§fWooden shears").addPersistentData("wooden_shears", 1).build(), "wooden_shears_bottom").setShape("   ", "  W"," W ").setIngredient('W', new RecipeChoice.MaterialChoice(Tag.PLANKS)).getShapedRecipe());
        // Composter
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.COMPOSTER).setDisplayName("§fComposter").addPersistentData("composter_item", 1).build(), "composter").setShape("W W", "W W", "WSW").setIngredient('W', new RecipeChoice.MaterialChoice(Tag.PLANKS)).setIngredient('S', new RecipeChoice.MaterialChoice(Tag.WOODEN_SLABS)).getShapedRecipe());
        // Hammer
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.WOODEN_PICKAXE).setDisplayName("§fWooden hammer").addPersistentData("wooden_hammer", 1).build(), "wooden_hammer").setShape(" W ", " SW", "S  ").setIngredient('W', new RecipeChoice.MaterialChoice(Tag.PLANKS)).setIngredient('S', Material.STICK).getShapedRecipe());
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.STONE_PICKAXE).setDisplayName("§fStone hammer").addPersistentData("stone_hammer", 1).build(), "stone_hammer").setShape(" C ", " SC", "S  ").setIngredient('C', Material.COBBLESTONE).setIngredient('S', Material.STICK).getShapedRecipe());
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.IRON_PICKAXE).setDisplayName("§fIron hammer").addPersistentData("iron_hammer", 1).build(), "iron_hammer").setShape(" I ", " SI", "S  ").setIngredient('I', Material.IRON_INGOT).setIngredient('S', Material.STICK).getShapedRecipe());
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.GOLDEN_PICKAXE).setDisplayName("§fGolden hammer").addPersistentData("golden_hammer", 1).build(), "golden_hammer").setShape(" G ", " SG", "S  ").setIngredient('G', Material.GOLD_INGOT).setIngredient('S', Material.STICK).getShapedRecipe());
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName("§fDiamond hammer").addPersistentData("diamond_hammer", 1).build(), "diamond_hammer").setShape(" D ", " SD", "S  ").setIngredient('D', Material.DIAMOND).setIngredient('S', Material.STICK).getShapedRecipe());
        // Netherite hammer
        // funktioniert nicht ganz, name bleibt gleich
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.NETHERITE_PICKAXE).setDisplayName("§fNetherite hammer").addPersistentData("netherite_hammer", 1).build(), "netherite_hammer", new RecipeChoice.ExactChoice(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayName("§fDiamond hammer").addPersistentData("diamond_hammer", 1).build()), new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT)).getSmithingRecipe());

        // Wooden crucible
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.CAULDRON).setDisplayName("§fWooden crucible").addPersistentData("wooden_crucible_item", 1).build(), "wooden_crucible").setShape("L L", "LHL", "S S").setIngredient('L', new RecipeChoice.MaterialChoice(Tag.LOGS)).setIngredient('H', new RecipeChoice.MaterialChoice(Tag.WOODEN_SLABS)).setIngredient('S', Material.STICK).getShapedRecipe());
        // Crucible
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.CAULDRON).setDisplayName("§fCrucible").addPersistentData("crucible_item", 1).build(), "crucible").setShape("P P", "P P", "PPP").setIngredient('P', new RecipeChoice.ExactChoice(new ItemBuilder(Material.CLAY_BALL).setDisplayName("§fPorcelain clay").addPersistentData("porcelain_clay", 1).build())).getShapedRecipe());
        // clay bucket
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.BUCKET).setDisplayName("§fClay bucket").addPersistentData("clay_bucket", 1).build(), "clay_bucket_top").setShape("C C", " C ", "   ").setIngredient('C', Material.CLAY_BALL).getShapedRecipe());
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.BUCKET).setDisplayName("§fClay bucket").addPersistentData("clay_bucket", 1).build(), "clay_bucket_bottom").setShape("   ", "C C", " C ").setIngredient('C', Material.CLAY_BALL).getShapedRecipe());
        // porcelain clay
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.CLAY_BALL).setDisplayName("§fPorcelain clay").addPersistentData("porcelain_clay", 1).build(), "porcelain_clay").setShape("CB ", "   ", "   ").setIngredient('C', Material.CLAY_BALL).setIngredient('B', Material.BONE_MEAL).getShapedRecipe());



    }

    public static ExNihilo getPlugin() {
        return plugin;
    }

}
