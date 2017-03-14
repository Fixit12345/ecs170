import javax.swing.*;

/// Entry point to program.
/**
 * This class acts as the entry point to the program and is responsible for parsing command line arguments
 * and setting up the GameController.  Run the program with the --help command-line parameter for more
 * information.
 * 
 * @author Leonid Shamis
 */
public class Main
{
	/// Prints the commandline instructions.
	public static void helpPrinter()
	{
		System.out.println("  Command Line Parameters are as follows:");
		System.out.println("    \"--help\" : You're looking at it");
		System.out.println("    \"-p1 [AI Class Name]\" : Set player 1 to the appropriate AI");
		System.out.println("      Example: -p1 StupidAI");
		System.out.println("    \"-p2 [AI Class Name]\" : Set player 2 to the appropriate AI");
		System.out.println("      Example: -p2 RandomAI");
		System.out.println("    \"-t [Time in ms]\" : Set the maximum amount of time alloted per AI move");
		System.out.println("      Example: -t 500");
		System.out.println("    \"-w [int]\" : Set the width of the game board");
		System.out.println("      Example: -w 7");
		System.out.println("    \"-h [int]\" : Set the height of the game board");
		System.out.println("      Example: -h 6");
		System.out.println("    \"-seed [int]\" : Set the random seed of hte game");
		System.out.println("      Example: -s 1");
		System.out.println("    \"-text\" : Prints using a text-based I/O");
		System.out.println("Note: Later command-line options override earlier ones if they are incompatable\n");
	}

	/// Program startup function.
	public static void main(String[] args)
	{
		boolean text = false;

		// Parse through the command line arguements
		try
		{
			int i = 0;
			while(i < args.length)
			{
				if(args[i].equalsIgnoreCase("-train"))
				{
					text = true;
					HelloWorld myHello = new HelloWorld();
					myHello.hello();
					// Compensate for i += 2
					i--;
				}
				else if(args[i].equalsIgnoreCase("-test"))
				{
					helpPrinter();
					System.exit(0);
				}
				else if(args[i].equalsIgnoreCase("--help"))
				{
					helpPrinter();
					System.exit(0);
				}
				else
					throw new IllegalArgumentException();
				i += 2;
			}
		}
		/*catch(ClassNotFoundException cnf)
		{
			System.err.println("Player Not Found: " + cnf.getMessage());
			System.exit(1);
		}*/
		catch(IndexOutOfBoundsException ioob)
		{
			System.err.println("Invalid Arguments");
			System.exit(2);
		}
		catch(NumberFormatException e)
		{
			System.err.println("Invalid Integer: " + e.getMessage());
			System.exit(3);
		}
		catch(IllegalArgumentException ia)
		{
			System.err.println("Invalid Arguments: " + ia.getMessage());
			System.exit(4);
		}
		catch(Exception e)
		{
			System.err.println("Unknown Error");
			System.exit(5);
		}

		// Create a new game
		
		try
		{
			// Load an optimized game representation if possible
			
		}
		catch(Exception e)
		{
			// Otherwise use a generic game representation
			
		}

	}
}

