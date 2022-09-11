package HandlerLists;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EditSessionHandlerList {


  private static final EditSessionHandlerList Instance = new EditSessionHandlerList();
  private static Map<UUID,EditSession> editSessionMap = new HashMap<>();


  public EditSession getorAdd(OfflinePlayer offlinePlayer){
      return offlinePlayer != null ? getorAdd(offlinePlayer.getUniqueId()) : null;
  }
    public static EditSessionHandlerList getInstance(){
        return Instance;
    }

  public EditSession getorAdd(UUID uuid){
      if(uuid == null) return null;
      EditSession editSession = editSessionMap.get(uuid);
      if(editSession == null) editSessionMap.computeIfAbsent(uuid, EditSession::new);;
      return editSession;
  }


  public static class EditSession{
      public boolean editName = false;
      public boolean editHealth = false;
      public String bossName;
      public double bossHealth;

      private final UUID uuid;

      public EditSession(UUID uuid){
this.uuid = uuid;
      }

      public UUID getUuid(){
          return uuid;
      }
  }



}
