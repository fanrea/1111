package com.awfgwfd.joiyuevgyftrsa.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.dhylive.app.AppAdConfig;
import com.dhylive.app.data.mine.ConfigurationInfo;
import com.dhylive.app.utils.ExtensionKt;
import com.dhylive.app.utils.LiveEventConst;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WXPayEntryActivity.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/awfgwfd/joiyuevgyftrsa/wxapi/WXPayEntryActivity;", "Landroid/app/Activity;", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "()V", "api", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onReq", "resp", "Lcom/tencent/mm/opensdk/modelbase/BaseReq;", "onResp", "baseResp", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    private IWXAPI api;

    public void onReq(BaseReq resp) {
        Intrinsics.checkNotNullParameter(resp, "resp");
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConfigurationInfo config = AppAdConfig.INSTANCE.getConfig();
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this, config != null ? config.getWxAppid() : null);
        this.api = iwxapiCreateWXAPI;
        if (iwxapiCreateWXAPI != null) {
            iwxapiCreateWXAPI.handleIntent(getIntent(), this);
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
    }

    public void onResp(BaseResp baseResp) {
        Intrinsics.checkNotNullParameter(baseResp, "baseResp");
        if (baseResp.getType() == 5) {
            int i = baseResp.errCode;
            if (i == -4) {
                ExtensionKt.toastShort(this, "微信支付失败");
            } else if (i == -2) {
                ExtensionKt.toastShort(this, "用户取消支付");
            } else if (i == 0) {
                ExtensionKt.toastShort(this, "支付成功");
                LiveEventBus.get(LiveEventConst.WX_PAY).post("success");
            }
        }
        finish();
    }
}
