package com.zp.leetcode.package2023.february.february08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/2/8 1:55 下午
 * 删除子文件夹
 **/
public class RemoveSubfolders {

    public static void main(String[] args) {
        String[] folders = new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        RemoveSubfolders removeSubfolders = new RemoveSubfolders();
        System.out.println(removeSubfolders.removeSubfolders(folders));
    }


    public List<String> removeSubfolders(String[] folder) {
        Trie root = new Trie();
        for (int i = 0; i < folder.length; ++i) {
            List<String> path = split(folder[i]);
            Trie cur = root;
            for (String name : path) {
                cur.children.putIfAbsent(name, new Trie());
                cur = cur.children.get(name);
            }
            cur.ref = i;
        }

        List<String> ans = new ArrayList<String>();
        dfs(folder, ans, root);
        return ans;
    }

    public List<String> split(String s) {
        List<String> ret = new ArrayList<String>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '/') {
                ret.add(cur.toString());
                cur.setLength(0);
            } else {
                cur.append(ch);
            }
        }
        ret.add(cur.toString());
        return ret;
    }

    public void dfs(String[] folder, List<String> ans, Trie cur) {
        if (cur.ref != -1) {
            ans.add(folder[cur.ref]);
            return;
        }
        for (Trie child : cur.children.values()) {
            dfs(folder, ans, child);
        }
    }

    class Trie {
        int ref;
        Map<String, Trie> children;

        public Trie() {
            ref = -1;
            children = new HashMap<String, Trie>();
        }
    }


}
