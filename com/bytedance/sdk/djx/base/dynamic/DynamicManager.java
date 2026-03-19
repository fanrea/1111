package com.bytedance.sdk.djx.base.dynamic;

import android.content.Context;
import com.bytedance.sdk.djx.base.dynamic.api.DynamicRsp;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.utils.LG;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicManager {
    private static volatile DynamicManager sInstance;
    private final List<OnDynamicUpdateListener> listeners = new CopyOnWriteArrayList();
    private DynamicModel mModel;

    public static DynamicManager getInstance() {
        if (sInstance == null) {
            synchronized (DynamicManager.class) {
                if (sInstance == null) {
                    sInstance = new DynamicManager();
                }
            }
        }
        return sInstance;
    }

    private DynamicManager() {
    }

    public void init(Context context, String str) {
        DynamicLoader.read(context, str);
    }

    public void update() {
        DynamicLoader.update(new IApiCallback<DynamicRsp>() { // from class: com.bytedance.sdk.djx.base.dynamic.DynamicManager.1
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DynamicRsp dynamicRsp) {
                Iterator it = DynamicManager.this.listeners.iterator();
                while (it.hasNext()) {
                    ((OnDynamicUpdateListener) it.next()).onDynamicUpdate(dynamicRsp);
                }
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DynamicRsp dynamicRsp) {
                LG.e("DynamicLoader update error: " + dJXError);
            }
        });
    }

    public void setDynamicModel(DynamicModel dynamicModel) {
        this.mModel = dynamicModel;
    }

    public DynamicModel getDynamicModel() {
        return this.mModel;
    }

    public String getInitPartner() {
        DynamicModel dynamicModel = this.mModel;
        return dynamicModel != null ? dynamicModel.mInitPartner : "";
    }

    public String getInitSecureKey() {
        DynamicModel dynamicModel = this.mModel;
        return dynamicModel != null ? dynamicModel.mInitSecureKey : "";
    }

    public String getInitOldSecureKey() {
        DynamicModel dynamicModel = this.mModel;
        return dynamicModel != null ? dynamicModel.mInitOldSecureKey : "";
    }

    public String getInitAppId() {
        DynamicModel dynamicModel = this.mModel;
        return dynamicModel != null ? dynamicModel.mInitAppId : "";
    }

    public String getInitSiteId() {
        DynamicModel dynamicModel = this.mModel;
        return dynamicModel != null ? dynamicModel.mInitSiteId : "";
    }

    public String getSmallDrawCodeId() {
        return this.mModel.mSmallDrawCodeId;
    }

    public String getSmallDrawNativeCodeId() {
        return this.mModel.mSmallDrawNativeCodeId;
    }

    public String getSmallDrawInterstitialCodeId() {
        return this.mModel.mSmallDrawInterstitialCodeId;
    }

    public String getSmallDrawNoteCodeId() {
        return this.mModel.mSmallDrawNoteCodeId;
    }

    public String getVideoBannerAdCodeId() {
        return this.mModel.mDrawBannerCodeId;
    }

    public String getSmallGridCodeId() {
        return this.mModel.mSmallGridCodeId;
    }

    public String getSmallGridDrawCodeId() {
        return this.mModel.mSmallGridDrawCodeId;
    }

    public String getSmallGridDrawNativeCodeId() {
        return this.mModel.mSmallGridDrawNativeCodeId;
    }

    public String getSmallCardCodeId() {
        return this.mModel.mSmallCardCodeId;
    }

    public String getSmallCardDrawCodeId() {
        return this.mModel.mSmallCardDrawCodeId;
    }

    public String getSmallCardDrawNativeCodeId() {
        return this.mModel.mSmallCardDrawNativeCodeId;
    }

    public String getDramaRewardedAdCodeId() {
        return this.mModel.mDramaRewardedAdCodeId;
    }

    public String getDramaRewardedAdCodeId2() {
        return this.mModel.mDramaRewardedAdCodeId2;
    }

    public String getStoryRewardedAdCodeId() {
        return this.mModel.mStoryRewardedAdCodeId;
    }

    public String getStoryHomeAdCodeId() {
        return this.mModel.mStoryHomeAdCodeId;
    }

    public void registerListener(OnDynamicUpdateListener onDynamicUpdateListener) {
        if (this.listeners.contains(onDynamicUpdateListener)) {
            return;
        }
        this.listeners.add(onDynamicUpdateListener);
    }

    public void unregisterListener(OnDynamicUpdateListener onDynamicUpdateListener) {
        this.listeners.remove(onDynamicUpdateListener);
    }
}
