package com.lingku.xuanshang.xutils.http.request;

import android.text.TextUtils;
import com.alipay.sdk.m.l.a;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.http.app.RequestTracker;
import com.sigmob.sdk.base.n;
import java.lang.reflect.Type;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class UriRequestFactory {
    public static Class<? extends RequestTracker> a;
    public static final HashMap<String, Class<? extends UriRequest>> b = new HashMap<>();

    public static RequestTracker getDefaultTracker() {
        try {
            Class<? extends RequestTracker> cls = a;
            if (cls == null) {
                return null;
            }
            return cls.newInstance();
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return null;
        }
    }

    public static UriRequest getUriRequest(RequestParams requestParams, Type type) {
        String uri = requestParams.getUri();
        int iIndexOf = uri.indexOf(":");
        String strSubstring = uri.startsWith("/") ? n.z : iIndexOf > 0 ? uri.substring(0, iIndexOf) : null;
        if (TextUtils.isEmpty(strSubstring)) {
            throw new IllegalArgumentException("The url not be support: " + uri);
        }
        String lowerCase = strSubstring.toLowerCase();
        Class<? extends UriRequest> cls = b.get(lowerCase);
        if (cls != null) {
            return cls.getConstructor(RequestParams.class, Type.class).newInstance(requestParams, type);
        }
        if (lowerCase.startsWith(a.r)) {
            return new HttpRequest(requestParams, type);
        }
        if (lowerCase.equals("assets")) {
            return new AssetsRequest(requestParams, type);
        }
        if (lowerCase.equals(n.z)) {
            return new LocalFileRequest(requestParams, type);
        }
        if (lowerCase.equals("res")) {
            return new ResRequest(requestParams, type);
        }
        throw new IllegalArgumentException("The url not be support: " + uri);
    }

    public static void registerDefaultTrackerClass(Class<? extends RequestTracker> cls) {
        a = cls;
    }

    public static void registerRequestClass(String str, Class<? extends UriRequest> cls) {
        b.put(str, cls);
    }
}
