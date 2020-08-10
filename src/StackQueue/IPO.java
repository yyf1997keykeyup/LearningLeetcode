package StackQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * From: https://leetcode.com/problems/ipo/
 * 502. IPO (Hard)
 */
public class IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        class Project {
            final public int profit;
            final public int capital;
            public Project(int p, int c) {
                this.profit = p;
                this.capital = c;
            }
        }
        Project[] projects = new Project[Profits.length];
        for (int i=0; i<projects.length; i++) {
            projects[i] = new Project(Profits[i], Capital[i]);
        }
        Arrays.sort(projects, (p1, p2) -> p1.capital - p2.capital);
        PriorityQueue<Project> maxHeap = new PriorityQueue<>((p1, p2) -> p2.profit - p1.profit);
        int currCapital = W;
        int i = 0;
        while (k != 0) {
            while (i < projects.length && projects[i].capital <= currCapital) {
                maxHeap.add(projects[i]);
                i++;
            }
            if (maxHeap.size() != 0) {
                Project selectedProj = maxHeap.poll();
                currCapital += selectedProj.profit;
            }
            k--;
        }
        return currCapital;
    }
}
