package com.zp.leetcode.package_2022.july.july30;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/7/30 10:01 上午
 **/
public class StringInterpolation {

    Map<String,String> keyMap ;

    public static void main(String[] args) {
        StringInterpolation stringInterpolation = new StringInterpolation();
        String str = "My name is {{ name }} and {{ name }} I am forever {{ age }}.";
        //String str = "Say hello to {{ name }}. He is {{ age }}.";
        //String str = "Tommy is a good friend of {{ name }}. He lives in {{ city }}.";
        String key = "{ \"name\": \"Bill\", \"age\": 21 }";
        //String key = "{ \"name\": \"Bill\", \"age\": 21, \"male\": true}";
        //String key = "{ \"name\": \"Bill\" }";
        System.out.println(stringInterpolation.stringInterpolation(str,key));
    }

    /**
     * 字符串传入替换
     * @param str
     * @param key
     * @return
     */
    public String stringInterpolation(String str,String key){
        keyMap = buildKeyMap(key);
        for (Map.Entry<String, String> stringStringEntry : keyMap.entrySet()) {
            if(str.indexOf(stringStringEntry.getKey()) > 0){
                str = StrUtil.replace(str,stringStringEntry.getKey(),stringStringEntry.getValue());
            }
        }
        //检查是否还存在占位符需替换，若存在抛异常
        check(str);
        return str;
    }

    /**
     * 检查是否还存在需要替换占位符变量
     * @param str
     */
    private void check(String str) {
        int indexOfLeft = str.indexOf("{{");
        int indexOfRight = str.indexOf("}}");
        if(indexOfRight > indexOfLeft){
            throw new IllegalArgumentException("参数不对，还存在需要替换的变量");
        }
    }

    /**
     * 构建占位符的key-value
     * @param key
     * @return
     */
    private Map<String, String> buildKeyMap(String key) {
        JSONObject jsonObject = JSONUtil.parseObj(key);
        if(jsonObject.isEmpty()){
            keyMap = new HashMap<>(0);
            return keyMap;
        }
        keyMap = new HashMap<>(jsonObject.keySet().size() * 3);
        for (Map.Entry<String, Object> stringObjectEntry : jsonObject.entrySet()) {
            String itemKey = stringObjectEntry.getKey();
            String itemValue = String.valueOf(stringObjectEntry.getValue());
            List<String> keys = buildKeys(itemKey);
            for (String s : keys) {
                keyMap.put(s,itemValue);
            }
        }
        return keyMap;
    }

    /**
     * 构建满足占位符的key
     * @param itemKey
     * @return
     */
    private List<String> buildKeys(String itemKey) {
        List<String> keys = new ArrayList<>(3);
        //case1
        String case1Key = "{{ " + itemKey + " }}";
        keys.add(case1Key);
        //case2
        String case2Key = "{{" + itemKey + "}}";
        keys.add(case2Key);
        //case3
        String case3Key = "{{ " + itemKey + "}}";
        keys.add(case3Key);
        return keys;

    }


}
