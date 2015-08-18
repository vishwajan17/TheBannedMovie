package com.interview.prep;
import java.util.*;
import com.sun.tools.javac.util.Pair;
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
        if(low > high)
        {
            return -1;
        }

        if(low == high)
        {
            return low;
        }

        int mid = (low + high)/2;
        if(mid > low && arr[mid] < arr[mid-1])
        {
            return mid-1;
        }

        if(mid < high && arr[mid] > arr[mid+1])
        {
            return mid;
        }

        if(arr[low] > arr[mid])
        {
            return getPivot(arr, low , mid-1);
        }

        else
        {
            return getPivot(arr, mid+1,high);
        }
    }

    public void merge(int[] arr1, int[] arr2, int l1)
    {
        int lastPointer = arr1.length-1;
        int secondPointer = arr2.length-1;

        while(l1 >=0 && secondPointer >=0)
        {
            if(arr1[l1] > arr2[secondPointer])
            {
                arr1[lastPointer] = arr1[l1];
                l1--;
                lastPointer--;
            }

            else
            {
                arr1[lastPointer] = arr2[secondPointer];
                secondPointer--;
                lastPointer--;
            }
        }

        while(secondPointer >= 0)
        {
            arr1[lastPointer] = arr2[secondPointer];
            secondPointer--;
            lastPointer--;
        }
    }

    public int medianSortedArrays(int[] arr1, int[] arr2)
    {
        int n = arr1.length;
        if(n == 1)
        {
            return (arr1[0] + arr2[0])/2;
        }

        if(n == 2)
        {
            int firstElem = Math.max(arr1[0], arr2[0]);
            int secondElem = Math.max(arr1[1], arr2[1]);
            return (firstElem + secondElem)/2;
        }

        int m1 = getMedian(arr1);
        int m2 = getMedian(arr2);

        if(m1 == m2)
        {
            return m1;
        }

        if(m1 < m2)
        {
            if(n%2 == 0)
            {
                medianSortedArrays(Arrays.copyOfRange(arr1,n/2-1,n-1), Arrays.copyOfRange(arr2, 0, n-n/2 +1));

            }

            else
            {
                medianSortedArrays(Arrays.copyOfRange(arr1,n/2-1,n), Arrays.copyOfRange(arr2,0,n-n/2));
            }
        }

        else
        {
            if(n%2 == 0)
            {
                medianSortedArrays(Arrays.copyOfRange(arr2,n/2-1,n-1), Arrays.copyOfRange(arr1, 0, n-n/2 +1));

            }

            else
            {
                medianSortedArrays(Arrays.copyOfRange(arr2,n/2-1,n), Arrays.copyOfRange(arr1,0,n-n/2));

            }
        }

        return -1;
    }

    private int getMedian(int[] arr)
    {
        int length = arr.length;
        if(length % 2 == 0)
        {
            return (arr[length/2] + arr[length-1/2] )/2;
        }

        return arr[length/2];
    }

    public void reverseArray(int[] arr, int start, int end)
    {
        if(arr == null || arr.length == 0)
        {
            return;
        }

        while(start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]= temp;
            end--;
            start++;
        }
    }

    public void rotateArray(int[] arr, int d)
    {
        reverseArray(arr, 0 , d-1);
        reverseArray(arr, d, arr.length-1);
        reverseArray(arr, 0 , arr.length-1);
    }

    public void juggleRotateArray(int[] arr, int rotateSize)
    {
        int length = arr.length;
        for(int i=0; i<gcd(length, rotateSize); i++)
        {
            int j = i;
            int k = 0;
            int temp = arr[i];
            while(true)
            {
                k = j + rotateSize;
                if(k >= length)
                {
                    k = k - length;
                }

                if(k == i)
                {
                    break;
                }
                arr[j] = arr[k];
                j = k;
            }

            arr[j] = temp;
        }
    }

    public int gcd(int num, int rotateSize)
    {
        if(rotateSize == 0)
        {
            return num;
        }

        else
        {
            return gcd(rotateSize, num % rotateSize);
        }
    }

    public int findMax(int[] arr)
    {
        int length = arr.length;
        int incl = arr[0];
        int excl = 0;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<length; ++i)
        {
            max = Math.max(incl, excl);
            incl = excl + arr[i];
            excl = max;

        }

        return incl > excl? incl : excl;
    }

    public void printLeaders(int[] arr)
    {
        int length = arr.length;
        int max_right = arr[arr.length-1];

        for(int i= length-2; i>=0; i--)
        {
            if(arr[i] > max_right)
            {
                System.out.print(arr[i] + " ");
                max_right = arr[i];
            }
        }
    }

    public int SortElementsByFrequency(int[] arr)
    {
        int length = arr.length;
        Map<Integer,Integer> freqMap = new HashMap<Integer, Integer>();
        for(int i=0; i<length; i++)
        {
            int count = 0;
            if(freqMap.containsKey(arr[i]))
            {
                count = freqMap.get(arr[i]);
            }

            freqMap.put(arr[i], count+1);
        }

        Iterator<Integer> freqMapIterator = freqMap.keySet().iterator();
        TreeMap<Integer,Integer> sortedFreqMap = new TreeMap<Integer, Integer>();
        while(freqMapIterator.hasNext())
        {
            int key = freqMapIterator.next();
            sortedFreqMap.put(freqMap.get(key), key);
        }

        freqMapIterator = sortedFreqMap.keySet().iterator();
        int index = 0;
        while (freqMapIterator.hasNext())
        {
            int key = freqMapIterator.next();
            int value = sortedFreqMap.get(key);
            while(key > 0)
            {
                arr[index] = value;
                key--;
            }
        }
        return 0;
    }

    public int countInversions(int[] arr)
    {
        int length = arr.length;
        int[] temp = new int[length];
        return countInversionsHelper(arr, 0, arr.length-1, temp);
    }

    public int countInversionsHelper(int[] arr, int low, int high, int[] temp)
    {
        int invCount = 0;
        if(high > low)
        {
            int mid = (high + low)/2;
            invCount = countInversionsHelper(arr, low, mid, temp);
            invCount += countInversionsHelper(arr, mid+1, high, temp);
            invCount += merge(arr, low, mid, high, temp);
        }

        return invCount;
    }

    public int merge(int[] arr, int low, int mid, int high, int[] temp)
    {
        int i = low;
        int j = mid;
        int k = low;
        int inv_count = 0;

        while((i <= mid-1) && (j <= high))
        {
            if(arr[i] <= arr[j])
            {
                temp[k++] = arr[i++];
            }

            else
            {
                temp[k++] = arr[j++];
                inv_count += mid - i;
            }
        }

        while (i <= mid - 1)
        {
            temp[k++] = arr[i++];
        }

        while (j <= high)
        {
            temp[k++] = arr[j++];
        }

        for(int index=low; index <=high; index++)
        {
            arr[index] = temp[index];
        }

        return inv_count;
    }

    public void minAbsPair(int[] arr)
    {
        int length = arr.length;
        Arrays.sort(arr);
        int left = 0;
        int right = length-1;
        int minSum = Integer.MAX_VALUE;
        while(left < right)
        {
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < minSum)
            {
                minSum = Math.abs(sum);
            }

            if(sum > 0)
            {
                right--;
            }

            else
            {
                left++;
            }
        }

        System.out.println(minSum);
    }

    public void twoSmallElements(int[] arr)
    {
        int length = arr.length;
        int first = arr[0];
        int second = Integer.MAX_VALUE;
        for(int i=1; i<length; i++)
        {
            if(arr[i] < first)
            {
                second = first;
                first = arr[i];
            }
        }

        System.out.println(first + " " + second);
    }

    public boolean majorityElementInSorted(int[] arr)
    {
        return false;
    }

    public void segregate01(int[] arr)
    {
        int length = arr.length;
        int i = 0;
        while(i < length)
        {
            while(arr[i] == 0 && i < length)
            {
                i++;
            }
            while(length >=0 && arr[length-1]  == 1)
            {
                length--;
            }

            if(i < length)
            {
                int temp = arr[i];
                arr[i] = arr[length - 1];
                arr[length - 1] = temp;
            }
            i++;
            length--;
        }
    }

    //Find maxSizeSubSquareMatrix with all 1s
    public int maxSizeSubSquareMatrix(int[][] matrix)
    {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++)
        {
            dp[i][0] = matrix[i][0];
        }

        for(int i=0; i < matrix[0].length; i++)
        {
            dp[0][i] = matrix[0][i];
        }

        for(int i=1; i<matrix.length; i++)
        {
            for(int j=1; j<matrix[0].length; j++)
            {
                if(matrix[i][j] == 1)
                {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j])) + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }

    public int floor(int[] arr, int low, int high, int x)
    {
        if(low < high)
        {
            int mid = (low + high)/2;
            if(arr[mid] == x)
            {
                return mid;
            }

            if(mid == high ||(arr[mid] > x && arr[mid+1] < x))
            {
                return mid;
            }

            if(arr[mid] < x)
            {
                return floor(arr, mid+1, high, x);
            }

            else
            {
                return floor(arr, low, mid-1, x);
            }
        }
        return -1;
    }

    public int ceil(int[] arr, int x)
    {
        return 0;
    }

    public void union(List<Integer> list1, List<Integer> list2)
    {
        Iterator<Integer> list1Iterator = list1.iterator();
        Iterator<Integer> list2Iterator = list2.iterator();
        List<Integer> result = new LinkedList<Integer>();

        Integer list1Elem = list1Iterator.hasNext()?list1Iterator.next():null;
        Integer list2Elem = list2Iterator.hasNext()?list2Iterator.next():null;

        while(list1Elem != null || list2Elem != null)
        {
            if(list1Elem != null && list2Elem != null)
            {
                if(list1Elem > list2Elem)
                {
                    result.add(list2Elem);
                    list2Elem = list2Iterator.hasNext()?list2Iterator.next():null;
                }

                else
                {
                    result.add(list1Elem);
                    list1Elem = list1Iterator.hasNext()?list1Iterator.next():null;
                }
            }

            else if(list1Elem != null)
            {
                result.add(list1Elem);
                list1Elem = list1Iterator.hasNext()?list1Iterator.next():null;
            }

            else
            {
                result.add(list2Elem);
                list2Elem = list2Iterator.hasNext()?list2Iterator.next():null;
            }
        }

    }

    public List<Integer> intersection(List<Integer> list1, List<Integer> list2)
    {
        Iterator<Integer> list1Iterator = list1.iterator();
        Iterator<Integer> list2Iterator = list2.iterator();
        List<Integer> result = new LinkedList<Integer>();

        Integer list1Elem = list1Iterator.hasNext()?list1Iterator.next():null;
        Integer list2Elem = list2Iterator.hasNext()?list2Iterator.next():null;

        while(list1Elem != null && list2Elem != null)
        {

            if (list1Elem > list2Elem)
            {
                list2Elem = list2Iterator.hasNext() ? list2Iterator.next() : null;
            }
            else if (list2Elem > list1Elem)
            {
                list1Elem = list1Iterator.hasNext() ? list1Iterator.next() : null;
            }
            else
            {
                result.add(list1Elem);
                list1Elem = list1Iterator.hasNext() ? list1Iterator.next() : null;
                list2Elem = list2Iterator.hasNext() ? list2Iterator.next() : null;
            }

        }

        return result;
    }

    public void productArray(int[] arr)
    {
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] prod = new int[length];
        left[0] = 1;
        right[length-1] = 1;
        for(int i=1; i<length; i++)
        {
            left[i] = left[i-1] * arr[i-1];
        }

        for(int i = length-2; i>=0; i--)
        {
            right[i] = right[i+1] * arr[i+1];
        }

        for(int i=0; i<length; i++)
        {
            prod[i] = left[i] * right[i];
            System.out.print(prod[i] + " ");
        }
    }
