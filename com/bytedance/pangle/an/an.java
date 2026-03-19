package com.bytedance.pangle.an;

import android.os.SystemClock;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.tt;
import com.bytedance.pangle.util.uo;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {

    interface d {
        boolean d(String str, int i);
    }

    public static void d() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "start");
        if (GlobalParam.getInstance().isCloseBgDex2oat()) {
            return;
        }
        if ((tt.h() || tt.tt() || tt.b()) && com.bytedance.pangle.u.c.hc(Zeus.getAppApplication())) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "post");
            com.bytedance.pangle.u.u.hc(new Runnable() { // from class: com.bytedance.pangle.an.an.1
                @Override // java.lang.Runnable
                public void run() {
                    GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "exec");
                    SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
                    an.hc();
                }
            });
        }
    }

    public static synchronized void hc() {
        Map<String, ?> all = hc.d(Zeus.getAppApplication()).getAll();
        if (all.size() > 0) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat start:" + entry.getKey());
                if (b().d(entry.getKey(), ((Integer) entry.getValue()).intValue())) {
                    hc.d(Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat success:" + entry.getKey());
                    uo.d().b(entry.getKey(), ((Integer) entry.getValue()).intValue(), true);
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat markDexOptState:" + entry.getKey());
                } else {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat failed:" + entry.getKey());
                }
            }
        }
    }

    public static d b() {
        if (tt.tt()) {
            return new u();
        }
        if (tt.h()) {
            return new c();
        }
        if (tt.b()) {
            return new b();
        }
        return new d() { // from class: com.bytedance.pangle.an.an.2
            @Override // com.bytedance.pangle.an.an.d
            public boolean d(String str, int i) {
                return true;
            }
        };
    }
}
