public class LuhnCheck{
    public static boolean checkCard(String value) {
        String number = value.trim();
        int length = number.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(number.charAt(i))) {
                System.out.println("Please enter nemeric value !");
                return false;
            }
        }

        int[] array = new int[length];
        int tempArray[] = new int[length];
        int max = array.length - 1;

        for (int i = 0; i < length; i++) {
            String substring = number.substring(i, i + 1);
            array[i] = Integer.parseInt(substring);
            tempArray[i] = Integer.parseInt(substring);
        }

        for (int i = max; i >= 0; i--) {
            if (i > 0) {
                int temp = array[i - 1];
                int doubleTemp = temp * 2;

                if (doubleTemp > 9) {
                    int addValue = 0;
                    String v = Integer.toString(doubleTemp);
                    for (int j = 0; j < v.length(); j++) {
                        addValue = addValue + Integer.parseInt(v.charAt(j) + "");
                    }
                    tempArray[i - 1] = addValue;
                }
            }
        }
        int total = 0;
        for (int i = 0; i < tempArray.length; i++) {
            total = total + i;
        }
        return total % 10 == 0;
    }

    public static void main(String[] args) {
        System.out.println(checkCard("CARD_NO"));;
    }    
}
