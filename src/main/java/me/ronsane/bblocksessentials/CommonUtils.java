package me.ronsane.bblocksessentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CommonUtils {
    public static String formatChatString(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void broadcastMsg(String msg) {
        try {
            for(Player player : Bukkit.getServer().getOnlinePlayers()) {
                player.sendMessage(formatChatString(msg));
            }
        }
        catch(Exception e) {
            Bukkit.getLogger().severe(BblocksEssentials.PluginPrefix + "Exception occurred: \n" + e.getMessage());
        }
    }
}
