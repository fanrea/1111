package com.dhylive.app;

import android.app.Activity;
import android.app.Application;
import androidx.multidex.MultiDex;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.dhylive.app.csj.DramaHolder;
import com.dhylive.app.csj.NovHolder;
import com.dhylive.app.data.user.UserData;
import com.dhylive.app.utils.SPConfig;
import com.dhylive.app.v.login.activity.LoginAccountActivity;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppApplication.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/dhylive/app/AppApplication;", "Landroid/app/Application;", "()V", "getUpdateVersionFilePath", "", "name", "logout", "", "onCreate", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class AppApplication extends Application {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static AppApplication instance;
    private static UserData userData;

    public static final UserData getUserData() {
        return INSTANCE.getUserData();
    }

    public static final void setUserData(UserData userData2) {
        INSTANCE.setUserData(userData2);
    }

    /* compiled from: AppApplication.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/dhylive/app/AppApplication$Companion;", "", "()V", "instance", "Lcom/dhylive/app/AppApplication;", "getInstance", "()Lcom/dhylive/app/AppApplication;", "setInstance", "(Lcom/dhylive/app/AppApplication;)V", "userData", "Lcom/dhylive/app/data/user/UserData;", "getUserData$annotations", "getUserData", "()Lcom/dhylive/app/data/user/UserData;", "setUserData", "(Lcom/dhylive/app/data/user/UserData;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getUserData$annotations() {
        }

        private Companion() {
        }

        public final AppApplication getInstance() {
            AppApplication appApplication = AppApplication.instance;
            if (appApplication != null) {
                return appApplication;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            return null;
        }

        public final void setInstance(AppApplication appApplication) {
            Intrinsics.checkNotNullParameter(appApplication, "<set-?>");
            AppApplication.instance = appApplication;
        }

        public final UserData getUserData() {
            return AppApplication.userData;
        }

        public final void setUserData(UserData userData) {
            AppApplication.userData = userData;
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        INSTANCE.setInstance(this);
        MultiDex.install(this);
        LogUtils.getConfig().setLogSwitch(false);
    }

    public final String getUpdateVersionFilePath(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        StringBuilder sb = new StringBuilder();
        File externalCacheDir = getExternalCacheDir();
        return sb.append(externalCacheDir != null ? externalCacheDir.getPath() : null).append("/version/").append(name).append(".apk").toString();
    }

    public final void logout() {
        SPUtils.getInstance().put(SPConfig.KEY_TOKEN, "");
        SPUtils.getInstance().put(SPConfig.KEY_SHOP_TOKEN, "");
        SPUtils.getInstance().put(SPConfig.KEY_USERID, 0L);
        userData = null;
        DramaHolder.INSTANCE.logout();
        NovHolder.INSTANCE.logout();
        ActivityUtils.startActivity((Class<? extends Activity>) LoginAccountActivity.class);
        ActivityUtils.finishOtherActivities(LoginAccountActivity.class);
    }
}
