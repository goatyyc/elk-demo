package com.example.demo.test;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 前缀树过滤敏感词
 * @author: yyc
 * @time: 2022/3/21 19:21
 */
public class FrontTrie {
    
    Trie root = new Trie();
    
    public static void main(String[] args) {
        
    }
    
    @PostConstruct
    public void init() throws IOException {
        // 初始化前缀树
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("sensitive-words.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String keyWord;
        while((keyWord=bufferedReader.readLine()) != null){
            // 添加到前缀树
            this.save(keyWord);
        }
    }

    /**
     * 判断输入词是否是敏感词
     * @param word
     * @return
     */
    public String isValid(String word){
        StringBuilder sb = new StringBuilder();
        Trie temp = root;
        int begin = 0;
        int p = 0;
        while (p<word.length()){
            char ch = word.charAt(p);
            // 检查下级节点
            temp = temp.getSubNode(ch);
            if(temp==null){
                sb.append(word.charAt(begin));
                begin++;
                p = begin;
                // 重新指向前缀树根
                temp = root;
            }else if(temp.isKeyWordEnd){
                // 前缀树不为空，且是叶子节点
                // 这就是一个敏感词
                sb.append("***");
                p++;
                begin = p;
                // 重新指向根节点
                temp = root;
            }else{
                // 前缀树不为空，前不是叶节点
                p++;
            }
        }
        // 将最后一批字符计入结果
        sb.append(word.substring(begin));
        return sb.toString();
    }
    
    // 存储一个字符串到前缀树中
    public void save(String str){
        Trie node = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Trie trie = node.getSubNode(ch);
            if(trie==null){
                // 该节点不存在，则加入前缀树子节点
                // 初始化子节点
                trie = new Trie();
                node.addSubNode(ch,trie);
            }
            // 将当前节点切换到下一个节点
            node = trie;
            // 判断是否到达叶子节点
            if(i==str.length()-1){
                // 设置结束标识
                node.isKeyWordEnd = true;
            }
        }
        
    }
    
}

class Trie{
    Character value;
    Map<Character,Trie> children = new HashMap<>(); 
    boolean isKeyWordEnd;
    
    // 添加子节点
    public void addSubNode(Character ch,Trie node){
        children.put(ch,node);
    }
    
    // 获取子节点
    public Trie getSubNode(Character ch){
        return children.get(ch);
    }
}