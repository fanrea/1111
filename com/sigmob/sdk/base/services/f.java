package com.sigmob.sdk.base.services;

import com.czhj.sdk.common.ClientMetadata;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f {
    public static final String a = "LocationService";
    public static final String b = "AppInstallService";
    public static final String c = "WifiScanService";
    public static final String d = "DownloadService";
    private static a e;
    private static a f;
    private static a g;
    private static a h;

    public interface a {
        boolean e();

        g f();

        void g();

        Error h();
    }

    public static a a() {
        return f;
    }

    public static synchronized a a(String name) {
        char c2 = 65535;
        int iHashCode = name.hashCode();
        if (iHashCode != 353926395) {
            if (iHashCode != 854806816) {
                if (iHashCode == 1382229229 && name.equals(d)) {
                    c2 = 2;
                }
            } else if (name.equals(a)) {
                c2 = 0;
            }
        } else if (name.equals(b)) {
            c2 = 1;
        }
        if (c2 == 0) {
            a aVar = e;
            if (aVar != null) {
                return aVar;
            }
            e eVar = new e();
            e = eVar;
            return eVar;
        }
        if (c2 == 1) {
            a aVar2 = f;
            if (aVar2 != null) {
                return aVar2;
            }
            b bVar = new b();
            f = bVar;
            return bVar;
        }
        if (c2 != 2) {
            return null;
        }
        a aVar3 = h;
        if (aVar3 != null) {
            return aVar3;
        }
        d dVar = new d();
        h = dVar;
        return dVar;
    }

    public static void a(String serviceName, boolean enabled) {
        a aVar;
        a aVarA = a(serviceName);
        if (aVarA == null) {
        }
        serviceName.hashCode();
        switch (serviceName) {
            case "WifiScanService":
                if (!enabled) {
                    aVar = g;
                    if (aVar == null) {
                    }
                    aVar.g();
                    break;
                }
                aVarA.e();
                break;
            case "AppInstallService":
                if (!enabled) {
                    aVar = f;
                    if (aVar == null) {
                    }
                    aVar.g();
                    break;
                }
                aVarA.e();
                break;
            case "LocationService":
                if (enabled) {
                    aVarA.e();
                } else {
                    a aVar2 = e;
                    if (aVar2 != null) {
                        aVar2.g();
                    }
                }
                ClientMetadata.getInstance().setEnableLocation(enabled);
                break;
            case "DownloadService":
                if (!enabled) {
                    aVar = h;
                    if (aVar == null) {
                    }
                    aVar.g();
                    break;
                }
                aVarA.e();
                break;
        }
    }

    public static a b() {
        return g;
    }

    public static a c() {
        return h;
    }

    public static a d() {
        return e;
    }
}
