

				.data
				.align 2
				.global out_char, in_charx
				
				
out_char:	
			andi	r4, r4, 0xff		#mask with one byte
			movia	r5, 0x868			#address of some juck
			movi	r14, 0x40			#r14=0x40
loop1:		ldwio	r6, 0(r5)			#get the status
			andi	r6, r6, 0x40		#ready to transmit?
			bne		r6, r14, loop1		#if no, goto loop1
			
			movia	r5, 0x864			#else: 0x864 is address of TxDATA 
			stwio	r4, 0(r5)			#transmit
			
			ret

in_charx:	
			movia	r5, 0x868			#address of control stuff
			ldwio	r6, 0(r5)			#load it...
			movi	r14, 0x80			#ready-to-recieve-bit
			andi	r6,r6,0x80
			beq		r6, r14, new		#if new byte to recieve, goto new

			movi	r2, -1				#else, return -1
			ret
			
new:		movia	r5, 0x860
			ldwio	r6, 0(r5)			#load the new byte
			andi	r2, r6, 0xff		#it is one byte... put it in r2
			ret				
			
.end
