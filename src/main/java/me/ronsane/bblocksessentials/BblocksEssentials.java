package me.ronsane.bblocksessentials;

import me.ronsane.bblocksessentials.Commands.BBlocksCommand;
import me.ronsane.bblocksessentials.Commands.PlaytimeCommand;
import me.ronsane.bblocksessentials.Commands.PlaytimeCommandTabCompleter;
import me.ronsane.bblocksessentials.Events.EventPlayerInteract;
import me.ronsane.bblocksessentials.Events.EventPlayerItemDamage;
import me.ronsane.bblocksessentials.Handlers.PAPIHandler;
import me.ronsane.bblocksessentials.ScheduledTasks.Task1SecInterval;
import me.ronsane.bblocksessentials.ScheduledTasks.Task5MinInterval;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class BblocksEssentials extends JavaPlugin {

    private static Plugin plugin;

    public BblocksEssentials() {
        plugin = this;
    }

    public static Plugin getInstance() {
        return plugin;
    }

    public static String PluginPrefix = CommonUtils.formatChatString("&b[Bblocks-Essentials] &r");

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        Bukkit.getLogger().info(BblocksEssentials.PluginPrefix + CommonUtils.formatChatString("A plugin by &cronsane"));
        Bukkit.getLogger().info(BblocksEssentials.PluginPrefix + "Enabling plugin");
        initCommands();
        initEvents();

        // Enable Scheduled Events
        Bukkit.getLogger().info(BblocksEssentials.PluginPrefix + "Initializing Scheduled Tasks");
//        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Task5MinInterval(), 0, 20*60*5);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Task1SecInterval(), 0, 20);

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PAPIHandler(this).register();
            Bukkit.getLogger().info(BblocksEssentials.PluginPrefix + "Registered Expansion 'Playtime'");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info(BblocksEssentials.PluginPrefix + "Disabling plugin");
    }

    private void initCommands() {
        Bukkit.getLogger().info(BblocksEssentials.PluginPrefix + "Registering commands");
        this.getCommand("playtime").setExecutor(new PlaytimeCommand());
        this.getCommand("playtime").setTabCompleter(new PlaytimeCommandTabCompleter());
        this.getCommand("bblocks-essentials").setExecutor(new BBlocksCommand());
    }

    private void initEvents() {
        // events register
        Bukkit.getLogger().info(BblocksEssentials.PluginPrefix + "Registering events");
        this.getServer().getPluginManager().registerEvents(new EventPlayerInteract(), this);
        this.getServer().getPluginManager().registerEvents(new EventPlayerItemDamage(), this);
    }
}
