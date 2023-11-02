package Instructions.R_type;

import Instructions.Rtype;

public class Addu extends Rtype {
    public Addu() {
        super("add", randomRegister(), randomRegister(), randomRegister());
    }
}
