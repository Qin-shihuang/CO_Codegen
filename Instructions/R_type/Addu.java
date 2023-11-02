package Instructions.R_type;

import utils.Global;
import Instructions.Rtype;

public class Addu extends Rtype {
    public Addu() {
        super(Global.getCurrentLine(), "addu", randomRegister(), randomRegister(), randomRegister());
    }
}
