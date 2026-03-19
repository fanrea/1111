package com.kwad.sdk.core.d;

import android.util.Log;
import com.ksad.annotation.invoker.ForInvoker;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    private static boolean bCk = com.kwad.sdk.core.d.a.qr.booleanValue();
    private static final com.kwad.sdk.core.d.a.a bCl = new b();
    private static final List<com.kwad.sdk.core.d.a.a> bCm = new CopyOnWriteArrayList();
    public static boolean sEnableLog = true;

    interface a {
        void b(com.kwad.sdk.core.d.a.a aVar);
    }

    @ForInvoker(methodId = "registerLogger")
    private static void aan() {
        com.kwad.sdk.commercial.h.a.register();
    }

    public static void a(com.kwad.sdk.core.d.a.a aVar) {
        List<com.kwad.sdk.core.d.a.a> list = bCm;
        if (list.contains(aVar)) {
            return;
        }
        list.add(aVar);
    }

    public static void init(boolean z) {
        sEnableLog = z;
        List<com.kwad.sdk.core.d.a.a> list = bCm;
        list.clear();
        list.add(bCl);
        aan();
    }

    private static void a(a aVar) {
        for (com.kwad.sdk.core.d.a.a aVar2 : bCm) {
            if (aVar2 != null) {
                try {
                    aVar.b(aVar2);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String fm(String str) {
        return "KSAd_" + str;
    }

    private static String fn(String str) {
        return str + " " + Pf();
    }

    public static void d(String str, String str2) {
        Z(fm(str), fn(str2));
    }

    public static void d(String str, Throwable th) {
        d(str, th.getMessage());
    }

    private static void Y(final String str, final String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.c.1
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.d(str, str2);
            }
        });
    }

    private static void Z(String str, String str2) {
        if (str2 != null && str2.length() > 4000) {
            Y(str, str2.substring(0, 4000));
            Z(str, str2.substring(4000));
        } else {
            Y(str, str2);
        }
    }

    public static void v(final String str, String str2) {
        final String strFn = fn(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.4
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.v(c.fm(str), strFn);
            }
        });
    }

    public static void aa(final String str, String str2) {
        final String strFn = fn(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.5
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.v(c.fm(str), strFn, true);
            }
        });
    }

    public static void i(final String str, String str2) {
        final String strFn = fn(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.6
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.i(c.fm(str), strFn);
            }
        });
    }

    public static void w(final String str, String str2) {
        final String strFn = fn(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.7
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.w(c.fm(str), strFn);
            }
        });
    }

    public static void w(final String str, Throwable th) {
        final String strFn = fn(Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.d.c.8
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.w(c.fm(str), strFn, com.kwad.sdk.core.d.a.qr.booleanValue());
            }
        });
    }

    public static void e(final String str, String str2) {
        final String strFn = fn(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.9
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.e(c.fm(str), strFn);
            }
        });
    }

    public static void e(final String str, String str2, Throwable th) {
        final String strFn = fn(str2 + '\n' + Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.d.c.10
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.e(c.fm(str), strFn);
            }
        });
    }

    public static void printStackTrace(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.c.2
                @Override // com.kwad.sdk.core.d.c.a
                public final void b(com.kwad.sdk.core.d.a.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
        if (com.kwad.sdk.core.d.a.qr.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static void printStackTraceOnly(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.c.3
                @Override // com.kwad.sdk.core.d.c.a
                public final void b(com.kwad.sdk.core.d.a.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
    }

    private static String Pf() {
        int lineNumber;
        String fileName;
        if (!bCk) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 3) {
            fileName = stackTrace[3].getFileName();
            lineNumber = stackTrace[3].getLineNumber();
        } else {
            lineNumber = -1;
            fileName = "unknown";
        }
        return "(" + fileName + ':' + lineNumber + ')';
    }
}
