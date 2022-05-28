package com.zp.leetcode.package_2022.may.may29;

/**
 * @author zhengpeng
 * @date 2022/5/27 10:27 上午
 * 最佳观光组合
 **/
public class MaxScoreSightseeingPair {

    /**
     * 最大观光组合,求区间和
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair(int[] values) {
        int minSize = Integer.MIN_VALUE;
        int sum = 0;
        int length = values.length;
        int pointer = 0;
        for (int i = 0; i < length; i++) {
            final int value = values[i];
            if(value >= i){
                sum += value;
                //最后一位
                if((i == length - 1) && (minSize == Integer.MIN_VALUE)){
                    return sum - i - pointer;
                }
            }else{
                int diff = i - pointer;
                minSize = Math.max((sum - diff) , minSize);
                pointer = i;
                sum = 0;
            }
        }
        return minSize;
    }

    /**
     * 最大观光组合，题目要求
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair2(int[] values) {
        int minSize = Integer.MIN_VALUE;
        int sum = 0;
        int length = values.length;
        //开始指针
        int startPointer = 0;
        for (int i = 1; i < length; i++) {
            final int value = values[i];
            int range = i - startPointer;
            if(value >= range && (sum <= (values[startPointer] + values[i]))){
                //startPointer 右移动
                for (int j = startPointer + 1; j < i; j++) {
                    if(values[j] >= values[startPointer]){
                        sum = sum - values[startPointer] + values[j];
                        startPointer = j;
                    }
                }
                sum = values[startPointer] + values[i];
                //最后一位
                if((i == length - 1) ){
                    final int i1 = sum + startPointer - i;
                    if(i1 > minSize){
                        return i1;
                    }
                }
            }else{
                int diff = startPointer - i + 1 ;
                final int i1 = sum + diff;
                if(i1 >= minSize){
                    minSize = i1;
                    startPointer = i -1;
                    i = i- 1;

                }
                sum = 0;
            }
        }
        return minSize;
    }

    public int maxScoreSightseeingPair3(int[] values) {
        int ans = 0, mx = values[0] + 0;
        for (int j = 1; j < values.length; ++j) {
            ans = Math.max(ans, mx + values[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, values[j] + j);
        }
        return ans;
    }


    /**
     *  diffRange 判断有问题
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair4(int[] values) {

        int sum = 0;
        int maxCount = Integer.MIN_VALUE;
        //区间最大值的下标
        int start = 0;
        int length = values.length;
        //当前区间的最大值
        int curMax = values[0];
        for (int i = 1; i < length; i++) {
            int diffRange = i - start;
            final int value = values[i];
            // 区间还可以扩展
            if(value >= diffRange){
                sum = values[start] + value + (start - i);
                //内部循环
                for(int j = start + 1;j < i;j++){
                    int curSum = values[j] + value + (j - i);
                    sum = Math.max(sum, curSum);
                }
                if(value >= curMax){
                    curMax = value;
                    //指向最大的索引
                    start = i;
                }
                maxCount = Math.max(maxCount,sum);
            //下一个区间
            }else{
                start = i - 1;
                curMax = values[i - 1];
                sum = 0;
                // 后退一位
                i = i - 1;
            }
        }
        return maxCount;
    }


    public static void main(String[] args) {

        //int[] array = new int[]{8,1,5,2,6,999};
        //int[] array = new int[]{8,1,5,2,6};
        //int[] array = new int[]{5,3,1};
        //int[] array = new int[]{2,2,2};
        //int[] array = new int[]{1,2};
        //int[] array = new int[]{1,2,2};
        //int[] array = new int[]{3,7,2,3};
        //int[] array = new int[]{4,7,5,8};
        //int[] array = new int[]{10,4,6,4,10};
        //int[] array = new int[]{7,8,8,10};
        //int[] array = new int[]{7,2,6,6,9,4,3};
        int[] array = new int[]{98,15,69,39,79,78,16,6,36,97};
        MaxScoreSightseeingPair maxScoreSightseeingPair = new MaxScoreSightseeingPair();
        //System.out.println(maxScoreSightseeingPair.maxScoreSightseeingPair2(array));
        System.out.println(maxScoreSightseeingPair.maxScoreSightseeingPair4(array));
        System.out.println(maxScoreSightseeingPair.maxScoreSightseeingPair3(array));
    }



}
