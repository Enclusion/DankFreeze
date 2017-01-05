package com.buzznacker.freeze.listener;

import com.buzznacker.freeze.Freeze;
import com.buzznacker.freeze.listener.listeners.EntityListener;
import com.buzznacker.freeze.listener.listeners.InventoryListener;
import com.buzznacker.freeze.listener.listeners.PlayerListener;
import org.bukkit.event.Listener;

public class ListenerHandler {

    private Freeze plugin;
    public ListenerHandler(Freeze plugin) {
        this.plugin = plugin;
        loadListeners();
    }

    private Listener[] listeners = {
            new EntityListener(this),
            new InventoryListener(this),
            new PlayerListener(this)
    };

    private void loadListeners() {
        for(Listener listener : listeners) {
            plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public Freeze getPlugin() {
        return plugin;
    }

}
