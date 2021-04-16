package lee.code.customitems.listeners;

import lee.code.customitems.GoldmanCustomItems;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoinRecipeUnlock(PlayerJoinEvent e) {
        GoldmanCustomItems plugin = GoldmanCustomItems.getPlugin();
        for (NamespacedKey key : plugin.getData().getRecipeKeys()) e.getPlayer().discoverRecipe(key);
    }
}
