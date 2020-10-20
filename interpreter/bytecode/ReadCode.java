package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Wameedh
 */
public class ReadCode extends ByteCode {

    /**
     * When asking for user input, use the following prompt: "Please enter an integer : "
     * The Read ByteCode needs to verify that the value given is actually a number. If
     * an invalid number is given, state that the input is invalid and ask for another value.
     * Continue to do so until a valid value is given.
     * Push the validated integer to the VirtualMachine's RunTimeStack.
     * If dumping is on, Simply print "READ" to the console.
     */

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

        while (true) {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Please enter an integer : ");
                String input = in.readLine();
                int integerInput = Integer.parseInt(input);
                virtualMachine.pushToRunTimeStack(integerInput);
                break;
            } catch (Exception e) {
                System.out.println("input is invalid");
            }
        }

    }

    public String toString() {
        return "READ";
    }

}
