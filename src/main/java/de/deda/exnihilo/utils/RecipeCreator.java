package de.deda.exnihilo.utils;

import de.deda.exnihilo.ExNihilo;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class RecipeCreator {

    private ShapedRecipe recipe;

    public RecipeCreator(ItemStack result, String key) {
        NamespacedKey namespacedKey = new NamespacedKey(ExNihilo.getPlugin(), key);
        recipe = new ShapedRecipe(namespacedKey, result);
    }

    public RecipeCreator setShape(String... slots) {
        recipe.shape(slots);
        return this;
    }

    public RecipeCreator setIngredient(char key, Material ingredient) {
        recipe.setIngredient(key, ingredient);
        return this;
    }

    public RecipeCreator setIngredient(char key, RecipeChoice choice) {
        recipe.setIngredient(key, choice);
        return this;
    }

    public ShapedRecipe getRecipe() {
        return recipe;
    }

}
