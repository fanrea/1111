package com.fc.tjcpl.sdk.a;

import com.fc.tjcpl.sdk.TJActivity;
import com.fc.tjcpl.sdk.n.x;
import com.fc.tjcpl.sdk.n.y;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b extends x {
    public final /* synthetic */ y a;
    public final /* synthetic */ TJActivity b;

    public b(TJActivity tJActivity, y yVar) {
        this.b = tJActivity;
        this.a = yVar;
    }

    @Override // com.fc.tjcpl.sdk.n.x
    public void a() {
        this.a.a();
        this.b.a(false);
    }

    @Override // com.fc.tjcpl.sdk.n.x
    public void b() {
        this.a.a();
        this.b.b = true;
        com.fc.tjcpl.sdk.b.a.b(this.b.getApplicationContext());
    }
}
