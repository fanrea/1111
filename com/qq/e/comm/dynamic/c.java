package com.qq.e.comm.dynamic;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.plugin.b10;
import com.qq.e.comm.plugin.d6;
import com.qq.e.comm.plugin.db;
import com.qq.e.comm.plugin.ez;
import com.qq.e.comm.plugin.f5;
import com.qq.e.comm.plugin.fb;
import com.qq.e.comm.plugin.gb;
import com.qq.e.comm.plugin.gp;
import com.qq.e.comm.plugin.gu;
import com.qq.e.comm.plugin.gv;
import com.qq.e.comm.plugin.lz;
import com.qq.e.comm.plugin.qg;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.s60;
import com.qq.e.comm.plugin.xo;
import com.ss.ttm.player.MediaPlayer;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class c {
    private static volatile c j = null;
    private static String k = "bGliZ2R0cWpzLnNv";
    private static String l = "bGlicXVpY2tqcy5zbw";
    private static String m = "bGlicXVpY2tqcy56aXA";
    private static String n = "eyd2JzoyLCdhJzoxLCczMic6J2h0dHBzOi8vcXpzLmdkdGltZy5jb20vdW5pb24vcmVzL3VuaW9uX2Nkbi9wYWdlL290aGVyL2xpYmdkdHFqc18yYTg4ZjIzZTIzYTFlN2ZhNjlkYzBjY2E2ZmZhZDY0Ny56aXAnLCc2NCc6J2h0dHBzOi8vcXpzLmdkdGltZy5jb20vdW5pb24vcmVzL3VuaW9uX2Nkbi9wYWdlL290aGVyL2xpYmdkdHFqc19hNzQ1NzVjM2QxODUzNjQzY2U3N2Y0YTgwY2Q1MWMxMC56aXAnfQA";
    private String c;
    private final int h;
    private final int i;
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final AtomicBoolean b = new AtomicBoolean(false);
    private int d = 0;
    private final ArrayList<e> e = new ArrayList<>();
    private int f = 999;
    private volatile CountDownLatch g = new CountDownLatch(1);

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ e a;
        final /* synthetic */ boolean b;

        a(e eVar, boolean z) {
            this.a = eVar;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a().a(this.a, this.b);
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f();
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.dynamic.c$c, reason: collision with other inner class name */
    class RunnableC0693c implements Runnable {
        RunnableC0693c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = c.this.e.iterator();
            while (it.hasNext()) {
                ((e) it.next()).b();
            }
            c.this.e.clear();
        }
    }

    /* compiled from: A */
    public interface e {
        void b();
    }

    private c() {
        try {
            byte[] bArrDecode = Base64.decode(k, 10);
            Charset charset = d6.a;
            k = new String(bArrDecode, charset);
            l = new String(Base64.decode(l, 10), charset);
            m = new String(Base64.decode(m, 10), charset);
            n = new String(Base64.decode(n, 10), charset);
        } catch (Exception unused) {
        }
        this.h = r1.d().f().a("selmit", 5000);
        this.i = r1.d().f().a("selmmit", 1000);
    }

    private void a(boolean z, boolean z2) {
        pro.getVresult(722, 0, this, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        pro.getVresult(723, 0, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HIT_CDN_CACHE, 0, this);
    }

    private void h() {
        this.b.compareAndSet(false, true);
        xo.a((Runnable) new RunnableC0693c());
    }

    private String d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return lz.c() ? jSONObject.optString("64") : jSONObject.optString("32");
        } catch (JSONException unused) {
            return null;
        }
    }

    public int b() {
        return this.f;
    }

    public void c() {
        a(true);
        CountDownLatch countDownLatch = this.g;
        if (countDownLatch != null) {
            countDownLatch.countDown();
            this.g = null;
        }
    }

    public boolean e() {
        return this.b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String strD = d(str);
        String strSubstring = strD.substring(strD.lastIndexOf(Config.replace) + 1, strD.lastIndexOf("."));
        StringBuilder sb = new StringBuilder();
        sb.append(gu.n());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(k);
        File file = new File(sb.toString());
        if (file.exists()) {
            if (TextUtils.equals(gp.a(file), strSubstring)) {
                return true;
            }
            file.delete();
        }
        File file2 = new File(gu.n() + str2 + l);
        if (!file2.exists()) {
            return false;
        }
        if (TextUtils.equals(gp.a(file2), strSubstring) && file2.renameTo(file)) {
            return true;
        }
        file2.delete();
        return false;
    }

    private boolean d() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private void c(String str) {
        String strD = d(str);
        File file = new File(gu.n() + File.separator + m);
        if (file.exists()) {
            file.delete();
        }
        fb.a().a(new gb.b().a(gu.n()).a(m).d(false).d(strD).b(false).a(), new d(str));
    }

    public void a(f5 f5Var) {
        CountDownLatch countDownLatch = this.g;
        if (countDownLatch == null) {
            return;
        }
        try {
            int i = d() ? this.i : this.h;
            if (countDownLatch.await(this.h, TimeUnit.MILLISECONDS)) {
                return;
            }
            b10.a(9130092, f5Var, Integer.valueOf(i), null);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static c a() {
        if (j == null) {
            synchronized (c.class) {
                if (j == null) {
                    j = new c();
                }
            }
        }
        return j;
    }

    private void a(boolean z) {
        if (z && !d() && !e()) {
            a(true, true);
        } else {
            a((e) null, z);
        }
    }

    public void a(e eVar, boolean z) {
        if (!d()) {
            xo.a((Runnable) new a(eVar, z));
            return;
        }
        if (e()) {
            if (eVar != null) {
                eVar.b();
            }
        } else {
            if (eVar != null) {
                this.e.add(eVar);
            }
            a(z, false);
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f = jSONObject.optInt("v", 0);
            String strOptString = jSONObject.optString("32");
            String strOptString2 = jSONObject.optString("64");
            this.d = jSONObject.optInt("a", 0);
            if (TextUtils.isEmpty(strOptString) || strOptString.lastIndexOf(Config.replace) == -1 || strOptString.lastIndexOf(".") == -1 || TextUtils.isEmpty(strOptString2) || strOptString2.lastIndexOf(Config.replace) == -1) {
                return false;
            }
            return strOptString2.lastIndexOf(".") != -1;
        } catch (JSONException unused) {
            return false;
        }
    }

    /* compiled from: A */
    class d extends ez {
        final /* synthetic */ String a;

        /* compiled from: A */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.g();
                c.this.a.compareAndSet(true, false);
            }
        }

        d(String str) {
            this.a = str;
        }

        @Override // com.qq.e.comm.plugin.ez, com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
            c.this.a.compareAndSet(true, false);
            gv.a(9130029, c.this.f, 4);
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            if (!s60.a(file.getAbsolutePath(), gu.n().getAbsolutePath())) {
                c.this.a.compareAndSet(true, false);
            } else if (c.this.b(this.a)) {
                qg.c.submit(new a());
            }
            file.delete();
        }
    }
}
