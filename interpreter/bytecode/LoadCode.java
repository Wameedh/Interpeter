package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * @author Wameedh
 */

public class LoadCode extends ByteCode {

    /**
     * The Load ByteCode can have 1 to 2 arguments.
     * - one argument is the offset in the current frame where the value is to be copied from.
     * - The second argument, if present, is the identifier (variable) the value belongs to.
     * This we be used for dumping.
     * Load must copy the value at the o set in the current and push it to the top of the stack.
     * Load must not remove any values from the runtime stack.
     * Load cannot operate across frame boundaries.
     * If dump is on, Load needs to be dumped according the specifications given in the
     * Dumping Formats section.
     */

    private int offset;
    private String id;

    @Override
    public void init(ArrayList<String> args) {
        this.offset = Integer.parseInt(args.get(0));
        if (args.size() > 1) this.id = args.get(1);

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.loadValueOnTopOfRunTimeStack(offset);
    }

    public String toString() {

        String bass = "LOAD " + offset;
        if (id != null) {
            bass += " <load " + id + ">";
        }
        return bass;

    }
}
