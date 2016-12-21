package com.buzznacker.freeze;

import com.buzznacker.freeze.commands.FreezeCmd;
import com.buzznacker.freeze.listener.EntityListener;
import com.buzznacker.freeze.listener.InventoryListener;
import com.buzznacker.freeze.manager.ManagerHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Freeze extends JavaPlugin {

    private ManagerHandler managerHandler;

    @Override
    public void onEnable() {
        registerListeners();
        managerHandler = new ManagerHandler(this);
        getCommand("freeze").setExecutor(new FreezeCmd(this));

    }

    private void registerListeners() {
        final PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new InventoryListener(this), this);
        pm.registerEvents(new EntityListener(this), this);
    }

    public ManagerHandler getManagerHandler() {
        return managerHandler;
    }


}
