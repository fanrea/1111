package com.ss.android.downloadlib;

import com.ss.android.downloadlib.h.mq;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.socialbase.appdownloader.b.cb;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class tt {
    private static final String d = "tt";
    private static boolean hc = false;

    private static class d {
        private static tt d = new tt();
    }

    private tt() {
    }

    public static tt d() {
        return d.d;
    }

    public void d(com.ss.android.downloadlib.addownload.hc.u uVar, final com.ss.android.hc.d.hc.hc hcVar) throws JSONException {
        if (!com.ss.android.downloadlib.h.u.b(hcVar)) {
            mq.d().d(d, "checkMarketInstallFinishEvent", "开关未开启, 不使用动态广播监听能力");
            return;
        }
        if (hcVar == null) {
            mq.d().hc(d, "checkMarketInstallFinishEvent", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (hcVar.ra()) {
            mq.d().hc(d, "checkMarketInstallFinishEvent", "正在监听中,不重复监听");
            return;
        }
        try {
            mq mqVarD = mq.d();
            String str = d;
            mqVarD.d(str, "checkMarketInstallFinishEvent", "针对商店直投广告,开始检测安装完成事件");
            if (com.ss.android.downloadlib.h.u.c(hcVar)) {
                mq.d().d(str, "checkMarketInstallFinishEvent", "开始进行动态广播监听");
                int iOptInt = com.ss.android.downloadlib.addownload.mq.tt().optInt("market_install_finish_check_time", 600);
                if (hcVar.qr() == 0 || System.currentTimeMillis() - hcVar.qr() > iOptInt * 1000) {
                    hcVar.tc(System.currentTimeMillis());
                    d(iOptInt, new cb() { // from class: com.ss.android.downloadlib.tt.1
                        @Override // com.ss.android.socialbase.appdownloader.b.cb
                        public void d() {
                            mq.d().d(tt.d, "checkMarketInstallFinishEvent", "注册广播监听成功,注册耗时" + (System.currentTimeMillis() - hcVar.qr()));
                            hcVar.tc(true);
                            com.ss.android.downloadlib.addownload.hc.an.d().d(hcVar);
                        }

                        @Override // com.ss.android.socialbase.appdownloader.b.cb
                        public void hc() {
                            mq.d().d(tt.d, "checkMarketInstallFinishEvent", "广播监听时间结束,主动解除了广播监听");
                            if (!uo.hc(hcVar)) {
                                mq.d().d(tt.d, "checkMarketInstallFinishEvent", "监听结束依然没有完成安装");
                            }
                            hcVar.tc(false);
                            com.ss.android.downloadlib.addownload.hc.an.d().d(hcVar);
                        }
                    });
                } else {
                    mq.d().d(str, "checkMarketInstallFinishEvent", "目前仍在广播监听的生效期内,不进行重复注册");
                }
            }
            if (com.ss.android.downloadlib.h.u.u(hcVar)) {
                mq.d().d(str, "checkMarketInstallFinishEvent", "开启轮询线程能力,作为容灾手段");
                com.ss.android.downloadlib.addownload.uo.d().d(hcVar);
            }
            com.ss.android.downloadlib.addownload.hc.tt.d().d(hcVar);
        } catch (Exception unused) {
            com.ss.android.downloadlib.u.b.d().d(false, "监听商店场景安装完成事件发生异常");
        }
    }

    public void d(final com.ss.android.hc.d.hc.hc hcVar) {
        if (!com.ss.android.downloadlib.h.u.b(hcVar)) {
            mq.d().d(d, "checkMarketInstallFinishEventForReboot", "线程轮询总开关未开启,因此不执行兜底逻辑");
            return;
        }
        if (hcVar == null) {
            mq.d().hc(d, "checkMarketInstallFinishEventForReboot", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (hcVar.u.get() && System.currentTimeMillis() - hcVar.qr() > 30000) {
            mq.d().d(d, "checkMarketInstallFinishEventForReboot", "兜底过一次了,不进行重复兜底");
            return;
        }
        if (com.ss.android.downloadlib.h.u.c(hcVar)) {
            long jOptInt = com.ss.android.downloadlib.addownload.mq.tt().optInt("market_install_finish_check_time", 600) * 1000;
            if (System.currentTimeMillis() - hcVar.qr() >= jOptInt) {
                mq.d().d(d, "checkMarketInstallFinishEventForReboot", "当前时间距离首次检测时间超出了广播生效期,不再执行兜底策略");
            } else {
                d((int) (((hcVar.qr() + jOptInt) - System.currentTimeMillis()) / 1000), new cb() { // from class: com.ss.android.downloadlib.tt.2
                    @Override // com.ss.android.socialbase.appdownloader.b.cb
                    public void d() {
                        mq.d().d(tt.d, "checkMarketInstallFinishEventForReboot", "进程被杀,重新注册广播监听成功,正式执行冷启兜底逻辑");
                        hcVar.u.compareAndSet(false, true);
                        com.ss.android.downloadlib.addownload.hc.tt.d().d(hcVar);
                    }

                    @Override // com.ss.android.socialbase.appdownloader.b.cb
                    public void hc() {
                        mq.d().d(tt.d, "checkMarketInstallFinishEventForReboot", "兜底监听执行完毕,解除广播监听");
                        if (!uo.hc(hcVar)) {
                            mq.d().d(tt.d, "checkMarketInstallFinishEventForReboot", "监听结束依然没有完成安装");
                        }
                        hcVar.u.compareAndSet(true, false);
                        hcVar.tc(false);
                        com.ss.android.downloadlib.addownload.hc.tt.d().d(hcVar);
                    }
                });
            }
        }
    }

    public void d(int i, cb cbVar) {
        mq.d().d(d, "registerMarketInstallFinishBroadcast", "动态广播监听的持续时间为:".concat(String.valueOf(i)));
        if (!hc) {
            com.ss.android.socialbase.appdownloader.c.mk().d(cbVar);
            hc = true;
        }
        com.ss.android.socialbase.appdownloader.c.mk().d(i);
    }
}
