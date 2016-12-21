package com.buzznacker.freeze.manager.managers;

import com.buzznacker.freeze.Freeze;
import com.buzznacker.freeze.manager.Manager;
import org.bukkit.inventory.Inventory;

public class InventoryManager extends Manager {

    private Inventory frozenInv;

    public InventoryManager(Freeze plugin) {
        super(plugin);
        initiateFrozenInv();
    }

    private void initiateFrozenInv() {
        frozenInv = plugin.getServer().createInventory(null, 9, "Screenshare inventory");
    }

    public Inventory getFrozenInv() {
        return frozenInv;
    }
}
