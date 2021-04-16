package lee.code.customitems.lists.items;

import lee.code.customitems.GoldmanCustomItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
@AllArgsConstructor
public enum NoRecipeItems {

    //WEAPONS
    AZURE_GREATSWORD("&6&lAzure Greatsword", Material.NETHERITE_SWORD, 4000),
    DRAGON_SLAYER("&c&lDragon Slayer", Material.NETHERITE_SWORD, 4001),

    //ELYTRAA

    ;

    @Getter private final String name;
    @Getter private final Material material;
    @Getter private final int id;

    public ItemStack getCustomItem() {
        GoldmanCustomItems plugin = GoldmanCustomItems.getPlugin();
        ItemStack customItem = new ItemStack(material);
        ItemMeta itemMeta = customItem.getItemMeta();
        if (name != null) itemMeta.displayName(plugin.getPU().formatC(name));
        if(id != -1) itemMeta.setCustomModelData(id);
        customItem.setItemMeta(itemMeta);
        return customItem;
    }
}

