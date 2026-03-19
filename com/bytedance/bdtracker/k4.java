package com.bytedance.bdtracker;

import com.bytedance.applog.log.LoggerImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k4 implements Runnable {
    public final /* synthetic */ l4 a;

    public k4(l4 l4Var) {
        this.a = l4Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.a.a.size(); i++) {
            try {
                String[] strArr = {"openudid", "clientudid", "serial_number", "sim_serial_number", "udid", com.baidu.mobads.upgrade.remote.gray.c.l};
                for (int i2 = 0; i2 < 6; i2++) {
                    String str = strArr[i2];
                    try {
                        l4 l4Var = this.a;
                        l4Var.a(l4Var.a.get(i), str);
                    } catch (Exception e) {
                        LoggerImpl.global().error("DeprecatedFileCleaner execute failed", e, new Object[0]);
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
    }
}
