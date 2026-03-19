package com.permissionx.guolindev.request;

import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.RequestCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseTask.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/permissionx/guolindev/request/BaseTask;", "Lcom/permissionx/guolindev/request/ChainTask;", "pb", "Lcom/permissionx/guolindev/request/PermissionBuilder;", "(Lcom/permissionx/guolindev/request/PermissionBuilder;)V", "explainReasonScope", "Lcom/permissionx/guolindev/request/ExplainScope;", "forwardToSettingsScope", "Lcom/permissionx/guolindev/request/ForwardScope;", "next", "finish", "", "getExplainScope", "getForwardScope", "permissionx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class BaseTask implements ChainTask {
    private ExplainScope explainReasonScope;
    private ForwardScope forwardToSettingsScope;
    public ChainTask next;
    public PermissionBuilder pb;

    public BaseTask(PermissionBuilder permissionBuilder) {
        Intrinsics.checkNotNullParameter(permissionBuilder, "pb");
        this.pb = permissionBuilder;
        BaseTask baseTask = this;
        this.explainReasonScope = new ExplainScope(this.pb, baseTask);
        this.forwardToSettingsScope = new ForwardScope(this.pb, baseTask);
        this.explainReasonScope = new ExplainScope(this.pb, baseTask);
        this.forwardToSettingsScope = new ForwardScope(this.pb, baseTask);
    }

    @Override // com.permissionx.guolindev.request.ChainTask
    /* renamed from: getExplainScope, reason: from getter */
    public ExplainScope getExplainReasonScope() {
        return this.explainReasonScope;
    }

    @Override // com.permissionx.guolindev.request.ChainTask
    /* renamed from: getForwardScope, reason: from getter */
    public ForwardScope getForwardToSettingsScope() {
        return this.forwardToSettingsScope;
    }

    @Override // com.permissionx.guolindev.request.ChainTask
    public void finish() {
        Unit unit;
        ChainTask chainTask = this.next;
        if (chainTask != null) {
            chainTask.request();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.pb.deniedPermissions);
            arrayList.addAll(this.pb.permanentDeniedPermissions);
            arrayList.addAll(this.pb.permissionsWontRequest);
            if (this.pb.shouldRequestBackgroundLocationPermission()) {
                if (PermissionX.isGranted(this.pb.getActivity(), RequestBackgroundLocationPermission.ACCESS_BACKGROUND_LOCATION)) {
                    this.pb.grantedPermissions.add(RequestBackgroundLocationPermission.ACCESS_BACKGROUND_LOCATION);
                } else {
                    arrayList.add(RequestBackgroundLocationPermission.ACCESS_BACKGROUND_LOCATION);
                }
            }
            if (this.pb.shouldRequestSystemAlertWindowPermission() && Build.VERSION.SDK_INT >= 23 && this.pb.getTargetSdkVersion() >= 23) {
                if (Settings.canDrawOverlays(this.pb.getActivity())) {
                    this.pb.grantedPermissions.add("android.permission.SYSTEM_ALERT_WINDOW");
                } else {
                    arrayList.add("android.permission.SYSTEM_ALERT_WINDOW");
                }
            }
            if (this.pb.shouldRequestWriteSettingsPermission() && Build.VERSION.SDK_INT >= 23 && this.pb.getTargetSdkVersion() >= 23) {
                if (Settings.System.canWrite(this.pb.getActivity())) {
                    this.pb.grantedPermissions.add("android.permission.WRITE_SETTINGS");
                } else {
                    arrayList.add("android.permission.WRITE_SETTINGS");
                }
            }
            if (this.pb.shouldRequestManageExternalStoragePermission()) {
                if (Build.VERSION.SDK_INT >= 30 && Environment.isExternalStorageManager()) {
                    this.pb.grantedPermissions.add(RequestManageExternalStoragePermission.MANAGE_EXTERNAL_STORAGE);
                } else {
                    arrayList.add(RequestManageExternalStoragePermission.MANAGE_EXTERNAL_STORAGE);
                }
            }
            if (this.pb.shouldRequestInstallPackagesPermission()) {
                if (Build.VERSION.SDK_INT >= 26 && this.pb.getTargetSdkVersion() >= 26 && this.pb.getActivity().getPackageManager().canRequestPackageInstalls()) {
                    this.pb.grantedPermissions.add(RequestInstallPackagesPermission.REQUEST_INSTALL_PACKAGES);
                } else {
                    arrayList.add(RequestInstallPackagesPermission.REQUEST_INSTALL_PACKAGES);
                }
            }
            if (this.pb.shouldRequestNotificationPermission()) {
                if (PermissionX.areNotificationsEnabled(this.pb.getActivity())) {
                    this.pb.grantedPermissions.add(PermissionX.permission.POST_NOTIFICATIONS);
                } else {
                    arrayList.add(PermissionX.permission.POST_NOTIFICATIONS);
                }
            }
            if (this.pb.shouldRequestBodySensorsBackgroundPermission()) {
                if (PermissionX.isGranted(this.pb.getActivity(), RequestBodySensorsBackgroundPermission.BODY_SENSORS_BACKGROUND)) {
                    this.pb.grantedPermissions.add(RequestBodySensorsBackgroundPermission.BODY_SENSORS_BACKGROUND);
                } else {
                    arrayList.add(RequestBodySensorsBackgroundPermission.BODY_SENSORS_BACKGROUND);
                }
            }
            if (this.pb.requestCallback != null) {
                RequestCallback requestCallback = this.pb.requestCallback;
                Intrinsics.checkNotNull(requestCallback);
                requestCallback.onResult(arrayList.isEmpty(), new ArrayList(this.pb.grantedPermissions), arrayList);
            }
            this.pb.endRequest$permissionx_release();
        }
    }
}
