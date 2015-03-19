/*LABB 2. PROGRAM 2: LAB2_Morse_Kod.java.

 *  Innefattar:
 *
 *   - Skapa och använd objekt av olika standardklasser (Scanner, Integer)
 *   -Objekt och vektorer med objekt som parametrar och returtyper i olika metoder
 * 
 * 
 * I detta program demonstreras Morsekod konvertering */

public class LAB2_Morse_Kod 
{

public static void main(String[] args) 
 {
	    
    String[] morse = {".- ","-... ","-.-/>. ","-.. ",". ","..-. ","--. ",".... ",".. ",
   ".--- ","-.-/> ",".-.. ","-- ","-. ","--- ",".--. ","--.-/> ",".-. ","... ","- ","..- ",
   "...- ",".-- ","-..- ","-.-/>- ","--.. ", "finns ej!", "finns ej!", "finns ej!"};
    
    String[] alf = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","å","ä","ö"};
   
    java.util.Scanner read = new java.util.Scanner (System.in);
    
    System.out.println("---------------------PROGRAM: Morsekod-konverterare---------------------------\n");
    System.out.println("Skriv en bokstav som ska konverteras till morsekod: ");
    
    String bokstav = read.nextLine();
    
    System.out.println("Bokstaven i morsekod: ");
    
    //printar ut motsvarande värde i vektor morse som alf
    if(bokstav.equals(alf[0]))
    {
         System.out.println(morse[0]);
    }
    if(bokstav.equals(alf[1]))
    {
         System.out.println(morse[1]);
    }

    if(bokstav.equals(alf[2]))
    {
         System.out.println(morse[2]);
    }
    if(bokstav.equals(alf[3]))
    {
         System.out.println(morse[3]);
    }

    if(bokstav.equals(alf[4]))
    {
         System.out.println(morse[4]);
    }
    if(bokstav.equals(alf[5]))
    {
         System.out.println(morse[5]);
    }

    if(bokstav.equals(alf[6]))
    {
         System.out.println(morse[6]);
    }
    if(bokstav.equals(alf[7]))
    {
         System.out.println(morse[7]);
    }

    if(bokstav.equals(alf[8]))
    {
         System.out.println(morse[8]);
    }
    if(bokstav.equals(alf[9]))
    {
         System.out.println(morse[9]);
    }

    if(bokstav.equals(alf[10]))
    {
         System.out.println(morse[10]);
    }
    if(bokstav.equals(alf[11]))
    {
         System.out.println(morse[11]);
    }
    if(bokstav.equals(alf[10]))
    {
         System.out.println(morse[12]);
    }
    if(bokstav.equals(alf[11]))
    {
         System.out.println(morse[12]);
    }
    if(bokstav.equals(alf[13]))
    {
         System.out.println(morse[13]);
    }
    if(bokstav.equals(alf[14]))
    {
         System.out.println(morse[14]);
    }
    if(bokstav.equals(alf[15]))
    {
         System.out.println(morse[15]);
    }
    if(bokstav.equals(alf[16]))
    {
         System.out.println(morse[16]);
    }

    if(bokstav.equals(alf[17]))
    {
         System.out.println(morse[17]);
    }
    if(bokstav.equals(alf[18]))
    {
         System.out.println(morse[18]);
    }

    if(bokstav.equals(alf[19]))
    {
         System.out.println(morse[19]);
    }
    if(bokstav.equals(alf[20]))
    {
         System.out.println(morse[20]);
    }

    if(bokstav.equals(alf[21]))
    {
         System.out.println(morse[21]);
    }
    if(bokstav.equals(alf[22]))
    {
         System.out.println(morse[22]);
    }

    if(bokstav.equals(alf[23]))
    {
         System.out.println(morse[23]);
    }
    if(bokstav.equals(alf[24]))
    {
         System.out.println(morse[24]);
    }
    if(bokstav.equals(alf[25]))
    {
         System.out.println(" 'å' finns inte i morsekodalfabetet!");
    }
    if(bokstav.equals(alf[26]))
    {
         System.out.println(" 'ä' finns inte i morsekodalfabetet!");
    }
    if(bokstav.equals(alf[26]))
    {
         System.out.println(" 'ö' finns inte i morsekodalfabetet!");
    }
    
    System.out.println("");
        
    int el1 = alf.length;
    int el2 = morse.length; 
    
    System.out.println("---------------------------------------------------------------");    
    System.out.println("Antal bokstäver i svenska alfabetet: " + el1);
    System.out.println("Antal tecken i morsekodalfabetet: " + (el2-3));
    System.out.println("---------------------------------------------------------------");    
    System.out.println("\nSvenska alfabetet | Morsekodsalfabetet: \n");
    
    //for-loop som loopar igenom vektorerna och printar hela alfabetet
    for(int counter = 0; counter < alf.length; counter++)
    {
    	System.out.println(alf[counter] + " \t\t  =  \t\t " + morse[counter]);
    }
    
    	   	
    
   }
}

 

