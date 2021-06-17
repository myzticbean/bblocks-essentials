package me.ronsane.bblocksessentials.Events;

import me.ronsane.bblocksessentials.BblocksEssentials;
import me.ronsane.bblocksessentials.Handlers.BlockTrampleHandler;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventPlayerInteract implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        try {
            BlockTrampleHandler.onPlayerTrample(event);
        }
        catch(Exception exp) {
            Bukkit.getLogger().info(BblocksEssentials.PluginPrefix + exp.getMessage());
        }
    }
}
