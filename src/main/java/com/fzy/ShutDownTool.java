package com.fzy;

import java.util.Calendar;

/**
 * Created by fuzhongyu on 2017/9/12.
 */
public class ShutDownTool {

    /**
     * 关机
     * @param second  关机时间
     * @return
     */
    public boolean shutDowns(int second){
        try {
            String cmdStr="cmd /c shutdown -s -t "+second;
            Runtime.getRuntime().exec(cmdStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 取消关机
     * @return
     */
    public boolean shutDownCancel(){
        try {
            String cmdStr="cmd /c shutdown -a ";
            Runtime.getRuntime().exec(cmdStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }


}
