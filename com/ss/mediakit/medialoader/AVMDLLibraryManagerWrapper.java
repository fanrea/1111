package com.ss.mediakit.medialoader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AVMDLLibraryManagerWrapper {
    public static final int LOADBASELIB = 4;
    public static final int LOADP2PLIB = 1;
    public static final int LOADSSL = 32;
    public static final int LOADTTNETLIB = 2;
    public static final int LOADV1LIB = 8;
    public static final int LOADV2LIB = 16;
    public static final int LOADVCN = 64;

    public static void setLibraryLoadLevel(int i) {
        AVMDLLibraryManager.setLibraryLoadLevel(i);
    }

    public static void setBoringSSLDependency(boolean z) {
        AVMDLLibraryManager.setBoringSSLDependency(z);
    }

    public static void setEnableV2(boolean z) {
        AVMDLLibraryManager.setEnableV2(z);
    }

    public static void setVcnDependency(boolean z) {
        AVMDLLibraryManager.setVcnDependency(z);
    }

    public static void setLibraryLoader(IAVMDLLibraryLoader iAVMDLLibraryLoader) {
        AVMDLLibraryManager.setLibraryLoader(iAVMDLLibraryLoader);
    }

    public static void setNeedBase(boolean z) {
        AVMDLLibraryManager.setNeedBase(z);
    }

    public static void setNeedP2pLib(boolean z) {
        AVMDLLibraryManager.setNeedP2PLib(z);
    }

    public static void setNeedTTnetLib(boolean z) {
        AVMDLLibraryManager.setNeedTTnetLib(z);
    }

    public static void setUseShadowVersion(boolean z) {
        AVMDLLibraryManager.setUseShadowVersion(z);
    }
}
