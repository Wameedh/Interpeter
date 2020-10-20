package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author Wameedh
 */

public class ReturnCode extends ByteCode {


    /**
     * The Return ByteCode can take 0 to 1 arguments. The arguments have no effect on its functionality.
     * But does effect the Dumping process.
     * The Return ByteCode must store the return value at the top of the runtime stack.
     * The Return ByteCode must empty the current frame of all values when the function is complete.
     * The Return ByteCode must pop the top value from the framePointer stack to remove the frame boundary.
     * The return ByteCode must pop the top of the return address stack and save it into program counter.
     * If dumping is on, the Return ByteCode needs to be dumped according the specifications.
     */


    private String functionName;
    private int address;

    @Override
    public void init(ArrayList<String> args) {
        if (!args.isEmpty()) this.functionName = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        this.address = virtualMachine.popReturnAddress();
        virtualMachine.setProgramCounter(address);
        virtualMachine.popCurrentFrameOfRunTimeStack();
        this.address = virtualMachine.getTopOfRunTimeStack();

    }

    //RETURN f<<2>> EXIT f : 4
    public String toString() {
        int n = functionName.indexOf("<");
        String temp;
        if (n < 0) {
            temp = functionName;
        } else {
            temp = functionName.substring(0, n);
        }

        return "RETURN " + functionName + "    EXIT " + temp + ": " + address;

    }
}
