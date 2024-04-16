package courses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Courses {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> alist = new HashMap<>();

    
        int[] order = new int[numCourses];

       
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            alist.putIfAbsent(prereq, new ArrayList<>());
            alist.get(prereq).add(course);
            order[course]++;
        }

        
        ArrayDeque<Integer> q = new ArrayDeque<>();

       
        for (int i = 0; i < order.length; i++) {
            if (order[i] == 0) {
                q.add(i);
            }
        }

        
        int count = 0;

       
        while (!q.isEmpty()) {
            int current = q.poll();
            count++;
            List<Integer> neighbors = alist.get(current);
            if (neighbors != null) {
                for (int i : neighbors) {
                    order[i]--;
                    if (order[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }

        
        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] aReq = {{1, 0}};
        int[][] bReq = {{1, 0}, {0, 1}};
        System.out.println(canFinish(2, aReq)); // true
        System.out.println(canFinish(2, bReq)); // false
    }
}