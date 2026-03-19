package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.gb;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class l0 {
    private final File a;
    private final String b;
    private final boolean c;
    private File d;
    private String e;

    abstract void a(JSONObject jSONObject, boolean z);

    public l0(File file, String str, boolean z) {
        this.a = file;
        this.b = str;
        this.c = z;
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            String strD = gu.d(l0.this.d);
            if (l0.this.e.equals(gp.a(strD))) {
                if (l0.this.c) {
                    l0 l0Var = l0.this;
                    l0Var.a(l0Var.d, strD, true);
                    return;
                }
                return;
            }
            l0.this.d.delete();
            l0.this.a();
        }
    }

    void b() {
        int length;
        String str = this.b;
        if (str == null || (length = str.length()) < 40) {
            return;
        }
        this.e = this.b.substring(length - 32);
        File file = new File(this.a, this.e);
        this.d = file;
        if (!file.exists()) {
            a();
        } else {
            qg.b.submit(new a());
        }
    }

    /* compiled from: A */
    class b extends ez {
        b() {
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            if (file == null) {
                return;
            }
            l0.this.a(file, gu.d(file), false);
        }

        @Override // com.qq.e.comm.plugin.ez, com.qq.e.comm.plugin.bb
        public void a(db dbVar) throws JSONException {
            new qc(1190007).d(dbVar.a());
            ja jaVar = new ja();
            jaVar.a("ot", dbVar.getMessage());
            jaVar.a("rs", l0.this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            file.delete();
            return;
        }
        try {
            a(new JSONObject(str), z);
        } catch (JSONException unused) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        fb.a().a(new gb.b().d(this.b).a(this.a).a(this.e).b(false).d(false).a(), new b());
    }
}
