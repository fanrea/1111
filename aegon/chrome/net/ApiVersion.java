package aegon.chrome.net;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ApiVersion {
    private static final int API_LEVEL = 12;
    private static final String CRONET_VERSION = "77.0.3865.0";
    private static final String LAST_CHANGE = "0cdcc6158160790658d1f033d3db873603250124-refs/heads/master@{#681094}";
    private static final int MIN_COMPATIBLE_API_LEVEL = 3;

    public static int getApiLevel() {
        return 3;
    }

    public static String getCronetVersion() {
        return CRONET_VERSION;
    }

    public static String getLastChange() {
        return LAST_CHANGE;
    }

    public static int getMaximumAvailableApiLevel() {
        return 12;
    }

    private ApiVersion() {
    }

    public static String getCronetVersionWithLastChange() {
        return "77.0.3865.0@0cdcc615";
    }
}
