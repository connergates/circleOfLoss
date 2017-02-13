package circleOfLoss;

import java.util.Date;

public class Game
{
	private Date mGameDate;
	
	private GameLocation mGameLocation;
	
	private Team mTeamOne;
	
	private Team mTeamTwo;
	
	private int mTeamOneScore;
	
	private int mTeamTwoScore;
	
	public Game(Date gameDate, GameLocation gameLocation, Team teamOne, int teamOneScore, Team teamTwo, int teamTwoScore)
	{
		mGameDate = gameDate;
		
		mGameLocation = gameLocation;
		
		mTeamOne = teamOne;
		
		mTeamTwo = teamTwo;
		
		mTeamOneScore = teamOneScore;
		
		mTeamTwoScore = teamTwoScore;
	}
	
	@Override
	public boolean equals(Object object)
	{
		if(object instanceof Game)
		{
			return ((Game) object).mGameDate == mGameDate 
					&& ((Game)object).mTeamOne == mTeamOne 
					&& ((Game)object).mTeamTwo == mTeamTwo;
		}
		
		return false;
	}
}
