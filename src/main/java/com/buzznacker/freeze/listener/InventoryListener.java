package com.buzznacker.freeze.listener;

import com.buzznacker.freeze.Freeze;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class InventoryListener implements Listener {

    private Freeze plugin;

    public InventoryListener(Freeze plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInvClose(InventoryCloseEvent e) {

        Player player = (Player) e.getPlayer();

        if(plugin.getFrozenManager().isFrozen(player.getUniqueId())) {

            //Cant reopen an inventory in the same tick as the InventoryCloseEvent so we wait 1 tick to open it.
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.openInventory(plugin.getInventoryManager().getFrozenInv());
                }
            }.runTaskLater(plugin, 1);

        }
    }
}
