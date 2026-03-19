package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import com.tencent.turingfd.sdk.ams.au.Phoenix;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Perseus extends Thread {
    public final /* synthetic */ Phoenix.Cdo a;
    public final /* synthetic */ Context b;

    public Perseus(Phoenix.Cdo cdo, Context context) {
        this.a = cdo;
        this.b = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.a.a.a(this.b);
    }
}
