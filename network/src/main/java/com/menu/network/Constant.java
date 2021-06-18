package com.menu.network;

import android.Manifest;

public final class Constant {
    public static final String TEST_URL = "";
    public static final String INNER_URL = "";
    public static final int PDA_HAND_KEY = 134;

    public static final String APP_TABLE_NAME = "reinforce";
    public static final String SP_USERNAME = "sp_username";

    public static final String SP_APP_TABLE_NAME = "TagCloud";

    public static final String GET = "GET";
    public static final String POST = "POST";

    public static final String TITLE = "title";

    public static final boolean LOG = true;
    public static final int SUCCESS = 200;
    public static final String SP_PASSWORD = "sp_password";
    public static final String SESSION_ID_NAME = "sessionId";
    public static final String SP_REMEMBER_PASSWORD = "sp_remember_password";
    public static final String SP_AUTO_LOGIN = "sp_auto_login";
    public static final String SP_POWER = "sp_prower";
    public static final int WRITE_PROWER = 5;
    public static final String RFID_WRITE_PRASSWORD = "00000000";
    public static final String PRODUCT_CHANGE_STATUS = "status";

    //LogFileName
    public static final String LOG_FILENAME = "/LOG";
    //time
    public static final int DURATION = 4000;

    //code
    public static final int REQUEST_STORAGE_CODE = 10;
    public static final String[] MANIFEST = {Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    public static String SESSION_ID = "";

    public static String DK_COMPANY_ID = "";

    public static String USER_ID = "";
    public static String DK_COMPANY_NAME = "";
    public static String PERSON_USER_NAME = "";
    /**
     * 图片上传地址
     */
    public static String IMG_URL = "";

    public static String FUNCTION = "function";
    public static int FUNCTION_IN_CODE = 0;
    public static int FUNCTION_UP_CODE = 1;
    public static int FUNCTION_CHECK_CODE = 2;
    public static int FUNCTION_SEARCH_CODE = 3;
    public static int FUNCTION_FIND_CODE = 4;
    public static int FUNCTION_OUT_CODE = 5;

}
