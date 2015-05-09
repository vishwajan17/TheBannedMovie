package com.interview.prep;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by vishwajan on 5/9/15.
 */
public class Geeks_Arrays
{
    public boolean checkSum(int[] arr, int sum)
    {
        if(arr == null || arr.length == 0)
        {
            return true;
        }

        Map<Integer, Integer> checkMap = new HashMap<Integer,Integer>();
        for(int i=0; i<arr.length; i++)
        {
            if(checkMap.containsKey(arr[i]))
            {
                return true;
            }
            checkMap.put(sum-arr[i], arr[i]);
        }

        return false;
    }

    public int majorityElement(int[] arr)
    {
        if(arr == null || arr.length == 0)
        {
            return  Integer.MAX_VALUE;
        }

        int length = arr.length;
        int majorityCount = 1;
        int currElem = arr[0];
        for(int i=1; i<length; i++)
        {
            if(arr[i] == currElem)
            {
                majorityCount++;
            }

            else
            {
                majorityCount--;
            }

            if(majorityCount == 0)
            {
                currElem = arr[i];
                majorityCount = 1;
            }
        }

        if(isMajority(arr, currElem))
        {
            return currElem;
        }

        return Integer.MAX_VALUE;
    }

    private boolean isMajority(int[] arr, int candidate)
    {
        int length = arr.length;
        int count = 0;
        for(int i=0; i<length; i++)
        {
            if(arr[i] == candidate)
            {
                count++;
            }
        }

        return count  >= length/2;
    }

    public int oddOccuring(int[] arr)
    {
        if(arr == null || arr.length == 0)
        {
            return -1;
        }

        int xor = arr[0];
        for(int i=1; i<arr.length; ++i)
        {
            xor = xor ^ arr[i];
        }

        return xor;
    }

    public int maxSum(int[] arr)
    {
        if(arr == null || arr.length == 0)
        {
            return 0;
        }

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
        {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }

    public int findMissingNumber(int[] arr)
    {
        if(arr == null || arr.length == 0)
        {
            return 0;
        }

        int xor = arr[0];

        for(int i=1; i<arr.length; ++i)
        {
            xor = xor ^ arr[i];
        }

        for(int i=1; i<=arr.length+1; i++)
        {
            xor = xor ^ i;
        }

        return xor;
    }

    public int searchInSortedArray(int[] arr, int target)
    {
        if(arr == null || arr.length == 0)
        {
            return -1;
        }

        int pivot = getPivot(arr, 0, arr.length-1);
        if(pivot == -1)
        {
            return binarySearch(arr, 0, arr.length-1, target);
        }

        if(arr[pivot] == target)
        {
            return  pivot;
        }
        else if(arr[0] <= target)
        {
            return binarySearch(arr, 0, pivot, target);
        }

        return binarySearch(arr, pivot ,arr.length-1 , target);
    }

    public int binarySearch(int[] arr, int low, int high, int target)
    {
        if(low > high)
        {
            return -1;
        }

        int mid = low + high /2;
        if(arr[mid] == target)
        {
            return mid;
        }

        else if( arr[mid] > target)
        {
            return binarySearch(arr, low, mid-1,target);
        }

        else
        {
            return binarySearch(arr, mid+1, high, target);
        }
    }

    public int getPivot(int[] arr, int low, int high)
    {
        return -1;
    }


}
