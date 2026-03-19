package com.bytedance.sdk.djx.core;

import com.bytedance.sdk.djx.DJXDramaLog;
import com.bytedance.sdk.djx.EMBaseSdk;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.core.api.ApiManager;
import com.bytedance.sdk.djx.core.api.log.ApiCallbackWrapper;
import com.bytedance.sdk.djx.core.api.req.ComboApi;
import com.bytedance.sdk.djx.core.api.req.DramaApi;
import com.bytedance.sdk.djx.core.api.req.FeedApi;
import com.bytedance.sdk.djx.core.api.req.PayApi;
import com.bytedance.sdk.djx.core.api.req.ProtocolApi;
import com.bytedance.sdk.djx.core.api.rsp.ComboRsp;
import com.bytedance.sdk.djx.core.api.rsp.DramaActionRsp;
import com.bytedance.sdk.djx.core.api.rsp.DramaFeedRsp;
import com.bytedance.sdk.djx.core.api.rsp.DramaParamsRsp;
import com.bytedance.sdk.djx.core.api.rsp.DramaRsp;
import com.bytedance.sdk.djx.core.api.rsp.OrderListRsp;
import com.bytedance.sdk.djx.core.api.rsp.ProtocolRsp;
import com.bytedance.sdk.djx.core.api.rsp.SignProtocolRsp;
import com.bytedance.sdk.djx.core.api.rsp.VipRsp;
import com.bytedance.sdk.djx.core.business.CooperationLog;
import com.bytedance.sdk.djx.core.business.SpeedPlayManager;
import com.bytedance.sdk.djx.core.business.bucustomapi.CustomApi;
import com.bytedance.sdk.djx.core.business.budrama.DramaManager;
import com.bytedance.sdk.djx.core.init.pay.PayInitHelper;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.DJXCombo;
import com.bytedance.sdk.djx.model.DJXDrama;
import com.bytedance.sdk.djx.model.DJXEpisodeStatus;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DJXLock;
import com.bytedance.sdk.djx.model.DJXOrder;
import com.bytedance.sdk.djx.model.DJXOthers;
import com.bytedance.sdk.djx.model.DJXProtocol;
import com.bytedance.sdk.djx.model.DJXRenewal;
import com.bytedance.sdk.djx.model.DJXUser;
import com.bytedance.sdk.djx.model.DJXVip;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.ev.BEDramaFavorAction;
import com.bytedance.sdk.djx.model.ev.BEDramaLikeAction;
import com.bytedance.sdk.djx.net.api.BaseRsp;
import com.bytedance.sdk.djx.net.api.ErrCode;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.bus.DJXBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXServiceProxy implements IDJXService {
    private static final String TAG = "DJXServiceProxy";

    @Override // com.bytedance.sdk.djx.IDJXService
    public String getSignString(String str, String str2, long j, Map<String, String> map) {
        return EMBaseSdk.service().getSignString(str, str2, j, map);
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void login(String str, IDJXService.IDJXCallback<DJXUser> iDJXCallback) {
        EMBaseSdk.service().login(str, iDJXCallback);
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public boolean isLogin() {
        return EMBaseSdk.service().isLogin();
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void logout(IDJXService.IDJXCallback<DJXUser> iDJXCallback) {
        EMBaseSdk.service().logout(iDJXCallback);
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void customizationCapability(Map<String, String> map, IDJXService.IDJXCallback<JSONObject> iDJXCallback) throws JSONException {
        CustomApi.request(map, iDJXCallback);
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void getPayProtocol(List<Integer> list, IDJXService.IDJXCallback<List<DJXProtocol>> iDJXCallback) {
        final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_PAY_AGREEMENT, iDJXCallback);
        ProtocolApi.getProtocol(list, new IApiCallback<ProtocolRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.1
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(ProtocolRsp protocolRsp) {
                DJXOthers dJXOthers = new DJXOthers();
                dJXOthers.requestId = protocolRsp.getRequestId();
                apiCallbackWrapperBuild.onSuccess(protocolRsp.getData(), dJXOthers);
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, ProtocolRsp protocolRsp) {
                apiCallbackWrapperBuild.onError(dJXError);
            }
        });
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void signedPayProtocol(final List<String> list, final IDJXService.IDJXCallback<Boolean> iDJXCallback) {
        final Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.2
            @Override // java.lang.Runnable
            public void run() {
                final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_SIGN_AGREEMENT, iDJXCallback);
                ProtocolApi.signedProtocol(list, new IApiCallback<SignProtocolRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.2.1
                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiSuccess(SignProtocolRsp signProtocolRsp) {
                        DJXOthers dJXOthers = new DJXOthers();
                        dJXOthers.requestId = signProtocolRsp.getRequestId();
                        apiCallbackWrapperBuild.onSuccess(true, dJXOthers);
                    }

                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiFailure(DJXError dJXError, SignProtocolRsp signProtocolRsp) {
                        apiCallbackWrapperBuild.onError(dJXError);
                    }
                });
            }
        };
        if (!TokenHelper.getInstance().isCustomLoginSuccess()) {
            DevInfo.sRouter.onLogin(new IDJXService.IDJXCallback<Boolean>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.3
                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onSuccess(Boolean bool, DJXOthers dJXOthers) {
                    runnable.run();
                }

                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onError(DJXError dJXError) {
                    iDJXCallback.onError(DJXError.build(-5, ErrCode.msg(-5)));
                }
            });
        } else {
            runnable.run();
        }
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void getCombos(final String str, final int i, final IDJXService.IDJXCallback<List<DJXCombo>> iDJXCallback) {
        final Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.4
            @Override // java.lang.Runnable
            public void run() {
                final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_COMBO, iDJXCallback);
                ComboApi.getCombos(str, i, new IApiCallback<ComboRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.4.1
                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiSuccess(ComboRsp comboRsp) {
                        DJXOthers dJXOthers = new DJXOthers();
                        dJXOthers.requestId = comboRsp.getRequestId();
                        dJXOthers.hasMore = comboRsp.isHasMore();
                        dJXOthers.total = comboRsp.getTotal();
                        apiCallbackWrapperBuild.onSuccess(comboRsp.getData(), dJXOthers);
                    }

                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiFailure(DJXError dJXError, ComboRsp comboRsp) {
                        apiCallbackWrapperBuild.onError(dJXError);
                    }
                });
            }
        };
        if (!TokenHelper.getInstance().isCustomLoginSuccess()) {
            DevInfo.sRouter.onLogin(new IDJXService.IDJXCallback<Boolean>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.5
                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onSuccess(Boolean bool, DJXOthers dJXOthers) {
                    runnable.run();
                }

                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onError(DJXError dJXError) {
                    iDJXCallback.onError(DJXError.build(-5, ErrCode.msg(-5)));
                }
            });
        } else {
            runnable.run();
        }
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void pay(String str, IDJXService.IDJXCallback<DJXOrder> iDJXCallback) {
        PayInitHelper.pay(str, iDJXCallback);
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void queryPayVips(final IDJXService.IDJXCallback<DJXVip> iDJXCallback) {
        final Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.6
            @Override // java.lang.Runnable
            public void run() {
                final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_MEMBER, iDJXCallback);
                PayApi.vip(new IApiCallback<VipRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.6.1
                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiSuccess(VipRsp vipRsp) {
                        DJXOthers dJXOthers = new DJXOthers();
                        dJXOthers.requestId = vipRsp.getRequestId();
                        apiCallbackWrapperBuild.onSuccess(vipRsp.getData(), dJXOthers);
                    }

                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiFailure(DJXError dJXError, VipRsp vipRsp) {
                        apiCallbackWrapperBuild.onError(dJXError);
                    }
                });
            }
        };
        if (!TokenHelper.getInstance().isCustomLoginSuccess()) {
            DevInfo.sRouter.onLogin(new IDJXService.IDJXCallback<Boolean>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.7
                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onSuccess(Boolean bool, DJXOthers dJXOthers) {
                    runnable.run();
                }

                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onError(DJXError dJXError) {
                    iDJXCallback.onError(DJXError.build(-5, ErrCode.msg(-5)));
                }
            });
        } else {
            runnable.run();
        }
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void queryPayDramas(final int i, final IDJXService.IDJXCallback<List<DJXDrama>> iDJXCallback) {
        final Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.8
            @Override // java.lang.Runnable
            public void run() {
                final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_PAY_DRAMA, iDJXCallback);
                PayApi.drama(i, new IApiCallback<DramaRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.8.1
                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiSuccess(DramaRsp dramaRsp) {
                        DJXOthers dJXOthers = new DJXOthers();
                        dJXOthers.requestId = dramaRsp.getRequestId();
                        dJXOthers.hasMore = dramaRsp.isHasMore();
                        dJXOthers.total = dramaRsp.getTotal();
                        apiCallbackWrapperBuild.onSuccess(new ArrayList(dramaRsp.getData()), dJXOthers);
                    }

                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiFailure(DJXError dJXError, DramaRsp dramaRsp) {
                        apiCallbackWrapperBuild.onError(dJXError);
                    }
                });
            }
        };
        if (!TokenHelper.getInstance().isCustomLoginSuccess()) {
            DevInfo.sRouter.onLogin(new IDJXService.IDJXCallback<Boolean>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.9
                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onSuccess(Boolean bool, DJXOthers dJXOthers) {
                    runnable.run();
                }

                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onError(DJXError dJXError) {
                    iDJXCallback.onError(DJXError.build(-5, ErrCode.msg(-5)));
                }
            });
        } else {
            runnable.run();
        }
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void queryPayOrders(final int i, final IDJXService.IDJXCallback<List<DJXOrder>> iDJXCallback) {
        final Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.10
            @Override // java.lang.Runnable
            public void run() {
                final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_PAY_ORDERS, iDJXCallback);
                PayApi.order(i, new IApiCallback<OrderListRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.10.1
                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiSuccess(OrderListRsp orderListRsp) {
                        DJXOthers dJXOthers = new DJXOthers();
                        dJXOthers.requestId = orderListRsp.getRequestId();
                        dJXOthers.hasMore = orderListRsp.isHasMore();
                        dJXOthers.total = orderListRsp.getTotal();
                        apiCallbackWrapperBuild.onSuccess(orderListRsp.getData(), dJXOthers);
                    }

                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiFailure(DJXError dJXError, OrderListRsp orderListRsp) {
                        apiCallbackWrapperBuild.onError(dJXError);
                    }
                });
            }
        };
        if (!TokenHelper.getInstance().isCustomLoginSuccess()) {
            DevInfo.sRouter.onLogin(new IDJXService.IDJXCallback<Boolean>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.11
                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onSuccess(Boolean bool, DJXOthers dJXOthers) {
                    runnable.run();
                }

                @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
                public void onError(DJXError dJXError) {
                    iDJXCallback.onError(DJXError.build(-5, ErrCode.msg(-5)));
                }
            });
        } else {
            runnable.run();
        }
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void cancelRenewal(long j, long j2, IDJXService.IDJXCallback<DJXRenewal> iDJXCallback) {
        PayInitHelper.cancelRenewal(j, j2, iDJXCallback);
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void getEpisodesStatus(long j, int i, IDJXService.IDJXCallback<List<DJXEpisodeStatus>> iDJXCallback) {
        final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_EPISODES, iDJXCallback);
        DramaApi.loadDramaDetail(j, 0, 0, i, null, new IApiCallback<DramaFeedRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.12
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaFeedRsp dramaFeedRsp) {
                DJXOthers dJXOthers = new DJXOthers();
                dJXOthers.requestId = dramaFeedRsp.getRequestId();
                apiCallbackWrapperBuild.onSuccess(dramaFeedRsp.getEpisodeStatusList(), dJXOthers);
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaFeedRsp dramaFeedRsp) {
                apiCallbackWrapperBuild.onError(dJXError);
            }
        });
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void likeEpisode(final long j, final int i, final boolean z, IDJXService.IDJXCallback<Object> iDJXCallback) {
        final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_DRAMA_LIKE, iDJXCallback);
        ApiManager.postLikeDrama(j, i, z, new IApiCallback<DramaActionRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.13
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaActionRsp dramaActionRsp) {
                DJXOthers dJXOthers = new DJXOthers();
                dJXOthers.requestId = dramaActionRsp.getRequestId();
                apiCallbackWrapperBuild.onSuccess(null, dJXOthers);
                DJXBus.getInstance().sendEvent(new BEDramaLikeAction(j, i, z));
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaActionRsp dramaActionRsp) {
                apiCallbackWrapperBuild.onError(dJXError);
            }
        });
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void favorDrama(final long j, int i, final boolean z, IDJXService.IDJXCallback<Object> iDJXCallback) {
        final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_DRAMA_FAV, iDJXCallback);
        ApiManager.postFavorDrama(j, i, z, new IApiCallback<DramaActionRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.14
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaActionRsp dramaActionRsp) {
                DJXOthers dJXOthers = new DJXOthers();
                dJXOthers.requestId = dramaActionRsp.getRequestId();
                apiCallbackWrapperBuild.onSuccess(null, dJXOthers);
                DJXBus.getInstance().sendEvent(new BEDramaFavorAction(j, z));
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaActionRsp dramaActionRsp) {
                apiCallbackWrapperBuild.onError(dJXError);
            }
        });
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void getFavorList(int i, int i2, IDJXService.IDJXCallback<List<? extends DJXDrama>> iDJXCallback) {
        final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_FAV_LIST, iDJXCallback);
        DramaApi.getStoryFavoriteList(i, i2, new IApiCallback<DramaRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.15
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaRsp dramaRsp) {
                List<Drama> data = dramaRsp.getData();
                DJXOthers dJXOthers = new DJXOthers();
                dJXOthers.requestId = dramaRsp.getRequestId();
                dJXOthers.hasMore = dramaRsp.isHasMore();
                dJXOthers.total = dramaRsp.getTotal();
                apiCallbackWrapperBuild.onSuccess(data, dJXOthers);
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaRsp dramaRsp) {
                apiCallbackWrapperBuild.onError(dJXError);
            }
        });
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void setGlobalSpeedPlay(float f) {
        SpeedPlayManager.setGlobalSpeed(f);
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void verifyDramaParams(int i, int i2, int i3, IDJXService.IDJXCallback<DJXLock> iDJXCallback) {
        final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_VERIFY_DRAMA_PARAM, iDJXCallback);
        DramaApi.verifyDramaParams(i, i2, i3, new IApiCallback<DramaParamsRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.16
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaParamsRsp dramaParamsRsp) {
                DJXOthers dJXOthers = new DJXOthers();
                dJXOthers.requestId = dramaParamsRsp.getRequestId();
                apiCallbackWrapperBuild.onSuccess(dramaParamsRsp.getData(), dJXOthers);
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaParamsRsp dramaParamsRsp) {
                apiCallbackWrapperBuild.onError(dJXError);
            }
        });
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void requestAllDramaByRecommend(int i, int i2, IDJXService.IDJXCallback<List<? extends DJXDrama>> iDJXCallback) {
        if (iDJXCallback == null) {
            LG.d(TAG, "callback is null");
        } else {
            final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_DRAMA_BY_REC, iDJXCallback);
            DramaApi.loadDramaAllList(1, null, i, i2, 2, new IApiCallback<DramaRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.17
                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiSuccess(DramaRsp dramaRsp) {
                    List<Drama> data = dramaRsp.getData();
                    DJXOthers dJXOthers = new DJXOthers();
                    dJXOthers.requestId = dramaRsp.getRequestId();
                    dJXOthers.hasMore = dramaRsp.isHasMore();
                    dJXOthers.total = dramaRsp.getTotal();
                    apiCallbackWrapperBuild.onSuccess(data, dJXOthers);
                }

                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiFailure(DJXError dJXError, DramaRsp dramaRsp) {
                    apiCallbackWrapperBuild.onError(dJXError);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void requestAllDrama(int i, int i2, boolean z, IDJXService.IDJXCallback<List<? extends DJXDrama>> iDJXCallback) {
        if (iDJXCallback == null) {
            LG.d(TAG, "callback is null");
        } else {
            final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_DRAMA_BY_ALL, iDJXCallback);
            DramaApi.loadDramaAllList(1, null, i, i2, !z ? 1 : 0, new IApiCallback<DramaRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.18
                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiSuccess(DramaRsp dramaRsp) {
                    List<Drama> data = dramaRsp.getData();
                    DJXOthers dJXOthers = new DJXOthers();
                    dJXOthers.requestId = dramaRsp.getRequestId();
                    dJXOthers.hasMore = dramaRsp.isHasMore();
                    dJXOthers.total = dramaRsp.getTotal();
                    apiCallbackWrapperBuild.onSuccess(data, dJXOthers);
                }

                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiFailure(DJXError dJXError, DramaRsp dramaRsp) {
                    apiCallbackWrapperBuild.onError(dJXError);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void requestDrama(List<Long> list, IDJXService.IDJXCallback<List<? extends DJXDrama>> iDJXCallback) {
        if (iDJXCallback == null) {
            LG.d(TAG, "callback is null");
            return;
        }
        final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_DRAMA_BY_IDS, iDJXCallback);
        StringBuilder sb = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                sb.append(",").append(it.next());
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(0);
            }
        }
        DramaApi.loadDramaAllList(0, sb.toString(), 0, 0, 0, new IApiCallback<DramaRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.19
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaRsp dramaRsp) {
                List<Drama> data = dramaRsp.getData();
                DJXOthers dJXOthers = new DJXOthers();
                dJXOthers.requestId = dramaRsp.getRequestId();
                dJXOthers.hasMore = dramaRsp.isHasMore();
                dJXOthers.total = dramaRsp.getTotal();
                apiCallbackWrapperBuild.onSuccess(data, dJXOthers);
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaRsp dramaRsp) {
                apiCallbackWrapperBuild.onError(dJXError);
            }
        });
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void requestDramaByCategory(String str, int i, int i2, int i3, IDJXService.IDJXCallback<List<? extends DJXDrama>> iDJXCallback) {
        if (iDJXCallback == null) {
            LG.d(TAG, "callback is null");
        } else {
            final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_DRAMA_BY_CATE, iDJXCallback);
            DramaApi.loadDramaListByCategory(str, i, i2, i3, new IApiCallback<DramaRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.20
                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiSuccess(DramaRsp dramaRsp) {
                    List<Drama> data = dramaRsp.getData();
                    DJXOthers dJXOthers = new DJXOthers();
                    dJXOthers.requestId = dramaRsp.getRequestId();
                    dJXOthers.hasMore = dramaRsp.isHasMore();
                    dJXOthers.total = dramaRsp.getTotal();
                    apiCallbackWrapperBuild.onSuccess(data, dJXOthers);
                }

                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiFailure(DJXError dJXError, DramaRsp dramaRsp) {
                    apiCallbackWrapperBuild.onError(dJXError);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void requestDramaCategoryList(IDJXService.IDJXCallback<List<String>> iDJXCallback) {
        if (iDJXCallback == null) {
            LG.d(TAG, "callback is null");
        } else {
            final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_CATE_LIST, iDJXCallback);
            DramaApi.loadDramaCategoryList(new IApiCallback<BaseRsp<List<String>>>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.21
                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiSuccess(BaseRsp<List<String>> baseRsp) {
                    List<String> data = baseRsp.getData();
                    DJXOthers dJXOthers = new DJXOthers();
                    dJXOthers.requestId = baseRsp.getRequestId();
                    apiCallbackWrapperBuild.onSuccess(data, dJXOthers);
                }

                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiFailure(DJXError dJXError, BaseRsp<List<String>> baseRsp) {
                    apiCallbackWrapperBuild.onError(dJXError);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void searchDrama(String str, boolean z, int i, int i2, IDJXService.IDJXCallback<List<? extends DJXDrama>> iDJXCallback) {
        if (iDJXCallback == null) {
            LG.d(TAG, "callback is null");
        } else {
            final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_DRAMA_BY_SEARCH, iDJXCallback);
            DramaApi.searchDrama(str, z, i, i2, new IApiCallback<DramaRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.22
                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiSuccess(DramaRsp dramaRsp) {
                    List<Drama> data = dramaRsp.getData();
                    DJXOthers dJXOthers = new DJXOthers();
                    dJXOthers.requestId = dramaRsp.getRequestId();
                    dJXOthers.hasMore = dramaRsp.isHasMore();
                    dJXOthers.total = dramaRsp.getTotal();
                    apiCallbackWrapperBuild.onSuccess(data, dJXOthers);
                }

                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiFailure(DJXError dJXError, DramaRsp dramaRsp) {
                    apiCallbackWrapperBuild.onError(dJXError);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void getDramaHistory(int i, int i2, IDJXService.IDJXCallback<List<? extends DJXDrama>> iDJXCallback) {
        if (iDJXCallback == null) {
            LG.d(TAG, "callback is null");
        } else {
            final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_DRAMA_BY_HISTORY, iDJXCallback);
            DramaApi.loadDramaHistory(i, i2, new IApiCallback<DramaRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.23
                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiSuccess(DramaRsp dramaRsp) {
                    List<Drama> data = dramaRsp.getData();
                    DJXOthers dJXOthers = new DJXOthers();
                    dJXOthers.requestId = dramaRsp.getRequestId();
                    dJXOthers.hasMore = dramaRsp.isHasMore();
                    dJXOthers.total = dramaRsp.getTotal();
                    apiCallbackWrapperBuild.onSuccess(data, dJXOthers);
                }

                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiFailure(DJXError dJXError, DramaRsp dramaRsp) {
                    apiCallbackWrapperBuild.onError(dJXError);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void uploadDramaHomeLog(DJXDramaLog dJXDramaLog) {
        LG.d(TAG, "uploadDramaLog: hotsoon_video, event = " + dJXDramaLog.getEvent() + ", drama = " + dJXDramaLog.getDrama());
        CooperationLog.getInstance().uploadDramaLog(FeedApi.CATEGORY_GRID, dJXDramaLog);
    }

    @Override // com.bytedance.sdk.djx.IDJXService
    public void clearDramaHistory(IDJXService.IDJXCallback<List<? extends DJXDrama>> iDJXCallback) {
        final ApiCallbackWrapper apiCallbackWrapperBuild = ApiCallbackWrapper.build(ILogConst.E_SERVICE_REQ_CLEAR_DRAMA_HISTORY, iDJXCallback);
        DramaApi.clearDramaHistory(new IApiCallback<DramaActionRsp>() { // from class: com.bytedance.sdk.djx.core.DJXServiceProxy.24
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaActionRsp dramaActionRsp) throws JSONException {
                DramaManager.getInstance().clearAllHistory();
                DJXOthers dJXOthers = new DJXOthers();
                dJXOthers.requestId = dramaActionRsp.getRequestId();
                apiCallbackWrapperBuild.onSuccess(null, dJXOthers);
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaActionRsp dramaActionRsp) {
                apiCallbackWrapperBuild.onError(dJXError);
            }
        });
    }
}
