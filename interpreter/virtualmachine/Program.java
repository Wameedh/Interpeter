package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.*;

import java.util.HashMap;
import java.util.ArrayList;

public class Program {

    private ArrayList<ByteCode> program;
    private static HashMap<String, Integer> labelTable;

    public Program() {
        program = new ArrayList<>();
        labelTable = new HashMap<>();
    }

    public ByteCode getCode(int pc) {
        return this.program.get(pc);
    }


    /**
     * This method is used to add the bytecode instance to the program class
     */
    public void add(ByteCode byteCode) {
        if (byteCode instanceof LabelCode) {
            LabelCode label = (LabelCode) byteCode;
            labelTable.put(label.getLabel(), program.size());
        }
        if (byteCode instanceof BranchCode) {
            BranchCode branchCode = (BranchCode) byteCode;
            labelTable.put(branchCode.getLabel(), program.size());
        }
        program.add(byteCode);
    }


    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void resolveAddress() {
        // 1st pass throw the arrayList keeping track of label codes and their labels
        // 2nd pass throw the arrayList look for call, goto and falsebranch code and do the following:
        // Look at stored label codes and find one that matching label value

        int jumpAddress;
        for (ByteCode byteCode : program) {
            if (byteCode instanceof BranchCode) {
                BranchCode temp = (BranchCode) byteCode;
                jumpAddress = (Integer) labelTable.get(temp.getLabel()); //get the address that matches
                temp.setTargetAddress(jumpAddress);

            }
        }

    }


}
