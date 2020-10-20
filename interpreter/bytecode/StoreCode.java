package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 *
 * @author Wameedh
 */

public class StoreCode extends ByteCode {


    /**
     * The Store ByteCode can have 1 to 2 arguments.
     * - one argument is the offset in the current frame where the value that is popped is to be stored.
     * - The second argument, if present, is the identifier (variable) the value being moved belongs to. This we will be using for dumping.
     * Store must pop the top of the runtime stack and store the value at the offset in the current frame.
     * Store cannot operate across frame boundaries.
     * If dump is on, Store needs to be dumped.
     */

    private int offset, value;
    private String id;

    @Override
    public void init(ArrayList<String> args) {

        this.offset = Integer.parseInt(args.get(0));
        if(args.size() > 1) this.id = args.get(1);

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        this.value = virtualMachine.getTopOfRunTimeStack();
        virtualMachine.storeItemTopItemOfRunTimeStackIntoAnOffset(offset);
    }

    public String toString(){
        return "STORE " + offset + " " + id + " " + id + " = " + value;
    }
}
