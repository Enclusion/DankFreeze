package com.buzznacker.freeze.commands;

import com.buzznacker.freeze.Freeze;
import com.buzznacker.freeze.player.PlayerSnapshot;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

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
            sender.sendMessage(ChatColor.GREEN + "You unfroze " + target.getName());

            plugin.getServer().broadcast(ChatColor.RED + target.getName() + ChatColor.GOLD + " has been unfrozen by " + ChatColor.RED +
                    (sender instanceof Player ? sender.getName() : "Console"), "freeze.freeze");

            unfreezePlayer(target);
            return true;
        }

        sender.sendMessage(ChatColor.GREEN + "You froze " + target.getName());

        plugin.getServer().broadcast(ChatColor.RED + target.getName() + ChatColor.GOLD + " has been frozen by " + ChatColor.RED +
                (sender instanceof Player ? sender.getName() : "Console"), "freeze.freeze");

        freezePlayer(target);
        return true;
    }

    private void freezePlayer(Player player) {
        plugin.getManagerHandler().getPlayerSnapshotManager().takeSnapshot(player);
        plugin.getManagerHandler().getFrozenManager().freezeUUID(player.getUniqueId());
        player.sendMessage(ChatColor.GREEN + "You have been frozen by a staff member ! Do not log out ! (Do not even try to use SelfDestruct)");
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.setWalkSpeed(0.0F);
        clearPotionEffects(player);
        player.updateInventory();
        player.openInventory(plugin.getManagerHandler().getInventoryManager().getFrozenInv());

    }

    private void unfreezePlayer(Player player) {
        plugin.getManagerHandler().getFrozenManager().unfreezeUUID(player.getUniqueId());
        player.sendMessage(ChatColor.GREEN + "You have been unfrozen by a staff member.");
        player.closeInventory();
        restorePlayerFromSnapshot(player, plugin.getManagerHandler().getPlayerSnapshotManager().getSnapshot(player));
        plugin.getManagerHandler().getPlayerSnapshotManager().removeSnapshot(player);
    }

    private void restorePlayerFromSnapshot(Player player, PlayerSnapshot playerSnapshot) {
        player.getInventory().clear();
        player.getInventory().setContents(playerSnapshot.getMainContent());
        player.getInventory().setArmorContents(playerSnapshot.getArmorContent());
        player.setWalkSpeed(playerSnapshot.getWalkSpeed());
        player.addPotionEffects(playerSnapshot.getPotionEffects());
        player.updateInventory();
    }

    private void clearPotionEffects(Player player) {
        for(PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
    }
}
