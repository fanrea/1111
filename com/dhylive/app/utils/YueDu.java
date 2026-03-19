package com.dhylive.app.utils;

import android.util.Log;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobstat.forbes.Config;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class YueDu {
    private static final String API_URL = "http://www.ttxlq.cn/api/channel/getReadDomain";
    private static final String ARTICLE_READ_API_URL = "http://www.ttxlq.cn/api/channel/getArticleRead";
    private static final String TAG = "阅读";
    private static final long TOKEN_CACHE_DURATION = 540000;
    private static ReadDomainData cachedData = null;
    private static String cachedToken = null;
    private static String cachedUUID = null;
    private static String jkey = "";
    private static long tokenCacheTime;
    private final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();
    private final Gson gson = new Gson();

    public interface ApiCallback {
        void onError(String str);

        void onSuccess(ReadDomainData readDomainData);
    }

    public static class ApiResponse {
        public int code;
        public ReadDomainData data;
        public String msg;
    }

    public interface ArticleReadCallback {
        void onError(String str);

        void onSuccess(String str);
    }

    public static class ArticleReadData {
        public String jkey;
        public int tid;
        public String url;
    }

    public static class ArticleReadResponse {
        public int code;
        public ArticleReadData data;
        public String msg;
    }

    public static class ReadDomainData {
        public String domain;
        public String fullUrl;
        public String searchUrl;
        public String token;
    }

    private String getCachedToken() {
        if (cachedToken == null || System.currentTimeMillis() - tokenCacheTime >= TOKEN_CACHE_DURATION) {
            return null;
        }
        return cachedToken;
    }

    private ReadDomainData getCachedData() {
        if (getCachedToken() != null) {
            return cachedData;
        }
        return null;
    }

    private void getReadDomain(String str, final ApiCallback apiCallback) {
        ReadDomainData cachedData2 = getCachedData();
        if (cachedData2 != null) {
            Log.d(TAG, "使用缓存的token: " + cachedToken);
            apiCallback.onSuccess(cachedData2);
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(g.s, str);
        jsonObject.addProperty(Config.CUSTOM_USER_ID, getCachedUUID());
        this.client.newCall(new Request.Builder().url(API_URL).post(RequestBody.create(jsonObject.toString(), MediaType.parse("application/json"))).addHeader("Content-Type", "application/json").build()).enqueue(new Callback() { // from class: com.dhylive.app.utils.YueDu.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Log.e(YueDu.TAG, "API调用失败", iOException);
                apiCallback.onError("网络错误: " + iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    try {
                    } catch (Exception e) {
                        Log.e(YueDu.TAG, "解析响应时出错", e);
                        apiCallback.onError("解析错误: " + e.getMessage());
                    }
                    if (!response.isSuccessful()) {
                        apiCallback.onError("HTTP错误: " + response.code());
                        return;
                    }
                    if (response.body() == null) {
                        apiCallback.onError("响应内容为空");
                        return;
                    }
                    String strString = response.body().string();
                    Log.d(YueDu.TAG, "API响应: " + strString);
                    ApiResponse apiResponse = (ApiResponse) YueDu.this.gson.fromJson(strString, ApiResponse.class);
                    if (apiResponse != null && apiResponse.code == 0 && apiResponse.data != null) {
                        String unused = YueDu.cachedToken = apiResponse.data.token;
                        ReadDomainData unused2 = YueDu.cachedData = apiResponse.data;
                        long unused3 = YueDu.tokenCacheTime = System.currentTimeMillis();
                        Log.d(YueDu.TAG, "Token缓存成功: " + YueDu.cachedToken);
                        apiCallback.onSuccess(apiResponse.data);
                    } else {
                        apiCallback.onError("API错误: " + ((apiResponse == null || apiResponse.msg == null) ? "响应数据格式错误" : apiResponse.msg));
                    }
                } finally {
                    response.close();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getArticleRead(final ArticleReadCallback articleReadCallback) {
        String cachedToken2 = getCachedToken();
        if (cachedToken2 == null) {
            articleReadCallback.onError("没有有效的token，请先调用getReadDomain获取token");
            return;
        }
        String str = "http://www.ttxlq.cn/api/channel/getArticleRead?tk=" + cachedToken2 + "&scheme=1&_jkey=" + jkey;
        Log.d(TAG, "请求文章阅读URL: " + str);
        this.client.newCall(new Request.Builder().url(str).get().build()).enqueue(new Callback() { // from class: com.dhylive.app.utils.YueDu.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Log.e(YueDu.TAG, "获取文章阅读链接失败", iOException);
                articleReadCallback.onError("网络错误: " + iOException.getMessage());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    try {
                    } catch (Exception e) {
                        Log.e(YueDu.TAG, "解析文章阅读响应时出错", e);
                        articleReadCallback.onError("解析错误: " + e.getMessage());
                    }
                    if (!response.isSuccessful()) {
                        articleReadCallback.onError("HTTP错误: " + response.code());
                        return;
                    }
                    if (response.body() == null) {
                        articleReadCallback.onError("响应内容为空");
                        return;
                    }
                    String strString = response.body().string();
                    Log.d(YueDu.TAG, "文章阅读API响应: " + strString);
                    ArticleReadResponse articleReadResponse = (ArticleReadResponse) YueDu.this.gson.fromJson(strString, ArticleReadResponse.class);
                    if (articleReadResponse != null && articleReadResponse.code == 0 && articleReadResponse.data != null && articleReadResponse.data.url != null) {
                        Log.d(YueDu.TAG, "获取文章URL成功: " + articleReadResponse.data.url);
                        String unused = YueDu.jkey = articleReadResponse.data.jkey;
                        articleReadCallback.onSuccess(articleReadResponse.data.url);
                    } else {
                        articleReadCallback.onError("API错误: " + ((articleReadResponse == null || articleReadResponse.msg == null) ? "响应数据格式错误" : articleReadResponse.msg));
                    }
                } finally {
                    response.close();
                }
            }
        });
    }

    public void getReadUrl(String str, final ArticleReadCallback articleReadCallback) {
        if (getCachedToken() != null) {
            Log.d(TAG, "使用缓存token直接获取文章链接");
            getArticleRead(articleReadCallback);
        } else {
            Log.d(TAG, "先获取token，再获取文章链接");
            getReadDomain(str, new ApiCallback() { // from class: com.dhylive.app.utils.YueDu.3
                @Override // com.dhylive.app.utils.YueDu.ApiCallback
                public void onSuccess(ReadDomainData readDomainData) {
                    Log.d(YueDu.TAG, "Token获取成功，开始获取文章链接");
                    YueDu.this.getArticleRead(articleReadCallback);
                }

                @Override // com.dhylive.app.utils.YueDu.ApiCallback
                public void onError(String str2) {
                    Log.e(YueDu.TAG, "获取token失败: " + str2);
                    articleReadCallback.onError("获取token失败: " + str2);
                }
            });
        }
    }

    public String getCachedUUID() {
        if (cachedUUID == null) {
            cachedUUID = UUID.randomUUID().toString();
            Log.d(TAG, "生成并缓存新的UUID: " + cachedUUID);
        }
        return cachedUUID;
    }
}
