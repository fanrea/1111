package com.awfgwfd.joiyuevgyftrsa.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.dhylive.app.AppAdConfig;
import com.dhylive.app.data.mine.ConfigurationInfo;
import com.dhylive.app.utils.ExtensionKt;
import com.dhylive.app.utils.LiveEventConst;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WXEntryActivity.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/awfgwfd/joiyuevgyftrsa/wxapi/WXEntryActivity;", "Landroid/app/Activity;", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "()V", "api", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "code", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "onReq", "baseReq", "Lcom/tencent/mm/opensdk/modelbase/BaseReq;", "onResp", "baseResp", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private IWXAPI api;
    private String code;

    public void onReq(BaseReq baseReq) {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConfigurationInfo config = AppAdConfig.INSTANCE.getConfig();
        String wxAppid = config != null ? config.getWxAppid() : null;
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this, wxAppid, true);
        this.api = iwxapiCreateWXAPI;
        if (iwxapiCreateWXAPI != null) {
            iwxapiCreateWXAPI.registerApp(wxAppid);
        }
        try {
            IWXAPI iwxapi = this.api;
            if (iwxapi == null || iwxapi.handleIntent(getIntent(), this)) {
                return;
            }
            Log.e("===微信===", "onCreate: 参数不合法");
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IWXAPI iwxapi = this.api;
        if (iwxapi != null) {
            iwxapi.handleIntent(data, this);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        IWXAPI iwxapi = this.api;
        if (iwxapi != null) {
            iwxapi.handleIntent(intent, this);
        }
        finish();
    }

    public void onResp(BaseResp baseResp) throws JSONException {
        String str;
        Intrinsics.checkNotNullParameter(baseResp, "baseResp");
        if (baseResp instanceof WXOpenBusinessView.Resp) {
            try {
                String string = new JSONObject(((WXOpenBusinessView.Resp) baseResp).extMsg).getString("result");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                int iHashCode = string.hashCode();
                if (iHashCode != -1867169789) {
                    if (iHashCode != -1367724422) {
                        if (iHashCode == 3135262 && string.equals("fail")) {
                            ExtensionKt.toastShort(this, "提现失败");
                        }
                    } else if (string.equals("cancel")) {
                        ExtensionKt.toastShort(this, "用户取消操作");
                    }
                } else if (string.equals("success")) {
                    LiveEventBus.get(LiveEventConst.WX_WITHDRAW).post("success");
                }
                finish();
                return;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        SendAuth.Resp resp = (SendAuth.Resp) baseResp;
        this.code = resp.code;
        int i = baseResp.errCode;
        if (i == -4) {
            ExtensionKt.toastShort(this, "微信认证失败");
        } else if (i == -2) {
            ExtensionKt.toastShort(this, "用户取消登录");
        } else {
            if (i == 0) {
                str = resp.code;
                LiveEventBus.get(LiveEventConst.WX_LOGIN).post(str);
                finish();
            }
            ExtensionKt.toastShort(this, "微信授权失败");
        }
        str = "";
        LiveEventBus.get(LiveEventConst.WX_LOGIN).post(str);
        finish();
    }
}
