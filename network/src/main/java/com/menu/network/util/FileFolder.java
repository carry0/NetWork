package com.menu.network.util;

import android.os.Environment;


import com.menu.network.Constant;

import java.io.File;

public class FileFolder {

    public static File rootDir() {
        return new File(Environment.getExternalStorageDirectory() + Constant.LOG_FILENAME);
    }

    public static File rootDir(String fileName){
        return new File(Environment.getExternalStorageDirectory() + fileName);
    }

}
