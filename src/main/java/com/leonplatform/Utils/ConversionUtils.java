package com.leonplatform.Utils;

import com.leonplatform.Objects.Tag;

import java.util.ArrayList;
import java.util.List;

public class ConversionUtils {

    public static List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (ids != null && !"".equals(ids)) {
            String[] split = ids.split(",");
            for (String s : split) {
                list.add(Long.parseLong(s));
            }
        }
        return list;
    }
}
