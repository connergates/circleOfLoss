package circleOfLoss;

import java.util.ArrayList;

public class GameData
{
	private ArrayList<Team> mTeamList;
	
	private ArrayList<Game> mGameList;
	
	public GameData(ArrayList<Team> teamList, ArrayList<Game> gameList)
	{
		mTeamList = teamList;
		
		mGameList = gameList;
	}
	
	public ArrayList<Team> getTeamList()
	{
		return mTeamList;
	}
	
	public ArrayList<Game> getGameList()
	{
		return mGameList;
	}
}
