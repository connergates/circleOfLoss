package circleOfLoss;

import java.util.ArrayList;

public class Team 
{
	private String mTeamName;
	
	private int mTeamNumber; 
	
	private ArrayList<Game> mGamesPlayed; 
	
	public Team(int teamNumber)
	{
		this("", teamNumber);
	}
	
	public Team(String teamName, int teamNumber)
	{
		mTeamName = teamName;
		
		mTeamNumber = teamNumber;
				
		mGamesPlayed = new ArrayList<Game>();	
	}
	
	public void addGamePlayed(Game playedGame)
	{
		mGamesPlayed.add(playedGame);
	}
	
	@Override 
	public boolean equals(Object object)
	{
		if(object instanceof Team)
		{
			return this.mTeamNumber == ((Team)object).mTeamNumber;
		}
			
		return false;
	}
}
