package Instructions;

public abstract class Itype extends Instruction {
    private final int type;
    protected String rs;
    protected String rt;
    protected String immediate_label;

    public Itype(String name, int type, String rs, String rt, String immediate_label) {
        super(name);
        this.type = type;
        this.rs = rs;
        this.rt = rt;
        this.immediate_label = immediate_label;
    }

    @Override
    public String toString() {
        if (type == 0) {
            return getLabel() + super.name + " " + this.rt + ", " + this.rs + ", " + this.immediate_label;
        } else if (type == 1) {
            return getLabel() + super.name + " " + this.rt + ", " + this.immediate_label + "(" + this.rs + ")";
        } else {
            return getLabel() + super.name + " " + this.rt + ", " + this.rs + ", " + this.immediate_label;
        }
    }
}
