package com.permissionx.guolindev.request;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.mobads.container.util.cm;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.ExplainReasonCallback;
import com.permissionx.guolindev.callback.ExplainReasonCallbackWithBeforeParam;
import com.permissionx.guolindev.callback.ForwardToSettingsCallback;
import com.permissionx.guolindev.callback.RequestCallback;
import com.permissionx.guolindev.dialog.DefaultDialog;
import com.permissionx.guolindev.dialog.RationaleDialog;
import com.permissionx.guolindev.dialog.RationaleDialogFragment;
import com.ss.texturerender.TextureRenderKeys;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionBuilder.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \\2\u00020\u0001:\u0001\\B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nJ\r\u00102\u001a\u000203H\u0000¢\u0006\u0002\b4J\u0006\u0010\u0015\u001a\u00020\u0000J\u0016\u00105\u001a\u0002032\f\u00106\u001a\b\u0012\u0004\u0012\u00020\b07H\u0002J\b\u00108\u001a\u000203H\u0003J\u0010\u00109\u001a\u00020\u00002\b\u0010:\u001a\u0004\u0018\u00010\u0018J\u0010\u00109\u001a\u00020\u00002\b\u0010:\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010;\u001a\u00020\u00002\b\u0010:\u001a\u0004\u0018\u00010\u001dJ\b\u0010<\u001a\u000203H\u0002J\u0010\u0010=\u001a\u0002032\b\u0010:\u001a\u0004\u0018\u00010,J\u000e\u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u0002032\u0006\u0010?\u001a\u00020@J\u000e\u0010B\u001a\u0002032\u0006\u0010?\u001a\u00020@J\u000e\u0010C\u001a\u0002032\u0006\u0010?\u001a\u00020@J\u000e\u0010D\u001a\u0002032\u0006\u0010?\u001a\u00020@J\u001c\u0010E\u001a\u0002032\f\u00106\u001a\b\u0012\u0004\u0012\u00020\b0F2\u0006\u0010?\u001a\u00020@J\u000e\u0010G\u001a\u0002032\u0006\u0010?\u001a\u00020@J\u000e\u0010H\u001a\u0002032\u0006\u0010?\u001a\u00020@J\b\u0010I\u001a\u000203H\u0002J\u0016\u0010J\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010K\u001a\u00020\u0016J\u0006\u0010L\u001a\u00020\u0016J\u0006\u0010M\u001a\u00020\u0016J\u0006\u0010N\u001a\u00020\u0016J\u0006\u0010O\u001a\u00020\u0016J\u0006\u0010P\u001a\u00020\u0016J\u0006\u0010Q\u001a\u00020\u0016J\u001e\u0010R\u001a\u0002032\u0006\u0010?\u001a\u00020@2\u0006\u0010S\u001a\u00020\u00162\u0006\u0010T\u001a\u00020UJ\u001e\u0010R\u001a\u0002032\u0006\u0010?\u001a\u00020@2\u0006\u0010S\u001a\u00020\u00162\u0006\u0010V\u001a\u00020WJ>\u0010R\u001a\u0002032\u0006\u0010?\u001a\u00020@2\u0006\u0010S\u001a\u00020\u00162\f\u00106\u001a\b\u0012\u0004\u0012\u00020\b072\u0006\u0010X\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\b2\b\u0010Z\u001a\u0004\u0018\u00010\bJ\b\u0010[\u001a\u000203H\u0002R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0018\u00101\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/permissionx/guolindev/request/PermissionBuilder;", "", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "normalPermissions", "", "", "specialPermissions", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;Ljava/util/Set;Ljava/util/Set;)V", "activity", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "currentDialog", "Landroid/app/Dialog;", "darkColor", "", "deniedPermissions", "explainReasonBeforeRequest", "", "explainReasonCallback", "Lcom/permissionx/guolindev/callback/ExplainReasonCallback;", "explainReasonCallbackWithBeforeParam", "Lcom/permissionx/guolindev/callback/ExplainReasonCallbackWithBeforeParam;", "forwardPermissions", "forwardToSettingsCallback", "Lcom/permissionx/guolindev/callback/ForwardToSettingsCallback;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "grantedPermissions", "invisibleFragment", "Lcom/permissionx/guolindev/request/InvisibleFragment;", "getInvisibleFragment", "()Lcom/permissionx/guolindev/request/InvisibleFragment;", "lightColor", "originRequestOrientation", "permanentDeniedPermissions", "permissionsWontRequest", "requestCallback", "Lcom/permissionx/guolindev/callback/RequestCallback;", "showDialogCalled", "targetSdkVersion", "getTargetSdkVersion", "()I", "tempPermanentDeniedPermissions", "endRequest", "", "endRequest$permissionx_release", "forwardToSettings", "permissions", "", "lockOrientation", "onExplainRequestReason", TextureRenderKeys.KEY_IS_CALLBACK, "onForwardToSettings", "removeInvisibleFragment", "request", "requestAccessBackgroundLocationPermissionNow", "chainTask", "Lcom/permissionx/guolindev/request/ChainTask;", "requestBodySensorsBackgroundPermissionNow", "requestInstallPackagePermissionNow", "requestManageExternalStoragePermissionNow", "requestNotificationPermissionNow", "requestNow", "", "requestSystemAlertWindowPermissionNow", "requestWriteSettingsPermissionNow", "restoreOrientation", "setDialogTintColor", "shouldRequestBackgroundLocationPermission", "shouldRequestBodySensorsBackgroundPermission", "shouldRequestInstallPackagesPermission", "shouldRequestManageExternalStoragePermission", "shouldRequestNotificationPermission", "shouldRequestSystemAlertWindowPermission", "shouldRequestWriteSettingsPermission", "showHandlePermissionDialog", "showReasonOrGoSettings", "dialog", "Lcom/permissionx/guolindev/dialog/RationaleDialog;", "dialogFragment", "Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;", cm.V, "positiveText", "negativeText", "startRequest", "Companion", "permissionx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class PermissionBuilder {
    private static final String FRAGMENT_TAG = "InvisibleFragment";
    public FragmentActivity activity;
    public Dialog currentDialog;
    private int darkColor;
    public Set<String> deniedPermissions;
    public boolean explainReasonBeforeRequest;
    public ExplainReasonCallback explainReasonCallback;
    public ExplainReasonCallbackWithBeforeParam explainReasonCallbackWithBeforeParam;
    public Set<String> forwardPermissions;
    public ForwardToSettingsCallback forwardToSettingsCallback;
    private Fragment fragment;
    public Set<String> grantedPermissions;
    private int lightColor;
    public Set<String> normalPermissions;
    private int originRequestOrientation;
    public Set<String> permanentDeniedPermissions;
    public Set<String> permissionsWontRequest;
    public RequestCallback requestCallback;
    public boolean showDialogCalled;
    public Set<String> specialPermissions;
    public Set<String> tempPermanentDeniedPermissions;

    public PermissionBuilder(FragmentActivity fragmentActivity, Fragment fragment, Set<String> set, Set<String> set2) {
        Intrinsics.checkNotNullParameter(set, "normalPermissions");
        Intrinsics.checkNotNullParameter(set2, "specialPermissions");
        this.lightColor = -1;
        this.darkColor = -1;
        this.originRequestOrientation = -1;
        this.permissionsWontRequest = new LinkedHashSet();
        this.grantedPermissions = new LinkedHashSet();
        this.deniedPermissions = new LinkedHashSet();
        this.permanentDeniedPermissions = new LinkedHashSet();
        this.tempPermanentDeniedPermissions = new LinkedHashSet();
        this.forwardPermissions = new LinkedHashSet();
        if (fragmentActivity != null) {
            setActivity(fragmentActivity);
        }
        if (fragmentActivity == null && fragment != null) {
            FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "fragment.requireActivity()");
            setActivity(fragmentActivityRequireActivity);
        }
        this.fragment = fragment;
        this.normalPermissions = set;
        this.specialPermissions = set2;
    }

    public final FragmentActivity getActivity() {
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        return null;
    }

    public final void setActivity(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<set-?>");
        this.activity = fragmentActivity;
    }

    private final FragmentManager getFragmentManager() {
        Fragment fragment = this.fragment;
        FragmentManager childFragmentManager = fragment != null ? fragment.getChildFragmentManager() : null;
        if (childFragmentManager != null) {
            return childFragmentManager;
        }
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        return supportFragmentManager;
    }

    private final InvisibleFragment getInvisibleFragment() {
        Fragment fragmentFindFragmentByTag = getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (fragmentFindFragmentByTag != null) {
            return (InvisibleFragment) fragmentFindFragmentByTag;
        }
        InvisibleFragment invisibleFragment = new InvisibleFragment();
        getFragmentManager().beginTransaction().add(invisibleFragment, FRAGMENT_TAG).commitNowAllowingStateLoss();
        return invisibleFragment;
    }

    public final int getTargetSdkVersion() {
        return getActivity().getApplicationInfo().targetSdkVersion;
    }

    public final PermissionBuilder onExplainRequestReason(ExplainReasonCallback callback) {
        this.explainReasonCallback = callback;
        return this;
    }

    public final PermissionBuilder onExplainRequestReason(ExplainReasonCallbackWithBeforeParam callback) {
        this.explainReasonCallbackWithBeforeParam = callback;
        return this;
    }

    public final PermissionBuilder onForwardToSettings(ForwardToSettingsCallback callback) {
        this.forwardToSettingsCallback = callback;
        return this;
    }

    public final PermissionBuilder explainReasonBeforeRequest() {
        this.explainReasonBeforeRequest = true;
        return this;
    }

    public final PermissionBuilder setDialogTintColor(int lightColor, int darkColor) {
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        return this;
    }

    public final void request(RequestCallback callback) {
        this.requestCallback = callback;
        startRequest();
    }

    public final void showHandlePermissionDialog(ChainTask chainTask, boolean showReasonOrGoSettings, List<String> permissions, String message, String positiveText, String negativeText) {
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(message, cm.V);
        Intrinsics.checkNotNullParameter(positiveText, "positiveText");
        showHandlePermissionDialog(chainTask, showReasonOrGoSettings, new DefaultDialog(getActivity(), permissions, message, positiveText, negativeText, this.lightColor, this.darkColor));
    }

    public final void showHandlePermissionDialog(final ChainTask chainTask, final boolean showReasonOrGoSettings, final RationaleDialog dialog) {
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this.showDialogCalled = true;
        final List<String> permissionsToRequest = dialog.getPermissionsToRequest();
        Intrinsics.checkNotNullExpressionValue(permissionsToRequest, "dialog.permissionsToRequest");
        if (permissionsToRequest.isEmpty()) {
            chainTask.finish();
            return;
        }
        this.currentDialog = dialog;
        dialog.show();
        if ((dialog instanceof DefaultDialog) && ((DefaultDialog) dialog).isPermissionLayoutEmpty$permissionx_release()) {
            dialog.dismiss();
            chainTask.finish();
        }
        View positiveButton = dialog.getPositiveButton();
        Intrinsics.checkNotNullExpressionValue(positiveButton, "dialog.positiveButton");
        View negativeButton = dialog.getNegativeButton();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        positiveButton.setClickable(true);
        positiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.permissionx.guolindev.request.PermissionBuilder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionBuilder.m1304showHandlePermissionDialog$lambda0(dialog, showReasonOrGoSettings, chainTask, permissionsToRequest, this, view);
            }
        });
        if (negativeButton != null) {
            negativeButton.setClickable(true);
            negativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.permissionx.guolindev.request.PermissionBuilder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PermissionBuilder.m1305showHandlePermissionDialog$lambda1(dialog, chainTask, view);
                }
            });
        }
        Dialog dialog2 = this.currentDialog;
        if (dialog2 != null) {
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.permissionx.guolindev.request.PermissionBuilder$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PermissionBuilder.m1306showHandlePermissionDialog$lambda2(this.f$0, dialogInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showHandlePermissionDialog$lambda-0, reason: not valid java name */
    public static final void m1304showHandlePermissionDialog$lambda0(RationaleDialog rationaleDialog, boolean z, ChainTask chainTask, List list, PermissionBuilder permissionBuilder, View view) {
        Intrinsics.checkNotNullParameter(rationaleDialog, "$dialog");
        Intrinsics.checkNotNullParameter(chainTask, "$chainTask");
        Intrinsics.checkNotNullParameter(list, "$permissions");
        Intrinsics.checkNotNullParameter(permissionBuilder, "this$0");
        rationaleDialog.dismiss();
        if (z) {
            chainTask.requestAgain(list);
        } else {
            permissionBuilder.forwardToSettings(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showHandlePermissionDialog$lambda-1, reason: not valid java name */
    public static final void m1305showHandlePermissionDialog$lambda1(RationaleDialog rationaleDialog, ChainTask chainTask, View view) {
        Intrinsics.checkNotNullParameter(rationaleDialog, "$dialog");
        Intrinsics.checkNotNullParameter(chainTask, "$chainTask");
        rationaleDialog.dismiss();
        chainTask.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showHandlePermissionDialog$lambda-2, reason: not valid java name */
    public static final void m1306showHandlePermissionDialog$lambda2(PermissionBuilder permissionBuilder, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(permissionBuilder, "this$0");
        permissionBuilder.currentDialog = null;
    }

    public final void showHandlePermissionDialog(final ChainTask chainTask, final boolean showReasonOrGoSettings, final RationaleDialogFragment dialogFragment) {
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
        this.showDialogCalled = true;
        final List<String> permissionsToRequest = dialogFragment.getPermissionsToRequest();
        Intrinsics.checkNotNullExpressionValue(permissionsToRequest, "dialogFragment.permissionsToRequest");
        if (permissionsToRequest.isEmpty()) {
            chainTask.finish();
            return;
        }
        dialogFragment.showNow(getFragmentManager(), "PermissionXRationaleDialogFragment");
        View positiveButton = dialogFragment.getPositiveButton();
        Intrinsics.checkNotNullExpressionValue(positiveButton, "dialogFragment.positiveButton");
        View negativeButton = dialogFragment.getNegativeButton();
        dialogFragment.setCancelable(false);
        positiveButton.setClickable(true);
        positiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.permissionx.guolindev.request.PermissionBuilder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionBuilder.m1307showHandlePermissionDialog$lambda3(dialogFragment, showReasonOrGoSettings, chainTask, permissionsToRequest, this, view);
            }
        });
        if (negativeButton != null) {
            negativeButton.setClickable(true);
            negativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.permissionx.guolindev.request.PermissionBuilder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PermissionBuilder.m1308showHandlePermissionDialog$lambda4(dialogFragment, chainTask, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showHandlePermissionDialog$lambda-3, reason: not valid java name */
    public static final void m1307showHandlePermissionDialog$lambda3(RationaleDialogFragment rationaleDialogFragment, boolean z, ChainTask chainTask, List list, PermissionBuilder permissionBuilder, View view) {
        Intrinsics.checkNotNullParameter(rationaleDialogFragment, "$dialogFragment");
        Intrinsics.checkNotNullParameter(chainTask, "$chainTask");
        Intrinsics.checkNotNullParameter(list, "$permissions");
        Intrinsics.checkNotNullParameter(permissionBuilder, "this$0");
        rationaleDialogFragment.dismiss();
        if (z) {
            chainTask.requestAgain(list);
        } else {
            permissionBuilder.forwardToSettings(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showHandlePermissionDialog$lambda-4, reason: not valid java name */
    public static final void m1308showHandlePermissionDialog$lambda4(RationaleDialogFragment rationaleDialogFragment, ChainTask chainTask, View view) {
        Intrinsics.checkNotNullParameter(rationaleDialogFragment, "$dialogFragment");
        Intrinsics.checkNotNullParameter(chainTask, "$chainTask");
        rationaleDialogFragment.dismiss();
        chainTask.finish();
    }

    public final void requestNow(Set<String> permissions, ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        getInvisibleFragment().requestNow(this, permissions, chainTask);
    }

    public final void requestAccessBackgroundLocationPermissionNow(ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        getInvisibleFragment().requestAccessBackgroundLocationPermissionNow(this, chainTask);
    }

    public final void requestSystemAlertWindowPermissionNow(ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        getInvisibleFragment().requestSystemAlertWindowPermissionNow(this, chainTask);
    }

    public final void requestWriteSettingsPermissionNow(ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        getInvisibleFragment().requestWriteSettingsPermissionNow(this, chainTask);
    }

    public final void requestManageExternalStoragePermissionNow(ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        getInvisibleFragment().requestManageExternalStoragePermissionNow(this, chainTask);
    }

    public final void requestInstallPackagePermissionNow(ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        getInvisibleFragment().requestInstallPackagesPermissionNow(this, chainTask);
    }

    public final void requestNotificationPermissionNow(ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        getInvisibleFragment().requestNotificationPermissionNow(this, chainTask);
    }

    public final void requestBodySensorsBackgroundPermissionNow(ChainTask chainTask) {
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        getInvisibleFragment().requestBodySensorsBackgroundPermissionNow(this, chainTask);
    }

    public final boolean shouldRequestBackgroundLocationPermission() {
        return this.specialPermissions.contains(RequestBackgroundLocationPermission.ACCESS_BACKGROUND_LOCATION);
    }

    public final boolean shouldRequestSystemAlertWindowPermission() {
        return this.specialPermissions.contains("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public final boolean shouldRequestWriteSettingsPermission() {
        return this.specialPermissions.contains("android.permission.WRITE_SETTINGS");
    }

    public final boolean shouldRequestManageExternalStoragePermission() {
        return this.specialPermissions.contains(RequestManageExternalStoragePermission.MANAGE_EXTERNAL_STORAGE);
    }

    public final boolean shouldRequestInstallPackagesPermission() {
        return this.specialPermissions.contains(RequestInstallPackagesPermission.REQUEST_INSTALL_PACKAGES);
    }

    public final boolean shouldRequestNotificationPermission() {
        return this.specialPermissions.contains(PermissionX.permission.POST_NOTIFICATIONS);
    }

    public final boolean shouldRequestBodySensorsBackgroundPermission() {
        return this.specialPermissions.contains(RequestBodySensorsBackgroundPermission.BODY_SENSORS_BACKGROUND);
    }

    private final void startRequest() {
        lockOrientation();
        RequestChain requestChain = new RequestChain();
        requestChain.addTaskToChain$permissionx_release(new RequestNormalPermissions(this));
        requestChain.addTaskToChain$permissionx_release(new RequestBackgroundLocationPermission(this));
        requestChain.addTaskToChain$permissionx_release(new RequestSystemAlertWindowPermission(this));
        requestChain.addTaskToChain$permissionx_release(new RequestWriteSettingsPermission(this));
        requestChain.addTaskToChain$permissionx_release(new RequestManageExternalStoragePermission(this));
        requestChain.addTaskToChain$permissionx_release(new RequestInstallPackagesPermission(this));
        requestChain.addTaskToChain$permissionx_release(new RequestNotificationPermission(this));
        requestChain.addTaskToChain$permissionx_release(new RequestBodySensorsBackgroundPermission(this));
        requestChain.runTask$permissionx_release();
    }

    private final void removeInvisibleFragment() {
        Fragment fragmentFindFragmentByTag = getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (fragmentFindFragmentByTag != null) {
            getFragmentManager().beginTransaction().remove(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
        }
    }

    private final void restoreOrientation() {
        if (Build.VERSION.SDK_INT != 26) {
            getActivity().setRequestedOrientation(this.originRequestOrientation);
        }
    }

    private final void lockOrientation() {
        if (Build.VERSION.SDK_INT != 26) {
            this.originRequestOrientation = getActivity().getRequestedOrientation();
            int i = getActivity().getResources().getConfiguration().orientation;
            if (i == 1) {
                getActivity().setRequestedOrientation(7);
            } else {
                if (i != 2) {
                    return;
                }
                getActivity().setRequestedOrientation(6);
            }
        }
    }

    private final void forwardToSettings(List<String> permissions) {
        this.forwardPermissions.clear();
        this.forwardPermissions.addAll(permissions);
        getInvisibleFragment().forwardToSettings();
    }

    public final void endRequest$permissionx_release() {
        removeInvisibleFragment();
        restoreOrientation();
    }
}
