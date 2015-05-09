package com.interview.prep;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by vishwajan on 4/27/15.
 */
public class BannedStuff
{
    public boolean threeSum(int[] arr)
    {
        int length = arr.length;
        for(int i=0; i<length-3; ++i)
        {
            int middle = i+1;
            int last = length -1;

            //Keep i constant and increment middle / decrement last
            //depending on whether sum is less than 0 or greater than 0;
            while(middle < last)
            {
                int sum = arr[i] + arr[middle] + arr[last];
                if(sum == 0)
                {
                    return true;
                }

                else if (sum > 0)
                {
                    last--;
                }

                else
                {
                    middle++;
                }
            }
        }

        return false;
    }

    public int balancedPartition(int[] arr, int sum)
    {
        int length = arr.length;
        boolean [][] tabulation = new boolean[sum+1][length+1];

        //You can make sum 0 with any subset because you always have empty set.
        for(int i=0; i<=length; i++)
        {
            tabulation[0][i] = true;
        }

        //You can never make a sum greater than 0 with an empty Set.

        for(int i =0; i<=sum; i++)
        {
            tabulation[i][0] = false;
        }

        for(int i=1; i<=sum; i++)
        {
            for(int j=1; j<=length; j++)
            {

            }
        }

        return 0;
    }


}
