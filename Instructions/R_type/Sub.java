package Instructions.R_type;

import utils.Global;
import Instructions.Rtype;

public class Sub extends Rtype {
    public Sub() {
        super(Global.getCurrentLine(), "sub", randomRegister(), randomRegister(), randomRegister());
    }
}
