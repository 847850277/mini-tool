package com.zp.leetcode.package2022.august.august23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/8/23 5:02 下午
 * 找到所有数组中消失的数字
 * 根据题目特点，可以把数组中的元素与索引建立一一对应的关系。因为索引是确定的0到n-1,一个也不缺，而数组的元素不确定，少了哪个也不知道。
 * 既然两者是一一对应的关系，那么我们对数组中的每个元素对应的索引做个标记；
 * 然后再对索引进行一次遍历，那么不存的元素就不会对它对应的索引进行比较，由此可查找出这些不存在的元素。
 **/
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        int[] numbers = new int[]{4,3,2,7,8,2,3,1};
        //System.out.println(findDisappearedNumbers.findDisappearedNumbers(numbers));
        System.out.println(findDisappearedNumbers.findDisappearedNumbers1(numbers));
    }


    /**
     * 非O（n）时间复杂度时间
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int size = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>(size * 2);
        for (int i = 1; i <= size; i++) {
            map.put(i, i);
        }
        for (int num : nums) {
            if (!map.containsKey(num)) {
                continue;
            }
            map.remove(num);
        }
        return new ArrayList<Integer>(map.keySet());
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        //用来存放结果
        List<Integer> res = new ArrayList<>();
        //1. 遍历下数组的元素，对对应的索引位置的元素作标记
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int num = Math.abs(nums[i]);  //由于数组的元素有可能被*-1，所以取绝对值
            int index = num - 1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        // 寻找没有标记的索引位置
        for(int i = 0; i < len; i++){
            if(nums[i] > 0){
                int num = i + 1;  //将索引转化为对应的元素
                res.add(num);
            }
        }
        return res;
    }


}
