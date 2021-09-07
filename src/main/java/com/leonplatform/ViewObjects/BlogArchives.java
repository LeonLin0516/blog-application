package com.leonplatform.ViewObjects;

import com.leonplatform.Objects.Blog;

import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class BlogArchives {
    private List<String> months = new ArrayList<>();
    private HashMap<String, List<Blog>> monthArchives = new HashMap<>();

    public BlogArchives() {
    }

    public BlogArchives(List<Blog> blogs) {
        String month = null;
        String year = null;
        String monthYear = null;
        for (Blog blog : blogs) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(blog.getUpdatedTime());
            month = Month.of(cal.get(Calendar.MONTH)+1).name().toLowerCase();
            year = Year.of(cal.get(Calendar.YEAR)).toString();
            monthYear = new StringBuilder(month.substring(0,1).toUpperCase()+month.substring(1)+ " " + year).toString();
            if (!monthArchives.containsKey(monthYear)) {
                monthArchives.put(monthYear, new ArrayList<Blog>());
                months.add(monthYear);
            }
            monthArchives.get(monthYear).add(blog);
        }
    }

    public List<String> getMonths() {
        return months;
    }

    public void setMonths(List<String> months) {
        this.months = months;
    }

    public HashMap<String, List<Blog>> getMonthArchives() {
        return monthArchives;
    }

    public void setMonthArchives(HashMap<String, List<Blog>> monthArchives) {
        this.monthArchives = monthArchives;
    }
}
