package genericSerDeser.util;

public class Logger {
	/*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
    DEBUG_VALUE=3 [Print to stdout everytime the serdeser and createDPMLFormat function is called]
    DEBUG_VALUE=2 [Print to stdout the objects added to first second object list]
    DEBUG_VALUE=1 [Print to the output that will be displayed in output.txt]
    DEBUG_VALUE=0 [the line "output.txt File created" ]
	 */

	public static enum DebugLevel {RELEASE, FROM_RESULTS, IN_RESULTS, IN_MAKER, CONSTRUCTOR
	};

	private static DebugLevel debugLevel;


	public static void setDebugValue (int levelIn) {
		switch (levelIn) {
		case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
		// add code for other cases
		case 3:
			debugLevel = DebugLevel.IN_MAKER;
			break;
		case 2:
			debugLevel = DebugLevel.IN_RESULTS;
			break;
		case 1:
			debugLevel = DebugLevel.FROM_RESULTS;
			break;
		case 0: debugLevel = DebugLevel.RELEASE; break;
		}
	}

	public static void setDebugValue (DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	// @return None
	public static void writeMessage (String  message  ,
			DebugLevel levelIn ) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	/**
	 * @return String
	 */
	public String toString() {
		return "Debug Level is " + debugLevel;
	}
}
