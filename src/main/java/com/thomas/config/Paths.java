package com.thomas.config;

import com.thomas.utilities.FileUtil;

/**
 * Created by Thomas on 12/21/2016.
 */
public class Paths {
    private static String getPath(String defaultPath, String... file) {
        String filename = (file.length>0)? file[0] : "";
        filename = defaultPath.concat(filename);
        return FileUtil.getFullpath(filename);
    }

    // For properties files
    public static String getPropertiesPath(String... file) {
        return getPath("src/main/java/com/thomas/config/", file);
    }

    // For CSV, XLS files
    public static String getDataPath(String... file) {
        return getPath("src/test/java/data/", file);
    }

    /* -----------------------------------------------------
    For testing purpose
    ----------------------------------------------------- */

    public static void main(String[] args) {
        System.out.println( getPropertiesPath() );
        System.out.println( getDataPath() );
    }
}
