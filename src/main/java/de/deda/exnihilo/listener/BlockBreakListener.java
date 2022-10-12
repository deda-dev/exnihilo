package de.deda.exnihilo.listener;

import com.jeff_media.customblockdata.CustomBlockData;
import de.deda.exnihilo.ExNihilo;
import de.deda.exnihilo.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Random;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack item = player.getInventory().getItemInMainHand();

        if(block.getType() == Material.PEARLESCENT_FROGLIGHT) {
            PersistentDataContainer container = new CustomBlockData(block, ExNihilo.getPlugin());
            NamespacedKey key = new NamespacedKey(ExNihilo.getPlugin(), "infected");

            if(!container.has(key, PersistentDataType.INTEGER)) return;
            event.setDropItems(false);
            container.remove(key);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemBuilder(Material.STRING).build());
            return;
        }
        if(block.getType() == Material.COMPOSTER) {
            PersistentDataContainer container = new CustomBlockData(block, ExNihilo.getPlugin());
            NamespacedKey key = new NamespacedKey(ExNihilo.getPlugin(), "composter_block");

            if(!container.has(key, PersistentDataType.INTEGER)) return;
            event.setDropItems(false);
            container.remove(key);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemBuilder(Material.COMPOSTER).setDisplayName("§fComposter").addPersistentData("composter_item", 1).build());
            return;
        }
        if(block.getType() == Material.CAULDRON) {
            if(block.getLocation().add(0,1,0).getBlock().getType() == Material.OAK_FENCE) block.getLocation().add(0,1,0).getBlock().setType(Material.AIR);

            PersistentDataContainer container = new CustomBlockData(block, ExNihilo.getPlugin());
            NamespacedKey key = new NamespacedKey(ExNihilo.getPlugin(), "wooden_crucible_block");

            if(!container.has(key, PersistentDataType.INTEGER)) return;
            event.setDropItems(false);
            container.remove(key);
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemBuilder(Material.CAULDRON).setDisplayName("§fWooden crucible").addPersistentData("wooden_crucible_item", 1).build());
            return;
        } else if(block.getType() == Material.OAK_FENCE) {
            if(block.getLocation().subtract(0,1,0).getBlock().getType() != Material.CAULDRON) return;

            PersistentDataContainer container = new CustomBlockData(block.getLocation().subtract(0,1,0).getBlock(), ExNihilo.getPlugin());
            NamespacedKey key = new NamespacedKey(ExNihilo.getPlugin(), "wooden_crucible_block");

            if(!container.has(key, PersistentDataType.INTEGER)) return;
            event.setDropItems(false);
            block.getLocation().subtract(0,1,0).getBlock().setType(Material.AIR);
            container.remove(key);
            block.getWorld().dropItemNaturally(block.getLocation().subtract(0,1,0).getBlock().getLocation(), new ItemBuilder(Material.CAULDRON).setDisplayName("§fWooden crucible").addPersistentData("wooden_crucible_item", 1).build());
            return;
        }

        if(item.getItemMeta() == null) return;
        ItemMeta meta = item.getItemMeta();

        if(meta.getPersistentDataContainer().has(new NamespacedKey(ExNihilo.getPlugin(),"crook"), PersistentDataType.INTEGER)) {
            if(block.getType() == Material.AZALEA_LEAVES || block.getType() == Material.ACACIA_LEAVES || block.getType() == Material.BIRCH_LEAVES ||
                    block.getType() == Material.DARK_OAK_LEAVES || block.getType() == Material.FLOWERING_AZALEA_LEAVES || block.getType() == Material.JUNGLE_LEAVES ||
                    block.getType() == Material.OAK_LEAVES || block.getType() == Material.SPRUCE_LEAVES || block.getType() == Material.MANGROVE_LEAVES) {
                Random random = new Random();
                int chance = random.nextInt(20)+1;

                if(chance <= 3)
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemBuilder(Material.OAK_SAPLING).build());
                if(chance == 4)
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemBuilder(Material.APPLE).build());
                if(chance == 5)
                    block.getWorld().dropItem(block.getLocation(), new ItemBuilder(Material.APPLE).build());
                if(chance == 6)
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemBuilder(Material.WHITE_DYE).setDisplayName("§fSilk worm").addPersistentData("silk_worm", 1).build());

                return;
            }
            if(block.getType() == Material.PEARLESCENT_FROGLIGHT) {
                Random random = new Random();
                int chance = random.nextInt(10)+1;

                if(chance <= 3)
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemBuilder(Material.STRING).build());
                return;
            }
            return;
        }
        if(meta.getPersistentDataContainer().has(new NamespacedKey(ExNihilo.getPlugin(), "wooden_shears"), PersistentDataType.INTEGER)) {
            if(!(meta instanceof Damageable)) return;
            ((Damageable) meta).setDamage(((Damageable) meta).getDamage()+3);
            item.setItemMeta(meta);
            return;
        }

    }

}
