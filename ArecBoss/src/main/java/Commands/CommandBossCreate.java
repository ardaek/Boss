package Commands;

import HandlerLists.EditSessionHandlerList;
import Utilites.Utils;
import me.arec.arecboss.ArecBoss;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBossCreate implements CommandExecutor {

    private ArecBoss plugin;

    EditSessionHandlerList editSessionHandlerList = EditSessionHandlerList.getInstance();

    public CommandBossCreate(ArecBoss plugin) {
        this.plugin = plugin;
        plugin.getCommand("boss").setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        if(!(sender instanceof Player)){
            System.out.println("Only players can run this command!");
            return true;
        }
        if(!player.hasPermission("boss.create")){
            player.sendMessage(Utils.color("&c&lYou do not have permission to run this command!"));
            return true;
        }


            if(args[0].equalsIgnoreCase("create")){
                editSessionHandlerList.getorAdd(player).editName = true;
                player.sendMessage(Utils.color("&6&lPlease enter boss name!"));

            }else{
                player.sendMessage(Utils.color("&c&lUSAGE:&7boss create"));

        }




        return true;
    }
}
