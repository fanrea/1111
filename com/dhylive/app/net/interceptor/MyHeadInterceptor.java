package com.dhylive.app.net.interceptor;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.accessibility.AccessibilityManager;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.PhoneUtils;
import com.blankj.utilcode.util.SPUtils;
import com.dhylive.app.AppApplication;
import com.dhylive.app.utils.SPConfig;
import com.dhylive.app.utils.YueDu;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import com.snail.antifake.deviceid.AndroidDeviceIMEIUtil;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: MyHeadInterceptor.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0002¨\u0006\n"}, d2 = {"Lcom/dhylive/app/net/interceptor/MyHeadInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "convertBoolean", "", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class MyHeadInterceptor implements Interceptor {
    private final String convertBoolean(boolean z) {
        return z ? "1" : "0";
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (StringsKt.contains$default((CharSequence) "https://tbq.tongbangqu.top/", (CharSequence) chain.request().url().host(), false, 2, (Object) null)) {
            String string = SPUtils.getInstance().getString(SPConfig.KEY_TOKEN);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Object systemService = AppApplication.INSTANCE.getInstance().getSystemService("accessibility");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
            AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
            Intent intentRegisterReceiver = AppApplication.INSTANCE.getInstance().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            boolean z = (intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", -1) : -1) == 2;
            BluetoothManager bluetoothManager = (BluetoothManager) AppApplication.INSTANCE.getInstance().getSystemService("bluetooth");
            Intrinsics.checkNotNull(bluetoothManager);
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            YueDu yueDu = new YueDu();
            Request.Builder builderHeader = chain.request().newBuilder().header("deviceType", "Android").header(NetworkDefine.PARAM_TOKEN, string).header("isSim", convertBoolean(true ^ PhoneUtils.isSimCardReady())).header("isBluetooth", convertBoolean(adapter.isEnabled())).header("isCharging", convertBoolean(z)).header("isdev", convertBoolean(DeviceUtils.isDevelopmentSettingsEnabled())).header("isRoot", convertBoolean(DeviceUtils.isDeviceRooted())).header("isEmulator", convertBoolean(AndroidDeviceIMEIUtil.isRunOnEmulator(AppApplication.INSTANCE.getInstance()))).header("bf", convertBoolean(accessibilityManager.isEnabled()));
            String cachedUUID = yueDu.getCachedUUID();
            Intrinsics.checkNotNullExpressionValue(cachedUUID, "getCachedUUID(...)");
            return chain.proceed(builderHeader.header("cachedUUID", cachedUUID).build());
        }
        return chain.proceed(chain.request());
    }
}
