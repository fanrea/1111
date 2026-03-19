package com.bytedance.msdk.core.admanager.reward.rewardagain;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.gromore.R;
import com.bytedance.msdk.b.c.mq;
import com.bytedance.msdk.core.gb.uo;
import com.bytedance.msdk.core.u.hc.c;
import com.bytedance.msdk.gb.zw;
import com.bytedance.msdk.u.an;
import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private Object an;
    private com.bytedance.msdk.api.c.d.gb.d b;
    private com.bytedance.msdk.api.c.d.gb.d c;
    private final SoftReference<Context> d;
    private String h;
    private final com.bytedance.msdk.api.d.hc hc;
    private Activity u;
    private static final Map<String, hc> tc = new ConcurrentHashMap();
    private static final Map<String, com.bytedance.msdk.core.admanager.reward.rewardagain.d> mk = new ConcurrentHashMap();
    private static d mq = new d();
    private volatile boolean gb = false;
    private volatile boolean tt = false;

    public static class d {
        public Runnable b;
        public hc d;
        public Runnable hc;
    }

    public b(Context context, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.api.c.d.gb.d dVar, com.bytedance.msdk.api.c.d.gb.d dVar2) {
        this.d = new SoftReference<>(context);
        this.hc = hcVar;
        if (dVar != null) {
            this.b = dVar;
        }
        if (dVar2 != null) {
            this.c = dVar2;
        }
    }

    public void d(Activity activity, Object obj, String str) {
        this.u = activity;
        this.an = obj;
        this.h = str;
    }

    public void d(com.bytedance.msdk.api.c.d.gb.d dVar) {
        if (dVar != null) {
            this.b = dVar;
        }
    }

    public void hc(com.bytedance.msdk.api.c.d.gb.d dVar) {
        if (dVar != null) {
            this.c = dVar;
        }
    }

    public void d(final com.bytedance.msdk.core.admanager.reward.rewardagain.d dVar, final com.bytedance.msdk.hc.b bVar) {
        Activity activity = this.u;
        if (activity != null && !activity.isFinishing() && !this.u.isDestroyed()) {
            final Dialog dialog = new Dialog(this.u);
            View viewInflate = LayoutInflater.from(this.u.getApplicationContext()).inflate(R.layout.reward_again_dialog, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ra_pic);
            TextView textView = (TextView) viewInflate.findViewById(R.id.ra_title);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.ra_btn_ok);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.ra_btn_cancel);
            hc hcVar = tc.get(dVar.c());
            if (hcVar != null) {
                textView.setText(hcVar.hc());
                textView2.setText(hcVar.c());
                textView3.setText(hcVar.u());
                if (!TextUtils.isEmpty(hcVar.b())) {
                    new com.bytedance.msdk.d.u.hc(imageView).d((Object[]) new String[]{hcVar.b()});
                }
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.b(dVar, bVar);
                    dialog.dismiss();
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.u();
                    dialog.dismiss();
                }
            });
            dialog.setContentView(viewInflate);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            dialog.show();
            return;
        }
        com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- reward again show activity dialog");
        hc(dVar, bVar);
    }

    private void hc(final com.bytedance.msdk.core.admanager.reward.rewardagain.d dVar, final com.bytedance.msdk.hc.b bVar) {
        d dVar2 = new d();
        mq = dVar2;
        dVar2.d = tc.get(dVar.c());
        mq.hc = new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(dVar, bVar);
                b.gb();
            }
        };
        mq.b = new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.u();
                b.gb();
            }
        };
        Intent intent = new Intent(com.bytedance.msdk.core.hc.getContext(), (Class<?>) GMRewardAgainDialogActivity.class);
        intent.setFlags(268435456);
        com.bytedance.msdk.core.hc.getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.bytedance.msdk.core.admanager.reward.rewardagain.d dVar, com.bytedance.msdk.hc.b bVar) {
        int iD = d(this.hc, dVar, bVar);
        an.b(this.hc, iD);
        if (iD == 0) {
            d();
            return;
        }
        com.bytedance.msdk.api.c.d.gb.d dVar2 = this.b;
        if (dVar2 != null) {
            dVar2.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.bytedance.msdk.api.c.d.gb.d dVar = this.b;
        if (dVar != null) {
            dVar.b();
        }
        an.hc(this.hc);
    }

    public void d() {
        Context context = this.d.get();
        if (context != null) {
            this.hc.u(1);
            final mq mqVar = new mq(context);
            d(mqVar);
            mqVar.d(this.hc, new com.bytedance.msdk.api.c.d.gb.hc() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.b.5
                @Override // com.bytedance.msdk.api.c.d.gb.hc
                public void d(com.bytedance.msdk.api.d dVar) {
                    if (b.this.gb) {
                        return;
                    }
                    b.this.gb = true;
                    if (b.this.b != null) {
                        b.this.b.b();
                    }
                }

                @Override // com.bytedance.msdk.api.c.d.gb.hc
                public void d() {
                    if (b.this.gb) {
                        return;
                    }
                    b.this.gb = true;
                    mqVar.d(b.this.u, b.this.an, b.this.h);
                }

                @Override // com.bytedance.msdk.api.c.d.gb.hc
                public void hc() {
                    if (b.this.gb) {
                        return;
                    }
                    b.this.gb = true;
                    mqVar.d(b.this.u, b.this.an, b.this.h);
                }
            });
            com.bytedance.msdk.d.u.an.hc(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.b.6
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gb) {
                        return;
                    }
                    b.this.gb = true;
                    if (b.this.b != null) {
                        b.this.b.b();
                    }
                }
            }, 500L);
        }
    }

    private void d(mq mqVar) {
        mqVar.d(new com.bytedance.msdk.api.c.d.gb.d() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.b.7
            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void i_() throws JSONException {
                String strV = b.this.hc != null ? b.this.hc.v() : "";
                b.hc(strV);
                b.c(strV);
                b.u(strV);
                if (b.this.c != null) {
                    b.this.c.i_();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void d(com.bytedance.msdk.api.d dVar) {
                if (b.this.c != null) {
                    b.this.c.d(dVar);
                }
            }

            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void j_() {
                if (b.this.c != null) {
                    b.this.c.j_();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void b() {
                if (b.this.b != null) {
                    b.this.b.b();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void c() {
                if (b.this.c != null) {
                    b.this.c.c();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void u() {
                if (b.this.c != null) {
                    b.this.c.u();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void d(com.bytedance.msdk.api.b.d dVar) {
                if (b.this.c != null) {
                    b.this.c.d(dVar);
                }
            }

            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void an() {
                if (b.this.c != null) {
                    b.this.c.an();
                }
            }
        });
        mqVar.hc(new com.bytedance.msdk.api.c.d.gb.d() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.b.8
            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void i_() {
                if (b.this.c != null) {
                    b.this.c.i_();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void d(com.bytedance.msdk.api.d dVar) {
                if (b.this.c != null) {
                    b.this.c.d(dVar);
                }
            }

            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void j_() {
                if (b.this.c != null) {
                    b.this.c.j_();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void b() {
                if (b.this.b != null) {
                    b.this.b.b();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void c() {
                if (b.this.c != null) {
                    b.this.c.c();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void u() {
                if (b.this.c != null) {
                    b.this.c.u();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void d(com.bytedance.msdk.api.b.d dVar) {
                if (b.this.c != null) {
                    b.this.c.d(dVar);
                }
            }

            @Override // com.bytedance.msdk.api.c.d.gb.d
            public void an() {
                if (b.this.c != null) {
                    b.this.c.an();
                }
            }
        });
    }

    public void hc() {
        this.tt = true;
    }

    public int d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.core.admanager.reward.rewardagain.d dVar, com.bytedance.msdk.hc.b bVar) {
        if (!this.tt) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--ra: 还未触发rewardVerify");
            return 1;
        }
        String strV = hcVar.v();
        int iU = dVar.u();
        int iD = d(strV);
        if (iD >= iU) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--ra: 激励再得展示次数超过天级别限制，限制: " + iU + ", 已经展示: " + iD);
            return 2;
        }
        if (tc.get(dVar.c()) == null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--ra: 激励再得样式为空");
            return 3;
        }
        if (com.bytedance.msdk.core.h.d.d().hc()) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--ra: 命中请求熔断");
            return 4;
        }
        if (!uo.d().gb(strV)) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--ra: 命中展示频控");
            return 5;
        }
        if (!uo.d().b(strV)) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--ra: 命中展示间隔");
            return 6;
        }
        double dHc = c.d().hc(strV, hcVar);
        if (dHc <= -1.0d) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--ra: 激励再得无缓存可用");
            return 7;
        }
        if (dHc < gb(strV)) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--ra: 激励再得有缓存，但是ecpm不符合");
            return 8;
        }
        int iD2 = dVar.d();
        int iB = b(strV);
        if (iB >= iD2) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--ra: 激励再得展示次数超过小时级别限制，限制: " + iD2 + ", 已经展示: " + iB);
            return 9;
        }
        long jHc = dVar.hc();
        long jAn = an(strV);
        long jCurrentTimeMillis = System.currentTimeMillis() - jAn;
        if (jAn != -1 && jCurrentTimeMillis < jHc) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--ra: 激励再得展示间隔超过限制，config间隔: " + jHc + ", 实际间隔: " + jCurrentTimeMillis);
            return 10;
        }
        double dH = h(strV);
        if (bVar == null || dH == -1.0d || dHc >= bVar.kb() * dH) {
            return 0;
        }
        com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--ra: 激励再得ecpm下探期间不满足");
        return 11;
    }

    public static int d(String str) {
        String strHc = zw.d((String) null, com.bytedance.msdk.core.hc.getContext()).hc("ra_show_count");
        if (!TextUtils.isEmpty(strHc)) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strHc).optJSONObject(an());
                if (jSONObjectOptJSONObject != null) {
                    return jSONObjectOptJSONObject.optInt(str, 0);
                }
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
        return 0;
    }

    public static void hc(String str) throws JSONException {
        zw zwVarD = zw.d((String) null, com.bytedance.msdk.core.hc.getContext());
        String strHc = zwVarD.hc("ra_show_count");
        if (!TextUtils.isEmpty(strHc)) {
            try {
                JSONObject jSONObject = new JSONObject(strHc);
                String strAn = an();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strAn);
                if (jSONObjectOptJSONObject == null) {
                    zwVarD.d("ra_show_count", "");
                    jSONObjectOptJSONObject = new JSONObject();
                }
                jSONObjectOptJSONObject.put(str, jSONObjectOptJSONObject.optInt(str, 0) + 1);
                jSONObject.put(strAn, jSONObjectOptJSONObject);
                zwVarD.d("ra_show_count", jSONObject.toString());
                return;
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, 1);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(an(), jSONObject2);
            zwVarD.d("ra_show_count", jSONObject3.toString());
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.mq.d(e2);
        }
    }

    private static String an() {
        return new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
    }

    private static String h() {
        return new SimpleDateFormat("dd-MM-yyyy HH", Locale.getDefault()).format(new Date());
    }

    public static int b(String str) {
        String strHc = zw.d((String) null, com.bytedance.msdk.core.hc.getContext()).hc("ra_show_count_in_hour");
        if (!TextUtils.isEmpty(strHc)) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strHc).optJSONObject(h());
                if (jSONObjectOptJSONObject != null) {
                    return jSONObjectOptJSONObject.optInt(str, 0);
                }
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
        return 0;
    }

    public static void c(String str) throws JSONException {
        zw zwVarD = zw.d((String) null, com.bytedance.msdk.core.hc.getContext());
        String strHc = zwVarD.hc("ra_show_count_in_hour");
        if (!TextUtils.isEmpty(strHc)) {
            try {
                JSONObject jSONObject = new JSONObject(strHc);
                String strH = h();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strH);
                if (jSONObjectOptJSONObject == null) {
                    zwVarD.d("ra_show_count_in_hour", "");
                    jSONObjectOptJSONObject = new JSONObject();
                }
                jSONObjectOptJSONObject.put(str, jSONObjectOptJSONObject.optInt(str, 0) + 1);
                jSONObject.put(strH, jSONObjectOptJSONObject);
                zwVarD.d("ra_show_count_in_hour", jSONObject.toString());
                return;
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, 1);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(h(), jSONObject2);
            zwVarD.d("ra_show_count_in_hour", jSONObject3.toString());
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.mq.d(e2);
        }
    }

    public static void u(String str) {
        JSONObject jSONObject;
        zw zwVarD = zw.d((String) null, com.bytedance.msdk.core.hc.getContext());
        String strHc = zwVarD.hc("ra_play_rit_ts");
        try {
            if (TextUtils.isEmpty(strHc)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strHc);
            }
            jSONObject.put(str, System.currentTimeMillis());
            zwVarD.d("ra_play_rit_ts", jSONObject.toString());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    public static long an(String str) {
        String strHc = zw.d((String) null, com.bytedance.msdk.core.hc.getContext()).hc("ra_play_rit_ts");
        try {
            if (!TextUtils.isEmpty(strHc)) {
                return new JSONObject(strHc).optLong(str, -1L);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
        return -1L;
    }

    public static double h(String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.d dVar = mk.get(str);
        if (dVar == null) {
            return -1.0d;
        }
        double dB = dVar.b();
        if (dB < 0.0d || dB > 1.0d) {
            return -1.0d;
        }
        return dB;
    }

    public static double gb(String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.d dVar = mk.get(str);
        if (dVar != null) {
            return dVar.an();
        }
        return 0.0d;
    }

    public static com.bytedance.msdk.core.admanager.reward.rewardagain.d tt(String str) {
        return mk.get(str);
    }

    public static void d(String str, com.bytedance.msdk.core.admanager.reward.rewardagain.d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        mk.put(str, dVar);
    }

    public static void tc(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mk.remove(str);
    }

    public static void d(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                hc hcVar = new hc();
                hcVar.d(jSONObjectOptJSONObject.optString("ra_id"));
                hcVar.hc(jSONObjectOptJSONObject.optString("title"));
                hcVar.b(jSONObjectOptJSONObject.optString("pic_url"));
                hcVar.c(jSONObjectOptJSONObject.optString("btn_ok"));
                hcVar.u(jSONObjectOptJSONObject.optString("btn_cancel"));
                tc.put(hcVar.d(), hcVar);
            }
        }
    }

    public static d b() {
        return mq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gb() {
        mq.d = null;
        mq.hc = null;
        mq.b = null;
    }
}
