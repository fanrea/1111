package com.baidu.mobads.container.components.a;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class m implements DialogInterface.OnKeyListener {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return false;
    }
}
