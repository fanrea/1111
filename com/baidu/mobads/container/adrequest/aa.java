package com.baidu.mobads.container.adrequest;

import android.app.Activity;
import android.content.Intent;
import com.baidu.mobads.container.rewardvideo.NativeRewardActivity;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.baidu.mobads.container.util.bo;
import com.baidu.mobads.sdk.api.IActivityImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aa implements Runnable {
    final /* synthetic */ y a;

    aa(y yVar) {
        this.a = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object remoteRewardActivity;
        if (this.a.C == null) {
            return;
        }
        try {
            Class<?> clsH = this.a.H();
            if ("rvideo".equals(this.a.k())) {
                if (this.a.G.size() > 1 || this.a.N()) {
                    remoteRewardActivity = new com.baidu.mobads.container.rewardvideo.a(this.a, this.a.G);
                } else {
                    remoteRewardActivity = new NativeRewardActivity(this.a);
                }
            } else {
                remoteRewardActivity = new RemoteRewardActivity(this.a);
            }
            bo.a(clsH, "setActivityImp", new Class[]{IActivityImpl.class}, new Object[]{remoteRewardActivity});
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this.a.C, this.a.H());
        if (!(this.a.C instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("orientation", this.a.R());
        boolean zOptBoolean = this.a.w().optBoolean("useSurfaceView", false);
        int iOptInt = this.a.w().optInt("downloadConfirmPolicy", 3);
        intent.putExtra("useSurfaceView", zOptBoolean);
        intent.putExtra("downloadConfirmPolicy", iOptInt);
        intent.putExtra("showDialogOnSkip", this.a.D);
        intent.putExtra("userid", this.a.E);
        intent.putExtra("extra", this.a.F);
        this.a.C.startActivity(intent);
    }
}
