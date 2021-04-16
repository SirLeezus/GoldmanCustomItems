package lee.code.customitems.lists.items;

import lee.code.customitems.GoldmanCustomItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

@AllArgsConstructor
public enum CraftingArmor {

    EMERALD_HELMET("&fEmerald Helmet", "AAA,A A,   ", new ItemStack(Material.DIAMOND_HELMET), "A", true, null, null, false, 1003, EquipmentSlot.HEAD, 3, 2, 0, 0, 1),
    EMERALD_CHESTPLATE("&fEmerald Chestplate", "A A,AAA,AAA", new ItemStack(Material.DIAMOND_CHESTPLATE), "A", true, null, null, false, 1002, EquipmentSlot.CHEST, 8, 2, 0, 0, 1),
    EMERALD_LEGGINGS("&fEmerald Leggings", "AAA,A A,A A", new ItemStack(Material.DIAMOND_LEGGINGS), "A", true, null, null, false, 1001, EquipmentSlot.LEGS, 6, 2, 0, 0, 1),
    EMERALD_BOOTS("&fEmerald Boots", "   ,A A,A A", new ItemStack(Material.DIAMOND_BOOTS), "A", true, null, null, false, 1000, EquipmentSlot.FEET, 3, 2, 0, 0, 1),

    CRYING_OBSIDIAN_HELMET("&fCrying Obsidian Helmet", "BBB,B B,   ", new ItemStack(Material.NETHERITE_HELMET), "B", true, null, null, false, 1007, EquipmentSlot.HEAD, 3, 3, 1, -0.01, 0),
    CRYING_OBSIDIAN_CHESTPLATE("&fCrying Obsidian Chestplate", "B B,BBB,BBB", new ItemStack(Material.NETHERITE_CHESTPLATE), "B", true, null, null, false, 1006, EquipmentSlot.CHEST, 8, 3, 1, -0.01, 0),
    CRYING_OBSIDIAN_LEGGINGS("&fCrying Obsidian Leggings", "BBB,B B,B B", new ItemStack(Material.NETHERITE_LEGGINGS), "B", true, null, null, false, 1005, EquipmentSlot.LEGS, 6, 3, 1, -0.01, 0),
    CRYING_OBSIDIAN_BOOTS("&fCrying Obsidian Boots", "   ,B B,B B", new ItemStack(Material.NETHERITE_BOOTS), "B", true, null, null, false, 1004, EquipmentSlot.FEET, 3, 3, 1, -0.01, 0),

    REDSTONE_RUBY_HELMET("&fRedstone Ruby Helmet", "AAA,A A,   ", new ItemStack(Material.DIAMOND_HELMET), "A", true, null, null, true, 1008, EquipmentSlot.HEAD, 4, 3, 0, 0.02, 0),
    REDSTONE_RUBY_CHESTPLATE("&fRedstone Ruby Chestplate", "A A,AAA,AAA", new ItemStack(Material.DIAMOND_CHESTPLATE), "A", true, null, null, true, 1009, EquipmentSlot.CHEST, 9, 3, 0, 0.02, 0),
    REDSTONE_RUBY_LEGGINGS("&fRedstone Ruby Leggings", "AAA,A A,A A", new ItemStack(Material.DIAMOND_LEGGINGS), "A", true, null, null, true, 1010, EquipmentSlot.LEGS, 7, 3, 0, 0.02, 0),
    REDSTONE_RUBY_BOOTS("&fRedstone Ruby Boots", "   ,A A,A A", new ItemStack(Material.DIAMOND_BOOTS), "A", true, null, null, true, 1011, EquipmentSlot.FEET, 4, 3, 0, 0.02, 0),

    LAPIS_SAPPHIRE_HELMET("&fLapis Sapphire Helmet", "CCC,C C,   ", new ItemStack(Material.DIAMOND_HELMET), "C", true, null, null, true, 1012, EquipmentSlot.HEAD, 4, 3, 0, 0.02, 0),
    LAPIS_SAPPHIRE_CHESTPLATE("&fLapis Sapphire Chestplate", "C C,CCC,CCC", new ItemStack(Material.DIAMOND_CHESTPLATE), "C", true, null, null, true, 1013, EquipmentSlot.CHEST, 9, 3, 0, 0.02, 0),
    LAPIS_SAPPHIRE_LEGGINGS("&fLapis Sapphire Leggings", "CCC,C C,C C", new ItemStack(Material.DIAMOND_LEGGINGS), "C", true, null, null, true, 1014, EquipmentSlot.LEGS, 7, 3, 0, 0.02, 0),
    LAPIS_SAPPHIRE_BOOTS("&fLapis Sapphire Boots", "   ,C C,C C", new ItemStack(Material.DIAMOND_BOOTS), "C", true, null, null, true, 1015, EquipmentSlot.FEET, 4, 3, 0, 0.02, 0),

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
    @Getter private final EquipmentSlot slot;
    @Getter private final double armor;
    @Getter private final double toughness;
    @Getter private final double knockback;
    @Getter private final double speed;
    @Getter private final double luck;


    public ItemStack getCustomItem() {
        GoldmanCustomItems plugin = GoldmanCustomItems.getPlugin();
        ItemStack customItem = new ItemStack(item);
        ItemMeta itemMeta = customItem.getItemMeta();
        itemMeta.displayName(plugin.getPU().formatC(name));
        itemMeta.setCustomModelData(id);
        if (armor != 0) itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", armor, AttributeModifier.Operation.ADD_NUMBER, slot));
        if (toughness != 0) itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(),"generic.armorToughness", toughness, AttributeModifier.Operation.ADD_NUMBER, slot));
        if (knockback != 0) itemMeta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "generic.knockbackResistance", knockback, AttributeModifier.Operation.ADD_NUMBER, slot));
        if (speed != 0) itemMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed", speed, AttributeModifier.Operation.ADD_NUMBER, slot));
        if (luck != 0) itemMeta.addAttributeModifier(Attribute.GENERIC_LUCK, new AttributeModifier(UUID.randomUUID(), "generic.luck", luck, AttributeModifier.Operation.ADD_NUMBER, slot));
        customItem.setItemMeta(itemMeta);
        return customItem;
    }
}
