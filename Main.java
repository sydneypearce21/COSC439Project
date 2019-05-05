

/**
 * Main class sets up and runs the simulation,
 * including managing user input and timestep control.
 */
public class Main {
	
	static int TIME;
	
	public static void main( String[] args ) {
		if (args.length != 1) {
			Externals.invalidUsageExit();
		}
		
		String simName = args[0].trim();
		MemorySimulatorBase sim = null;
		
		if ( "first".equals(simName) ) {
			sim = new FirstFitMemorySimulator( );
		} else if ( "best".equals(simName) ) {
			sim = new BestFitMemorySimulator();
		} else if ( "next".equals(simName) ) {
			sim = new NextFitMemorySimulator();
		} else if ( "worst".equals(simName) ) {
			sim = new WorstFitMemorySimulator();
		}
			else {
			Externals.invalidUsageExit();
		}
		
		sim.timeStepUntil(0);
		sim.printMemory();
	
		TIME = 500;
		while (TIME > 0) {
			sim.timeStepUntil(TIME);
			
			TIME--;
		}
		
		System.out.println("No more events to process... exiting!");
	}
}
