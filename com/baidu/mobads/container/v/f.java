package com.baidu.mobads.container.v;

import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.bridge.x;
import com.baidu.mobads.container.k;
import com.baidu.mobads.container.util.bk;
import com.baidu.mobads.container.util.bu;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f implements x {
    final /* synthetic */ d a;

    f(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.mobads.container.bridge.x
    public void onVisibilityChanged(boolean z) {
    }

    @Override // com.baidu.mobads.container.bridge.x
    public void onClose() {
    }

    @Override // com.baidu.mobads.container.bridge.x
    public void onInited() {
    }

    @Override // com.baidu.mobads.container.bridge.x
    public void onPreloadEnd(boolean z) {
    }

    @Override // com.baidu.mobads.container.bridge.x
    public void onAdFailed(String str) {
    }

    @Override // com.baidu.mobads.container.bridge.x
    public void onAdShow() {
    }

    @Override // com.baidu.mobads.container.bridge.x
    public void onAdSwitch() {
    }

    @Override // com.baidu.mobads.container.bridge.x
    public void onAdClicked(j jVar) {
        if ("rsplash".equals(this.a.mAdContainerCxt.k())) {
            if (!this.a.isSendValidSplashImpressionLoged.getAndSet(true)) {
                this.a.sendImpressionLog(this.a.mAdContainerCxt.q());
                this.a.send3rdImpressionLog(this.a.mAdContainerCxt.v());
                this.a.sendSplashViewStateInClick(0, true, 2, bu.aL, "");
            }
            boolean zOptBoolean = this.a.mAdContainerCxt.w().optBoolean("popDialogIfDl", false);
            bk.a(this.a.mAppContext, this.a.mAdContainerCxt, bk.M, 7);
            bk.a(this.a.mAppContext, this.a.mAdContainerCxt, bk.L, 8);
            HashMap<String, Object> shouBaiLpFlag = this.a.getShouBaiLpFlag(this.a.mAdContainerCxt, jVar);
            if (shouBaiLpFlag == null) {
                shouBaiLpFlag = new HashMap<>();
            }
            shouBaiLpFlag.put("use_dialog_frame", Boolean.valueOf(zOptBoolean));
            if (this.a.getCloudControlInt(com.baidu.mobads.container.components.k.c.a, 1) == 1) {
                shouBaiLpFlag.put(com.baidu.mobads.container.components.k.c.b, this.a.getCloudControlStr(com.baidu.mobads.container.components.k.c.c, com.baidu.mobads.container.components.k.c.d));
            }
            new com.baidu.mobads.container.components.k.c().a((k) this.a, jVar, (Boolean) true, shouBaiLpFlag);
        } else {
            HashMap<String, Object> shouBaiLpFlag2 = this.a.getShouBaiLpFlag(this.a.mAdContainerCxt, jVar);
            if (shouBaiLpFlag2 == null) {
                shouBaiLpFlag2 = new HashMap<>();
            }
            if (this.a.getCloudControlInt(com.baidu.mobads.container.components.k.c.a, 1) == 1) {
                shouBaiLpFlag2.put(com.baidu.mobads.container.components.k.c.b, this.a.getCloudControlStr(com.baidu.mobads.container.components.k.c.b, com.baidu.mobads.container.components.k.c.d));
            }
            new com.baidu.mobads.container.components.k.c().a((k) this.a, jVar, (Boolean) true, shouBaiLpFlag2);
        }
        this.a.d();
    }

    @Override // com.baidu.mobads.container.bridge.x
    public void setVisibility(int i) {
    }

    @Override // com.baidu.mobads.container.bridge.x
    public void onExpand(boolean z) {
    }

    @Override // com.baidu.mobads.container.bridge.x
    public void onUseCustomClose(boolean z) {
    }

    @Override // com.baidu.mobads.container.bridge.x
    public void onPlayVideo(String str) {
    }
}
