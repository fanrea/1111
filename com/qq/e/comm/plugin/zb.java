package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.plugin.aw;
import com.qq.e.comm.plugin.gb;
import com.qq.e.comm.plugin.rr;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class zb {
    protected String a;

    /* compiled from: A */
    public interface c {
        void a(int i, String str);

        void a(String str, byte[] bArr);
    }

    public zb() {
        a();
    }

    /* compiled from: A */
    class a implements qr {
        final /* synthetic */ File a;

        a(File file) {
            this.a = file;
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, Exception exc) {
            exc.getMessage();
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) {
            if (hwVar.a() == 200) {
                try {
                    String strC = hwVar.c();
                    if (TextUtils.isEmpty(strC)) {
                        return;
                    }
                    zb.this.a(strC, true);
                    gu.c(this.a, strC);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
    }

    /* compiled from: A */
    class b extends ez {
        final /* synthetic */ AtomicBoolean a;
        final /* synthetic */ CountDownLatch b;
        final /* synthetic */ AtomicReference c;

        b(AtomicBoolean atomicBoolean, CountDownLatch countDownLatch, AtomicReference atomicReference) {
            this.a = atomicBoolean;
            this.b = countDownLatch;
            this.c = atomicReference;
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            this.a.set(true);
            this.b.countDown();
        }

        @Override // com.qq.e.comm.plugin.ez, com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
            dbVar.b();
            this.a.set(false);
            this.c.set(dbVar);
            this.b.countDown();
        }
    }

    public void b(File file, c cVar) throws Throwable {
        String strD = gu.d(file);
        String strA = "";
        String message = TextUtils.isEmpty(strD) ? "File Content Empty" : "";
        try {
            strA = a(strD);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (!TextUtils.isEmpty(strA)) {
            cVar.a(strA, (byte[]) null);
        } else {
            file.delete();
            cVar.a(6000, message);
        }
    }

    public void b() {
        String strB = r1.d().f().b("espju", "");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        String strD = gu.d(strB);
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        File file = new File(gu.f(), strD);
        String strD2 = gu.d(new File(gu.f(), strD));
        if (!TextUtils.isEmpty(strD2)) {
            a(strD2, false);
        } else {
            sr.a().a(new cu(strB, aw.a.GET, (byte[]) null), rr.a.High, new a(file));
        }
    }

    private String b(String str) {
        return str + "_bc_" + com.qq.e.comm.dynamic.c.a().b();
    }

    protected String a(String str) throws Exception {
        return lx.b(str);
    }

    private void a(String str, ez ezVar) {
        if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(str)) {
            fb.a().a(new gb.b().a(gu.f()).d(String.format("%s%s", this.a, str)).d(false).b(false).a(str).a(), ezVar);
        } else if (ezVar != null) {
            ezVar.a(new db(4, ""));
        }
    }

    protected void a() {
        try {
            this.a = new String(Base64.decode("aHR0cHM6Ly9xenMuZ2R0aW1nLmNvbS91bmlvbi9yZXMvdW5pb25fY2RuL3BhZ2Uvb3RoZXIv", 0), d6.a);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public boolean a(File file, c cVar) {
        try {
            byte[] bArrD = lx.d(gu.e(file));
            if (bArrD == null || bArrD.length <= 0) {
                return false;
            }
            cVar.a((String) null, bArrD);
            return true;
        } catch (Exception e) {
            file.delete();
            e.getMessage();
            return false;
        }
    }

    public void a(String str, boolean z, c cVar) {
        File fileF = gu.f();
        if (z && a(new File(fileF, b(str)), cVar)) {
            return;
        }
        File file = new File(fileF, str);
        if (file.exists()) {
            b(file, cVar);
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        AtomicReference atomicReference = new AtomicReference();
        a(str, new b(atomicBoolean, countDownLatch, atomicReference));
        try {
            countDownLatch.await(2L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        if (atomicBoolean.get()) {
            b(file, cVar);
            return;
        }
        db dbVar = (db) atomicReference.get();
        if (dbVar != null) {
            cVar.a(dbVar.a(), dbVar.b());
        } else {
            cVar.a(6000, "Unknown Error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        JSONArray jSONArrayOptJSONArray;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("p");
            if (!TextUtils.isEmpty(strOptString)) {
                this.a = strOptString;
            }
            if (z && (jSONArrayOptJSONArray = jSONObject.optJSONArray("sl")) != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    a(jSONArrayOptJSONArray.optString(i), (ez) null);
                }
            }
        } catch (JSONException e) {
            e.getMessage();
        }
    }

    public boolean a(String str, byte[] bArr) {
        try {
            return gu.c(new File(gu.f(), b(str)), lx.c(bArr));
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