/*
    public void segregateEvenOdd(int[] arr)
    {
        int length = arr.length;
        int i = 0;

        while(i < length)
        {
            while(arr[i] %2 == 0 && i < length)
            {
                i++;
            }

            while(arr[i] %2 == 1 && )
        }
    }
    */

    public int findSmallestMissing(int[] arr, int low, int high)
    {
        if(low > high)
        {
            return -1;
        }

        int mid = (low + high)/2;
        if(arr[low] != low)
        {
            return low;
        }

        if(arr[mid] > mid)
        {
            return findSmallestMissing(arr, low, mid);
        }

        else
        {
            return findSmallestMissing(arr, mid+1, high);
        }
    }

    public int countOccurences(int[] arr, int num)
    {
        int first = firstOccurence(arr, 0, arr.length-1, num);
        int last = lastOccurence(arr, 0, arr.length-1,  num);

        return last - first + 1;
    }

    public int firstOccurence(int[] arr, int low, int high, int num)
    {
        if(low > high)
        {
            return -1;
        }

        int mid = (low+high)/2;

        if(mid == 0 || (arr[mid-1] < num && arr[mid] == num))
        {
            return mid;
        }

        else if(arr[mid] >= num)
        {
            return firstOccurence(arr, low, mid-1, num);
        }

        else
        {
            return firstOccurence(arr, mid+1, high, num);
        }
    }

    public int lastOccurence(int[] arr, int low, int high, int num)
    {
        if(low > high)
        {
            return -1;
        }

        int mid = (low+high)/2;
        if(mid == arr.length-1 || (arr[mid+1] > num && arr[mid] == num ))
        {
            return mid;
        }

        else if(arr[mid] > num)
        {
            return lastOccurence(arr, low, mid-1, num);
        }

        else
        {
            return lastOccurence(arr, mid+1, high, num);
        }
    }

    public int maxIndexDiff(int[] arr)
    {
        int length = arr.length;
        int leftMin[] = new int[length];
        int rightMax[] = new int[length];
        leftMin[0] = arr[0];
        rightMax[length-1] = arr[length-1];
        for(int i=1; i<length; i++)
        {
            leftMin[i] = Math.min(leftMin[i], arr[i]);
        }

        for(int i=length-2; i>=0; i--)
        {
            rightMax[i] = Math.max(arr[i], rightMax[i+1]);
        }

        int maxDiff = Integer.MIN_VALUE;

        int i =  0, j=0;
        while(i<length && j<length)
        {
            if(leftMin[i] < rightMax[j])
            {
                maxDiff = Math.max(maxDiff, j-i);
                j++;
            }

            else
            {
                i++;
            }
        }

        return  maxDiff;
    }

    public void printKMax(int[] arr, int window)
    {
        int length = arr.length;
        int i = 0;
        Deque<Integer> integerDeque = new LinkedList<Integer>();
        for(; i < window; i++)
        {
            while(!(integerDeque.isEmpty()) && arr[i] >= arr[integerDeque.getLast()])
            {
                integerDeque.removeLast();
            }

            integerDeque.addLast(i);
        }
        System.out.println();
        for(; i < length; i++)
        {
            System.out.print(arr[integerDeque.getFirst()] + " ");
            while(!(integerDeque.isEmpty()) && integerDeque.getFirst() <= i-window)
            {
                integerDeque.removeFirst();
            }

            while(!integerDeque.isEmpty() && arr[integerDeque.getLast()] <= arr[i])
            {
                integerDeque.removeLast();
            }

            integerDeque.addLast(i);
        }

        System.out.print(arr[integerDeque.getFirst()]);
    }

    public boolean isSubset(int[] arr1, int[] arr2)
    {
        Set<Integer> hash = new HashSet<Integer>();
        for(Integer i : arr1)
        {
            hash.add(i);
        }

        for(Integer i : arr2)
        {
            if(!hash.contains(i))
            {
                return false;
            }
        }

        return true;
    }

    public int minDistance(int[] arr, int num1, int num2)
    {
        Map<Integer, List<Integer>> indexMap = new HashMap<Integer, List<Integer>>();
        int length = arr.length;
        for(int i=0; i<length; i++)
        {
            if(indexMap.containsKey(arr[i]))
            {
                indexMap.get(arr[i]).add(i);
            }
            else
            {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                indexMap.put(arr[i], list);
            }
        }

        List<Integer> list1 = indexMap.get(num1);
        List<Integer> list2 = indexMap.get(num2);

        int length1 = list1.size();
        int length2 = list2.size();
        int i=0,j=0;
        int minDist = Integer.MAX_VALUE;
        while(i<length1 && j < length2)
        {
            minDist = Math.min(minDist, Math.abs(list2.get(j)-list1.get(i)));

            if(i > j)
            {
                j++;
            }

            else
            {
                i++;
            }
        }

        return minDist;
    }

    public void missingandRepeated(int[] arr)
    {
        int length = arr.length;
        int xor = arr[0];
        for(int i=1; i<length; i++)
        {
            xor ^= arr[i];
        }

        for(int i=1; i<=length; i++)
        {
            xor ^= i;
        }

        int setbit = xor & xor-1;

        int x =1, y=1;

        for(int i=0; i<length; i++)
        {
            if((setbit & arr[i]) == 1)
            {
                x ^= arr[i];
            }

            else
            {
                y ^= arr[i];
            }
        }

        for(int i=1; i<=length; i++)
        {
            if((setbit & i) == 1)
            {
                x ^= i;
            }

            else
            {
                y ^= i;
            }
        }

        System.out.println(x + " " + y);
    }

    public void spiralPrint(int[][] arr)
    {
        int rowLength = arr.length;
        int colLength = arr[0].length;

        int k = 0;
        int l = 0;

        int m = rowLength;
        int n = colLength;

        while(k < m && l <n)
        {
            for(int i=l; i<n; i++)
            {
                System.out.print(arr[k][i]+ " ");
            }
            k++;

            for(int i=k; i<m; i++)
            {
                System.out.print(arr[i][n-1] + " ");
            }
            n--;

            if(k < m)
            {
                for (int i = n - 1; i >= l; i--)
                {
                    System.out.print(arr[m - 1][i] + " ");
                }
                m--;
            }

            if(l < n)
            {
                for (int i = m - 1; i >= k; i--)
                {
                    System.out.print(arr[i][l] + " ");
                }
                l++;
            }
        }
    }

    public void modifyMatrix(boolean[][] matrix)
    {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        boolean row[] = new boolean[rowLength];
        boolean col[] = new boolean[colLength];

        for(int i=0; i<rowLength; i++)
        {
            for(int j=0; j<colLength; j++)
            {
                if(matrix[i][j])
                {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i=0; i<rowLength; i++)
        {
            for(int j=0; j<colLength; j++)
            {
                if(row[i] || col[j])
                {
                    matrix[i][j] = true;
                }
            }
        }
    }

    public int fixedPoint(int[] arr, int low, int high)
    {
        if(low > high)
        {
            return -1;
        }

        int mid = (low + high)/2;

        if(arr[mid] == mid)
        {
            return mid;
        }

        if(arr[mid] > mid)
        {
            return fixedPoint(arr, low, mid-1);
        }

        else
        {
            return fixedPoint(arr, mid+1, high);
        }
    }

    public int maxLengthBitonic(int[] arr)
    {
        int length = arr.length;
        int[] inc = new int[length];
        int[] dec = new int[length];

        inc[0] = 1;
        for(int i=1; i<length; i++)
        {
            if(arr[i] > arr[i-1])
            {
                inc[i] = inc[i-1] + 1;
            }

            else
            {
                inc[i] = 1;
            }
        }

        dec[length-1] = 1;

        for(int i=length-2; i>=0; i--)
        {
            if(arr[i] < arr[i+1])
            {
                dec[i] = dec[i+1] + 1;
            }

            else
            {
                dec[i] = 1;
            }
        }

        int maxLength = inc[0] + dec[0] - 1;

        for(int i=1; i<length; i++)
        {
            maxLength = Math.max(maxLength, inc[i] + dec[i]-1);
        }

        return maxLength;
    }

    public int maxElement(int[] arr, int low, int high)
    {
        if(low > high)
        {
            return -1;
        }

        if(low +1 == high)
        {
            return arr[low] > arr[high] ? arr[low] : arr[high];
        }

        int mid = (low+high)/2;
        return 0;

    }

    public void generateRandomNumbers()
    {
        Random rb = new Random();
        for(int i=0; i<10; i++)
        {
            System.out.print(rb.nextInt(10) + " ");
        }
    }
}
