package stack;

/**
 * Created by yingtan on 1/20/18.
 *
 * 71. Simplify Path
 DescriptionHintsSubmissionsDiscussSolution
 DiscussPick One
 Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 click to show corner cases.
 */
import java.util.*;
public class SimplyfyPath {

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        Stack<String> stack = new Stack<>();
        //stack.push("/");
        String[] parts = path.split("/");
        for (String part : parts) {
            if (part.length() == 0) continue; // /home//foo/
            if (part.equals(".")) continue;
            if (part.equals("..")) {
                // important !!!! should firstly check is stack.isEmpty()
                if (! stack.isEmpty()) stack.pop();
            }
            else {
                stack.push(part);
            }
        }
        String res = "";
        if (! stack.isEmpty()) {
            res = stack.pop();
        }
        while(! stack.isEmpty()) {
            res = stack.pop() + "/" + res;
        }
        res = "/" + res;
        return res;
    }
}
