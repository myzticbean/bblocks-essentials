package me.ronsane.bblocksessentials.ScheduledTasks;

import me.ronsane.bblocksessentials.Handlers.RankUpHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Task1SecInterval implements Runnable {
    @Override
    public void run() {
        checkForAllOnlinePlayers();
    }

    private void checkForAllOnlinePlayers() {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            RankUpHandler.checkPlaytimeCriteriaMet(p);
        }
    }
}
