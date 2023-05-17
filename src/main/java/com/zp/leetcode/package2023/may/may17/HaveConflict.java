package com.zp.leetcode.package2023.may.may17;

/**
 * @author zhengpeng
 * @date 2023/5/17 9:06 上午
 * 判断两个事件是否存在冲突
 **/
public class HaveConflict {

    public static void main(String[] args) {

        HaveConflict haveConflict = new HaveConflict();
        //System.out.println(haveConflict.haveConflict(new String[]{"01:15","02:00"},new String[]{"02:00","03:00"}));
        //System.out.println(haveConflict.haveConflict(new String[]{"01:00","02:00"},new String[]{"01:20","03:00"}));
        //System.out.println(haveConflict.haveConflict(new String[]{"10:00","11:00"},new String[]{"14:00","15:00"}));
        System.out.println(haveConflict.haveConflict(new String[]{"16:53","19:00"},new String[]{"10:33","18:15"}));


    }



    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }

    public boolean haveConflict1(String[] event1, String[] event2) {
        Event eventObj1 = new Event(event1[0],event1[1]);
        Event eventObj2 = new Event(event2[0],event2[1]);
        return eventObj1.compareConflict(eventObj2);
    }

    public static class Event{

        private String startTime;

        private String endTime;

        public Event(String startTime, String endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public boolean compareConflict(Event eventObj2) {
            String[] split1 = startTime.split(":");
            String[] split2 = endTime.split(":");

            Integer integer1 = Integer.valueOf(split1[0]);
            Integer integer2 = Integer.valueOf(split2[0]);

            String[] obj2Split1 = eventObj2.startTime.split(":");
            String[] obj2Split2 = eventObj2.endTime.split(":");

            Integer obj2Integer1 = Integer.valueOf(obj2Split1[0]);
            Integer obj2Integer2 = Integer.valueOf(obj2Split2[0]);

            if(integer1< obj2Integer1 && obj2Integer1 < integer2 ){
                return true;
            }else if(integer1.compareTo(obj2Integer1) == 0){
                Integer integer1_2 = Integer.valueOf(split1[1]);
                Integer obj2Integer1_2 = Integer.valueOf(obj2Split1[1]);
                if(integer1_2 <= obj2Integer1_2){
                    return true;
                }
            }else if(integer2.compareTo(obj2Integer1) == 0){
                Integer integer2_2 = Integer.valueOf(split2[1]);
                Integer obj2Integer2_1 = Integer.valueOf(obj2Split1[1]);
                if(integer2_2 <= obj2Integer2_1){
                    return true;
                }
            }else if(obj2Integer2.compareTo(integer2) ==0){
                Integer integer2_2 = Integer.valueOf(split2[1]);
                Integer obj2Integer2_2 = Integer.valueOf(obj2Split2[1]);
                if(integer2_2.compareTo(obj2Integer2_2) == 0){
                    return true;
                }
            } else if(obj2Integer1 < integer2 && integer2 < obj2Integer2){
                return true;
            }
            return false;
        }
    }


}
