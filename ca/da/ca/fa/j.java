package ca.da.ca.fa;

import android.accounts.Account;
import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: DeviceRegisterParameterFactory.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class j {
    public static volatile ConcurrentHashMap<g, j> c = new ConcurrentHashMap<>();
    public static Account d;
    public volatile ca.da.ca.ja.k a;
    public ca.da.ca.ia.a b;

    public static ca.da.ca.ja.k a(Context context, g gVar) throws IllegalArgumentException {
        j jVar = c.get(gVar);
        if (jVar == null) {
            synchronized (j.class) {
                jVar = c.get(gVar);
                if (jVar == null) {
                    if (context == null) {
                        throw new IllegalArgumentException("context == null");
                    }
                    jVar = new j();
                    jVar.b = new ca.da.ca.ia.a(context);
                    if (jVar.a == null) {
                        jVar.a = new ca.da.ca.ja.f(context, gVar, jVar.b);
                        if (d != null) {
                            ((ca.da.ca.ja.f) jVar.a).a(d);
                        }
                    }
                }
            }
        }
        return jVar.a;
    }

    public static void a(Context context, boolean z) {
    }

    public static boolean a() {
        return false;
    }

    public static boolean a(Context context) {
        ca.da.ca.ja.r.a("DeviceRegisterParameterFactory isNewUserMode false. context=" + context + " isDebugChannel()=false");
        return false;
    }
}
