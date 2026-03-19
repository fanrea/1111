package com.bytedance.sdk.djx.core.api.req;

import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.bytedance.sdk.djx.core.api.rsp.DramaRsp;
import com.bytedance.sdk.djx.core.api.rsp.OrderListRsp;
import com.bytedance.sdk.djx.core.api.rsp.VipRsp;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DJXOrder;
import com.bytedance.sdk.djx.model.DJXVip;
import com.bytedance.sdk.djx.net.ApiConstants;
import com.bytedance.sdk.djx.net.NetClient;
import com.bytedance.sdk.djx.net.api.ErrCode;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.cb.NetCallback;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import com.bytedance.sdk.djx.net.req.NetResponse;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.NetUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class PayApi {
    private static final String TAG = "PayApi";
    private static final String URL_VIP = ApiConstants.getHostWithPath() + "/user/member_right";
    private static final String URL_DRAMA = ApiConstants.getHostWithPath() + "/user/shortplay_right";
    private static final String URL_ORDER = ApiConstants.getHostWithPath() + "/user/order_list";

    public static void vip(final IApiCallback<VipRsp> iApiCallback) {
        NetClient.post().url(URL_VIP).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(NetClient.getCommonParams()).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.PayApi.1
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i, String str, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i, str);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    VipRsp vip = PayApi.parseVip(JSON.build(netResponse.data));
                    if (vip.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(vip);
                        }
                    } else if (iApiCallback != null) {
                        DJXError dJXError = vip.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, vip);
                    }
                } catch (Throwable th) {
                    LG.e(PayApi.TAG, "callback error", th);
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    public static VipRsp parseVip(JSONObject jSONObject) {
        VipRsp vipRsp = new VipRsp();
        vipRsp.parseComm(jSONObject);
        JSONObject jsonObject = JSON.getJsonObject(jSONObject, "data");
        DJXVip dJXVip = new DJXVip();
        dJXVip.isVip = JSON.getBoolean(jsonObject, "is_member");
        dJXVip.startTime = JSON.getLong(jsonObject, MetricsSQLiteCacheKt.METRICS_START_TIME);
        dJXVip.endTime = JSON.getLong(jsonObject, MetricsSQLiteCacheKt.METRICS_END_TIME);
        dJXVip.renewalStatus = JSON.getInt(jsonObject, "agreement_status");
        dJXVip.nextRenewalTime = JSON.getLong(jsonObject, "next_withhold_time");
        dJXVip.comboName = JSON.getString(jsonObject, "combo_name");
        dJXVip.renewalId = JSON.getLong(jsonObject, "agreement_id");
        vipRsp.setData(dJXVip);
        return vipRsp;
    }

    public static void drama(int i, final IApiCallback<DramaRsp> iApiCallback) {
        NetClient.post().url(URL_DRAMA).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(NetClient.getCommonParams()).addParam("page", String.valueOf(i)).addParam("num", "20").go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.PayApi.2
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i2, String str, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i2, str);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    DramaRsp dramaRsp = DramaApi.parseDramaRsp(JSON.build(netResponse.data));
                    if (dramaRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaRsp);
                            return;
                        }
                        return;
                    }
                    int code = dramaRsp.getCode();
                    if (TextUtils.isEmpty(dramaRsp.getMsg())) {
                        ErrCode.msg(code);
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaRsp);
                    }
                } catch (Throwable th) {
                    LG.e(PayApi.TAG, "callback error", th);
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    public static void order(int i, final IApiCallback<OrderListRsp> iApiCallback) {
        NetClient.post().url(URL_ORDER).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(NetClient.getCommonParams()).addParam("page", String.valueOf(i)).addParam("num", "20").go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.PayApi.3
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i2, String str, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i2, str);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    OrderListRsp orderList = PayApi.parseOrderList(JSON.build(netResponse.data));
                    if (orderList.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(orderList);
                        }
                    } else if (iApiCallback != null) {
                        DJXError dJXError = orderList.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, orderList);
                    }
                } catch (Throwable th) {
                    LG.e(PayApi.TAG, "callback error", th);
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OrderListRsp parseOrderList(JSONObject jSONObject) {
        OrderListRsp orderListRsp = new OrderListRsp();
        orderListRsp.parseComm(jSONObject);
        JSONObject jsonObject = JSON.getJsonObject(jSONObject, "data");
        orderListRsp.setHasMore(JSON.getBoolean(jsonObject, "has_more"));
        orderListRsp.setTotal(JSON.getInt(jsonObject, Config.EXCEPTION_MEMORY_TOTAL));
        ArrayList arrayList = new ArrayList();
        JSONArray jsonArray = JSON.getJsonArray(jsonObject, "list");
        if (jsonArray != null) {
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jsonArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    DJXOrder dJXOrder = new DJXOrder();
                    dJXOrder.orderId = JSON.getString(jSONObjectOptJSONObject, b.B0);
                    dJXOrder.status = JSON.getInt(jSONObjectOptJSONObject, "trade_status");
                    dJXOrder.name = JSON.getString(jSONObjectOptJSONObject, "trade_name");
                    dJXOrder.desc = JSON.getString(jSONObjectOptJSONObject, "trade_desc");
                    dJXOrder.time = JSON.getLong(jSONObjectOptJSONObject, "trade_time");
                    dJXOrder.combo = ComboApi.parseCombo(JSON.getJsonObject(jSONObjectOptJSONObject, "combo"));
                    dJXOrder.drama = DramaApi.parseDrama(JSON.getJsonObject(jSONObjectOptJSONObject, "shortplay"));
                    arrayList.add(dJXOrder);
                }
            }
        }
        orderListRsp.setData(arrayList);
        return orderListRsp;
    }
}
