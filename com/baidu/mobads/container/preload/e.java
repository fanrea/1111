package com.baidu.mobads.container.preload;

import android.view.View;
import com.baidu.mobads.container.util.bu;
import com.baidu.mobads.container.util.by;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e extends com.baidu.mobads.container.util.d.b {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.mobads.container.util.d.b, com.baidu.mobads.container.util.d.d.InterfaceC0136d
    public void a(String str, String str2, View view, int i) {
        by.a = String.valueOf(System.currentTimeMillis());
    }

    @Override // com.baidu.mobads.container.util.d.b, com.baidu.mobads.container.util.d.d.InterfaceC0136d
    public void a(String str, String str2, View view, com.baidu.mobads.container.util.d.c cVar) {
        by.b = String.valueOf(System.currentTimeMillis());
        by.a(this.a.b, bu.aL, "failure", str2);
    }

    @Override // com.baidu.mobads.container.util.d.b, com.baidu.mobads.container.util.d.d.InterfaceC0136d
    public void a(String str, String str2, View view, File file) {
        by.b = String.valueOf(System.currentTimeMillis());
        by.a(this.a.b, bu.aL, "success", str2);
    }
}
