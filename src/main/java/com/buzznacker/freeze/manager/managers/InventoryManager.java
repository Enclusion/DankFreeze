package com.buzznacker.freeze.manager.managers;

import com.buzznacker.freeze.Freeze;
import com.buzznacker.freeze.manager.Manager;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager extends Manager {

    private Inventory frozenInv;

    public InventoryManager(Freeze plugin) {
        super(plugin);
        initiateFrozenInv();
    }

    private void initiateFrozenInv() {
        frozenInv = plugin.getServer().createInventory(null, 9, "Screenshare inventory");
        ItemStack paper = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = paper.getItemMeta();
        List<String> lores = new ArrayList<>();
        lores.add(0, "DO NOT LOG OUT YOU HAVE 5 MINUTES");
        lores.add(1, "https://www.teamspeak.com/downloads");
        itemMeta.setLore(lores);
        itemMeta.setDisplayName("ts.zonix.us");
        paper.setItemMeta(itemMeta);

        frozenInv.setItem(4, paper);
    }

    public Inventory getFrozenInv() {
        return frozenInv;
    }


}
