package com.buzznacker.freeze.listener.listeners;

import com.buzznacker.freeze.listener.ListenerHandler;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    private ListenerHandler handler;
    public PlayerListener(ListenerHandler handler) {
        this.handler = handler;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (handler.getPlugin().getManagerHandler().getFrozenManager().isFrozen(e.getPlayer().getUniqueId())) {
            handler.getPlugin().getServer().broadcast(ChatColor.GOLD + e.getPlayer().getName() + " logged out while being frozen", "freeze.freeze");
            handler.getPlugin().getManagerHandler().getFrozenManager().unfreezeUUID(e.getPlayer().getUniqueId());
            handler.getPlugin().getManagerHandler().getPlayerSnapshotManager().removeSnapshot(e.getPlayer());
            e.getPlayer().setWalkSpeed(0.2F);
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {
        if(handler.getPlugin().getManagerHandler().getFrozenManager().isFrozen(e.getPlayer().getUniqueId()))
            e.setCancelled(true);
    }
}
