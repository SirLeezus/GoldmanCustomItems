package lee.code.customitems.commands;

import lee.code.customitems.GoldmanCustomItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TabCompletion implements TabCompleter {

    private final List<String> blank = new ArrayList<>();
    private final List<String> subCommands = Arrays.asList("ornament");

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        GoldmanCustomItems plugin = GoldmanCustomItems.getPlugin();

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 1) {
                List<String> hasCommand = new ArrayList<>();
                for (String pluginCommand : subCommands) if (sender.hasPermission("ci.command." + pluginCommand)) hasCommand.add(pluginCommand);
                return StringUtil.copyPartialMatches(args[0], hasCommand, new ArrayList<>());
            } else return blank;
        }
        return blank;
    }
}