package com.bykv.vk.openvk.component.video.d.hc.u;

import android.text.TextUtils;
import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.mq;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements hc {
    private mq d;

    public c() {
        this.d = null;
        this.d = com.bykv.vk.openvk.component.video.api.b.b();
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.u.hc
    public d d(u uVar) throws IOException {
        k.d dVar = new k.d();
        try {
            if (uVar.u != null) {
                for (Map.Entry<String, String> entry : uVar.u.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        dVar.hc(key, value);
                    }
                }
            }
            cb cbVarD = this.d.d(dVar.d(uVar.hc).d().hc()).d();
            com.bykv.vk.openvk.component.video.api.an.b.d("NetworkSoureVolleyImpl", "response code = ", Integer.valueOf(cbVarD.b()));
            return new an(cbVarD, uVar);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            return null;
        }
    }
}
