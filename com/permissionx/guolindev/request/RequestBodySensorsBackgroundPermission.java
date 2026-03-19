package com.permissionx.guolindev.request;

import android.os.Build;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.ExplainReasonCallback;
import com.permissionx.guolindev.callback.ExplainReasonCallbackWithBeforeParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestBodySensorsBackgroundPermission.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\f"}, d2 = {"Lcom/permissionx/guolindev/request/RequestBodySensorsBackgroundPermission;", "Lcom/permissionx/guolindev/request/BaseTask;", "permissionBuilder", "Lcom/permissionx/guolindev/request/PermissionBuilder;", "(Lcom/permissionx/guolindev/request/PermissionBuilder;)V", "request", "", "requestAgain", "permissions", "", "", "Companion", "permissionx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class RequestBodySensorsBackgroundPermission extends BaseTask {
    public static final String BODY_SENSORS_BACKGROUND = "android.permission.BODY_SENSORS_BACKGROUND";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestBodySensorsBackgroundPermission(PermissionBuilder permissionBuilder) {
        super(permissionBuilder);
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
    }

    @Override // com.permissionx.guolindev.request.ChainTask
    public void request() {
        if (this.pb.shouldRequestBodySensorsBackgroundPermission()) {
            if (Build.VERSION.SDK_INT < 33) {
                this.pb.specialPermissions.remove(BODY_SENSORS_BACKGROUND);
                this.pb.permissionsWontRequest.add(BODY_SENSORS_BACKGROUND);
                finish();
                return;
            }
            if (PermissionX.isGranted(this.pb.getActivity(), BODY_SENSORS_BACKGROUND)) {
                finish();
                return;
            }
            if (Build.VERSION.SDK_INT >= 20 ? PermissionX.isGranted(this.pb.getActivity(), "android.permission.BODY_SENSORS") : false) {
                if (this.pb.explainReasonCallback != null || this.pb.explainReasonCallbackWithBeforeParam != null) {
                    List<String> listMutableListOf = CollectionsKt.mutableListOf(new String[]{BODY_SENSORS_BACKGROUND});
                    if (this.pb.explainReasonCallbackWithBeforeParam != null) {
                        ExplainReasonCallbackWithBeforeParam explainReasonCallbackWithBeforeParam = this.pb.explainReasonCallbackWithBeforeParam;
                        Intrinsics.checkNotNull(explainReasonCallbackWithBeforeParam);
                        explainReasonCallbackWithBeforeParam.onExplainReason(getExplainReasonScope(), listMutableListOf, true);
                        return;
                    } else {
                        ExplainReasonCallback explainReasonCallback = this.pb.explainReasonCallback;
                        Intrinsics.checkNotNull(explainReasonCallback);
                        explainReasonCallback.onExplainReason(getExplainReasonScope(), listMutableListOf);
                        return;
                    }
                }
                requestAgain(CollectionsKt.emptyList());
                return;
            }
        }
        finish();
    }

    @Override // com.permissionx.guolindev.request.ChainTask
    public void requestAgain(List<String> permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.pb.requestBodySensorsBackgroundPermissionNow(this);
    }
}
