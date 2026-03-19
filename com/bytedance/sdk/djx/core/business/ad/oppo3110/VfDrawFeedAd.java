package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import android.app.Activity;
import com.bykv.vk.openvk.ComplianceInfo;
import com.bykv.vk.openvk.TTDrawVfObject;
import com.bykv.vk.openvk.TTVfDislike;
import com.bytedance.sdk.djx.core.business.ad.AdComplianceInfo;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.utils.Reflector;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VfDrawFeedAd extends VfFeedAd {
    private final TTDrawVfObject mDrawFeedAd;

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfFeedAd, com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public int getAdTypeName() {
        return 8;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public AdComplianceInfo getAdComplianceInfo() {
        ComplianceInfo complianceInfo = this.mDrawFeedAd.getComplianceInfo();
        if (complianceInfo == null) {
            return null;
        }
        AdComplianceInfo adComplianceInfo = new AdComplianceInfo();
        adComplianceInfo.appName = complianceInfo.getAppName();
        adComplianceInfo.developerName = complianceInfo.getDeveloperName();
        adComplianceInfo.appVersion = complianceInfo.getAppVersion();
        adComplianceInfo.privacyUrl = complianceInfo.getPrivacyUrl();
        adComplianceInfo.permissionsMap = complianceInfo.getPermissionsMap();
        try {
            adComplianceInfo.permissionUrl = (String) Reflector.with(complianceInfo).method("getPermissionUrl", new Class[0]).call(new Object[0]);
        } catch (Reflector.DJXReflectedException unused) {
        }
        try {
            adComplianceInfo.functionDescUrl = (String) Reflector.with(complianceInfo).method("getFunctionDescUrl", new Class[0]).call(new Object[0]);
            return adComplianceInfo;
        } catch (Reflector.DJXReflectedException unused2) {
            return adComplianceInfo;
        }
    }

    public VfDrawFeedAd(TTDrawVfObject tTDrawVfObject, long j) {
        super(tTDrawVfObject, j);
        this.mDrawFeedAd = tTDrawVfObject;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setDrawVideoListener(final IDJXAd.DrawVideoListener drawVideoListener) {
        TTDrawVfObject tTDrawVfObject = this.mDrawFeedAd;
        if (tTDrawVfObject == null || drawVideoListener == null) {
            return;
        }
        tTDrawVfObject.setDrawVideoListener(new TTDrawVfObject.DrawVideoListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.VfDrawFeedAd.1
            public void onClickRetry() {
                drawVideoListener.onClickRetry();
            }

            public void onClick() {
                drawVideoListener.onClick();
            }
        });
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void showDislikeDialog(Activity activity, final IDJXAd.DislikeInteractionCallback dislikeInteractionCallback) {
        TTVfDislike dislikeDialog;
        TTDrawVfObject tTDrawVfObject = this.mDrawFeedAd;
        if (tTDrawVfObject == null || (dislikeDialog = tTDrawVfObject.getDislikeDialog(activity)) == null) {
            return;
        }
        dislikeDialog.setDislikeInteractionCallback(new TTVfDislike.DislikeInteractionCallback() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.VfDrawFeedAd.2
            public void onShow() {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onShow();
                }
            }

            public void onSelected(int i, String str, boolean z) {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onSelected(i, str);
                }
            }

            public void onSelected(int i, String str) {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onSelected(i, str);
                }
            }

            public void onCancel() {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onCancel();
                }
            }

            public void onRefuse() {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onRefuse();
                }
            }
        });
        dislikeDialog.showDislikeDialog();
    }
}
