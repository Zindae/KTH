#define NDIGS 4

int hex7seg(int);
void put_hexlow(int);

void puttime_hex(int* mytimep) {
    
    int citron=0; //citron=0 very important
    
    /*int mytime, dig1, dig2, dig3, dig4,
        fdig1, fdig2, fdig3, fdig4;

    mytime=*mytimep;
    dig1=mytime & 0xf;
    dig2=(mytime & 0xf0)>>4;
    dig3=(mytime & 0xf00)>>8;
    dig4=(mytime & 0xf000)>>12;
    
    fdig1=hex7seg(dig1);
    fdig2=(hex7seg(dig2))<<7;
    fdig3=(hex7seg(dig3))<<14;
    fdig4=(hex7seg(dig4))<<21;
    citron=fdig1|fdig2|fdig3|fdig4;
    */
    
    /*shorter version of above
     * send four bit digits to hex7seg and or
     * together the seven bit digits we get back into one
     * 28 bit "word", citron*/
     
    int i;
    for (i=0;i<NDIGS;++i) {
        int tmp=(*mytimep)>>(i*4);
        citron|=(hex7seg(tmp))<<(i*7);
    }
    
    put_hexlow(citron);         //send citron to display
    
}
