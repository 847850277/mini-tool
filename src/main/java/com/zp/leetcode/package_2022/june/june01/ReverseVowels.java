package com.zp.leetcode.package_2022.june.june01;

/**
 * @author zhengpeng
 * @date 2022/5/31 4:37 下午
 * 反转元因字母
 **/
public class ReverseVowels {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean leftFlag = false;
        boolean rightFlag = false;
        char[] array = new char[s.length()];
        while (left != right && left < right) {
            //交换
            if(leftFlag && rightFlag){
                final char c = s.charAt(left);
                final char c1 = s.charAt(right);
                //sb.insert(left,c1);
                //sb.insert(right,c);
                array[left] = c1;
                array[right] = c;
                left++;
                right--;
                leftFlag = false;
                rightFlag = false;
            }else if(!leftFlag){
                final char c = s.charAt(left);
                if(!isVowel(c)){
                    //sb.insert(left,c);
                    array[left] = c;
                    left++;
                }else if(isVowel(c)){
                    leftFlag = true;
                }
            }else if(!rightFlag){
                final char c = s.charAt(right);
                if(!isVowel(c)){
                    //sb.insert(right,c);
                    array[right] = c;
                    right--;
                }else if(isVowel(c)){
                    rightFlag = true;
                }

            }
        }
        if(left == right){
            array[left] = s.charAt(left);
        }


        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(c);
        }
        return sb.toString();
    }

    public boolean isVowel(Character c){
        char d = String.valueOf(c).toLowerCase().charAt(0);
        if('a' == d || 'e' == d || 'i' == d || 'o' == d || 'u' == d){
            return true;
        }
        return false;

    }



    public static void main(String[] args) {

        ReverseVowels reverseVowels = new ReverseVowels();
        //System.out.println(reverseVowels.isVowel('A'));
        //System.out.println(reverseVowels.isVowel('a'));
        //System.out.println(reverseVowels.reverseVowels("hello"));
        System.out.println(reverseVowels.reverseVowels("ai"));
    }
}
