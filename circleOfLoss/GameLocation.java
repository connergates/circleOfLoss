package circleOfLoss;

public enum GameLocation
{
	TEAM_ONE_HOME(1),
	
	TEAM_TWO_HOME(-1),
	
	NEUTRAL_LOCATION(0);
	
	private int mRawLocation;
	
	GameLocation(int rawLocation)
	{
		mRawLocation = rawLocation;
	}
	
	public static GameLocation generateLocation(int location)
	{
		for(GameLocation gameLocation : GameLocation.values())
		{
			if(gameLocation.mRawLocation == location)
			{
				return gameLocation;
			}
		}
		
		return NEUTRAL_LOCATION;
	}
}
