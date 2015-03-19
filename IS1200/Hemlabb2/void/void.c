/* void.c - Test pointers to void
 * Written 2012 by F Lundevall
 * Copyright abandoned. This file is in the public domain.
 *
 * To make this program work on as many systems as possible,
 * addresses are converted to unsigned long when printed.
 * The 'l' in formatting-codes %ld and %lx means a long operand. */

#include <stdio.h>
#include <stdlib.h>

int * ip; /* Declare a pointer to int, a.k.a. int pointer. */
void * vp; /* Pointer to void, a.k.a. void pointer. */
int ia[ 17 ]; /* Declare an array of 17 ints, numbered 0 through 16. */

/* Main function. */
int main()
{
    char * cp;
    
    printf( "Message VO.01 from void.c: Hello Void!\n" );
    
    /* Do some assignments. */
    ip = &ia[2];
    vp = ia;
    
    ia[ 0 ] = 111111; /* First element. */
    ia[ 1 ] = 17;
    ia[ 2 ] = 123456;
    ia[ 16 ] = 66; /* Last element. */
    
    printf( "VO.02: ia[0]: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &ia[0], ia[0], ia[0] );
    printf( "VO.03: ia[1]: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &ia[1], ia[1], ia[1] );
    printf( "VO.04: ia[2]: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &ia[2], ia[2], ia[2] );
    printf( "VO.05: ip: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &ip, (long) ip, (long) ip );
    printf( "VO.06: Dereference pointer ip and we find: %d \n", *ip );
    printf( "VO.07: vp: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &vp, (long) vp, (long) vp );
    
    cp = vp;
    printf( "\nVO.08: Executed cp = vp; \n" );
    printf( "VO.09: cp: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &cp, (long) cp, (long) cp );
    printf( "VO.10: Dereference pointer cp and we find: %d \n", *cp );
    
    ip = vp;
    printf( "\nVO.11: Executed ip = vp; \n" );
    printf( "VO.12: ip: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &ip, (long) ip, (long) ip );
    printf( "VO.13: Dereference pointer ip and we find: %d \n", *ip );
    
    vp = vp + 1; /* Add 1 to pointer. The compiler may warn you about this. */
    printf( "\nVO.14: Executed vp = vp + 1; \n" );
    printf( "VO.15: vp: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &vp, (long) vp, (long) vp );
    
    *ip = 4711;
    printf( "\nVO.16: Executed *ip = 4711; \n" );
    printf( "VO.17: ip: stored at %lx (hex); value is %ld (dec), %lx (hex)\n",
           (long) &ip, (long) ip, (long) ip );
    printf( "VO.18: Dereference pointer ip and we find: %d \n", *ip );
    printf( "VO.19: ia[0]: stored at %lx (hex); value is %d (dec), %x (hex)\n",
           (long) &ia[0], ia[0], ia[0] );
    
    // *vp = 1234; /* The compiler should complain about this. */
    printf( "\nVO.20: After // *vp = 1234; \n" );
    
    return( 0 );
}
