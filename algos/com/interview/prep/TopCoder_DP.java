package com.interview.prep;

/**
 * Created by vishwajan on 5/9/15.
 */


public class TopCoder_DP
{
    /*
    The following algorithm can be used to encode a sequence of characters s:

Find any palindrome of even length in s. A palindrome is a string that reads the same forward and backward. If there are no palindromes of even length, go to step 3.
Remove the last half of the selected palindrome from s. For example, if the palindrome is "0110", remove the "10". Go to step 1.
Print the remaining sequence of characters.
Note that the resulting sequence is not necessarily unique since there may be multiple palindromes to choose from in step 1.

Given a String s containing only the digits '0' and '1', return the length of the shortest possible string that can result from applying the above algorithm to s.


Definition

Class:	PalindromeEncoding
Method:	getLength
Parameters:	String
Returns:	int
Method signature:	int getLength(String s)
(be sure your method is public)


Constraints
-	s will contain between 1 and 50 characters, inclusive.
-	s will contain only the digits '0' and '1'.

Examples
0)

"0111001"
Returns: 2
First, take the last four digits and remove the "01" to get "01110". Then, select either of the "11"s and remove a "1" to get "0110". Finally, since the entire string is now a palindrome, you can remove the "10" to get "01".
1)

"0"
Returns: 1
There is no palindrome of even length in this string, so nothing is changed.
2)

"01010111100110101110000001011000101000010111000111"
Returns: 6

     */
    public int getLength(String s)
    {
        int res;

        int i, n;
        n = s.length();
        res = 1;
        for (i=1; i<n; i++)
        {
            if (s.charAt(i) != s.charAt(i - 1))
            {
                res++;
            }
            else if (res > 1)
            {
                break;
            }
        }


        return res;
    }
}
