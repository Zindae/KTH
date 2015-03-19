.equ    timer1_status,        (0x920)         # status
.equ    timer1_control,       (0x924)         # control
.equ    timer1_period_low,    (0x928)         # period low
.equ    timer1_period_high,   (0x92C)         # period high
.equ    timer1_snap_low,      (0x930)         # snapshot low
.equ    timer1_snap_high,     (0x934)         # snapshot high


						.data
						.global snaptime
						.align 2
						
snaptime:		movia	r5, timer1_snap_low
				movia	r6, timer1_snap_high
				stwio	r0, 0(r5)					#write to low to take snapshot
				ldwio	r7, 0(r5)					#load lower
				ldwio	r8, 0(r6)					#load higher
				andi	r7, r7, 0xffff				#just to be sure...
				slli	r8, r8, 16					#high part
				mov		r2, r7						#
				or		r2, r2, r8					#or together
				
				ret
.end

				
						
						