package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.plugin.aw;
import com.qq.e.comm.plugin.rr;
import com.ss.ttm.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ro {
    private static final String c = "ro";
    private static volatile ro d;
    private JSONObject a;
    private String b;

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(h4 h4Var) {
        pro.getVresult(472, 0, this, h4Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h4 h4Var, WeakReference<View> weakReference) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_TRACK_INFO, 0, this, h4Var, weakReference);
    }

    public static ro b() {
        if (d == null) {
            synchronized (ro.class) {
                if (d == null) {
                    d = new ro();
                }
            }
        }
        return d;
    }

    private void e() {
        String strB = r1.d().f().b("ulrcfg", "");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        try {
            this.a = new JSONObject(strB);
        } catch (JSONException unused) {
        }
    }

    private ro() {
        e();
    }

    public boolean f() {
        JSONObject jSONObject = this.a;
        return jSONObject != null && jSONObject.length() > 0;
    }

    public void d() {
        if (f()) {
            a(null);
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ h4 a;
        final /* synthetic */ WeakReference b;

        a(h4 h4Var, WeakReference weakReference) {
            this.a = h4Var;
            this.b = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ro.this.a(this.a, (WeakReference<View>) this.b);
                ro.this.a(this.a);
            } catch (Throwable th) {
                ro.this.a(6000, 1004, th.getMessage());
                th.getMessage();
            }
        }
    }

    /* compiled from: A */
    class b extends hz {
        b() {
        }

        @Override // com.qq.e.comm.plugin.hz
        public void a(aw awVar, int i, Exception exc) {
            ro.this.a(i, 0, exc.getMessage());
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) {
            if (hwVar == null) {
                ro.this.a(6000, 1001, (String) null);
                return;
            }
            if (hwVar.a() != 200) {
                ro.this.a(3005, hwVar.a(), (String) null);
                return;
            }
            try {
                String strC = hwVar.c();
                if (TextUtils.isEmpty(strC)) {
                    ro.this.a(6000, 1002, (String) null);
                    return;
                }
                String unused = ro.c;
                JSONObject jSONObject = new JSONObject(strC);
                int iOptInt = jSONObject.optInt("code", -1);
                if (iOptInt != 0) {
                    ro.this.a(5001, iOptInt, jSONObject.optString("msg"));
                } else {
                    ro.this.a(0, 0, (String) null);
                }
            } catch (JSONException e) {
                ro.this.a(5000, 0, e.getMessage());
            } catch (Exception e2) {
                ro.this.a(6000, 1004, e2.getMessage());
            }
        }
    }

    public int c() {
        JSONObject jSONObject = this.a;
        if (jSONObject == null) {
            return 3000;
        }
        return jSONObject.optInt("gdtlpdur", 3000);
    }

    public boolean a(h4 h4Var, View view) {
        if (h4Var == null || view == null || h4Var.B1()) {
            return false;
        }
        h4Var.H1();
        qg.c.submit(new a(h4Var, new WeakReference(view)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        b10.a(9750000, null, Integer.valueOf(i2), Integer.valueOf(i), !TextUtils.isEmpty(str) ? new ja().a("msg", str) : null);
    }

    private void a(String str, Map<String, String> map) {
        sr.a().a(new cu(str, map, aw.a.POST), rr.a.Low, new b());
    }
}
