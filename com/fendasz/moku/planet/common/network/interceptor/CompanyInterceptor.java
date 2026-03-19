package com.fendasz.moku.planet.common.network.interceptor;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import androidx.core.location.LocationRequestCompat;
import com.alibaba.fastjson.JSON;
import com.fendasz.moku.planet.entity.PhoneInfo;
import com.fendasz.moku.planet.entity.TokenInfo;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.utils.AesUtil;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CompanyInterceptor implements Interceptor {
    private static final String AUTHORIZATION = "Authorization";
    private static final String FOR_NAME = "UTF-8";
    private static final String NEED_TOKEN_STR = "needToken";
    private static final String NEED_TOKEN_VALUE = "false";
    private static final String TAG = "CompanyInterceptor";
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static Context mContext;

    public static CompanyInterceptor create(Context context) {
        return new CompanyInterceptor(context);
    }

    private CompanyInterceptor(Context context) {
        mContext = context;
    }

    public static void removeContent() {
        mContext = null;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request requestBuild;
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        String strHeader = request.header(NEED_TOKEN_STR);
        boolean z = TextUtils.isEmpty(strHeader) || !NEED_TOKEN_VALUE.equals(strHeader);
        String userAgent = getUserAgent(mContext);
        String str = TAG;
        LogUtils.logD(str, "userAgent:" + userAgent);
        builderNewBuilder.addHeader("User-Agent", userAgent);
        if (z) {
            TokenInfo tokenInfo = new TokenInfo();
            PhoneInfo phoneInfo = MokuConfigure.getInstance().getPhoneInfo(mContext);
            tokenInfo.setAppId(phoneInfo.getAppId());
            tokenInfo.setDeviceId(phoneInfo.getDeviceId());
            tokenInfo.setSdkAppUserId(phoneInfo.getSdkAppUserId());
            tokenInfo.setTime(phoneInfo.getNetTime().longValue());
            String strEncrypt = AesUtil.encrypt(JSON.toJSONString(tokenInfo), MokuConfigure.getInstance().getPhoneInfo(mContext).getAppId() + MokuConfigure.getInstance().getPhoneInfo(mContext).getAppSecret());
            LogUtils.log(str, "token >> " + AesUtil.decrypt(strEncrypt, MokuConfigure.getInstance().getPhoneInfo(mContext).getAppId() + MokuConfigure.getInstance().getPhoneInfo(mContext).getAppSecret()));
            requestBuild = builderNewBuilder.addHeader(AUTHORIZATION, strEncrypt).removeHeader(NEED_TOKEN_STR).build();
        } else {
            LogUtils.log(str, "no token");
            requestBuild = builderNewBuilder.removeHeader(NEED_TOKEN_STR).build();
        }
        Response responseProceed = chain.proceed(requestBuild);
        ResponseBody responseBodyBody = responseProceed.body();
        BufferedSource source = responseBodyBody.getSource();
        source.request(LocationRequestCompat.PASSIVE_INTERVAL);
        Buffer bufferField = source.getBufferField();
        Charset charset = UTF8;
        MediaType mediaType = responseBodyBody.get$contentType();
        if (mediaType != null) {
            charset = mediaType.charset(charset);
        }
        return responseProceed.newBuilder().body(ResponseBody.create(mediaType, bufferField.clone().readString(charset))).build();
    }

    public static String getUserAgent(Context context) {
        try {
            defaultUserAgent = Build.VERSION.SDK_INT >= 17 ? WebSettings.getDefaultUserAgent(context) : null;
            if (StringUtils.isEmpty(defaultUserAgent)) {
                defaultUserAgent = System.getProperty("http.agent");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        if (!StringUtils.isEmpty(defaultUserAgent) && defaultUserAgent.length() > 0) {
            int length = defaultUserAgent.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = defaultUserAgent.charAt(i);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                } else {
                    sb.append(cCharAt);
                }
            }
        }
        LogUtils.logE("UserAgent===", sb.toString());
        return sb.toString();
    }
}
