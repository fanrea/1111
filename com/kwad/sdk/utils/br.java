package com.kwad.sdk.utils;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class br {
    public static String get(String str) {
        Object objB = b("get", new Class[]{String.class}, str);
        if (objB instanceof String) {
            return (String) objB;
        }
        return iL(str);
    }

    public static String get(String str, String str2) {
        Object objB = b("get", new Class[]{String.class, String.class}, str, str2);
        if (objB instanceof String) {
            return (String) objB;
        }
        return (String) a(str, str2, new com.kwad.sdk.g.b<String, String>() { // from class: com.kwad.sdk.utils.br.1
            private static String iM(String str3) {
                return str3;
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ String apply(String str3) {
                return iM(str3);
            }
        });
    }

    public static int getInt(String str, int i) {
        Object objB = b("getInt", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
        if (objB instanceof Integer) {
            return ((Integer) objB).intValue();
        }
        return ((Integer) a(str, Integer.valueOf(i), new com.kwad.sdk.g.b<String, Integer>() { // from class: com.kwad.sdk.utils.br.2
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Integer apply(String str2) {
                return iN(str2);
            }

            private static Integer iN(String str2) {
                return Integer.valueOf(Integer.parseInt(str2));
            }
        })).intValue();
    }

    public static long getLong(String str, long j) {
        Object objB = b("getLong", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j));
        if (objB instanceof Long) {
            return ((Long) objB).longValue();
        }
        return ((Long) a(str, Long.valueOf(j), new com.kwad.sdk.g.b<String, Long>() { // from class: com.kwad.sdk.utils.br.3
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Long apply(String str2) {
                return iO(str2);
            }

            private static Long iO(String str2) {
                return Long.valueOf(Long.parseLong(str2));
            }
        })).longValue();
    }

    public static boolean getBoolean(String str, boolean z) {
        Object objB = b("getBoolean", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z));
        if (objB instanceof Boolean) {
            return ((Boolean) objB).booleanValue();
        }
        return ((Boolean) a(str, Boolean.valueOf(z), new com.kwad.sdk.g.b<String, Boolean>() { // from class: com.kwad.sdk.utils.br.4
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Boolean apply(String str2) {
                return iP(str2);
            }

            private static Boolean iP(String str2) {
                return Boolean.valueOf(Boolean.parseBoolean(str2));
            }
        })).booleanValue();
    }

    private static Object b(String str, Class[] clsArr, Object... objArr) {
        try {
            return z.a("android.os.SystemProperties", str, clsArr, objArr);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return null;
        }
    }

    private static <T> T a(String str, T t, com.kwad.sdk.g.b<String, T> bVar) {
        String strIL = iL(str);
        if (strIL == null) {
            return t;
        }
        try {
            return bVar.apply(strIL);
        } catch (Throwable unused) {
            return t;
        }
    }

    private static String iL(String str) {
        try {
            return com.kwad.sdk.crash.utils.h.d(Runtime.getRuntime().exec("getprop " + str).getInputStream());
        } catch (IOException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return null;
        }
    }
}
