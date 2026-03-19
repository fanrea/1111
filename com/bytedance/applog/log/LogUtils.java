package com.bytedance.applog.log;

import com.bytedance.applog.log.EventBus;
import com.bytedance.bdtracker.a4;
import com.bytedance.bdtracker.b4;
import com.bytedance.bdtracker.d4;
import com.bytedance.bdtracker.e4;
import com.bytedance.bdtracker.g4;
import com.bytedance.bdtracker.h4;
import com.bytedance.bdtracker.l0;
import com.bytedance.bdtracker.t3;
import com.bytedance.bdtracker.w3;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LogUtils {
    public static final String EVENT_TYPE_EVENT_V3 = "EVENT_V3";
    public static final String EVENT_TYPE_LAUNCH = "LAUNCH";
    public static final String EVENT_TYPE_PROFILE = "PROFILE";
    public static final String EVENT_TYPE_TERMINATE = "TERMINATE";
    public static final String EVENT_TYPE_TRACE = "TRACE";
    public static volatile boolean a = false;

    public static class a implements EventBus.DataFetcher {
        public final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() throws JSONException {
            t3 t3Var;
            String upperCase;
            JSONObject jSONObjectH = ((t3) this.a).h();
            JSONObject jSONObject = new JSONObject();
            l0.b.b(jSONObjectH, jSONObject);
            try {
                jSONObject.put("$$APP_ID", ((t3) this.a).m);
                t3Var = (t3) this.a;
            } catch (JSONException unused) {
            }
            if (t3Var != null) {
                if ((t3Var instanceof a4) || (t3Var instanceof d4)) {
                    upperCase = LogUtils.EVENT_TYPE_EVENT_V3;
                } else if (t3Var instanceof w3) {
                    upperCase = ((w3) t3Var).s.toUpperCase(Locale.ROOT);
                } else if (t3Var instanceof b4) {
                    upperCase = LogUtils.EVENT_TYPE_LAUNCH;
                } else if (t3Var instanceof g4) {
                    upperCase = LogUtils.EVENT_TYPE_TERMINATE;
                } else if (t3Var instanceof e4) {
                    upperCase = LogUtils.EVENT_TYPE_PROFILE;
                } else if (t3Var instanceof h4) {
                    upperCase = LogUtils.EVENT_TYPE_TRACE;
                }
                jSONObject.put("$$EVENT_TYPE", upperCase);
                jSONObject.put("$$EVENT_LOCAL_ID", ((t3) this.a).p);
                return jSONObject;
            }
            upperCase = "";
            jSONObject.put("$$EVENT_TYPE", upperCase);
            jSONObject.put("$$EVENT_LOCAL_ID", ((t3) this.a).p);
            return jSONObject;
        }
    }

    public static String a(String str) {
        return "applog_" + str;
    }

    public static boolean a() {
        return !a;
    }

    public static void sendJson(String str, JSONObject jSONObject) {
        if (a() || l0.b.c(str)) {
            return;
        }
        EventBus.global.get(new Object[0]).emit(a(str), jSONObject);
    }

    public static void sendJsonFetcher(String str, EventBus.DataFetcher dataFetcher) {
        if (a() || l0.b.c(str)) {
            return;
        }
        EventBus.global.get(new Object[0]).emit(a(str), dataFetcher);
    }

    public static void sendObject(String str, Object obj) {
        if (a() || l0.b.c(str)) {
            return;
        }
        if (obj instanceof t3) {
            EventBus.global.get(new Object[0]).emit(a(str), (EventBus.DataFetcher) new a(obj));
        } else {
            EventBus.global.get(new Object[0]).emit(a(str), obj);
        }
    }

    public static void sendString(String str, String str2) {
        if (a() || l0.b.c(str)) {
            return;
        }
        EventBus.global.get(new Object[0]).emit(a(str), str2);
    }

    public static void setEnable(boolean z) {
        a = z;
    }
}
