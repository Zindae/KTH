
public class Up24 
{
	class StringCreator
	{
	private char[]    v;
	private int    count;
	
	public StringCreator (int capacity)
	
	{
    this.v = new char[capacity]; //ny char skapas fr�n denna v  
	count = 0; 
	}
	
	public void append (char c)
	{
        this.v[count++] = c; //c f�rl�ngs med count++
    }
	}
	
	class UseStringCreator
	{
    public static void main (String[] args)
    {
        StringCreator    sc = new StringCreator (4);
        char[]    c = {'a', 'b', 'c', 'd'};
        
        for (int i = 0; i < c.length; i++)
            sc.append (c[i]); //sc f�rl�ngs med c[i]
        // sc.append ('e');
     }
	}

}
