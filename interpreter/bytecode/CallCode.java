package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * @author Wameedh
 */

public class CallCode extends BranchCode {

    /**
     * Call ByteCode takes 1 argument, a label to jump to.
     * Call Code must go through address resolution to figure out where it needs to jump to in the Program before the program is ran.
     * Call Code must store a return address onto the Return Address Stack.
     * Call Code must Jump the address in the program that corresponds to a label code (this address is computed during address resolution).
     * If dumping is on, the Call ByteCode needs to be dumped according the specifications in the Dumping formats section.
     */

    private int ReturnAddress;
    private String labelToJumpTo;

    @Override
    public void init(ArrayList<String> args) {
        labelToJumpTo = args.get(0);

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int ProgramCounter = virtualMachine.getProgramCounter();
        virtualMachine.pushReturnAddress(ProgramCounter);
        virtualMachine.setProgramCounter(ReturnAddress);
    }

    @Override
    public int getTargetAddress() {
        return this.ReturnAddress;
    }

    @Override
    public void setTargetAddress(int index) {
        this.ReturnAddress = index;
    }

    @Override
    public String getLabel() {
        return this.labelToJumpTo;
    }

    public void setLabel(int index) {
        this.labelToJumpTo = Integer.toString(index);
    }


    // CALL f<<3>> f(3,4,5) example
    public String toString() {
        return "CALL" + "f<<" + labelToJumpTo + ">>";
    }

}
