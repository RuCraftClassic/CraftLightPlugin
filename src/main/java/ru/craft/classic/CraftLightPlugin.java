package ru.craft.classic;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

public class CraftLightPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        addRecipe();
        getLogger().info("CraftLightPlugin включён: рецепт блока света добавлен");
    }

    private void addRecipe() {
        ItemStack result = new ItemStack(Material.LIGHT, 4);

        // зелье невидимости
        ItemStack invisPotion = new ItemStack(Material.POTION);
        PotionMeta potionMeta = (PotionMeta) invisPotion.getItemMeta();
        potionMeta.setBasePotionType(PotionType.INVISIBILITY); // обычное зелье невидимости
        invisPotion.setItemMeta(potionMeta);

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "light_block_exact"), result);
        recipe.shape("GGG", "GTG", "GIG");
        recipe.setIngredient('G', Material.GLASS);
        recipe.setIngredient('T', Material.TORCH);
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(invisPotion)); // строго это зелье

        Bukkit.addRecipe(recipe);
    }
}
