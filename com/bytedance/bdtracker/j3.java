package com.bytedance.bdtracker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.bdtracker.l0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class j3 implements Handler.Callback {
    public final e0 a;
    public final Handler b;
    public final Map<String, b> c = new HashMap();
    public final Set<String> d = new HashSet();
    public String e = "";

    public class a implements EventBus.DataFetcher {
        public final /* synthetic */ Set a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public a(j3 j3Var, Set set, String str, boolean z) {
            this.a = set;
            this.b = str;
            this.c = z;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    jSONArray.put((String) it.next());
                }
                jSONObject.put("$$APP_ID", this.b);
                jSONObject.put("$$EVENT_LOCAL_ID_ARRAY", jSONArray);
                jSONObject.put("$$UPLOAD_STATUS", this.c ? "success" : com.alipay.sdk.m.u.h.i);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public static class b {
        public long a;
        public String b;
        public JSONObject c;

        public b(long j, String str, JSONObject jSONObject) {
            this.a = j;
            this.b = str;
            this.c = jSONObject;
        }

        public String toString() {
            return com.bytedance.bdtracker.a.a("ProfileDataWrapper{timeStamp=").append(this.a).append(", apiName='").append(this.b).append('\'').append(", jsonObject=").append(this.c).append('}').toString();
        }
    }

    public j3(e0 e0Var) {
        this.a = e0Var;
        HandlerThread handlerThread = new HandlerThread(com.bytedance.bdtracker.a.a("bd_tracker_profile:").append(e0Var.d.m).toString());
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper(), this);
    }

    public final void a(b bVar) {
        if (this.a == null) {
            return;
        }
        e4 e4Var = new e4(com.bytedance.bdtracker.a.a("__profile_").append(bVar.b).toString(), bVar.c.toString());
        ArrayList arrayList = new ArrayList();
        e0 e0Var = this.a;
        e0Var.n.a(e0Var.d, e4Var);
        this.a.b(e4Var);
        arrayList.add(e4Var);
        this.a.c().c.b(arrayList);
        this.b.sendMessageDelayed(this.b.obtainMessage(106), 500L);
    }

    public void a(JSONObject jSONObject) {
        a(105, new b(System.currentTimeMillis(), "append", jSONObject));
    }

    public void b(JSONObject jSONObject) {
        a(103, new b(System.currentTimeMillis(), "increment", jSONObject));
    }

    public void c(JSONObject jSONObject) {
        a(100, new b(System.currentTimeMillis(), "set", jSONObject));
    }

    public void d(JSONObject jSONObject) {
        a(102, new b(System.currentTimeMillis(), "set_once", jSONObject));
    }

    public void e(JSONObject jSONObject) {
        a(104, new b(System.currentTimeMillis(), "unset", jSONObject));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 100:
                b bVar = (b) message.obj;
                this.a.d.D.debug(9, "Handle set:{}", bVar);
                String str = this.e;
                boolean zEquals = str != null ? str.equals(this.a.d.getSsid()) : false;
                this.e = this.a.d.getSsid();
                Iterator<String> itKeys = bVar.c.keys();
                boolean z = true;
                boolean z2 = false;
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!this.c.containsKey(next) || this.c.get(next) == null) {
                        z2 = true;
                    } else {
                        b bVar2 = this.c.get(next);
                        if (bVar2 != null) {
                            if (System.currentTimeMillis() - bVar2.a >= 60000) {
                                z2 = true;
                            }
                            try {
                                if (!l0.b.a(bVar.c, bVar2.c, (String) null)) {
                                }
                            } catch (Throwable th) {
                                this.a.d.D.error(9, "JSON handle failed", th, new Object[0]);
                            }
                        }
                        this.c.put(next, bVar);
                    }
                    z = false;
                    this.c.put(next, bVar);
                }
                if (!zEquals || z2 || !z) {
                    this.a.d.D.debug(9, "invoke profile set.", new Object[0]);
                    a(bVar);
                }
                return true;
            case 101:
            default:
                return true;
            case 102:
                b bVar3 = (b) message.obj;
                this.a.d.D.debug(9, "Handle setOnce:{}", bVar3);
                String str2 = this.e;
                boolean zEquals2 = str2 != null ? str2.equals(this.a.d.getSsid()) : false;
                this.e = this.a.d.getSsid();
                Iterator<String> itKeys2 = bVar3.c.keys();
                boolean z3 = true;
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    if (!this.d.contains(next2)) {
                        z3 = false;
                    }
                    this.d.add(next2);
                }
                if (!zEquals2 || !z3) {
                    this.a.d.D.debug(9, "invoke profile set once.", new Object[0]);
                    a(bVar3);
                }
                return true;
            case 103:
                b bVar4 = (b) message.obj;
                this.a.d.D.debug(9, "Handle increment:{}", bVar4);
                a(bVar4);
                return true;
            case 104:
                b bVar5 = (b) message.obj;
                this.a.d.D.debug(9, "Handle unset:{}", bVar5);
                a(bVar5);
                return true;
            case 105:
                b bVar6 = (b) message.obj;
                this.a.d.D.debug(9, "Handle append:{}", bVar6);
                a(bVar6);
                return true;
            case 106:
                e0 e0Var = this.a;
                if (e0Var != null) {
                    e0Var.d.D.debug(9, "Handle flush with dr state:{}", Integer.valueOf(e0Var.i.h()));
                    if (this.a.i.h() != 0) {
                        Map<String, List<e4>> mapA = this.a.c().a(this.a.d.m);
                        if (!mapA.isEmpty()) {
                            HashSet hashSet = new HashSet();
                            for (Map.Entry<String, List<e4>> entry : mapA.entrySet()) {
                                String key = entry.getKey();
                                JSONArray jSONArray = new JSONArray();
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    l0.b.a(jSONObject, this.a.d.getHeader());
                                    boolean zC = l0.b.c(key);
                                    Object obj = key;
                                    if (zC) {
                                        obj = JSONObject.NULL;
                                    }
                                    jSONObject.put("user_unique_id", obj);
                                    jSONObject.remove("ssid");
                                    JSONObject jSONObject2 = new JSONObject();
                                    for (e4 e4Var : entry.getValue()) {
                                        jSONArray.put(e4Var.h());
                                        if (l0.b.d(e4Var.i) && !jSONObject.has("ssid")) {
                                            jSONObject.put("ssid", e4Var.i);
                                        }
                                        hashSet.add(e4Var.p);
                                    }
                                    if (this.a.a(jSONObject)) {
                                        jSONObject2.put("event_v3", jSONArray);
                                        jSONObject2.put("magic_tag", "ss_app_log");
                                        jSONObject2.put("header", jSONObject);
                                        jSONObject2.put("time_sync", o3.d);
                                        jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                                        this.a.c().a(entry.getValue());
                                        if (this.a.d.k.a(new String[]{this.a.e().getProfileUri()}, jSONObject2, this.a.e) != 200) {
                                            this.a.c().c(entry.getValue());
                                            a((Set<String>) hashSet, false);
                                        } else {
                                            a((Set<String>) hashSet, true);
                                        }
                                    } else {
                                        this.a.d.D.warn(9, "Register to get ssid by temp header failed.", new Object[0]);
                                    }
                                } catch (Throwable th2) {
                                    this.a.d.D.error(9, "Flush failed", th2, new Object[0]);
                                    a((Set<String>) hashSet, false);
                                }
                            }
                        }
                    }
                }
                return true;
        }
    }

    public final void a(int i, b bVar) {
        if (this.a.d.x) {
            return;
        }
        Handler handler = this.b;
        handler.sendMessage(handler.obtainMessage(i, bVar));
    }

    public final void a(Set<String> set, boolean z) {
        if (set == null || set.isEmpty()) {
            return;
        }
        LogUtils.sendJsonFetcher("event_upload_eid", new a(this, set, this.a.d.m, z));
    }
}
