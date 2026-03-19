package com.netease.htprotect.necrash.nis.p003O8oO888;

import android.net.ConnectivityManager;
import android.net.Network;
import com.netease.htprotect.necrash.nis.p003O8oO888.Ooo;
import java.util.Timer;

/* renamed from: com.netease.htprotect.necrash.nis.O8〇oO8〇88.OO〇8, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class OO8 extends ConnectivityManager.NetworkCallback {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    final /* synthetic */ Timer f112O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    final /* synthetic */ String f113O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    final /* synthetic */ boolean[] f114Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    final /* synthetic */ Ooo.O8oO888 f115o0o0;

    /* renamed from: 〇oO, reason: contains not printable characters */
    final /* synthetic */ ConnectivityManager f116oO;

    OO8(Timer timer, boolean[] zArr, String str, Ooo.O8oO888 o8oO888, ConnectivityManager connectivityManager) {
        this.f112O8oO888 = timer;
        this.f114Ooo = zArr;
        this.f113O8 = str;
        this.f115o0o0 = o8oO888;
        this.f116oO = connectivityManager;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
        o8o0.m581Ooo("切换网络成功");
        this.f112O8oO888.cancel();
        this.f112O8oO888.purge();
        if (!this.f114Ooo[0]) {
            Ooo.m594O8oO888(this.f113O8, false, false, null, null, network, this.f115o0o0);
            this.f114Ooo[0] = true;
        }
        this.f116oO.unregisterNetworkCallback(this);
    }
}
