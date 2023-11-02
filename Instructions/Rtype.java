package Instructions;

public abstract class Rtype extends Instruction {
    protected String rs;
    protected String rt;
    protected String rd;

    public Rtype(String name, String rs, String rt, String rd) {
        super(name);
        this.rs = rs;
        this.rt = rt;
        this.rd = rd;
    }

    @Override
    public String toString() {
        return getLabel() + super.name + " " + this.rd + ", " + this.rs + ", " + this.rt;
    }
}
