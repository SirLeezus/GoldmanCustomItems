package lee.code.customitems.lists.items;

import lee.code.customitems.GoldmanCustomItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@AllArgsConstructor
public enum FurnaceItems {

    REDSTONE_RUBY("&fRedstone Ruby", new ItemStack(Material.CLOCK), Material.REDSTONE_BLOCK, (float) 1, 300, 3000),
    LAPIS_SAPPHIRE("&fLapis Sapphire", new ItemStack(Material.CLOCK), Material.LAPIS_BLOCK, (float) 1, 300, 3001),

    ;

    @Getter private final String name;
    @Getter private final ItemStack item;
    @Getter private final Material source;
    @Getter private final float experience;
    @Getter private final int cookTime;
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
