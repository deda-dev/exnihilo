package de.deda.exnihilo.listener;

import com.jeff_media.customblockdata.CustomBlockData;
import de.deda.exnihilo.ExNihilo;
import de.deda.exnihilo.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PlayerBucketListener implements Listener {

    //
    // Funktioniert teilweise nicht!!!!!
    //

    @EventHandler
    public void onEmptyBucket(PlayerBucketEmptyEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        Block block = event.getBlockClicked();

        if(item.getType() == Material.WATER_BUCKET) {
            PersistentDataContainer container = new CustomBlockData(block, ExNihilo.getPlugin());
            if(container.has(new NamespacedKey(ExNihilo.getPlugin(), "wooden_crucible_block"), PersistentDataType.INTEGER)) {
                NamespacedKey keyLevel = new NamespacedKey(ExNihilo.getPlugin(), "wooden_crucible_block_level");
                container.set(keyLevel, PersistentDataType.INTEGER, 8);
            }
            if(item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(ExNihilo.getPlugin(), "clay_bucket"), PersistentDataType.INTEGER)) {
                event.setItemStack(new ItemBuilder(Material.BUCKET).setDisplayName("§fClay bucket").addPersistentData("clay_bucket", 1).build());
                return;
            }
        }
        if(item.getType() == Material.LAVA_BUCKET) {
            PersistentDataContainer container = new CustomBlockData(block, ExNihilo.getPlugin());
            if(container.has(new NamespacedKey(ExNihilo.getPlugin(), "crucible_block"), PersistentDataType.INTEGER)) {
                NamespacedKey keyLevel = new NamespacedKey(ExNihilo.getPlugin(), "wooden_crucible_block_level");
                container.set(keyLevel, PersistentDataType.INTEGER, 8);
                block.setType(Material.LAVA_CAULDRON);
            }
            if(item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(ExNihilo.getPlugin(), "clay_bucket"), PersistentDataType.INTEGER)) {
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1f, 1f);
                event.setItemStack(new ItemStack(Material.AIR));
                item.setType(null);
            }
        }








    }

    @EventHandler
    public void onFillBucket(PlayerBucketFillEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItemStack();
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        Block blockClicked = event.getBlockClicked();
        Block block = event.getBlock();

        player.sendMessage("test"+item.getType());

        PersistentDataContainer container = new CustomBlockData(blockClicked, ExNihilo.getPlugin());
        if(container.has(new NamespacedKey(ExNihilo.getPlugin(), "wooden_crucible_block"), PersistentDataType.INTEGER)) {

            player.sendMessage("test1");

            NamespacedKey keyLevel = new NamespacedKey(ExNihilo.getPlugin(), "wooden_crucible_block_level");
            container.set(keyLevel, PersistentDataType.INTEGER, 0);
            blockClicked.setType(Material.CAULDRON);
        }

        player.sendMessage("test2");
        PersistentDataContainer persistentDataContainer = itemStack.getItemMeta().getPersistentDataContainer();

        if(persistentDataContainer.has(new NamespacedKey(ExNihilo.getPlugin(), "clay_bucket"), PersistentDataType.INTEGER)) {

            player.sendMessage("test3");

            if(block.getType() == Material.WATER || blockClicked.getType() == Material.WATER_CAULDRON)
                event.setItemStack(new ItemBuilder(Material.WATER_BUCKET).setDisplayName("§fWater clay bucket").addPersistentData("clay_bucket", 1).build());
            else if(block.getType() == Material.LAVA || blockClicked.getType() == Material.LAVA_CAULDRON)
                event.setItemStack(new ItemBuilder(Material.LAVA_BUCKET).setDisplayName("§fLava clay bucket").addPersistentData("clay_bucket", 1).build());
            else
                event.setCancelled(true);
        }


    }

}
