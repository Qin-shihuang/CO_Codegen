package Instructions;

public abstract class Instruction {
    private String name;
    private int type;
    private String opcode;
    private String funct;

    /*
     * 0: R-type
     * add, sub
     * Format: example $rd, $rs, $rt
     * 1: I-type
     * ori,lui
     * Format: example $rt, $rs, imm
     * 2: I-type
     * lw, sw
     * Format: example $rt, imm($rs)
     * 3: I-type
     * beq
     * Format: example $rs, $rt, tag
     * 4: J-type
     * jr
     * Format: example $rs
     * 5: J-type
     * jal
     * Format: example tag
     * 6: NOP
     * nop
     */
    public String toString() {
        switch()
    }

}
