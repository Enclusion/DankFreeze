package com.buzznacker.freeze;

import com.buzznacker.freeze.commands.FreezeCmd;
import com.buzznacker.freeze.listener.ListenerHandler;
import com.buzznacker.freeze.listener.listeners.EntityListener;
import com.buzznacker.freeze.listener.listeners.InventoryListener;
import com.buzznacker.freeze.listener.listeners.PlayerListener;
import com.buzznacker.freeze.manager.ManagerHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Freeze extends JavaPlugin {

    private ManagerHandler managerHandler;

    @Override
    public void onEnable() {
        new ListenerHandler(this);
        managerHandler = new ManagerHandler(this);
        getCommand("freeze").setExecutor(new FreezeCmd(this));
    }

    public ManagerHandler getManagerHandler() {
        return managerHandler;
    }


}
