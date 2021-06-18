package com.menu.network;


import androidx.lifecycle.Observer;

import com.menu.network.bean.DataResponse;

public abstract class CustomObserver<T> implements Observer<DataResponse<T>> {

    @Override
    public void onChanged(DataResponse<T> tDataResponse) {
        onLoadingEnd();
        if (tDataResponse != null) {
            if (tDataResponse.getCode() == 200) {
                if (tDataResponse.getData() == null) {
                    onSuccess((T) tDataResponse.getMessage());
                } else {
                    onSuccess(tDataResponse.getData());
                }
            } else {
                onFail(tDataResponse.getCode(), tDataResponse.getMessage());
            }
        } else {
            onFail(404, "后台数据返回失败");
        }
    }

    public abstract void onSuccess(T t);

    public abstract void onFail(int code, String message);

    public void onLoadingEnd() {
    }
}
