package com.baidu.mobads.container.l;

import android.os.Build;
import com.baidu.mobads.container.l.g;
import java.util.regex.Matcher;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e extends g.a {
    public static final String a = "local";
    private static final int c = 23;
    private static final int d = 5;
    protected b b;

    public e() {
        this.b = new j();
    }

    public e(b bVar) {
        this.b = bVar;
    }

    @Override // com.baidu.mobads.container.l.g.a
    String a() {
        return "local";
    }

    private String a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        Matcher matcher = i.c.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        String strSubstring = className.substring(className.lastIndexOf(46) + 1);
        if (strSubstring.length() <= 23 || Build.VERSION.SDK_INT >= 24) {
            return strSubstring;
        }
        return strSubstring.substring(0, 23);
    }

    @Override // com.baidu.mobads.container.l.g.a
    final String b() {
        String strB = super.b();
        if (strB != null) {
            return strB;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length <= 5) {
            return "";
        }
        return a(stackTrace[5]);
    }

    @Override // com.baidu.mobads.container.l.g.a
    protected void a(int i, String str, String str2, Throwable th) {
        try {
            this.b.a(i, str, str2, th);
        } catch (Throwable th2) {
            i.a(6, str, th2.toString());
        }
    }
}
