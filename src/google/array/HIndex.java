package google.array;

import java.util.Arrays;

/**
 * Created by yingtan on 11/20/15.
 */
/*
* Given an array of citations (each citation is a non-negative integer) of a researcher,
* write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia:
"A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers
have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of
them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations
each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.
*
* */
public class HIndex {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        // candidate h must be of one of [1 - citations.length] because it is the number of N papers
        int len = citations.length;
        for (int i = 0 ; i < len; i ++) {
            int paperNum = len - i;
            int hValue = paperNum;
            if (citations[i] >= hValue) {
                // there are paperNum papers whose value >= citations[i] >= hValue

                // max value, i is smaller, hValue is larger
                return hValue;
            }
        }
        return 0;
    }
}
