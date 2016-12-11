package com.buzznacker.freeze.manager;

import com.buzznacker.freeze.Freeze;
import org.bukkit.inventory.Inventory;

public class InventoryManager {

    private Inventory frozenInv;

    private Freeze plugin;
    public InventoryManager(Freeze plugin) {
        this.plugin = plugin;
        initiateFrozenInv();
    }

    private void initiateFrozenInv() {
        frozenInv = plugin.getServer().createInventory(null, 9, "Screenshare inventory");
    }

    public Inventory getFrozenInv() {
        return frozenInv;
    }
}
