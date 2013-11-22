package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: AllNumberDemo
 * User: liushuai
 * Date: 13-10-16
 * Time: 下午1:51
 */
public class AllNumberDemo {
    public static char[] numberTag = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void listAllNumber(int count) {
        String flage = "first";
        String num[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        List<String> finalTotalList = new ArrayList<String>();
        List<String> allList = new ArrayList<String>();
        //把一位数的情况 先存到list中,没算0
        allList = convertArrayToList(allList, num);

        String[] tempNum = null;
        while (count != 0) {
            if (flage.equals("first")) {
                finalTotalList = getNewArray(num);
                flage = "second";
            } else {
                finalTotalList = getNewArray(tempNum);
            }
            tempNum = convertListToArrayString(finalTotalList);
            copyList(allList, finalTotalList);
            count--;
        }
        for (int i = 0; i < allList.size(); i++) {
            System.out.println("总共" + allList.size() + "个 " + " 第" + (i + 1) + "个 " + "数字为: " + allList.get(i));
        }
    }

    public static List<String> convertArrayToList(List<String> oldList, String[] num) {
        for (int i = 0; i < num.length; i++) {
            oldList.add(num[i]);
        }
        return oldList;
    }

    public static String[] convertListToArrayString(List<String> list) {
        String[] tempArray = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tempArray[i] = list.get(i);
        }
        return tempArray;
    }

    public static List<String> getNewArray(String[] num) {
        List<String> totalList = new ArrayList<String>();
        for (int i = 0; i < num.length; i++) {
            //把“123”---》'1''2''3'
            char[] tempArray = convertStringToArray(num[i]);
            copyList(totalList, cmpTargetArray(tempArray, numberTag));
        }
        return totalList;
    }

    public static List<String> copyList(List<String> totalList, List<String> oldList) {
        for (int i = 0; i < oldList.size(); i++) {
            totalList.add(oldList.get(i));
        }
        return totalList;
    }

    public static char[] convertStringToArray(String str) {
        char[] array = str.toCharArray();
        return array;
    }

    public static List<String> cmpTargetArray(char[] array, char[] numberTag) {
        List<String> stringList = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        for (int i = 0; i < numberTag.length; i++) {
            if (isNotIn(array, numberTag[i])) {
                stringList.add(sb.toString() + numberTag[i]);
            }
        }
        return stringList;
    }

    public static boolean isNotIn(char[] array, char number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //1，表示 把 1位数的 和 2位数的 情况 都列出来
        //从1位数到10位数的都列举出来了。
        listAllNumber(9);
    }
}
