package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Ori extends Itype {
    public Ori() {
        super("ori", 0, randomRegister(), randomRegister(), randomImmediate());
    }

    public Ori(String rs, String rt) {
        super("ori", 0, rt, rs, randomImmediate());
    }

    private static String randomImmediate() {
        return Global.getRandom(0, 0x7fff) + "";
    }
}