package de.deda.exnihilo;

import de.deda.exnihilo.listener.BlockBreakListener;
import de.deda.exnihilo.listener.BlockPlaceListener;
import de.deda.exnihilo.listener.PlayerInteractListener;
import de.deda.exnihilo.utils.ItemBuilder;
import de.deda.exnihilo.utils.RecipeCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExNihilo extends JavaPlugin {

    private static ExNihilo plugin;

    @Override
    public void onEnable() {
        plugin = this;
        addRecipes();

        // How to exportieren das Plugin
        // Maven (rechts, ist von oben nach unten geschrieben so: // M
        //                                                        // A
        //                                                        // V
        //                                                        // E
        //                                                        // N)
        // dann auf "LifeCycle" und doppelklick auf "package"
        // Plugin wird automatisch in dne plugin ordner exportiert

        // register events
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);


    }

    @Override
    public void onDisable() {

    }

    private void addRecipes() {
        // Crook
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.WOODEN_HOE).setDisplayName("§fCrook").addPersistentData("crook", 1).build(), "crook").setShape("SS ", " S "," S ").setIngredient('S', Material.STICK).getRecipe());
        // Wooden Shears
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.SHEARS).setDisplayName("§fWooden shears").addPersistentData("wooden_shears", 1).build(), "wooden_shears_top").setShape(" W ", "W  ","   ").setIngredient('W', new RecipeChoice.MaterialChoice(Tag.PLANKS)).getRecipe());
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.SHEARS).setDisplayName("§fWooden shears").addPersistentData("wooden_shears", 1).build(), "wooden_shears_right").setShape("  W", " W ","   ").setIngredient('W', new RecipeChoice.MaterialChoice(Tag.PLANKS)).getRecipe());
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.SHEARS).setDisplayName("§fWooden shears").addPersistentData("wooden_shears", 1).build(), "wooden_shears_left").setShape("   ", " W ","W  ").setIngredient('W', new RecipeChoice.MaterialChoice(Tag.PLANKS)).getRecipe());
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.SHEARS).setDisplayName("§fWooden shears").addPersistentData("wooden_shears", 1).build(), "wooden_shears_bottom").setShape("   ", "  W"," W ").setIngredient('W', new RecipeChoice.MaterialChoice(Tag.PLANKS)).getRecipe());
        // Composter
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.COMPOSTER).setDisplayName("§fComposter").addPersistentData("composter_item", 1).build(), "composter").setShape("W W", "W W", "WSW").setIngredient('W', new RecipeChoice.MaterialChoice(Tag.PLANKS)).setIngredient('S', new RecipeChoice.MaterialChoice(Tag.WOODEN_SLABS)).getRecipe());
        // Wooden Crucible
        Bukkit.addRecipe(new RecipeCreator(new ItemBuilder(Material.CAULDRON).setDisplayName("§fWooden crucible").addPersistentData("wooden_crucible_item", 1).build(), "wooden_crucible").setShape("L L", "LHL","S S").setIngredient('L', new RecipeChoice.MaterialChoice(Tag.LOGS)).setIngredient('H', new RecipeChoice.MaterialChoice(Tag.WOODEN_SLABS)).setIngredient('S', Material.STICK).getRecipe());


    }

    public static ExNihilo getPlugin() {
        return plugin;
    }

}
