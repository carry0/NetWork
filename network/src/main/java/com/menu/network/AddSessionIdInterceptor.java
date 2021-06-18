package com.menu.network;

import android.text.TextUtils;
import android.webkit.WebSettings;

import com.menu.network.util.LogUtil;
import com.menu.network.util.RequestUtil;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 添加公共参数拦截器
 *
 * @author Administrator
 */
public class AddSessionIdInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        //获取到request
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        String userAgent = WebSettings.getDefaultUserAgent(Application.getContext());
        //获取到方法
        String method = request.method();

        String sessionId = Constant.SESSION_ID;
        //GET添加参数
        if (Constant.GET.equals(method)) {
            HttpUrl.Builder builder = request.url().newBuilder()
                    .addQueryParameter("__ajax", "json");
            HttpUrl url = builder.build();
            requestBuilder.url(url);
        } else if (Constant.POST.equals(method)) {
            //post请求追加参数
            FormBody.Builder newBody = new FormBody.Builder();
            RequestBody requestBody = request.body();
            if (requestBody instanceof FormBody) {
                FormBody formBody = (FormBody) requestBody;
                for (int i = 0; i < formBody.size(); i++) {
                    newBody.add(formBody.encodedName(i), formBody.encodedValue(i));
                }
                newBody.add("__ajax", "json");
                requestBuilder.post(newBody.build());
            }
        }
        requestBuilder.removeHeader("User-Agent")
                .addHeader("User-Agent", userAgent);
        if (!TextUtils.isEmpty(sessionId)) {
//            修改Cookie 、session id名称
            requestBuilder.addHeader("Cookie", "jeesite.session.id=" + sessionId);
        }
        request = requestBuilder.build();
        Response response = chain.proceed(request);
        LogUtil.i("TAG", "\n请求链接：" + request.url().toString() + "\n请求参数：" + RequestUtil.getRequestInfo(request) + "\n请求响应:" + RequestUtil.getResponseInfo(response));
        return response;
    }
}
