public class NumberToString {
    private static final String[] NUM = {"1", "5", "10", "17", "20", "21", "30", "34", "99", "100", "150", "129",
            "179", "1000", "2000", "3306", "5003", "7897", "8888", "9020", "10000", "20001", "30060", "40700", "56789",
            "100000", "210000", "305789", "409001", "777777", "2000000", "5777777", "20000000", "60409001", "55555555",
            "300000000", "91140703", "4000000000", "6091140703"};// 100 ; 100,000 ; 1,000,000 (million) ; 1,000,000,000 (billion)

    private static String getNumString(int num) {
        switch (num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "";
    }

    private static String tenToTwenty(int num) {
        switch (num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }

    private static String twoDigit(int num) {
        if (num >= 10 && num < 20) {
            return tenToTwenty(num);
        } else if (num >= 20 && num < 30) {
            return "Twenty".concat(" ").concat(getNumString(num%10));
        } else if (num >= 30 && num < 40) {
            return "Thirty".concat(" ").concat(getNumString(num%10));
        } else if (num >= 40 && num < 50) {
            return "Forty".concat(" ").concat(getNumString(num%10));
        } else if (num >= 50 && num < 60) {
            return "Fifty".concat(" ").concat(getNumString(num%10));
        } else if (num >= 60 && num < 70) {
            return "Sixty".concat(" ").concat(getNumString(num%10));
        } else if (num >= 70 && num < 80) {
            return "Seventy".concat(" ").concat(getNumString(num%10));
        } else if (num >= 80 && num < 90) {
            return "Eighty".concat(" ").concat(getNumString(num%10));
        } else if (num >= 90 && num < 100) {
            return "Ninety".concat(" ").concat(getNumString(num%10));
        } else {
            return getNumString(num);
        }
    }

    private static String threeDigit(String num) {
        final String result = getNumString(num.charAt(0) - '0');
        if ("".equals(result)) {
            return twoDigit(Integer.parseInt(num.substring(1)));
        } else {
            return result.concat(" Hundred ").concat(twoDigit(Integer.parseInt(num.substring(1))));
        }
    }

    private static String fourDigit(String num) {
        final String result = getNumString(num.charAt(0) - '0');
        if ("".equals(result)) {
            return threeDigit(num.substring(1));
        } else {
            return result.concat(" Thousand ").concat(threeDigit(num.substring(1)));
        }
    }

    private static String fiveDigit(String num) {
        final String result = twoDigit(Integer.parseInt(num.substring(0, 2)));
        if ("".equals(result)) {
            return result;
        } else {
            return result.concat(" Thousand ").concat(threeDigit(num.substring(2)));
        }
    }

    private static String sixDigit(String num) {
        final String result = threeDigit(num.substring(0, 3));
        if ("".equals(result)) {
            return result;
        } else {
            return result.concat(" Thousand ").concat(threeDigit(num.substring(3)));
        }
    }

    private static String sevenDigit(String num) {
        final String result = getNumString(num.charAt(0) - '0');
        if ("".equals(result)) {
            return sixDigit(num.substring(1));
        } else {
            return result.concat(" Million ").concat(sixDigit(num.substring(1)));
        }
    }

    private static String eightDigit(String num) {
        final String result = twoDigit(Integer.parseInt(num.substring(0, 2)));
        if ("".equals(result)) {
            return sixDigit(num.substring(2));
        } else {
            return result.concat(" Million ").concat(sixDigit(num.substring(2)));
        }
    }

    private static String nineDigit(String num) {
        final String result = threeDigit(num.substring(0, 3));
        if ("".equals(result)) {
            return sixDigit(num.substring(3));
        } else {
            return result.concat(" Million ").concat(sixDigit(num.substring(3)));
        }
    }

    private static String tenDigit(String num) {
        final String result = getNumString(num.charAt(0) - '0');
        if ("".equals(result)) {
            return nineDigit(num.substring(1));
        } else {
            return result.concat(" Billion ").concat(nineDigit(num.substring(1)));
        }
    }

    private static String convert(String num) {
        switch (num.length()) {
            case 1:
                return getNumString(num.charAt(0) - '0');
            case 2:
                return twoDigit(Integer.parseInt(num));
            case 3:
                return threeDigit(num);
            case 4:
                return fourDigit(num);
            case 5:
                return fiveDigit(num);
            case 6:
                return sixDigit(num);
            case 7:
                return sevenDigit(num);
            case 8:
                return eightDigit(num);
            case 9:
                return nineDigit(num);
            case 10:
                return tenDigit(num);
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        for (String n : NUM) {
            System.out.println(n + " -- " + convert(n).replaceAll("  ", " "));
        }
    }
}
