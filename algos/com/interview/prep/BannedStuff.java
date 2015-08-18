package com.interview.prep;
import java.util.*;

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

    public int minSequenceGreaterThanSum(int[] arr, int sum)
    {
        int length = arr.length;
        int begin = 0;
        int end = 1;
        int minDistance = Integer.MAX_VALUE;
        int curr_sum = arr[begin];
        while(begin < end && end < length)
        {

            if(curr_sum < sum)
            {
                curr_sum+= arr[end];
                end++;
            }

            else
            {
                minDistance = Math.min(minDistance, end - begin);
                curr_sum-= arr[begin];
                begin++;
            }

        }

        while(begin < end)
        {
            if(curr_sum > sum)
            {
                minDistance  = Math.min(minDistance, end - begin);
            }
            curr_sum-= arr[begin];
            begin++;
        }

        return minDistance;
    }

    public List<List<Integer>> computePowerSet(int[] nums)
    {
        if(nums.length == 0)
        {
            return null;
        }

        return powerSetHelper(nums, 0);
    }

    public List<List<Integer>> powerSetHelper(int[] nums, int index)
    {
        List<List<Integer>> subsets;
        if(index == nums.length)
        {
            subsets = new ArrayList<List<Integer>>();
            subsets.add(new ArrayList<Integer>());
        }

        else
        {
            subsets = powerSetHelper(nums, index+1);
            int elem = nums[index];
            List<List<Integer>> additionalSubsets = new ArrayList<List<Integer> >();
            for(List<Integer> subset: subsets)
            {
                List<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(subset);
                newSubset.add(elem);
                additionalSubsets.add(newSubset);
            }

            subsets.addAll(additionalSubsets);
        }

        return subsets;
    }

    public Integer findCommonLetters(List<String> input)
    {
        if(input == null)
        {
            return 0;
        }

        Map<Character, Integer> characterCount = new HashMap<Character, Integer>();
        Set<Character> set = new HashSet<Character>();

        for(String s : input)
        {
            int length = s.length();
            for(int i=0; i<length; i++)
            {
                set.add(s.charAt(i));
            }

            Iterator<Character> iterator = set.iterator();
            while(iterator.hasNext())
            {
                Character c = iterator.next();
                int count = 0;
                if(characterCount.containsKey(c))
                {
                    count = characterCount.get(c);
                }

                characterCount.put(c, count+1);
            }

            set.clear();
        }

        Iterator<Character> countIterator = characterCount.keySet().iterator();
        int count = 0;
        while (countIterator.hasNext())
        {
            Character c = countIterator.next();
            if(characterCount.get(c) == input.size())
            {
                count++;
            }
        }

        return count;
    }

    public int knapsack(int W, int wt[], int val[])
    {
        int length = wt.length;
        int tabulation[][] = new int[length+1][W+1];

        for (int i = 0; i <= length; i++)
        {
            for (int w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                {
                    tabulation[i][w] = 0;
                }
                else if (wt[i-1] <= w)
                {
                    tabulation[i][w] = Math.max(val[i - 1] + tabulation[i - 1][w - wt[i - 1]], tabulation[i - 1][w]);
                }
                else
                {
                    tabulation[i][w] = tabulation[i - 1][w];
                }
            }
        }

        return tabulation[length][W];
    }

    public int maxThreats(int[] arr)
    {
        int length = arr.length;
        int threats = 0;
        boolean[] visited = new boolean[length];
        for(int i=0; i<length; i++)
        {
            for(int j=i+1; j<length; j++)
            {
                if((Math.abs(arr[j] - arr[i])) == (j-i) ||
                        (arr[j] == arr[i]))
                {
                    if(!visited[j])
                    {
                        if(!visited[i])
                        {
                            threats++;
                            visited[i] = true;
                        }
                        visited[j] = true;
                    }
                }
            }
        }
        return threats;
    }

    public int longestChain(String[] words)
    {

        Arrays.sort(words, new Comparator<String>()
        {
            @Override
            public int compare(String s, String t1)
            {
                return t1.length()-s.length();
            }
        });

        Set<String> dict = new HashSet<String>();
        for(String s:words)
        {
            dict.add(s);
        }
        Queue<String> wordQueue = new LinkedList<String>();
        Queue<Integer> sizeQueue  = new LinkedList<Integer>();
        wordQueue.add(words[0]);
        sizeQueue.add(1);

        String finalString = words[words.length-1];
        int longest = Integer.MIN_VALUE;
        while(!wordQueue.isEmpty())
        {
            String word = wordQueue.remove();
            int size = sizeQueue.remove();

            int length = word.length();

            for(int i=0; i<length; i++)
            {
                String newWord = word.substring(0,i) + word.substring(i+1,length);

                if(dict.contains(newWord))
                {

                    size = size + 1;
                    wordQueue.add(newWord);
                    sizeQueue.add(size);
                    dict.remove(newWord);
                    System.out.println(newWord + " " + size);

                }

                longest  = Math.max(longest, size);
            }
        }




        return longest;
    }
}
