package DFSBFS;

/**
 * Created by yingtan on 2/25/18.
 *
 * 690. Employee Importance
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

 For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

 Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.

 Example 1:
 Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 Output: 11
 Explanation:
 Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 */
import java.util.*;
public class EmployeeImportance {

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee em : employees) {
            map.put(em.id, em);
        }
        Employee root = map.get(id);
        return dfs(id, map);
    }
    public int dfs(int id, Map<Integer, Employee> employees) {
        int res = 0;
        if (employees.containsKey(id)) {
            Employee cur = employees.get(id);
            res = cur.importance;
            if (cur != null) {
                for (Integer child : cur.subordinates) {
                    res = res + dfs(child, employees);
                }
            }
        }
        return res;
    }
}

