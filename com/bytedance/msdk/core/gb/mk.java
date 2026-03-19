package com.bytedance.msdk.core.gb;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.forbes.Config;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk {
    private static final String d = "TTMediationSDK_mk";
    private Map<String, Pair<String, String>> hc;

    private mk() {
        this.hc = new ConcurrentHashMap();
    }

    public static mk d() {
        return d.d;
    }

    private static class d {
        private static mk d = new mk();
    }

    public Pair<String, String> d(String str, String str2) {
        return this.hc.get(str + Config.replace + str2);
    }

    public void hc(final String str, final String str2) {
        com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.core.gb.mk.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.d.u.b.d(mk.d, "adn addShowFreqctlCount ritId = " + str + " adnSlotId = " + str2);
                h hVarC = mk.this.c(str, str2);
                if (hVarC == null || !hVarC.gb()) {
                    return;
                }
                for (u uVar : hVarC.mk()) {
                    if (uVar.u() < uVar.d()) {
                        mk.this.d(hVarC, uVar.b(), uVar.u() + 1);
                    }
                }
            }
        });
    }

    public boolean b(String str, String str2) {
        com.bytedance.msdk.d.u.b.d(d, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2);
        h hVarC = c(str, str2);
        if (hVarC == null || !hVarC.gb()) {
            return true;
        }
        for (u uVar : hVarC.mk()) {
            Date date = new Date();
            String str3 = d;
            com.bytedance.msdk.d.u.b.d(str3, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2 + "  date = " + date.getTime() + " item.getEffectiveTime() = " + uVar.c());
            if (date.getTime() <= uVar.c()) {
                if (uVar.u() < uVar.d()) {
                    com.bytedance.msdk.d.u.b.d(str3, "adn checkFreqctl 未到上线可以展示 ritId = " + str + " adnSlotId = " + str2 + " ruleId = " + uVar.b() + " count = " + uVar.u());
                } else {
                    com.bytedance.msdk.d.u.b.d(str3, "adn checkFreqctl 到了上线不可以展示 ritId = " + str + " adnSlotId = " + str2 + " ruleId = " + uVar.b() + " count = " + uVar.u());
                    this.hc.put(str + Config.replace + str2, new Pair<>(uVar.b(), new StringBuilder().append(uVar.u()).toString()));
                    return false;
                }
            } else {
                d(hVarC, uVar.b(), 0);
                d(hVarC, uVar.b(), an.d(uVar.hc()));
                com.bytedance.msdk.d.u.b.d(str3, "adn checkFreqctl 有效期外计数需要清0，过期时间需要更新 = " + uVar.b());
            }
        }
        return true;
    }

    public boolean d(h hVar) {
        if (hVar == null) {
            return false;
        }
        h hVarC = c(hVar.hc(), hVar.b());
        if (hVarC == null) {
            com.bytedance.msdk.d.u.b.d(d, "adn freqctl 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(hVar.an())) {
            com.bytedance.msdk.d.u.b.d(d, "adn freqctl version 为空 清空本地数据 ");
            delete(hVarC.hc(), hVarC.b());
            return false;
        }
        if (TextUtils.equals(hVarC.an(), hVar.an())) {
            com.bytedance.msdk.d.u.b.d(d, "adn freqctl version 一致 version = " + hVarC.an() + " 无需处理");
            return false;
        }
        com.bytedance.msdk.d.u.b.d(d, "adn freqctl version不一致，缓存新规则 old version = " + hVarC.an() + "  new version " + hVar.an());
        return true;
    }

    public void hc(h hVar) {
        uo.d().hc(hVar);
    }

    public void delete(String str, String str2) {
        gb.d().d(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h c(String str, String str2) {
        return gb.d().hc(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(h hVar, String str, int i) {
        gb.d().d(hVar, str, i);
    }

    private void d(h hVar, String str, long j) {
        gb.d().d(hVar, str, j);
    }
}
