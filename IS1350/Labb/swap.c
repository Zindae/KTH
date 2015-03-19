//
//  swap.c
//  Lab1
//
//  Created by Christopher State on 29/01/14.
//  Copyright (c) 2014 Christopher State. All rights reserved.
//

#include <stdio.h>


void swap1(unsigned int, unsigned int);
void swap2(unsigned int *, unsigned int *);
void swap3(unsigned int *, unsigned int *);

int main()
{
    unsigned int a = 4, b = 33333;
    printf("a = %5u b = %5u\n", a, b);
    swap1(a, b);
    printf("a = %5u b = %5u\n", a, b);
    swap2(&a, &b);
    printf("a = %5u b = %5u\n", a, b);
    swap3(&a, &b); //referar till adressen till a samt b
    printf("a = %5u b = %5u\n", a, b);
}
void swap1(unsigned int i, unsigned int j)
{
    unsigned int tmp;
    printf("called swap1( %u, %u)\n", i, j);
    tmp = i;
    i = j;
    j = tmp;
}
void swap2(unsigned int *i, unsigned int *j)
{
    unsigned int tmp;
    printf("called swap2( %u, %u)\n", i, j);
    tmp = i; //adress to a (&a) - Warning. Tilldelning av en pointer till en integer utan typecast.
    i = j; //adress to a replace with adress to b . (&a => &b)
    j = tmp; // adress to (&a) - Warning. Tilldelning av en integer till en pointer utan typecast.
}
void swap3(unsigned int *i, unsigned int *j)
{
    unsigned int tmp;
    printf("called swap3( %u, %u)\n", *i, *j); //*i = a. j* = b
    tmp = *i; //Lagra värdet(4) från adressen &a till tmp.
    *i = *j; //Lagra värdet(3333) från adressen &b till adressen &a (skriver över minnesplats a)
    *j = tmp; //Lagra värdet(4) från tmp till adress en %b (skriver över minnesplats b)
}