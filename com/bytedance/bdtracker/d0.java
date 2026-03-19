package com.bytedance.bdtracker;

import android.content.SharedPreferences;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.applog.Level;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.bdtracker.l0;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d0 extends c0 {

    public class a implements EventBus.DataFetcher {
        public final /* synthetic */ JSONObject a;

        public a(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            l0.b.b(this.a, jSONObject);
            try {
                jSONObject.put("appId", d0.this.f.m);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public d0(e0 e0Var) {
        super(e0Var, e0Var.e.f.getLong("app_log_last_config_time", 0L));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.bdtracker.c0
    public boolean c() throws JSONException {
        String strA;
        int i;
        s1 s1Var = this.e.i;
        JSONObject jSONObjectE = s1Var.e();
        if (s1Var.h() != 0 && jSONObjectE != null) {
            JSONObject jSONObjectB = o3.b(jSONObjectE);
            if (this.e.e.c.isEventFilterEnable()) {
                jSONObjectB.put("event_filter", 1);
            }
            o4.a(this.f, jSONObjectB);
            String strA2 = this.f.j.a(s1Var.e(), this.e.e().getSettingUri(), true, Level.L1);
            o3 o3Var = this.f.k;
            String strA3 = o3.a(strA2, o4.b);
            o3Var.b.D.debug(11, "Start to get config to uri:{} with request:{}...", strA3, jSONObjectB);
            try {
                strA = o3Var.a(jSONObjectB, strA3, o3Var.a(), 60000);
            } catch (Throwable th) {
                o3Var.b.D.error(11, "Config failed", th, new Object[0]);
                strA = null;
            }
            o3Var.b.D.debug(11, "Get config with response:{}", strA);
            JSONObject jSONObjectA = o3Var.a(strA);
            JSONObject jSONObjectOptJSONObject = (jSONObjectA != null && "ss_app_log".equals(jSONObjectA.optString("magic_tag", ""))) != false ? jSONObjectA.optJSONObject("config") : null;
            q1 q1Var = this.e.e;
            e1 e1Var = this.f.y;
            if (e1Var != null) {
                e1Var.onRemoteConfigGet(!((jSONObjectOptJSONObject == null || q1Var.i == null) ? l0.b.b((Object) jSONObjectOptJSONObject, (Object) r6) : jSONObjectOptJSONObject.toString().equals(r6.toString())), jSONObjectOptJSONObject);
            }
            if (jSONObjectOptJSONObject != null) {
                q1Var.b.D.debug(Collections.singletonList("ConfigManager"), "Set config:{}", jSONObjectOptJSONObject);
                q1Var.i = jSONObjectOptJSONObject;
                long jCurrentTimeMillis = System.currentTimeMillis();
                SharedPreferences.Editor editorEdit = q1Var.f.edit();
                long jOptInt = jSONObjectOptJSONObject.optInt("session_interval", 0);
                if (jOptInt <= 0 || jOptInt > 604800) {
                    editorEdit.remove("session_interval");
                } else {
                    editorEdit.putLong("session_interval", jOptInt * 1000);
                }
                long jOptInt2 = jSONObjectOptJSONObject.optInt("batch_event_interval", 60) * 1000;
                if ((jOptInt2 >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT && jOptInt2 <= 300000) == true) {
                    editorEdit.putLong("batch_event_interval", jOptInt2);
                } else {
                    editorEdit.remove("batch_event_interval");
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("batch_event_size", -1);
                if (q1Var.a(iOptInt)) {
                    editorEdit.putInt("batch_event_size", iOptInt);
                } else {
                    editorEdit.remove("batch_event_size");
                }
                int iOptInt2 = jSONObjectOptJSONObject.optInt("send_launch_timely", 0);
                if (iOptInt2 <= 0 || iOptInt2 > 604800) {
                    editorEdit.remove("send_launch_timely");
                } else {
                    editorEdit.putInt("send_launch_timely", iOptInt2);
                }
                long jOptInt3 = jSONObjectOptJSONObject.optInt("abtest_fetch_interval", 0);
                if (jOptInt3 <= 20 || jOptInt3 > 604800) {
                    editorEdit.remove("abtest_fetch_interval");
                } else {
                    editorEdit.putLong("abtest_fetch_interval", jOptInt3 * 1000);
                }
                boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("bav_log_collect", q1Var.c.isAutoTrackEnabled());
                editorEdit.putBoolean("bav_log_collect", zOptBoolean);
                q1Var.s = zOptBoolean ? 1 : 0;
                editorEdit.putBoolean("bav_ab_config", jSONObjectOptJSONObject.optBoolean("bav_ab_config", q1Var.c.isAbEnable()));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("real_time_events");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    editorEdit.remove("real_time_events");
                } else {
                    editorEdit.putString("real_time_events", jSONArrayOptJSONArray.toString());
                }
                q1Var.l = null;
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("sensitive_fields");
                if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                    editorEdit.remove("sensitive_fields");
                } else {
                    editorEdit.putString("sensitive_fields", jSONArrayOptJSONArray2.toString());
                }
                editorEdit.putLong("app_log_last_config_time", jCurrentTimeMillis);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("forbid_report_phone_detail_info", -1);
                if (iOptInt3 >= 0) {
                    editorEdit.putBoolean("forbid_report_phone_detail_info", iOptInt3 > 0);
                }
                long jOptLong = jSONObjectOptJSONObject.optLong("fetch_interval", 21600L) * 1000;
                if (jOptLong < 1800000 || jOptLong > 172800000) {
                    jOptLong = 21600000;
                }
                editorEdit.putLong("fetch_interval", jOptLong);
                if (jSONObjectOptJSONObject.has("applog_disable_monitor")) {
                    i = 1;
                    editorEdit.putBoolean("monitor_enabled", jSONObjectOptJSONObject.optInt("applog_disable_monitor", 0) == 1);
                } else {
                    i = 1;
                }
                if (jSONObjectOptJSONObject.has("enter_background_not_send")) {
                    editorEdit.putBoolean("enter_background_not_send", jSONObjectOptJSONObject.optInt("enter_background_not_send") == i);
                }
                editorEdit.apply();
                q1Var.k();
                this.f.setForbidReportPhoneDetailInfo(q1Var.f.getBoolean("forbid_report_phone_detail_info", false));
                if (!q1Var.i()) {
                    this.e.q = null;
                }
                e0 e0Var = this.e;
                e0Var.j.removeMessages(13);
                e0Var.j.sendEmptyMessage(13);
                if (this.e.e.c.isEventFilterEnable()) {
                    String strA4 = b.a(this.f, "sp_filter_name");
                    e0 e0Var2 = this.e;
                    e0Var2.y = b1.a(e0Var2.b(), strA4, jSONObjectOptJSONObject);
                }
                LogUtils.sendJsonFetcher("fetch_log_settings_end", new a(jSONObjectOptJSONObject));
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.bdtracker.c0
    public String d() {
        return "Configure";
    }

    @Override // com.bytedance.bdtracker.c0
    public long[] e() {
        return h0.h;
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean f() {
        return true;
    }

    @Override // com.bytedance.bdtracker.c0
    public long g() {
        return this.e.e.f.getLong("fetch_interval", 21600000L);
    }
}
