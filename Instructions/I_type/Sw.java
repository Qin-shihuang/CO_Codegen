package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Sw extends Itype {
    public Sw() {
        super("sw", 1, Zero(), randomRegister(), randomImmediate());
    }

    // 0x000-0x7ffd, imm%4 = 0
    private static String randomImmediate() {
        return (Global.getRandom(0, 0x1000) & 0xfffffffc) + "";
    }
}
