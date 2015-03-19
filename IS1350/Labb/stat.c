//
//  stat.c
//  Lab1
//
//  Created by Christopher State on 23/01/14.
//  Copyright (c) 2014 Christopher State. All rights reserved.
//

#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
#include <string.h>

extern int statPrint(char*, struct stat*); //funktion deklarerar en extern (funktion)int (libstat.o) Två inparametrar, char* och stat*

int main(int argc, char *argv[]) //Arc a couter telling how many arguments was on the command line when C-program was invoked. Argv is a vector containig the text strings found on the command line. Exekvering startas - ladda in i minnet
{
	struct stat s; //Structures, Collection of varibles under a single name. Buffert. Lokal variabel lagras på stacken. Närmaste du kan komma ett objekt.

    stat(argv[argc-1], &s); //(sys/stat.h) Argc-1 eller 1, första elementet i arrayen, inparameter från terminal, &s adressreferens till minnet. Return value 0(found) or 254(not found)
	statPrint(argv[1], &s); /* call statPrint in the libstat.o(handling the printf, to print the stat.
                            &s adressreferens för minnnesadressen s. */
}
