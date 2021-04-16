package lee.code.customitems.lists.items;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;

@AllArgsConstructor
public enum RecipeMaterials {

    A(Material.EMERALD),
    B(Material.CRYING_OBSIDIAN),
    C(Material.BLACK_DYE),
    D(Material.WHITE_DYE),
    E(Material.ORANGE_DYE),
    F(Material.MAGENTA_DYE),
    G(Material.LIGHT_BLUE_DYE),
    H(Material.YELLOW_DYE),
    I(Material.LIME_DYE),
    J(Material.PINK_DYE),
    K(Material.GRAY_DYE),
    L(Material.LIGHT_GRAY_DYE),
    M(Material.CYAN_DYE),
    N(Material.PURPLE_DYE),
    O(Material.BLUE_DYE),
    P(Material.BROWN_DYE),
    Q(Material.GREEN_DYE),
    R(Material.RED_DYE),
    S(Material.BLACK_DYE),
    T(Material.ELYTRA),
    U(Material.FEATHER),
    V(Material.STRING),
    W(Material.ENDER_PEARL),
    X(Material.REDSTONE),
    ;

    @Getter private final Material material;
}
