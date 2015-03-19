
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class People 
{
    private HashMap<String, HashMap<String,String>> details;

    public People()
    {
        details = new HashMap<>();
    }
    
    void displayData(String name)
    {
        try
        {
            HashMap<String ,String> data = details.get(name);
            System.out.println("Details of the Person " + name + " : ");

            for(String type :data.keySet())
            {
                System.out.println(type + " : " + data.get(type));
            }
        }
        catch(Exception e)
        {
            System.out.println("Error : Person not found!\n");
        }
    }
    
    void addData(String name, String type, String value)
    {
        try
        {
            HashMap<String, String> data = details.get(name);
            data.put(type, value);
            details.put(name, data);
        }
        catch(Exception e)
        {
            HashMap<String, String> data = new HashMap<>();
            data.put(type, value);
            details.put(name, data);
        }
    }
    
    void writeToFile(String fileName)
    {
        try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName)));
			List<String> namesList= new ArrayList<String>(details.keySet());
			Collections.sort(namesList);
			for(String name:namesList){
		      writer.append(name).append("  ")
		            .append(details.get(name).entrySet().iterator().next().getKey()).append("  ")
		            .append(details.get(name).entrySet().iterator().next().getValue()).append("\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void Menu()
    {
        Scanner in = new Scanner(System.in);
        int exit = -1;
        while(exit == -1)
        {
            System.err.println("\n\n\t\t--- Collection of People ---\n\n");
            System.out.print("\n\t1. Add new Data.\n\t2. Get Details of a Persion.\n\t3. Change Details of a Person\n\t4. Enter the file name to which data is to be written.\n\t5. Exit.\n\nWhat do you want : ");
            int choice =0;
            try
            {
                choice = Integer.parseInt(in.nextLine());
            }
            catch(Exception e)
            {
                System.out.println("Error : Invalid Input");
                continue;
            }
            if (choice==1)
            {
                System.out.print("Enter the Person Name : ");
                String name = in.nextLine();
                System.out.print("Enter the Details (type:value) : ");
                String details[] = (in.nextLine()).split(":");
                this.addData(name,details[0],details[1]);
            }
            else if(choice == 2)
            {
                System.out.print("Enter the Person Name : ");
                String name = in.nextLine();
                this.displayData(name);
            }
            else if(choice == 3)
            {
                System.out.print("Enter the Person Name : ");
                String name = in.nextLine();
                System.out.print("Enter the Details (type:value) : ");
                String details[] = (in.nextLine()).split(":");
                this.addData(name,details[0],details[1]);
            }
            else if(choice == 4)
            {
                System.out.print("Enter the file name : ");
                String fileName = in.nextLine();
                writeToFile(fileName);
            }
            else
            {
                exit = 0;
            }
                  
        }
    }
    
    public static void main(String arg[])
    {
        People people = new People();
        people.Menu();
    }
    
}
