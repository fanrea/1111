package com.baidu.mobads.container.components.e;

import android.net.NetworkInfo;
import com.baidu.mobads.container.components.e.b;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements IOAdEventListener {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        try {
            bq.a().a(f.a, "网络状态已经改变");
            NetworkInfo networkInfoC = com.baidu.mobads.container.util.e.a.c(this.a.c);
            if (networkInfoC == null || !networkInfoC.isConnected()) {
                bq.a().a(f.a, "没有可用网络");
                return;
            }
            int type = networkInfoC.getType();
            bq.a().a(f.a, "当前网络类型：" + type);
            ArrayList<b> arrayListB = this.a.b();
            if (arrayListB != null) {
                for (b bVar : arrayListB) {
                    if (type == 1) {
                        if (bVar.i() == b.a.ERROR || bVar.i() == b.a.PAUSED) {
                            try {
                                bVar.c();
                            } catch (Exception e) {
                                bq.a().a(f.a, e);
                            }
                        }
                    } else if (type == 0) {
                        bq.a().a(f.a, "mobile net work");
                        if (!bVar.v()) {
                            if (bVar.i() == b.a.ERROR || bVar.i() == b.a.PAUSED) {
                                try {
                                    bVar.c();
                                } catch (Exception e2) {
                                    bq.a().a(f.a, e2);
                                }
                            }
                        } else {
                            try {
                                bVar.b(false);
                                bVar.a(0);
                            } catch (Exception e3) {
                                bq.a().a(f.a, e3);
                            }
                        }
                    }
                }
            }
        } catch (Exception e4) {
            bq.a().a(f.a, e4);
        }
    }
}
