package com.bytedance.bdtracker;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.applog.Level;
import com.bytedance.applog.game.GameReportHelper;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.bdtracker.l0;
import com.pandora.common.Constants;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h0 extends c0 {
    public static final long[] g = {60000, 60000, 60000, 120000, 120000, 180000, 180000, 360000, 360000, 540000, 540000};
    public static final long[] h = {180000, 180000, 360000, 360000, 540000, 540000, 720000, 720000};
    public static final long[] i = {ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 20000, 20000, 60000, 60000, 120000, 120000, 180000, 180000, 360000, 360000, 540000, 540000};

    public class a implements EventBus.DataFetcher {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public a(String str, String str2, String str3, String str4, String str5, String str6) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = str6;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", h0.this.f.m);
                jSONObject.put(Constants.APPLog.DEVICE_ID, this.a);
                jSONObject.put("installId", this.b);
                jSONObject.put("ssid", this.c);
                jSONObject.put("bdDid", this.d);
                jSONObject.put("uuid", this.e);
                jSONObject.put("uuidType", this.f);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public h0(e0 e0Var) {
        super(e0Var, e0Var.i.d.optLong("register_time", 0L));
    }

    public synchronized boolean a(JSONObject jSONObject) {
        this.e.d.D.debug(1, "Start do register work", new Object[0]);
        String strOptString = jSONObject.optString("user_unique_id");
        String strOptString2 = jSONObject.optString("user_unique_id_type");
        e0 e0Var = this.e;
        s1 s1Var = e0Var.i;
        q1 q1Var = e0Var.e;
        q1Var.c.getPreInstallCallback();
        Map<String, Object> commonHeader = q1Var.c.getCommonHeader();
        jSONObject.put(com.baidu.mobads.container.adrequest.g.o, x4.a.b(new Object[0]));
        if (q1Var.j()) {
            try {
                boolean z = h5.a.b(this.f.n).c;
                this.e.d.D.debug(1, "Oaid maySupport: {}", Boolean.valueOf(z));
                jSONObject.put("oaid_may_support", z);
            } catch (Throwable th) {
                this.e.d.D.error(1, "Check oaid maySupport failed.", th, new Object[0]);
            }
        }
        if (commonHeader != null) {
            for (Map.Entry<String, Object> entry : commonHeader.entrySet()) {
                if (entry.getValue() != null) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        }
        JSONObject jSONObjectB = b(jSONObject);
        if (jSONObjectB == null) {
            this.e.d.D.debug(1, "Register finished", new Object[0]);
            return false;
        }
        String strOptString3 = jSONObjectB.optString(com.baidu.mobads.upgrade.remote.gray.c.l, "");
        String strOptString4 = jSONObjectB.optString("install_id", "");
        String strOptString5 = jSONObjectB.optString("ssid", "");
        String strOptString6 = jSONObjectB.optString("bd_did", "");
        String strOptString7 = jSONObjectB.optString("cd", "");
        if (l0.b.d(strOptString5)) {
            this.e.c().a(strOptString, strOptString5);
        }
        boolean zA = s1Var.a(jSONObjectB, strOptString, strOptString3, strOptString4, strOptString5, strOptString6, strOptString7);
        if (zA) {
            e0 e0Var2 = this.e;
            e0Var2.a(e0Var2.m);
            if (this.e.e.c.isReportOaidEnable()) {
                this.e.a();
            }
            LogUtils.sendJsonFetcher("device_register_end", new a(strOptString3, strOptString4, strOptString5, strOptString6, strOptString, strOptString2));
        }
        return zA;
    }

    public JSONObject b(JSONObject jSONObject) {
        this.e.d.D.debug(1, "Start to invokeRegister", new Object[0]);
        try {
            if (jSONObject.opt("oaid") instanceof String) {
                jSONObject.remove("oaid");
                if (this.e.i != null && this.e.i.e() != null) {
                    Object objOpt = this.e.i.e().opt("oaid");
                    if (objOpt instanceof JSONObject) {
                        jSONObject.put("oaid", objOpt);
                    }
                }
            }
            JSONObject jSONObjectB = o3.b(jSONObject);
            return this.f.k.a(this.f.j.a(jSONObject, this.e.e().getRegisterUri(), true, Level.L1), jSONObjectB);
        } catch (Throwable th) {
            this.e.d.D.error(1, "Request to register server failed.", th, new Object[0]);
            return null;
        }
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean c() {
        JSONObject jSONObject = new JSONObject();
        l0.b.a(jSONObject, this.e.i.e());
        return a(jSONObject);
    }

    @Override // com.bytedance.bdtracker.c0
    public String d() {
        return GameReportHelper.REGISTER;
    }

    @Override // com.bytedance.bdtracker.c0
    public long[] e() {
        int iH = this.e.i.h();
        if (iH == 0) {
            return i;
        }
        if (iH != 1) {
            if (iH == 2) {
                return g;
            }
            this.e.d.D.error(1, "Unknown register state", new Object[0]);
        }
        return h;
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean f() {
        return true;
    }

    @Override // com.bytedance.bdtracker.c0
    public long g() {
        return this.e.n.i ? 21600000L : 43200000L;
    }

    public JSONObject c(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectB = o3.b(jSONObject);
            return this.f.k.b(this.e.e().getReportOaidUri(), jSONObjectB);
        } catch (Throwable th) {
            this.e.d.D.error(1, "Report oaid failed.", th, new Object[0]);
            return null;
        }
    }
}
