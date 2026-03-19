package com.baidu.mobstat.forbes;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.baidu.mobstat.forbes.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class q {
    private static q b = new q();
    private static String n = "";
    public a a;
    private Handler d;
    private volatile int e;
    private int f;
    private int p;
    private HandlerThread c = new HandlerThread("fullTraceHandleThread");
    private JSONObject g = new JSONObject();
    private JSONArray h = new JSONArray();
    private JSONArray i = new JSONArray();
    private JSONArray j = new JSONArray();
    private JSONArray k = new JSONArray();
    private JSONArray l = new JSONArray();
    private JSONArray m = new JSONArray();
    private boolean o = false;
    private List<JSONObject> q = new ArrayList();
    private List<String> r = new ArrayList();
    private List<String> s = new ArrayList();

    public interface a {
        void a(JSONObject jSONObject);
    }

    public static q a() {
        return b;
    }

    private q() {
        this.c.start();
        this.c.setPriority(10);
        this.d = new Handler(this.c.getLooper());
    }

    public int b() {
        return this.f;
    }

    public boolean c() {
        return this.o;
    }

    public void a(Context context) throws JSONException {
        String str;
        JSONObject jSONObject;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        JSONArray jSONArrayOptJSONArray3;
        JSONArray jSONArrayOptJSONArray4;
        if (context == null) {
            return;
        }
        try {
            this.o = true;
            g();
            str = ar.l(context) + Config.STAT_FULL_CACHE_FILE_NAME;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!aj.c(context, str)) {
            return;
        }
        String strA = aj.a(context, str);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        try {
            jSONObject = new JSONObject(strA);
        } catch (Exception e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        try {
            jSONArrayOptJSONArray = jSONObject.optJSONArray(Config.EVENT_PART);
            jSONArrayOptJSONArray2 = jSONObject.optJSONArray(Config.PRINCIPAL_PART);
            jSONArrayOptJSONArray3 = jSONObject.optJSONArray(Config.FEED_LIST_PART);
            jSONArrayOptJSONArray4 = jSONObject.optJSONArray("sv");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if ((jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) || ((jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() != 0) || ((jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() != 0) || (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() != 0)))) {
            b(context, jSONObject.getJSONObject(Config.HEADER_PART));
            c(context, jSONObject);
            d(jSONObject);
            strA = jSONObject.toString();
            if (aa.c().b()) {
                aa.c().a("saveLastCacheToSend content: " + strA);
            }
            c(context, strA);
            c(context, false);
            this.o = false;
            return;
        }
        if (aa.c().b()) {
            aa.c().a("saveLastCacheToSend content:empty, return");
        }
    }

    public void a(Context context, String str, String str2, String str3, int i, long j, String str4, JSONArray jSONArray, String str5, JSONArray jSONArray2, String str6, Map<String, String> map, JSONObject jSONObject, String str7, JSONArray jSONArray3, JSONObject jSONObject2) {
        a(context, str, str2, str3, i, j, str4, jSONArray, str5, jSONArray2, str6, map, false, jSONObject, str7, jSONArray3, jSONObject2);
    }

    public void a(final Context context, final String str, final String str2, final String str3, final int i, final long j, final String str4, final JSONArray jSONArray, final String str5, final JSONArray jSONArray2, final String str6, final Map<String, String> map, final boolean z, final JSONObject jSONObject, final String str7, final JSONArray jSONArray3, final JSONObject jSONObject2) {
        if (!ap.a().f()) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.forbes.q.1
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                long sessionStartTime = BDStatCore.instance().getSessionStartTime();
                if (sessionStartTime > 0) {
                    q.this.a(context, sessionStartTime, str, str2, str3, i, j, str4, jSONArray, str5, jSONArray2, str6, map, z, jSONObject, str7, jSONArray3, jSONObject2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j, String str, String str2, String str3, int i, long j2, String str4, JSONArray jSONArray, String str5, JSONArray jSONArray2, String str6, Map<String, String> map, boolean z, JSONObject jSONObject, String str7, JSONArray jSONArray3, JSONObject jSONObject2) throws JSONException {
        JSONObject event = EventAnalysis.getEvent(context, j, str, str2, str3, i, j2, 0L, "", null, null, ae.a(str4), ae.a(str5), str6, Config.EventViewType.EDIT.getValue(), 3, null, map, ae.c(jSONArray), ae.d(jSONArray2), z, jSONObject, str7, jSONArray3);
        if (event != null && jSONObject2 != null) {
            try {
                event.put(Config.EVENT_SDK_NAME, jSONObject2.optString(Config.EVENT_SDK_NAME, ""));
                event.put(Config.EVENT_LOGO_PROD, jSONObject2.optString(Config.EVENT_LOGO_PROD, ""));
                event.put(Config.EVENT_AD_PROD, jSONObject2.optString(Config.EVENT_AD_PROD, ""));
                event.put(Config.EVENT_AD_FEED_CLASS, jSONObject2.optString(Config.EVENT_AD_FEED_CLASS, ""));
                event.put(Config.EVENT_SDK_SHAKE, jSONObject2.optString(Config.EVENT_SDK_SHAKE, "false"));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        a(context, event);
        c(context);
        try {
            if (this.h.length() >= CooperService.instance().getEvAutoSize()) {
                p.a(context, false);
                LogSender.instance().onSend(context);
            }
        } catch (Throwable th2) {
        }
    }

    private void a(Context context, JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        if (aa.c().b()) {
            aa.c().a("putEvent: " + jSONObject.toString());
        }
        String string = jSONObject.toString();
        if (b(context, string)) {
            if (aa.c().b()) {
                aa.c().a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + string.length());
            }
            d(context);
        }
        try {
            jSONObject.put(Config.EVENT_NEXT_PAGENAME, "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        EventAnalysis.doEventMerge(this.h, jSONObject);
        if (this.p <= 0) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("l");
            if (!TextUtils.isEmpty(strOptString)) {
                if (this.q.size() >= this.p) {
                    this.q.remove(0);
                }
                this.q.add(jSONObject);
            }
            String strOptString2 = jSONObject.optString("content");
            if (!TextUtils.isEmpty(strOptString2) && strOptString2.contains("广告")) {
                if (this.r.size() >= this.p) {
                    this.r.remove(0);
                }
                this.r.add(strOptString2);
            } else if (!TextUtils.isEmpty(strOptString) && strOptString.contains("广告")) {
                if (this.r.size() >= this.p) {
                    this.r.remove(0);
                }
                this.r.add(strOptString);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean b(Context context, String str) {
        int length;
        if (str == null) {
            length = 0;
        } else {
            length = str.getBytes().length;
        }
        return length + this.e > 51200;
    }

    public void a(final Context context, final boolean z) {
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.forbes.q.2
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                q.this.b(context, z);
            }
        });
    }

    public void a(final JSONObject jSONObject) {
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.forbes.q.3
            @Override // java.lang.Runnable
            public void run() {
                if (jSONObject == null || jSONObject.length() == 0) {
                    return;
                }
                q.this.k = q.this.b(q.this.k, jSONObject);
            }
        });
    }

    public void b(JSONObject jSONObject) {
        this.i.put(jSONObject);
    }

    public void c(JSONObject jSONObject) {
        this.j.put(jSONObject);
    }

    public void b(Context context, boolean z) throws JSONException {
        try {
            if (z) {
                g();
            } else {
                f();
            }
            try {
                b(context, this.g);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.h.length() == 0 && this.k.length() == 0 && this.l.length() == 0 && this.m.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.HEADER_PART, this.g);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put(Config.PRINCIPAL_PART, this.k);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject.put(Config.EVENT_PART, this.h);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put(Config.ACTIVITY_LIFE_CYCLE_PART, this.i);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put(Config.BQT_MESSAGE, this.j);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put(Config.FEED_LIST_PART, this.l);
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put("sv", this.m);
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put(Config.EVENT_PAGE_MAPPING, o.a().a(o.a.b));
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put(Config.EVENT_PATH_MAPPING, o.a().a(o.a.a));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            jSONObject.put("sd", o.a().a(o.a.c));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put(Config.PYD, n);
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        c(context, jSONObject);
        d(jSONObject);
        String string = jSONObject.toString();
        if (aa.c().b()) {
            aa.c().a("saveCurrentCacheToSend content: " + string);
        }
        c(context, string);
        c(context, !z);
        this.o = true;
    }

    public void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            n = str;
        } catch (Exception e) {
        }
    }

    public void c(Context context, boolean z) throws JSONException {
        this.g = new JSONObject();
        b(context);
        try {
            this.g.put(Config.CUID_SEC, "");
            this.g.put(Config.OTHER_ID, "");
        } catch (JSONException e) {
        }
        this.k = new JSONArray();
        this.h = new JSONArray();
        this.l = new JSONArray();
        this.m = new JSONArray();
        this.i = new JSONArray();
        this.j = new JSONArray();
        if (!z) {
            o.a().b();
        }
        c(context);
    }

    public void b(Context context) {
        CooperService.instance().getHeadObject().installHeader(context, this.g);
    }

    public void c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.HEADER_PART, new JSONObject(this.g.toString()));
                jSONObject.put(Config.PRINCIPAL_PART, new JSONArray(this.k.toString()));
                jSONObject.put(Config.EVENT_PART, new JSONArray(this.h.toString()));
                jSONObject.put(Config.ACTIVITY_LIFE_CYCLE_PART, new JSONArray(this.i.toString()));
                jSONObject.put(Config.BQT_MESSAGE, new JSONArray(this.j.toString()));
                jSONObject.put(Config.FEED_LIST_PART, new JSONArray(this.l.toString()));
                jSONObject.put("sv", new JSONArray(this.m.toString()));
                jSONObject.put(Config.PYD, n);
                jSONObject.put(Config.EVENT_PAGE_MAPPING, o.a().a(o.a.b));
                jSONObject.put(Config.EVENT_PATH_MAPPING, o.a().a(o.a.a));
                jSONObject.put("sd", o.a().a(o.a.c));
            } catch (Exception e) {
                e.printStackTrace();
            }
            String string = jSONObject.toString();
            int length = string.getBytes().length;
            if (length >= 51200) {
                return;
            }
            this.e = length;
            aj.a(context, ar.l(context) + Config.STAT_FULL_CACHE_FILE_NAME, string, false);
        } catch (Throwable th) {
            th.printStackTrace();
            StatService.closeTrace();
        }
    }

    private void b(Context context, JSONObject jSONObject) throws JSONException {
        CooperService.instance().getHeadObject().installHeader(context, jSONObject);
        try {
            jSONObject.put("t", System.currentTimeMillis());
            jSONObject.put(Config.SEQUENCE_INDEX, this.f);
            jSONObject.put("ss", BDStatCore.instance().getSessionStartTime());
            jSONObject.put("at", "1");
            jSONObject.put(Config.OTHER_ID, ap.a().b());
            jSONObject.put(Config.CUID_SEC, ap.a().c());
            jSONObject.put(Config.SID, ap.a().a(context));
            jSONObject.put("sign", CooperService.instance().getUUID());
            jSONObject.put(Config.PY, DataCore.instance().getHeadSessionPy());
            jSONObject.put(Config.PLT, CooperService.instance().getPlatformType());
        } catch (Exception e) {
        }
    }

    private void d(Context context) throws JSONException {
        this.k = b(this.k, BDStatCore.instance().getPageSessionHead());
        b(context, false);
        f();
    }

    private void f() {
        this.f++;
    }

    private void g() {
        this.f = 0;
    }

    private void c(Context context, JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
        } catch (Exception e) {
        }
        try {
            jSONObject.put(Config.TRACE_PART, jSONObject2);
        } catch (Exception e2) {
        }
    }

    private void d(JSONObject jSONObject) {
    }

    private void c(Context context, String str) {
        LogSender.instance().saveLogData(context, str, true);
        if (this.a != null) {
            try {
                this.a.a(new JSONObject(str));
            } catch (Exception e) {
            }
        }
    }

    public void a(final Context context, final i iVar) {
        if (CooperService.instance().isCloseTrace() || !ap.a().f()) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.forbes.q.4
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                if (BDStatCore.instance().getSessionStartTime() > 0) {
                    q.this.b(context, iVar);
                }
            }
        });
    }

    public void a(final Context context, final ArrayList<j> arrayList) {
        if (CooperService.instance().isCloseTrace() || !ap.a().f()) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.forbes.q.5
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                q.this.c(context, (ArrayList<j>) arrayList);
            }
        });
    }

    public void b(final Context context, final ArrayList<k> arrayList) {
        if (CooperService.instance().isCloseTrace() || !ap.a().f()) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.baidu.mobstat.forbes.q.6
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                q.this.d(context, (ArrayList<k>) arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, i iVar) throws JSONException {
        if (context == null || iVar == null) {
            return;
        }
        this.k = b(this.k, BDStatCore.instance().getPageSessionHead());
        if (this.k.length() == 0) {
            return;
        }
        long jA = a(this.k);
        if (jA <= 0) {
            return;
        }
        d(context, iVar.a(jA, o.a().a(iVar.a(), o.a.b), o.a().a(iVar.b(), o.a.c)));
        c(context);
    }

    private void d(Context context, JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        if (aa.c().b()) {
            aa.c().a("putPage: " + jSONObject.toString());
        }
        String string = jSONObject.toString();
        if (b(context, string)) {
            if (aa.c().b()) {
                aa.c().a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + string.length());
            }
            d(context);
        }
        a(this.k, jSONObject);
    }

    private void a(JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        JSONArray jSONArrayOptJSONArray = null;
        try {
            jSONObject2 = jSONArray.getJSONObject(0);
        } catch (Exception e) {
            jSONObject2 = null;
        }
        if (jSONObject2 != null) {
            try {
                jSONArrayOptJSONArray = jSONObject2.optJSONArray("p");
            } catch (Exception e2) {
            }
        }
        if (jSONArrayOptJSONArray == null) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject);
            if (jSONObject2 != null) {
                try {
                    jSONObject2.put("p", jSONArray2);
                    return;
                } catch (Exception e3) {
                    return;
                }
            }
            return;
        }
        jSONArrayOptJSONArray.put(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONArray b(org.json.JSONArray r6, org.json.JSONObject r7) throws org.json.JSONException {
        /*
            r5 = this;
            if (r7 == 0) goto L71
            if (r6 != 0) goto L6
            goto L71
        L6:
            java.lang.String r0 = "s"
            long r0 = r7.optLong(r0)
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L13
            return r6
        L13:
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            int r1 = r6.length()
            java.lang.String r2 = "p"
            r3 = 0
            if (r1 != 0) goto L3f
        L22:
            java.lang.String r6 = r7.toString()     // Catch: java.lang.Exception -> L37
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Exception -> L37
            r7.<init>(r6)     // Catch: java.lang.Exception -> L37
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch: java.lang.Exception -> L34
            r6.<init>()     // Catch: java.lang.Exception -> L34
            r7.put(r2, r6)     // Catch: java.lang.Exception -> L34
            goto L39
        L34:
            r6 = move-exception
            r3 = r7
            goto L38
        L37:
            r6 = move-exception
        L38:
            r7 = r3
        L39:
            if (r7 == 0) goto L3e
            r0.put(r7)
        L3e:
            goto L70
        L3f:
            r1 = 0
            org.json.JSONObject r6 = r6.getJSONObject(r1)     // Catch: java.lang.Exception -> L46
            goto L48
        L46:
            r6 = move-exception
            r6 = r3
        L48:
            if (r6 == 0) goto L53
            org.json.JSONArray r6 = r6.getJSONArray(r2)     // Catch: java.lang.Exception -> L50
            goto L54
        L50:
            r6 = move-exception
            r6 = r3
            goto L55
        L53:
            r6 = r3
        L54:
        L55:
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L69
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L69
            r1.<init>(r7)     // Catch: java.lang.Exception -> L69
            if (r6 == 0) goto L68
            r1.put(r2, r6)     // Catch: java.lang.Exception -> L65
            goto L68
        L65:
            r6 = move-exception
            r3 = r1
            goto L6a
        L68:
            goto L6b
        L69:
            r6 = move-exception
        L6a:
            r1 = r3
        L6b:
            if (r1 == 0) goto L70
            r0.put(r1)
        L70:
            return r0
        L71:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.q.b(org.json.JSONArray, org.json.JSONObject):org.json.JSONArray");
    }

    private long a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return 0L;
        }
        try {
            return jSONArray.getJSONObject(0).optLong("s");
        } catch (Exception e) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, ArrayList<j> arrayList) throws JSONException {
        if (context == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<j> it = arrayList.iterator();
        while (it.hasNext()) {
            j next = it.next();
            JSONObject jSONObjectA = next.a(o.a().a(next.a(), o.a.c));
            if (jSONObjectA != null) {
                jSONArray.put(jSONObjectA);
            }
        }
        a(context, jSONArray);
        c(context);
    }

    private void a(Context context, JSONArray jSONArray) throws JSONException {
        if (context == null || this.l == null || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        if (aa.c().b()) {
            aa.c().a("putFeedList: " + jSONArray.toString());
        }
        String string = jSONArray.toString();
        if (b(context, string)) {
            if (aa.c().b()) {
                aa.c().a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + string.length());
            }
            d(context);
        }
        a(this.l, jSONArray);
    }

    private void a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null || jSONArray2 == null) {
            return;
        }
        for (int i = 0; i < jSONArray2.length(); i++) {
            try {
                jSONArray.put(jSONArray2.getJSONObject(i));
            } catch (Exception e) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, ArrayList<k> arrayList) throws JSONException {
        if (context == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<k> it = arrayList.iterator();
        while (it.hasNext()) {
            k next = it.next();
            JSONObject jSONObjectA = next.a(o.a().a(next.b(), o.a.b), o.a().a(next.f(), o.a.c), ae.c(next.c()));
            if (jSONObjectA != null) {
                jSONArray.put(jSONObjectA);
            }
        }
        b(context, jSONArray);
        c(context);
    }

    private void b(Context context, JSONArray jSONArray) throws JSONException {
        if (context == null || this.m == null || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        if (aa.c().b()) {
            aa.c().a("putFeedListItem: " + jSONArray.toString());
        }
        String string = jSONArray.toString();
        if (b(context, string)) {
            if (aa.c().b()) {
                aa.c().a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + string.length());
            }
            d(context);
        }
        b(this.m, jSONArray);
    }

    private void b(JSONArray jSONArray, JSONArray jSONArray2) throws JSONException {
        JSONObject jSONObject;
        if (jSONArray == null || jSONArray2 == null) {
            return;
        }
        for (int i = 0; i < jSONArray2.length(); i++) {
            try {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                if (jSONObject2 != null && jSONObject2.length() != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            jSONObject = null;
                            break;
                        }
                        jSONObject = jSONArray.getJSONObject(i2);
                        if (jSONObject != null && jSONObject.length() != 0 && a(jSONObject, jSONObject2)) {
                            break;
                        }
                        i2++;
                    }
                    if (jSONObject == null) {
                        jSONArray.put(jSONObject2);
                    } else {
                        b(jSONObject, jSONObject2);
                    }
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    private boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return false;
        }
        String strOptString = jSONObject.optString("id");
        jSONObject.optString("d");
        String strOptString2 = jSONObject.optString("p");
        String strOptString3 = jSONObject.optString("path");
        String strOptString4 = jSONObject.optString("title");
        String strOptString5 = jSONObject.optString("index");
        String strOptString6 = jSONObject.optString("n");
        int iOptInt = jSONObject.optInt("user");
        jSONObject.optInt("c");
        jSONObject.optLong("t");
        jSONObject.optString("ps");
        String strOptString7 = jSONObject2.optString("id");
        jSONObject2.optString("d");
        String strOptString8 = jSONObject2.optString("p");
        String strOptString9 = jSONObject2.optString("path");
        String strOptString10 = jSONObject2.optString("title");
        String strOptString11 = jSONObject2.optString("index");
        String strOptString12 = jSONObject2.optString("n");
        int iOptInt2 = jSONObject2.optInt("user");
        jSONObject2.optInt("c");
        jSONObject2.optLong("t");
        jSONObject2.optString("ps");
        if (!a(strOptString, strOptString7) || !a(strOptString2, strOptString8) || !a(strOptString3, strOptString9) || !a(strOptString4, strOptString10) || !a(strOptString5, strOptString11) || !a(strOptString6, strOptString12) || iOptInt != iOptInt2) {
            return false;
        }
        return true;
    }

    private void b(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        String str;
        String str2;
        long jLongValue;
        long jLongValue2;
        String strOptString = jSONObject.optString("d");
        int iOptInt = jSONObject.optInt("c");
        long jOptLong = jSONObject.optLong("t");
        String str3 = "ps";
        String strOptString2 = jSONObject.optString("ps");
        String strOptString3 = jSONObject2.optString("d");
        int iOptInt2 = jSONObject2.optInt("c");
        long jOptLong2 = jSONObject2.optLong("t");
        String strOptString4 = jSONObject2.optString("ps");
        int i = iOptInt + iOptInt2;
        long j = jOptLong <= jOptLong2 ? jOptLong : jOptLong2;
        String str4 = jOptLong <= jOptLong2 ? strOptString + "|" + strOptString3 : strOptString3 + "|" + strOptString;
        long jLongValue3 = 0;
        if (jOptLong > jOptLong2) {
            str = "ps";
            long j2 = jOptLong - jOptLong2;
            StringBuilder sb = new StringBuilder();
            String[] strArrSplit = strOptString2.split("\\|");
            if (strArrSplit != null && strArrSplit.length != 0) {
                int i2 = 0;
                for (int length = strArrSplit.length; i2 < length; length = length) {
                    String str5 = strArrSplit[i2];
                    if (!TextUtils.isEmpty(sb.toString())) {
                        sb.append("|");
                    }
                    try {
                        jLongValue = Long.valueOf(str5).longValue();
                    } catch (Exception e) {
                        jLongValue = 0;
                    }
                    sb.append(j2 + jLongValue);
                    i2++;
                    strArrSplit = strArrSplit;
                }
            } else {
                try {
                    jLongValue3 = Long.valueOf(strOptString2).longValue();
                } catch (Exception e2) {
                }
                sb.append(j2 + jLongValue3);
            }
            str2 = strOptString4 + "|" + sb.toString();
        } else {
            long j3 = jOptLong2 - jOptLong;
            StringBuilder sb2 = new StringBuilder();
            String[] strArrSplit2 = strOptString4.split("\\|");
            if (strArrSplit2 == null || strArrSplit2.length == 0) {
                str = "ps";
                try {
                    jLongValue3 = Long.valueOf(strOptString4).longValue();
                } catch (Exception e3) {
                }
                sb2.append(j3 + jLongValue3);
            } else {
                int length2 = strArrSplit2.length;
                int i3 = 0;
                while (i3 < length2) {
                    String str6 = strArrSplit2[i3];
                    if (!TextUtils.isEmpty(sb2.toString())) {
                        sb2.append("|");
                    }
                    try {
                        jLongValue2 = Long.valueOf(str6).longValue();
                    } catch (Exception e4) {
                        jLongValue2 = 0;
                    }
                    sb2.append(j3 + jLongValue2);
                    i3++;
                    strArrSplit2 = strArrSplit2;
                    str3 = str3;
                }
                str = str3;
            }
            str2 = strOptString2 + "|" + sb2.toString();
        }
        try {
            jSONObject.put("c", i);
            jSONObject.put("t", j);
            jSONObject.put("d", str4);
            jSONObject.put(str, str2);
        } catch (Exception e5) {
        }
    }

    private boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(str2)) {
            return true;
        }
        return false;
    }

    public void a(int i) {
        this.p = i;
    }

    public String d() {
        if (this.q == null || this.q.size() == 0) {
            return "";
        }
        return this.q.toString();
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str) || this.p <= 0) {
            return;
        }
        if (this.s.size() >= this.p) {
            this.s.remove(0);
        }
        this.s.add(str);
    }

    public HashMap e() {
        HashMap map = new HashMap();
        if (this.r != null && this.r.size() > 0) {
            map.put("click", this.r.toString());
        }
        if (this.s != null && this.s.size() > 0) {
            map.put("view", this.s.toString());
        }
        return map;
    }

    public void a(Context context, String str) {
        if (this.h == null || this.h.length() == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            JSONObject jSONObject = (JSONObject) this.h.get(this.h.length() - 1);
            if (jSONObject != null) {
                String strOptString = jSONObject.optString(Config.EVENT_NEXT_PAGENAME);
                long jOptLong = jSONObject.optLong("t");
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - jOptLong <= 1500 && TextUtils.isEmpty(strOptString)) {
                    jSONObject.put(Config.EVENT_NEXT_PAGENAME, str + "|" + jCurrentTimeMillis);
                    this.h.put(this.h.length() - 1, jSONObject);
                    c(context);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
