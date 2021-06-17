package me.ronsane.bblocksessentials.Commands;

import me.ronsane.bblocksessentials.BblocksEssentials;
import me.ronsane.bblocksessentials.Handlers.PlaytimeHandler;
import org.apache.commons.lang.NullArgumentException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class PlaytimeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("playtime")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(BblocksEssentials.PluginPrefix + "This command can only be run from in game");
            }
            else {
                Player player = (Player) sender;
                if(args.length  == 0) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &6&lYour Playtime: &e" + PlaytimeHandler.getFormattedPlaytime(player)));
                }
                else if(args.length == 1) {
                    if(player.hasPermission("playtime.others")) {
                        try {
                            OfflinePlayer offPlayer = Bukkit.getOfflinePlayer(Bukkit.getPlayerUniqueId(args[0]));
                            if(offPlayer != null) {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &6&l" + args[0] + "'s playtime: &e" + PlaytimeHandler.getFormattedPlaytimeForOfflinePlayer(offPlayer)));
                            }
                            else {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &c&lInvalid Player Name!"));
                            }
                        }
                        catch(NullArgumentException | NullPointerException e) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &c&lInvalid Player Name!"));
                            Bukkit.getLogger().severe(BblocksEssentials.PluginPrefix + "Exception occurred: \n" + e.getMessage());
                        }
                        catch(Exception e) {
                            Bukkit.getLogger().severe(BblocksEssentials.PluginPrefix + "Exception occurred: \n" + e.getMessage());
                        }
                    }
                    else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l» &c&lNo Permission!"));
                    }
                }
            }
        }
        return true;
    }
}
