.equ    timer1_status,        (0x920)         # status
.equ    timer1_control,       (0x924)         # control
.equ    timer1_period_low,    (0x928)         # period low
.equ    timer1_period_high,   (0x92C)         # period high
.equ    timer1_snap_low,      (0x930)         # snapshot low
.equ    timer1_snap_high,     (0x934)         # snapshot high

					.data
					.align 2
					.global checktimer


 
checktimer:
			movia	r5, timer1_status			#r5 address of timer1 status reg
			ldwio	r6, 0(r5)					#r6 = timer1's status
			andi	r6, r6, 0x1					#mask with 0x1, just to be safe
			movi	r7, 0x1						#r7=0x1
			
			bne		r6, r7, zero
			
			movi	r2, 0						#r2 all zeroes
			stwio	r17, 0(r5)					#write any value to reset timeout bit
			ret			
zero:
			movi	r2, -1						#r2 all ones
			ret									#return
			
.end
