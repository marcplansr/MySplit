
public class Main {

	public static void main(String[] args) {
		String stringToSplit = "hell,owr,ld,!!";
		String separator = ",";

		System.out.println(stringArrayToString(mySplit(stringToSplit, separator)));
	}

	private static String[] mySplit(String stringToSplit, String separator) {
		int[] separatorIndex = getSplitIndex(stringToSplit, separator);
		String[] output = new String[separatorIndex.length + 1];
		int startPoint = 0;
		for (int i = 0; i < separatorIndex.length + 1; i++) {
			if (i < separatorIndex.length) {
				output[i] = mySubString(stringToSplit, startPoint, separatorIndex[i]);
				startPoint = separatorIndex[i] + separator.length();
			} else if (myStringMatch(mySubString(stringToSplit, stringToSplit.length() - separator.length()),
					separator)) {
				output[i] = mySubString(stringToSplit, startPoint, stringToSplit.length() - separator.length());
			} else {
				output[i] = mySubString(stringToSplit, startPoint);
			}
		}
		return output;
	}

	private static int[] getSplitIndex(String stringToSplit, String separator) {
		int[] rawOutput = new int[stringToSplit.length() / 2];
		int arrayIndex = 0;
		for (int i = 0; i < stringToSplit.length(); i++) {
			if ((i + separator.length() < stringToSplit.length())
					&& (myStringMatch((mySubString(stringToSplit, i, i + separator.length())), separator))) {
				rawOutput[arrayIndex] = i;
				arrayIndex++;
				i += separator.length();
			}
		}
		int[] output = new int[arrayIndex];
		for (int i = 0; i < output.length; i++) {
			output[i] = rawOutput[i];
		}
		return output;
	}

	// start index included, end index excluded
	private static String mySubString(String originalString, int startIndex, int endIndex) {
		String output = "";
		for (int i = startIndex; i < endIndex; i++) {
			output += originalString.charAt(i);
		}
		return output;
	}

	private static String mySubString(String originalString, int startIndex) {
		return mySubString(originalString, startIndex, originalString.length());
	}

	private static boolean myStringMatch(String firstString, String secondString) {
		if (firstString.length() != secondString.length()) {
			return false;
		}
		for (int i = 0; i < firstString.length(); i++) {
			if (firstString.charAt(i) != secondString.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private static String stringArrayToString(String[] arrayToString) {
		String outputString = "[";
		for (int i = 0; i < arrayToString.length; i++) {
			outputString += arrayToString[i];
			if (i < arrayToString.length - 1) {
				outputString += ", ";
			}
		}
		return outputString + "]";
	}

	private static String intArrayToString(int[] arrayToString) {
		String outputString = "[";
		for (int i = 0; i < arrayToString.length; i++) {
			outputString += arrayToString[i];
			if (i < arrayToString.length - 1) {
				outputString += ", ";
			}
		}
		return outputString + "]";
	}

}
