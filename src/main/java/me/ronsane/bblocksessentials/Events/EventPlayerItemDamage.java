package me.ronsane.bblocksessentials.Events;

import me.ronsane.bblocksessentials.BblocksEssentials;
import me.ronsane.bblocksessentials.Handlers.ItemDurabilityNotifyHandler;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class EventPlayerItemDamage implements Listener {
    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {
        try {
            ItemDurabilityNotifyHandler.onItemLowDurability(event);
        }
        catch(Exception exp) {
            Bukkit.getLogger().info(BblocksEssentials.PluginPrefix + exp.getMessage());
        }
    }
}
