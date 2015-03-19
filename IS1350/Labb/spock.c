//
//  spock.c
//  Lab1
//
//  Created by Christopher State on 20/01/14.
//  Copyright (c) 2014 Christopher State. All rights reserved.
//

#include <stdio.h>
#include <string.h>
int PasswordOkay()
{
    char GoodPassword = 'F';
    char Password [8]; // 9th char will override the returnpointer. IF that char is a T, you will successfully enter the program. 
    gets(Password);
    if (!strcmp(Password, "SPOCKSUX"))
        GoodPassword = 'T';
    return (GoodPassword == 'T');
}
int main()
{
    puts("Enter Password:");
    if (PasswordOkay())
        puts("Hello, Dr. Bones.");
    else
        puts("Access denied.");
}