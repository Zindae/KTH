//
//  stat3.c
//  Lab1
//
//  Created by Christopher State on 27/01/14.
//  Copyright (c) 2014 Christopher State. All rights reserved.
//

#include <sys/stat.h>
#include <stdio.h>
#include <string.h>
#include <time.h>
#include <stdlib.h>
#include <sys/types.h>

#include <grp.h>
#include <pwd.h>

void statPrint(char*, struct stat*);

int main(int argc, char* argv[])
{
	struct stat s; 
	int result;//result > value 0 or 254
	result = stat(argv[1],&s);
    
	if(result==0) //if 0(found) continue
		statPrint(argv[1],&s);
	else //if not found(254) print > Finns Ej.
        printf("Finns ej\n");
    
	return 0;
}


void statPrint(char* path, struct stat* s) //The stat function returns information about the attributes of the file named by path in the structure pointed to by s(buffert).
{
    printf("File: '%s'\n",path); //% = Replace with path. (char *)
    printf("Size: %lld\t",s->st_size); //st_size (unsigned long long)
    printf("Blocks: %lld\t",s->st_blocks); //st_blocks  (unsigned long long)
    printf("IO Block: %d\n",s->st_blksize); //st_blksize (double)
    
    printf("Device: 0x%04x%04x\t", major(s->st_dev), minor(s->st_dev)); //st_dev Prints the number as hex (x), padded with zeroes (0) to a total width of 4. (x2) Device: 0x00010002
    
    printf("Inode: %lld\t",s->st_ino); //st_ino  (unsigned long long)
    printf("Links: %d\n",s->st_nlink); //st_nlink (double)
    
    printf("Access: (%o/ ", s->st_mode); //st_mode Access: (100644/)
    
    printf( (S_ISDIR(s->st_mode)) ? "d" : "-");
    printf( (s->st_mode & S_IRUSR) ? "r" : "-");    //read permission-user
    printf( (s->st_mode & S_IWUSR) ? "w" : "-");    //write permission-user
    printf( (s->st_mode & S_IXUSR) ? "x" : "-");    //execute permission-user
    printf( (s->st_mode & S_IRGRP) ? "r" : "-");    //read permissions-group
    printf( (s->st_mode & S_IWGRP) ? "w" : "-");    //write permissions-group
    printf( (s->st_mode & S_IXGRP) ? "x" : "-");    //execute permissions-group
    printf( (s->st_mode & S_IROTH) ? "r" : "-");    //read permissions-other
    printf( (s->st_mode & S_IWOTH) ? "w" : "-");    //write permissions-other
    printf( (s->st_mode & S_IXOTH) ? "x" : "-");    //execute permissions-other
    
    printf(")\t");
    
    printf("UID: ( %u/ %s )\t",s->st_uid, getpwuid(s->st_uid)->pw_name); //st_uid (unsigned int) -Password userid and name
    printf("GID: ( %u/ %s )\t\n",s->st_gid, getgrgid(s->st_gid)->gr_name); //st_gid (unsigned int) -Password groupid and name
    
    printf("Access %s", ctime(&s->st_atime));   //Accesstime
    printf("Modify %s", ctime(&s->st_mtime));   //Modifytime
    printf("Change %s", ctime(&s->st_ctime));   //Changetime
    
    
}




