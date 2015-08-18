package com.interview.prep;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by vishwajan on 4/27/15.
 */
public class Test
{
    public static void main(String[] args)
    {
        System.out.println("The Banned Stuff");
        BannedStuff bs = new BannedStuff();
        int[] threats = {4,5,1,3,7,8,2,6};
        System.out.println(bs.maxThreats(threats));

        String[] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println(bs.longestChain(words));
        /*
        int median1[] = {1, 2, 3, 6};
        int median2[] = {4, 6, 8, 10};
        /*
        int[] threeSumarr = {-8,0,1,2,3,4,8};
        System.out.println(bs.threeSum(threeSumarr));
        int[] minDistance = {2,1,1,4,3,6};
        System.out.println(bs.minSequenceGreaterThanSum(minDistance, 8));
        System.out.println("Geeks for Geeks");
        */
        /*Geeks for Geeks Arrays */
        Geeks_Arrays arrays = new Geeks_Arrays();
        //System.out.println(arrays.medianSortedArrays(median1,median2));

        int[] checkSum = {1,5,3,11,8,4};
        System.out.println(arrays.checkSum(checkSum, 9));
        int[] majority = {1, 3, 3, 1, 2,3,3};
        System.out.println(arrays.majorityElement(majority));
        int[] xor = {1,2,1,2,1};
        System.out.println(arrays.oddOccuring(xor));
        int[] maxSum = {-1, -2, -3, -4};
        System.out.println(arrays.maxSum(maxSum));
        int[] missing  = {1,2,4};
        System.out.println(arrays.findMissingNumber(missing));
        int[] sortedRotated = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(arrays.searchInSortedArray(sortedRotated, 10));
        int[] bigMerge = {1,2,3,4,0,0,0};
        int[] smallMerge = {1,2,3};
        arrays.merge(bigMerge,smallMerge, 3);
        for(Integer i : bigMerge)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] reverse = {1,2,3,4,5};
        arrays.reverseArray(reverse, 0 , reverse.length-1);
        arrays.rotateArray(reverse, 2);
        for(Integer i : reverse)
        {
            System.out.print(i + " ");
        }
        System.out.println();

        int [] juggle = {1,2,3,4,5,6,7,8,9,10,11,12};
        arrays.juggleRotateArray(juggle, 3);
        System.out.println("This is BlockSwap Test:");
        for(Integer i : juggle)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] maxArray =  {5,  5, 10, 40, 50, 35};
        System.out.println(arrays.findMax(maxArray));
        int[] leaders = {16, 17, 4, 3, 5, 2};
        arrays.printLeaders(leaders);
        System.out.println();
        int[] inversions = {2, 4, 1, 3, 5};
        System.out.println(arrays.countInversions(inversions));
        int[] minSum = {1, 60, -10, 70, -80, 85};
        arrays.minAbsPair(minSum);
        arrays.twoSmallElements(leaders);
        int[] segregate = {0,1,0,0,0,1};
        arrays.segregate01(segregate);
        for(Integer i : segregate)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        List<Integer> list1 = new LinkedList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> result = arrays.intersection(list1, new LinkedList<Integer>());
        for(Integer i: result)
        {
            System.out.print(i + " ");
        }
        int[][] subsquareMatrix = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(arrays.maxSizeSubSquareMatrix(subsquareMatrix));
        int[] prod = {1,2,4,5};
        arrays.productArray(prod);
        List<String> s = new ArrayList<String>();
        s.add("aaaabbc");
        s.add("hdjnfafb");
        s.add("ccgdaab");
        System.out.println("The Banned Stuff");
        System.out.println(bs.findCommonLetters(s));
        int[] missingNum = {0,1,2,4};
        System.out.println(arrays.findSmallestMissing(missingNum, 0, 3));
        int[] occurences = {1,1,1,2,4,6,8};
        System.out.println(arrays.countOccurences(occurences, 1));
        int[] maxIndexDiff = {1,2,3,4,5,6};
        System.out.println(arrays.maxIndexDiff(maxIndexDiff));
        int[] kMax = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        arrays.printKMax(kMax, 3);
        int[] subset1 = {1,4,5,6,8};
        int[] subset2 = {4,5,8,9};
        System.out.println(arrays.isSubset(subset1, subset2));
        int[] repMissing = {1,1,2,4};
        arrays.missingandRepeated(repMissing);
        int[][] spiral = {{1,2,3,4},{5,6,7,8},{9,10,11,12}, {13,14,15,16}};
        arrays.spiralPrint(spiral);

        boolean[][] modifyMatrix = {{true,false,false},{false,false,false},{false,false,true}};
        arrays.modifyMatrix(modifyMatrix);

        int[] fixedPoint = {-10, -5, 0, 3, 7};
        System.out.println();
        System.out.println(arrays.fixedPoint(fixedPoint, 0, 4));
        int[] bitonic = {10,20,30,40};
        System.out.println(arrays.maxLengthBitonic(bitonic));
        arrays.generateRandomNumbers();

/*
        int[] nums = {1,2,3};
        List<List<Integer>> list = bs.computePowerSet(nums);
        for(List<Integer> top: list )
        {
            for(Integer i : top)
            {
                System.out.print(i + " ");
            }

            System.out.println();
        }
        /*TopCoder DP Stuff */

        /*
        TopCoder_DP tc_dp = new TopCoder_DP();
        System.out.println(tc_dp.getLength("01010111001"));
        int[] weight = {1,2,3};
        int[][] constraints = {{0,0,0}, {0,0,0},{0,0,0}};
        int[] order = tc_dp.stackWareHouseBoxes(weight, constraints);
        System.out.println("The Orders are");
        for(Integer i : order)
        {
            System.out.print(i + " ");
        }

*/

    }
}
