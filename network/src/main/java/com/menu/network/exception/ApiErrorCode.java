package com.menu.network.exception;

/**
 * @author lidabo
 * 异常处理编码
 * 属于安卓内的网络异常按照10001后写
 */
public interface ApiErrorCode {

    /**
     * 安卓内部异常 数据解析错误异常，多出现在后台直接返回网页的情况和安卓实体类写错的情况
     */
    int DATA_PARSER_ERROR = 100011;


    /**
     * 安卓内部异常 网络没有连接的情况下出现的异常。
     */
    int NET_WORK_DISCONNECT_ERROR = 100021;
//----------------------------------------------------------------------
    /**
     * 库位编码或者档口ID不为空
     */
    int LOCATION_NAME_OF_ID = 30001;

    /**
     * 用户名不存在
     */
    int USER_INEXISTENCE_ERROR = 1004;

//----------------------------------------------------------------------
    /**
     * 安卓异常 登录超时，用户长时间没请求的情况下出现，返回到登录界面让用户重新登录。
     */
    int LOGIN_TIMEOUT_ERROR = 20000;


    /**
     * 安卓异常 权限不足，账号没请求的权限。
     */
    int USER_PERMISSION_DENIED_ERROR = 20001;


    /**
     * 安卓异常 HTTP方法不支持，此异常一般出现在参数传错或GET  POST方法用错的情况。
     */
    int NOT_SUPPORT_HTTP_METHOD_ERROR = 20002;

    /**
     * 后台异常 连接超时（超时指）
     */
    int SOCKET_TIME_OUT_ERROR = 300011;

    /**
     * 后台异常 连接异常，检查服务器是否打开
     */
    int CONNECT_ERROR = 300021;


    /**
     * 后台异常 找不到服务器主机
     */
    int NO_ROUTE_TO_HOST_ERROR = 300031;


    /**
     * 必须字段缺失
     */
    int PARAMS_NOT_FOUND = 300041;

    /**
     * 查询结果为空
     */
    int SEARCH_RESULT_EMPTY_ERROR = 30002;


    /**
     * EPC编码为空
     */
    int EMPTY_EPC_CODE_ERROR =  30005;

    /**
     * 无效的EPC编码
     */
    int USELESS_EPC_CODE_ERROR = 300071;

    /**
     * 后台异常 后台返回失败，此异常属于后台出现错误。
     */
    int COMMON_ERROR = 400;


    /**
     * 后台异常 后台系统错误，此异常属于后台直接报错。
     */
    int SYSTEM_ERROR = 500;


    /**
     * 后台异常 后台报告其他异常，不会返回数据，遇到此问题直接联系后台解决。
     */
    int OTHER_ERROR = 40000;


    /**
     * 后台异常 未知异常，不会返回数据，遇到此问题直接联系后台解决。
     */
    int UNKNOWN_ERROR = 40001;

    /**
     * 出库单未备货完毕
     */
    int ORDER_DELIVERED_ERROR = 300091;

    /**
     * 出库单已出库
     */
    int UNFINISH_ERROR = 300101;
}
