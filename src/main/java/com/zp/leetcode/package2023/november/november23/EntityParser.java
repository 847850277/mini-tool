package com.zp.leetcode.package2023.november.november23;

import java.util.HashMap;
import java.util.Map;

public class EntityParser {


    public static void main(String[] args) {
        String str = "and I quote: &quot;...&quot;";
        EntityParser entityParser = new EntityParser();
        System.out.println(entityParser.entityParser(str));
    }

    private Map replaceMap = new HashMap(){{
        put("&quot;","\"");
        put("&apos;","'");
        put("&amp;","&");
        put("&gt;",">");
        put("&lt;","<");
        put("&frasl;","/");
    }};

    public String entityParser(String text) {
        StringBuffer ans = new StringBuffer();
        int len = text.length();
        for (int i = 0; i < len; ) {
            if(text.charAt(i) == '&'){
                int j = i + 1;
                while (j < len && j - i < 6 && text.charAt(j) != ';') j++;
                String sub = text.substring(i,Math.min(j + 1, len));
                if(replaceMap.containsKey(sub)){
                    ans.append(replaceMap.get(sub));
                    i = j + 1;
                    continue;
                }
            }
            ans.append(text.charAt(i++));
        }
        return ans.toString();
    }
}
