package com.dhylive.app.csj;

import android.content.Context;
import com.baidu.mobstat.forbes.Config;
import com.blankj.utilcode.util.LogUtils;
import com.bytedance.sdk.djx.DJXSdk;
import com.bytedance.sdk.djx.DJXSdkConfig;
import com.bytedance.sdk.djx.IDJXPrivacyController;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DJXOthers;
import com.bytedance.sdk.djx.model.DJXUser;
import com.dhylive.app.AppAdConfig;
import com.dhylive.app.data.mine.ConfigurationInfo;
import com.dhylive.app.utils.LiveEventConst;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.kuaishou.weapon.p0.bq;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.HashMap;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DramaHolder.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/dhylive/app/csj/DramaHolder;", "", "()V", "isLogin", "", "()Z", "isStartSuccess", PointCategory.INIT, "", "context", "Landroid/content/Context;", "login", Config.CUSTOM_USER_ID, "", "logout", "random", "length", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class DramaHolder {
    public static final DramaHolder INSTANCE = new DramaHolder();

    private DramaHolder() {
    }

    public final boolean isStartSuccess() {
        return DJXSdk.isStartSuccess();
    }

    public final boolean isLogin() {
        IDJXService iDJXServiceService = DJXSdk.service();
        if (iDJXServiceService != null) {
            return iDJXServiceService.isLogin();
        }
        return false;
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DJXSdkConfig dJXSdkConfigBuild = new DJXSdkConfig.Builder().debug(false).newUser(true).build();
        dJXSdkConfigBuild.setPrivacyController(new IDJXPrivacyController() { // from class: com.dhylive.app.csj.DramaHolder.init.1
        });
        DJXSdk.init(context, "SDK_Setting_5744631.json", dJXSdkConfigBuild);
        DJXSdk.start(new DJXSdk.StartListener() { // from class: com.dhylive.app.csj.DramaHolder$$ExternalSyntheticLambda0
            @Override // com.bytedance.sdk.djx.DJXSdk.StartListener
            public final void onStartComplete(boolean z, String str, DJXError dJXError) {
                DramaHolder.init$lambda$0(z, str, dJXError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(boolean z, String str, DJXError dJXError) {
        LogUtils.e("DramaSdk init: " + z + ", " + dJXError);
        if (z) {
            LiveEventBus.get(LiveEventConst.DRAMA_INIT_SUCCESS).post(Unit.INSTANCE);
        }
    }

    public final void login(String uid) {
        String csjSecretKey;
        Intrinsics.checkNotNullParameter(uid, Config.CUSTOM_USER_ID);
        ConfigurationInfo config = AppAdConfig.INSTANCE.getConfig();
        if (config == null || (csjSecretKey = config.getCsjSecretKey()) == null) {
            csjSecretKey = "9bd9a035aa0486a6aaa2e3b499f12a3f";
        }
        String str = csjSecretKey;
        String strRandom = random(16);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        HashMap map = new HashMap();
        map.put("ouid", uid);
        IDJXService iDJXServiceService = DJXSdk.service();
        String signString = iDJXServiceService != null ? iDJXServiceService.getSignString(str, strRandom, jCurrentTimeMillis, map) : null;
        IDJXService iDJXServiceService2 = DJXSdk.service();
        if (iDJXServiceService2 != null) {
            iDJXServiceService2.login(signString, new IDJXService.IDJXCallback<DJXUser>() { // from class: com.dhylive.app.csj.DramaHolder.login.1
                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onSuccess(DJXUser p0, DJXOthers p1) {
                    Object[] objArr = new Object[1];
                    objArr[0] = "短剧登录成功id" + (p0 != null ? p0.ouid : null);
                    LogUtils.e(objArr);
                }

                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onError(DJXError p0) {
                    Intrinsics.checkNotNullParameter(p0, bq.g);
                    LogUtils.e("短剧登录失败:" + p0);
                }
            });
        }
    }

    public final void logout() {
        IDJXService iDJXServiceService;
        if (isStartSuccess() && (iDJXServiceService = DJXSdk.service()) != null) {
            iDJXServiceService.logout(new IDJXService.IDJXCallback<DJXUser>() { // from class: com.dhylive.app.csj.DramaHolder.logout.1
                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onError(DJXError p0) {
                    Intrinsics.checkNotNullParameter(p0, bq.g);
                }

                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onSuccess(DJXUser data, DJXOthers others) {
                    Object[] objArr = new Object[1];
                    objArr[0] = "短剧退出成功id" + (data != null ? data.ouid : null);
                    LogUtils.e(objArr);
                }
            });
        }
    }

    private final String random(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
