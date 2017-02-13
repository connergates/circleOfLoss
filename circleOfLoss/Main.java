package circleOfLoss;

public class Main 
{
	private static final String GAME_SCORE_FILE = "2016_GamesV2.txt";

	public static void main(String[] args)
	{
		GameData gameData = GameDataParser.parseData(GAME_SCORE_FILE);
		
		System.out.println("There are " + gameData.getTeamList().size() + " teams in the list");
		
		System.out.println("There are " + gameData.getGameList().size() + " games in the list");
	}
}
