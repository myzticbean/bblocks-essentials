package me.ronsane.bblocksessentials.Commands;

import me.ronsane.bblocksessentials.BblocksEssentials;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BBlocksCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("bblocks-essentials")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(BblocksEssentials.PluginPrefix + "This command can only be run from in game");
            }
            else {
                Player player = (Player) sender;
                if(player.hasPermission("bblocks-essentials.admin")) {
                    if(args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                        BblocksEssentials.getInstance().reloadConfig();
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                BblocksEssentials.PluginPrefix + "&aPlugin reloaded!"));
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                BblocksEssentials.PluginPrefix + "&cUsage: /bblocks-essentials reload"));
                    }
                }
                else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            BblocksEssentials.PluginPrefix + "&cNo Permission!"));
                }
            }
         }
        return true;
    }
}
