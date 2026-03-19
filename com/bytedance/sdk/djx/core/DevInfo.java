package com.bytedance.sdk.djx.core;

import com.bytedance.sdk.djx.IDJXPrivacyController;
import com.bytedance.sdk.djx.IDJXRouter;
import com.bytedance.sdk.djx.IDJXToastController;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DevInfo {
    public static int sAliveSeconds = 0;
    public static String sAppId = null;
    public static String sContentUUID = null;
    public static boolean sDisableABTest = false;
    public static boolean sDisableTTPlayer = false;
    public static int sImageCacheSize = 0;
    public static int sInterestType = 0;
    public static boolean sIsDebug = false;
    public static boolean sIsNewUser;
    public static String sOldPartner;
    public static String sOldSecureKey;
    public static String sOldUUID;
    public static String sPartner;
    public static IDJXPrivacyController sPrivacyController;
    public static IDJXRouter sRouter;
    public static String sSecureKey;
    public static String sSiteId;
    public static IDJXToastController sToastController;

    public static IDJXPrivacyController getPrivacyController() {
        IDJXPrivacyController iDJXPrivacyController = sPrivacyController;
        return iDJXPrivacyController == null ? EmptyPrivacyController.inst() : iDJXPrivacyController;
    }

    private static class EmptyPrivacyController extends IDJXPrivacyController {
        private static EmptyPrivacyController sInstance;

        private EmptyPrivacyController() {
        }

        static EmptyPrivacyController inst() {
            if (sInstance == null) {
                sInstance = new EmptyPrivacyController();
            }
            return sInstance;
        }
    }
}
