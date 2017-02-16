package circleOfLoss;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String args[])
	{
		System.out.println("Hello World");
		
		ArrayList<Node> teamRecords =  new ArrayList<Node>();
		
		teamRecords = importTeams();
		Collections.sort(teamRecords);
		boolean result = hamPath(teamRecords, new ArrayList<Node>(), 0, 0);
		System.out.println(result);
		return;
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
	
	private static boolean hamPath(ArrayList<Node> graph, ArrayList<Node> used, int index, int start)
	{
		if(index == start && graph.size() == used.size())
		{
			return true;
		}
		boolean retVal = false;
		Node spot = graph.get(index);
		for(Node i : used)
		{
			if( i == spot)
			{
				return false;
			}
		}
		used.add(spot);
		for(int i : spot.beaten)
		{
			retVal = hamPath(graph, used, i, start);
			if(retVal)
			{
				break;
			}
		}
		used.remove(spot);
		return false || retVal;
	}
}
