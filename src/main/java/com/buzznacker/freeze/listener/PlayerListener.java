package com.buzznacker.freeze.listener;

import com.buzznacker.freeze.Freeze;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    private Freeze plugin;
    public PlayerListener(Freeze plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (plugin.getManagerHandler().getFrozenManager().isFrozen(e.getPlayer().getUniqueId())) {
            plugin.getServer().broadcast(ChatColor.GOLD + e.getPlayer().getName() + " logged out while being frozen", "freeze.freeze");
            plugin.getManagerHandler().getFrozenManager().unfreezeUUID(e.getPlayer().getUniqueId());
            e.getPlayer().setWalkSpeed(0.2F);
        }
    }
}
