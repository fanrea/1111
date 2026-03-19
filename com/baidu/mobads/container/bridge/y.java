package com.baidu.mobads.container.bridge;

import com.bytedance.sdk.djx.core.api.req.FeedReqParams;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class y {
    public static final y I;

    /* renamed from: K, reason: collision with root package name */
    public static final y f722K;
    public static final y L;
    public static final y M;
    public static final y N;
    public static final y O;
    public static final y P;
    public static final y Q;
    public static final y R;
    private static final /* synthetic */ y[] T;
    public static final y o;
    public static final y q;
    public static final y y;
    private final String S;
    public static final y a = new y("DOWNLOAD_PERMISSION_CLICK", 0, "setPermissionActionUrl");
    public static final y b = new y("DOWNLOAD_PRIVACY_CLICK", 1, "setPrivacyActionUrl");
    public static final y c = new y("DOWNLOAD_FUNCTION_CLICK", 2, "setFunctionActionUrl");
    public static final y d = new y("HANDLE_PLAY_CLICK", 3, "handlePlayClick");
    public static final y e = new y("GET_ID_FROME_NATIVE", 4, "getIdFromNative");
    public static final y f = new z("SET_ACTION_URL", 5, "setActionUrl");
    public static final y g = new y("GET_CONFS", 6, "getConfs");
    public static final y h = new y("ON_INITED", 7, "onInited");
    public static final y i = new y("GET_ADVIEW_STATE", 8, "getAdViewState");
    public static final y j = new y("PRINT_LOG", 9, "printLog");
    public static final y k = new y("SET_APP_TIP", 10, "setAppTip");
    public static final y l = new y("PAUSE_DOWNLOAD", 11, "pauseDownload");
    public static final y m = new y("GET_DOWNLOAD_STATUS", 12, "getDownloadStatus");
    public static final y n = new y("SPECIAL_PAUSE_DOWNLOAD", 13, "specialPauseDownload");
    public static final y p = new y("GET_APP_STATUS", 15, "getAppStatus");
    public static final y r = new y("GET_WIFI_SCANS", 17, "getWifiScans");
    public static final y s = new y("GET_VERSION_CODE_BY_PKG", 18, "getVersionCodeByPkg");
    public static final y t = new y("GET_INSTALLED", 19, "getInstalled");
    public static final y u = new y("GET_RECENT_DIFF", 20, "getRecentDiff");
    public static final y v = new y("GET_RECENT_ALL", 21, "getRecentAll");
    public static final y w = new y("GET_CURRENT_APP", 22, "getCurrentApp");
    public static final y x = new y("GET_SYS_INSTALLED", 23, "getSysInstalled");
    public static final y z = new y("ON_AD_FALED", 25, "onAdFailed");
    public static final y A = new y("ON_AD_SHOW", 26, "onAdShow");
    public static final y B = new y("ON_AD_SWITCH", 27, "onAdSwitch");
    public static final y C = new y("SET_VISIBILITY", 28, "setVisibility");
    public static final y D = new y("GET_ACTIVE_TYPE", 29, "getActiveType");
    public static final y E = new y("ON_INTERSTITIAL_PRELOAD_END", 30, "onInterstitialPreloadEnd");
    public static final y F = new y("ON_AD_PLAY_END", 31, "onAdPlayEnd");
    public static final y G = new y("PLAY_VIDEO_FOR_INTERSTITIAL", 32, "playVideoForInterstitial");
    public static final y H = new y("CLOSE", 33, "close");
    public static final y J = new y("USE_CUSTOM_CLOSE", 35, "useCustomClose");

    /* synthetic */ y(String str, int i2, String str2, z zVar) {
        this(str, i2, str2);
    }

    public static y a(String str) {
        return (y) Enum.valueOf(y.class, str);
    }

    public static y[] a() {
        return (y[]) T.clone();
    }

    static {
        final String str = "installApp";
        final String str2 = "INSTALL_APP";
        final int i2 = 14;
        o = new y(str2, i2, str) { // from class: com.baidu.mobads.container.bridge.ac
            {
                z zVar = null;
            }

            @Override // com.baidu.mobads.container.bridge.y
            boolean a(an anVar) {
                return true;
            }
        };
        final String str3 = "openApp";
        final String str4 = "OPEN_APP";
        final int i3 = 16;
        q = new y(str4, i3, str3) { // from class: com.baidu.mobads.container.bridge.ad
            {
                z zVar = null;
            }

            @Override // com.baidu.mobads.container.bridge.y
            boolean a(an anVar) {
                return true;
            }
        };
        final int i4 = 24;
        final String str5 = "confirm";
        final String str6 = "CONFIRM";
        y = new y(str6, i4, str5) { // from class: com.baidu.mobads.container.bridge.ae
            {
                z zVar = null;
            }

            @Override // com.baidu.mobads.container.bridge.y
            boolean a(an anVar) {
                return true;
            }
        };
        final int i5 = 34;
        final String str7 = "expand";
        final String str8 = "EXPAND";
        I = new y(str8, i5, str7) { // from class: com.baidu.mobads.container.bridge.af
            {
                z zVar = null;
            }

            @Override // com.baidu.mobads.container.bridge.y
            boolean a(an anVar) {
                return anVar == an.INLINE;
            }
        };
        final int i6 = 36;
        final String str9 = FeedReqParams.REQ_TYPE_OPEN;
        final String str10 = "OPEN";
        f722K = new y(str10, i6, str9) { // from class: com.baidu.mobads.container.bridge.ag
            {
                z zVar = null;
            }

            @Override // com.baidu.mobads.container.bridge.y
            boolean a(an anVar) {
                return true;
            }
        };
        final int i7 = 37;
        final String str11 = "resize";
        final String str12 = "RESIZE";
        L = new y(str12, i7, str11) { // from class: com.baidu.mobads.container.bridge.ah
            {
                z zVar = null;
            }

            @Override // com.baidu.mobads.container.bridge.y
            boolean a(an anVar) {
                return true;
            }
        };
        M = new y("SET_ORIENTATION_PROPERTIES", 38, "setOrientationProperties");
        final int i8 = 39;
        final String str13 = "playVideo";
        final String str14 = "PLAY_VIDEO";
        N = new y(str14, i8, str13) { // from class: com.baidu.mobads.container.bridge.ai
            {
                z zVar = null;
            }

            @Override // com.baidu.mobads.container.bridge.y
            boolean a(an anVar) {
                return anVar == an.INLINE;
            }
        };
        final int i9 = 40;
        final String str15 = "storePicture";
        final String str16 = "STORE_PICTURE";
        O = new y(str16, i9, str15) { // from class: com.baidu.mobads.container.bridge.aj
            {
                z zVar = null;
            }

            @Override // com.baidu.mobads.container.bridge.y
            boolean a(an anVar) {
                return true;
            }
        };
        final int i10 = 41;
        final String str17 = "createCalendarEvent";
        final String str18 = "CREATE_CALENDAR_EVENT";
        P = new y(str18, i10, str17) { // from class: com.baidu.mobads.container.bridge.aa
            {
                z zVar = null;
            }

            @Override // com.baidu.mobads.container.bridge.y
            boolean a(an anVar) {
                return true;
            }
        };
        final int i11 = 42;
        final String str19 = "playGame";
        final String str20 = "PLAY_GAME";
        Q = new y(str20, i11, str19) { // from class: com.baidu.mobads.container.bridge.ab
            {
                z zVar = null;
            }

            @Override // com.baidu.mobads.container.bridge.y
            boolean a(an anVar) {
                return true;
            }
        };
        R = new y("UNSPECIFIED", 43, "");
        T = new y[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, f722K, L, M, N, O, P, Q, R};
    }

    private y(String str, int i2, String str2) {
        this.S = str2;
    }

    public static y b(String str) {
        for (y yVar : a()) {
            if (yVar.S.equals(str)) {
                return yVar;
            }
        }
        return R;
    }

    public String b() {
        return this.S;
    }

    boolean a(an anVar) {
        return false;
    }
}
