package com.simple.utils;

import java.util.UUID;

/**
 * @author Simple
 * @data 2021/3/24 18:47
 */

@SuppressWarnings("all")//抑制警告
public class IDutils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
