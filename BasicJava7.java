public class BasicJava7 {
	
	public static boolean isUpper(char aChar) {
		return aChar >= 'A' && aChar <= 'Z';
	}
	
	public static double volumeOfCylinder(double radius,double height) {
		double volume = (double) 3.14*radius*radius*height;
		if (radius < 0 || height < 0) {
			volume = 0;
		}
		return volume;
	}
	
	public static boolean isPerfectNumber(int number) {
		boolean result = false;
		int sum = 0;
		for (int i = 1; i < number; i++) {
			if (number%i == 0) {
				sum = sum + i;
			}
		}
		if (number == sum && number > 0) {
			result = true;
		}
		return result;
	}
	
	public static int indexOfFirstUpperCaseChar(String str) {
		int index = 0;
		if (str.length() > 0) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) < 'A' || str.charAt(i) > 'Z') {
					index = index+1;
				} 
				else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
					break;
				}
			}
			if (index == str.length()) {
				index = -1;
			}
		}
		else if(str.length() == 0) {
			index = -1;
		}
		return index;
	}

}
