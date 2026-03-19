package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class q implements Runnable {
    final /* synthetic */ IOAdEvent a;
    final /* synthetic */ p b;

    q(p pVar, IOAdEvent iOAdEvent) {
        this.b = pVar;
        this.a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        IOAdEvent iOAdEvent = this.a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.a.getType();
        if (z.ap.equals(type)) {
            List<CpuChannelResponse> listA = n.a((JSONArray) this.a.getData().get("cpuChannelList"));
            if (this.b.a.t != null) {
                this.b.a.t.onChannelListLoaded(listA);
                return;
            }
            return;
        }
        if (z.aq.equals(type)) {
            Map<String, Object> data = this.a.getData();
            int iIntValue = 0;
            if (data != null) {
                str = (String) data.get("error_message");
                Object obj = data.get("error_code");
                if (obj == null) {
                    obj = 0;
                }
                iIntValue = ((Integer) obj).intValue();
            } else {
                str = "";
            }
            if (this.b.a.t != null) {
                this.b.a.t.onChannelListError(str, iIntValue);
            }
        }
    }
}
