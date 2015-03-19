import java.util.*;

//superklass
//håller alla gemensammna variablar/metoder för de andra klasserna

public class LAB4_Personer_JOBB
{
	String name;
	//alla klasser ärver Stringen 'name'
	
	public void Jobb1()
	{
		System.out.println(name + " jobbar på bank");
	}
	public void Jobb2()
	{
		System.out.println(name + " jobbar som domare");
	}
	public void Jobb3()
	{
		System.out.println(name + " jobbar som lärare");
	}
	public void Jobb4()
	{
		System.out.println(name + " jobbar på ICA");
	}


}