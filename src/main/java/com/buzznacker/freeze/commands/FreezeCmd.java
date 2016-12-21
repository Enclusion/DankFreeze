package com.buzznacker.freeze.commands;

import com.buzznacker.freeze.Freeze;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCmd implements CommandExecutor {

    private Freeze plugin;
    public FreezeCmd(Freeze plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!sender.hasPermission("freeze.freeze")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command.");
            return true;
        }

        if(args.length != 1)
            return false;

        Player target = plugin.getServer().getPlayer(args[0]);

        if(target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        if(plugin.getManagerHandler().getFrozenManager().isFrozen(target.getUniqueId())) {
            plugin.getManagerHandler().getFrozenManager().unfreezeUUID(target.getUniqueId());
            sender.sendMessage(ChatColor.GREEN + "You unfroze " + target.getName());
            target.sendMessage(ChatColor.GREEN + "You have been unfrozen by a staff member.");
            target.closeInventory();
            return true;
        }

        plugin.getManagerHandler().getFrozenManager().freezeUUID(target.getUniqueId());
        sender.sendMessage(ChatColor.GREEN + "You froze " + target.getName());
        target.sendMessage(ChatColor.GREEN + "You have been frozen by a staff member ! Do not log out !");
        target.openInventory(plugin.getManagerHandler().getInventoryManager().getFrozenInv());

        return true;
    }
}
