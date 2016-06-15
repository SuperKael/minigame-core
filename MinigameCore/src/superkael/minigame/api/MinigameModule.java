package superkael.minigame.api;

import org.bukkit.entity.Player;

public abstract class MinigameModule implements IMinigame{

	public static MinigameModule instance;
	
	public abstract String getID();
	public abstract String getGameName();
	
	public MinigameModule(){
		instance = this;
	}
	
	public final void loadGame(){
		onGameLoad();
	}
	
	public final void unloadGame(){
		onGameUnload();
	}
	
	@Override
	public IMinigame getInstance(){
		return instance;
	}
	
	public String[] dependencies(){
		return new String[]{};
	}
	
	public Player[] getPlayers(){
		return ZoneHelper.getPlayersInGame(getID());
	}
	
	public MinigameZone[] getZones(){
		return ZoneHelper.getZonesForGame(getID());
	}
	
	public MinigameZone[] getWorldZones(){
		return ZoneHelper.getWorldZonesForGame(getID());
	}
	
	public MinigameZone[] getAllZones(){
		return ZoneHelper.getAllZonesForGame(getID());
	}
	
	public void onGameLoad(){}
	public void onGameUnload(){}
	public void onTick(){}
	public void onActiveTick(){}
	public void onPlayerTick(MinigameZone zone, Player player){}
	public void onPlayerEnterGame(MinigameZone zone, Player player){}
	public void onPlayerExitGame(MinigameZone zone, Player player){}
	public void onZoneTick(MinigameZone zone){}
	public void onPlayerZoneTick(MinigameZone zone, Player player){}
	public void onPlayerEnterZone(MinigameZone zone, Player player){}
	public void onPlayerExitZone(MinigameZone zone, Player player){}
	public void onWorldTick(MinigameZone zone){}
	public void onPlayerWorldTick(MinigameZone zone, Player player){}
	public void onPlayerEnterWorld(MinigameZone zone, Player player){}
	public void onPlayerExitWorld(MinigameZone zone, Player player){}
	
}
