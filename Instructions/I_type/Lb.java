package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Lb extends Itype {
    public Lb() {
        super("lb", 1, Zero(), randomRegister(), randomImmediate());
    }

    private static String randomImmediate() {
        if (Global.isWrittenMemoryOffsetEmpty()) {
            return Integer.toString(Global.getRandom(0, 0x2fff));
        }
        return Integer.toString(Global.getRamdomWrittenMemoryOffset());
    }
}
