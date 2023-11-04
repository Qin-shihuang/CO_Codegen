package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Addiu extends Itype {
    public Addiu() {
        super("addiu", 0, randomRegister(), randomRegister(), randomImmediate());
    }

    public Addiu(String rs, String rt) {
        super("addiu", 0, rt, rs, randomImmediate());
    }

    private static String randomImmediate() {
        return Global.getRandom(0, 0x7fff) + "";
    }
}