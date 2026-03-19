package com.bytedance.sdk.djx.net.api;

import com.bytedance.sdk.commonsdk.api.model.CommonError;
import com.bytedance.sdk.djx.net.ICommonApiCallback;
import com.bytedance.sdk.djx.net.token.TokenApiConfigUtils;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class TokenAccessError {
    private static final AtomicInteger sCount = new AtomicInteger(0);
    private static final AtomicBoolean sLoading = new AtomicBoolean(false);

    private TokenAccessError() {
    }

    public static void valid(int i) {
        if (i != 5) {
            return;
        }
        AtomicBoolean atomicBoolean = sLoading;
        if (atomicBoolean.get()) {
            return;
        }
        AtomicInteger atomicInteger = sCount;
        if (atomicInteger.get() > 9) {
            return;
        }
        atomicInteger.incrementAndGet();
        atomicBoolean.set(true);
        TokenApi.register(null, TokenApiConfigUtils.buildTokenApiConfig(), new ICommonApiCallback<TokenRsp>() { // from class: com.bytedance.sdk.djx.net.api.TokenAccessError.1
            @Override // com.bytedance.sdk.djx.net.ICommonApiCallback
            public void onApiSuccess(TokenRsp tokenRsp) {
                TokenAccessError.sLoading.set(false);
                TokenHelper.getInstance().saveToken(tokenRsp);
            }

            @Override // com.bytedance.sdk.djx.net.ICommonApiCallback
            public void onApiFailure(CommonError commonError, TokenRsp tokenRsp) {
                TokenAccessError.sLoading.set(false);
            }
        });
    }
}
