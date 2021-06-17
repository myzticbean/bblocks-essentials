package me.ronsane.bblocksessentials.Handlers;


import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class ItemDurabilityNotifyHandler {
    public static void onItemLowDurability(PlayerItemDamageEvent event) {

        if(!event.getItem().getItemMeta().isUnbreakable()) {
            if((event.getItem().getType().getMaxDurability() - event.getItem().getDurability() - 1) < 21) {
                event.getPlayer().sendActionBar(ChatColor.translateAlternateColorCodes('&',
                        "&c&lINFO: &7Your item &e" + event.getItem().getType().toString().replaceAll("_", " ")
                                + " &7will break soon (" + (event.getItem().getType().getMaxDurability() - event.getItem().getDurability() - 1)
                                + "/" + event.getItem().getType().getMaxDurability() + ")"));
            }
        }

    }
}
