package com.duoyou.task.sdk.xutils.http.request;

import android.text.TextUtils;
import com.alipay.sdk.m.l.a;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.http.RequestParams;
import com.duoyou.task.sdk.xutils.http.app.RequestTracker;
import com.sigmob.sdk.base.n;
import java.lang.reflect.Type;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class UriRequestFactory {
    private static final HashMap<String, Class<? extends UriRequest>> SCHEME_CLS_MAP = new HashMap<>();
    private static Class<? extends RequestTracker> defaultTrackerCls;

    private UriRequestFactory() {
    }

    public static UriRequest getUriRequest(RequestParams requestParams, Type type) {
        String strSubstring;
        String uri = requestParams.getUri();
        int iIndexOf = uri.indexOf(":");
        if (uri.startsWith("/")) {
            strSubstring = n.z;
        } else {
            strSubstring = iIndexOf > 0 ? uri.substring(0, iIndexOf) : null;
        }
        if (!TextUtils.isEmpty(strSubstring)) {
            String lowerCase = strSubstring.toLowerCase();
            Class<? extends UriRequest> cls = SCHEME_CLS_MAP.get(lowerCase);
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
        throw new IllegalArgumentException("The url not be support: " + uri);
    }

    public static void registerDefaultTrackerClass(Class<? extends RequestTracker> cls) {
        defaultTrackerCls = cls;
    }

    public static RequestTracker getDefaultTracker() {
        try {
            Class<? extends RequestTracker> cls = defaultTrackerCls;
            if (cls == null) {
                return null;
            }
            return cls.newInstance();
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return null;
        }
    }

    public static void registerRequestClass(String str, Class<? extends UriRequest> cls) {
        SCHEME_CLS_MAP.put(str, cls);
    }
}
