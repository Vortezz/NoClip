package dev.vortezz.noclip;

import dev.vortezz.noclip.commands.NoClipCMD;
import dev.vortezz.noclip.listeners.MoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class NoClip extends JavaPlugin {

    private NoClip instance;

    public void onEnable() {
        instance = this;

        System.out.println("NoClip Launched !");

        getCommand("noclip").setExecutor(new NoClipCMD());
        Bukkit.getPluginManager().registerEvents(new MoveEvent(), this);
    }

}
