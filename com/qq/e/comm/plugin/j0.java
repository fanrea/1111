package com.qq.e.comm.plugin;

import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.plugin.gb;
import java.io.File;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class j0 {
    private JSONObject b;
    private String f;
    private String g;
    private String h;
    private String i;
    private final AtomicInteger j;
    private String k;
    private String l;
    private final AtomicBoolean a = new AtomicBoolean(false);
    private int c = 0;
    private final Queue<c> d = new ConcurrentLinkedQueue();
    private int e = -1;

    /* compiled from: A */
    public interface c {
        void a(boolean z);

        void b();
    }

    private int a(JSONObject jSONObject, boolean z) {
        return pro.getIresult(395, 0, this, jSONObject, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        pro.getVresult(396, 0, this, Boolean.valueOf(z));
    }

    private boolean i() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        pro.getVresult(397, 0, this);
    }

    private void l() {
        pro.getVresult(398, 0, this);
    }

    protected abstract int d();

    protected abstract String e();

    protected abstract String f();

    protected abstract int g();

    private void b() {
        File fileN = gu.n();
        File file = new File(fileN, this.h);
        if (file.exists()) {
            file.delete();
        }
        fb.a().a(new gb.b().a(fileN).a(this.h).d(false).d(this.k).b(false).a(), new b(fileN));
    }

    protected j0(String str, String str2, String str3) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.j = atomicInteger;
        try {
            this.f = m10.a(str);
            this.g = m10.a(str2);
            this.i = m10.a(str3);
            atomicInteger.compareAndSet(0, 1);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.a(this.a);
        }
    }

    public final boolean j() {
        return this.j.get() == 7;
    }

    private JSONObject c() {
        String strF = f();
        try {
            if (!TextUtils.isEmpty(strF)) {
                JSONObject jSONObject = new JSONObject(strF);
                int iOptInt = jSONObject.optInt("v", 0);
                int iOptInt2 = jSONObject.optInt("msv", Integer.MAX_VALUE);
                int iG = g();
                if (iOptInt2 <= iG && iOptInt >= iG) {
                    return jSONObject;
                }
            }
        } catch (JSONException e) {
            e();
            e.getMessage();
        }
        try {
            return new JSONObject(this.i);
        } catch (JSONException e2) {
            e();
            e2.getMessage();
            return null;
        }
    }

    private void m() {
        this.j.compareAndSet(2, 7);
        this.a.compareAndSet(false, true);
        while (true) {
            c cVarPoll = this.d.poll();
            if (cVarPoll == null) {
                return;
            } else {
                cVarPoll.b();
            }
        }
    }

    /* compiled from: A */
    class b extends ez {
        final /* synthetic */ File a;

        b(File file) {
            this.a = file;
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            if (s60.a(file.getAbsolutePath(), this.a.getAbsolutePath())) {
                if (!j0.this.a()) {
                    j0.this.a(3);
                    j0.this.a(9130104, "invalid");
                } else {
                    qg.c.submit(new a());
                }
            } else {
                j0.this.a(3);
                j0.this.a(9130104, "unzip error");
            }
            file.delete();
        }

        /* compiled from: A */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j0.this.k();
            }
        }

        @Override // com.qq.e.comm.plugin.ez, com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
            j0.this.a(3);
            j0.this.a(9130104, dbVar.a() + "#" + dbVar.b());
        }
    }

    public int h() {
        return this.j.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.j.compareAndSet(2, i);
        this.a.compareAndSet(true, false);
        while (true) {
            c cVarPoll = this.d.poll();
            if (cVarPoll == null) {
                return;
            } else {
                cVarPoll.a(i == 3);
            }
        }
    }

    public final void a(c cVar, boolean z) {
        if (this.j.get() == 0) {
            if (cVar != null) {
                cVar.a(false);
                return;
            }
            return;
        }
        if (j()) {
            if (cVar != null) {
                cVar.b();
                return;
            }
            return;
        }
        if (cVar != null) {
            this.d.add(cVar);
        }
        if (this.a.compareAndSet(false, true)) {
            this.j.set(2);
            if (z && !i()) {
                a(true);
            } else {
                qg.c.submit(new a(z));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        b10.a(i, null, Integer.valueOf(this.e), Integer.valueOf(d()), !TextUtils.isEmpty(str) ? new ja().a("msg", str) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        File file = new File(gu.n(), this.f);
        if (file.exists()) {
            if (TextUtils.equals(gp.a(file), this.l)) {
                return true;
            }
            file.delete();
        }
        if (TextUtils.equals(this.f, this.g)) {
            return false;
        }
        File file2 = new File(gu.n(), this.g);
        if (file2.exists()) {
            if (TextUtils.equals(gp.a(file2), this.l) && file2.renameTo(file)) {
                return true;
            }
            file2.delete();
        }
        return false;
    }
}
