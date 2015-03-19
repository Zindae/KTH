/*
 * smash.c - do bad things with a local array
 *
 * Written 2012 by F Lundevall
 * Copyright abandoned. This program is in the public domain.
 */

#include <stdio.h>

/* Define an array of bytes, simulating a carefully planned input string. */
unsigned char magicbytes[] =
{
    'A', 'n', 'y', 'b', 'y', 't', 'e', 's',
    32, 'g', 'o', 32, 'h', 'e', 'r', 'e',
    4, 2, 128, 0,
    'a', 'n', 'd', 32, 'h', 'e', 'r', 'e', 32, 't', 'o', 'o',
    4, 2, 128, 0
};

void fun( void )
{
    printf( "SM.07: Function fun is never called in this program.\n" );
    printf( "SM.08: So if you see this message, what happened?\n" );
}

void smashup( unsigned char * bytes, int count )
{
#define BUFFERSIZE (12)
    int i;
    char buf[ BUFFERSIZE ];
    
    printf( "SM.03: Will now copy %d bytes into buffer of size %d\n",
           count, BUFFERSIZE );
    /* Sloppy programming: this copy-loop does not stop at BUFFERSIZE. */
    printf( "SM.04: Showing old and new contents of memory during copy.\n" );
    for( i = 0; i < count; i += 1 )
    {
        if( BUFFERSIZE == i ) printf( "Uh-oh, going beyond buffer now:\n" );
        printf( "buf[ %d ] at address %lx contained %d, ",
               i, (long) &buf[ i ], buf[ i ] );
        buf[ i ] = bytes[ i ];
        printf( "new value is %d\n", buf[ i ] );
    }
    printf( "SM.05: Finished copying, will now return from smashup\n" );
}

int main()
{
    printf( "Message SM.01 from smash.c: Hello, smashing world!\n" );
    printf( "SM.02: Will now call function smashup with simulated input.\n" );
    smashup( magicbytes, (int) sizeof( magicbytes ) );
    printf( "SM.06: Successfully returned from function smashup\n" );
    return( 0 );
}
