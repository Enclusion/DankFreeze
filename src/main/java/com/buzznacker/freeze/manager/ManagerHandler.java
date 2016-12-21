package com.buzznacker.freeze.manager;

import com.buzznacker.freeze.Freeze;
import com.buzznacker.freeze.manager.managers.FrozenManager;
import com.buzznacker.freeze.manager.managers.InventoryManager;

public class ManagerHandler {

    private Freeze plugin;

    private InventoryManager inventoryManager;
    private FrozenManager frozenManager;

    public ManagerHandler(Freeze plugin) {
        this.plugin = plugin;
        loadManagers();
    }

    private void loadManagers() {
        inventoryManager = new InventoryManager(plugin);
        frozenManager = new FrozenManager(plugin);
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public FrozenManager getFrozenManager() {
        return frozenManager;
    }
}
