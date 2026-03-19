package com.bytedance.sdk.djx.core.init.pay;

import android.content.Context;
import android.util.Pair;
import com.bytedance.sdk.djx.DJXSdkConfig;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DJXOrder;
import com.bytedance.sdk.djx.model.DJXRenewal;
import com.bytedance.sdk.djx.net.ApiConstants;
import com.bytedance.sdk.djx.utils.AppLogManager;
import com.bytedance.sdk.djx.utils.debug.DebugInfo;
import com.pangrowth.empay.EMPayConfig;
import com.pangrowth.empay.EMPaySdk;
import com.pangrowth.empay.IEMNetWork;
import com.pangrowth.empay.IEMPaySetting;
import com.pangrowth.empay.callback.IEMCommonCallback;
import com.pangrowth.empay.callback.IEMPayCallback;
import com.pangrowth.empay.model.EMOrder;
import com.pangrowth.empay.model.EMRenewal;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class PayProxy {
    public static void init(Context context, DJXSdkConfig dJXSdkConfig) {
        EMPaySdk.INSTANCE.init(context, new DJXPayConfig());
    }

    public static void pay(String str, final IDJXService.IDJXCallback<DJXOrder> iDJXCallback) {
        EMPaySdk.INSTANCE.pay(str, new IEMPayCallback() { // from class: com.bytedance.sdk.djx.core.init.pay.PayProxy.1
            public void onPayError(int i, String str2, EMOrder eMOrder) {
                IDJXService.IDJXCallback iDJXCallback2 = iDJXCallback;
                if (iDJXCallback2 != null) {
                    iDJXCallback2.onError(DJXError.build(i, str2));
                }
            }

            public void onPaySuccess(EMOrder eMOrder) {
                if (iDJXCallback != null) {
                    DJXOrder dJXOrder = new DJXOrder();
                    if (eMOrder != null) {
                        dJXOrder.orderId = eMOrder.getTradeNo();
                        dJXOrder.status = eMOrder.getStatus();
                    }
                    iDJXCallback.onSuccess(dJXOrder, null);
                }
            }
        });
    }

    public static void cancelRenewal(long j, long j2, final IDJXService.IDJXCallback<DJXRenewal> iDJXCallback) {
        EMPaySdk.INSTANCE.cancelRenewal(j, j2, new IEMCommonCallback<EMRenewal>() { // from class: com.bytedance.sdk.djx.core.init.pay.PayProxy.2
            public void onError(int i, String str) {
                IDJXService.IDJXCallback iDJXCallback2 = iDJXCallback;
                if (iDJXCallback2 != null) {
                    iDJXCallback2.onError(DJXError.build(i, str));
                }
            }

            public void onSuccess(EMRenewal eMRenewal) {
                if (iDJXCallback != null) {
                    DJXRenewal dJXRenewal = new DJXRenewal();
                    if (eMRenewal != null) {
                        dJXRenewal.id = eMRenewal.getRenewalId();
                        dJXRenewal.comboName = eMRenewal.getComboName();
                        dJXRenewal.status = eMRenewal.getStatus();
                    }
                    iDJXCallback.onSuccess(dJXRenewal, null);
                }
            }
        });
    }

    private static class DJXPayConfig implements EMPayConfig {
        public String getAppId() {
            return "520328";
        }

        public String getUrl4CreateOrder() {
            return "/csj_sp/api/v1/pay/create_order";
        }

        public String getUrl4QueryOrder() {
            return "/csj_sp/api/v1/pay/query_order";
        }

        public String getUrl4RenewalCancel() {
            return "/csj_sp/api/v1/pay/cancel_agreement";
        }

        private DJXPayConfig() {
        }

        public String getDid() {
            return AppLogManager.getAppLogInstance().getDid();
        }

        public String getIId() {
            return AppLogManager.getAppLogInstance().getIid();
        }

        public Map<String, String> getRiskInfo() {
            HashMap map = new HashMap();
            map.put("sdk_aid", getAppId());
            map.put("aid", DevInfo.sAppId);
            map.put("site_id", DevInfo.sSiteId);
            return map;
        }

        public void onEventSender(String str, JSONObject jSONObject) {
            BLogAgent.build("pay", str, null).putAll(jSONObject).send();
        }

        public IEMNetWork onNetWorkInject() {
            return new PayNetImpl();
        }

        public IEMPaySetting getSettings() {
            return new PaySettingsImpl();
        }

        public String onHost() {
            return ApiConstants.getHost();
        }

        public Pair<Integer, String> onPpeOrBoe() {
            Map mapPpe = DebugInfo.Bridge.ppe();
            if (mapPpe == null || mapPpe.isEmpty()) {
                return null;
            }
            String str = (String) mapPpe.get("x-tt-env");
            if (mapPpe.containsKey("x-use-ppe")) {
                return new Pair<>(1, str);
            }
            if (mapPpe.containsKey("x-use-boe")) {
                return new Pair<>(2, str);
            }
            return null;
        }
    }
}
