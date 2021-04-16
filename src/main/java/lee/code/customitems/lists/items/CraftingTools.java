package lee.code.customitems.lists.items;

import lee.code.customitems.GoldmanCustomItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@AllArgsConstructor
public enum CraftingTools {

    REDSTONE_RUBY_SWORD("&fRedstone Ruby Sword", " A , A , B ", new ItemStack(Material.IRON_SWORD), "A,B", true, null, null, true, 2000),
    LAPIS_SAPPHIRE_SWORD("&fLapis Sapphire Sword", " C , C , B ", new ItemStack(Material.IRON_SWORD), "C,B", true, null, null, true, 2001),
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
