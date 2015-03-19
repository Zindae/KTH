//Klass 2 i LAB4_Flera_Konstruktorer.//

//this anv�nder de lokala variablarna,
//ist�llet f�r de globala (private, public)
public class LAB4_Flera_Konstruktorer_KLASS2
{
	
	private int timme;
	private int minut;
	private int sekund;
	
	 
	//olika konstruktorer anv�nds beroende p� hur m�nga argument som anv�nds
	public LAB4_Flera_Konstruktorer_KLASS2()
	{
		this(0,0,0);
		
	}
	public LAB4_Flera_Konstruktorer_KLASS2(int h)
	{
		this(h,0,0);
		
	}
	public LAB4_Flera_Konstruktorer_KLASS2(int h, int m)
	{
		this(h,m,0);
		
	}
	public LAB4_Flera_Konstruktorer_KLASS2(int h, int m, int s)
	{
		setTime(h,m,s);
		
	}
	//metoden setTime anropar ytterligare metoder 
	public void setTime(int h, int m, int s)
	{
		setHour(h);
		setMinute(m);
		setSecond(s);
	}

	//SET-Metoderna s�tter h,m,s till variablarna om vilkoren uppfylls, annars 0
	public void setHour(int h)
	{
		timme =  ((h >= 0 && h < 24) ? h : 0);
	}
	public void setMinute(int m)
	{
		minut =  ((m >= 0 && m < 60) ? m : 0);
	}
	public void setSecond(int s)
	{
		sekund = ((s >= 0 && s < 60) ? s : 0);
	}
	
	//GET-Metodena retunerar v�rderna
	public int getHour()
	{
		return timme;
	}
	public int getMinute()
	{
		return minut;
	}
	public int getSecond()
	{
		return sekund;
	}
	
	//Metoden formaterar tiden till digitaltid
	public String digitalTid()
	{
		return String.format("%02d: %02d: %02d", getHour(), getMinute(), getSecond());
	}


}
