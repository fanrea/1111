package com.bytedance.msdk.core.admanager.reward;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.msdk.d.u.an;
import com.bytedance.msdk.gb.fs;
import com.bytedance.msdk.gb.k;
import com.bytedance.msdk.gb.np;
import com.bytedance.msdk.gb.zw;
import com.bytedance.msdk.hc.b;
import com.bytedance.sdk.component.tt.hc.c;
import com.bytedance.sdk.component.tt.hc.u;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.windad.WindAds;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private int b;
    private String cb;
    private long e;
    private com.bytedance.msdk.api.b.d h;
    private int hc;
    private b k;
    private com.bytedance.msdk.api.d.hc uo;
    private hc w;
    private boolean c = false;
    private boolean u = false;
    private long an = -1;
    private boolean gb = false;
    private boolean tt = false;
    private boolean tc = true;
    private int mk = -1;
    private String mq = "";
    AtomicInteger d = new AtomicInteger(1);

    public interface hc {
        void d(com.bytedance.msdk.api.b.d dVar);
    }

    public d(String str) {
        com.bytedance.msdk.core.tc.hc hcVarD;
        com.bytedance.msdk.core.k.b bVarHc = com.bytedance.msdk.core.hc.hc();
        if (bVarHc != null && (hcVarD = bVarHc.d(str, 7, 101)) != null) {
            this.hc = hcVarD.dc();
            this.b = hcVarD.tr();
        }
        if (this.hc < 0) {
            this.hc = 15000;
        }
    }

    public boolean d() {
        boolean z = this.b == 1;
        com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- 判断是否开启了M服务端激励验证： ".concat(String.valueOf(z)));
        return z;
    }

    public void hc() {
        an.d(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.u = true;
            }
        });
    }

    public void b() {
        an.d(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.c = true;
            }
        });
    }

    public void d(com.bytedance.msdk.api.d.hc hcVar, b bVar) {
        this.e = System.currentTimeMillis();
        this.uo = hcVar;
        this.k = bVar;
        an();
    }

    /* renamed from: com.bytedance.msdk.core.admanager.reward.d$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.c) {
                d.this.gb = true;
                if (d.this.h != null) {
                    if (d.this.w == null || d.this.tt) {
                        return;
                    }
                    com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，已经有结果，直接给开发者回调");
                    d.this.tt = true;
                    d.this.w.d(d.this.h);
                    return;
                }
                if (d.this.an == -1) {
                    com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，先进来发起请求");
                    d.this.an = SystemClock.elapsedRealtime();
                    if (d.this.tc) {
                        d.this.h();
                    } else {
                        com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来准备请求，但是不能重试");
                    }
                } else if (SystemClock.elapsedRealtime() - d.this.an > 2000) {
                    com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，后进来但大于2s，发起请求");
                    if (d.this.tc) {
                        d.this.h();
                    } else {
                        com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来准备请求，但是不能重试");
                    }
                }
                an.d(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!d.this.c) {
                            if (d.this.w == null || d.this.tt) {
                                return;
                            }
                            com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，给开发者verify回调");
                            d.this.tt = true;
                            com.bytedance.msdk.api.b.d dVar = new com.bytedance.msdk.api.b.d() { // from class: com.bytedance.msdk.core.admanager.reward.d.3.1.1
                                @Override // com.bytedance.msdk.api.b.d
                                public boolean d() {
                                    return false;
                                }

                                @Override // com.bytedance.msdk.api.b.d
                                public float hc() {
                                    if (d.this.uo != null) {
                                        return d.this.uo.s();
                                    }
                                    return 0.0f;
                                }

                                @Override // com.bytedance.msdk.api.b.d
                                public String b() {
                                    return d.this.uo != null ? d.this.uo.j() : "";
                                }

                                @Override // com.bytedance.msdk.api.b.d
                                @DungeonFlag
                                public Map<String, Object> c() {
                                    HashMap map = new HashMap();
                                    map.put("isGroMoreServerSideVerify", Boolean.TRUE);
                                    map.put(ServerSideVerificationOptions.TRANS_ID, d.this.cb);
                                    map.put("reason", 0);
                                    map.put("gromoreExtra", (d.this.uo == null || d.this.uo.hv() == null) ? "" : d.this.uo.hv().get("gromoreExtra"));
                                    map.put("errorCode", Integer.valueOf(d.this.mk));
                                    map.put("errorMsg", d.this.mq);
                                    com.bytedance.msdk.api.b bVarD = k.d(d.this.uo, d.this.k, true);
                                    map.put("adnName", bVarD != null ? bVarD.mq() : "");
                                    map.put(SplashAd.KEY_BIDFAIL_ECPM, bVarD != null ? bVarD.uo() : "");
                                    return map;
                                }
                            };
                            hc hcVar = d.this.w;
                            if (d.this.h != null) {
                                dVar = d.this.h;
                            }
                            hcVar.d(dVar);
                            return;
                        }
                        com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，已经destroy了, 直接return");
                    }
                }, com.alipay.sdk.m.u.b.a);
                return;
            }
            com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，已经destroy, 直接return");
        }
    }

    public void c() {
        an.d(new AnonymousClass3());
    }

    public void u() {
        an.d(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (!d.this.c) {
                    if (d.this.h != null || d.this.tt) {
                        com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，已经有响应(" + (d.this.h != null) + ")或已经给出开发者回调(" + d.this.tt + "), 直接return");
                        return;
                    }
                    if (d.this.an == -1) {
                        com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，先进来发起请求");
                        d.this.an = SystemClock.elapsedRealtime();
                        if (d.this.tc) {
                            d.this.h();
                            return;
                        } else {
                            com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来准备请求，但是不能重试");
                            return;
                        }
                    }
                    if (SystemClock.elapsedRealtime() - d.this.an > 2000) {
                        com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，后进来但大于2s，发起请求");
                        if (d.this.tc) {
                            d.this.h();
                            return;
                        } else {
                            com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来准备请求，但是不能重试");
                            return;
                        }
                    }
                    return;
                }
                com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，已经destroy, 直接return");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public void d(com.bytedance.sdk.component.tt.hc hcVar, boolean z, long j) {
        if (this.c) {
            return;
        }
        if (hcVar == null) {
            com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify netResponse is null");
            d(-1, "response is null", z);
            return;
        }
        int iD = hcVar.d();
        if (fs.d(hcVar)) {
            String strD = fs.d(hcVar.tc());
            if (!TextUtils.isEmpty(strD)) {
                try {
                    this.mk = 20000;
                    d(new JSONObject(strD), z, j);
                    return;
                } catch (Throwable th) {
                    mq.d(th);
                    this.mk = 1;
                    d(-1, th.getMessage(), z);
                    return;
                }
            }
            com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify data v4 is null");
            d(iD, "data is empty", z);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(hcVar.c());
            JSONObject jSONObject2 = null;
            int iOptInt = jSONObject.optInt("cypher", -1);
            String strOptString = jSONObject.optString(cm.V);
            this.mk = jSONObject.optInt("code");
            this.mq = jSONObject.optString(RemoteRewardActivity.JSON_BANNER_DESC_ID);
            int i = this.mk;
            if (i == 50001) {
                this.tc = true;
                com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify code: 50001，请求媒体服务端失败，需要重试");
                d(this.mk, this.mq, z);
                return;
            }
            if (i != 0 && i != 20000) {
                this.tc = false;
                com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify code: " + this.mk + ", msg: " + this.mq + "，不能再重试");
                d(this.mk, this.mq, z);
                return;
            }
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                if (iOptInt == 2) {
                    String strD2 = fs.d(strOptString);
                    if (!TextUtils.isEmpty(strD2)) {
                        jSONObject2 = new JSONObject(strD2);
                    }
                } else if (iOptInt == 1) {
                    String strHc = com.bytedance.msdk.gb.d.hc(strOptString, com.bytedance.msdk.gb.hc.d());
                    if (!TextUtils.isEmpty(strHc)) {
                        jSONObject2 = new JSONObject(strHc);
                    }
                } else if (iOptInt == 0) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                d(jSONObject2, z, j);
                return;
            }
            com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify cypher error or message is null");
            d(iD, "message is null", z);
        } catch (Throwable th2) {
            d(-1, th2.getMessage(), z);
        }
    }

    @DungeonFlag
    private void d(JSONObject jSONObject, boolean z, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (jSONObject != null) {
            com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- data: " + jSONObject.toString());
            final boolean zOptBoolean = jSONObject.optBoolean("is_verify");
            final int iOptInt = jSONObject.optInt("reason");
            final String strOptString = jSONObject.optString("reward_name");
            final int iOptInt2 = jSONObject.optInt("reward_amount");
            this.h = new com.bytedance.msdk.api.b.d() { // from class: com.bytedance.msdk.core.admanager.reward.d.5
                @Override // com.bytedance.msdk.api.b.d
                public boolean d() {
                    return zOptBoolean;
                }

                @Override // com.bytedance.msdk.api.b.d
                public float hc() {
                    return iOptInt2;
                }

                @Override // com.bytedance.msdk.api.b.d
                public String b() {
                    return strOptString;
                }

                @Override // com.bytedance.msdk.api.b.d
                @DungeonFlag
                public Map<String, Object> c() {
                    HashMap map = new HashMap();
                    map.put("isGroMoreServerSideVerify", Boolean.TRUE);
                    map.put(ServerSideVerificationOptions.TRANS_ID, d.this.cb);
                    map.put("reason", Integer.valueOf(iOptInt));
                    map.put("gromoreExtra", (d.this.uo == null || d.this.uo.hv() == null) ? "" : d.this.uo.hv().get("gromoreExtra"));
                    map.put("errorCode", Integer.valueOf(d.this.mk));
                    map.put("errorMsg", d.this.mq);
                    com.bytedance.msdk.api.b bVarD = k.d(d.this.uo, d.this.k, true);
                    map.put("adnName", bVarD != null ? bVarD.mq() : "");
                    map.put(SplashAd.KEY_BIDFAIL_ECPM, bVarD != null ? bVarD.uo() : "");
                    return map;
                }
            };
            if (this.gb && this.w != null && !this.tt) {
                com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- verify接口请求回来，给开发者verify回调");
                this.tt = true;
                this.w.d(this.h);
            }
            d(z, jCurrentTimeMillis);
            return;
        }
        com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify data is null");
        d(-1, "data is null", z);
    }

    private void d(boolean z, long j) {
        zw.d(z ? "v4Enc_reward" : "v2Enc_reward", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, String str, boolean z) {
        zw.d(z ? "v4Enc_reward" : "v2Enc_reward", false, 0L, "code = " + i + "，msg = " + str);
    }

    private void an() {
        com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- showListen回调进来，开始计时");
        an.d(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.an != -1 || d.this.c || d.this.u) {
                    com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，已经destroy，或者skip，或者比complete/verify回调还晚，直接return");
                    return;
                }
                com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，发起请求");
                d.this.h();
                an.d(d.this.new RunnableC0234d(1), com.alipay.sdk.m.u.b.a);
                an.d(d.this.new RunnableC0234d(2), 6000L);
                an.d(d.this.new RunnableC0234d(3), 9000L);
            }
        }, this.hc);
    }

    /* renamed from: com.bytedance.msdk.core.admanager.reward.d$d, reason: collision with other inner class name */
    private class RunnableC0234d implements Runnable {
        private final int hc;

        RunnableC0234d(int i) {
            this.hc = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.h != null || d.this.tt || !d.this.tc || d.this.c || d.this.u) {
                return;
            }
            com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide reward verify 进行第" + this.hc + "次重试请求");
            d.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public void h() {
        u uVarHc = com.bytedance.msdk.c.hc.d().hc().hc();
        uVarHc.d(com.bytedance.msdk.core.b.c());
        final long jCurrentTimeMillis = System.currentTimeMillis();
        String strGb = com.bytedance.msdk.core.d.mk().gb();
        if (!TextUtils.isEmpty(strGb)) {
            uVarHc.hc("X-Tt-Env", strGb);
            uVarHc.hc("x-use-ppe", "1");
        }
        uVarHc.hc("User-Agent", com.bytedance.msdk.hc.hc.d);
        final boolean z = !com.bytedance.msdk.core.hc.hc().b();
        if (z) {
            uVarHc.hc("x-pglcypher", "4");
            uVarHc.d(MediaTypeUtils.APPLICATION_OCTET_STREAM, fs.hc(d(true)));
        } else {
            uVarHc.b(d(false));
        }
        uVarHc.d(new com.bytedance.sdk.component.tt.d.d() { // from class: com.bytedance.msdk.core.admanager.reward.d.7
            @Override // com.bytedance.sdk.component.tt.d.d
            public void d(c cVar, final com.bytedance.sdk.component.tt.hc hcVar) {
                an.d(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.d.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.d(hcVar, z, jCurrentTimeMillis);
                    }
                });
            }

            @Override // com.bytedance.sdk.component.tt.d.d
            public void d(c cVar, final IOException iOException) {
                an.d(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.d.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.msdk.d.u.b.d("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify http error: " + iOException.toString());
                        d.this.d(-2, "request error" + iOException.getMessage(), z);
                    }
                });
            }
        });
    }

    @DungeonFlag
    private String d(boolean z) throws JSONException {
        String string;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version", com.bytedance.msdk.hc.hc.hc());
            jSONObject.put(ILogConst.Keys.KEY_PLUGIN_VERSION, com.bytedance.msdk.hc.hc.c());
            jSONObject.put(com.alipay.sdk.m.l.b.b, com.bytedance.msdk.hc.hc.d);
            jSONObject.put("try_value", this.d.getAndIncrement());
            jSONObject.put(PointCategory.NETWORK, np.u());
            jSONObject.put("play_start_ts", this.e);
            jSONObject.put("play_end_ts", System.currentTimeMillis());
            com.bytedance.msdk.api.d.hc hcVar = this.uo;
            jSONObject.put("user_id", hcVar != null ? hcVar.z() : "");
            if (TextUtils.isEmpty(this.cb)) {
                string = UUID.randomUUID().toString();
                this.cb = string;
            } else {
                string = this.cb;
            }
            jSONObject.put(WindAds.TRANS_ID, string);
            com.bytedance.msdk.api.d.hc hcVar2 = this.uo;
            jSONObject.put("link_id", hcVar2 != null ? hcVar2.d() : "");
            com.bytedance.msdk.api.d.hc hcVar3 = this.uo;
            jSONObject.put("prime_rit", hcVar3 != null ? hcVar3.v() : "");
            b bVar = this.k;
            jSONObject.put("adn_rit", bVar != null ? bVar.ph() : "");
            com.bytedance.msdk.api.d.hc hcVar4 = this.uo;
            jSONObject.put("reward_name", hcVar4 != null ? hcVar4.j() : "");
            com.bytedance.msdk.api.d.hc hcVar5 = this.uo;
            jSONObject.put("reward_amount", hcVar5 != null ? hcVar5.s() : 0);
            com.bytedance.msdk.api.d.hc hcVar6 = this.uo;
            jSONObject.put("media_extra", (hcVar6 == null || hcVar6.hv() == null) ? "" : this.uo.hv().get("gromoreExtra"));
            com.bytedance.msdk.api.d.hc hcVar7 = this.uo;
            if (hcVar7 != null && hcVar7.np() != null) {
                jSONObject.put("scenario_id", this.uo.np());
            }
            com.bytedance.msdk.api.b bVarD = k.d(this.uo, this.k, true);
            jSONObject.put("adn_name", bVarD != null ? bVarD.mq() : "");
            jSONObject.put(SplashAd.KEY_BIDFAIL_ECPM, bVarD != null ? bVarD.uo() : "");
        } catch (JSONException e) {
            mq.d(e);
        }
        if (z) {
            return jSONObject.toString();
        }
        return fs.d(jSONObject).toString();
    }

    public void d(hc hcVar) {
        this.w = hcVar;
    }
}
