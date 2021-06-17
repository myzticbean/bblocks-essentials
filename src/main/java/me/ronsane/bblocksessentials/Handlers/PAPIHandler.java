package me.ronsane.bblocksessentials.Handlers;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.ronsane.bblocksessentials.BblocksEssentials;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PAPIHandler extends PlaceholderExpansion {

    private BblocksEssentials plugin;

    public PAPIHandler(BblocksEssentials plugin){
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "playtime";
    }

    @Override
    public @NotNull String getAuthor() {
        return "ronsane";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0-SNAPSHOT";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier){

        if(player == null){
            return "";
        }

        // %someplugin_placeholder1%
        if(identifier.equals("formatted")){
            return BblocksEssentials.getInstance().getConfig().getString("formatted", PlaytimeHandler.getFormattedPlaytime(player));
        }

        // %someplugin_placeholder2%
        if(identifier.equals("raw")){
            return BblocksEssentials.getInstance().getConfig().getString("raw", String.valueOf(PlaytimeHandler.getRawPlaytime(player)));
        }

        // We return null if an invalid placeholder (f.e. %someplugin_placeholder3%)
        // was provided
        return null;
    }
}
