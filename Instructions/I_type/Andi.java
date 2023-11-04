package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Andi extends Itype {
    public Andi() {
        super("andi", 0, randomRegister(), randomRegister(), randomImmediate());
    }

    private static String randomImmediate() {
        return Global.getRandom(0, 0x7fff) + "";
    }
}