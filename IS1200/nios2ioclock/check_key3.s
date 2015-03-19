


					.data
					.align 2
					.global check_key3, check_key2, check_key1
					
check_key3:
					movia	r5, 0x840			#r5 address of key stuff
					ldwio	r6, 0(r5)			#r6 = status of keys
					andi	r6, r6, 8			#bit 3 is key 3
					#xori	r6, r6, 8			#simulate pressing key 3
					slli	r6, r6, 28			#shift bit 3 to msb position
					srai	r2, r6, 31			#fill with copies of msb
					ret							#return
					
check_key2:
					movia	r5, 0x840			#r5 address of key stuff
					ldwio	r6, 0(r5)			#r6 = status of keys
					andi	r6, r6, 4			#bit 2 is key 2
					#xori	r6, r6, 4			#simulate pressing key 2
					slli	r6, r6, 29			#shift bit 2 to msb position
					srai	r2, r6, 31			#fill with copies of msb
					ret							#return
					
check_key1:
					movia	r5, 0x840			#r5 address of key stuff
					ldwio	r6, 0(r5)			#r6 = status of keys
					andi	r6, r6, 2			#bit 1 is key 1
					#xori	r6, r6, 2			#simulate pressing key 1
					slli	r6, r6, 30			#shift bit 1 to msb position
					srai	r2, r6, 31			#fill with copies of msb
					ret							#return
					
									
.end
