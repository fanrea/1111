package com.bytedance.sdk.djx.core.impl;

import android.text.TextUtils;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.IEMBaseService;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DJXUser;
import com.bytedance.sdk.djx.net.api.ErrCode;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.utils.PayEncrypt;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class EMBSImpl implements IEMBaseService {
    public static EMBSImpl getInstance() {
        return InnerHolder.instance;
    }

    private EMBSImpl() {
    }

    @Override // com.bytedance.sdk.djx.IEMBaseService
    public String getSignString(String str, String str2, long j, Map<String, String> map) {
        return PayEncrypt.paySign(str, j, str2, map);
    }

    @Override // com.bytedance.sdk.djx.IEMBaseService
    public void login(String str, IDJXService.IDJXCallback<DJXUser> iDJXCallback) {
        if (TextUtils.isEmpty(str)) {
            iDJXCallback.onError(DJXError.build(-2, ErrCode.msg(-2)));
        } else {
            TokenHelper.getInstance().update(str, iDJXCallback);
        }
    }

    @Override // com.bytedance.sdk.djx.IEMBaseService
    public boolean isLogin() {
        return TokenHelper.getInstance().isCustomLoginSuccess();
    }

    @Override // com.bytedance.sdk.djx.IEMBaseService
    public void logout(IDJXService.IDJXCallback<DJXUser> iDJXCallback) {
        TokenHelper.getInstance().update(null, iDJXCallback);
    }

    private static class InnerHolder {
        private static final EMBSImpl instance = new EMBSImpl();

        private InnerHolder() {
        }
    }
}
