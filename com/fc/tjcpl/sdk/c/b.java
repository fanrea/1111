package com.fc.tjcpl.sdk.c;

import android.content.Intent;
import com.fc.tjcpl.sdk.apploader.NonWifiWarnActivity;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b {
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final AtomicBoolean b;
    public final Object c;
    public a d;

    public b(a aVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        this.b = atomicBoolean;
        this.c = new Object();
        this.d = aVar;
        atomicBoolean.set(aVar.h);
    }

    public void a() {
        this.a.set(true);
        Intent intent = new Intent(this.d.a, (Class<?>) NonWifiWarnActivity.class);
        intent.setFlags(268435456);
        this.d.a.startActivity(intent);
    }
}
