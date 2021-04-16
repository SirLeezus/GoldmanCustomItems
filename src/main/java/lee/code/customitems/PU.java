package lee.code.customitems;

import lee.code.customitems.lists.items.*;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class PU {

    public String format(String format) {
        return ChatColor.translateAlternateColorCodes('&', format);
    }

    public List<String> recipes() {
        List<String> list = new ArrayList<>();
        list.addAll(getCraftingItems());
        list.addAll(getCraftingTools());
        list.addAll(getCraftingArmor());
        return list;
    }

    public Component formatC(String message) {
        LegacyComponentSerializer serializer = LegacyComponentSerializer.legacyAmpersand();
        return Component.empty().decoration(TextDecoration.ITALIC, false).append(serializer.deserialize(message));
    }

    public List<String> getCraftingArmor() {
        return EnumSet.allOf(CraftingArmor.class).stream().map(CraftingArmor::name).collect(Collectors.toList());
    }

    public List<String> getCraftingTools() {
        return EnumSet.allOf(CraftingTools.class).stream().map(CraftingTools::name).collect(Collectors.toList());
    }

    public List<String> getNoRecipeItems() {
        return EnumSet.allOf(NoRecipeItems.class).stream().map(NoRecipeItems::name).collect(Collectors.toList());
    }

    public List<String> getCraftingItems() {
        return EnumSet.allOf(CraftingItems.class).stream().map(CraftingItems::name).collect(Collectors.toList());
    }

    public List<String> getFurnaceItems() {
        return EnumSet.allOf(FurnaceItems.class).stream().map(FurnaceItems::name).collect(Collectors.toList());
    }
}
