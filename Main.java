import java.util.Scanner;

public class Main {
	
	static int TIME;
	
	public static void main( String[] args ) {
		if (args.length != 0) {
			Externals.invalidUsageExit();
		}
		
		MemorySimulatorBase sim1 = null;

		System.out.println("============================================");
		System.out.println("Choose You Memory Simulator:");
		System.out.println("============================================");
		System.out.println("first" +
		"\nbest" +
		"\nnext" +
		"\nworst" );

		Scanner scanner = new Scanner(System.in);

		String userInput = scanner.nextLine();
		if ( "first".equals(userInput) ) {
			sim1 = new FirstFitMemorySimulator( );
		} else if ( "best".equals(userInput) ) {
		 	sim1 = new BestFitMemorySimulator( );
		 } else if ( "next".equals(userInput) ) {
			sim1 = new NextFitMemorySimulator();
		} else if ( "worst".equals(userInput) ) {
			sim1 = new WorstFitMemorySimulator();
		}
	 	else {
		 	Externals.invalidUsageExit();
		 }
	
		sim1.timeStepUntil(0);
		sim1.printMemory();
	
		int count1 = 0;
		while (sim1.processesRemaining() != 0) {
			sim1.timeStepUntil(count1++);
		}
		
		System.out.println("No more events to process... ending this simulation!");
		
		
	}
}
