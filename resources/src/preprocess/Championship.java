package preprocess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Championship {
	private String championshipName;
	private ArrayList<Match> matchesArray = new ArrayList<Match>(); 
	private ArrayList<String> teams = new ArrayList<String>();
	private HashMap<String, Integer> goals = new HashMap<String, Integer>();
	
	
	public Championship(String name)
	{
		this.championshipName = name;

	}
	
	private void setTeams() {
		for(Match match : matchesArray)
		{
			String aTeam = match.getAwayTeam();
			String hTeam = match.getHomeTeam();
			if(!teams.contains(aTeam))
				teams.add(aTeam);
			
			if(!teams.contains(hTeam))
				teams.add(hTeam);
			
		}
		
	}

	public boolean addGame(Match game)
	{
		return matchesArray.add(game);
	}
	
	public boolean removeGame (Match game)
	{
		return matchesArray.remove(game);
	}
	
	public int totalGoals (String team)
	{
		return 0;
	}
	
	public String toString()
	{
		return championshipName + matchesArray.size();
	}
	
	public String getName()
	{
		return championshipName;
	}
	
	public ArrayList<String> getTeams()
	{
		setTeams();
		return teams;
	}
	
	public HashMap<String,Integer> getGoals()
	{
		setTeams();
		for(String team : teams)
		{
			
			int totalGoals = 0;
			for(Match m : matchesArray)
			{
				if(m.getAwayTeam().equals(team))
				{
					totalGoals += m.FTAG;
				}
				else if(m.getHomeTeam().equals(team))
					totalGoals += m.FTHG;
			}
			System.out.println(team + " " + totalGoals);
			goals.put(team, totalGoals);
		}
		return goals;
		
	}
	
	public String[][] gamesTwoTeams(String team1, String team2)
	{
		String[][] result = new String[10][5];
		int matchCount = 0;
		for (Match m : matchesArray)
		{

			if ( m.getAwayTeam().equals(team1) && m.getHomeTeam().equals(team2))
			{
				result[matchCount][0] = team1;
				result[matchCount][1] = team2;
				result[matchCount][2] = "" + m.FTAG;
				result[matchCount][3] = "" + m.FTHG;
				result[matchCount][4] = "" + m.date;
				matchCount++;
			}
			else if (m.getAwayTeam().equals(team2) && m.getHomeTeam().equals(team1))
			{
				result[matchCount][0] = team2;
				result[matchCount][1] = team1;
				result[matchCount][2] = "" + m.FTAG;
				result[matchCount][3] = "" + m.FTHG;
				result[matchCount][4] = "" + m.date;
				matchCount++;
			}
			
			
		}
		return result;
		
	}
}
