package com.bytedance.bdtracker;

import com.bytedance.applog.profile.UserProfileCallback;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class l3 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ n3 b;

    public l3(n3 n3Var, int i) {
        this.b = n3Var;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserProfileCallback userProfileCallback = this.b.d;
        if (userProfileCallback != null) {
            userProfileCallback.onFail(this.a);
        }
    }
}
