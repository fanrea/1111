package com.bytedance.sdk.djx.base.dynamic;

import android.text.TextUtils;
import com.bytedance.sdk.djx.base.dynamic.api.DynamicRsp;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class DynamicLoader {
    private static final String TAG = "DynamicLoader";

    DynamicLoader() {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean read(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            android.content.Context r3 = com.bytedance.sdk.djx.utils.InnerManager.getContext()     // Catch: java.lang.Throwable -> L37
            if (r3 != 0) goto La
            goto Le
        La:
            android.content.Context r4 = com.bytedance.sdk.djx.utils.InnerManager.getContext()     // Catch: java.lang.Throwable -> L37
        Le:
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch: java.lang.Throwable -> L37
            java.io.InputStream r4 = r4.open(r5)     // Catch: java.lang.Throwable -> L37
            byte[] r5 = com.bytedance.sdk.djx.utils.FileUtil.read(r4)     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Throwable -> L38
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L38
            org.json.JSONObject r5 = com.bytedance.sdk.djx.utils.JSON.build(r3)     // Catch: java.lang.Throwable -> L38
            com.bytedance.sdk.djx.base.dynamic.DynamicModel r0 = com.bytedance.sdk.djx.base.dynamic.api.DynamicApi.parseModel(r5)     // Catch: java.lang.Throwable -> L38
            if (r0 == 0) goto L2b
            r5 = r1
            goto L2c
        L2b:
            r5 = r2
        L2c:
            if (r4 == 0) goto L35
            java.io.Closeable[] r1 = new java.io.Closeable[r1]
            r1[r2] = r4
            com.bytedance.sdk.djx.utils.IOUtil.closeIOQuietly(r1)
        L35:
            r2 = r5
            goto L41
        L37:
            r4 = r0
        L38:
            if (r4 == 0) goto L41
            java.io.Closeable[] r5 = new java.io.Closeable[r1]
            r5[r2] = r4
            com.bytedance.sdk.djx.utils.IOUtil.closeIOQuietly(r5)
        L41:
            if (r2 == 0) goto L46
            initRom(r0)
        L46:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.base.dynamic.DynamicLoader.read(android.content.Context, java.lang.String):boolean");
    }

    private static void initRom(DynamicModel dynamicModel) {
        if (dynamicModel == null) {
            return;
        }
        DynamicPresenter.getInstance().checkLicense(dynamicModel);
        DynamicModel config = DynamicPresenter.getInstance().getConfig(dynamicModel.mInitSiteId);
        DynamicManager dynamicManager = DynamicManager.getInstance();
        if (config != null) {
            dynamicModel = config;
        }
        dynamicManager.setDynamicModel(dynamicModel);
    }

    public static void update(IApiCallback<DynamicRsp> iApiCallback) {
        if (DynamicManager.getInstance().getDynamicModel() == null) {
            LG.d(TAG, "sDynamicModel=null, not need update");
        } else if (TextUtils.isEmpty(DynamicManager.getInstance().getDynamicModel().mInitSiteId)) {
            LG.d(TAG, "sDynamicModel.mInitSiteId=null, not need update");
        } else {
            DynamicPresenter.getInstance().update(new String[]{DynamicManager.getInstance().getDynamicModel().mInitSiteId}, iApiCallback);
        }
    }
}
