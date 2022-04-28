package com.zp.leetcode.package_2022.april.april0428;

/**
 * @author zhengpeng
 * @date 2022-04-28 08:57
 **/
public class MajorityElement {



    /**
     * 分治法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        return majorityElementRec(nums,0,nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {

        if(lo == hi){
            return nums[lo];
        }
        //分
        int mid = (hi - lo) / 2 + lo;
        //治
        int left = majorityElementRec(nums,lo,mid);
        int right = majorityElementRec(nums,mid + 1,hi);

        if( left == right){
            return left;
        }
        //合并
        int leftCount = countInRange(nums,left,lo,hi);
        int rightCount = countInRange(nums,right,lo,hi);
        return leftCount > rightCount ? left : right;

    }

    /**
     * @param nums
     * @param num
     * @param lo
     * @param hi
     * @return
     */
    private int countInRange(int[] nums, int num, int lo, int hi) {

        int count = 0;
        for (int i = lo; i <= hi; i++){
            if(num == nums[i]){
                count++;
            }
        }
        return count;
    }


//    /**
//     * 主要元素
//     * @param nums
//     * @return
//     */
//    public int majorityElement(int[] nums) {
//        int maxSizeCount = Integer.MIN_VALUE;
//        Map<Integer, Integer> keyCounterMap = new HashMap<>(nums.length / 2);
//        Map<Integer, Integer> maxSizeMap = new HashMap<>(nums.length / 2);
//        for (int num : nums) {
//            //先放计数器
//            keyCounterMap.put(num, keyCounterMap.getOrDefault(num,0) + 1);
//            //maxSizeCount = Math.max(maxSizeCount,keyCounterMap.get(num));
//            if(maxSizeCount < keyCounterMap.get(num)){
//                maxSizeCount = keyCounterMap.get(num);
//                maxSizeMap.put(maxSizeCount,num);
//            }
//        }
//        return maxSizeMap.get(maxSizeCount);
//    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,1};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(array));
    }
}
