package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * @author Wameedh
 */

public class ArgsCode extends ByteCode {

    /**
     * The Args byteCode has one argument, the number of values that will be a part of the new activation frame.
     * The Args ByteCode will need to push the starting index of the new frame to the framePointer stack.
     * If dump is on, the Args ByteCode is required to be dumped. Examples are given in this document.
     */


    private int numberOfArguments;

    @Override
    public void init(ArrayList<String> args) {
        this.numberOfArguments = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.newFrameAtOffsetDownFromTopOfRunTimeStack(numberOfArguments);
    }

    public String toString() {
        return "ARGS " + numberOfArguments;
    }
}
