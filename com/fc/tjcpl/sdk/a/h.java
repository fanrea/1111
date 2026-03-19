package com.fc.tjcpl.sdk.a;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class h implements View.OnClickListener {
    public final /* synthetic */ f a;

    public h(f fVar) {
        this.a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.l = true;
        com.fc.tjcpl.sdk.b.a.b(this.a.h.getApplicationContext());
    }
}
