//subklass
//unika metoder hos varje subklass
//enda som kan utföra denna metod är denna klass

public class LAB4_Personer_FRITID extends LAB4_Personer_JOBB //extends "ärver", dvs, tar info från staff
{

	public void fritid1()
	{
		System.out.println(name + " tycker om basket");
	}
	public void fritid2()
	{
		System.out.println(name + " tycker om datorspel");
	}
	public void fritid3()
	{
		System.out.println(name + " tycker om Java");
	}

}