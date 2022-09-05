package com.zp.leetcode.package2022.may.may23;

/**
 * @author zhengpeng
 * @date 2022/5/22 9:49 下午
 **/
public class FirstBadVersion  extends VersionControl{

    /**
     * 第一个错误的版本
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {

        if(n == 1 && isBadVersion(n)){
            return n;
        }
        int right = n;
        int left = n / 2;
        while(left != right){
            System.out.println("left:" + left + ",right:" + right);
            if(isBadVersion(left)){
                right = left;
                left = left / 2;
            }else{
                //解决两个int相加超过了最大的限制数
                final long sum = (long) left + (long) right + 1L;
                left = (int) (sum / 2);
            }
        }
        return  left;
    }


    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();

        //System.out.println(firstBadVersion.firstBadVersion(100));
        System.out.println(firstBadVersion.firstBadVersion(2126753390));
    }

}

class VersionControl{

    /**
     * 是否错误的版本
     * @param version
     * @return
     */
    boolean isBadVersion(int version){

        if(version >= 1702766719){
            return true;
        }
        return false;
    };
}
