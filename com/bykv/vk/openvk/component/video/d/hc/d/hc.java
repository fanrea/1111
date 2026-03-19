package com.bykv.vk.openvk.component.video.d.hc.d;

import android.content.Context;
import com.bykv.vk.openvk.component.video.d.hc.c;
import com.bykv.vk.openvk.component.video.d.hc.u;
import com.bytedance.sdk.component.tc.tt;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends d {
    public final File d;

    public void d() {
        com.bykv.vk.openvk.component.video.d.b.d.d(new tt("clear") { // from class: com.bykv.vk.openvk.component.video.d.hc.d.hc.1
            @Override // java.lang.Runnable
            public void run() {
                hc.this.hc();
            }
        });
    }

    public void hc() {
        c.b().c();
        Context context = u.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.d.hc.hc.b.d(context).d(1);
        }
        for (File file : this.d.listFiles()) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.d.d
    public File b(String str) {
        return u(str);
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.d.d
    public File c(String str) {
        return u(str);
    }

    File u(String str) {
        return new File(this.d, str);
    }
}
