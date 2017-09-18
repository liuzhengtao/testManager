package org.yumin.zengDaWebUI.utils;

import java.io.*;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
public class CopyReportResources {

     public void copyResources()
     {
         this.copyFile("src/main/resources/reportResources/back.gif", "test-output/back.gif");
         this.copyFile("src/main/resources/reportResources/close.gif", "test-output/close.gif");
         this.copyFile("src/main/resources/reportResources/yuminlogo.png", "test-output/yuminlogo.png");
         this.copyFile("src/main/resources/reportResources/Chart.js", "test-output/Chart.js");
         this.copyFile("src/main/resources/reportResources/jquery-1.7.1.min.js", "test-output/jquery-1.7.1.min.js");
         this.copyFile("src/main/resources/reportResources/loadxmldoc.js", "test-output/loadxmldoc.js");
         this.copyFile("src/main/resources/reportResources/report.css", "test-output/report.css");
         this.copyFile("src/main/resources/reportResources/report.js", "test-output/report.js");
         this.copyFile("src/main/resources/reportResources/imageshow.css", "test-output/imageshow.css");
     }
    /**
     * 复制图片及其他文件
     * @param sourceRelativePath 源文件相对路径
     * @param targetRelativePath 目标文件相对路径
     */
    private void copyFile(String sourceRelativePath,String targetRelativePath)
    {
        FileManger.copyFile(sourceRelativePath,targetRelativePath);
    }
}
