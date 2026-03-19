package ca.da.ca.ia;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import ca.da.ca.ia.d;
import ca.da.ca.ja.r;
import com.apm.applog.AppLog;
import com.baidu.mobstat.forbes.Config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Pack.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class i extends b {
    public byte[] l;
    public int m;
    public int n;
    public JSONArray o;
    public long p;
    public JSONArray q;
    public long r;
    public h s;
    public JSONArray t;
    public m u;
    public JSONObject v;
    public JSONArray w;
    public long x;
    public JSONArray y;

    public static byte[] a(ArrayList<b> arrayList, JSONObject jSONObject) {
        try {
            i iVar = new i();
            JSONArray[] jSONArrayArr = {new JSONArray(), new JSONArray(), null};
            long[] jArr = new long[3];
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (NotificationCompat.CATEGORY_EVENT.equals(next.e())) {
                    jSONArrayArr[0].put(next.g());
                } else if ("eventv3".equals(next.e())) {
                    jSONArrayArr[1].put(next.g());
                }
            }
            iVar.a(jSONObject, null, null, null, jSONArrayArr, jArr, null);
            return iVar.f().toString().getBytes();
        } catch (JSONException e) {
            r.a(e);
            return null;
        }
    }

    @Override // ca.da.ca.ia.b
    public List<String> b() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "_data", "blob", "_fail", TypedValues.Custom.S_INT);
    }

    @Override // ca.da.ca.ia.b
    public String d() {
        return String.valueOf(this.a);
    }

    @Override // ca.da.ca.ia.b
    public String e() {
        return "pack";
    }

    @Override // ca.da.ca.ia.b
    public JSONObject g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.v);
        jSONObject.put("time_sync", ca.da.ca.ba.a.b);
        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
        if (this.s != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.s.f());
            jSONObject.put(Config.LAUNCH, jSONArray);
        }
        m mVar = this.u;
        if (mVar != null) {
            JSONObject jSONObjectF = mVar.f();
            JSONArray jSONArray2 = this.t;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            for (int i = 0; i < length; i++) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(new JSONObject(this.t.optString(i)).optString("params"));
                jSONArray4.put(0, jSONObject2.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject2.optInt("duration", 0) + 999) / 1000);
                jSONArray3.put(jSONArray4);
            }
            if (length > 0) {
                jSONObjectF.put("activites", jSONArray3);
            }
            int i2 = AppLog.sLaunchFrom;
            if (i2 > 0) {
                jSONObjectF.put("launch_from", i2);
                AppLog.sLaunchFrom = 0;
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(jSONObjectF);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.o;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.o);
        }
        JSONArray jSONArray7 = this.t;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        ca.da.ca.da.b.f();
        JSONArray jSONArray8 = this.q;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.q);
        }
        JSONArray jSONArray9 = this.w;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put("log_data", this.w);
        }
        JSONArray jSONArray10 = this.y;
        int length6 = jSONArray10 != null ? jSONArray10.length() : 0;
        if (length6 > 0) {
            jSONObject.put("item_impression", this.y);
        }
        StringBuilder sb = new StringBuilder("pack {");
        sb.append("ts:").append(this.b);
        StringBuilder sbAppend = sb.append(", la:");
        Object obj = this.s;
        if (obj == null) {
            obj = "0";
        }
        sbAppend.append(obj);
        StringBuilder sbAppend2 = sb.append(", te:");
        m mVar2 = this.u;
        sbAppend2.append(mVar2 != null ? mVar2 : "0");
        sb.append(", p:").append(length3);
        sb.append(", v1:").append(length2);
        sb.append(", v3:").append(length4);
        sb.append(", m:").append(length5);
        sb.append(", imp:").append(length6).append(com.alipay.sdk.m.u.i.d);
        r.a(sb.toString());
        return jSONObject;
    }

    public boolean h() {
        return this.s != null;
    }

    public byte[] i() {
        this.l = null;
        try {
            byte[] bArrA = ca.da.ca.ha.b.a(f().toString());
            this.l = bArrA;
            return bArrA;
        } catch (OutOfMemoryError e) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                d.b[] bVarArr = d.f;
                if (i >= bVarArr.length) {
                    throw new RuntimeException(sb.toString(), e);
                }
                d.b bVar = bVarArr[i];
                if (bVar != null) {
                    sb.append(bVar.toString()).append(com.alipay.sdk.m.u.i.b);
                }
                i++;
            }
        }
    }

    @Override // ca.da.ca.ia.b
    public void b(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.b));
        contentValues.put("_data", i());
    }

    public void a(JSONObject jSONObject, h hVar, m mVar, JSONArray jSONArray, JSONArray[] jSONArrayArr, long[] jArr, JSONArray jSONArray2) {
        a(0L);
        this.v = jSONObject;
        this.s = hVar;
        this.u = mVar;
        this.t = jSONArray;
        this.o = jSONArrayArr[0];
        this.p = jArr[0];
        this.q = jSONArrayArr[1];
        this.r = jArr[1];
        this.w = jSONArrayArr[2];
        this.x = jArr[2];
        this.y = jSONArray2;
    }

    @Override // ca.da.ca.ia.b
    public int a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.l = cursor.getBlob(2);
        this.m = cursor.getInt(3);
        this.d = "";
        this.v = null;
        this.s = null;
        this.u = null;
        this.t = null;
        this.o = null;
        this.q = null;
        this.w = null;
        this.y = null;
        return 4;
    }

    @Override // ca.da.ca.ia.b
    public b a(JSONObject jSONObject) {
        r.a((Throwable) null);
        return null;
    }
}
