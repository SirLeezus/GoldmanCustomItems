package lee.code.customitems.lists.items;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public enum RecipeItemStacks {

    A(FurnaceItems.REDSTONE_RUBY.getCustomItem()),
    B(new ItemStack(Material.STICK)),
    C(FurnaceItems.LAPIS_SAPPHIRE.getCustomItem()),
    ;

    @Getter private final ItemStack item;
}
