package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    /**
     * Bop must pop 2 values from the runtime stack.
     * Bop must push 1 value, the result, back to the top of the runtime stack.
     * Bop must implement the following binary operations:
     * Addition: +
     * Subtraction: -
     * Division: /
     * Multiplication: *
     * Equality: ==
     * Not-Equal To: !=
     * Less-Than Equal To: <=
     * Greater Than: >
     * Greater Than Equal To: >=
     * Less Than: <
     * Logical OR: |
     * Logical AND: &
     * If dump is on, the Bop ByteCode is required to be dumped.
     */

    private String operator;

    @Override
    public void init(ArrayList<String> args) {
        this.operator = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int firstValue = virtualMachine.popTopOfRunTimeStack();
        int secondValue = virtualMachine.popTopOfRunTimeStack();
        int result = 0;

        if ("+".equals(operator)) {
            result = secondValue + firstValue;
        } else if ("-".equals(operator)) {
            result = secondValue - firstValue;
        } else if ("*".equals(operator)) {
            result = secondValue * firstValue;
        } else if ("/".equals(operator)) {
            result = secondValue / firstValue;
        } else if ("==".equals(operator)) {
            if (secondValue == firstValue)
                result = 1;
            else result = 0;
        } else if ("!=".equals(operator)) {
            if (secondValue == firstValue)
                result = 0;
            else result = 1;
        } else if ("<=".equals(operator)) {
            if (secondValue <= firstValue)
                result = 1;
            else result = 0;
        } else if (">=".equals(operator)) {
            if (secondValue >= firstValue)
                result = 1;
            else result = 0;
        } else if ("<".equals(operator)) {
            if (secondValue < firstValue)
                result = 1;
            else result = 0;
        } else if (">".equals(operator)) {
            if (secondValue > firstValue)
                result = 1;
            else result = 0;
        } else if ("|".equals(operator)) {
            if (secondValue == 0 && firstValue == 0)
                result = 0;
            else result = 1;
        } else if ("&".equals(operator)) {
            if (secondValue == 1 && firstValue == 1)
                result = 1;
            else result = 0;
        }

        virtualMachine.pushToRunTimeStack(result); //push result to the Run Time Stack

    }

    public String toString() {
        return "BOP" + operator;
    }

}
