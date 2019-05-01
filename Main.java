

/**
 * Main class sets up and runs the simulation,
 * including managing user input and timestep control.
 */
public class Main {
	public static void main( String[] args ) {
		if (args.length != 1) {
			Externals.invalidUsageExit();
		}
		
		String simName = args[0].trim();
		MemorySimulatorBase sim = null;
		
		if ( simName.equals("first") ) {
			sim = new FirstFitMemorySimulator( );
		} else if ( simName.equals("best") ) {
			sim = new BestFitMemorySimulator();
		} else if ( simName.equals("next") ) {
			sim = new NextFitMemorySimulator();
		} else if ( simName.equals("worst") ) {
			sim = new WorstFitMemorySimulator();
		}
			else {
			Externals.invalidUsageExit();
		}
		
		sim.timeStepUntil(0);
		sim.printMemory();
	
		int count = 0;
		while (count > -1) {
			System.out.print("memsim> ");
			
			count++;
			
			sim.timeStepUntil(count);
			sim.printMemory();
		}
		
		System.out.println("No more events to process... exiting!");
	}
}
