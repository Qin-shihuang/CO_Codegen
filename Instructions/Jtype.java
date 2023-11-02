package Instructions;

public abstract class Jtype extends Instruction {
    protected final String label;

    public Jtype(int currentLine, String name, String label) {
        super(currentLine, name);
        this.label = label;
    }

    @Override
    public String toString() {
        return getLabel() + super.name + " " + this.label;
    }
}