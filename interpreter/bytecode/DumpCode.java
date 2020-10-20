package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 *
 * @author Wameedh
 */

public class DumpCode extends ByteCode {

    /**
     * The Dump ByteCode has 1 argument. Either "ON" or "OFF"
     * The Dump ByteCode must request the VirtualMachine to turn dumping either "ON" or "OFF".
     * The Dump ByteCode is NOT TO BE DUMPED.
     */

    protected String label;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

        if("ON".equals(label)){
            virtualMachine.setDumbFlag(true);
        }
        else if("OFF".equals(label)){
            virtualMachine.setDumbFlag(false);
        }
    }

}
