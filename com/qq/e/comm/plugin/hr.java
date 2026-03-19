package com.qq.e.comm.plugin;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import java.util.List;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class hr implements NUADI {
    private final NUADI a;

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
    }

    public hr(Context context, String str, String str2, String str3, ADListener aDListener) {
        this.a = i1.a(context, str, str2, str3, aDListener);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i) {
        this.a.loadData(i);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setCategories(List<String> list) {
        this.a.setCategories(list);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMinVideoDuration(int i) {
        this.a.setMinVideoDuration(i);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMaxVideoDuration(int i) {
        this.a.setMaxVideoDuration(i);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public String getAdNetWorkName() {
        return this.a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i, LoadAdParams loadAdParams) {
        this.a.loadData(i, loadAdParams);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVastClassName(String str) {
        this.a.setVastClassName(str);
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        this.a.sendLossNotification(map);
    }
}
