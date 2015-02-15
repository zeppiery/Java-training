package com.company;

import java.util.Arrays;

public class MainArray {

    public static void main(String[] args) {
        System.out.println("Two arrays are not empty:");
        TwoFullArray();
        System.out.println("One array is empty:");
        OneArrayIsEmpty();
        System.out.println("One array is Null.");
        OneArrayIsNull();
    }
    private static void TwoFullArray() {
        int[] LeftArray = new int[]{1, 5, 4, 23, 65, 32, 78};
        int[] RightArray = new int[]{3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectResult = new int[]{1, 5, 4, 23, 65, 32, 78, 5, 4, 1, 32, 5};
        System.out.println("leftArray:= " + Arrays.toString(LeftArray));
        System.out.println("rightArray:= " + Arrays.toString(RightArray));

        MainArray Main = new MainArray();
        int[] returnValue;
        returnValue = Main.leftUnion(LeftArray, RightArray);

        System.out.println("returnValue:= " + Arrays.toString(returnValue));
        System.out.println("expectResult:= " + Arrays.toString(expectResult));
    }
    private static void OneArrayIsEmpty() {
        int[] LeftArray = new int[]{1, 5, 4, 23, 65, 32, 78};
        int[] RightArray = new int[]{};
        int[] expectResult = new int[]{1, 5, 4, 23, 65, 32, 78};
        System.out.println("leftArray:= " + Arrays.toString(LeftArray));
        System.out.println("rightArray:= " + Arrays.toString(RightArray));

        MainArray Main = new MainArray();
        int[] returnValue;
        returnValue = Main.leftUnion(LeftArray, RightArray);

        System.out.println("returnValue:= " + Arrays.toString(returnValue));
        System.out.println("expectResult:= " + Arrays.toString(expectResult));
    }
    private static void OneArrayIsNull() {
        int[] LeftArray = new int[]{1, 5, 4, 23, 65, 32, 78};
        int[] RightArray = null;
        //int[] expectResult = new int[]{1, 5, 4, 23, 65, 32, 78, 5, 4, 1, 32, 5};
        System.out.println("leftArray:= " + Arrays.toString(LeftArray));
        System.out.println("rightArray:= " + Arrays.toString(RightArray));

        MainArray Main = new MainArray();
        if (!(RightArray instanceof int[])) {
            System.out.println("Second array is Null.");
            return;
        }
        int[] returnValue = Main.leftUnion(LeftArray, RightArray);

        System.out.println("returnValue:= " + Arrays.toString(returnValue));
        //System.out.println("expectResult:= " + Arrays.toString(expectResult));
    }

    public int[] leftUnion(int[] leftArray, int[] rightArray) {//метод LeftUnion
        int[] buffArray = new int[leftArray.length+rightArray.length];
        System.arraycopy(leftArray,0,buffArray,0,leftArray.length);
        //System.out.println("buffArray:= " + Arrays.toString(buffArray));
        int countFoundedElement = 0;
        for (int rightArrayElement: rightArray){
            for (int leftArrayElement: leftArray){
                if(rightArrayElement == leftArrayElement){
                    buffArray[leftArray.length+countFoundedElement]= rightArrayElement;
                    countFoundedElement++;
                }
            }
        }
        //написать на binary search
        int[] cutArray = new int[leftArray.length+countFoundedElement];
        cutArray = Arrays.copyOf(buffArray,leftArray.length+countFoundedElement);
        return cutArray;

    }
}
