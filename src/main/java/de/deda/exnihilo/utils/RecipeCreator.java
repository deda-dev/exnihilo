package de.deda.exnihilo.utils;

import de.deda.exnihilo.ExNihilo;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.SmithingRecipe;

public class RecipeCreator {

    private ShapedRecipe shapedRecipe;
    private SmithingRecipe smithingRecipe;

    public RecipeCreator(ItemStack result, String key) {
        NamespacedKey namespacedKey = new NamespacedKey(ExNihilo.getPlugin(), key);
        shapedRecipe = new ShapedRecipe(namespacedKey, result);
    }

    public RecipeCreator setShape(String... slots) {
        shapedRecipe.shape(slots);
        return this;
    }

    public RecipeCreator setIngredient(char key, Material ingredient) {
        shapedRecipe.setIngredient(key, ingredient);
        return this;
    }

    public RecipeCreator setIngredient(char key, RecipeChoice choice) {
        shapedRecipe.setIngredient(key, choice);
        return this;
    }

    public ShapedRecipe getShapedRecipe() {
        return shapedRecipe;
    }

    public RecipeCreator(ItemStack result, String key, RecipeChoice base, RecipeChoice addition) {
        NamespacedKey namespacedKey = new NamespacedKey(ExNihilo.getPlugin(), key);
        smithingRecipe = new SmithingRecipe(namespacedKey, result, base, addition);
    }

    public SmithingRecipe getSmithingRecipe() {
        return smithingRecipe;
    }

}
