package com.pangrowth.adclog;

import java.util.TimerTask;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c extends TimerTask {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public c(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        f.a(this.a, this.b);
    }
}
