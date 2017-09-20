package com.niuchatao.pw.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2017/3/28.
 */
public class MainTest {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            temp =  br.readLine();
            System.out.println(temp);
        } while(!temp.equals("我退出"));
    }
}
