
.equ    timer1_status,        (0x920)         # status
.equ    timer1_control,       (0x924)         # control
.equ    timer1_period_low,    (0x928)         # period low
.equ    timer1_period_high,   (0x92C)         # period high
.equ    timer1_snap_low,      (0x930)         # snapshot low
.equ    timer1_snap_high,     (0x934)         # snapshot high

				.data
				.align 2
				.global init_timer
				#.equ		left_shift_hack, 19
				#.equ		period, 5000		#1/100 of real period... sigh...
				.equ		period, 50000000
				
init_timer: 
			movi	r5, timer1_period_low		#r5=periodl
			movi	r6, timer1_period_high		#r6=periodh
			
			#ugly hack
			#movi	r7, 1
			#slli	r7, r7, left_shift_hack
			
			#movi	r7, period
			
			#multiplication didn't work...
			#muli	r7, r7, 100					#processor doesn't support?
			#movi	r8, 100
			#mul	r7, r7, r8
			
			/*#very ugly hack, mul as looped add...
			movi	r8, 0
			movi	r9, 99
loop:		addi	r8, r8, 1
			addi	r7, r7, period
			bne		r8, r9, loop
			*/
			
			movia	r7, period					#r7=period
			
			
			srai	r8, r7, 16					#high part of r7 in r8
			stwio	r7, 0(r5)					#write low part to timer_low
			stwio	r8, 0(r6)					#write high part to timer_high
			movi	r5, timer1_control			#r5=control
			movi	r6, 0x6						#set bit# 1 and 2
			stwio	r6, 0(r5)					# --||--

			ret									#return
			
			
.end
