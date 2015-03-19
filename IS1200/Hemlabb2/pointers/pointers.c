//
//  pointers.c
//  Hemlabb2
//
//  Created by Christopher State on 2013-01-28.
//  Copyright (c) 2013 Christopher State. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

int * ip; /* Declare a pointer to int, a.k.a. int pointer. */
char * cp; /* Pointer to char, a.k.a. char pointer. */

/* Declare fp as a pointer to function, where that function
 * has one parameter of type int and returns an int.
 * Use cdecl to get the syntax right, http://cdecl.org/ */
int ( *fp )( int );

int val1 = 111111;

int ia[ 17 ]; /* Declare an array of 17 ints, numbered 0 through 16. */
char ca[ 17 ]; /* Declare an array of 17 chars. */

int fun( int parm )
{
    printf( "Function fun called with parameter %d\n", parm );
    return( parm + 1 );
}

/* Main function. */
int main()
{
    int val2 = 2222222;
    
    printf( "Message PT.01 from pointers.c: Hello, pointy World!\n" );
    
    /* Do some assignments. */
    ip = &val1;
    cp = &val2; /* The compiler should warn you about this. */
    fp = fun;
    
    ia[ 0 ] = 11; /* First element. */
    ia[ 1 ] = 17;
    ia[ 2 ] = 3;
    ia[ 16 ] = 58; /* Last element. */
    
    ca[ 0 ] = 11; /* First element. */
    ca[ 1 ] = 17;
    ca[ 2 ] = 3;
    ca[ 16 ] = 58; /* Last element. */
    
    printf( "PT.02: val1: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &val1, val1, val1 );
    printf( "PT.03: val2: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &val2, val2, val2 );
    printf( "PT.04: ip: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &ip, (long) ip, (long) ip );
    printf( "PT.05: sizeof(ip) == %d\n", (int) sizeof( ip ) );
    printf( "PT.06: Dereference pointer ip and we find: %d \n", *ip );
    printf( "PT.07: sizeof(*ip) == %d\n", (int) sizeof( *ip ) );
    printf( "PT.08: cp: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &cp, (long) cp, (long) cp );
    printf( "PT.09: sizeof(cp) == %d\n", (int) sizeof( cp ) );
    printf( "PT.10: Dereference pointer cp and we find: %d \n", *cp );
    printf( "PT.11: sizeof(*cp) == %d\n", (int) sizeof( *cp ) );
    
    *ip = 1234;
    printf( "\nPT.12: Executed *ip = 1234; \n" );
    printf( "PT.13: val1: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &val1, val1, val1 );
    printf( "PT.14: ip: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &ip, (long) ip, (long) ip );
    printf( "PT.15: Dereference pointer ip and we find: %d \n", *ip );
    
    *cp = 1234; /* The compiler should warn you about this. */
    printf( "\nPT.16: Executed *cp = 1234; \n" );
    printf( "PT.17: val2: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &val2, val2, val2 );
    printf( "PT.18: cp: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &cp, (long) cp, (long) cp );
    printf( "PT.19: Dereference pointer cp and we find: %d \n", *cp );
    
    ip = ia;
    printf( "\nPT.20: Executed ip = ia; \n" );
    printf( "PT.21: ia[0]: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &ia[0], ia[0], ia[0] );
    printf( "PT.22: ia[1]: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &ia[1], ia[1], ia[1] );
    printf( "PT.23: ip: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &ip, (long) ip, (long) ip );
    printf( "PT.24: Dereference pointer ip and we find: %d \n", *ip );
    
    ip = ip + 1; /* add 1 to pointer */
    printf( "\nPT.25: Executed ip = ip + 1; \n" );
    printf( "PT.26: ip: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &ip, (long) ip, (long) ip );
    printf( "PT.27: Dereference pointer ip and we find: %d \n", *ip );
    
    cp = ca;
    printf( "\nPT.28: Executed cp = ca; \n" );
    printf( "PT.29: ca[0]: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &ca[0], ca[0], ca[0] );
    printf( "PT.30: ca[1]: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &ca[1], ca[1], ca[1] );
    printf( "PT.31: ca[2]: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &ca[2], ca[2], ca[2] );
    printf( "PT.32: ca[3]: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &ca[3], ca[3], ca[3] );
    printf( "PT.33: cp: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &cp, (long) cp, (long) cp );
    printf( "PT.34: Dereference pointer cp and we find: %d \n", *cp );
    
    cp = cp + 1; /* add 1 to pointer */
    printf( "\nPT.35: Executed cp = cp + 1; \n" );
    printf( "PT.36: cp: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &cp, (long) cp, (long) cp );
    printf( "PT.37: Dereference pointer cp and we find: %d \n", *cp );
    
    ip = ca; /* The compiler should warn you about this. */
    printf( "\nPT.38: Executed ip = ca; \n" );
    printf( "PT.39: Dereference pointer ip and we find: %d \n", *ip );
    
    ip = ip + 1; /* add 1 to pointer */
    printf( "\nPT.40: Executed ip = ip + 1; \n" );
    printf( "PT.41: ip: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &ip, (long) ip, (long) ip );
    printf( "PT.42: Dereference pointer ip and we find: %d \n", *ip );
    
    cp = ia; /* The compiler should warn you about this. */
    printf( "\nPT.43: Executed cp = ia; \n" );
    printf( "PT.44: cp: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &cp, (long) cp, (long) cp );
    printf( "PT.45: Dereference pointer cp and we find: %d \n", *cp );
    
    printf( "\nPT.46: fp: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &fp, (long) fp, (long) fp );
    printf( "PT.47: Dereference fp and see what happens.\n" );
    
    val1 = (*fp)(42);
    printf( "PT.48: Executed val1 = (*fp)(42); \n" );
    printf( "PT.49: val1: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &val1, val1, val1 );
    
    return( 0 );
}

