package com.qq.e.comm.plugin;

import android.content.Context;
import com.kuaishou.socket.nano.SocketMessages;
import com.qq.e.comm.plugin.m0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class o3 {
    private static final String f = "o3";
    private static final o3 g = new o3();
    private AtomicBoolean a = new AtomicBoolean(false);
    private AtomicInteger b = new AtomicInteger(0);
    private final Map<String, Long> e = new ConcurrentHashMap();
    private final m0 c = new m2();
    private final m0 d = new n00();

    private long a(Context context, String str) {
        return pro.getJresult(SocketMessages.PayloadType.SC_VOICE_PARTY_COMMON_INFO, 0, this, context, str);
    }

    static /* synthetic */ String a() {
        return (String) pro.getobjresult(SocketMessages.PayloadType.SC_VOICE_PARTY_ENTER_ROOM_NOTICE, 1, new Object[0]);
    }

    private void a(int i, j jVar, JSONObject jSONObject, int i2) {
        pro.getVresult(SocketMessages.PayloadType.SC_MIC_SEATS_INFO, 0, this, Integer.valueOf(i), jVar, jSONObject, Integer.valueOf(i2));
    }

    private void a(Context context, String str, long j, j jVar, int i) {
        pro.getVresult(SocketMessages.PayloadType.SC_MIC_SEATS_INVITATION_INFO, 0, this, context, str, Long.valueOf(j), jVar, Integer.valueOf(i));
    }

    private void a(Context context, String str, List<JSONObject> list, int i) {
        pro.getVresult(SocketMessages.PayloadType.SC_BET_CHANGED, 0, this, context, str, list, Integer.valueOf(i));
    }

    private void a(Context context, List<JSONObject> list, int i) {
        pro.getVresult(SocketMessages.PayloadType.SC_BET_CLOSED, 0, this, context, list, Integer.valueOf(i));
    }

    private void a(Context context, JSONArray jSONArray, int i) {
        pro.getVresult(443, 0, this, context, jSONArray, Integer.valueOf(i));
    }

    private void a(jn jnVar, String str, long j) {
        pro.getVresult(444, 0, this, jnVar, str, Long.valueOf(j));
    }

    static /* synthetic */ void a(o3 o3Var, Context context) {
        pro.getVresult(445, 1, o3Var, context);
    }

    static /* synthetic */ void a(o3 o3Var, Context context, String str, List list, int i) {
        pro.getVresult(446, 1, o3Var, context, str, list, Integer.valueOf(i));
    }

    static /* synthetic */ void a(o3 o3Var, Context context, List list, int i) {
        pro.getVresult(447, 1, o3Var, context, list, Integer.valueOf(i));
    }

    private void b(Context context, boolean z) {
        pro.getVresult(448, 0, this, context, Boolean.valueOf(z));
    }

    private void c(Context context) {
        pro.getVresult(449, 0, this, context);
    }

    public static o3 d() {
        return (o3) pro.getobjresult(450, 1, new Object[0]);
    }

    private void d(Context context) {
        pro.getVresult(451, 0, this, context);
    }

    private void e(Context context) {
        pro.getVresult(452, 0, this, context);
    }

    jn a(Context context) {
        return (jn) pro.getobjresult(453, 0, this, context);
    }

    public void a(Context context, boolean z) {
        pro.getVresult(454, 0, this, context, Boolean.valueOf(z));
    }

    public void a(String str, j jVar) {
        pro.getVresult(455, 0, this, str, jVar);
    }

    public void a(String str, boolean z) {
        pro.getVresult(456, 0, this, str, Boolean.valueOf(z));
    }

    public void b() {
        pro.getVresult(457, 0, this);
    }

    public void b(Context context) {
        pro.getVresult(458, 0, this, context);
    }

    public JSONObject c() {
        return (JSONObject) pro.getobjresult(459, 0, this);
    }

    public void e() {
        pro.getVresult(460, 0, this);
    }

    private o3() {
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o3.this.a(r1.d().a(), true);
        }
    }

    /* compiled from: A */
    class b implements m0.b {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // com.qq.e.comm.plugin.m0.b
        public void a(JSONObject jSONObject) {
            String strOptString = jSONObject.optString("sr");
            String strOptString2 = jSONObject.optString(com.kuaishou.weapon.p0.t.k);
            ArrayList arrayList = new ArrayList();
            o3.a(o3.this, this.a, strOptString, arrayList, 3);
            o3.a(o3.this, this.a, strOptString2, arrayList, 2);
            o3.a(o3.this, this.a, arrayList, 1);
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ Context a;

        c(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            o3.a(o3.this, this.a);
        }
    }

    /* compiled from: A */
    class d implements m0.b {
        final /* synthetic */ Context a;

        d(Context context) {
            this.a = context;
        }

        @Override // com.qq.e.comm.plugin.m0.b
        public void a(JSONObject jSONObject) {
            String strOptString = jSONObject.optString("s");
            ArrayList arrayList = new ArrayList();
            o3.a(o3.this, this.a, strOptString, arrayList, 1);
            o3.a(o3.this, this.a, arrayList, 2);
            yy.b("wlrt", System.currentTimeMillis());
        }
    }

    /* compiled from: A */
    class e extends hz {
        final /* synthetic */ int a;

        e(int i) {
            this.a = i;
        }

        @Override // com.qq.e.comm.plugin.hz
        public void a(aw awVar, int i, Exception exc) {
            o3.a();
            if (this.a == 2) {
                yy.a("wlrt");
            }
            b10.a(9200004, null, Integer.valueOf(this.a), Integer.valueOf(i), null);
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) {
            o3.a();
        }
    }
}
