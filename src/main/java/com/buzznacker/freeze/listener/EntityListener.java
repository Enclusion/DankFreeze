package com.buzznacker.freeze.listener;

import com.buzznacker.freeze.Freeze;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityListener implements Listener {

    private Freeze plugin;
    public EntityListener(Freeze plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if(e.getEntity() instanceof Player && e.getDamager() instanceof Player) {

            Player playerDamaged = (Player) e.getEntity();
            Player playerDamager = (Player) e.getDamager();

            if(plugin.getFrozenManager().isFrozen(playerDamaged.getUniqueId()) || plugin.getFrozenManager().isFrozen(playerDamager.getUniqueId()))
                e.setCancelled(true);
        }
    }
}
