package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.aw;
import com.qq.e.comm.plugin.rr;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class m0 {
    private static final String c = "m0";
    private volatile JSONObject a;
    private final AtomicBoolean b = new AtomicBoolean(false);

    /* compiled from: A */
    interface b {
        void a(JSONObject jSONObject);
    }

    protected abstract String b();

    protected abstract int c();

    protected abstract String d();

    m0() {
    }

    /* compiled from: A */
    class a extends hz {
        final /* synthetic */ b a;
        final /* synthetic */ File b;

        a(b bVar, File file) {
            this.a = bVar;
            this.b = file;
        }

        @Override // com.qq.e.comm.plugin.hz
        public void a(aw awVar, int i, Exception exc) {
            String unused = m0.c;
            exc.getMessage();
            m0 m0Var = m0.this;
            m0Var.a(m0Var.b(), this.a);
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) {
            int iA = hwVar.a();
            if (iA == 200) {
                try {
                    String strC = hwVar.c();
                    if (!TextUtils.isEmpty(strC)) {
                        m0.this.a(strC, this.a);
                        synchronized (m0.class) {
                            gu.c(this.b, strC);
                        }
                        return;
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            } else {
                b10.a(9200019, null, Integer.valueOf(m0.this.c()), Integer.valueOf(iA), null);
            }
            m0 m0Var = m0.this;
            m0Var.a(m0Var.b(), this.a);
        }
    }

    void a(b bVar) throws Throwable {
        if (this.b.get()) {
            if (bVar != null) {
                bVar.a(this.a);
                return;
            }
            return;
        }
        String strD = d();
        if (TextUtils.isEmpty(strD)) {
            a(b(), bVar);
            return;
        }
        String strD2 = gu.d(strD);
        if (TextUtils.isEmpty(strD2)) {
            a(b(), bVar);
            return;
        }
        File file = new File(gu.c(), strD2);
        String strD3 = gu.d(file);
        if (!TextUtils.isEmpty(strD3)) {
            a(strD3, bVar);
        } else {
            sr.a().a(new cu(strD, aw.a.GET, (byte[]) null), rr.a.High, new a(bVar, file));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, b bVar) {
        if (str != b() || this.a == null) {
            try {
                String strB = lx.b(str);
                if (!TextUtils.isEmpty(strB)) {
                    this.a = new JSONObject(strB);
                    if (str != b()) {
                        this.b.set(true);
                    }
                }
            } catch (Exception unused) {
            }
            if (this.a == null) {
                this.a = new JSONObject();
            }
        }
        if (bVar != null) {
            bVar.a(this.a);
        }
    }
}
