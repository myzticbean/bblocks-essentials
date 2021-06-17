package me.ronsane.bblocksessentials.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlaytimeCommandTabCompleter implements TabCompleter {

    List<String> arguments = new ArrayList<>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(arguments.isEmpty()) {
            for(Player player : Bukkit.getServer().getOnlinePlayers()) {
                arguments.add(player.getName());
            }
        }

        List<String> result = new ArrayList<>();
        if(args.length == 1) {
            for(String a : arguments) {
                if(a.toLowerCase().startsWith(args[0].toLowerCase())) {
                    result.add(a);
                }
            }
            return result;
        }
        return null;
    }

}
