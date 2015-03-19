


		.text
		.align 2



		.macro PUSH reg
  		subi    sp, sp, 4
		stw     \reg, 0(sp)
		.endm

		.macro POP reg
		ldw     \reg, 0(sp)
		addi    sp, sp, 4
		.endm	
		
		.global puttime
		
		
		

		
puttime:
		PUSH	r16					#save registers
		PUSH	r17
		PUSH	r18
		PUSH	r19
		PUSH	r20
		
		mov		r16, r31			#put value of r31 in safe place
		ldw		r20, 0(r4)			#load word from address in r20
		
		movi	r4, 0x0a			#put \n
		call	putchar
		
		movi	r17, 0				#i=0
		
		movi	r18, 2				#read two digits first round
		movi	r19, 4				#defines format: 4 gives XX:XX, 6 gives XX:XX:XX, and so on
		
		roli	r20, r20, 20		#bring up first 4 bits to be printed
		mov		r4, r20 
loop:
		call 	hexasc				#make digit of bits
		mov		r4, r2				
		call	putchar				#print 

			
		roli	r20, r20, 4			#bring up next 4 bits
		mov		r4, r20
		addi	r17, r17, 1			#i++
		blt		r17, r18, loop		#if (i<r18) goto: loop
		
		beq		r18, r19, return	#if (r18==r19) then: finished
		
		movi	r4, 0x3a			#print ":"
		call	putchar				#
		addi	r18, r18, 2			#another run in the loop
		mov		r4, r20
		
		br		loop				#goto: loop
		
return:
		mov		r31, r16			#restore r31
		POP		r20					#restore registers
		POP		r19
		POP		r18
		POP		r17
		POP		r16					
		ret							#return
	
	
/*
puttime:

		mov		r14, r31

		PUSH	r16
		PUSH	r17
		PUSH	r18
		PUSH	r19
		

		ldw		r16, 0(r4)
		srai	r17, r16, 4
		srai	r18, r16, 8
		srai	r19, r16, 12


		movi	r4, 0x0a
		call	putchar
		mov		r4, r2
		call	lcdput


		mov		r4, r19
		call 	hexasc
		mov		r4, r2
		call	putchar
		mov		r4, r2
		call	lcdput


		mov		r4, r18
		call 	hexasc
		mov		r4, r2
		call	putchar
		mov		r4, r2
		call	lcdput
		
		movi	r4, 0x3a
		call	putchar
		mov		r4, r2
		call	lcdput
		
		
		mov		r4, r17
		call 	hexasc
		mov		r4, r2
		call	putchar
		mov		r4, r2
		call	lcdput		
		
		
		mov		r4, r16
		call 	hexasc
		mov		r4, r2
		call	putchar
		mov		r4, r2
		call	lcdput		
		
			
		mov		r4, r20
			

		POP		r19
		POP		r18
		POP		r17
		POP		r16
		
		mov		r31, r14
		ret
*/
.end
