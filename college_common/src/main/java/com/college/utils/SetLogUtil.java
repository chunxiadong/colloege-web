package com.college.utils;

import org.apache.log4j.Logger;

//注解工具，log4j日志
public class SetLogUtil {

    public static Logger setLog(Class cla){

        return Logger.getLogger(cla);
    }

}
