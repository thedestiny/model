package com.destiny.model.util.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class IOutils {

    public static void outPutToFile(File file, String content) throws IOException {

        FileUtils.writeStringToFile(file, content, true);

    }


}
