package me.ronsane.bblocksessentials.Handlers;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class PlaytimeHandler {

    public static String second = "s";
    public static String minute = "m";
    public static String hour = "h";
    public static String day = "d";

    private static String format(String format) {
        return ChatColor.translateAlternateColorCodes('&', format);
    }
    private static  String getTime(int seconds) {
        if (seconds < 60) {
            return seconds + second;
        }
        int minutes = seconds / 60;
        int s = 60 * minutes;
        int secondsLeft = seconds - s;
        if (minutes < 60) {
            if (secondsLeft > 0) {
                return String.valueOf(minutes + minute + " " + secondsLeft + second);
            }
            return String.valueOf(minutes + minute);
        }
        if (minutes < 1440) {
            String time = "";
            int hours = minutes / 60;
            time = hours + hour;
            int inMins = 60 * hours;
            int leftOver = minutes - inMins;
            if (leftOver >= 1) {
                time = time + " " + leftOver + minute;
            }
            if (secondsLeft > 0) {
                time = time + " " + secondsLeft + second;
            }
            return time;
        }
        String time = "";
        int days = minutes / 1440;
        time = days + day;
        int inMins = 1440 * days;
        int leftOver = minutes - inMins;
        if (leftOver >= 1) {
            if (leftOver < 60) {
                time = time + " " + leftOver + minute;
            } else {
                int hours = leftOver / 60;
                time = time + " " + hours + hour;
                int hoursInMins = 60 * hours;
                int minsLeft = leftOver - hoursInMins;
                if (leftOver >= 1) {
                    time = time + " " + minsLeft + minute;
                }
            }
        }
        if (secondsLeft > 0) {
            time = time + " " + secondsLeft + second;
        }
        return time;
    }

    public static String getFormattedPlaytime(Player player) {
        return getTime(getRawPlaytime(player));
    }

    public static int getRawPlaytime(Player player) {
        return player.getStatistic(Statistic.PLAY_ONE_MINUTE)/20;
    }

    public static int getRawPlaytimeForOfflinePlayer(OfflinePlayer player) {
        return player.getStatistic(Statistic.PLAY_ONE_MINUTE)/20;
    }

    public static String getFormattedPlaytimeForOfflinePlayer(OfflinePlayer player) {
        return getTime(getRawPlaytimeForOfflinePlayer(player));
    }
}
