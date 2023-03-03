package com.zp.leetcode.package2023.march.march03;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/3/3 8:53 上午
 * 保证文件名唯一
 **/
public class GetFolderNames {

    public static void main(String[] args) {
        GetFolderNames getFolderNames = new GetFolderNames();
        //String[] array = new String[]{"pes","fifa","gta","pes(2019)"};
        //String[] array = new String[]{"gta","gta(1)","gta","avalon"};
        ///String[] array = new String[]{"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"};
        //String[] array = new String[]{"wano","wano","wano","wano"};
        //String[] array = new String[]{"kaido","kaido(1)","kaido","kaido(1)"};
        String[] array = new String[]{"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};
        //String[] array = new String[]{"kingston(0)","kingston","kingston"};
        String[] folderNames = getFolderNames.getFolderNames(array);
        for (String folderName : folderNames) {
            System.out.println(folderName);
        }
    }

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> index = new HashMap<String, Integer>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!index.containsKey(name)) {
                res[i] = name;
                index.put(name, 1);
            } else {
                int k = index.get(name);
                while (index.containsKey(addSuffix(name, k))) {
                    k++;
                }
                res[i] = addSuffix(name, k);
                index.put(name, k + 1);
                index.put(addSuffix(name, k), 1);
            }
        }
        return res;
    }

    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }


    public String[] getFolderNames1(String[] names) {
        String[] result = new String[names.length];
        Map<String,Boolean> existsMap = new HashMap<String,Boolean>();
        int i = 0;
        for (String name : names) {
            Boolean orDefault = existsMap.getOrDefault(name, false);
            //层数
            int level = 0;
            while (orDefault){
                name = calK(name,level);
                level++;
                orDefault = existsMap.getOrDefault(name,false);
            }
            existsMap.put(name,true);
            result[i] = name;
            i++;
        }
        return result;
    }

    private String calK(String name,int level) {
        if(name.lastIndexOf(")") == name.length() - 1 && level > 0){
            int start = name.lastIndexOf("(");
            int end = name.lastIndexOf(")");
            int num = Integer.valueOf(name.substring(start + 1,end)) + 1;
            return name.substring(0,name.lastIndexOf("(")) + "(" + num + ")";
        }else {
            return name + "(1)";
        }
    }


}
