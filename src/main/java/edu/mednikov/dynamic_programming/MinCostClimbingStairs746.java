package edu.mednikov.dynamic_programming;

public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] accCost = new int[cost.length + 1];
        accCost[0] = 0;
        accCost[1] = cost[0];
        accCost[2] = Math.min(cost[0], cost[1]);
        accCost[3] = cost[1];
        for (int i = 4; i < accCost.length; i++) {
            accCost[i] = accCost[i-1] + cost[i-1];
        }
        for (int i = 2; i < cost.length; i++) {
            accCost[i+1] = Math.min(accCost[i+1], accCost[i] + cost[i]);
            if (i < cost.length - 1) {
                accCost[i + 2] = Math.min(accCost[i + 2], accCost[i] + cost[i]);
            }
        }
        return accCost[accCost.length - 1];
    }

    private int minCostClimbingStairsLikeFibbonachi(int[] cost) {
        int stepsLeft = cost.length;
        int [] stepCost = new int [cost.length+1];
        stepCost[0] = cost[0];
        stepCost[1] = cost[1];
        for(int i=2;i<=cost.length;i++)
        {
            stepCost[i] = Math.min(stepCost[i-1],stepCost[i-2]);
            if(i<cost.length)
                stepCost[i]+= cost[i];
        }
        return stepCost[cost.length];
    }
}
