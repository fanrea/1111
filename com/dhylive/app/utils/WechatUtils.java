package com.dhylive.app.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.blankj.utilcode.util.ToastUtils;
import com.dhylive.app.AppAdConfig;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.ss.texturerender.VideoSurfaceTexture;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WechatUtils.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011JB\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011J,\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u00112\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/dhylive/app/utils/WechatUtils;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "wxApi", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "bmpToByteArray", "", "bmp", "Landroid/graphics/Bitmap;", "needRecycle", "", "toLogin", "", "toVideoShare", "videoName", "", "s", "videoUrl", "videoCover", "toWXPayNotSign", "partnerId", "prepayId", "packageValue", "nonceStr", VideoSurfaceTexture.KEY_TIME, "sign", "toWebShare", "tittle", "description", "url", "flag", "", "toWithdraw", "query", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class WechatUtils {
    private final Context context;
    private final IWXAPI wxApi;

    public WechatUtils(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, (String) null);
        Intrinsics.checkNotNullExpressionValue(iwxapiCreateWXAPI, "createWXAPI(...)");
        this.wxApi = iwxapiCreateWXAPI;
        iwxapiCreateWXAPI.registerApp(AppAdConfig.INSTANCE.getWxAppid());
    }

    public final void toLogin() {
        if (!this.wxApi.isWXAppInstalled()) {
            ToastUtils.showShort("您的设备未安装微信客户端", new Object[0]);
            LiveEventBus.get(LiveEventConst.WX_LOGIN, String.class).post("");
        } else {
            BaseReq req = new SendAuth.Req();
            ((SendAuth.Req) req).scope = "snsapi_userinfo";
            ((SendAuth.Req) req).state = "wechat_sdk_demo_test";
            this.wxApi.sendReq(req);
        }
    }

    public final void toWithdraw(String query) {
        if (this.wxApi.getWXAppSupportAPI() >= 620889344) {
            BaseReq req = new WXOpenBusinessView.Req();
            ((WXOpenBusinessView.Req) req).businessType = "requestMerchantTransfer";
            ((WXOpenBusinessView.Req) req).query = query;
            this.wxApi.sendReq(req);
            return;
        }
        ToastUtils.showShort("请升级微信客户端", new Object[0]);
    }

    public final boolean toWXPayNotSign(final String partnerId, final String prepayId, final String packageValue, final String nonceStr, final String timeStamp, final String sign) {
        if (!this.wxApi.isWXAppInstalled()) {
            return false;
        }
        new Thread(new Runnable() { // from class: com.dhylive.app.utils.WechatUtils$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WechatUtils.toWXPayNotSign$lambda$0(partnerId, prepayId, packageValue, nonceStr, timeStamp, sign, this);
            }
        }).start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toWXPayNotSign$lambda$0(String str, String str2, String str3, String str4, String str5, String str6, WechatUtils wechatUtils) {
        Intrinsics.checkNotNullParameter(wechatUtils, "this$0");
        BaseReq payReq = new PayReq();
        ((PayReq) payReq).appId = AppAdConfig.INSTANCE.getWxAppid();
        ((PayReq) payReq).partnerId = str;
        ((PayReq) payReq).prepayId = str2;
        ((PayReq) payReq).packageValue = str3;
        ((PayReq) payReq).nonceStr = str4;
        ((PayReq) payReq).timeStamp = str5;
        ((PayReq) payReq).sign = str6;
        wechatUtils.wxApi.sendReq(payReq);
    }

    public final void toWebShare(String tittle, String description, String url, int flag) {
        if (!this.wxApi.isWXAppInstalled()) {
            ToastUtils.showShort("未安装微信", new Object[0]);
            return;
        }
        WXMediaMessage.IMediaObject wXWebpageObject = new WXWebpageObject();
        ((WXWebpageObject) wXWebpageObject).webpageUrl = url;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = tittle;
        wXMediaMessage.description = description;
        wXMediaMessage.setThumbImage(BitmapFactory.decodeResource(this.context.getResources(), 2131558400));
        BaseReq req = new SendMessageToWX.Req();
        ((SendMessageToWX.Req) req).transaction = System.currentTimeMillis() + "";
        ((SendMessageToWX.Req) req).message = wXMediaMessage;
        ((SendMessageToWX.Req) req).scene = flag != 0 ? 1 : 0;
        this.wxApi.sendReq(req);
    }

    public final void toVideoShare(final String videoName, final String s, final String videoUrl, final String videoCover) {
        Intrinsics.checkNotNullParameter(videoName, "videoName");
        Intrinsics.checkNotNullParameter(s, "s");
        if (!this.wxApi.isWXAppInstalled()) {
            ToastUtils.showShort("未安装微信客户端", new Object[0]);
        } else {
            new Thread(new Runnable() { // from class: com.dhylive.app.utils.WechatUtils$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    WechatUtils.toVideoShare$lambda$1(videoUrl, videoName, s, videoCover, this);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toVideoShare$lambda$1(String str, String str2, String str3, String str4, WechatUtils wechatUtils) throws IOException {
        Bitmap bitmapDecodeStream;
        Intrinsics.checkNotNullParameter(str2, "$videoName");
        Intrinsics.checkNotNullParameter(str3, "$s");
        Intrinsics.checkNotNullParameter(wechatUtils, "this$0");
        WXMediaMessage.IMediaObject wXVideoObject = new WXVideoObject();
        ((WXVideoObject) wXVideoObject).videoUrl = str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
        wXMediaMessage.title = "" + str2;
        wXMediaMessage.description = "" + str3;
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(new URL(str4).openStream());
        } catch (IOException e) {
            e.printStackTrace();
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(wechatUtils.context.getResources(), 2131558400);
            Intrinsics.checkNotNull(bitmapDecodeResource);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeResource, 120, 150, true);
            bitmapDecodeResource.recycle();
            wXMediaMessage.thumbData = wechatUtils.bmpToByteArray(bitmapCreateScaledBitmap, true);
        }
        if (bitmapDecodeStream == null) {
            throw new IOException("");
        }
        Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeStream, 120, 150, true);
        bitmapDecodeStream.recycle();
        wXMediaMessage.thumbData = wechatUtils.bmpToByteArray(bitmapCreateScaledBitmap2, true);
        BaseReq req = new SendMessageToWX.Req();
        ((SendMessageToWX.Req) req).transaction = "video" + System.currentTimeMillis();
        ((SendMessageToWX.Req) req).message = wXMediaMessage;
        ((SendMessageToWX.Req) req).scene = 0;
        wechatUtils.wxApi.sendReq(req);
    }

    public final byte[] bmpToByteArray(Bitmap bmp, boolean needRecycle) throws IOException {
        Intrinsics.checkNotNullParameter(bmp, "bmp");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        if (needRecycle) {
            bmp.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intrinsics.checkNotNull(byteArray);
        return byteArray;
    }
}
