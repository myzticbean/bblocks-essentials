package me.ronsane.bblocksessentials.Handlers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockTrampleHandler {
    public static void onPlayerTrample(PlayerInteractEvent e) {

        if (e.getAction().equals(Action.PHYSICAL)) {
            Player player = e.getPlayer();
            assert e.getClickedBlock() != null;
            Material block = e.getClickedBlock().getType();
            if (block.equals(Material.TURTLE_EGG)) {
                e.setCancelled(true);
            } else if (block.equals(Material.FARMLAND)) {
                e.setCancelled(true);
            }
        }
    }
}
