package com.bytedance.bdtracker;

import com.bytedance.applog.profile.UserProfileCallback;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class m3 implements Runnable {
    public final /* synthetic */ n3 a;

    public m3(n3 n3Var) {
        this.a = n3Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserProfileCallback userProfileCallback = this.a.d;
        if (userProfileCallback != null) {
            userProfileCallback.onSuccess();
        }
    }
}
