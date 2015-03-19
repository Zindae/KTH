

	.global hexasc
	
	.text
	.align 2
	
hexasc:	mov 	r8, r4			#
		andi 	r8,r8, 0x0f		#only use 4 ls bits
		
		movi	r9, 0x09		#r9=9
		
		bgt		r8, r9, char	#if (r8>9): goto char, r8 is a-f	
		
		addi	r8, r8, 0x30	#ascii numbers start at 0x30
		
		br		return			#return
			
char:	addi	r8, r8, 55 		#A is at 0x41=65, 0xa=10
		
return: andi 	r2, r8, 0x7f	#only want 7 ls bit
		ret 
		
		.end
