/* matrix.c - test rows and columns of a matrix
 * Written 2004-2012 by F Lundevall and J Wennlund
 * Copyright abandoned. This file is in the public domain. */

#include <stdio.h>
#define ROWCOUNT (3)
#define COLUMNCOUNT (4)

int imat[ ROWCOUNT ][ COLUMNCOUNT ];
char cmat[ ROWCOUNT ][ COLUMNCOUNT ];
double dmat[ ROWCOUNT ][ COLUMNCOUNT ];
int rmat[ ROWCOUNT ][ COLUMNCOUNT ];

void matriscopy (int destmat[ROWCOUNT][COLUMNCOUNT], int srcmat[ROWCOUNT ][COLUMNCOUNT], int x, int y)
{
    int * dest = &destmat[x][y]; 
    int * src = &srcmat[x][y];
    int i;
    int j;
    
    for( i = 0; i < ROWCOUNT; i = i + 1 ){
        for( j = 0; j < COLUMNCOUNT; j = j + 1 )
        {
            
            * src = * dest;
            src = src + 1;
            dest = dest + 1;
            
        }
    }
    
}
int main()

{
    
    int i; int j;
    int * ip; char * cp; double * dp;
    
    for( i = 0; i < ROWCOUNT; i = i + 1 )
        for( j = 0; j < COLUMNCOUNT; j = j + 1 )
        {
            imat[ i ][ j ] = 10000 + 100*i + j;
            cmat[ i ][ j ] = 10*i + j;
            dmat[ i ][ j ] = 1.0 + i/100.0 + j/10000.0;
            rmat[ i ][ j ] = 0;
        };
    
    printf( "\n Examining imat:\n" );
    for( ip = &imat[ 0 ][ 0 ];
        ip <= &imat[ ROWCOUNT - 1 ][ COLUMNCOUNT - 1 ];
        ip = ip + 1 )
        printf( "memory at: %lx contains value: %d\n", (unsigned long) ip, *ip );
    
    printf( "\n Examining cmat:\n" );
    for( cp = &cmat[ 0 ][ 0 ];
        cp <= &cmat[ ROWCOUNT - 1 ][ COLUMNCOUNT - 1 ];
        cp = cp + 1 )
        printf( "memory at: %lx contains value: %d\n", (unsigned long) cp, *cp );
    
    printf( "\n Examining dmat:\n" );
    for( dp = &dmat[ 0 ][ 0 ];
        dp <= &dmat[ ROWCOUNT - 1 ][ COLUMNCOUNT - 1 ];
        dp = dp + 1 )
        printf( "memory at: %lx contains value: %f\n", (unsigned long) dp, *dp );
    
    /* Add a statement here to call your matriscopy function. */
    
    matriscopy (imat,rmat,0,0);
    
    printf( "\n Examining rmat:\n" );
    for( ip = &rmat[ 0 ][ 0 ];
        ip <= &rmat[ ROWCOUNT - 1 ][ COLUMNCOUNT - 1 ];
        ip = ip + 1 )
        printf( "memory at: %lx contains value: %d\n", (unsigned long) ip, *ip );
    
    return( 0 );
}
