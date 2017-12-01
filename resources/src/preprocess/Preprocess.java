package preprocess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Preprocess {
	public static BufferedReader brd;
	private static ArrayList<Championship> championships = new ArrayList<Championship>(); 
	public static Championship champ;

	public static void main (String[] args){
		//championships contains all competitions that contain premier in their name
		championships = readAll("Premier");
		System.out.println(championships);
		
		//mostRecentPreprocess(championships);
		//allPreprocess(championships);
		
		
		
		//compiling matches between two teams
		String[][] result = new String[100][5];
		int line = 0;
		for (Championship champ : championships)
		{
			String[][] twoTeams = champ.gamesTwoTeams("Leicester", "Arsenal");
			
			
			for (int i=0 ; i<twoTeams.length ; i++)
			{
				
					if (twoTeams[i][1] != null)
					{
						result[line] = twoTeams[i];
						line++;
					}
				
			}
		}
		
		// printing the final matrix with all matches between the two teams
		for (int i=0 ; i<result.length ; i++)
		{
			//to not have excess returns
			if(result[i][0] != null)
				System.out.println();
			for (int j=0 ; j<5 ; j++)
			{
				if(result[i][0] != null)
					System.out.print(result[i][j] + " ");
			}
		}
		
	}

	private static void allPreprocess(ArrayList<Championship> championships2) {
		
		
	}
	
	//goals
	private static void mostRecentPreprocess(ArrayList<Championship> championships2) {
		for (Championship champ : championships2)
		{
			if(champ.getName().contains("2015")) //set year
			{
				HashMap<String, Integer> goals = new HashMap<String, Integer>();
				goals = champ.getGoals();
				PrintWriter writer = null;
				try {
					writer = new PrintWriter("mostRecentPre.txt", "UTF-8");
					Iterator it = goals.entrySet().iterator();
					while(it.hasNext())
					{
						Map.Entry pair = (Map.Entry)it.next();
						writer.println(pair.getKey() + " "+  pair.getValue());
						it.remove();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					writer.close();
				}
				
				
				
			}
		}
		
	}

	private static ArrayList<Championship> readAll(String fileHandle) {
		ArrayList<Championship> competition = new ArrayList<Championship>();
		File folder = new File("/Users/Jeff/Documents/workspace/Uni/Year3/ProjectY3/resources");
		File[] listOfFiles = folder.listFiles();
		
		for(File file : listOfFiles)
		{
			if(file.isFile())
			{
				if(file.getName().contains(fileHandle))
				{
					champ = new Championship(file.getName());
					try{
						Match current;
			            brd = new BufferedReader(new FileReader(file));
			            brd.readLine();
			          
			            while ( brd.ready()) {
			                String st = brd.readLine();
			                if (st.contains("nothing"))
			                {
			                	break;
			                }
			                
			                String[] OneRow = st.split(",");
			                
			                
			                
			                current = new Match(OneRow[0], OneRow[1],OneRow[2],OneRow[3], Integer.parseInt(OneRow[4]), Integer.parseInt(OneRow[5]),OneRow[6]
			                		,Integer.parseInt(OneRow[7]),Integer.parseInt(OneRow[8]),OneRow[9]);
			                
			               
			               champ.addGame(current);
			            }
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
			           // System.out.println("File not found:" + errmsg);
					}
					competition.add(champ);
					
				}
			}
		}
		return competition;
		
	}
}


