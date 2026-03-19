package com.kwad.sdk.utils;

import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bd {
    public static volatile int cmS;

    private static boolean aps() {
        if (!com.kwad.framework.a.a.qr.booleanValue()) {
            return false;
        }
        com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        return false;
    }

    public static boolean readLocationDisable() {
        KsCustomController ksCustomController;
        if (aps()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                if (!ksCustomController.canReadLocation()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static com.kwad.sdk.internal.api.a apt() {
        KsCustomController ksCustomController;
        com.kwad.sdk.internal.api.a aVarI;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) {
                return null;
            }
            try {
                aVarI = com.kwad.sdk.internal.api.a.I(ksCustomController.getKsLocation());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                aVarI = null;
            }
            return aVarI != null ? aVarI : com.kwad.sdk.internal.api.a.a(ksCustomController.getLocation());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean usePhoneStateDisable() {
        KsCustomController ksCustomController;
        if (aps()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                if (!ksCustomController.canUsePhoneState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String getDevImei() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) ? "" : ksCustomController.getImei();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] getDevImeis() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                return ksCustomController.getImeis();
            }
        } catch (Throwable unused) {
        }
        return new String[]{"", ""};
    }

    public static String getDevAndroidId() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) ? "" : ksCustomController.getAndroidId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean useMacAddressDisable() {
        KsCustomController ksCustomController;
        if (aps()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                if (!ksCustomController.canUseMacAddress()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String getDevMacAddress() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) ? "" : ksCustomController.getMacAddress();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean useOaidDisable() {
        KsCustomController ksCustomController;
        if (aps()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                if (!ksCustomController.canUseOaid()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String getDevOaid() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            return (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) ? "" : ksCustomController.getOaid();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean useNetworkStateDisable() {
        KsCustomController ksCustomController;
        if (aps()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                if (!ksCustomController.canUseNetworkState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean useStoragePermissionDisable() {
        KsCustomController ksCustomController;
        if (aps()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                if (!ksCustomController.canUseStoragePermission()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean readInstalledPackagesDisable() {
        KsCustomController ksCustomController;
        if (aps()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                if (!ksCustomController.canReadInstalledPackages()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static List<String> getDevInstalledPackages() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }

    public static boolean useSensorManagerDisable() {
        if (apu()) {
            return true;
        }
        return cmS == -1;
    }

    private static boolean apu() {
        if (!com.kwad.sdk.core.d.a.qr.booleanValue()) {
            return false;
        }
        try {
            com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        } catch (Throwable unused) {
        }
        return false;
    }
}
