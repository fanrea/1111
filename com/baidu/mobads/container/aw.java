package com.baidu.mobads.container;

import android.view.KeyEvent;
import com.baidu.mobads.container.bridge.ak;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aw implements ak.b {
    final /* synthetic */ au a;

    aw(au auVar) {
        this.a = auVar;
    }

    @Override // com.baidu.mobads.container.bridge.ak.b
    public boolean a(int i, KeyEvent keyEvent) {
        boolean z = i == 4;
        if (z) {
            this.a.closeExpand();
        }
        return z;
    }
}
