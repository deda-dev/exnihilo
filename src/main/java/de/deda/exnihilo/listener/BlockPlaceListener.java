package de.deda.exnihilo.listener;

import com.jeff_media.customblockdata.CustomBlockData;
import de.deda.exnihilo.ExNihilo;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlockPlaced();
        ItemStack item = player.getInventory().getItemInMainHand();

        if(item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(ExNihilo.getPlugin(), "composter_item"), PersistentDataType.INTEGER)) {
            PersistentDataContainer container = new CustomBlockData(block, ExNihilo.getPlugin());
            NamespacedKey key = new NamespacedKey(ExNihilo.getPlugin(), "composter_block");
            container.set(key, PersistentDataType.INTEGER, 1);
            return;
        }
        if(item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(ExNihilo.getPlugin(), "wooden_crucible_item"), PersistentDataType.INTEGER)) {
            if(block.getLocation().add(0,1,0).getBlock().getType() != Material.AIR) { event.setCancelled(true); return; }
            block.getLocation().add(0,1,0).getBlock().setType(Material.OAK_FENCE);

            PersistentDataContainer container = new CustomBlockData(block, ExNihilo.getPlugin());
            NamespacedKey key = new NamespacedKey(ExNihilo.getPlugin(), "wooden_crucible_block");
            container.set(key, PersistentDataType.INTEGER, 1);
            return;
        }



    }

}
