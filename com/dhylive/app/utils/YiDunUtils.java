package com.dhylive.app.utils;

import android.content.Context;
import android.view.View;
import com.blankj.utilcode.util.LogUtils;
import com.dhylive.app.AppAdConfig;
import com.dhylive.app.data.mine.ConfigurationInfo;
import com.netease.htprotect.HTProtect;
import com.netease.htprotect.callback.HTPCallback;
import com.netease.htprotect.result.AntiCheatResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;

/* compiled from: YiDunUtils.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\tJ.\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/dhylive/app/utils/YiDunUtils;", "", "()V", "sTimes", "", "getTokenSuspend", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initYiDun", "", "context", "Landroid/content/Context;", "productId", "logout", "setRoleInfo", "businessId", "roleId", "roleName", "roleAccount", "serverId", "track", "viewOnce", "Landroid/view/View;", "description", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class YiDunUtils {
    public static final YiDunUtils INSTANCE = new YiDunUtils();
    private static int sTimes;

    private YiDunUtils() {
    }

    public final int track(View viewOnce, String description) {
        int iTrack = HTProtect.track(viewOnce, description);
        LogUtils.e("埋点：" + iTrack);
        return iTrack;
    }

    public final void initYiDun(Context context, String productId) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(productId, "productId");
        HTProtect.init(context, productId, new HTPCallback() { // from class: com.dhylive.app.utils.YiDunUtils$$ExternalSyntheticLambda0
            @Override // com.netease.htprotect.callback.HTPCallback
            public final void onReceive(int i, String str) {
                YiDunUtils.initYiDun$lambda$0(i, str);
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initYiDun$lambda$0(int i, String str) {
        if (i == 200) {
            LogUtils.e("易盾初始化成功");
        } else {
            LogUtils.e("易盾初始化失败" + i);
        }
    }

    public final int setRoleInfo(String businessId, String roleId, String roleName, String roleAccount, int serverId) throws JSONException {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        Intrinsics.checkNotNullParameter(roleName, "roleName");
        Intrinsics.checkNotNullParameter(roleAccount, "roleAccount");
        return HTProtect.setRoleInfo(businessId, roleId, roleName, roleAccount, null, serverId, null);
    }

    public final void logout() {
        HTProtect.unregisterTouchEvent();
        HTProtect.logOut();
    }

    /* compiled from: YiDunUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.utils.YiDunUtils$getTokenSuspend$2", f = "YiDunUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.utils.YiDunUtils$getTokenSuspend$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            String businessId;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ConfigurationInfo config = AppAdConfig.INSTANCE.getConfig();
            String str = "";
            if (config != null && config.getYidunStatus() == 1) {
                if (YiDunUtils.sTimes % 5 == 0) {
                    YiDunUtils yiDunUtils = YiDunUtils.INSTANCE;
                    YiDunUtils.sTimes++;
                    ConfigurationInfo config2 = AppAdConfig.INSTANCE.getConfig();
                    if (config2 == null || (businessId = config2.getBusinessId()) == null) {
                        businessId = "";
                    }
                    AntiCheatResult token = HTProtect.getToken(3000, businessId);
                    if (token.code == 200) {
                        LogUtils.e("易盾token " + token.token);
                        str = token.token;
                    } else {
                        LogUtils.e("易盾获取token失败");
                    }
                } else {
                    YiDunUtils yiDunUtils2 = YiDunUtils.INSTANCE;
                    YiDunUtils.sTimes++;
                    LogUtils.e("次数累计中" + YiDunUtils.sTimes);
                }
                Intrinsics.checkNotNull(str);
                return str;
            }
            LogUtils.e("易盾未开启");
            return "";
        }
    }

    public final Object getTokenSuspend(Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }
}
