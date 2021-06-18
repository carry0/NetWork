package com.menu.network;



import com.menu.network.bean.DataResponse;
import com.menu.network.bean.Response;
import com.menu.network.exception.ApiErrorCode;
import com.menu.network.exception.ApiErrorHelper;
import com.menu.network.exception.ApiException;
import com.menu.network.util.NetWorkUtil;
import com.menu.network.util.ResourcesUtils;

import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;

import androidx.lifecycle.MutableLiveData;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 请求控制类，监听RXjava结果，结果集最后放入LiveData中。
 */
public class CallHandler {

    public static <E extends Response> MutableLiveData<E> get(Observable<E> observable) {

        MutableLiveData<E> data = new MutableLiveData<>();

        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(throwable -> {
                    //onErrorReturn,错误时返回，返回值是onNext的参数

                    DataResponse<Void> dataResponse;
                    //OKHttp等异常捕获并处理
                    if (!NetWorkUtil.isNetworkConnected(Application.getContext())) {
                        //网络未连接抛出异常
                        dataResponse = new DataResponse<>(ApiErrorCode.NET_WORK_DISCONNECT_ERROR, ResourcesUtils.getString(R.string.no_network_error));

                    } else if (throwable instanceof SocketTimeoutException) {
                        //连接超时
                        dataResponse = new DataResponse<>(ApiErrorCode.SOCKET_TIME_OUT_ERROR, ResourcesUtils.getString(R.string.socket_timeout_error));

                    } else if (throwable instanceof ConnectException) {
                        //连接异常，一般指服务器没打开或对应接口不存在。
                        dataResponse = new DataResponse<>(ApiErrorCode.CONNECT_ERROR, ResourcesUtils.getString(R.string.connect_error));

                    } else if (throwable instanceof NoRouteToHostException) {
                        //连接异常，找不到服务器主机
                        dataResponse = new DataResponse<>(ApiErrorCode.NO_ROUTE_TO_HOST_ERROR, ResourcesUtils.getString(R.string.no_route_to_host));

                    } else if (throwable instanceof ApiException) {
                        //非成功码异常
                        dataResponse = new DataResponse<>(((ApiException) throwable).getErrorCode(), throwable.getMessage());

                    } else {
                        //未知异常，未处理的异常
                        dataResponse = new DataResponse<>(ApiErrorCode.UNKNOWN_ERROR, ResourcesUtils.getString(R.string.unknown_error));

                    }
                    //异常统一广播处理
                    ApiErrorHelper.handleCommonError(Application.getContext(), dataResponse.getCode());
                    return (E) dataResponse;

                })
                .subscribe(new Subscriber<E>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //执行onErrorReturn后，onError不执行
                    }

                    @Override
                    public void onNext(E e) {
                        data.postValue(e);
                    }
                });

        return data;
    }

}
