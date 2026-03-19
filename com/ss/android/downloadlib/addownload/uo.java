package com.ss.android.downloadlib.addownload;

import android.os.SystemClock;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class uo {
    private static final String d = "uo";

    private static class hc {
        private static uo d = new uo();
    }

    private uo() {
    }

    public static uo d() {
        return hc.d;
    }

    public void d(com.ss.android.hc.d.hc.hc hcVar) {
        com.ss.android.downloadlib.h.mq.d().d(d, "tryListenInstallFinish", "开始通过轮询线程监听安装完成事件");
        com.ss.android.downloadlib.u.d().b(new d(hcVar));
    }

    private class d implements Runnable {
        private final com.ss.android.hc.d.hc.hc hc;

        d(com.ss.android.hc.d.hc.hc hcVar) {
            this.hc = hcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.hc.tc(true);
                    uo.this.hc(this.hc);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                }
            } finally {
                this.hc.tc(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(com.ss.android.hc.d.hc.hc hcVar) {
        JSONObject jSONObject = new JSONObject();
        int iD = com.ss.android.downloadlib.h.u.d(hcVar);
        int iHc = com.ss.android.downloadlib.h.u.hc(hcVar);
        if (com.ss.android.downloadlib.h.u.u(hcVar) && com.ss.android.downloadlib.h.u.c(hcVar)) {
            com.ss.android.downloadlib.h.mq.d().d(d, "tryListenInstallFinishEvent", "上层库开启二级线程轮询检测策略");
            d(hcVar, iD, iHc, jSONObject);
        } else {
            com.ss.android.downloadlib.h.mq.d().d(d, "tryListenInstallFinishEvent", "采用原有默认轮询策略");
            hc(hcVar, 15, 20000, jSONObject);
        }
    }

    private void d(com.ss.android.hc.d.hc.hc hcVar, int i, int i2, JSONObject jSONObject) {
        int iAn;
        if (hcVar.hv() == 4) {
            iAn = mq.tt().optInt("market_install_finish_check_time", 600);
        } else {
            iAn = com.ss.android.downloadlib.h.u.an(hcVar);
        }
        int i3 = ((iAn * 1000) / 20000) + 1;
        com.ss.android.downloadlib.h.mq mqVarD = com.ss.android.downloadlib.h.mq.d();
        String str = d;
        mqVarD.d(str, "realListenInstallFinishEventOpt", "一级轮询次数，即广播生效期内的轮询次数为:".concat(String.valueOf(i3)));
        if (hc(hcVar, i3, 20000, jSONObject)) {
            return;
        }
        if (iAn * 1000 < com.ss.android.downloadlib.h.u.h(hcVar)) {
            com.ss.android.downloadlib.h.mq.d().d(str, "tryListenInstallFinishEventOpt", "广播生效时间外，一级轮询完成且没有检测到安装完成事件，开始二级检测");
            if (hc(hcVar, i, i2, jSONObject)) {
                return;
            }
            com.ss.android.downloadlib.h.mq.d().d(str, "tryListenInstallFinishEventOpt", "监听时间结束,依然没有监听到安装完成事件");
            return;
        }
        com.ss.android.downloadlib.h.mq.d().d(str, "tryListenInstallFinishEventOpt", "一级轮询时间小于广播监听时间,且未监听到安装完成事件");
    }

    private boolean hc(com.ss.android.hc.d.hc.hc hcVar, int i, int i2, JSONObject jSONObject) {
        com.ss.android.downloadlib.h.mq.d().d(d, "realListenInstallFinishEvent", "开始轮询检测,轮询时间间隔为" + i2 + ",轮询次数为" + i);
        long j = i2;
        SystemClock.sleep(j);
        while (i > 0) {
            if (com.ss.android.downloadlib.h.uo.hc(hcVar)) {
                com.ss.android.downloadlib.d.d().d(hcVar.u());
                com.ss.android.downloadlib.h.mq.d().d(d, "realListenInstallFinishEvent", "检测到安装成功，当前剩余的轮询次数为".concat(String.valueOf(i)));
                return true;
            }
            i--;
            if (i == 0) {
                return false;
            }
            SystemClock.sleep(j);
        }
        return false;
    }
}
