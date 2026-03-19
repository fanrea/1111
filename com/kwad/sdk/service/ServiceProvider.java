package com.kwad.sdk.service;

import android.content.Context;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ServiceProvider {
    private static List<Throwable> PU;
    private static Context ckQ;
    private static Context ckR;
    private static boolean ckS;
    private static Context mContext;

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static void cM(Context context) {
        ckQ = context;
        mContext = m.fh(context);
    }

    public static void ant() {
        ckS = true;
    }

    @Deprecated
    public static Context anu() {
        return mContext;
    }

    public static Context getContext() {
        if (ckS) {
            return anu();
        }
        if (ckR == null) {
            ckR = m.wrapContextIfNeed(mContext);
        }
        return ckR;
    }

    public static SdkConfig getSDKConfig() {
        return b.getSDKConfig();
    }

    public static String getAppId() {
        return b.getAppId();
    }

    public static String getAppName() {
        return b.getAppName();
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    public static <T> void put(Class<T> cls, T t) {
        ServiceProviderDelegate.INSTANCE.put(cls, t);
    }

    public static void reportSdkCaughtException(Throwable th) {
        e eVar = (e) get(e.class);
        if (eVar != null) {
            eVar.gatherException(th);
        } else {
            b(th);
        }
    }

    private static void b(Throwable th) {
        if (PU == null) {
            PU = new CopyOnWriteArrayList();
        }
        PU.add(th);
    }

    public static void f(com.kwad.sdk.g.a<Throwable> aVar) {
        List<Throwable> list = PU;
        if (list == null) {
            return;
        }
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
        PU.clear();
        PU = null;
    }

    enum ServiceProviderDelegate {
        INSTANCE;

        private final Map<Class<?>, Object> mProviders = new HashMap(32);

        ServiceProviderDelegate() {
        }

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public final <T> void put(Class<T> cls, T t) {
            this.mProviders.put(cls, t);
        }
    }
}
