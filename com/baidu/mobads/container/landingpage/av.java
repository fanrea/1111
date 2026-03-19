package com.baidu.mobads.container.landingpage;

import com.baidu.mobads.container.util.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class av implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ XDLJsInterface c;

    av(XDLJsInterface xDLJsInterface, String str, String str2) {
        this.c = xDLJsInterface;
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.c.c.loadUrl(String.format("javascript:(function(){baidu.mobads.Sdk.natFireEvent('%s', '%s')})()", this.a, this.b));
        } catch (Exception e) {
            bq.a().a(XDLJsInterface.TAG, e.getMessage());
        }
    }
}
