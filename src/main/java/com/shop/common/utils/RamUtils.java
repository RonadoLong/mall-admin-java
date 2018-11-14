package com.shop.common.utils;

public class RamUtils {

    public static int getRandNum(int min, int max) {
        int randNum = min + (int)(Math.random() * ((max - min) + 1));
        return randNum;
    }

    public static int getSixRamNumber(){
        return getRandNum(1,999999);
    }

}
