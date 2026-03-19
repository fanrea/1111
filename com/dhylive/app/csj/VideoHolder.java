package com.dhylive.app.csj;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.LogUtils;
import com.bytedance.sdk.dp.DPSdk;
import com.bytedance.sdk.dp.DPSdkConfig;
import com.bytedance.sdk.dp.DPWidgetBannerParams;
import com.bytedance.sdk.dp.DPWidgetBubbleParams;
import com.bytedance.sdk.dp.DPWidgetDrawParams;
import com.bytedance.sdk.dp.DPWidgetGridParams;
import com.bytedance.sdk.dp.DPWidgetInnerPushParams;
import com.bytedance.sdk.dp.DPWidgetNewsParams;
import com.bytedance.sdk.dp.DPWidgetTextChainParams;
import com.bytedance.sdk.dp.DPWidgetVideoCardParams;
import com.bytedance.sdk.dp.DPWidgetVideoSingleCardParams;
import com.bytedance.sdk.dp.IDPNativeData;
import com.bytedance.sdk.dp.IDPPrivacyController;
import com.bytedance.sdk.dp.IDPToastController;
import com.bytedance.sdk.dp.IDPWidget;
import com.bytedance.sdk.dp.IDPWidgetFactory;
import com.dhylive.app.utils.LiveEventConst;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.kwai.kanas.upload.e;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: VideoHolder.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0012J\"\u0010\u0014\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010\u001e\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!J\u001a\u0010\"\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010#2\b\u0010 \u001a\u0004\u0018\u00010!J\u001a\u0010$\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010%2\b\u0010 \u001a\u0004\u0018\u00010!J\u001a\u0010&\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010'2\b\u0010 \u001a\u0004\u0018\u00010!J\u001a\u0010(\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u00122\b\u0010)\u001a\u0004\u0018\u00010*J\u0010\u0010+\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u0012J\u001a\u0010,\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010%2\b\u0010 \u001a\u0004\u0018\u00010!J\u001a\u0010-\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010.2\b\u0010 \u001a\u0004\u0018\u00010!J\u001a\u0010/\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010%2\b\u0010 \u001a\u0004\u0018\u00010!J\u001a\u00100\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u0001012\b\u0010 \u001a\u0004\u0018\u00010!J\u001a\u00102\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u0001012\b\u0010 \u001a\u0004\u0018\u00010!J$\u00103\u001a\u00020\u00152\b\u00104\u001a\u0004\u0018\u00010\u00192\b\u00105\u001a\u0004\u0018\u00010\u00192\b\u00106\u001a\u0004\u0018\u000107R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u00068"}, d2 = {"Lcom/dhylive/app/csj/VideoHolder;", "", "()V", "factory", "Lcom/bytedance/sdk/dp/IDPWidgetFactory;", "getFactory", "()Lcom/bytedance/sdk/dp/IDPWidgetFactory;", "isStartSuccess", "", "()Z", "buildDoubleFeedWidget", "Lcom/bytedance/sdk/dp/IDPWidget;", "params", "Lcom/bytedance/sdk/dp/DPWidgetGridParams;", "buildDrawWidget", "Lcom/bytedance/sdk/dp/DPWidgetDrawParams;", "buildGridWidget", "buildNewsOneTabWidget", "Lcom/bytedance/sdk/dp/DPWidgetNewsParams;", "buildNewsTabsWidget", "enterNewsDetail", "", "groupId", "", "data", "", PointCategory.INIT, "application", "Landroid/app/Application;", "initDp", "loadBanner", "Lcom/bytedance/sdk/dp/DPWidgetBannerParams;", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/sdk/dp/IDPWidgetFactory$Callback;", "loadBubble", "Lcom/bytedance/sdk/dp/DPWidgetBubbleParams;", "loadCustomVideoCard", "Lcom/bytedance/sdk/dp/DPWidgetVideoCardParams;", "loadInnerPush", "Lcom/bytedance/sdk/dp/DPWidgetInnerPushParams;", "loadNativeNews", "listener", "Lcom/bytedance/sdk/dp/IDPNativeData$DPNativeDataListener;", "loadPush", "loadSmallVideoCard", "loadTextChain", "Lcom/bytedance/sdk/dp/DPWidgetTextChainParams;", "loadVideoCard", "loadVideoSingleCard", "Lcom/bytedance/sdk/dp/DPWidgetVideoSingleCardParams;", "loadVideoSingleCard4News", e.a, "category", NotificationCompat.CATEGORY_EVENT, "json", "Lorg/json/JSONObject;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class VideoHolder {
    public static final VideoHolder INSTANCE = new VideoHolder();

    private VideoHolder() {
    }

    public final boolean isStartSuccess() {
        return DPSdk.isStartSuccess();
    }

    private final IDPWidgetFactory getFactory() {
        IDPWidgetFactory iDPWidgetFactoryFactory = DPSdk.factory();
        Intrinsics.checkNotNullExpressionValue(iDPWidgetFactoryFactory, "factory(...)");
        return iDPWidgetFactoryFactory;
    }

    public final void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        try {
            initDp(application);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void initDp(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("sp_dpsdk", 0);
        DPSdk.init(application, "SDK_Setting_5744631.json", new DPSdkConfig.Builder().debug(false).disableABTest(false).newUser(false).aliveSeconds(0).toastController(new IDPToastController() { // from class: com.dhylive.app.csj.VideoHolder$initDp$configBuilder$1
        }).fontStyle(sharedPreferences != null && sharedPreferences.getBoolean("sp_key_xl_font", false) ? DPSdkConfig.ArticleDetailListTextStyle.FONT_XL : DPSdkConfig.ArticleDetailListTextStyle.FONT_NORMAL).luckConfig(new DPSdkConfig.LuckConfig().application(application).enableLuck(false)).privacyController(new IDPPrivacyController() { // from class: com.dhylive.app.csj.VideoHolder$initDp$configBuilder$2
        }).build());
        DPSdk.start(new DPSdk.StartListener() { // from class: com.dhylive.app.csj.VideoHolder$$ExternalSyntheticLambda0
            public final void onStartComplete(boolean z, String str) {
                VideoHolder.initDp$lambda$0(z, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDp$lambda$0(boolean z, String str) {
        LogUtils.e("DPSdk start result=" + z + ", msg=" + str);
        if (z) {
            LiveEventBus.get(LiveEventConst.VIDEO_INIT_SUCCESS).post(Unit.INSTANCE);
        }
    }

    public final IDPWidget buildDrawWidget(DPWidgetDrawParams params) {
        IDPWidget iDPWidgetCreateDraw = getFactory().createDraw(params);
        Intrinsics.checkNotNullExpressionValue(iDPWidgetCreateDraw, "createDraw(...)");
        return iDPWidgetCreateDraw;
    }

    public final IDPWidget buildGridWidget(DPWidgetGridParams params) {
        IDPWidget iDPWidgetCreateGrid = getFactory().createGrid(params);
        Intrinsics.checkNotNullExpressionValue(iDPWidgetCreateGrid, "createGrid(...)");
        return iDPWidgetCreateGrid;
    }

    public final IDPWidget buildDoubleFeedWidget(DPWidgetGridParams params) {
        IDPWidget iDPWidgetCreateDoubleFeed = getFactory().createDoubleFeed(params);
        Intrinsics.checkNotNullExpressionValue(iDPWidgetCreateDoubleFeed, "createDoubleFeed(...)");
        return iDPWidgetCreateDoubleFeed;
    }

    public final IDPWidget buildNewsTabsWidget(DPWidgetNewsParams params) {
        IDPWidget iDPWidgetCreateNewsTabs = getFactory().createNewsTabs(params);
        Intrinsics.checkNotNullExpressionValue(iDPWidgetCreateNewsTabs, "createNewsTabs(...)");
        return iDPWidgetCreateNewsTabs;
    }

    public final IDPWidget buildNewsOneTabWidget(DPWidgetNewsParams params) {
        IDPWidget iDPWidgetCreateNewsOneTab = getFactory().createNewsOneTab(params);
        Intrinsics.checkNotNullExpressionValue(iDPWidgetCreateNewsOneTab, "createNewsOneTab(...)");
        return iDPWidgetCreateNewsOneTab;
    }

    public final void loadVideoCard(DPWidgetVideoCardParams params, IDPWidgetFactory.Callback callback) {
        getFactory().loadVideoCard(params, callback);
    }

    public final void loadSmallVideoCard(DPWidgetVideoCardParams params, IDPWidgetFactory.Callback callback) {
        getFactory().loadSmallVideoCard(params, callback);
    }

    public final void loadVideoSingleCard(DPWidgetVideoSingleCardParams params, IDPWidgetFactory.Callback callback) {
        getFactory().loadVideoSingleCard(params, callback);
    }

    public final void loadTextChain(DPWidgetTextChainParams params, IDPWidgetFactory.Callback callback) {
        getFactory().loadTextChain(params, callback);
    }

    public final void loadCustomVideoCard(DPWidgetVideoCardParams params, IDPWidgetFactory.Callback callback) {
        getFactory().loadCustomVideoCard(params, callback);
    }

    public final void loadBubble(DPWidgetBubbleParams params, IDPWidgetFactory.Callback callback) {
        getFactory().loadBubble(params, callback);
    }

    public final void loadBanner(DPWidgetBannerParams params, IDPWidgetFactory.Callback callback) {
        getFactory().loadBanner(params, callback);
    }

    public final void loadInnerPush(DPWidgetInnerPushParams params, IDPWidgetFactory.Callback callback) {
        getFactory().loadInnerPush(params, callback);
    }

    public final void loadVideoSingleCard4News(DPWidgetVideoSingleCardParams params, IDPWidgetFactory.Callback callback) {
        getFactory().loadVideoSingleCard4News(params, callback);
    }

    public final void loadNativeNews(DPWidgetNewsParams params, IDPNativeData.DPNativeDataListener listener) {
        getFactory().loadNativeNews(params, listener);
    }

    public final void enterNewsDetail(DPWidgetNewsParams params, long groupId, String data) {
        getFactory().enterNewsDetail(params, groupId, data);
    }

    public final void loadPush(DPWidgetNewsParams params) {
        getFactory().pushNews(params);
    }

    public final void uploadLog(String category, String event, JSONObject json) {
        getFactory().uploadLog(category, event, json);
    }
}
