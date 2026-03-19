package com.bytedance.sdk.djx.net.token;

import com.bytedance.sdk.commonsdk.api.model.CommonError;
import com.bytedance.sdk.commonsdk.api.model.CommonUser;
import com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService;
import com.bytedance.sdk.commonsdk.api.utils.CommonSdkUtils;
import com.bytedance.sdk.djx.IDJXRecSwitchCallback;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.impl.DJXSdkStartHelper;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DJXOthers;
import com.bytedance.sdk.djx.model.DJXUser;
import com.bytedance.sdk.djx.model.ev.BEBDDidCome;
import com.bytedance.sdk.djx.model.ev.BERecommendSwitch;
import com.bytedance.sdk.djx.model.ev.BETokenUpdate;
import com.bytedance.sdk.djx.net.NetClient;
import com.bytedance.sdk.djx.net.api.BaseRsp;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.api.TokenApiConfig;
import com.bytedance.sdk.djx.net.api.TokenRsp;
import com.bytedance.sdk.djx.net.api.UserApi;
import com.bytedance.sdk.djx.utils.CommonConvertDjxUtils;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.bus.BusEvent;
import com.bytedance.sdk.djx.utils.bus.DJXBus;
import com.bytedance.sdk.djx.utils.bus.IBusListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class TokenHelper {
    private static final String TAG = "TokenHelper";
    public static final boolean sHasSyncMark = getTokenService().isHasSyncMark();
    private static volatile TokenHelper sInstance;

    public static TokenHelper getInstance() {
        if (sInstance == null) {
            synchronized (TokenHelper.class) {
                if (sInstance == null) {
                    sInstance = new TokenHelper();
                }
            }
        }
        return sInstance;
    }

    private TokenHelper() {
    }

    public void init(OnTokenResultListener onTokenResultListener) {
        TokenCallbackLog<CommonUser> tokenCallbackLogBuild = TokenCallbackLog.build(null);
        getTokenService().init(TokenApiConfigUtils.buildTokenApiConfig(), getTokenApiRegisterCallback(TokenApiConfigUtils.buildTokenApiConfig(), tokenCallbackLogBuild), onTokenResultListener);
    }

    public boolean isCustomLoginSuccess() {
        return getTokenService().isCustomLoginSuccess();
    }

    public void update(String str, IDJXService.IDJXCallback<DJXUser> iDJXCallback) {
        updateInternal(str, TokenApiConfigUtils.buildTokenApiConfig(), dJXUserCallbackConvertCommonUser(iDJXCallback));
    }

    private IDJXService.IDJXCallback<CommonUser> dJXUserCallbackConvertCommonUser(final IDJXService.IDJXCallback<DJXUser> iDJXCallback) {
        return new IDJXService.IDJXCallback<CommonUser>() { // from class: com.bytedance.sdk.djx.net.token.TokenHelper.1
            @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
            public void onSuccess(CommonUser commonUser, DJXOthers dJXOthers) {
                IDJXService.IDJXCallback iDJXCallback2 = iDJXCallback;
                if (iDJXCallback2 != null) {
                    iDJXCallback2.onSuccess(CommonConvertDjxUtils.commonErrorConvertDJXUser(commonUser), dJXOthers);
                }
            }

            @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
            public void onError(DJXError dJXError) {
                IDJXService.IDJXCallback iDJXCallback2 = iDJXCallback;
                if (iDJXCallback2 != null) {
                    iDJXCallback2.onError(dJXError);
                }
            }
        };
    }

    public void update() {
        updateInternal(null, TokenApiConfigUtils.buildTokenApiConfig(), null);
    }

    private void updateInternal(String str, TokenApiConfig tokenApiConfig, IDJXService.IDJXCallback<CommonUser> iDJXCallback) {
        getTokenService().update(str, tokenApiConfig, iDJXCallback == null, getTokenApiRegisterCallback(tokenApiConfig, TokenCallbackLog.build(iDJXCallback)));
    }

    /* renamed from: com.bytedance.sdk.djx.net.token.TokenHelper$2, reason: invalid class name */
    class AnonymousClass2 implements TokenApiRegisterCallback {
        final /* synthetic */ TokenCallbackLog val$callbackWrap;
        final /* synthetic */ TokenApiConfig val$tokenApiConfig;

        AnonymousClass2(TokenCallbackLog tokenCallbackLog, TokenApiConfig tokenApiConfig) {
            this.val$callbackWrap = tokenCallbackLog;
            this.val$tokenApiConfig = tokenApiConfig;
        }

        @Override // com.bytedance.sdk.djx.net.token.TokenApiRegisterCallback
        public void onApiSuccess(TokenRsp tokenRsp, CommonUser commonUser, boolean z) {
            if (z) {
                this.val$callbackWrap.reSetCallback();
            }
            this.val$callbackWrap.onSuccess(commonUser, new DJXOthers().setRequestId(tokenRsp.getRequestId()));
            BETokenUpdate.build().sendOnThread();
        }

        @Override // com.bytedance.sdk.djx.net.token.TokenApiRegisterCallback
        public void onApiFailure(CommonError commonError, TokenRsp tokenRsp, boolean z) {
            if (z) {
                this.val$callbackWrap.reSetCallback();
            }
            this.val$callbackWrap.onError(commonError);
        }

        @Override // com.bytedance.sdk.djx.net.token.TokenApiRegisterCallback
        public void onApiFailureWhenDidDegrade(CommonError commonError, TokenRsp tokenRsp) {
            if (NetClient.getInstance().getInject() != null) {
                NetClient.getInstance().getInject().setErrCode11();
            }
        }

        @Override // com.bytedance.sdk.djx.net.token.TokenApiRegisterCallback
        public void eventBusAddListener() {
            DJXBus dJXBus = DJXBus.getInstance();
            final TokenApiConfig tokenApiConfig = this.val$tokenApiConfig;
            dJXBus.addListener(new IBusListener() { // from class: com.bytedance.sdk.djx.net.token.TokenHelper$2$$ExternalSyntheticLambda0
                public final void onBusEvent(BusEvent busEvent) {
                    this.f$0.m369x61ac62af(tokenApiConfig, busEvent);
                }
            });
        }

        /* renamed from: lambda$eventBusAddListener$0$com-bytedance-sdk-djx-net-token-TokenHelper$2, reason: not valid java name */
        /* synthetic */ void m369x61ac62af(TokenApiConfig tokenApiConfig, BusEvent busEvent) {
            if (busEvent instanceof BEBDDidCome) {
                TokenHelper.getTokenService().handleBEBDDidComeEvent(tokenApiConfig, this);
            }
        }
    }

    private TokenApiRegisterCallback getTokenApiRegisterCallback(TokenApiConfig tokenApiConfig, TokenCallbackLog<CommonUser> tokenCallbackLog) {
        return new AnonymousClass2(tokenCallbackLog, tokenApiConfig);
    }

    public void saveToken(TokenRsp tokenRsp) {
        getTokenService().saveToken(tokenRsp);
    }

    public String getToken() {
        return getTokenService().getToken();
    }

    public String getUserId() {
        return getTokenService().getUserId();
    }

    public String getUtUid() {
        return getTokenService().getUtUid();
    }

    public int getUserType() {
        return getTokenService().getUserType();
    }

    public String getUserMeta() {
        return getTokenService().getUserMeta();
    }

    public boolean getRecommendSwitch() {
        return getTokenService().getRecommendSwitch();
    }

    public boolean isGetTokenFromServer() {
        return getTokenService().isGetTokenFromServer();
    }

    public void setRecommendSwitch(final boolean z, final IDJXRecSwitchCallback iDJXRecSwitchCallback) {
        UserApi.reportUserConfig(z, new IApiCallback<BaseRsp<Object>>() { // from class: com.bytedance.sdk.djx.net.token.TokenHelper.3
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(BaseRsp<Object> baseRsp) {
                TokenHelper.getTokenService().setRecommendSwitch(z);
                DJXBus.getInstance().sendEvent(new BERecommendSwitch());
                IDJXRecSwitchCallback iDJXRecSwitchCallback2 = iDJXRecSwitchCallback;
                if (iDJXRecSwitchCallback2 != null) {
                    iDJXRecSwitchCallback2.onResult(true, -1, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, BaseRsp<Object> baseRsp) {
                IDJXRecSwitchCallback iDJXRecSwitchCallback2 = iDJXRecSwitchCallback;
                if (iDJXRecSwitchCallback2 != null) {
                    iDJXRecSwitchCallback2.onResult(false, dJXError.code, dJXError.msg);
                }
                LG.w(TokenHelper.TAG, "reportUserConfig: onApiFailure, code = " + dJXError);
            }
        });
    }

    public boolean isSyncHistory() {
        return getTokenService().isSyncHistory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ICommonSdkTokenService getTokenService() {
        return CommonSdkUtils.getTokenService(DJXSdkStartHelper.getInstance().getDJXSdkClassLoader());
    }
}
