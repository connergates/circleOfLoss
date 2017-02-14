package circleOfLoss;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String args[])
	{
		System.out.println("Hello World");
		importTeams();
	}
	
	
	//ArrayList<ArrayList<Integer>>
	public static void	importTeams()
	{	
		try{
			String directory = System.getProperty("user.dir");
			File textFile = new File(directory + "/" + "2016_GamesV2.txt");
			
			ArrayList<Node> teamRecords =  new ArrayList<Node>();
			Scanner sc = new Scanner(textFile);
			
			int i = 1;
			
				String readLine = sc.nextLine();
				String[] stringArray = readLine.split(",");
				
				Integer wTeamNumber = Integer.parseInt(stringArray[2]);
				Integer lTeamNumber = Integer.parseInt(stringArray[5]);
				
				Node winningTeam = new Node(wTeamNumber);
				winningTeam.addToBeaten(lTeamNumber);
				
				teamRecords.add(winningTeam);
			
			
		} catch (Exception e){
			e.printStackTrace();
		}
			
		//return teamRecords;
	}
}
