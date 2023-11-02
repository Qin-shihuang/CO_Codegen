package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Lw extends Itype {
    public Lw() {
        super(Global.getCurrentLine(), "lw", 1, randomRegister(), Zero(), randomImmediate());
    }
    //0x000-0x7ffd, imm%4 = 0
    private static String randomImmediate() {
        return (Global.getRandom(0, 0x7ffe) & 0xfffffffc) + "";
    }
}
