package com.buzznacker.freeze.listener.listeners;

import com.buzznacker.freeze.Freeze;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityListener implements Listener {

    private Freeze plugin;
    public EntityListener(Freeze plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();

            if(plugin.getManagerHandler().getFrozenManager().isFrozen(player.getUniqueId())) {
                e.setCancelled(true);
            }

        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof Player) {

            Player player = (Player) e.getDamager();

            if(plugin.getManagerHandler().getFrozenManager().isFrozen(player.getUniqueId())) {
                e.setCancelled(true);
            }
        }
    }
}
