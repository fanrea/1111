package com.fc.tjcpl.sdk.n;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class z extends Dialog {
    public x a;

    public z(Context context, int i, int i2) {
        super(context, i);
        setContentView(i2);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return true;
        }
        this.a.getClass();
        return true;
    }
}
