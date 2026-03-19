package com.qq.e.comm.plugin;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.vg;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.AdErrorConvertor;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ii extends e30 {
    private final LinkedHashMap<String, b> a = new LinkedHashMap<>();

    public String a() {
        return "h5RewardVideo";
    }

    /* compiled from: A */
    class b implements ADListener {
        private final ug a;
        private a b;
        private final bm c;

        public b(bm bmVar, ug ugVar) {
            this.c = bmVar;
            this.a = ugVar;
        }

        public a a() {
            return this.b;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 100) {
                e();
                return;
            }
            if (type == 201) {
                g();
                return;
            }
            if (type != 206) {
                switch (type) {
                    case 102:
                        f();
                        break;
                    case 103:
                        d();
                        break;
                    case 104:
                        String str = (String) aDEvent.getParam(String.class);
                        if (str != null) {
                            HashMap map = new HashMap();
                            map.put(ServerSideVerificationOptions.TRANS_ID, str);
                            a(map);
                            break;
                        }
                        break;
                    case 105:
                        b();
                        break;
                    case 106:
                        c();
                        break;
                    case 107:
                        Integer num = (Integer) aDEvent.getParam(Integer.class);
                        if (num != null) {
                            a(AdErrorConvertor.formatErrorCode(num.intValue()));
                            break;
                        }
                        break;
                }
                return;
            }
            h();
        }

        private void e() {
            a aVar = this.b;
            this.c.a(new vg(this.a, vg.a.OK, ii.this.a("onADLoad", 0, null, aVar == null ? 0L : (aVar.getExpireTimestamp() - SystemClock.elapsedRealtime()) + (System.currentTimeMillis() / 1000)), 1));
        }

        private void g() {
            this.c.a(new vg(this.a, vg.a.OK, ii.this.a("onVideoCached", 0, null, 0L), 1));
        }

        private void f() {
            this.c.a(new vg(this.a, vg.a.OK, ii.this.a("onADShow", 0, null, 0L), 1));
        }

        private void d() {
            this.c.a(new vg(this.a, vg.a.OK, ii.this.a("onADExpose", 0, null, 0L), 1));
        }

        private void b() {
            this.c.a(new vg(this.a, vg.a.OK, ii.this.a("onADClick", 0, null, 0L), 1));
        }

        private void h() {
            this.c.a(new vg(this.a, vg.a.OK, ii.this.a("onVideoComplete", 0, null, 0L), 1));
        }

        private void c() {
            this.c.a(new vg(this.a, vg.a.OK, ii.this.a("onADClose", 0, null, 0L), 1));
        }

        private void a(AdError adError) {
            this.c.a(new vg(this.a, vg.a.OK, ii.this.a("onError", adError.getErrorCode(), adError.getErrorMsg(), 0L), 1));
        }

        private void a(Map<String, Object> map) {
            this.c.a(new vg(this.a, vg.a.OK, ii.this.a("onReward", 0, null, 0L), 1));
        }

        public void a(a aVar) {
            this.b = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, int i, String str2, long j) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("data", jSONObject2);
            jSONObject2.put("action", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put(com.baidu.mobads.container.util.cm.V, str2);
            }
            if (j > 0) {
                jSONObject2.put("expiredTimestamp", j);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.qq.e.comm.plugin.e30
    public ih<String> a(jm jmVar, ug ugVar) throws JSONException {
        String strA = ugVar.a();
        JSONObject jSONObjectD = ugVar.d();
        String strB = ugVar.b();
        bm bmVarB = jmVar.b();
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strB)) {
            bmVarB.a(new vg(ugVar, vg.a.ERROR, "Params Empty !", 1));
            b10.a(21072, null, 1);
            return new ih<>(null);
        }
        if (jSONObjectD == null) {
            bmVarB.a(new vg(ugVar, vg.a.JSON_PARSE_EXCEPTION, "Json 解析结果为空 !", 1));
            b10.a(21072, null, 4);
            return new ih<>(null);
        }
        String strOptString = jSONObjectD.optString("instance_id");
        String strOptString2 = jSONObjectD.optString(PointParamKey.PLACEMENT_ID);
        String strOptString3 = jSONObjectD.optString("ext_url");
        String strOptString4 = jSONObjectD.optString("xflow_pos_id");
        f5 f5VarC = new f5().a(e2.REWARDVIDEOAD).c(strOptString2);
        if ("registerRewardVideoAD".equals(strA)) {
            b10.a(21012, f5VarC);
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                b bVar = new b(bmVarB, ugVar);
                bVar.a(new a(r1.d().a(), r1.d().b().a(), strOptString2, bVar, strOptString3, strOptString4));
                if (this.a.size() < r1.d().f().a("maxRewardVideoAdsPerWebview", 100)) {
                    this.a.put(strOptString, bVar);
                    bmVarB.a(new vg(ugVar, vg.a.OK, a("onRegisterSuccess", 0, null, 0L), 1));
                } else {
                    bmVarB.a(new vg(ugVar, vg.a.OK, a("onError", 4001, "传入的参数有错误", 0L), 1));
                    b10.a(21002, f5VarC);
                }
                return new ih<>(null);
            }
            bmVarB.a(new vg(ugVar, vg.a.OK, a("onError", 4001, "传入的参数有错误", 0L), 1));
            b10.a(21072, f5VarC, 6);
            return new ih<>(null);
        }
        if ("loadRewardVideoAD".equals(strA)) {
            b10.a(21022, f5VarC);
            if (TextUtils.isEmpty(strOptString)) {
                b10.a(21072, f5VarC, 2);
                return new ih<>(null);
            }
            b bVar2 = this.a.get(strOptString);
            a aVarA = bVar2 != null ? bVar2.a() : null;
            if (aVarA == null) {
                bmVarB.a(new vg(ugVar, vg.a.OK, a("onError", 4017, "广告实例尚未准备好", 0L), 1));
            } else {
                aVarA.loadAD();
            }
            return new ih<>(null);
        }
        if ("showRewardVideoAD".equals(strA)) {
            b10.a(21032, f5VarC);
            if (TextUtils.isEmpty(strOptString)) {
                b10.a(21072, f5VarC, 3);
                return new ih<>(null);
            }
            b bVar3 = this.a.get(strOptString);
            a aVarA2 = bVar3 != null ? bVar3.a() : null;
            if (aVarA2 == null) {
                bmVarB.a(new vg(ugVar, vg.a.OK, a("onError", 4017, "广告实例尚未准备好", 0L), 1));
            } else {
                aVarA2.showAD();
            }
            return new ih<>(null);
        }
        b10.a(21072, f5VarC, 5);
        return new ih<>(1000, "Unsupported action");
    }

    /* compiled from: A */
    class a extends je {
        private final String D;
        private final String E;

        @Override // com.qq.e.comm.plugin.je
        protected boolean b(int i) {
            String str = g1.o;
            return false;
        }

        public a(Context context, String str, String str2, ADListener aDListener, String str3, String str4) {
            super(context, str, str2, "", aDListener);
            this.D = str3;
            this.E = str4;
        }

        @Override // com.qq.e.comm.plugin.je
        protected w1 d() {
            w1 w1VarD = super.d();
            w1VarD.d(1);
            w1VarD.i(this.D);
            w1VarD.j(this.E);
            return w1VarD;
        }
    }
}
