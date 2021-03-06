# Village Defense 3 Changelog

### Version Release
* Added cancel lobbystart when there are not enough players

### 3.12 Release (07.09.2018)
* Dropped 1.9-1.10 support
* /vda reload now force players to quit to prevent problems
* Now shop will be successfully registered when arena is freshly created
* Added villagedefense.command.override permission to be able to use all game commands while being in VillageDefense game

### 3.11.2 Release (03.09.2018)
* Temporarily merged PLCore to fix issues when using my other plugins

### 3.11.1 Release (01.09.2018)
* Fixed update checker bugs while using my other mini games
* Fixed errors in console for 1.13 - sounds problem

### 3.11.0 Release (19/26.08.2018)
* Now removing invalid players in game when getPlayers() method is invoked
* Fixed NullPointerException for users who were no longer online
* Some code improvements
* Added dynamic locale manager system - you can now get latest locales on demand from our repository
* Added Romanian locale
* Added 1.13.1 support
* Fixed scoreboard color bugs (see https://i.imgur.com/kaZy5s2.png)
* Fixed this bug https://github.com/Plajer-Lair/Village_Defense/issues/10
* Some MySQL improvements
* Moved some bad console messages to debugger
* Some small fixes for errors from Error service
* Added PlaceholderAPI placeholders support in scoreboard

### 3.10.1 Release (13/17.08.2018)
* Fixed NullPointerException in combust event (reported anonymously via Error service) (#1 error service report)
* Fixed IndexOutOfBoundsException in join event while bungee is enabled (reported anonymously via Error service) (#2 error service report)
* Added configurable time between next waves (for example for implementing custom bosses using wave end rewards :))
* Fixed NullPointerException in add orbs other method in vda command (reported anonymously via Error service)
* Fixed NullPointerException while using setup menu while using my other minigames (like BuildBattle) (reported anonymously via Error service)
* Fixed NumberFormatException for language.yml migrator - this problem is very rare to occur but it was reported so fix was done
* Some 2 other small fixes for errors that MAY be fixed (and may not)

### 3.10.0 Release (08.08.2018)
* Built against PLCore API
* Fixed MySQL error when creating it for first time
* Fixed error in 1.9 versions in game
* Updated German locale
* Dropped WorldEdit support

### 3.9.2 Release (03.08.2018)
* Fixed InventoryManager errors due to scoreboard saving in it
* Updated French and Hungarian locales

### 3.9.1 Release (26.07.2018)
* Fixed Unknown Player bug in /vd top while using database (now user names are stored in database)
(will take a while until all Unknown Player records will be changed to Player names cause they are overridden every quit event)
* Fixed Vietnamese locale
* Fixed 1.13 not working
* Fixed /vd command wasn't working in game
* Added scoreboard saving in inventory manager
* Added Chinese (Simplified) locale support
* Fixed /vd randomjoin wasn't working

### 3.9.0 Release (16/17.07.2018)
* Added support for 1.13-pre7
* Removed deprecated commands (/vda setshopchest and /vda addsign) - they were deprecated and not working
* Updated locales messages
* Added /vd randomjoin command for multi arena server
* Added info when setting empty shop chest
* Added 1.10 support
* Optimized code a bit

### 3.8.2 Release (12.07.2018)
* Bring back Vietnamese locale support

### 3.8.1 Release (02.07.2018)
* /vd top command and other not working /vd commands will now work in game
* Dropped Vietnamese locale as this translation was in 50% of English messages...
* Fixed locales loading not working, plugin wasn't even enabled

### 3.8.0 Release (29.06.2018)
* API update - added new events: VillageGameStateChangeEvent, VillageGolemUpgradeEvent, VillagePowerupPickEvent and VillagePlayerStatisticChangeEvent
* Added orbs StatisticType to StatsStorage class (keep in mind that orbs stat is a temporary statistic for each game!)
* Added wolves and golems limit per player

### 3.7.6 Release (28.06.2018)
* Now you will see setup video link when creating new arena
* Using placeholder for golem upgrades cost to be corresponding to golem upgrades values from config.yml (makes locales more adaptive)
* Added Vietnamese localization support (thanks to POEditor contirbutors!)

### 3.7.5 Release (23/27.06.2018)
* Implemented Spanish, French and Indonesian localization support (thanks to POEditor contributors!)
* Updated other locales translations (thanks to POEditor contributors!)
* Added few more translatable admin messages (thanks to montlikadani for contribution!)
* Fixed NPE for 1.8 boss bar users

### 3.7.4 Release (22.06.2018)
* Implemented localization support via .properties files - more info later
* Added whitelisted commands configurable in config.yml
* Now admin commands won't be blocked via blocked commands in game
* Using default config values in case of config gets totally reset (somehow)

### 3.7.3 Release (14.06.2018)
* Fixed boss bar startup errors
* Removed usage of basic permission "arena edit"

### 3.7.2 Release (04.06.2018)
* Added sign block states of the game
* Added /vd selectkit command to select kit in game (permission villagedefense.command.selectkit)
* Fixed last Dark essence of Wizard kit wasn't removed when used
* Prettified commands now work properly at 1.9 and are available at 1.8
* Added BossBar for 1.8 versions

### 3.7.1 Release (25.05.2018)
* Full games permission now works for BungeeCord
* Can't combust villagers, iron golems and wolves now using flaming arrows

### 3.7.0 Release (23.05.2018)
* New modernized and customizable scoreboard
* /vda addsign is now deprecated, use Setup menu instead - changed due to some problems
* Now signs accept %state%, %players% etc placeholders in different lines! You can swap them how you want.
* Players with MVP and Elite permissions will be able to join full arenas now (only Vip permission worked)
* By default level kits were unlocked to operator players, now they won't
* Now spectators will not have night vision after respawn

### 3.6.3 Release (11/12.05.2018)
* Added tab completer
* Added did you mean to help with wrong commands (ex. /vd leaveve > Did you mean /vd leave?)
* Added line wrapping for blocker kit and some new comments in language.yml file
* Fixed #4 bug, mysql users should be aware of that problem especially users with cloud management systems
* Now removing boss bar of player when plugin gets disabled while games are on
* Re-commented rewards.yml file and added chance condition
* Overriding WorldGuard build deny flag which disallow Villager damage by zombies
* Fixed bug where flaming arrows from player could set on fire another player
* Reworked files migrator, now it will update config and language files without losing comments!

### 3.6.2 Release (04/10.05.2018)
* Fixed /vd create command without argument gave an error
* Added PlaceholderAPI support
* Fixed permissions for Worker and Blocker kits (villagedefense.kit.%kit name% wasn't working for them)
* Updated Java Docs and API for getting sorted statistics
* Fixed errors in console when offline player's wolves killed zombies
* Update notify permission for admins with villagedefense.admin.* added
* Now doors amount in setup menu will be normal (was 2x more because 1 door is 2 blocks)
* Fixed bug where power ups were staying in game even if we left it, now power ups will remove after 40 seconds after spawn
* Added /vd top <stat> command to show top 10 users!

### 3.6.1 Hotfix (04.05.2018)
* Fixed /vda command not working on 1.8

### 3.6.0 Release (04.05.2018)
* Code improvements
* Fixed another bug from early 2.x versions with cooldown drop faster depending on arenas number (ex. 2 arenas = 2 cooldown seconds less per second!)
* Wolves are rideable now
* Golems and wolves won't get drowned now, they can swim!
* Added new zombie spawning randomly in waves higher than 21! Villager Slayer.
* Fixed shotbow bow ability was working for every different kit
* Fixed /vd admin list command
* Prettified admin commands, now you don't need wiki for extended information about commands :)
* Fixed bug where you could throw any items to the secret well

### 3.5.0 Release (28.04.2018)
* Fixed #3 bug
* Fixed particles in 1.8
* Fixed files generation without comments
* Fixed TPS loss
* Now wizard staff's attack will damage zombie if zombie is in front of you (less than 1 block away)

### 3.4.0 Release (22.04.2018)
* Fixed major memory leak since 3.2.0
* Fixed setup errors on clean installation
* Fixed title message on death not displaying properly
* Fixed typo "plugin is up to date" instead of "plugin is outdated"

### 3.3.0 Release (20.04.2018)
* Added Powerups
* Fixed titles weren't displaying (bug since 2.1.x)
* Now removing potion effects from player after force server stop
* Organised code
* Enhanced Village Debugger
* Added generic VillageEvent event class

### 3.2.0 Release (1.04.2018)
* Small fix for plugin loading errors when dependencies weren't installed and plugin was disabled
* Using metadata for village defense entities
* Fixed permission villagedefense.join.<arena_name>
* Fixed client kick when trying to get spawn eggs
* Fixed compatibility with plugins like Citizens

### 3.1.3 Release (30.03.2018)
* Fixed zombies spawning warning in console (reported by transportowiec96)
* You can now ride villagers properly in 1.11
* Removed usage of /vda setshopchest command, now you can set shop chest via setup menu only
* Implemented iron golems riding in 1.8, 1.9 and 1.11 versions
* Improved Villagers pathfinders, now they will avoid zombies
* Fixed zombie kills stats counting
* Fixed zombie kills stats counting by wolves
* Fixed shop registering when reloading arenas via /vda reload

### 3.1.2 Release (28.03.2018)
* Fixed scoreboard issue

### 3.1.1 Release (28.03.2018)
* Fixed zombie kills stats counting X times on zombie death (based on created arenas size)
* Now wolf owner will get stat for killing zombie
* Optimized Tornado and Blocker kits schedulers (even if kits were unused)
* Buffed Archer kit's arrows amount per wave from 5 to 15
* Fixed small memory leak
* Fixed bStats new config generation in bStats/resources/ folder
* Improved auto respawn
* Added messages In-Game.Spectator.Target-Player-Health and Scoreboard.Footer
* Properly clearing player inventory when server is closed/plugin gets disabled
* Hypixelized plugin (sort of)
* Fixed some typos in setup menu
* Added night vision for spectators
* Fixed restart needed after shop was created

### 3.1.0 Release
* MAJOR EXPLOIT FIX - You could get rotten fleshes infinitely from secret well using freecam (Exploit since early 2.0 versions)
* Added permissions for signs creating and breaking
* Now you properly get Spectator menu on death
* Now players that join running arena gets bonus hearts that were added before from rotten fleshes

### 3.0.1 Release
* Fixed plugin startup error when using MySQL

### 3.0.0 Release
* Added game mode, saturation and flying state saving to Inventory Manager
* ZombieFinderKit fixes
* Some arenas fixes
* Fixed migrator (v2 > v3)
* Fixed arena registering via setup menu


