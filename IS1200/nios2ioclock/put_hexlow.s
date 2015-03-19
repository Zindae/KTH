

				.data
				.align 2
				.global put_hexlow
				
put_hexlow:
			movia	r5, 0x9f0		#address of lower part of display
			stw		r4, 0(r5)		#send r4 there...
			ret
.end
