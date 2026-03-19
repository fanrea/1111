package com.ss.mediakit.medialoader;

import android.util.Log;
import com.bytedance.boringssl.so.BoringsslLoaderWrapper;
import com.ss.mediakit.vcnlib.VcnlibloadWrapper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class AVMDLLibraryManager {
    private static final String BaseLibName = "avmdlbase";
    private static final String CryptoName = "ttcrypto";
    public static final int MediaLoadBase = 4;
    public static final int MediaLoadBoringssl = 32;
    public static final int MediaLoadP2P = 1;
    public static final int MediaLoadTTNet = 2;
    public static final int MediaLoadV1 = 8;
    public static final int MediaLoadV2 = 16;
    public static final int MediaLoadVcn = 64;
    private static final String P2PLibName = "avmdlp2p";
    private static final String SSLName = "ttboringssl";
    private static final String ShadowVerName = "avmdls";
    private static final String TTNetLibName = "avmdlttnet";
    private static final String V1LibName = "avmdl";
    private static final String V2LibName = "avmdlv2";
    private static final String VcnName = "vcn";
    private static boolean dependBoringSSl = true;
    private static boolean dependVcn = true;
    private static boolean enableV2 = false;
    private static IAVMDLLibraryLoader libraryLoader = null;
    private static int loadLevel = 0;
    private static boolean needBase = true;
    private static boolean needP2PLib = false;
    private static boolean needTTnetLib = false;
    private static boolean useShadowVersion = false;

    AVMDLLibraryManager() {
    }

    private static boolean shouldLoadLib(int i) {
        return libraryLoader != null && i > 0 && (loadLevel & i) == i;
    }

    private static boolean tryLoadLibray(int i) {
        String str;
        boolean zLoadLibrary = false;
        boolean z = true;
        if (i == 1) {
            str = P2PLibName;
        } else if (i == 2) {
            str = TTNetLibName;
        } else if (i == 4) {
            str = BaseLibName;
        } else if (i == 8) {
            str = V1LibName;
        } else {
            if (i != 16) {
                return false;
            }
            str = useShadowVersion ? ShadowVerName : V2LibName;
        }
        if (shouldLoadLib(i)) {
            zLoadLibrary = libraryLoader.loadLibrary(str);
            Log.e("ttmn", "tryLoadLibray " + str + " result: " + zLoadLibrary);
        }
        if (zLoadLibrary) {
            z = zLoadLibrary;
        } else {
            try {
                System.loadLibrary(str);
            } catch (Throwable th) {
                Log.e("ttmn", "Can't load " + str + ", cause: " + th);
            }
        }
        Log.e("ttmn", "load lib " + str + " result : " + z);
        return z;
    }

    private static boolean tryLoadSSL() {
        boolean zLoadLibrary;
        if (shouldLoadLib(32)) {
            zLoadLibrary = libraryLoader.loadLibrary(CryptoName);
            if (zLoadLibrary) {
                zLoadLibrary = libraryLoader.loadLibrary(SSLName);
            }
        } else {
            zLoadLibrary = false;
        }
        if (zLoadLibrary) {
            return zLoadLibrary;
        }
        try {
            if (!dependBoringSSl) {
                return zLoadLibrary;
            }
            if (!BoringsslLoaderWrapper.loadBoringssl()) {
                Log.e("ttmn", "load boringssl fail!");
            }
            return true;
        } catch (Exception e) {
            Log.e("ttmn", "load ssl failed: " + e);
            return zLoadLibrary;
        }
    }

    private static boolean tryLoadVcn() {
        if (!dependVcn) {
            return true;
        }
        boolean zLoadLibrary = shouldLoadLib(64) ? libraryLoader.loadLibrary(VcnName) : false;
        if (!zLoadLibrary && (zLoadLibrary = VcnlibloadWrapper.tryLoadVcnlib())) {
            zLoadLibrary = VcnlibloadWrapper.tryLoadVcnverifylib();
        }
        if (!zLoadLibrary) {
            Log.e("ttmn", "Can't load vcn ");
        }
        return zLoadLibrary;
    }

    public static synchronized void setLibraryLoadLevel(int i) {
        loadLevel = i;
    }

    public static synchronized void setBoringSSLDependency(boolean z) {
        dependBoringSSl = z;
    }

    public static synchronized void setVcnDependency(boolean z) {
        dependVcn = z;
    }

    public static synchronized void setEnableV2(boolean z) {
        enableV2 = z;
    }

    public static synchronized void setLibraryLoader(IAVMDLLibraryLoader iAVMDLLibraryLoader) {
        libraryLoader = iAVMDLLibraryLoader;
    }

    public static synchronized void setNeedBase(boolean z) {
        needBase = z;
    }

    public static synchronized void setNeedP2PLib(boolean z) {
        needP2PLib = z;
    }

    public static synchronized void setNeedTTnetLib(boolean z) {
        needTTnetLib = z;
    }

    public static synchronized void setUseShadowVersion(boolean z) {
        useShadowVersion = z;
    }

    public static synchronized boolean loadLibraries() {
        boolean zTryLoadLibray;
        tryLoadSSL();
        tryLoadVcn();
        if (needBase) {
            tryLoadLibray(4);
        }
        zTryLoadLibray = false;
        if (enableV2) {
            boolean zTryLoadLibray2 = tryLoadLibray(16);
            if (zTryLoadLibray2 || !useShadowVersion) {
                zTryLoadLibray = zTryLoadLibray2;
            } else {
                useShadowVersion = false;
                zTryLoadLibray = tryLoadLibray(16);
            }
        }
        if (!zTryLoadLibray) {
            zTryLoadLibray = tryLoadLibray(8);
            if (needP2PLib) {
                tryLoadLibray(1);
            }
            if (needTTnetLib) {
                tryLoadLibray(2);
            }
        }
        return zTryLoadLibray;
    }
}
