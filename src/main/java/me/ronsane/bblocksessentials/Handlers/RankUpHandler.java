package me.ronsane.bblocksessentials.Handlers;

import me.ronsane.bblocksessentials.CommonUtils;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class RankUpHandler {

    private static boolean isPlayerInGroup(Player player, String group) {
        return player.hasPermission("group." + group);
    }

    public static void checkPlaytimeCriteriaMet(Player player) {

//        LuckPerms api = LuckPermsProvider.get();
//        User user = api.getPlayerAdapter(Player.class).getUser(player);

//        player.sendActionBar(CommonUtils.formatChatString("&6Primary Group: &r" + user.getPrimaryGroup()));

        String ranksPrefix = "&8&l[&b&lRanks&8&l] &r";

        // 1 hour playtime
        if((PlaytimeHandler.getRawPlaytime(player) >= (1 * 60 * 60))
                && (PlaytimeHandler.getRawPlaytime(player) < (5 * 60 * 60))) {
            if(!isPlayerInGroup(player, "farmer")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                        "lp user " + player.getName() + " parent add farmer");
                CommonUtils.broadcastMsg(ranksPrefix + "&6" + player.getName() + " &eis now a Farmer!");
            }
        }
        // 5 hour playtime
        else if((PlaytimeHandler.getRawPlaytime(player) >= (5 * 60 * 60))
                && (PlaytimeHandler.getRawPlaytime(player) < ((2 * 24 * 60 * 60) + (12 * 60 * 60)))) {
            if(!isPlayerInGroup(player, "settler")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                        "lp user " + player.getName() + " parent add settler");
                CommonUtils.broadcastMsg(ranksPrefix + "&6" + player.getName() + " &eis now a Settler!");
            }
        }
        // 2.5 day playtime
        else if((PlaytimeHandler.getRawPlaytime(player) >= ((2 * 24 * 60 * 60) + (12 * 60 * 60)))
                && (PlaytimeHandler.getRawPlaytime(player) < (5 * 24 * 60 * 60))) {
            if(!isPlayerInGroup(player, "citizen")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                        "lp user " + player.getName() + " parent add citizen");
                CommonUtils.broadcastMsg(ranksPrefix + "&6" + player.getName() + " &eis now a Citizen!");
            }
        }
        // 5 day playtime
        else if((PlaytimeHandler.getRawPlaytime(player) >= (5 * 24 * 60 * 60))
                && PlaytimeHandler.getRawPlaytime(player) < ((7 * 24 * 60 * 60) + (12 * 60 * 60))) {
            if(!isPlayerInGroup(player, "expert")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                        "lp user " + player.getName() + " parent add expert");
                CommonUtils.broadcastMsg(ranksPrefix + "&6" + player.getName() + " &eis now a Expert!");
            }
        }
        // 7.5 day playtime
        else if(PlaytimeHandler.getRawPlaytime(player) >= ((7 * 24 * 60 * 60) + (12 * 60 * 60))
                && (PlaytimeHandler.getRawPlaytime(player) < (10 * 24 * 60 * 60))) {
            if(!isPlayerInGroup(player, "legend")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                        "lp user " + player.getName() + " parent add legend");
                CommonUtils.broadcastMsg(ranksPrefix + "&6" + player.getName() + " &eis now a Legend!");
            }
        }
        // 10 day playtime
        else if((PlaytimeHandler.getRawPlaytime(player) >= (10 * 24 * 60 * 60))) {
            if(!isPlayerInGroup(player, "hero")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                        "lp user " + player.getName() + " parent add hero");
                CommonUtils.broadcastMsg(ranksPrefix + "&6" + player.getName() + " &eis now a Hero!");
            }
        }

    }

}
