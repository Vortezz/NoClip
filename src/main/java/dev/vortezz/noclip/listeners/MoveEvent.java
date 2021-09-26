package dev.vortezz.noclip.listeners;

import dev.vortezz.noclip.commands.NoClipCMD;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Set;

public class MoveEvent implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (NoClipCMD.isNoClipActivated(player)) {
            Location playerLocation = player.getTargetBlock((Set<Material>) null, 1).getLocation();
            if (playerLocation.getBlock().getType() != Material.AIR || playerLocation.getBlock().getType() != Material.getMaterial("LEGACY_AIR") || player.getLocation(new Location(player.getWorld(), playerLocation.getBlockX(), playerLocation.getBlockY() - 1, playerLocation.getBlockZ())).getBlock().getType() != Material.AIR || player.getLocation(new Location(player.getWorld(), playerLocation.getBlockX(), playerLocation.getBlockY() - 1, playerLocation.getBlockZ())).getBlock().getType() != Material.getMaterial("LEGACY_AIR")) {
                player.setGameMode(GameMode.SPECTATOR);
            } else if (player.getLocation(new Location(player.getWorld(), player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ())).getBlock().getType() == Material.AIR) {
                player.setGameMode(GameMode.CREATIVE);
            }
        }
    }
}
