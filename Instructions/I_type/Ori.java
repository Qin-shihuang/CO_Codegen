package Instructions.I_type;

import utils.Global;
import Instructions.Itype;


public class Ori extends Itype {
    public Ori() {
        super(Global.getCurrentLine(), "ori", 0 ,randomRegister(), randomRegister(), randomImmediate());
    }

    public Ori(String rs, String rt){
        super(Global.getCurrentLine(), "ori", 0, rs, rt, randomImmediate());
    
    }

    private static String randomImmediate() {
        return Global.getRandom(0,0x7fff) + "";
    }
}    