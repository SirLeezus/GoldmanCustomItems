package lee.code.customitems.lists.items;

import lee.code.customitems.GoldmanCustomItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@AllArgsConstructor
public enum CraftingItems {

    //ELYTRA
    ELYTRA(null, "UVU,UWU,U U", new ItemStack(Material.ELYTRA), "U,V,W", true, null, null, false, -1),
    ELYTRA_BLACK("&eBlack Elytra", null, new ItemStack(Material.ELYTRA), "C,T", false, new int[] {1, 1}, "coloredElytra", false, 1),
    ELYTRA_BLUE("&eBlue Elytra", null, new ItemStack(Material.ELYTRA), "O,T", false, new int[] {1, 1}, "coloredElytra", false,2),
    ELYTRA_BROWN("&eBrown Elytra", null, new ItemStack(Material.ELYTRA), "P,T", false, new int[] {1, 1}, "coloredElytra", false, 3),
    ELYTRA_CYAN("&eCyan Elytra", null, new ItemStack(Material.ELYTRA), "M,T", false, new int[] {1, 1}, "coloredElytra", false, 4),
    ELYTRA_GRAY("&eGray Elytra", null, new ItemStack(Material.ELYTRA), "K,T", false, new int[] {1, 1}, "coloredElytra", false, 5),
    ELYTRA_GREEN("&eGreen Elytra", null, new ItemStack(Material.ELYTRA), "Q,T", false, new int[] {1, 1}, "coloredElytra", false, 6),
    ELYTRA_LIGHT_BLUE("&eLight Blue Elytra", null, new ItemStack(Material.ELYTRA), "G,T", false, new int[] {1, 1}, "coloredElytra", false, 7),
    ELYTRA_LIGHT_GRAY("&eLight Gray Elytra", null, new ItemStack(Material.ELYTRA), "L,T", false, new int[] {1, 1}, "coloredElytra", false,8),
    ELYTRA_LIME("&eLime Elytra", null, new ItemStack(Material.ELYTRA), "I,T", false, new int[] {1, 1}, "coloredElytra", false,  9),
    ELYTRA_MAGENTA("&eMagenta Elytra", null, new ItemStack(Material.ELYTRA), "F,T", false, new int[] {1, 1}, "coloredElytra", false, 10),
    ELYTRA_ORANGE("&eOrange Elytra", null, new ItemStack(Material.ELYTRA), "E,T", false, new int[] {1, 1}, "coloredElytra", false, 11),
    ELYTRA_PINK("&ePink Elytra", null, new ItemStack(Material.ELYTRA), "J,T", false, new int[] {1, 1}, "coloredElytra", false, 12),
    ELYTRA_PURPLE("&ePurple Elytra", null, new ItemStack(Material.ELYTRA), "N,T", false, new int[] {1, 1}, "coloredElytra", false, 13),
    ELYTRA_RED("&eRed Elytra", null, new ItemStack(Material.ELYTRA), "R,T", false, new int[] {1, 1}, "coloredElytra", false, 14),
    ELYTRA_WHITE("&eWhite Elytra", null, new ItemStack(Material.ELYTRA), "D,T", false, new int[] {1, 1}, "coloredElytra", false,  15),
    ELYTRA_YELLOW("&eYellow Elytra", null, new ItemStack(Material.ELYTRA), "H,T", false, new int[] {1, 1}, "coloredElytra", false, 16),
    ;

    @Getter private final String name;
    @Getter private final String shape;
    @Getter private final ItemStack item;
    @Getter private final String recipeItemIDs;
    @Getter private final boolean shaped;
    @Getter private final int[] recipeAmount;
    @Getter private final String group;
    @Getter private final boolean exact;
    @Getter private final int id;

    public ItemStack getCustomItem() {
        GoldmanCustomItems plugin = GoldmanCustomItems.getPlugin();
        ItemStack customItem = new ItemStack(item);
        ItemMeta itemMeta = customItem.getItemMeta();
        if (name != null) itemMeta.displayName(plugin.getPU().formatC(name));
        if(id != -1) itemMeta.setCustomModelData(id);
        customItem.setItemMeta(itemMeta);
        return customItem;
    }
}
