package com.menu.network.exception;

import android.content.Context;
import android.content.Intent;

/**
 * @author lidabo
 * 异常统一处理
 */

public class ApiErrorHelper {

    public static final String ACTION_UNFINISH_ERROR = "con.menu.ACTION_UNFINISH_ERROR";
    public static final String ACTION_ORDER_DELIVERED_ERROR = "con.menu.ACTION_ORDER_DELIVERED_ERROR";
    public static final String ACTION_SEARCH_RESULT_EMPTY_ERROR = "con.menu.ACTION_SEARCH_RESULT_EMPTY_ERROR";
    public static final String ACTION_PARAMS_NOT_FOUND = "con.menu.ACTION_SERVICE_NOT_USE_ERROR";
    public static final String ACTION_NO_ROUTE_TO_HOST_ERROR = "con.menu.ACTION_NO_ROUTE_TO_HOST_ERROR";
    public static final String ACTION_NET_WORK_DISCONNECT_ERROR = "con.menu.ACTION_NET_WORK_DISCONNECT_ERROR";
    public static final String ACTION_DATA_PARSER_ERROR = "con.menu.ACTION_DATA_PARSER_ERROR";
    public static final String ACTION_LOGIN_TIMEOUT_ERROR = "con.menu.ACTION_LOGIN_TIMEOUT_ERROR";
    public static final String ACTION_USER_PERMISSION_DENIED_ERROR = "con.menu.ACTION_USER_PERMISSION_DENIED_ERROR";
    public static final String ACTION_NOT_SUPPORT_HTTP_METHOD_ERROR = "con.menu.ACTION_NOT_SUPPORT_HTTP_METHOD_ERROR";
    public static final String ACTION_COMMON_ERROR = "con.menu.ACTION_COMMON_ERROR";
    public static final String ACTION_OTHER_ERROR = "con.menu.ACTION_OTHER_ERROR";
    public static final String ACTION_SYSTEM_ERROR = "con.menu.ACTION_SYSTEM_ERROR";
    public static final String ACTION_UNKNOWN_ERROR = "con.menu.ACTION_UNKNOWN_ERROR";
    public static final String ACTION_CONNECT_ERROR = "con.menu.ACTION_CONNECT_ERROR";
    public static final String ACTION_SOCKET_TIME_OUT_ERROR = "con.menu.ACTION_SOCKET_TIME_OUT_ERROR";
    public static final String ACTION_USELESS_EPC_ERROR = "con.menu.ACTION_USELESS_EPC_ERROR";
    public static final String ACTION_EMPTY_EPC_ERROR ="con.menu.ACTION_EMPTY_EPC_ERROR";
    public static final String ACTION_USER_INEXISTENCE_ERROR ="con.menu.ACTION_USER_INEXISTENCE_ERROR";

    //网络异常发送广播统一处理。
    public static void handleCommonError(Context context, int errorCode) {

        Intent intent = null;
        //自定义异常的统一处理
        switch (errorCode) {
            case ApiErrorCode.NET_WORK_DISCONNECT_ERROR:
                intent = new Intent(ACTION_NET_WORK_DISCONNECT_ERROR);
                break;

            case ApiErrorCode.DATA_PARSER_ERROR:
                intent = new Intent(ACTION_DATA_PARSER_ERROR);
                break;

            case ApiErrorCode.LOGIN_TIMEOUT_ERROR:
                intent = new Intent(ACTION_LOGIN_TIMEOUT_ERROR);
                break;

            case ApiErrorCode.USER_PERMISSION_DENIED_ERROR:
                intent = new Intent(ACTION_USER_PERMISSION_DENIED_ERROR);
                break;

            case ApiErrorCode.NOT_SUPPORT_HTTP_METHOD_ERROR:
                intent = new Intent(ACTION_NOT_SUPPORT_HTTP_METHOD_ERROR);
                break;

            case ApiErrorCode.COMMON_ERROR:
                intent = new Intent(ACTION_COMMON_ERROR);
                break;

            case ApiErrorCode.OTHER_ERROR:
                intent = new Intent(ACTION_OTHER_ERROR);
                break;

            case ApiErrorCode.SYSTEM_ERROR:
                intent = new Intent(ACTION_SYSTEM_ERROR);
                break;

            case ApiErrorCode.UNKNOWN_ERROR:
                intent = new Intent(ACTION_UNKNOWN_ERROR);
                break;

            case ApiErrorCode.SOCKET_TIME_OUT_ERROR:
                intent = new Intent(ACTION_SOCKET_TIME_OUT_ERROR);
                break;

            case ApiErrorCode.CONNECT_ERROR:
                intent = new Intent(ACTION_CONNECT_ERROR);
                break;

            case ApiErrorCode.NO_ROUTE_TO_HOST_ERROR:
                intent = new Intent(ACTION_NO_ROUTE_TO_HOST_ERROR);
                break;

            case ApiErrorCode.PARAMS_NOT_FOUND:
                intent = new Intent(ACTION_PARAMS_NOT_FOUND);
                break;

            case ApiErrorCode.USELESS_EPC_CODE_ERROR:
                intent = new Intent(ACTION_USELESS_EPC_ERROR);
                break;

            case ApiErrorCode.EMPTY_EPC_CODE_ERROR:
                intent = new Intent(ACTION_EMPTY_EPC_ERROR);
                break;

            case ApiErrorCode.SEARCH_RESULT_EMPTY_ERROR:
                intent = new Intent(ACTION_SEARCH_RESULT_EMPTY_ERROR);
                break;

            case ApiErrorCode.ORDER_DELIVERED_ERROR:
                intent = new Intent(ACTION_ORDER_DELIVERED_ERROR);
                break;

            case ApiErrorCode.UNFINISH_ERROR:
                intent = new Intent(ACTION_UNFINISH_ERROR);
                break;
            case ApiErrorCode.USER_INEXISTENCE_ERROR:
                intent = new Intent(ACTION_USER_INEXISTENCE_ERROR);
            default:
        }

        if(intent != null){
            context.sendBroadcast(intent);
        }

    }


}
