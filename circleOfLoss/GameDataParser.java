package circleOfLoss;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GameDataParser
{
	private static final int DAYS_SINCE_1_1_0000_INDEX = 0;

	private static final int DATE_INDEX = 1;

	private static final int TEAM_1_INDEX = 2;

	private static final int HOME_FIELD_1_INDEX = 3;

	private static final int TEAM_1_SCORE_INDEX = 4;

	private static final int TEAM_2_INDEX = 5;

	private static final int HOME_FIELD_2_INDEX = 6;

	private static final int TEAM_2_SCORE_INDEX = 7;

	public static GameData parseData(String gameFileName)
	{
		return generateGameDataFromFile(gameFileName);
	}

	private static GameData generateGameDataFromFile(String fileName)
	{
		ArrayList<Team> teamList = new ArrayList<Team>();
		
		ArrayList<Game> gameList = new ArrayList<Game>();

		String directory = System.getProperty("user.dir");

		File gameDataFile = new File(directory + "/" + fileName);

		Scanner scanner = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

		try 
		{
			scanner = new Scanner(gameDataFile);

			while(scanner.hasNextLine())
			{
				String gameLine = scanner.nextLine();

				if(gameLine.replaceAll("\\s+","").equals(""))
				{
					continue;
				}
				
				String[] gameData = gameLine.split(",");

				String daysSince0000AD = gameData[DAYS_SINCE_1_1_0000_INDEX];

				String rawDate = gameData[DATE_INDEX].replaceAll("\\s+","");

				Date formattedGameDate = dateFormat.parse(rawDate);

				String team1NumberAsString = gameData[TEAM_1_INDEX].replaceAll("\\s+","");

				int team1Number = Integer.parseInt(team1NumberAsString);

				Team teamOne = new Team(team1Number);

				String gameLocationAsString = gameData[HOME_FIELD_1_INDEX].replaceAll("\\s+","");

				GameLocation location = GameLocation.generateLocation(Integer.parseInt(gameLocationAsString));

				String team1ScoreAsString = gameData[TEAM_1_SCORE_INDEX].replaceAll("\\s+","");

				int team1Score = Integer.parseInt(team1ScoreAsString);

				String team2NubmerAsString = gameData[TEAM_2_INDEX].replaceAll("\\s+","");

				int team2Number = Integer.parseInt(team2NubmerAsString);

				Team teamTwo = new Team(team2Number);

				String team2ScoreAsString = gameData[TEAM_2_SCORE_INDEX].replaceAll("\\s+","");

				int team2Score = Integer.parseInt(team2ScoreAsString);

				Game game = new Game(formattedGameDate, location, teamOne, team1Score, teamTwo, team2Score);
				
				teamOne.addGamePlayed(game);
				
				teamTwo.addGamePlayed(game);
				
				if(teamList.contains(teamOne) == false)
				{
					teamList.add(teamOne);
				}
				
				if(teamList.contains(teamTwo) == false)
				{
					teamList.add(teamTwo);
				}
				
				if(gameList.contains(game) == false)
				{
					gameList.add(game);
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(scanner != null)
			{
				scanner.close();
			}
		}

		return new GameData(teamList, gameList);	
	}
}
