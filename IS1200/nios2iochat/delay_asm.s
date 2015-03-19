
		.text
		.align	2

		.global	delay
		.equ	delaycount, 1500
		

		
		
delay:	
		mov		r9, r4

outerloop:
		movia	r5, delaycount

		ble		r9, r0, return

innerloop:
		
		ble		r5, r0, outerloop
		subi	r5, r5, 1

		bgt		r5, r0, innerloop
		
		#movi	r4, 0x3a
		#call	putchar
		
		subi	r9, r9, 1
		br		outerloop


return:	
		#movi	r4, 0x30
		#call	putchar
		ret
.end
		