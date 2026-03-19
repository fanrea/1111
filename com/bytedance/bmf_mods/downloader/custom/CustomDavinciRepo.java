package com.bytedance.bmf_mods.downloader.custom;

import androidx.core.app.NotificationCompat;
import com.bytedance.bmf_mods.downloader.custom.ICustomDavinciRequester;
import com.bytedance.bmf_mods.downloader.custom.bean.Arithmetics;
import com.bytedance.bmf_mods.downloader.custom.bean.ArithmeticsBean;
import com.bytedance.bmf_mods.downloader.custom.bean.ArithmeticsData;
import com.bytedance.bmf_mods.downloader.custom.bean.CakeCook;
import com.bytedance.bmf_mods.downloader.custom.bean.FileUrl;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedInput;
import com.sigmob.sdk.base.n;
import com.ss.texturerender.TextureRenderKeys;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomDavinciRepo.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ¾\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052f\u0010\u0016\u001ab\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\r0\u0017R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/CustomDavinciRepo;", "", "()V", "apis", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/bmf_mods/downloader/custom/ICustomDavinciRequester;", "downloadFile", "", "url", n.z, "Ljava/io/File;", "getDownloadUrl", "", "host", "accessKey", "modelName", "deviceType", "appId", "appVersion", "platformSdkVersion", "deviceId", TextureRenderKeys.KEY_IS_CALLBACK, "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "code", "msg", ContentProviderManager.PROVIDER_URI, "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class CustomDavinciRepo {
    public static final CustomDavinciRepo INSTANCE = new CustomDavinciRepo();
    private static final ConcurrentHashMap<String, ICustomDavinciRequester> apis = new ConcurrentHashMap<>();

    private CustomDavinciRepo() {
    }

    public final void getDownloadUrl(String host, String accessKey, String modelName, String deviceType, String appId, String appVersion, String platformSdkVersion, String deviceId, final Function4<? super Integer, ? super String, ? super String, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(callback, TextureRenderKeys.KEY_IS_CALLBACK);
        ConcurrentHashMap<String, ICustomDavinciRequester> concurrentHashMap = apis;
        if (!concurrentHashMap.containsKey(host)) {
            concurrentHashMap.put(host, ICustomDavinciRequester.INSTANCE.create(host));
        }
        ICustomDavinciRequester iCustomDavinciRequester = concurrentHashMap.get(host);
        Intrinsics.checkNotNull(iCustomDavinciRequester);
        ICustomDavinciRequester.DefaultImpls.arithmetics$default(iCustomDavinciRequester, accessKey, modelName, deviceType, appId, appVersion, platformSdkVersion, deviceId, null, 0, null, null, 1920, null).enqueue(new Callback<ArithmeticsBean>() { // from class: com.bytedance.bmf_mods.downloader.custom.CustomDavinciRepo.getDownloadUrl.1
            public void onResponse(Call<ArithmeticsBean> call, SsResponse<ArithmeticsBean> response) {
                List<String> urlList;
                Arithmetics arithmetics;
                List<CakeCook> cakeCook;
                CakeCook cakeCook2;
                Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkNotNullParameter(response, "response");
                String str = null;
                if (response.isSuccessful()) {
                    if (((ArithmeticsBean) response.body()).getStatusCode() == 0) {
                        ArithmeticsData data = ((ArithmeticsBean) response.body()).getData();
                        FileUrl fileUrl = (data == null || (arithmetics = data.getArithmetics()) == null || (cakeCook = arithmetics.getCakeCook()) == null || (cakeCook2 = (CakeCook) CollectionsKt.firstOrNull(cakeCook)) == null) ? null : cakeCook2.getFileUrl();
                        String uri = fileUrl != null ? fileUrl.getUri() : null;
                        if (fileUrl != null && (urlList = fileUrl.getUrlList()) != null) {
                            str = (String) CollectionsKt.firstOrNull(urlList);
                        }
                        String str2 = uri;
                        boolean z = true;
                        if (!(str2 == null || str2.length() == 0)) {
                            String str3 = str;
                            if (str3 != null && str3.length() != 0) {
                                z = false;
                            }
                            if (!z) {
                                callback.invoke(0, "", uri, str);
                                return;
                            }
                        }
                        callback.invoke(-4001, response.message(), uri, str);
                        return;
                    }
                    callback.invoke(Integer.valueOf(((ArithmeticsBean) response.body()).getStatusCode()), response.message(), (Object) null, (Object) null);
                    return;
                }
                callback.invoke(-4002, response.message(), (Object) null, (Object) null);
            }

            public void onFailure(Call<ArithmeticsBean> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkNotNullParameter(t, "t");
                callback.invoke(-4000, t.getMessage(), (Object) null, (Object) null);
            }
        });
    }

    public final boolean downloadFile(String url, File file) throws Exception {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(file, n.z);
        SsResponse ssResponseExecute = FileDownloadRequester.INSTANCE.create(url).downloadFile().execute();
        if (!ssResponseExecute.isSuccessful()) {
            return false;
        }
        FileOutputStream fileOutputStreamIn = ((TypedInput) ssResponseExecute.body()).in();
        try {
            InputStream inputStream = fileOutputStreamIn;
            fileOutputStreamIn = new FileOutputStream(file);
            try {
                Intrinsics.checkNotNullExpressionValue(inputStream, "ins");
                ByteStreamsKt.copyTo$default(inputStream, fileOutputStreamIn, 0, 2, (Object) null);
                CloseableKt.closeFinally(fileOutputStreamIn, (Throwable) null);
                CloseableKt.closeFinally(fileOutputStreamIn, (Throwable) null);
                return true;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
            }
        }
    }
}
