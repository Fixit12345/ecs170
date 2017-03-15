import java.util.*;


/// Entry point to program.
/**
 * Borrowed strucure from professors previous assignments to ensure correct output
 */
public class AASJ {
	
    /// Prints the commandline instructions.
    public static void helpPrinter() {
        System.out.println("  Command Line Parameters are as follows:");
        System.out.println("    \"--help\" : You're looking at it");
        System.out.println("    \"-Please make format such java AASJ -train dir dir");
        System.out.println("Note: Later command-line options override earlier ones if they are incompatable\n");
    }

    /// Program startup function.
    public static void main(String[] args) {
		FFNN myNN = new FFNN();

        // Parse through the command line arguements
        try {
            int i = 0;
            while (i < args.length) {
                if (args[i].equalsIgnoreCase("-train")) {
                    
                    myNN.train(args[i + 1]);
                    //myNN.train(args[i + 2]);
                    
                    i = i + 2;
                } else if (args[i].equalsIgnoreCase("-test")) {
                    myNN.test(args[i + 1]);
                    System.exit(0);
                    i++;
                } else if (args[i].equalsIgnoreCase("--help")) {
                    helpPrinter();
                    System.exit(0);
                    i++;
                } else {
                    throw new IllegalArgumentException();
				}
				i++;
            }
        }
        catch (IndexOutOfBoundsException ioob) {
            System.err.println("Invalid Arguments");
            System.exit(2);
        } catch (NumberFormatException e) {
            System.err.println("Invalid Integer: " + e.getMessage());
            System.exit(3);
        } catch (IllegalArgumentException ia) {
            System.err.println("Invalid Arguments: " + ia.getMessage());
            System.exit(4);
        } catch (Exception e) {
            System.err.println("Unknown Error");
            System.exit(5);
        }
    }
}
