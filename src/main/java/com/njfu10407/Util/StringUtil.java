package com.njfu10407.Util;

public class StringUtil {
    public static boolean isEmpty(String str) {
        if(str == null || "".contentEquals(str)) return true;
        return false;
    }

}
