package lee.code.customitems;

import lee.code.customitems.lists.items.*;
import lombok.Getter;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Data {

    @Getter private final List<NamespacedKey> recipeKeys = new ArrayList<>();

    public void loadRecipes() {
        GoldmanCustomItems plugin = GoldmanCustomItems.getPlugin();

        int number = 0;
        for (String cItem : plugin.getPU().recipes()) {

            boolean shaped = false;
            String shape = null;
            ItemStack customItem = null;
            String recipeItemIDs = null;
            int[] recipeAmount = null;
            String group = null;
            boolean exact = false;

            if (plugin.getPU().getCraftingItems().contains(cItem)) {
                CraftingItems item = CraftingItems.valueOf(cItem);
                shaped = item.isShaped();
                shape = item.getShape();
                customItem = item.getCustomItem();
                recipeItemIDs = item.getRecipeItemIDs();
                recipeAmount = item.getRecipeAmount();
                group = item.getGroup();
                exact = item.isExact();
            } else if (plugin.getPU().getCraftingTools().contains(cItem)) {
                CraftingTools item = CraftingTools.valueOf(cItem);
                shaped = item.isShaped();
                shape = item.getShape();
                customItem = item.getCustomItem();
                recipeItemIDs = item.getRecipeItemIDs();
                recipeAmount = item.getRecipeAmount();
                group = item.getGroup();
                exact = item.isExact();
            } else if (plugin.getPU().getCraftingArmor().contains(cItem)) {
                CraftingArmor item = CraftingArmor.valueOf(cItem);
                shaped = item.isShaped();
                shape = item.getShape();
                customItem = item.getCustomItem();
                recipeItemIDs = item.getRecipeItemIDs();
                recipeAmount = item.getRecipeAmount();
                group = item.getGroup();
                exact = item.isExact();
            }

            NamespacedKey key = new NamespacedKey(plugin, cItem);

            if (shaped) {
                ShapedRecipe recipe = new ShapedRecipe(key, customItem);
                String[] shapeSplit = StringUtils.split(shape, ',');
                recipe.shape(shapeSplit[0], shapeSplit[1], shapeSplit[2]);

                String[] recipeIDSplit = StringUtils.split(recipeItemIDs, ',');

                for (String rID : recipeIDSplit) {
                    char cKey = rID.charAt(0);
                    if (!exact) recipe.setIngredient(cKey, RecipeMaterials.valueOf(rID).getMaterial());
                    else recipe.setIngredient(cKey, new RecipeChoice.ExactChoice(RecipeItemStacks.valueOf(rID).getItem()));
                }
                if (group != null) recipe.setGroup(group);
                Bukkit.addRecipe(recipe);
                number++;
            } else {
                if (customItem != null) {
                    ShapelessRecipe recipe = new ShapelessRecipe(key, customItem);
                    String[] recipeIDSplit = StringUtils.split(recipeItemIDs, ',');

                    int recipeOrder = 0;
                    for (String rID : recipeIDSplit) {
                        recipe.addIngredient(recipeAmount[recipeOrder], RecipeMaterials.valueOf(rID).getMaterial());
                        recipeOrder++;
                    }
                    if (group != null) recipe.setGroup(group);
                    Bukkit.addRecipe(recipe);
                    number++;
                }
            }
        }

        for (String cItem : plugin.getPU().getFurnaceItems()) {
            FurnaceItems item = FurnaceItems.valueOf(cItem);
            NamespacedKey key = new NamespacedKey(plugin, cItem);
            FurnaceRecipe recipe = new FurnaceRecipe(key, item.getCustomItem(), item.getSource(), item.getCookTime(), item.getCookTime());
            Bukkit.addRecipe(recipe);
            number++;
        }

        System.out.println(plugin.getPU().format("&2Custom Item Recipes Loaded: &a" + number));
    }

    public void loadRegisteredRecipes() {
        Iterator<Recipe> it = Bukkit.getServer().recipeIterator();
        it.forEachRemaining(recipe -> {
            if (recipe instanceof ShapelessRecipe) {
                ShapelessRecipe shapelessRecipe = (ShapelessRecipe) recipe;
                recipeKeys.add(shapelessRecipe.getKey());
            } else if (recipe instanceof ShapedRecipe) {
                ShapedRecipe shapedRecipe = (ShapedRecipe) recipe;
                recipeKeys.add(shapedRecipe.getKey());
            } else if (recipe instanceof BlastingRecipe) {
                BlastingRecipe shapedRecipe = (BlastingRecipe) recipe;
                recipeKeys.add(shapedRecipe.getKey());
            } else if (recipe instanceof CampfireRecipe) {
                CampfireRecipe shapedRecipe = (CampfireRecipe) recipe;
                recipeKeys.add(shapedRecipe.getKey());
            } else if (recipe instanceof FurnaceRecipe) {
                FurnaceRecipe shapedRecipe = (FurnaceRecipe) recipe;
                recipeKeys.add(shapedRecipe.getKey());
            } else if (recipe instanceof SmithingRecipe) {
                SmithingRecipe shapedRecipe = (SmithingRecipe) recipe;
                recipeKeys.add(shapedRecipe.getKey());
            } else if (recipe instanceof SmokingRecipe) {
                SmokingRecipe shapedRecipe = (SmokingRecipe) recipe;
                recipeKeys.add(shapedRecipe.getKey());
            } else if (recipe instanceof StonecuttingRecipe) {
                StonecuttingRecipe shapedRecipe = (StonecuttingRecipe) recipe;
                recipeKeys.add(shapedRecipe.getKey());
            }
        });
    }
}
