package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Lui extends Itype {
    public Lui() {
        super(Global.getCurrentLine(), "lui", 0, randomRegister(), randomRegister(), randomImmediate());
    }

    public Lui(String rs, String rt) {
        super(Global.getCurrentLine(), "lui", 0, rs, rt, randomImmediate());
    }

    private static String randomImmediate() {
        return Global.getRandom(0, 0xffff) + "";
    }
}