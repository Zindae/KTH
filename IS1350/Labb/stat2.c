//
//  stat2.c
//  Lab1
//
//  Created by Christopher State on 23/01/14.
//  Copyright (c) 2014 Christopher State. All rights reserved.
//
//  Unlike C, which starts counting at 0 (array elements), gcc starts counting function arguments at 1.
//  So in printf (fmt, value), "argument 1" would refer to fmt, and "argument 2" refers to value.
//

#include <sys/stat.h>
#include <stdio.h>
#include <string.h>
#include <time.h>
#include <stdlib.h>
#include <sys/types.h>

void statPrint(char*, struct stat*);

int main(int argc, char* argv[]) //argc (argument count, argv(argument vector)
{
	struct stat s;
	int result; //result > value 0 or 254
	result = stat(argv[1],&s);
    
    printf("%d\n",result); // test
    
	if(result==0) //if 0(found) continue
		statPrint(argv[1],&s);
	else //if not found(254) print > Finns Ej.
        printf("Finns ej\n");
    
	return 0;
}

/* The int printf(const char *format, ...) function writes output to the standard output stream stdout and produces output according to a format provided. The format can be a simple constant string, but you can specify %s, %d, %c, %f, etc., to print or read strings, integer, character or float respectively. */

void statPrint(char* path, struct stat* s) //The stat function returns information about the attributes of the file named by path(from terminal, argv[1]) in the structure pointed to by s(buffert).
{
    printf("File: '%s'\n",path); //% = Replace with path. (char *) The const char * argument is expected to be a pointer to an array of character type (pointer to a string). Characters from the array are written up to (but not including) a terminating null byte ('\0');
    printf("Size: %lld\t",s->st_size); //st_size (unsigned long long)
    printf("Blocks: %lld\t",s->st_blocks); //st_blocks (unsigned long long)
    printf("IO Block: %d\n",s->st_blksize); //st_blksize (double)
    
    printf("Device: 0x%04x%04x\t", major(s->st_dev), minor(s->st_dev)); //st_dev Prints the number as hex (x), padded with zeroes (0) to a total width of 4. (x2) Major - A number indicating which device driver should be used to access a particular device. Minor - A number serving as a flag to a device driver. Device: 0x00010002
    
    printf("Inode: %lld\t",s->st_ino); //st_ino  (unsigned long long)
    printf("Links: %d\n",s->st_nlink); //st_nlink (double)

    printf("Access: (%o/ )\t", s->st_mode); //st_mode Access: (100644/)
    printf("UID: ( %u/ )\t\n",s->st_uid); //st_uid (unsigned int)
    printf("GID: ( %u/ )\t\n",s->st_gid); //st_gid (unsigned int)
    
    printf("Access %s", ctime(&s->st_atime));   //Accesstime    (ctime()'s return value includes a \n) char *ctime(const time_t *);
    printf("Modify %s", ctime(&s->st_mtime));   //Modifytime    (ctime()'s return value includes a \n)
    printf("Change %s", ctime(&s->st_ctime));   //Changetime    (ctime()'s return value includes a \n)
    
    
    /* printf("Size: %ld     Blocks: %lld  IO Block: %d\n",(unsigned long)s.st_size,s.st_blocks,s.st_blksize);
	printf("Device: %#x    Inode: %llu     Links %d\n",s.st_dev,s.st_ino,s.st_nlink);
	printf("Access: (%#lo/ )\t	UID: ( %d/)\t    GID:( %d/)\n",(unsigned long)(s.st_mode&0xfff),s.st_uid,s.st_gid);
    printf("Access: (%04ho/ )",s.st_mode); //st_mode
	
    char buffer[80];
	strftime(buffer,80,"%a %b %d %X %Y",localtime(&s.st_atime));
	printf("Access: %s  ( )\n",buffer);
    
	strftime(buffer,80,"%a %b %d %X %Y",localtime(&s.st_mtime));
	printf("Modify: %s  ( )\n",buffer);
    
	strftime(buffer,80,"%a %b %d %X %Y",localtime(&s.st_ctime));
	printf("Change: %s  ( )\n",buffer);  */

}




