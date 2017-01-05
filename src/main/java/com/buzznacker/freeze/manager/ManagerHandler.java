package com.buzznacker.freeze.manager;

import com.buzznacker.freeze.Freeze;
import com.buzznacker.freeze.manager.managers.FrozenManager;
import com.buzznacker.freeze.manager.managers.InventoryManager;
import com.buzznacker.freeze.manager.managers.PlayerSnapshotManager;

public class ManagerHandler {

    private Freeze plugin;

    private InventoryManager inventoryManager;
    private FrozenManager frozenManager;
    private PlayerSnapshotManager playerSnapshotManager;

    public ManagerHandler(Freeze plugin) {
        this.plugin = plugin;
        loadManagers();
    }

    private void loadManagers() {
        inventoryManager = new InventoryManager(plugin);
        frozenManager = new FrozenManager(plugin);
        playerSnapshotManager = new PlayerSnapshotManager(plugin);
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public FrozenManager getFrozenManager() {
        return frozenManager;
    }

    public PlayerSnapshotManager getPlayerSnapshotManager() {
        return playerSnapshotManager;
    }
}
