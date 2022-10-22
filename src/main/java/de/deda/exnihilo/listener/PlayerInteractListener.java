package de.deda.exnihilo.listener;

import com.jeff_media.customblockdata.CustomBlockData;
import de.deda.exnihilo.ExNihilo;
import de.deda.exnihilo.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Random;

public class PlayerInteractListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        ItemStack item = player.getInventory().getItemInMainHand();

        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            if(item.getType() == Material.WHITE_DYE) {
                if(!item.hasItemMeta()) return;
                if(!item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(ExNihilo.getPlugin(), "silk_worm"), PersistentDataType.INTEGER)) return;
                if(block.getType() != Material.AZALEA_LEAVES && block.getType() != Material.ACACIA_LEAVES && block.getType() != Material.BIRCH_LEAVES &&
                        block.getType() != Material.DARK_OAK_LEAVES && block.getType() != Material.FLOWERING_AZALEA_LEAVES && block.getType() != Material.JUNGLE_LEAVES &&
                        block.getType() != Material.OAK_LEAVES && block.getType() != Material.SPRUCE_LEAVES && block.getType() != Material.MANGROVE_LEAVES) return;

                block.setType(Material.PEARLESCENT_FROGLIGHT);

                PersistentDataContainer container = new CustomBlockData(block, ExNihilo.getPlugin());
                NamespacedKey key = new NamespacedKey(ExNihilo.getPlugin(), "infected");
                container.set(key, PersistentDataType.INTEGER, 1);

                if(item.getAmount() > 1)
                    item.setAmount(item.getAmount()-1);
                else
                    item.setAmount(0);
                return;
            }
            if(block.getType() == Material.COMPOSTER) {
                PersistentDataContainer container = new CustomBlockData(block, ExNihilo.getPlugin());
                NamespacedKey key = new NamespacedKey(ExNihilo.getPlugin(), "composter_block");

                if(!container.has(key, PersistentDataType.INTEGER)) return;
                event.setCancelled(true);
                Levelled levelled = (Levelled) block.getBlockData();

                if(levelled.getLevel() == levelled.getMaximumLevel()-1) return;
                if(levelled.getLevel() == levelled.getMaximumLevel()) {
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemBuilder(Material.DIRT).build());
                    levelled.setLevel(0);
                    block.setBlockData(levelled);
                    return;
                }

                if(item.getType() != Material.OAK_SAPLING && item.getType() != Material.SPRUCE_SAPLING && item.getType() != Material.BIRCH_SAPLING &&
                        item.getType() != Material.JUNGLE_SAPLING && item.getType() != Material.ACACIA_SAPLING && item.getType() != Material.DARK_OAK_SAPLING &&
                        item.getType() != Material.MANGROVE_PROPAGULE && item.getType() != Material.OAK_LEAVES && item.getType() != Material.SPRUCE_LEAVES &&
                        item.getType() != Material.BIRCH_LEAVES && item.getType() != Material.JUNGLE_LEAVES && item.getType() != Material.ACACIA_LEAVES &&
                        item.getType() != Material.DARK_OAK_LEAVES && item.getType() != Material.MANGROVE_LEAVES && item.getType() != Material.AZALEA_LEAVES &&
                        item.getType() != Material.FLOWERING_AZALEA_LEAVES && item.getType() != Material.TALL_GRASS && item.getType() != Material.GRASS &&
                        item.getType() != Material.LARGE_FERN && item.getType() != Material.FERN && item.getType() != Material.AZALEA &&
                        item.getType() != Material.FLOWERING_AZALEA && item.getType() != Material.DEAD_BUSH && item.getType() != Material.SEAGRASS &&
                        item.getType() != Material.SEA_PICKLE && item.getType() != Material.BROWN_MUSHROOM && item.getType() != Material.RED_MUSHROOM &&
                        item.getType() != Material.CRIMSON_FUNGUS && item.getType() != Material.WARPED_FUNGUS && item.getType() != Material.WEEPING_VINES &&
                        item.getType() != Material.TWISTING_VINES && item.getType() != Material.SUGAR_CANE && item.getType() != Material.KELP &&
                        item.getType() != Material.BAMBOO && item.getType() != Material.CHORUS_PLANT && item.getType() != Material.CHORUS_FLOWER &&
                        item.getType() != Material.CHORUS_FRUIT && item.getType() != Material.CACTUS && item.getType() != Material.BROWN_MUSHROOM_BLOCK &&
                        item.getType() != Material.RED_MUSHROOM_BLOCK && item.getType() != Material.MUSHROOM_STEM && item.getType() != Material.VINE &&
                        item.getType() != Material.GLOW_LICHEN && item.getType() != Material.LILY_PAD && item.getType() != Material.SUNFLOWER &&
                        item.getType() != Material.LILAC && item.getType() != Material.ROSE_BUSH && item.getType() != Material.PEONY &&
                        item.getType() != Material.APPLE && item.getType() != Material.BREAD && item.getType() != Material.PORKCHOP &&
                        item.getType() != Material.COOKED_PORKCHOP && item.getType() != Material.COD && item.getType() != Material.SALMON &&
                        item.getType() != Material.TROPICAL_FISH && item.getType() != Material.PUFFERFISH && item.getType() != Material.COOKED_COD &&
                        item.getType() != Material.COOKED_SALMON && item.getType() != Material.CAKE && item.getType() != Material.COOKIE &&
                        item.getType() != Material.MELON_SLICE && item.getType() != Material.DRIED_KELP && item.getType() != Material.BEEF &&
                        item.getType() != Material.COOKED_BEEF && item.getType() != Material.CHICKEN && item.getType() != Material.COOKED_CHICKEN &&
                        item.getType() != Material.CARROT && item.getType() != Material.POTATO && item.getType() != Material.BAKED_POTATO &&
                        item.getType() != Material.PUMPKIN_PIE && item.getType() != Material.RABBIT && item.getType() != Material.COOKED_RABBIT &&
                        item.getType() != Material.BEETROOT && item.getType() != Material.SWEET_BERRIES && item.getType() != Material.GLOW_BERRIES &&
                        item.getType() != Material.MUTTON && item.getType() != Material.COOKED_MUTTON && item.getType() != Material.DRIED_KELP_BLOCK &&
                        item.getType() != Material.MELON && item.getType() != Material.PUMPKIN && item.getType() != Material.CARVED_PUMPKIN &&
                        item.getType() != Material.WHEAT && item.getType() != Material.WHEAT_SEEDS && item.getType() != Material.COCOA_BEANS &&
                        item.getType() != Material.PUMPKIN_SEEDS && item.getType() != Material.MELON_SEEDS && item.getType() != Material.BEETROOT_SEEDS &&
                        item.getType() != Material.NETHER_WART && item.getType() != Material.NETHER_WART_BLOCK) return;

                levelled.setLevel(levelled.getLevel()+1);
                block.setBlockData(levelled);

                if(item.getAmount() > 1)
                    item.setAmount(item.getAmount()-1);
                else
                    item.setAmount(0);

            }
            if(block.getType() == Material.CAULDRON) {
                PersistentDataContainer container = new CustomBlockData(block, ExNihilo.getPlugin());

                // Wooden Crucible

                if(container.has(new NamespacedKey(ExNihilo.getPlugin(), "wooden_crucible_block"), PersistentDataType.INTEGER)) {
                    NamespacedKey keyLevel = new NamespacedKey(ExNihilo.getPlugin(), "wooden_crucible_block_level");

                    if(item.getType() == Material.WATER_BUCKET) {
                        container.set(keyLevel, PersistentDataType.INTEGER, 8);
                        return;
                    }
                    event.setCancelled(true);

                    if(item.getType() != Material.OAK_LEAVES && item.getType() != Material.SPRUCE_LEAVES &&
                            item.getType() != Material.BIRCH_LEAVES && item.getType() != Material.JUNGLE_LEAVES && item.getType() != Material.ACACIA_LEAVES &&
                            item.getType() != Material.DARK_OAK_LEAVES && item.getType() != Material.MANGROVE_LEAVES && item.getType() != Material.AZALEA_LEAVES &&
                            item.getType() != Material.FLOWERING_AZALEA_LEAVES) return;
                    if(!container.has(keyLevel, PersistentDataType.INTEGER)) return;
                    if(container.get(keyLevel, PersistentDataType.INTEGER) != 0) return;

                    if(item.getAmount() > 1)
                        item.setAmount(item.getAmount()-1);
                    else
                        item.setAmount(0);

                    block.setType(Material.WATER_CAULDRON);
                    container.set(keyLevel, PersistentDataType.INTEGER, 1);
                    return;
                }

                // Crucible

                if(container.has(new NamespacedKey(ExNihilo.getPlugin(), "crucible_block"), PersistentDataType.INTEGER)) {
                    NamespacedKey keyLevel = new NamespacedKey(ExNihilo.getPlugin(), "crucible_block_level");

                    if(item.getType() == Material.WATER_BUCKET) {
                        container.set(keyLevel, PersistentDataType.INTEGER, 8);
                        return;
                    }
                    if(item.getType() == Material.LAVA_BUCKET) {
                        container.set(keyLevel, PersistentDataType.INTEGER, 8);
                        return;
                    }
                    event.setCancelled(true);

                    if(item.getType() == Material.OAK_LEAVES || item.getType() == Material.SPRUCE_LEAVES ||
                            item.getType() == Material.BIRCH_LEAVES || item.getType() == Material.JUNGLE_LEAVES || item.getType() == Material.ACACIA_LEAVES ||
                            item.getType() == Material.DARK_OAK_LEAVES || item.getType() == Material.MANGROVE_LEAVES || item.getType() == Material.AZALEA_LEAVES ||
                            item.getType() == Material.FLOWERING_AZALEA_LEAVES) {
                        if(!container.has(keyLevel, PersistentDataType.INTEGER)) return;
                        if(container.get(keyLevel, PersistentDataType.INTEGER) != 0) return;

                        if(item.getAmount() > 1)
                            item.setAmount(item.getAmount() - 1);
                        else
                            item.setAmount(0);

                        block.setType(Material.WATER_CAULDRON);
                        container.set(keyLevel, PersistentDataType.INTEGER, 1);
                        return;
                    }
                    if(item.getType() == Material.COBBLESTONE || item.getType() == Material.COBBLED_DEEPSLATE || item.getType() == Material.STONE || item.getType() == Material.DEEPSLATE ||
                            item.getType() == Material.GRAVEL) {
                        if(!container.has(keyLevel, PersistentDataType.INTEGER)) return;

                        switch (block.getLocation().subtract(0,1,0).getBlock().getType()) {
                            case LAVA -> {
                                // 50 %
                                int random = (int) (Math.random()*2+1);
                                if(random != 1) return;
                            }
                            case FIRE, SOUL_FIRE -> {
                                // 33 %
                                int random = (int) (Math.random()*3+1);
                                if(random != 1) return;
                            }
                            case CAMPFIRE, SOUL_CAMPFIRE -> {
                                // 20 %
                                int random = (int) (Math.random()*5+1);
                                if(random != 1) return;
                            }
                            case TORCH, WALL_TORCH, SOUL_TORCH, SOUL_WALL_TORCH -> {
                                // 5 %
                                int random = (int) (Math.random()*20+1);
                                if(random != 1) return;
                            }
                        }
                        if(item.getAmount() > 1)
                            item.setAmount(item.getAmount() - 1);
                        else
                            item.setAmount(0);

                        if(container.get(keyLevel, PersistentDataType.INTEGER) == 8) {
                            block.setType(Material.LAVA_CAULDRON);
                            player.playSound(player.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH, 1f, 1f);
                            container.set(keyLevel, PersistentDataType.INTEGER, 0);
                            return;
                        }
                        player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1f, 1f);
                        container.set(keyLevel, PersistentDataType.INTEGER, container.get(keyLevel, PersistentDataType.INTEGER)+1);
                        return;
                    }
                }



            }
            if(block.getType() == Material.WATER_CAULDRON) {
                PersistentDataContainer container = new CustomBlockData(block, ExNihilo.getPlugin());
                Levelled levelled = (Levelled) block.getBlockData();

                // Wooden Crucible

                if(container.has(new NamespacedKey(ExNihilo.getPlugin(), "wooden_crucible_block"), PersistentDataType.INTEGER)) {
                    if(item.getType() == Material.LAVA_BUCKET) { event.setCancelled(true); return; }

                    NamespacedKey keyLevel = new NamespacedKey(ExNihilo.getPlugin(), "wooden_crucible_block_level");
                    if(!container.has(keyLevel, PersistentDataType.INTEGER)) return;
                    if(item.getType() == Material.GLASS_BOTTLE) { event.setCancelled(true); return; }

                    if(item.getType() == Material.BUCKET) {
                        container.set(keyLevel, PersistentDataType.INTEGER, 0);
                        return;
                    }

                    if(levelled.getMaximumLevel() == levelled.getLevel()) {
                        if(item.hasItemMeta()) {
                            if(item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(ExNihilo.getPlugin(), "dust"), PersistentDataType.INTEGER)) {
                                event.setCancelled(true);
                                block.setType(Material.CAULDRON);
                                container.set(keyLevel, PersistentDataType.INTEGER, 0);

                                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.CLAY));
                                if (item.getAmount() > 1)
                                    item.setAmount(item.getAmount() - 1);
                                else
                                    item.setAmount(0);
                                return;
                            }
                        }
                        if(item.getType() == Material.MILK_BUCKET) {
                            event.setCancelled(true);
                            block.setType(Material.CAULDRON);
                            container.set(keyLevel, PersistentDataType.INTEGER, 0);

                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SLIME_BALL));
                            item.setType(Material.BUCKET);
                            return;
                        }


                        return;
                    }
                    if(item.getType() == Material.OAK_LEAVES || item.getType() == Material.SPRUCE_LEAVES ||
                            item.getType() == Material.BIRCH_LEAVES || item.getType() == Material.JUNGLE_LEAVES || item.getType() == Material.ACACIA_LEAVES ||
                            item.getType() == Material.DARK_OAK_LEAVES || item.getType() == Material.MANGROVE_LEAVES || item.getType() == Material.AZALEA_LEAVES ||
                            item.getType() == Material.FLOWERING_AZALEA_LEAVES) {
                        event.setCancelled(true);

                        if(item.getAmount() > 1)
                            item.setAmount(item.getAmount()-1);
                        else
                            item.setAmount(0);

                        if(container.get(keyLevel, PersistentDataType.INTEGER) == 4 || container.get(keyLevel, PersistentDataType.INTEGER) == 7) {
                            levelled.setLevel(levelled.getLevel()+1);
                            block.setBlockData(levelled);
                            container.set(keyLevel, PersistentDataType.INTEGER, container.get(keyLevel, PersistentDataType.INTEGER)+1);
                            return;
                        }
                        if(container.get(keyLevel, PersistentDataType.INTEGER) == 1 || container.get(keyLevel, PersistentDataType.INTEGER) == 2 || container.get(keyLevel, PersistentDataType.INTEGER) == 3 ||
                                container.get(keyLevel, PersistentDataType.INTEGER) == 5 || container.get(keyLevel, PersistentDataType.INTEGER) == 6)
                            container.set(keyLevel, PersistentDataType.INTEGER, container.get(keyLevel, PersistentDataType.INTEGER) + 1);
                        return;
                    }

                }

                // Crucible

                if(container.has(new NamespacedKey(ExNihilo.getPlugin(), "crucible_block"), PersistentDataType.INTEGER)) {
                    NamespacedKey keyLevel = new NamespacedKey(ExNihilo.getPlugin(), "crucible_block_level");
                    if(!container.has(keyLevel, PersistentDataType.INTEGER)) return;
                    if(item.getType() == Material.GLASS_BOTTLE) { event.setCancelled(true); return; }

                    if(item.getType() == Material.BUCKET) {
                        container.set(keyLevel, PersistentDataType.INTEGER, 0);
                        return;
                    }

                    if(levelled.getMaximumLevel() == levelled.getLevel()) {
                        if(item.hasItemMeta()) {
                            if(item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(ExNihilo.getPlugin(), "dust"), PersistentDataType.INTEGER)) {
                                event.setCancelled(true);
                                block.setType(Material.CAULDRON);
                                container.set(keyLevel, PersistentDataType.INTEGER, 0);

                                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.CLAY));
                                if (item.getAmount() > 1)
                                    item.setAmount(item.getAmount() - 1);
                                else
                                    item.setAmount(0);
                                return;
                            }
                        }
                        if(item.getType() == Material.MILK_BUCKET) {
                            event.setCancelled(true);
                            block.setType(Material.CAULDRON);
                            container.set(keyLevel, PersistentDataType.INTEGER, 0);

                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SLIME_BALL));
                            item.setType(Material.BUCKET);
                            return;
                        }


                        return;
                    }
                    if(item.getType() == Material.OAK_LEAVES || item.getType() == Material.SPRUCE_LEAVES ||
                            item.getType() == Material.BIRCH_LEAVES || item.getType() == Material.JUNGLE_LEAVES || item.getType() == Material.ACACIA_LEAVES ||
                            item.getType() == Material.DARK_OAK_LEAVES || item.getType() == Material.MANGROVE_LEAVES || item.getType() == Material.AZALEA_LEAVES ||
                            item.getType() == Material.FLOWERING_AZALEA_LEAVES) {
                        event.setCancelled(true);

                        if(item.getAmount() > 1)
                            item.setAmount(item.getAmount()-1);
                        else
                            item.setAmount(0);

                        if(container.get(keyLevel, PersistentDataType.INTEGER) == 4 || container.get(keyLevel, PersistentDataType.INTEGER) == 7) {
                            levelled.setLevel(levelled.getLevel()+1);
                            block.setBlockData(levelled);
                            container.set(keyLevel, PersistentDataType.INTEGER, container.get(keyLevel, PersistentDataType.INTEGER)+1);
                            return;
                        }
                        if(container.get(keyLevel, PersistentDataType.INTEGER) == 1 || container.get(keyLevel, PersistentDataType.INTEGER) == 2 || container.get(keyLevel, PersistentDataType.INTEGER) == 3 ||
                                container.get(keyLevel, PersistentDataType.INTEGER) == 5 || container.get(keyLevel, PersistentDataType.INTEGER) == 6)
                            container.set(keyLevel, PersistentDataType.INTEGER, container.get(keyLevel, PersistentDataType.INTEGER) + 1);
                        return;
                    }

                }

            }
            if(block.getType() == Material.LAVA_CAULDRON) {




            }

        }


    }

}
