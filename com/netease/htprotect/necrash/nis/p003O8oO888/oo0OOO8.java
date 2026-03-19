package com.netease.htprotect.necrash.nis.p003O8oO888;

import android.net.ConnectivityManager;
import com.netease.htprotect.necrash.nis.p003O8oO888.Ooo;
import java.util.TimerTask;

/* renamed from: com.netease.htprotect.necrash.nis.O8〇oO8〇88.oo0〇OO〇O8, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class oo0OOO8 extends TimerTask {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    final /* synthetic */ ConnectivityManager f135O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    final /* synthetic */ Ooo.O8oO888 f136O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    final /* synthetic */ ConnectivityManager.NetworkCallback f137Ooo;

    oo0OOO8(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback, Ooo.O8oO888 o8oO888) {
        this.f135O8oO888 = connectivityManager;
        this.f137Ooo = networkCallback;
        this.f136O8 = o8oO888;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f135O8oO888.unregisterNetworkCallback(this.f137Ooo);
        this.f136O8.mo569O8oO888(10002, "当前状态为wifi和数据流量同时开启，切换到数据流量超时，请重试");
    }
}
