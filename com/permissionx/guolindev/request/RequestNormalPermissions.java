package com.permissionx.guolindev.request;

import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.ExplainReasonCallback;
import com.permissionx.guolindev.callback.ExplainReasonCallbackWithBeforeParam;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestNormalPermissions.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/permissionx/guolindev/request/RequestNormalPermissions;", "Lcom/permissionx/guolindev/request/BaseTask;", "permissionBuilder", "Lcom/permissionx/guolindev/request/PermissionBuilder;", "(Lcom/permissionx/guolindev/request/PermissionBuilder;)V", "request", "", "requestAgain", "permissions", "", "", "permissionx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class RequestNormalPermissions extends BaseTask {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestNormalPermissions(PermissionBuilder permissionBuilder) {
        super(permissionBuilder);
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
    }

    @Override // com.permissionx.guolindev.request.ChainTask
    public void request() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.pb.normalPermissions) {
            if (PermissionX.isGranted(this.pb.getActivity(), str)) {
                this.pb.grantedPermissions.add(str);
            } else {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            finish();
            return;
        }
        if (this.pb.explainReasonBeforeRequest && (this.pb.explainReasonCallback != null || this.pb.explainReasonCallbackWithBeforeParam != null)) {
            this.pb.explainReasonBeforeRequest = false;
            this.pb.deniedPermissions.addAll(arrayList);
            if (this.pb.explainReasonCallbackWithBeforeParam != null) {
                ExplainReasonCallbackWithBeforeParam explainReasonCallbackWithBeforeParam = this.pb.explainReasonCallbackWithBeforeParam;
                Intrinsics.checkNotNull(explainReasonCallbackWithBeforeParam);
                explainReasonCallbackWithBeforeParam.onExplainReason(getExplainReasonScope(), arrayList, true);
                return;
            } else {
                ExplainReasonCallback explainReasonCallback = this.pb.explainReasonCallback;
                Intrinsics.checkNotNull(explainReasonCallback);
                explainReasonCallback.onExplainReason(getExplainReasonScope(), arrayList);
                return;
            }
        }
        this.pb.requestNow(this.pb.normalPermissions, this);
    }

    @Override // com.permissionx.guolindev.request.ChainTask
    public void requestAgain(List<String> permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        HashSet hashSet = new HashSet(this.pb.grantedPermissions);
        hashSet.addAll(permissions);
        if (!hashSet.isEmpty()) {
            this.pb.requestNow(hashSet, this);
        } else {
            finish();
        }
    }
}
