package com.zp.renewal.calculator;

import cn.hutool.core.date.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022-04-01 11:35
 * 续报计算器测试类
 **/
public class Calculator {

    private static Student studentInfo;
    private static List<TermPlan> termPlanList;
    private static List<SchoolUnitePrice> schoolUnitePrices;
    private static List<DiscountRate> discountRates;

    /**
     * 初始化
     */
    static {
        //初始化学员
        studentInfo = Student.builder().currentRemainLesson(32).schoolId("123").studentId("001").studentNumber("S001").levelId("s1").build();
        //初始化学期计划
        termPlanList = new ArrayList<>();
        //学期计划一
        termPlanList.add(TermPlan.builder()
                .termYear(2022)
                .startDate(DateUtil.parseDate("2022-03-01"))
                .endDate(DateUtil.parseDate("2022-03-31"))
                .hoursNumber(10)
                .levelId("s1")
                .build());
        //学期计划二
        termPlanList.add(TermPlan.builder()
                .termYear(2022)
                .startDate(DateUtil.parseDate("2022-04-01"))
                .endDate(DateUtil.parseDate("2022-06-31"))
                .hoursNumber(22)
                .levelId("s1")
                .build());
        //学期计划三
        termPlanList.add(TermPlan.builder()
                .termYear(2022)
                .startDate(DateUtil.parseDate("2022-07-04"))
                .endDate(DateUtil.parseDate("2022-08-31"))
                .hoursNumber(19)
                .levelId("s1")
                .build());

        schoolUnitePrices = new ArrayList<>();
        //初始化校区单价
        schoolUnitePrices.add(SchoolUnitePrice.builder()
                .schoolId("123")
                .uniPrice(new BigDecimal("120"))
                .build());

        //初始化折扣信息
        discountRates = new ArrayList<>();
        //一个时间段8折
        discountRates.add(DiscountRate.builder()
                .startDate(DateUtil.parseDate("2022-04-01"))
                .endDate(DateUtil.parseDate("2022-04-02"))
                .rate(new BigDecimal("0.8"))
                .schoolId("123")
                .build());
        //一个时间段9折
        discountRates.add(DiscountRate.builder()
                .startDate(DateUtil.parseDate("2022-04-03"))
                .endDate(DateUtil.parseDate("2022-04-07"))
                .rate(new BigDecimal("0.9"))
                .schoolId("123")
                .build());

    }



    public static void main(String[] args) {

        System.out.println("初始化的信息：" + studentInfo);
        System.out.println(" " + termPlanList);
        System.out.println(" " + schoolUnitePrices);
        System.out.println(" " + discountRates);
        System.out.println(calculator(studentInfo,termPlanList,schoolUnitePrices,discountRates));

    }

    /**
     * 计算价格，获取订单信息
     * 根据学期计划，校区单价，折扣信息计算
     * @param studentInfo
     * @param termPlanList
     * @param schoolUnitePrices
     * @param discountRates
     */
    private static RenewalOrderInfo calculator(Student studentInfo, List<TermPlan> termPlanList, List<SchoolUnitePrice> schoolUnitePrices, List<DiscountRate> discountRates) {

        //step1 计算课时
        int shouldByClassNumber  = calculatorShouldByClassNumber(studentInfo,termPlanList);

        //step2 计算校区的折扣价格
        BigDecimal shouldPrice = calculatorPrice(studentInfo,shouldByClassNumber,schoolUnitePrices,discountRates);



        return RenewalOrderInfo.builder()
                .buyLessonNumber(shouldByClassNumber)
                .buyPrice(shouldPrice)
                .studentId(studentInfo.getStudentId())
                .schoolId(studentInfo.getSchoolId())
                .build();
    }

    /**
     * 计算单价
     * @param studentInfo
     * @param shouldByLesson
     * @param schoolUnitePrices
     * @param discountRates
     * @return
     */
    private static BigDecimal calculatorPrice(Student studentInfo, int shouldByLesson, List<SchoolUnitePrice> schoolUnitePrices, List<DiscountRate> discountRates) {








        return BigDecimal.ZERO;
    }

    /**
     * 计算应该续费的课时
     * @param studentInfo
     * @param termPlanList
     * @return
     */
    private static int calculatorShouldByClassNumber(Student studentInfo, List<TermPlan> termPlanList) {

        //现在时间
        Date now = new Date();



        return 0;

    }

    /**
     * 续报订单信息
     */
    @Data
    @Builder
    public static class RenewalOrderInfo{

        /**
         * 购买课时数量
         */
        private Integer buyLessonNumber;

        /**
         * 购买价格
         */
        private BigDecimal buyPrice;

        /**
         * 学生id
         */
        private String studentId;

        /**
         * 校区id
         */
        private String schoolId;

    }


    /**
     * 校区单价
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class SchoolUnitePrice {

        private String schoolId;

        private BigDecimal uniPrice;

    }


    /**
     * 折扣率
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class DiscountRate {
        /**
         * 开始时间
         */
        private Date startDate;
        /**
         * 结束时间
         */
        private Date endDate;

        /**
         * 折扣率[0-1]的区间
         */
        private BigDecimal rate;

        /**
         * 校区
         */
        private String schoolId;

    }


    /**
     * 学员信息
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Student{

        /**
         * 学生id
         */
        private String studentId;
        /**
         * 学号
         */
        private String studentNumber;

        /**
         * 当前剩余课时
         */
        private Integer currentRemainLesson;

        /**
         * 学员所在校区
         */
        private String schoolId;

        /**
         * 等级id
         */
        private String levelId;

    }


    /**
     * 学期计划
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TermPlan {

        /**
         * 年
         */
        private Integer termYear;

        /**
         * 开始时间
         */
        private Date startDate;

        /**
         * 结束时间
         */
        private Date endDate;

        /**
         * 期间课时数量
         */
        private Integer hoursNumber;

        /**
         * 匹配学员等级
         */
        private String levelId;

    }

    /**
     * 浮动课程
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class FloatClass{

        /**
         * 学生id
         */
        private String studentId;

    }








}
