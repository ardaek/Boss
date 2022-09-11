package me.arec.arecboss;

import Commands.CommandBossCreate;
import Listeners.BossEditSeassionListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArecBoss extends JavaPlugin {



    @Override
    public void onEnable() {
        getLogger().info("ArecBoss is active!");
new CommandBossCreate(this);
new BossEditSeassionListener(this);

    }

    @Override
    public void onDisable() {
        getLogger().info("ArecBoss is deactive!");
    }
}
