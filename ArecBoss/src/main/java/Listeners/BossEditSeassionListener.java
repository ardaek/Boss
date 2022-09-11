package Listeners;

import HandlerLists.EditSessionHandlerList;
import Utilites.Utils;
import me.arec.arecboss.ArecBoss;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class BossEditSeassionListener implements Listener {

    private ArecBoss plugin;

    EditSessionHandlerList editSessionHandlerList = EditSessionHandlerList.getInstance();

    public BossEditSeassionListener(ArecBoss plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);

    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        String Msg = e.getMessage();
        if(!player.hasPermission("boss.create")) return;
        EditSessionHandlerList.EditSession editSession = editSessionHandlerList.getorAdd(player);
        if(editSession.editName){
            player.sendMessage(Utils.color("&6You succesfully set boss name to &f" + Msg));
            editSession.editName = false;
            editSession.bossName = Msg;
        }
        }
    }

