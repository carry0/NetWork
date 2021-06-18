package com.menu.network.converter;

import com.menu.network.bean.DataResponse;
import com.menu.network.exception.ApiErrorCode;
import com.menu.network.exception.ApiException;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private final Gson mGson;
    private final TypeAdapter<T> adapter;

    public CustomGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        mGson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        DataResponse re;
        try {
            re = mGson.fromJson(response, DataResponse.class);
        } catch (Exception e) {
            throw new ApiException("后台数据错误", ApiErrorCode.DATA_PARSER_ERROR);
        }

        //关注的重点，自定义响应码中非0的情况，一律抛出ApiException异常。
        //这样，我们就成功的将该异常交给onError()去处理了。
        if (re.getCode() != 200) {
            value.close();
            throw new ApiException(re.getMessage(), re.getCode());
        }

        MediaType mediaType = value.contentType();
        Charset charset = mediaType != null ? mediaType.charset(UTF_8) : UTF_8;
        ByteArrayInputStream bis = new ByteArrayInputStream(response.getBytes());
        InputStreamReader reader = new InputStreamReader(bis, charset);
        JsonReader jsonReader = mGson.newJsonReader(reader);
        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }
}
