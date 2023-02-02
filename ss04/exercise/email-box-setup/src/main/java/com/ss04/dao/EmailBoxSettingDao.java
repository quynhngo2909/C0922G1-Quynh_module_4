package com.ss04.dao;

import java.util.ArrayList;
import java.util.List;

public class EmailBoxSettingDao {

    private static List<String> languages;
    private static List<Integer> pageSizes;

    static {
        languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
    }

    static {
        pageSizes = new ArrayList<>();
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
    }

    public static List<String> getLanguages(){
        return languages;
    }

    public static List<Integer> getPageSizes(){
        return pageSizes;
    }
}
