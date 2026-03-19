package com.bytedance.pangle.h;

import android.os.RemoteException;
import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends c.d {
    private final ZeusPluginInstallListener d;

    public hc(ZeusPluginInstallListener zeusPluginInstallListener) {
        this.d = zeusPluginInstallListener;
    }

    @Override // com.bytedance.pangle.c
    public void d(String str, int i, String str2) throws RemoteException {
        ZeusPluginInstallListener zeusPluginInstallListener = this.d;
        if (zeusPluginInstallListener != null) {
            zeusPluginInstallListener.onPluginInstall(str, i, str2);
        }
    }
}
