package circleOfLoss;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}
	
	
	
	public static ArrayList<ArrayList<Integer>> importTeams()
	{	
		try{
			String directory = System.getProperty("user.dir");
			File textFile = new File(directory + "/" + "2016_GamesV2.txt");
			
			ArrayList<ArrayList<Integer>> teamRecords =  new ArrayList<ArrayList<Integer>>();
			Scanner sc = new Scanner(textFile);
		} catch (Exception e){
			
		}
			
		return teamRecords;
	}
}
