/*
 * Village Defense 3 - Protect villagers from hordes of zombies
 * Copyright (C) 2018  Plajer's Lair - maintained by Plajer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.plajer.villagedefense3.user;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

import pl.plajer.villagedefense3.Main;
import pl.plajer.villagedefense3.arena.Arena;
import pl.plajer.villagedefense3.arena.ArenaRegistry;
import pl.plajer.villagedefense3.kits.kitapi.KitRegistry;
import pl.plajer.villagedefense3.kits.kitapi.basekits.Kit;
import pl.plajer.villagedefense3.villagedefenseapi.StatsStorage;
import pl.plajer.villagedefense3.villagedefenseapi.VillagePlayerStatisticChangeEvent;

/**
 * Created by Tom on 27/07/2014.
 */
public class User {

  private static Main plugin = JavaPlugin.getPlugin(Main.class);
  private static long cooldownCounter = 0;
  private ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
  private UUID uuid;
  private boolean spectator = false;
  private Kit kit = KitRegistry.getDefaultKit();
  private Map<StatsStorage.StatisticType, Integer> stats = new HashMap<>();
  private Map<String, Long> cooldowns = new HashMap<>();

  public User(UUID uuid) {
    this.uuid = uuid;
  }

  public static void cooldownHandlerTask() {
    Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, () -> cooldownCounter++, 20, 20);
  }

  public Kit getKit() {
    if (kit == null) {
      throw new NullPointerException("User has no kit!");
    } else {
      return kit;
    }
  }

  public void setKit(Kit kit) {
    this.kit = kit;
  }

  public Arena getArena() {
    return ArenaRegistry.getArena(Bukkit.getPlayer(uuid));
  }

  public Player toPlayer() {
    return Bukkit.getServer().getPlayer(uuid);
  }

  public boolean isSpectator() {
    return spectator;
  }

  public void setSpectator(boolean b) {
    spectator = b;
  }

  public int getStat(StatsStorage.StatisticType s) {
    if (!stats.containsKey(s)) {
      stats.put(s, 0);
      return 0;
    } else if (stats.get(s) == null) {
      return 0;
    }
    return stats.get(s);
  }

  public void removeScoreboard() {
    this.toPlayer().setScoreboard(scoreboardManager.getNewScoreboard());
  }

  public void setStat(StatsStorage.StatisticType s, int i) {
    stats.put(s, i);

    //statistics manipulation events are called async when using mysql
    Bukkit.getScheduler().runTask(plugin, () -> {
      VillagePlayerStatisticChangeEvent villagePlayerStatisticIncreaseEvent = new VillagePlayerStatisticChangeEvent(getArena(), toPlayer(), s, i);
      Bukkit.getPluginManager().callEvent(villagePlayerStatisticIncreaseEvent);
    });
  }

  public void addStat(StatsStorage.StatisticType s, int i) {
    stats.put(s, getStat(s) + i);

    //statistics manipulation events are called async when using mysql
    Bukkit.getScheduler().runTask(plugin, () -> {
      VillagePlayerStatisticChangeEvent villagePlayerStatisticIncreaseEvent = new VillagePlayerStatisticChangeEvent(getArena(), toPlayer(), s, getStat(s));
      Bukkit.getPluginManager().callEvent(villagePlayerStatisticIncreaseEvent);
    });
  }

  public void setCooldown(String s, int seconds) {
    cooldowns.put(s, seconds + cooldownCounter);
  }

  public long getCooldown(String s) {
    if (!cooldowns.containsKey(s) || cooldowns.get(s) <= cooldownCounter) {
      return 0;
    }
    return cooldowns.get(s) - cooldownCounter;
  }

}
