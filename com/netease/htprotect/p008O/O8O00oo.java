package com.netease.htprotect.p008O;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.netease.htprotect.〇O.〇O8O00oo〇, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8O00oo implements ServiceConnection {

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static final ThreadPoolExecutor f235O8 = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    boolean f236O8oO888 = false;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    final LinkedBlockingQueue f237Ooo = new LinkedBlockingQueue(1);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        f235O8.execute(new oO00O(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
