package com.destiny.model.util.config;

import java.util.ResourceBundle;

public class ConfigLoader {


    public static ResourceBundle loadConfig(String fileName) {

        try {
            return ResourceBundle.getBundle(fileName);
        } catch (Exception e) {
            throw new IllegalStateException(fileName + " 文件找不到 ");
        }
    }


}
