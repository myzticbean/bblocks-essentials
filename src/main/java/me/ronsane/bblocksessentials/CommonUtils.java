package me.ronsane.bblocksessentials;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
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

    public static void sendActionBarToPlayer(Player player, String msg) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(formatChatString(msg)));
    }
}
