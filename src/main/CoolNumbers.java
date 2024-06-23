package main;

import java.util.*;

public class CoolNumbers {
    private static ArrayList<String> coolNumbers;
    private static final String ALLOWED_SYMBOLS_REGEX = "АВЕКМНОРСТУХ";
    private static final String FORMAT_STATE_NUMBER_REGEX =
            "[" + ALLOWED_SYMBOLS_REGEX + "]{1}(00[1-9]|0[1-9][0-9]|[1-9][0-9]{2})["
                    + ALLOWED_SYMBOLS_REGEX + "]{2}(0[1-9]|[1-9][0-9]{2}|[1-9][0-9])";

    public static List<String> generateCoolNumbers() {
        coolNumbers = new ArrayList<>();
        String[] allowedSymbols = ALLOWED_SYMBOLS_REGEX.split("");

        while(coolNumbers.size() < 2_000_000){
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 199; j++) {
                    String charA = allowedSymbols[(int)Math.round(Math.random() * 11)];
                    String charB = allowedSymbols[(int)Math.round(Math.random() * 11)];
                    String charC = allowedSymbols[(int)Math.round(Math.random() * 11)];

                    String region = "";
                    if(j < 10){
                        region = "0" + j;
                    } else{
                        region += j;
                    }

                    String number = String.format("%s%d%d%d%s%s%s", charA, i, i, i, charB, charC, region);
                    if(number.matches(FORMAT_STATE_NUMBER_REGEX)){
                        coolNumbers.add(number);
                    }
                }
            }
        }
        System.out.println(coolNumbers);
        return coolNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for (String s : list) {
            if (s.equals(number)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return Collections.binarySearch(sortedList, number) >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }
}

