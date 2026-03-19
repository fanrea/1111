package com.fc.tjcpl.sdk.a;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class g implements View.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ f b;

    public g(f fVar, boolean z) {
        this.b = fVar;
        this.a = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        this.b.i.setVisibility(4);
        if (this.a) {
            this.b.c();
        } else {
            this.b.l = true;
            com.fc.tjcpl.sdk.b.a.b(this.b.h.getApplicationContext());
        }
    }
}
