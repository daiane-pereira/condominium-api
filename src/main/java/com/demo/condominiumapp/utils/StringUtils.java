package com.demo.condominiumapp.utils;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.regex.Pattern;

public class StringUtils {

    public static List<String> split(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return Splitter.on(pattern)
                .trimResults()
                .omitEmptyStrings()
                .splitToList(text);
    }
}
