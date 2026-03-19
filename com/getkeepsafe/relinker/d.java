package com.getkeepsafe.relinker;

import android.os.Build;
import com.getkeepsafe.relinker.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class d implements b.InterfaceC0389b {
    d() {
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0389b
    public final void loadLibrary(String str) {
        System.loadLibrary(str);
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0389b
    public final void j(String str) {
        System.load(str);
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0389b
    public final String mapLibraryName(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0389b
    public final String k(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0389b
    public final String[] supportedAbis() {
        if (Build.VERSION.SDK_INT < 21 || Build.SUPPORTED_ABIS.length <= 0) {
            return !e.isEmpty(Build.CPU_ABI2) ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : new String[]{Build.CPU_ABI};
        }
        return Build.SUPPORTED_ABIS;
    }
}
