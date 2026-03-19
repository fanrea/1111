package com.sigmob.sdk.base.mta;

import com.czhj.sdk.common.mta.DeviceContext;
import com.sigmob.sdk.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class PointEntitySigmobError extends PointEntitySigmob {
    private String a;

    public static PointEntitySigmobError SigmobError(String category, int errorCode, String errorMessage) {
        PointEntitySigmobError pointEntitySigmobError = new PointEntitySigmobError();
        pointEntitySigmobError.setAc_type("9");
        pointEntitySigmobError.setCategory(category);
        pointEntitySigmobError.setError_code(String.valueOf(errorCode));
        pointEntitySigmobError.setError_message(errorMessage);
        return pointEntitySigmobError;
    }

    @Override // com.sigmob.sdk.base.mta.PointEnitySigmobBase
    public DeviceContext getDeviceContext() {
        return b.b();
    }

    @Override // com.sigmob.sdk.base.mta.PointEntitySigmob
    public String getError_message() {
        return this.a;
    }

    @Override // com.sigmob.sdk.base.mta.PointEntitySigmob
    public void setError_message(String error_message) {
        this.a = error_message;
    }
}
