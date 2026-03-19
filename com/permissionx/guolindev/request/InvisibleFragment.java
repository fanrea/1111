package com.permissionx.guolindev.request;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.luck.picture.lib.permissions.PermissionUtil;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.ExplainReasonCallback;
import com.permissionx.guolindev.callback.ExplainReasonCallbackWithBeforeParam;
import com.ss.texturerender.TextureRenderKeys;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvisibleFragment.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\u001c\u0010!\u001a\u00020\u001a2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00180#H\u0002J\b\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\u0016\u0010'\u001a\u00020\u001a2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001a0)H\u0002J\u0016\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0016J\u0016\u0010-\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0016J\u0016\u0010.\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0016J\u0018\u0010/\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0016H\u0007J\u0016\u00100\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0016J$\u00101\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\n2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\f032\u0006\u0010,\u001a\u00020\u0016J\u0016\u00104\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0016J\u0016\u00105\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\f0\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\f0\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \u0006*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00110\u00110\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/permissionx/guolindev/request/InvisibleFragment;", "Landroidx/fragment/app/Fragment;", "()V", "forwardToSettingsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "handler", "Landroid/os/Handler;", "pb", "Lcom/permissionx/guolindev/request/PermissionBuilder;", "requestBackgroundLocationLauncher", "", "requestBodySensorsBackgroundLauncher", "requestInstallPackagesLauncher", "requestManageExternalStorageLauncher", "requestNormalPermissionLauncher", "", "requestNotificationLauncher", "requestSystemAlertWindowLauncher", "requestWriteSettingsLauncher", "task", "Lcom/permissionx/guolindev/request/ChainTask;", "checkForGC", "", "forwardToSettings", "", "onDestroy", "onRequestBackgroundLocationPermissionResult", "granted", "onRequestBodySensorsBackgroundPermissionResult", "onRequestInstallPackagesPermissionResult", "onRequestManageExternalStoragePermissionResult", "onRequestNormalPermissionsResult", "grantResults", "", "onRequestNotificationPermissionResult", "onRequestSystemAlertWindowPermissionResult", "onRequestWriteSettingsPermissionResult", "postForResult", TextureRenderKeys.KEY_IS_CALLBACK, "Lkotlin/Function0;", "requestAccessBackgroundLocationPermissionNow", "permissionBuilder", "chainTask", "requestBodySensorsBackgroundPermissionNow", "requestInstallPackagesPermissionNow", "requestManageExternalStoragePermissionNow", "requestNotificationPermissionNow", "requestNow", "permissions", "", "requestSystemAlertWindowPermissionNow", "requestWriteSettingsPermissionNow", "permissionx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class InvisibleFragment extends Fragment {
    private final ActivityResultLauncher<Intent> forwardToSettingsLauncher;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private PermissionBuilder pb;
    private final ActivityResultLauncher<String> requestBackgroundLocationLauncher;
    private final ActivityResultLauncher<String> requestBodySensorsBackgroundLauncher;
    private final ActivityResultLauncher<Intent> requestInstallPackagesLauncher;
    private final ActivityResultLauncher<Intent> requestManageExternalStorageLauncher;
    private final ActivityResultLauncher<String[]> requestNormalPermissionLauncher;
    private final ActivityResultLauncher<Intent> requestNotificationLauncher;
    private final ActivityResultLauncher<Intent> requestSystemAlertWindowLauncher;
    private final ActivityResultLauncher<Intent> requestWriteSettingsLauncher;
    private ChainTask task;

    public InvisibleFragment() {
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.permissionx.guolindev.request.InvisibleFragment$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InvisibleFragment.m1284requestNormalPermissionLauncher$lambda0(this.f$0, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.requestNormalPermissionLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.permissionx.guolindev.request.InvisibleFragment$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InvisibleFragment.m1280requestBackgroundLocationLauncher$lambda1(this.f$0, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResul…)\n            }\n        }");
        this.requestBackgroundLocationLauncher = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.permissionx.guolindev.request.InvisibleFragment$$ExternalSyntheticLambda3
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InvisibleFragment.m1286requestSystemAlertWindowLauncher$lambda2(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResul…)\n            }\n        }");
        this.requestSystemAlertWindowLauncher = activityResultLauncherRegisterForActivityResult3;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.permissionx.guolindev.request.InvisibleFragment$$ExternalSyntheticLambda4
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InvisibleFragment.m1287requestWriteSettingsLauncher$lambda3(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult4, "registerForActivityResul…)\n            }\n        }");
        this.requestWriteSettingsLauncher = activityResultLauncherRegisterForActivityResult4;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.permissionx.guolindev.request.InvisibleFragment$$ExternalSyntheticLambda5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InvisibleFragment.m1283requestManageExternalStorageLauncher$lambda4(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult5, "registerForActivityResul…)\n            }\n        }");
        this.requestManageExternalStorageLauncher = activityResultLauncherRegisterForActivityResult5;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult6 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.permissionx.guolindev.request.InvisibleFragment$$ExternalSyntheticLambda6
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InvisibleFragment.m1282requestInstallPackagesLauncher$lambda5(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult6, "registerForActivityResul…)\n            }\n        }");
        this.requestInstallPackagesLauncher = activityResultLauncherRegisterForActivityResult6;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult7 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.permissionx.guolindev.request.InvisibleFragment$$ExternalSyntheticLambda7
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InvisibleFragment.m1285requestNotificationLauncher$lambda6(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult7, "registerForActivityResul…)\n            }\n        }");
        this.requestNotificationLauncher = activityResultLauncherRegisterForActivityResult7;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult8 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.permissionx.guolindev.request.InvisibleFragment$$ExternalSyntheticLambda8
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InvisibleFragment.m1281requestBodySensorsBackgroundLauncher$lambda7(this.f$0, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult8, "registerForActivityResul…)\n            }\n        }");
        this.requestBodySensorsBackgroundLauncher = activityResultLauncherRegisterForActivityResult8;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult9 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.permissionx.guolindev.request.InvisibleFragment$$ExternalSyntheticLambda9
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InvisibleFragment.m1278forwardToSettingsLauncher$lambda8(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult9, "registerForActivityResul…)\n            }\n        }");
        this.forwardToSettingsLauncher = activityResultLauncherRegisterForActivityResult9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestNormalPermissionLauncher$lambda-0, reason: not valid java name */
    public static final void m1284requestNormalPermissionLauncher$lambda0(final InvisibleFragment invisibleFragment, final Map map) {
        Intrinsics.checkNotNullParameter(invisibleFragment, "this$0");
        invisibleFragment.postForResult(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestNormalPermissionLauncher$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1298invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1298invoke() {
                InvisibleFragment invisibleFragment2 = this.this$0;
                Map<String, Boolean> map2 = map;
                Intrinsics.checkNotNullExpressionValue(map2, "grantResults");
                invisibleFragment2.onRequestNormalPermissionsResult(map2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestBackgroundLocationLauncher$lambda-1, reason: not valid java name */
    public static final void m1280requestBackgroundLocationLauncher$lambda1(final InvisibleFragment invisibleFragment, final Boolean bool) {
        Intrinsics.checkNotNullParameter(invisibleFragment, "this$0");
        invisibleFragment.postForResult(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestBackgroundLocationLauncher$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1294invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1294invoke() {
                InvisibleFragment invisibleFragment2 = this.this$0;
                Boolean bool2 = bool;
                Intrinsics.checkNotNullExpressionValue(bool2, "granted");
                invisibleFragment2.onRequestBackgroundLocationPermissionResult(bool2.booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestSystemAlertWindowLauncher$lambda-2, reason: not valid java name */
    public static final void m1286requestSystemAlertWindowLauncher$lambda2(final InvisibleFragment invisibleFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(invisibleFragment, "this$0");
        invisibleFragment.postForResult(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestSystemAlertWindowLauncher$1$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1300invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1300invoke() {
                this.this$0.onRequestSystemAlertWindowPermissionResult();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestWriteSettingsLauncher$lambda-3, reason: not valid java name */
    public static final void m1287requestWriteSettingsLauncher$lambda3(final InvisibleFragment invisibleFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(invisibleFragment, "this$0");
        invisibleFragment.postForResult(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestWriteSettingsLauncher$1$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1301invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1301invoke() {
                this.this$0.onRequestWriteSettingsPermissionResult();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestManageExternalStorageLauncher$lambda-4, reason: not valid java name */
    public static final void m1283requestManageExternalStorageLauncher$lambda4(final InvisibleFragment invisibleFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(invisibleFragment, "this$0");
        invisibleFragment.postForResult(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestManageExternalStorageLauncher$1$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1297invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1297invoke() {
                this.this$0.onRequestManageExternalStoragePermissionResult();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestInstallPackagesLauncher$lambda-5, reason: not valid java name */
    public static final void m1282requestInstallPackagesLauncher$lambda5(final InvisibleFragment invisibleFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(invisibleFragment, "this$0");
        invisibleFragment.postForResult(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestInstallPackagesLauncher$1$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1296invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1296invoke() {
                this.this$0.onRequestInstallPackagesPermissionResult();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestNotificationLauncher$lambda-6, reason: not valid java name */
    public static final void m1285requestNotificationLauncher$lambda6(final InvisibleFragment invisibleFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(invisibleFragment, "this$0");
        invisibleFragment.postForResult(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestNotificationLauncher$1$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1299invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1299invoke() {
                this.this$0.onRequestNotificationPermissionResult();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestBodySensorsBackgroundLauncher$lambda-7, reason: not valid java name */
    public static final void m1281requestBodySensorsBackgroundLauncher$lambda7(final InvisibleFragment invisibleFragment, final Boolean bool) {
        Intrinsics.checkNotNullParameter(invisibleFragment, "this$0");
        invisibleFragment.postForResult(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment$requestBodySensorsBackgroundLauncher$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1295invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1295invoke() {
                InvisibleFragment invisibleFragment2 = this.this$0;
                Boolean bool2 = bool;
                Intrinsics.checkNotNullExpressionValue(bool2, "granted");
                invisibleFragment2.onRequestBodySensorsBackgroundPermissionResult(bool2.booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: forwardToSettingsLauncher$lambda-8, reason: not valid java name */
    public static final void m1278forwardToSettingsLauncher$lambda8(InvisibleFragment invisibleFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(invisibleFragment, "this$0");
        if (invisibleFragment.checkForGC()) {
            ChainTask chainTask = invisibleFragment.task;
            PermissionBuilder permissionBuilder = null;
            if (chainTask == null) {
                Intrinsics.throwUninitializedPropertyAccessException("task");
                chainTask = null;
            }
            PermissionBuilder permissionBuilder2 = invisibleFragment.pb;
            if (permissionBuilder2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
            } else {
                permissionBuilder = permissionBuilder2;
            }
            chainTask.requestAgain(new ArrayList(permissionBuilder.forwardPermissions));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void requestNow(PermissionBuilder permissionBuilder, Set<String> permissions, ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        ActivityResultLauncher<String[]> activityResultLauncher = this.requestNormalPermissionLauncher;
        Object[] array = permissions.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        activityResultLauncher.launch(array);
    }

    public final void requestAccessBackgroundLocationPermissionNow(PermissionBuilder permissionBuilder, ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        this.requestBackgroundLocationLauncher.launch(RequestBackgroundLocationPermission.ACCESS_BACKGROUND_LOCATION);
    }

    public final void requestSystemAlertWindowPermissionNow(PermissionBuilder permissionBuilder, ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(requireContext())) {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(Uri.parse("package:" + requireActivity().getPackageName()));
            this.requestSystemAlertWindowLauncher.launch(intent);
            return;
        }
        onRequestSystemAlertWindowPermissionResult();
    }

    public final void requestWriteSettingsPermissionNow(PermissionBuilder permissionBuilder, ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        if (Build.VERSION.SDK_INT >= 23 && !Settings.System.canWrite(requireContext())) {
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse("package:" + requireActivity().getPackageName()));
            this.requestWriteSettingsLauncher.launch(intent);
            return;
        }
        onRequestWriteSettingsPermissionResult();
    }

    public final void requestManageExternalStoragePermissionNow(PermissionBuilder permissionBuilder, ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        if (Build.VERSION.SDK_INT >= 30 && !Environment.isExternalStorageManager()) {
            Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent.setData(Uri.parse("package:" + requireActivity().getPackageName()));
            if (intent.resolveActivity(requireActivity().getPackageManager()) == null) {
                intent = new Intent(PermissionUtil.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
            }
            this.requestManageExternalStorageLauncher.launch(intent);
            return;
        }
        onRequestManageExternalStoragePermissionResult();
    }

    public final void requestInstallPackagesPermissionNow(PermissionBuilder permissionBuilder, ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            intent.setData(Uri.parse("package:" + requireActivity().getPackageName()));
            this.requestInstallPackagesLauncher.launch(intent);
            return;
        }
        onRequestInstallPackagesPermissionResult();
    }

    public final void requestNotificationPermissionNow(PermissionBuilder permissionBuilder, ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", requireActivity().getPackageName());
            this.requestNotificationLauncher.launch(intent);
            return;
        }
        onRequestInstallPackagesPermissionResult();
    }

    public final void requestBodySensorsBackgroundPermissionNow(PermissionBuilder permissionBuilder, ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        this.requestBodySensorsBackgroundLauncher.launch(RequestBodySensorsBackgroundPermission.BODY_SENSORS_BACKGROUND);
    }

    public final void forwardToSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", requireActivity().getPackageName(), null));
        this.forwardToSettingsLauncher.launch(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (checkForGC()) {
            PermissionBuilder permissionBuilder = this.pb;
            if (permissionBuilder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
                permissionBuilder = null;
            }
            Dialog dialog = permissionBuilder.currentDialog;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01fa, code lost:
    
        if ((!r9.tempPermanentDeniedPermissions.isEmpty()) != false) goto L124;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onRequestNormalPermissionsResult(java.util.Map<java.lang.String, java.lang.Boolean> r9) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.permissionx.guolindev.request.InvisibleFragment.onRequestNormalPermissionsResult(java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRequestBackgroundLocationPermissionResult(final boolean granted) {
        if (checkForGC()) {
            postForResult(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment.onRequestBackgroundLocationPermissionResult.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1288invoke();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
                /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
                /* renamed from: invoke, reason: collision with other method in class */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void m1288invoke() {
                    /*
                        Method dump skipped, instructions count: 324
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.permissionx.guolindev.request.InvisibleFragment.AnonymousClass1.m1288invoke():void");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRequestSystemAlertWindowPermissionResult() {
        if (checkForGC()) {
            ChainTask chainTask = null;
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(requireContext())) {
                    ChainTask chainTask2 = this.task;
                    if (chainTask2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("task");
                    } else {
                        chainTask = chainTask2;
                    }
                    chainTask.finish();
                    return;
                }
                PermissionBuilder permissionBuilder = this.pb;
                if (permissionBuilder == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pb");
                    permissionBuilder = null;
                }
                if (permissionBuilder.explainReasonCallback == null) {
                    PermissionBuilder permissionBuilder2 = this.pb;
                    if (permissionBuilder2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        permissionBuilder2 = null;
                    }
                    if (permissionBuilder2.explainReasonCallbackWithBeforeParam == null) {
                        return;
                    }
                }
                PermissionBuilder permissionBuilder3 = this.pb;
                if (permissionBuilder3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pb");
                    permissionBuilder3 = null;
                }
                if (permissionBuilder3.explainReasonCallbackWithBeforeParam != null) {
                    PermissionBuilder permissionBuilder4 = this.pb;
                    if (permissionBuilder4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        permissionBuilder4 = null;
                    }
                    ExplainReasonCallbackWithBeforeParam explainReasonCallbackWithBeforeParam = permissionBuilder4.explainReasonCallbackWithBeforeParam;
                    Intrinsics.checkNotNull(explainReasonCallbackWithBeforeParam);
                    ChainTask chainTask3 = this.task;
                    if (chainTask3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("task");
                    } else {
                        chainTask = chainTask3;
                    }
                    explainReasonCallbackWithBeforeParam.onExplainReason(chainTask.getExplainReasonScope(), CollectionsKt.listOf("android.permission.SYSTEM_ALERT_WINDOW"), false);
                    return;
                }
                PermissionBuilder permissionBuilder5 = this.pb;
                if (permissionBuilder5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pb");
                    permissionBuilder5 = null;
                }
                ExplainReasonCallback explainReasonCallback = permissionBuilder5.explainReasonCallback;
                Intrinsics.checkNotNull(explainReasonCallback);
                ChainTask chainTask4 = this.task;
                if (chainTask4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("task");
                } else {
                    chainTask = chainTask4;
                }
                explainReasonCallback.onExplainReason(chainTask.getExplainReasonScope(), CollectionsKt.listOf("android.permission.SYSTEM_ALERT_WINDOW"));
                return;
            }
            ChainTask chainTask5 = this.task;
            if (chainTask5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("task");
            } else {
                chainTask = chainTask5;
            }
            chainTask.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRequestWriteSettingsPermissionResult() {
        if (checkForGC()) {
            postForResult(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment.onRequestWriteSettingsPermissionResult.1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1293invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1293invoke() {
                    ChainTask chainTask = null;
                    if (Build.VERSION.SDK_INT < 23) {
                        ChainTask chainTask2 = InvisibleFragment.this.task;
                        if (chainTask2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("task");
                        } else {
                            chainTask = chainTask2;
                        }
                        chainTask.finish();
                        return;
                    }
                    if (Settings.System.canWrite(InvisibleFragment.this.requireContext())) {
                        ChainTask chainTask3 = InvisibleFragment.this.task;
                        if (chainTask3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("task");
                        } else {
                            chainTask = chainTask3;
                        }
                        chainTask.finish();
                        return;
                    }
                    PermissionBuilder permissionBuilder = InvisibleFragment.this.pb;
                    if (permissionBuilder == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        permissionBuilder = null;
                    }
                    if (permissionBuilder.explainReasonCallback == null) {
                        PermissionBuilder permissionBuilder2 = InvisibleFragment.this.pb;
                        if (permissionBuilder2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pb");
                            permissionBuilder2 = null;
                        }
                        if (permissionBuilder2.explainReasonCallbackWithBeforeParam == null) {
                            return;
                        }
                    }
                    PermissionBuilder permissionBuilder3 = InvisibleFragment.this.pb;
                    if (permissionBuilder3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        permissionBuilder3 = null;
                    }
                    if (permissionBuilder3.explainReasonCallbackWithBeforeParam != null) {
                        PermissionBuilder permissionBuilder4 = InvisibleFragment.this.pb;
                        if (permissionBuilder4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pb");
                            permissionBuilder4 = null;
                        }
                        ExplainReasonCallbackWithBeforeParam explainReasonCallbackWithBeforeParam = permissionBuilder4.explainReasonCallbackWithBeforeParam;
                        Intrinsics.checkNotNull(explainReasonCallbackWithBeforeParam);
                        ChainTask chainTask4 = InvisibleFragment.this.task;
                        if (chainTask4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("task");
                        } else {
                            chainTask = chainTask4;
                        }
                        explainReasonCallbackWithBeforeParam.onExplainReason(chainTask.getExplainReasonScope(), CollectionsKt.listOf("android.permission.WRITE_SETTINGS"), false);
                        return;
                    }
                    PermissionBuilder permissionBuilder5 = InvisibleFragment.this.pb;
                    if (permissionBuilder5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        permissionBuilder5 = null;
                    }
                    ExplainReasonCallback explainReasonCallback = permissionBuilder5.explainReasonCallback;
                    Intrinsics.checkNotNull(explainReasonCallback);
                    ChainTask chainTask5 = InvisibleFragment.this.task;
                    if (chainTask5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("task");
                    } else {
                        chainTask = chainTask5;
                    }
                    explainReasonCallback.onExplainReason(chainTask.getExplainReasonScope(), CollectionsKt.listOf("android.permission.WRITE_SETTINGS"));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRequestManageExternalStoragePermissionResult() {
        if (checkForGC()) {
            postForResult(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment.onRequestManageExternalStoragePermissionResult.1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1291invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1291invoke() {
                    ChainTask chainTask = null;
                    if (Build.VERSION.SDK_INT < 30) {
                        ChainTask chainTask2 = InvisibleFragment.this.task;
                        if (chainTask2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("task");
                        } else {
                            chainTask = chainTask2;
                        }
                        chainTask.finish();
                        return;
                    }
                    if (Environment.isExternalStorageManager()) {
                        ChainTask chainTask3 = InvisibleFragment.this.task;
                        if (chainTask3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("task");
                        } else {
                            chainTask = chainTask3;
                        }
                        chainTask.finish();
                        return;
                    }
                    PermissionBuilder permissionBuilder = InvisibleFragment.this.pb;
                    if (permissionBuilder == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        permissionBuilder = null;
                    }
                    if (permissionBuilder.explainReasonCallback == null) {
                        PermissionBuilder permissionBuilder2 = InvisibleFragment.this.pb;
                        if (permissionBuilder2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pb");
                            permissionBuilder2 = null;
                        }
                        if (permissionBuilder2.explainReasonCallbackWithBeforeParam == null) {
                            return;
                        }
                    }
                    PermissionBuilder permissionBuilder3 = InvisibleFragment.this.pb;
                    if (permissionBuilder3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        permissionBuilder3 = null;
                    }
                    if (permissionBuilder3.explainReasonCallbackWithBeforeParam != null) {
                        PermissionBuilder permissionBuilder4 = InvisibleFragment.this.pb;
                        if (permissionBuilder4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pb");
                            permissionBuilder4 = null;
                        }
                        ExplainReasonCallbackWithBeforeParam explainReasonCallbackWithBeforeParam = permissionBuilder4.explainReasonCallbackWithBeforeParam;
                        Intrinsics.checkNotNull(explainReasonCallbackWithBeforeParam);
                        ChainTask chainTask4 = InvisibleFragment.this.task;
                        if (chainTask4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("task");
                        } else {
                            chainTask = chainTask4;
                        }
                        explainReasonCallbackWithBeforeParam.onExplainReason(chainTask.getExplainReasonScope(), CollectionsKt.listOf(RequestManageExternalStoragePermission.MANAGE_EXTERNAL_STORAGE), false);
                        return;
                    }
                    PermissionBuilder permissionBuilder5 = InvisibleFragment.this.pb;
                    if (permissionBuilder5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        permissionBuilder5 = null;
                    }
                    ExplainReasonCallback explainReasonCallback = permissionBuilder5.explainReasonCallback;
                    Intrinsics.checkNotNull(explainReasonCallback);
                    ChainTask chainTask5 = InvisibleFragment.this.task;
                    if (chainTask5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("task");
                    } else {
                        chainTask = chainTask5;
                    }
                    explainReasonCallback.onExplainReason(chainTask.getExplainReasonScope(), CollectionsKt.listOf(RequestManageExternalStoragePermission.MANAGE_EXTERNAL_STORAGE));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRequestInstallPackagesPermissionResult() {
        if (checkForGC()) {
            postForResult(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment.onRequestInstallPackagesPermissionResult.1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1290invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1290invoke() {
                    ChainTask chainTask = null;
                    if (Build.VERSION.SDK_INT < 26) {
                        ChainTask chainTask2 = InvisibleFragment.this.task;
                        if (chainTask2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("task");
                        } else {
                            chainTask = chainTask2;
                        }
                        chainTask.finish();
                        return;
                    }
                    if (InvisibleFragment.this.requireActivity().getPackageManager().canRequestPackageInstalls()) {
                        ChainTask chainTask3 = InvisibleFragment.this.task;
                        if (chainTask3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("task");
                        } else {
                            chainTask = chainTask3;
                        }
                        chainTask.finish();
                        return;
                    }
                    PermissionBuilder permissionBuilder = InvisibleFragment.this.pb;
                    if (permissionBuilder == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        permissionBuilder = null;
                    }
                    if (permissionBuilder.explainReasonCallback == null) {
                        PermissionBuilder permissionBuilder2 = InvisibleFragment.this.pb;
                        if (permissionBuilder2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pb");
                            permissionBuilder2 = null;
                        }
                        if (permissionBuilder2.explainReasonCallbackWithBeforeParam == null) {
                            return;
                        }
                    }
                    PermissionBuilder permissionBuilder3 = InvisibleFragment.this.pb;
                    if (permissionBuilder3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        permissionBuilder3 = null;
                    }
                    if (permissionBuilder3.explainReasonCallbackWithBeforeParam != null) {
                        PermissionBuilder permissionBuilder4 = InvisibleFragment.this.pb;
                        if (permissionBuilder4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pb");
                            permissionBuilder4 = null;
                        }
                        ExplainReasonCallbackWithBeforeParam explainReasonCallbackWithBeforeParam = permissionBuilder4.explainReasonCallbackWithBeforeParam;
                        Intrinsics.checkNotNull(explainReasonCallbackWithBeforeParam);
                        ChainTask chainTask4 = InvisibleFragment.this.task;
                        if (chainTask4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("task");
                        } else {
                            chainTask = chainTask4;
                        }
                        explainReasonCallbackWithBeforeParam.onExplainReason(chainTask.getExplainReasonScope(), CollectionsKt.listOf(RequestInstallPackagesPermission.REQUEST_INSTALL_PACKAGES), false);
                        return;
                    }
                    PermissionBuilder permissionBuilder5 = InvisibleFragment.this.pb;
                    if (permissionBuilder5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        permissionBuilder5 = null;
                    }
                    ExplainReasonCallback explainReasonCallback = permissionBuilder5.explainReasonCallback;
                    Intrinsics.checkNotNull(explainReasonCallback);
                    ChainTask chainTask5 = InvisibleFragment.this.task;
                    if (chainTask5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("task");
                    } else {
                        chainTask = chainTask5;
                    }
                    explainReasonCallback.onExplainReason(chainTask.getExplainReasonScope(), CollectionsKt.listOf(RequestInstallPackagesPermission.REQUEST_INSTALL_PACKAGES));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRequestNotificationPermissionResult() {
        if (checkForGC()) {
            postForResult(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment.onRequestNotificationPermissionResult.1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1292invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1292invoke() {
                    ChainTask chainTask = null;
                    if (Build.VERSION.SDK_INT < 26) {
                        ChainTask chainTask2 = InvisibleFragment.this.task;
                        if (chainTask2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("task");
                        } else {
                            chainTask = chainTask2;
                        }
                        chainTask.finish();
                        return;
                    }
                    if (PermissionX.areNotificationsEnabled(InvisibleFragment.this.requireContext())) {
                        ChainTask chainTask3 = InvisibleFragment.this.task;
                        if (chainTask3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("task");
                        } else {
                            chainTask = chainTask3;
                        }
                        chainTask.finish();
                        return;
                    }
                    PermissionBuilder permissionBuilder = InvisibleFragment.this.pb;
                    if (permissionBuilder == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        permissionBuilder = null;
                    }
                    if (permissionBuilder.explainReasonCallback == null) {
                        PermissionBuilder permissionBuilder2 = InvisibleFragment.this.pb;
                        if (permissionBuilder2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pb");
                            permissionBuilder2 = null;
                        }
                        if (permissionBuilder2.explainReasonCallbackWithBeforeParam == null) {
                            return;
                        }
                    }
                    PermissionBuilder permissionBuilder3 = InvisibleFragment.this.pb;
                    if (permissionBuilder3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        permissionBuilder3 = null;
                    }
                    if (permissionBuilder3.explainReasonCallbackWithBeforeParam != null) {
                        PermissionBuilder permissionBuilder4 = InvisibleFragment.this.pb;
                        if (permissionBuilder4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pb");
                            permissionBuilder4 = null;
                        }
                        ExplainReasonCallbackWithBeforeParam explainReasonCallbackWithBeforeParam = permissionBuilder4.explainReasonCallbackWithBeforeParam;
                        Intrinsics.checkNotNull(explainReasonCallbackWithBeforeParam);
                        ChainTask chainTask4 = InvisibleFragment.this.task;
                        if (chainTask4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("task");
                        } else {
                            chainTask = chainTask4;
                        }
                        explainReasonCallbackWithBeforeParam.onExplainReason(chainTask.getExplainReasonScope(), CollectionsKt.listOf(PermissionX.permission.POST_NOTIFICATIONS), false);
                        return;
                    }
                    PermissionBuilder permissionBuilder5 = InvisibleFragment.this.pb;
                    if (permissionBuilder5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        permissionBuilder5 = null;
                    }
                    ExplainReasonCallback explainReasonCallback = permissionBuilder5.explainReasonCallback;
                    Intrinsics.checkNotNull(explainReasonCallback);
                    ChainTask chainTask5 = InvisibleFragment.this.task;
                    if (chainTask5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("task");
                    } else {
                        chainTask = chainTask5;
                    }
                    explainReasonCallback.onExplainReason(chainTask.getExplainReasonScope(), CollectionsKt.listOf(PermissionX.permission.POST_NOTIFICATIONS));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRequestBodySensorsBackgroundPermissionResult(final boolean granted) {
        if (checkForGC()) {
            postForResult(new Function0<Unit>() { // from class: com.permissionx.guolindev.request.InvisibleFragment.onRequestBodySensorsBackgroundPermissionResult.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1289invoke();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
                /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
                /* renamed from: invoke, reason: collision with other method in class */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void m1289invoke() {
                    /*
                        Method dump skipped, instructions count: 324
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.permissionx.guolindev.request.InvisibleFragment.C09651.m1289invoke():void");
                }
            });
        }
    }

    private final boolean checkForGC() {
        if (this.pb != null && this.task != null) {
            return true;
        }
        Log.w("PermissionX", "PermissionBuilder and ChainTask should not be null at this time, so we can do nothing in this case.");
        return false;
    }

    private final void postForResult(final Function0<Unit> callback) {
        this.handler.post(new Runnable() { // from class: com.permissionx.guolindev.request.InvisibleFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InvisibleFragment.m1279postForResult$lambda10(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: postForResult$lambda-10, reason: not valid java name */
    public static final void m1279postForResult$lambda10(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$callback");
        function0.invoke();
    }
}
