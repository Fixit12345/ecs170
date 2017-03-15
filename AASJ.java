import java.util.*;
import java.io.*;

/// Entry point to program.
/**
 * This class acts as the entry point to the program and is responsible for parsing command line arguments
 * and setting up the GameController.  Run the program with the --help command-line parameter for more
 * information.
 * 
 * @author Leonid Shamis
 */
public class AASJ {
    /// Prints the commandline instructions.
    public static void helpPrinter() {
        System.out.println("  Command Line Parameters are as follows:");
        System.out.println("    \"--help\" : You're looking at it");
        System.out.println("    \"-Please make format such java AASJ -train dir dir");
        System.out.println("Note: Later command-line options override earlier ones if they are incompatable\n");
    }

    public static void openFile(String filename) {
        List < Integer > list = new ArrayList < Integer > ();
        File file = new File(filename);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                list.add(Integer.parseInt(text));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {}
        }

        //print out the list
        System.out.println(list);
    }

    /// Program startup function.
    public static void main(String[] args) {
        String[] dirFiles;
        File myDir = null;
        File tFile = null;
        int cont = 0;

        // Parse through the command line arguements
        try {
            int i = 0;
            while (i < args.length) {
                if (args[i].equalsIgnoreCase("-train")) {
                    myDir = new File("Female");
                    //store the names of files in myDir as String[]
                    dirFiles = myDir.list();
                    for(String f:dirFiles) {
						// prints filename and directory name
						System.out.println(f);
					}
                    //openFile(temp);
                    // Compensate for i += 2
                    i = i + 2;
                } else if (args[i].equalsIgnoreCase("-test")) {
                    helpPrinter();
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
        /*catch(ClassNotFoundException cnf)
        {
        	System.err.println("Player Not Found: " + cnf.getMessage());
        	System.exit(1);
        }*/
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

        // Create a new game

        try {
            // Load an optimized game representation if possible

        } catch (Exception e) {
            // Otherwise use a generic game representation

        }

    }
}
