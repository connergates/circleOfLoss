package circleOfLoss;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String args[])
	{
		System.out.println("Hello World");
		
		ArrayList<Node> teamRecords =  new ArrayList<Node>();
		
		teamRecords = importTeams();
		
	}
	
	
	//ArrayList<ArrayList<Integer>>
	public static ArrayList<Node>	importTeams()
	{	
		//NEED TO CHECK FOR THIS NUMBER 
		int numTeams = 351;
		ArrayList<Node> teamRecords =  new ArrayList<Node>(numTeams);
		try{
			String directory = System.getProperty("user.dir");
			File textFile = new File(directory + "/" + "2016_GamesV2.txt");
			

			Scanner sc = new Scanner(textFile);
			
			//NEED WAY TO CHECK NUM OF LINES IN TXT FILE
			int numLines = 5516;
			int i = 1;
			while (i <= numLines) { 
			
				String readLine = sc.nextLine();
				String[] stringArray = readLine.split(",");
				
				Integer wTeamNumber = Integer.parseInt(stringArray[2].trim()) - 1;
				Integer lTeamNumber = Integer.parseInt(stringArray[5].trim()) - 1;
			
				int teamIndex = teamRecords.indexOf(new Node(wTeamNumber));
				
				if (teamIndex >= 0) { //If team exists
					// add new team to the beaten of the given index	
					if (teamRecords.get(teamIndex).beaten.contains(lTeamNumber)) { 
						
					} else { 
						teamRecords.get(teamIndex).addToBeaten(lTeamNumber);	
					}
				
				} else {
					
					Node winningTeam = new Node(wTeamNumber);
					winningTeam.addToBeaten(lTeamNumber);
					
					teamRecords.add(winningTeam);	
				}
				
				i++;
				
			}
			
			System.out.println("Nodes Created");
			
		} catch (Exception e){
			e.printStackTrace();
		}
			
		return teamRecords;
	}
}
