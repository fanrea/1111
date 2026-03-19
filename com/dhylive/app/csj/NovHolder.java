package com.dhylive.app.csj;

import android.content.Context;
import com.baidu.mobstat.forbes.Config;
import com.blankj.utilcode.util.LogUtils;
import com.bytedance.sdk.djx.IDJXPrivacyController;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DJXOthers;
import com.bytedance.sdk.djx.model.DJXUser;
import com.bytedance.sdk.nov.api.INovCallback;
import com.bytedance.sdk.nov.api.INovService;
import com.bytedance.sdk.nov.api.NovSdk;
import com.bytedance.sdk.nov.api.NovSdkConfig;
import com.dhylive.app.AppAdConfig;
import com.dhylive.app.data.mine.ConfigurationInfo;
import com.dhylive.app.utils.LiveEventConst;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.HashMap;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NovHolder.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/dhylive/app/csj/NovHolder;", "", "()V", "isLogin", "", "()Z", "isStartSuccess", PointCategory.INIT, "", "context", "Landroid/content/Context;", "login", Config.CUSTOM_USER_ID, "", "logout", "random", "length", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class NovHolder {
    public static final NovHolder INSTANCE = new NovHolder();

    private NovHolder() {
    }

    public final boolean isStartSuccess() {
        return NovSdk.INSTANCE.isStartSuccess();
    }

    public final boolean isLogin() {
        INovService iNovServiceService = NovSdk.service();
        if (iNovServiceService != null) {
            return iNovServiceService.isLogin();
        }
        return false;
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NovSdkConfig novSdkConfigBuild = ((NovSdkConfig.Builder) ((NovSdkConfig.Builder) new NovSdkConfig.Builder().debug(false)).newUser(false)).build();
        novSdkConfigBuild.setPrivacyController(new IDJXPrivacyController() { // from class: com.dhylive.app.csj.NovHolder.init.1
        });
        Intrinsics.checkNotNull(novSdkConfigBuild);
        NovSdk.init(context, "SDK_Setting_5744631.json", novSdkConfigBuild);
        NovSdk.start(new NovSdk.StartListener() { // from class: com.dhylive.app.csj.NovHolder.init.2
            public void onStartComplete(boolean isSuccess, String message, DJXError error) {
                LogUtils.e("NovSdk start: " + isSuccess + ", " + message + ", " + error);
                if (isSuccess) {
                    LiveEventBus.get(LiveEventConst.NOVEL_INIT_SUCCESS).post(Unit.INSTANCE);
                }
            }
        });
    }

    public final void login(String uid) {
        String csjSecretKey;
        Intrinsics.checkNotNullParameter(uid, Config.CUSTOM_USER_ID);
        if (isStartSuccess()) {
            ConfigurationInfo config = AppAdConfig.INSTANCE.getConfig();
            if (config == null || (csjSecretKey = config.getCsjSecretKey()) == null) {
                csjSecretKey = "9bd9a035aa0486a6aaa2e3b499f12a3f";
            }
            String str = csjSecretKey;
            String strRandom = random(16);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            HashMap map = new HashMap();
            map.put("ouid", uid);
            INovService iNovServiceService = NovSdk.service();
            String signString = iNovServiceService != null ? iNovServiceService.getSignString(str, strRandom, jCurrentTimeMillis, map) : null;
            INovService iNovServiceService2 = NovSdk.service();
            if (iNovServiceService2 != null) {
                iNovServiceService2.login(signString, new INovCallback<DJXUser>() { // from class: com.dhylive.app.csj.NovHolder.login.1
                    public void onSuccess(DJXUser data, DJXOthers others) {
                        Object[] objArr = new Object[1];
                        objArr[0] = "小说登录成功id" + (data != null ? data.ouid : null);
                        LogUtils.e(objArr);
                    }

                    public void onError(DJXError error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        LogUtils.e("小说登录失败:" + error);
                    }
                });
            }
        }
    }

    public final void logout() {
        INovService iNovServiceService;
        if (isStartSuccess() && (iNovServiceService = NovSdk.service()) != null) {
            iNovServiceService.logout(new INovCallback<DJXUser>() { // from class: com.dhylive.app.csj.NovHolder.logout.1
                public void onError(DJXError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                }

                public void onSuccess(DJXUser data, DJXOthers others) {
                    Object[] objArr = new Object[1];
                    objArr[0] = "小说退出成功id" + (data != null ? data.ouid : null);
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
