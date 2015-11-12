package google.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yingtan on 11/10/15.
 */
/*
* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*
* */
public class GenerateParatheses {

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        int maxLeft = n;
        int maxRight = n;

        return recurGenerateParenthesis(maxLeft, maxRight, "");
    }

    public List<String> recurGenerateParenthesis(int maxLeft, int maxRight, String str) {
        List<String> res = new ArrayList<>();

        if ((maxLeft == 0) && (maxRight == 0)) {
            res.add(str);
            return res;
        }
        if (maxLeft > 0) {
            String newLeftStr = str + "(";
            List<String> lefts = recurGenerateParenthesis(maxLeft-1, maxRight, newLeftStr);
            res.addAll(lefts);
        }
        if ((maxRight > 0) && (maxLeft < maxRight)) {
            String newRightStr = str + ")";
            List<String> rights = recurGenerateParenthesis(maxLeft, maxRight-1, newRightStr);
            res.addAll(rights);
        }
        return res;
    }

    // old solution
    public List<String> generateParenthesis_2(int n) {

        int countLeft = 1;
        int countRight = 0;
        int curCount = 1;


        List<String> res = new ArrayList<String>();
        String cur = "(";
        return recurGenerate(n, res, countLeft, countRight, cur);
    }

    public List<String> recurGenerate(int n, List<String> res, int countLeft, int countRight, String cur)
    {
        if((countLeft == n) && (countRight == n))
        {
            res.add(cur);
            return res;
        }

        if(countLeft > countRight)
        {
            String newcur = cur +")";

            int newcountRight = countRight + 1;
            res = recurGenerate(n, res, countLeft, newcountRight, newcur);

        }
        if(countLeft < n)
        {
            String newcur = cur + "(";

            int newcountLeft = countLeft + 1;
            res = recurGenerate(n, res, newcountLeft,countRight, newcur);
        }

        return res;

    }
}
