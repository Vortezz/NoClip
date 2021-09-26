package dev.vortezz.noclip.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class NoClipCMD implements CommandExecutor {

    static ArrayList<String> noclipList = new ArrayList<String>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("noclip.use")) {
                boolean isNoClip = toogleNoClip(player);
                player.sendMessage(isNoClip ? "§aNoClip activated !" : "§aNoClip desactivated !");
            } else {
                player.sendMessage("§cSorry but you can't do that !");
            }
            return true;
        }
        return false;
    }

    public boolean toogleNoClip(Player player) {
        boolean noClipToggle = noclipList.contains(player.getName().toString());
        if (noClipToggle) {
            noclipList.remove(player.getName().toString());
        } else {
            noclipList.add(player.getName().toString());
        }
        return !noClipToggle;
    }

    static public boolean isNoClipActivated(Player player) {
        return noclipList.contains(player.getName().toString());
    }
}
