package com.bytedance.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class p4 {
    public static volatile String a;

    public static class a implements Callable<String> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ q1 b;

        public a(Context context, q1 q1Var) {
            this.a = context;
            this.b = q1Var;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            AdvertisingIdClient.Info advertisingIdInfo;
            if (TextUtils.isEmpty(p4.a)) {
                synchronized (p4.class) {
                    if (!TextUtils.isEmpty(p4.a)) {
                        return p4.a;
                    }
                    try {
                        advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.a);
                    } catch (Throwable th) {
                        if (!(th instanceof ClassNotFoundException) && !(th instanceof NoClassDefFoundError)) {
                            LoggerImpl.global().error("Query Gaid failed", th, new Object[0]);
                        }
                    }
                    String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                    if (TextUtils.isEmpty(id)) {
                        id = this.b.f.getString("google_aid", null);
                    } else if (!TextUtils.equals(this.b.f.getString("google_aid", null), id)) {
                        q1 q1Var = this.b;
                        if (!TextUtils.isEmpty(id) && q1Var != null) {
                            q1Var.f.edit().putString("google_aid", id).apply();
                        }
                    }
                    p4.a = id;
                }
            }
            return p4.a;
        }
    }

    public static String a(Context context, q1 q1Var) {
        return (String) x.a.submit(new a(context, q1Var)).get(q1Var.c.getGaidTimeOutMilliSeconds(), TimeUnit.MILLISECONDS);
    }
}
