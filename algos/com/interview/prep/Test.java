package com.interview.prep;

/**
 * Created by vishwajan on 4/27/15.
 */
public class Test
{
    public static void main(String[] args)
    {
        System.out.println("The Banned Stuff");
        BannedStuff bs = new BannedStuff();
        int[] threeSumarr = {-8,0,1,2,3,4,8};
        System.out.println(bs.threeSum(threeSumarr));
        /*Geeks for Geeks Arrays */
        Geeks_Arrays arrays = new Geeks_Arrays();
        int[] checkSum = {1,5,3,11,8,4};
        System.out.println(arrays.checkSum(checkSum, 10));
        int[] majority = {1, 3, 3, 1, 2,3,3};
        System.out.println(arrays.majorityElement(majority));
        int[] xor = {1,2,1,2,1};
        System.out.println(arrays.oddOccuring(xor));
        int[] maxSum = {-1, -2, -3, -4};
        System.out.println(arrays.maxSum(maxSum));
        int[] missing  = {1,2,4};
        System.out.println(arrays.findMissingNumber(missing));

        /*TopCoder DP Stuff */
        TopCoder_DP tc_dp = new TopCoder_DP();
        System.out.println(tc_dp.getLength("0111001"));



    }
}
