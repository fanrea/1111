package com.bytedance.msdk.core.gb;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq {
    private static final String d = "TTMediationSDK_mq";
    private Map<String, Long> hc;

    private mq() {
        this.hc = new ConcurrentHashMap();
    }

    public static mq d() {
        return d.d;
    }

    private static class d {
        private static mq d = new mq();
    }

    public long d(String str, String str2) {
        Long l = this.hc.get(str + Config.replace + str2);
        if (l == null) {
            return -2L;
        }
        return l.longValue();
    }

    public void hc(final String str, final String str2) {
        com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.core.gb.mq.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.d.u.b.d(mq.d, "adn updateShowPacingTime ritId = " + str + " adnSlotId = " + str2);
                tt ttVarC = mq.this.c(str, str2);
                if (ttVarC == null || !ttVarC.gb()) {
                    return;
                }
                Date date = new Date();
                com.bytedance.msdk.d.u.b.d(mq.d, "adn updateShowPacingTime save time = " + an.hc(date.getTime()));
                mq.this.d(str, str2, date.getTime());
            }
        });
    }

    public boolean b(String str, String str2) {
        String str3 = d;
        com.bytedance.msdk.d.u.b.d(str3, "adn checkPacing ritId = " + str + " adnSlotId = " + str2);
        tt ttVarC = c(str, str2);
        if (ttVarC != null && ttVarC.gb() && ttVarC.mq()) {
            long time = new Date().getTime();
            long jMk = ttVarC.mk();
            long jMk2 = ttVarC.mk() + ttVarC.tt();
            com.bytedance.msdk.d.u.b.d(str3, "adn checkPacing currentTime = " + an.hc(time) + " showTime = " + an.hc(jMk) + " pacingBean.getPacing() = " + ttVarC.tt() + " pacingTime = " + an.hc(jMk2));
            if (time <= jMk2) {
                this.hc.put(str + Config.replace + str2, Long.valueOf(time - jMk));
                return false;
            }
        }
        return true;
    }

    public boolean d(tt ttVar) {
        if (ttVar == null) {
            return false;
        }
        tt ttVarC = c(ttVar.hc(), ttVar.b());
        if (ttVarC == null) {
            com.bytedance.msdk.d.u.b.d(d, "adn pacing 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(ttVar.tc())) {
            com.bytedance.msdk.d.u.b.d(d, "adn pacing ruleId 为空 清空本地数据 ");
            delete(ttVar.hc(), ttVar.b());
            return false;
        }
        if (TextUtils.equals(ttVarC.tc(), ttVar.tc())) {
            com.bytedance.msdk.d.u.b.d(d, "adn pacing ruleId 一致 ruleId = " + ttVarC.tc() + " 无需处理");
            return false;
        }
        com.bytedance.msdk.d.u.b.d(d, "adn pacing ruleId不一致，缓存新规则 old ruleId = " + ttVarC.tc() + "  new ruleId = " + ttVar.tc());
        delete(ttVar.hc(), ttVar.b());
        return true;
    }

    public void hc(tt ttVar) {
        tc.d().d(ttVar);
    }

    public void delete(String str, String str2) {
        tc.d().d(str, str2);
    }

    public tt c(String str, String str2) {
        return tc.d().hc(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, long j) {
        tc.d().d(str, str2, j);
    }
}
