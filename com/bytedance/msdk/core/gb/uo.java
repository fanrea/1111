package com.bytedance.msdk.core.gb;

import android.text.TextUtils;
import android.util.Pair;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo {
    private Map<String, Long> d;
    private Map<String, Pair<String, String>> hc;

    private uo() {
        hc();
    }

    public static uo d() {
        return d.d;
    }

    private static class d {
        private static uo d = new uo();
    }

    public void hc() {
        this.hc = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
    }

    public long d(String str) {
        Long l = this.d.get(str);
        if (l == null) {
            return -2L;
        }
        return l.longValue();
    }

    public void hc(final String str) {
        com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.core.gb.uo.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "updateShowPacingTime ritId = " + str);
                tt ttVarU = uo.this.u(str);
                if (ttVarU == null || !ttVarU.gb()) {
                    return;
                }
                Date date = new Date();
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "updateShowPacingTime save time = " + an.hc(date.getTime()));
                uo.this.d(str, date.getTime());
            }
        });
    }

    public boolean b(String str) {
        tt ttVarU = u(str);
        if (ttVarU != null && ttVarU.gb() && ttVarU.mq()) {
            long time = new Date().getTime();
            long jMk = ttVarU.mk();
            long jMk2 = ttVarU.mk() + ttVarU.tt();
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "checkPacing currentTime = " + an.hc(time) + " showTime = " + an.hc(jMk) + " pacingBean.getPacing() = " + ttVarU.tt() + " pacingTime = " + an.hc(jMk2));
            if (time <= jMk2) {
                this.d.put(str, Long.valueOf(time - jMk));
                return false;
            }
        }
        return true;
    }

    public boolean d(tt ttVar) {
        if (ttVar == null) {
            return false;
        }
        tt ttVarU = u(ttVar.hc());
        if (ttVarU == null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "pacing 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(ttVar.tc())) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "pacing ruleId 为空 清空本地数据 ");
            c(ttVar.c());
            return false;
        }
        if (TextUtils.equals(ttVarU.tc(), ttVar.tc())) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "pacing ruleId 一致 ruleId = " + ttVarU.tc() + " 无需处理");
            return false;
        }
        com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "pacing ruleId不一致，缓存新规则 old ruleId = " + ttVarU.tc() + "  new ruleId = " + ttVar.tc());
        com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "pacing 删除 ritId = " + ttVar.c());
        c(ttVar.c());
        return true;
    }

    public void d(String str, long j) {
        tc.d().d(str, j);
    }

    public void c(String str) {
        tc.d().d(str);
    }

    public void hc(tt ttVar) {
        tc.d().d(ttVar);
    }

    public tt u(String str) {
        return tc.d().hc(str);
    }

    public Pair<String, String> an(String str) {
        return this.hc.get(str);
    }

    public void h(final String str) {
        com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.core.gb.uo.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "addShowFreqctlCount ritId = " + str);
                h hVarTc = uo.this.tc(str);
                if (hVarTc == null || !hVarTc.gb()) {
                    return;
                }
                for (u uVar : hVarTc.mk()) {
                    if (uVar.u() < uVar.d()) {
                        uo.this.d(hVarTc, uVar.b(), uVar.u() + 1);
                    }
                }
            }
        });
    }

    public boolean gb(String str) {
        h hVarTc = tc(str);
        if (hVarTc == null || !hVarTc.gb()) {
            return true;
        }
        for (u uVar : hVarTc.mk()) {
            Date date = new Date();
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "checkFreqctl date = " + date.getTime() + " item.getEffectiveTime() = " + uVar.c());
            if (date.getTime() <= uVar.c()) {
                if (uVar.u() < uVar.d()) {
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "checkFreqctl 未到上线可以展示 ruleId = " + uVar.b() + " count = " + uVar.u());
                } else {
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "checkFreqctl 到了上线不可以展示 ruleId = " + uVar.b() + " count = " + uVar.u());
                    this.hc.put(str, new Pair<>(uVar.b(), new StringBuilder().append(uVar.u()).toString()));
                    return false;
                }
            } else {
                d(hVarTc, uVar.b(), 0);
                d(hVarTc, uVar.b(), an.d(uVar.hc()));
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "checkFreqctl 有效期外计数需要清0，过期时间需要更新 = " + uVar.b());
            }
        }
        return true;
    }

    public boolean d(h hVar) {
        if (hVar == null) {
            return false;
        }
        h hVarTc = tc(hVar.hc());
        if (hVarTc == null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "freqctl 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(hVar.u())) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "freqctl version 为空 清空本地数据 ");
            tt(hVarTc.hc());
            return false;
        }
        if (TextUtils.equals(hVarTc.u(), hVar.u())) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "freqctl version 一致 version = " + hVarTc.u() + "无需处理");
            return false;
        }
        com.bytedance.msdk.d.u.b.d("TTMediationSDK_IntervalShowControl", "freqctl version不一致，缓存新规则 old version = " + hVarTc.u() + "  new version " + hVar.u());
        return true;
    }

    public void tt(String str) {
        gb.d().d(str);
    }

    public void hc(h hVar) {
        gb.d().d(hVar);
    }

    public h tc(String str) {
        return gb.d().hc(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(h hVar, String str, int i) {
        gb.d().d(hVar, str, i);
    }

    private void d(h hVar, String str, long j) {
        gb.d().d(hVar, str, j);
    }
}
