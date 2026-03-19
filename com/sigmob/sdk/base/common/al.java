package com.sigmob.sdk.base.common;

import android.content.Context;
import android.net.Uri;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.MiMarketManager;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.models.rtb.WXProgramRes;
import com.sigmob.sdk.videoAd.BaseAdActivity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public enum al {
    IGNORE_ABOUT_SCHEME(0 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.al.1
        @Override // com.sigmob.sdk.base.common.al
        public String a(BaseAdUnit adUnit) {
            return null;
        }

        @Override // com.sigmob.sdk.base.common.al
        protected void a(Context context, Uri uri, am urlHandler, BaseAdUnit adUnit) {
            al.b(this, "performAction", adUnit, null);
            SigmobLog.d("Link to about page ignored.");
        }

        @Override // com.sigmob.sdk.base.common.al
        public boolean a(Uri uri, int interActionType) {
            return "about".equalsIgnoreCase(uri.getScheme());
        }
    },
    MINI_PROGRAM(0 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.al.2
        @Override // com.sigmob.sdk.base.common.al
        public String a(BaseAdUnit adUnit) {
            WXProgramRes wXProgramRes;
            if (adUnit == null || (wXProgramRes = adUnit.getWXProgramRes()) == null) {
                return null;
            }
            return wXProgramRes.wx_app_id;
        }

        @Override // com.sigmob.sdk.base.common.al
        protected void a(Context context, Uri uri, am urlHandler, BaseAdUnit adUnit) throws Exception {
            al.b(this, "performAction", adUnit, null);
            int interactionType = adUnit.getInteractionType();
            if (interactionType != 7) {
                String str = "performAction interaction_type is not right with " + interactionType;
                al.b(this, "performAction", adUnit, str);
                throw new Exception(str);
            }
            WXProgramRes wXProgramRes = adUnit.getWXProgramRes();
            if (wXProgramRes == null) {
                return;
            }
            t.a(com.sigmob.sdk.b.e(), wXProgramRes.wx_app_id, wXProgramRes.wx_app_username, wXProgramRes.wx_app_path, wXProgramRes.wx_business_type.intValue(), wXProgramRes.wx_ext_msg);
        }

        @Override // com.sigmob.sdk.base.common.al
        public boolean a(final Uri uri, int interActionType) {
            String scheme = uri.getScheme();
            return ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme) || interActionType != 7) ? false : true;
        }
    },
    FOLLOW_DEEP_LINK(true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.al.3
        @Override // com.sigmob.sdk.base.common.al
        public String a(BaseAdUnit adUnit) {
            if (adUnit == null) {
                return null;
            }
            return adUnit.getDeeplinkUrl();
        }

        @Override // com.sigmob.sdk.base.common.al
        protected void a(Context context, Uri uri, am urlHandler, BaseAdUnit adUnit) throws Exception {
            al.b(this, "performAction", adUnit, null);
            try {
                int interactionType = adUnit.getInteractionType();
                g.d(adUnit);
                adUnit.setDeeplinkUri(uri);
                String host = uri.getHost();
                if (interactionType != 8 && (!com.sigmob.sdk.base.utils.m.b(host) || !host.equalsIgnoreCase("hapjs.org"))) {
                    t.a(context, uri, t.a(context, uri, adUnit.getMarketPackageNameList()), adUnit.enableSmallWindow(Integer.valueOf(interactionType)));
                    return;
                }
                t.a(context, uri, com.sigmob.sdk.b.a());
            } catch (Exception e) {
                g.d((BaseAdUnit) null);
                adUnit.setDeeplinkUri(null);
                throw e;
            }
        }

        @Override // com.sigmob.sdk.base.common.al
        public boolean a(Uri uri, int interActionType) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            return (interActionType == 8 || (com.sigmob.sdk.base.utils.m.b(host) && host.equalsIgnoreCase("hapjs.org"))) ? "HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme) || "HAP".equalsIgnoreCase(scheme) : ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme)) ? false : true;
        }
    },
    FOLLOW_PACKAGE_NAME(true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.al.4
        @Override // com.sigmob.sdk.base.common.al
        public String a(BaseAdUnit adUnit) {
            if (adUnit == null) {
                return null;
            }
            return com.sigmob.sdk.base.utils.m.a((CharSequence) adUnit.getApkPackageName()) ? adUnit.getProductId() : adUnit.getApkPackageName();
        }

        @Override // com.sigmob.sdk.base.common.al
        protected void a(Context context, Uri uri, am urlHandler, BaseAdUnit adUnit) throws Exception {
            al.b(this, "performAction", adUnit, null);
            String apkPackageName = adUnit.getApkPackageName();
            if (adUnit.getsubInteractionType() == 2 || com.sigmob.sdk.base.utils.m.b(apkPackageName)) {
                if (!com.sigmob.sdk.base.utils.m.b(apkPackageName)) {
                    apkPackageName = adUnit.getProductId();
                }
                if (com.sigmob.sdk.base.utils.m.b(apkPackageName)) {
                    boolean zA = com.sigmob.sdk.base.utils.n.a(adUnit.enableSmallWindow());
                    try {
                        g.c(adUnit);
                        t.a(context, (Uri) null, apkPackageName, zA);
                        return;
                    } catch (Throwable th) {
                        al.b(this, "performAction", adUnit, th.getMessage());
                        g.c((BaseAdUnit) null);
                    }
                }
            }
            throw new Exception("can't launch application for packageName " + adUnit.getProductId());
        }

        @Override // com.sigmob.sdk.base.common.al
        public boolean a(Uri uri, int interActionType) {
            return interActionType == 2;
        }
    },
    MARKET_SCHEME(0 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.al.5
        @Override // com.sigmob.sdk.base.common.al
        public String a(BaseAdUnit adUnit) {
            AndroidMarket androidMarket;
            if (adUnit == null || (androidMarket = adUnit.getAndroidMarket()) == null) {
                return null;
            }
            return androidMarket.market_url;
        }

        @Override // com.sigmob.sdk.base.common.al
        protected void a(Context context, Uri uri, am urlHandler, BaseAdUnit adUnit) throws Exception {
            String strA = null;
            al.b(this, "performAction", adUnit, null);
            AndroidMarket androidMarket = adUnit.getAndroidMarket();
            if (androidMarket == null) {
                return;
            }
            int iIntValue = ((Integer) Wire.get(androidMarket.type, 0)).intValue();
            if (com.sigmob.sdk.base.utils.m.b(androidMarket.appstore_package_name)) {
                try {
                    if (AppPackageUtil.getPackageVersionCode(context, androidMarket.appstore_package_name) != -1) {
                        strA = androidMarket.appstore_package_name;
                    }
                } catch (Throwable th) {
                    al.b(this, "performAction", adUnit, th.getMessage());
                    SigmobLog.e("get store package error " + th.getMessage());
                }
            }
            Uri uri2 = Uri.parse(androidMarket.market_url);
            if (com.sigmob.sdk.base.utils.m.a((CharSequence) strA)) {
                strA = t.a(context, uri2, adUnit.getMarketPackageNameList());
            }
            if (iIntValue == 1) {
                new MiMarketManager.DirectMailStatusReceiver().a(com.sigmob.sdk.b.e(), adUnit);
            }
            t.a(context, uri2, strA);
        }

        @Override // com.sigmob.sdk.base.common.al
        public boolean a(final Uri uri, int interActionType) {
            String scheme = uri.getScheme();
            return ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme)) ? false : true;
        }
    },
    DOWNLOAD_APK(true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.al.6
        @Override // com.sigmob.sdk.base.common.al
        public String a(BaseAdUnit adUnit) {
            if (adUnit == null) {
                return null;
            }
            return adUnit.getLanding_page();
        }

        @Override // com.sigmob.sdk.base.common.al
        protected void a(Context context, Uri uri, am urlHandler, BaseAdUnit adUnit) throws Exception {
            int interactionType;
            al.b(this, "performAction", adUnit, null);
            if (adUnit == null || (interactionType = adUnit.getInteractionType()) == 2 || interactionType == 3) {
                return;
            }
            String str = "Could not handle download Scheme url: " + uri;
            al.b(this, "performAction", adUnit, str);
            throw new Exception(str);
        }

        @Override // com.sigmob.sdk.base.common.al
        public boolean a(final Uri uri, int interActionType) {
            String scheme = uri.getScheme();
            return "HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme);
        }
    },
    OPEN_WITH_BROWSER(true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.al.7
        @Override // com.sigmob.sdk.base.common.al
        public String a(BaseAdUnit adUnit) {
            if (adUnit == null) {
                return null;
            }
            return adUnit.getLanding_page();
        }

        @Override // com.sigmob.sdk.base.common.al
        protected void a(Context context, Uri uri, am urlHandler, BaseAdUnit adUnit) throws Exception {
            al.b(this, "performAction", adUnit, null);
            if (adUnit.getInteractionType() != 8) {
                if (urlHandler.b()) {
                    t.a(context, uri);
                    return;
                } else {
                    g.a(adUnit);
                    AdActivity.a(context, (Class<? extends BaseAdActivity>) AdActivity.class, adUnit.getUuid());
                    return;
                }
            }
            try {
                g.d(adUnit);
                adUnit.setDeeplinkUri(uri);
                t.a(context, uri, com.sigmob.sdk.b.a());
            } catch (Exception e) {
                al.b(this, "performAction", adUnit, e.getMessage());
                g.d((BaseAdUnit) null);
                adUnit.setDeeplinkUri(null);
                throw e;
            }
        }

        @Override // com.sigmob.sdk.base.common.al
        public boolean a(final Uri uri, int interActionType) {
            return uri != null && ("HTTP".equalsIgnoreCase(uri.getScheme()) || "HTTPS".equalsIgnoreCase(uri.getScheme()));
        }
    },
    NOOP(0 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.al.8
        @Override // com.sigmob.sdk.base.common.al
        public String a(BaseAdUnit adUnit) {
            return null;
        }

        @Override // com.sigmob.sdk.base.common.al
        protected void a(Context context, Uri uri, am urlHandler, BaseAdUnit adUnit) {
            al.b(this, "performAction", adUnit, null);
        }

        @Override // com.sigmob.sdk.base.common.al
        public boolean a(final Uri uri, int interActionType) {
            return false;
        }
    };

    private final boolean i;

    al(boolean requiresUserInteraction) {
        this.i = requiresUserInteraction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(al urlAction, String methodName, BaseAdUnit adUnit, String error) {
        if (urlAction == null || adUnit == null) {
            return;
        }
        String strName = urlAction.name();
        String deeplinkUrl = adUnit.getDeeplinkUrl();
        int interactionType = adUnit.getInteractionType();
        if (com.sigmob.sdk.base.utils.m.b(error)) {
            SigmobLogger.e(strName, methodName + ": error = " + error, new Object[0]);
        } else {
            SigmobLogger.d(strName, methodName + ": deeplinkUrl = " + deeplinkUrl + ", interactionType = " + interactionType, new Object[0]);
        }
    }

    public abstract String a(BaseAdUnit adUnit);

    protected abstract void a(Context context, Uri uri, am urlHandler, BaseAdUnit adUnit) throws Exception;

    public void a(am urlHandler, Context context, Uri destinationUri, boolean fromUserInteraction, BaseAdUnit adUnit) throws Exception {
        SigmobLog.d("Ad event URL: " + destinationUri);
        if (this.i && !fromUserInteraction) {
            throw new Exception("Attempted to handle action without user interaction.");
        }
        a(context, destinationUri, urlHandler, adUnit);
    }

    public abstract boolean a(Uri uri, int interActionType);
}
