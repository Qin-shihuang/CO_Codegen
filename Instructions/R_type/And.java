package Instructions.R_type;

import Instructions.Rtype;

public class And extends Rtype {
    public And() {
        super("and", randomRegister(), randomRegister(), randomRegister());
    }
}
