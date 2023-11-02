package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Lw extends Itype {
    public Lw() {
        super("lw", 1, Zero(), randomRegister(), randomImmediate());
    }

    private static String randomImmediate() {
        if (Global.isWrittenMemoryOffsetEmpty()) {
            return Integer.toString(Global.getRandom(0, 0x2ffc) & 0xfffffffc);
        }
        return Integer.toString(Global.getRamdomWrittenMemoryOffset());
    }
}
