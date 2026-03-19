package com.kwad.sdk.api;

import com.kwad.sdk.api.core.IKsAdSDK;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    private static List<Throwable> PU;
    private static IKsAdSDK brP;

    static /* synthetic */ List ac(List list) {
        PU = null;
        return null;
    }

    public static void a(IKsAdSDK iKsAdSDK) {
        brP = iKsAdSDK;
    }

    public static IKsAdSDK VK() {
        return brP;
    }

    public static boolean VL() {
        Boolean bool = (Boolean) g("enableDynamic", new Object[0]);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public static int VM() {
        Integer num = (Integer) g("getAutoRevertTime", new Object[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static <T> T g(String str, Object... objArr) {
        try {
            T t = (T) brP.dM(str, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String dD(String str) {
        return (String) g("TRANSFORM_API_HOST", str);
    }

    public static void r(Throwable th) {
        try {
            if (brP != null && KsAdSDK.haseInit()) {
                brP.re(th);
            } else {
                b(th);
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(Throwable th) {
        try {
            if (PU == null) {
                PU = new CopyOnWriteArrayList();
            }
            PU.add(th);
        } catch (Throwable unused) {
        }
    }

    public static void oE() {
        try {
            com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.b.1
                @Override // com.kwad.sdk.api.a.b
                public final void doTask() {
                    try {
                        if (b.PU == null) {
                            return;
                        }
                        for (Throwable th : b.PU) {
                            if (b.brP != null && KsAdSDK.haseInit()) {
                                b.brP.re(th);
                            }
                        }
                        b.PU.clear();
                        b.ac(null);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
