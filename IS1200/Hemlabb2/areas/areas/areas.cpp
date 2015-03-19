/* areas.c - Find addresses of memory areas
 *
 * Written 2012 by F Lundevall.
 * Copyright abandoned. This file is in the public domain.
 *
 * To make this program work on as many systems as possible,
 * addresses are converted to unsigned long when printed.
 * The 'l' in formatting-codes %ld and %lx means a long operand. */

#include "sys/malloc.h"
#include <stdio.h>
#include <stdlib.h>

int gi; /* Global variable. */
int in = 4711; /* Global variable, initialized to 4711. */

int fun( int parm )
{
    /* Local variable, initialized every time fun is called. */
    int loc1 = parm + 17;
    
    printf( "AF.1: loc1 stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &loc1, loc1, loc1 );
    printf( "AF.2: parm stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &parm, parm, parm );
    
    gi = parm; /* Change the value of a global variable. */
    printf( "AF.3: Executed gi = parm;\n" );
    return( loc1 );
}

/* Main function. */
int main()
{
    /* Local variables. */
    int m;
    int n;
    int * p; /* Declare p as pointer, so that p can hold an address. */
    /* Do some calculation. */
    gi = 12345;
    m = gi + 11111;
    n = 17;
    printf( "AM.09: p: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &p, (long) p, (long) p );
    
    printf( "Message AM.01 from areas.c: Hello, World!\n" );
    
    printf( "AM.02: m: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &m, m, m );
    printf( "AM.03: n: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &n, n, n );
    printf( "AM.04: gi: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &gi, gi, gi );
    printf( "AM.05: in: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &in, in, in );
    
    printf( "AM.06: fun: address is %lx (hex)\n", (long) fun );
    printf( "AM.07: main: address is %lx (hex)\n", (long) main );
    
    p = (int *) malloc( sizeof( int ) );
    printf( "AM.08: Executed p = (int *) malloc( sizeof( int ) );\n" );
    printf( "AM.09: p: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &p, (long) p, (long) p );
    
    printf( "AM.10: Will soon execute n = fun( m );\n" );
    n = fun( m );
    printf( "AM.11: Has now returned from n = fun( m );\n" );
    
    printf( "AM.12: n: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &n, n, n );
    printf( "AM.13: gi: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &gi, gi, gi );
    
    free( p );
    exit( 0 );
}
