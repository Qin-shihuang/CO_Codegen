package Instructions.I_type;

import Instructions.Itype;
import utils.Global;


public class Ori extends Itype {
    public Ori() {
        super(Global.getCurrentLine(), "ori", 0 ,randomRegister(), randomRegister(), randomImmediate());
    }

    private static String randomImmediate() {
        return Global.getRandom(0,0x7fff) + "";
    }
}    