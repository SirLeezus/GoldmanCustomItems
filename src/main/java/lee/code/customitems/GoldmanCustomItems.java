package lee.code.customitems;

import lee.code.customitems.commands.CommandManager;
import lee.code.customitems.commands.TabCompletion;
import lee.code.customitems.listeners.JoinListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class GoldmanCustomItems extends JavaPlugin {

    @Getter private Data data;
    @Getter private PU pU;

    @Override
    public void onEnable() {
        this.data = new Data();
        this.pU = new PU();

        registerListeners();
        registerCommands();

        data.loadRecipes();
        data.loadRegisteredRecipes();
    }

    @Override
    public void onDisable() {

    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
    }

    private void registerCommands() {
        getCommand("customitems").setExecutor(new CommandManager());
        getCommand("customitems").setTabCompleter(new TabCompletion());
    }

    public static GoldmanCustomItems getPlugin() {
        return GoldmanCustomItems.getPlugin(GoldmanCustomItems.class);
    }
}
