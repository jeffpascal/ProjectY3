package preprocess;

import java.util.Date;

public class Match { 
	protected String div;  //league divison
	protected String date;  //match date
	protected String homeTeam;  //home team
	protected String awayTeam; // away team
	public int FTHG; //full time home team goals
	public int FTAG; //full time away team goals
	protected String FTR; // full time result h= home win, d = draw, a = away win
	protected int HTHG; //half time home goals
	protected int HTAG; //half time away goals
	protected String HTR; // half time result h= home win, d = draw, a = away win
	
	public Match (String div, String date, String homeTeam, String awayTeam, int FTHG, int FTAG
			, String FTR, int HTHG, int HTAG, String HTR)
	{
		this.div = div;
		this.date = date;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.FTHG = FTHG;
		this.FTAG = FTAG;
		this.FTR = FTR;
		this.HTHG = HTHG;
		this.HTAG = HTAG;
		this.HTR = HTR;
	}
	
	public String toString()
	{
		return "" + div + " " + date + " " + homeTeam + " " + awayTeam + " " 
				+ FTHG + " " + FTAG + " " + FTR + " " + HTHG + " " + HTAG + " " + HTR;
	}
	
	public String getHomeTeam()
	{
		return homeTeam;
	}
	
	public String getAwayTeam()
	{
		return awayTeam;
	}
	

}
