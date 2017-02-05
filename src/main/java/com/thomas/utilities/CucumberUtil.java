package com.thomas.utilities;

import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Thomas on 12/19/2016.
 */
public class CucumberUtil {
    private static Map<String, String> data = new HashMap<>();

    public static void set(DataTable table) {
        for (DataTableRow row : table.getGherkinRows()) {
            data.put(row.getCells().get(0), row.getCells().get(1));
        }
    }

    public static Map<String, String> get() {
        return data;
    }
    public static String get(String key) {
        return data.get(key);
    }
}
