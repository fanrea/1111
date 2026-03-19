package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.plugin.aw;
import com.qq.e.comm.plugin.rr;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ws {
    private static final Pattern k = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");
    private volatile String e;
    private volatile String f;
    private volatile long g;
    private final boolean h;
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicInteger c = new AtomicInteger(0);
    private int d = new Random(System.currentTimeMillis()).nextInt(10000);
    private final AtomicBoolean i = new AtomicBoolean(true);
    private final zj j = new b();
    private final Context a = r1.d().a();

    /* compiled from: A */
    private static class c {
        private static final ws a = new ws();
    }

    /* compiled from: A */
    public interface e {
    }

    static /* synthetic */ e d(ws wsVar) {
        wsVar.getClass();
        return null;
    }

    protected ws() {
        this.h = r1.d().f().a("nmpupfl", 1) == 1;
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ int a;

        @Override // java.lang.Runnable
        public void run() {
            eu euVar = new eu(fu.b(ws.this.a), fu.c(ws.this.a));
            if (euVar.a(this.a)) {
                euVar.a(fu.d(ws.this.a), fu.e(ws.this.a));
            }
            ws.this.b.set(false);
        }

        a(int i) {
            this.a = i;
        }
    }

    private boolean d(int i) {
        if (!this.h || n3.c()) {
            return false;
        }
        if (!this.i.compareAndSet(true, false)) {
            return true;
        }
        if (!fu.a(this.a).exists()) {
            return false;
        }
        qg.c.submit(new a(i));
        return true;
    }

    /* compiled from: A */
    class b implements zj {
        @Override // com.qq.e.comm.plugin.zj
        public void a(int i) {
        }

        b() {
        }

        @Override // com.qq.e.comm.plugin.zj
        public void a(boolean z, JSONObject jSONObject) {
            if (z) {
                ws.this.g = 0L;
                ws.this.a();
            }
        }
    }

    private String b(int i) {
        return String.format("%s_%d", "puocg", Integer.valueOf(i));
    }

    public static ws b() {
        return c.a;
    }

    private int c() throws NumberFormatException {
        String strC = r1.d().f().c("plucfg");
        int i = 100;
        if (TextUtils.isEmpty(strC)) {
            return 100;
        }
        String[] strArrSplit = strC.split(",");
        if (strArrSplit != null && strArrSplit.length > 0) {
            Date date = new Date();
            int hours = date.getHours();
            int minutes = date.getMinutes();
            for (String str : strArrSplit) {
                int iIndexOf = str.indexOf(Config.replace);
                int iIndexOf2 = str.indexOf(":");
                if (iIndexOf > 0 && iIndexOf2 > 0) {
                    int i2 = Integer.parseInt(str.substring(0, iIndexOf));
                    int i3 = Integer.parseInt(str.substring(iIndexOf + 1, iIndexOf2));
                    if (hours >= i2 && hours <= i3) {
                        String strSubstring = str.substring(iIndexOf2 + 1);
                        int iIndexOf3 = strSubstring.indexOf(Config.replace);
                        if (iIndexOf3 > 0) {
                            int i4 = Integer.parseInt(strSubstring.substring(0, iIndexOf3));
                            i = (((Integer.parseInt(strSubstring.substring(iIndexOf3 + 1)) - i4) * (((hours - i2) * 60) + minutes)) / (((i3 - i2) + 1) * 60)) + i4;
                        } else {
                            i = Integer.parseInt(strSubstring);
                        }
                    }
                }
            }
        }
        return i;
    }

    /* compiled from: A */
    private class d implements qr {
        private final String a;
        private final int b;

        public d(String str, int i) {
            this.a = str;
            this.b = i;
        }

        private void a(String str) {
            ws.d(ws.this);
        }

        private boolean a(File file, File file2) {
            return gu.b(file, fu.d(ws.this.a)) && gu.b(file2, fu.e(ws.this.a));
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, Exception exc) throws JSONException {
            GDTLogger.w("更新插件出现异常", exc);
            a(exc.getMessage());
            a(3001, exc.getMessage());
            ws.this.b.set(false);
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) throws JSONException {
            int iA = hwVar.a();
            if (iA == 200) {
                File fileG = fu.g(ws.this.a);
                File fileH = fu.h(ws.this.a);
                try {
                    String strA = gu.a(hwVar, fileG);
                    if (y30.a().a(this.a, strA)) {
                        boolean z = a(fileH) && a(fileG, fileH);
                        a();
                        if (z) {
                            ws.this.c.set(this.b);
                            a(0, "");
                        } else {
                            a(6000, "Rename file error");
                        }
                    } else {
                        fileG.delete();
                        String str = "Verify error:sig=" + this.a + "md5=" + strA + "version=" + this.b;
                        a(6000, str);
                        a(str);
                    }
                } catch (Throwable th) {
                    fileG.delete();
                    a(th.getMessage());
                    a(6000, th.getMessage());
                }
            } else {
                String str2 = "Status code error:" + iA;
                a(3005, str2);
                a(str2);
            }
            ws.this.b.set(false);
        }

        private void a(int i, String str) throws JSONException {
            ja jaVar = new ja();
            if (!TextUtils.isEmpty(str)) {
                jaVar.a("msg", str);
            }
            b10.a(9120030, null, Integer.valueOf(this.b), Integer.valueOf(i), jaVar);
        }

        private void a() {
            ws.d(ws.this);
        }

        private boolean a(File file) {
            return gu.c(file, this.b + "#####" + this.a);
        }
    }

    private boolean a(int i) {
        return (i < su.a() || i == this.c.get() || i == this.c.get()) ? false : true;
    }

    protected boolean c(int i) {
        try {
            int iC = c() * 100;
            if (iC > this.d) {
                return true;
            }
            vb vbVarA = wb.a(yy.a(b(i), 0L), this.j);
            if (iC + xb.a(vbVarA) > this.d) {
                b10.a(9120040, null, Integer.valueOf(i));
                return true;
            }
            ub.c().e(vbVarA);
            return false;
        } catch (Exception e2) {
            e2.getMessage();
            return true;
        }
    }

    public void a() {
        if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.f) || System.currentTimeMillis() - this.g < 600000) {
            return;
        }
        this.g = System.currentTimeMillis();
        a(this.e, this.f);
    }

    private void a(int i, long j) {
        String strB = b(i);
        if (j <= 0) {
            yy.a(strB);
        } else if (yy.a(strB, 0L) <= 0) {
            yy.b(strB, System.currentTimeMillis());
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !this.b.compareAndSet(false, true)) {
            return;
        }
        int iA = a(str2);
        if (!a(iA) || d(iA)) {
            return;
        }
        if (!c(iA)) {
            this.e = str;
            this.f = str2;
            this.b.set(false);
            a(iA, System.currentTimeMillis());
            return;
        }
        this.e = null;
        this.f = null;
        ub.c().b("puor");
        a(iA, 0L);
        System.nanoTime();
        sr.a().a(new cu(str2, aw.a.GET, (byte[]) null), rr.a.High, new d(str, iA));
    }

    private int a(String str) {
        Matcher matcher = k.matcher(str);
        return m10.a(matcher.matches() ? matcher.group(1) : "0", 0);
    }
}
