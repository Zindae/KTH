


void send_char(     int data    )     {
    
        int* status = (int*) 0x888;        //address to control stuff on uart_1
        int* txd = (int*) 0x884;            //address to where we write on uart_1
        
        
        while (!(*status & 0x40)) {}       //när 0x888 får en etta på bit6, hoppa ut
        (*txd) = data;                      //sätt data till 0x884
}
    
int rec_charx( void ) {
        
        int* status = (int*) 0x888;                 //address to control stuff on uart_1
        int* rxd    = (int*) 0x880;                 //address to where we read on uart_1
        
        if (!((*status) & 0x80)) return -1;         //if not ready to recieve, return -1
        
        return (*rxd & 0xff);                       //else: read
}
