package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Lh extends Itype {
    public Lh() {
        super("lh", 1, Zero(), randomRegister(), randomImmediate());
    }

    private static String randomImmediate() {
        if (Global.isWrittenMemoryOffsetEmpty()) {
            return Integer.toString(Global.getRandom(0, 0x2ffe) & 0xfffffffe);
        }
        return Integer.toString(Global.getRamdomWrittenMemoryOffset() & 0xfffffffe);
    }
}
