
package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN loadCodes.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
        this.program = new Program();
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts. Can also use the split function in the String class.
     * Grab THE correct class name for the given ByteCode from CodeTable
     * Create an instance of the ByteCode class name returned from code table.
     * Parse any additional arguments for the given ByteCode and send them to
     * the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {

        String line;
        String[] items;
        //The Vector args holds the arguments associated with each bytecode (i.e. LIT 0, 0 is args[0])
        ArrayList<String> args = new ArrayList<>();
        String byteCodeName; // Bye name from .x.cod file
        String className; // class name after it was mapped from name in source code
        Class classBlueprint;
        ByteCode bc;
        Program program = new Program();

        try {
            while (this.byteSource.ready()) {

                line = byteSource.readLine(); // Tokenize read line
                items = line.split("\\s+");
                byteCodeName = items[0]; // grab the first token
                className = CodeTable.getClassName(byteCodeName); // grab class name from a token
                classBlueprint = Class.forName("interpreter.bytecode." + className); // Using the class name , load the Class blueprint into the JVM
                // Get a reference to the construction of the class blueprint
                // referenced by c. Create an instance for the class blueprint.
                bc = (ByteCode) classBlueprint.getDeclaredConstructor().newInstance();

                // grab remaining args

                for (int i = 1; i < items.length; i++) {

                    if (items[i].contains(">>")) {
                        for (int j = 0; j < items[i].length(); j++) {
                            char c = items[i].charAt(j);

                            Boolean flag = Character.isDigit(c);
                            if (flag) {
                                String str = String.valueOf(c);
                                args.add(str);
                            }
                        }

                    } else {
                        args.add(items[i]);
                    }

                }

                // pass args to init bytCode function
                bc.init(args);
                // add bytCode to program
                program.add(bc);


            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
            System.exit(255);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        program.resolveAddress();
        return program;
    }
}
