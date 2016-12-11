package com.buzznacker.freeze;

import com.buzznacker.freeze.commands.FreezeCmd;
import com.buzznacker.freeze.listener.EntityListener;
import com.buzznacker.freeze.listener.InventoryListener;
import com.buzznacker.freeze.manager.FrozenManager;
import com.buzznacker.freeze.manager.InventoryManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Freeze extends JavaPlugin {

    private InventoryManager inventoryManager;
    private FrozenManager frozenManager;

    @Override
    public void onEnable() {
        registerListeners();
        initiateManagers();

        getCommand("freeze").setExecutor(new FreezeCmd(this));

    }

    private void initiateManagers() {
        inventoryManager = new InventoryManager(this);
        frozenManager = new FrozenManager();
    }

    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new InventoryListener(this), this);
        pm.registerEvents(new EntityListener(this), this);
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public FrozenManager getFrozenManager() {
        return frozenManager;
    }


}
