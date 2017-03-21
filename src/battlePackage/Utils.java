package battlePackage;

public class Utils {
	private static boolean dev;
	
	public static void p(String toPrint) {
		if (!dev) {
			if (toPrint==null)
				toPrint="";
			else
				toPrint=toPrint.replaceAll("null", "");
			if (!toPrint.trim().equals(""))
				System.out.println(toPrint);
		} else {
			System.out.println(toPrint);
		}
	}

	public static void p() {
		System.out.println();
		
	}

	public static void setDev(boolean dev) {
		Utils.dev=dev;
	}
}
