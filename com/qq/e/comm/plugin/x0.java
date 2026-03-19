package com.qq.e.comm.plugin;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class x0 implements bm {
    private static final Pattern d = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");
    protected final jm a;
    protected final e b = new e();
    protected final d c = new d();

    public x0(jm jmVar) {
        this.a = jmVar;
    }

    @Override // com.qq.e.comm.plugin.bm
    public bm a(c30 c30Var) {
        if (c30Var != null) {
            this.c.a(c30Var.a(), c30Var);
        }
        return this;
    }

    /* compiled from: A */
    public static class d {
        private Map<String, c30> a = new HashMap();

        void a(String str, c30 c30Var) {
            if (TextUtils.isEmpty(str) || c30Var == null) {
                return;
            }
            this.a.put(str, c30Var);
        }

        public c30 a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.a.get(str);
        }
    }

    /* compiled from: A */
    public static class e {
        private Map<String, e30> a = new HashMap();

        void a(String str, e30 e30Var) {
            if (TextUtils.isEmpty(str) || e30Var == null) {
                return;
            }
            this.a.put(str, e30Var);
        }

        public e30 a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.a.get(str);
        }
    }

    @Override // com.qq.e.comm.plugin.bm
    public bm a(String str, e30 e30Var) {
        this.b.a(str, e30Var);
        return this;
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ tg a;

        a(tg tgVar) {
            this.a = tgVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                x0.this.a.a(this.a.a());
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ vg a;

        b(vg vgVar) {
            this.a = vgVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                x0.this.a.a(this.a.a());
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ sg a;

        c(sg sgVar) {
            this.a = sgVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                x0.this.a.a(this.a.a());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.qq.e.comm.plugin.bm
    public void a(sg sgVar) {
        if (sgVar != null) {
            new Handler(Looper.getMainLooper()).post(new c(sgVar));
        }
    }

    public void a(String... strArr) {
        a(new tg("bridge.onReceived", strArr));
    }

    protected ug a(Uri uri) throws NumberFormatException {
        if (uri == null) {
            return null;
        }
        Matcher matcher = d.matcher(uri.getPath());
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        String strGroup3 = matcher.group(3);
        String queryParameter = uri.getQueryParameter(com.baidu.mobads.container.adrequest.g.q);
        String queryParameter2 = uri.getQueryParameter("t1");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(queryParameter2)) {
            try {
                jCurrentTimeMillis = Long.parseLong(queryParameter2);
            } catch (NumberFormatException unused) {
            }
        }
        if ("multiAction".equals(strGroup)) {
            return new ug(strGroup2, strGroup, strGroup3, null, queryParameter, jCurrentTimeMillis);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(queryParameter)) {
                jSONObject = new JSONObject(queryParameter);
            }
            return new ug(strGroup2, strGroup, strGroup3, jSONObject, jCurrentTimeMillis);
        } catch (JSONException unused2) {
            return null;
        }
    }

    public void a(tg tgVar) {
        if (tgVar != null) {
            new Handler(Looper.getMainLooper()).post(new a(tgVar));
        }
    }

    @Override // com.qq.e.comm.plugin.bm
    public void a(vg vgVar) {
        if (vgVar != null) {
            new Handler(Looper.getMainLooper()).post(new b(vgVar));
        }
    }
}
