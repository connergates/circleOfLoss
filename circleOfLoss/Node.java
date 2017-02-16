package circleOfLoss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Node implements Comparator<Node> {
	private int teamNumber;
	private ArrayList<Integer> beaten = new ArrayList<Integer>(); 

	public Node(int teamNum)
	{
		teamNumber = teamNum;
	}
	
	public int getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}

	public void addToBeaten(Integer loser)
	{
		beaten.add(loser);
	}

	@Override
	public int compare(Node o1, Node o2) {
		if(o1.getTeamNumber() > o2.getTeamNumber())
		{
			return 1;
		}
		else if(o1.getTeamNumber() < o2.getTeamNumber())
		{
			return -1;
		}
		return 0;
		
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
		{
			return true;
		}
		if(!(obj instanceof Node))
		{
			return false;
		}
		Node node = (Node) obj;
		return this.teamNumber == node.teamNumber;
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(teamNumber);
	}
}
