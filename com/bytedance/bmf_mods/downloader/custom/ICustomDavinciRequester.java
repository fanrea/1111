package com.bytedance.bmf_mods.downloader.custom;

import com.baidu.mobads.upgrade.remote.gray.c;
import com.bytedance.bmf_mods.downloader.custom.bean.ArithmeticsBean;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.component.a.f.d;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICustomDavinciRequester.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u008a\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\r\u001a\u00020\u00062\b\b\u0003\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u00062\b\b\u0003\u0010\u0011\u001a\u00020\u0006H'¨\u0006\u0013"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/ICustomDavinciRequester;", "", "arithmetics", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/bmf_mods/downloader/custom/bean/ArithmeticsBean;", "accessKey", "", "modelName", "deviceType", "appId", "appVersion", "platformSdkVersion", "deviceId", "sdkVersion", "status", "", "devicePlatform", "businessId", "Companion", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface ICustomDavinciRequester {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("/model/api/arithmetics/")
    Call<ArithmeticsBean> arithmetics(@Query(TextureRenderKeys.KEY_IS_BMF_VQSCORE_ACCESS_KEY) String accessKey, @Query("required_model_list") String modelName, @Query("device_type") String deviceType, @Query("aid") String appId, @Query("app_version") String appVersion, @Query("platform_sdk_version") String platformSdkVersion, @Query(c.l) String deviceId, @Query("sdk_version") String sdkVersion, @Query("status") int status, @Query("device_platform") String devicePlatform, @Query("busi_id") String businessId);

    /* compiled from: ICustomDavinciRequester.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/ICustomDavinciRequester$Companion;", "", "()V", d.b, "Lcom/bytedance/bmf_mods/downloader/custom/ICustomDavinciRequester;", "host", "", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final ICustomDavinciRequester create(String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            Object objCreate = RetrofitUtils.getSsRetrofit(host).create(ICustomDavinciRequester.class);
            Intrinsics.checkNotNullExpressionValue(objCreate, "getSsRetrofit(host).crea…nciRequester::class.java)");
            return (ICustomDavinciRequester) objCreate;
        }
    }

    /* compiled from: ICustomDavinciRequester.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call arithmetics$default(ICustomDavinciRequester iCustomDavinciRequester, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: arithmetics");
            }
            if ((i2 & 1) != 0) {
                str = null;
            }
            if ((i2 & 2) != 0) {
                str2 = null;
            }
            if ((i2 & 4) != 0) {
                str3 = null;
            }
            if ((i2 & 8) != 0) {
                str4 = null;
            }
            if ((i2 & 16) != 0) {
                str5 = null;
            }
            if ((i2 & 32) != 0) {
                str6 = null;
            }
            if ((i2 & 64) != 0) {
                str7 = null;
            }
            if ((i2 & 128) != 0) {
                str8 = "11.0.0";
            }
            if ((i2 & 256) != 0) {
                i = 1;
            }
            if ((i2 & 512) != 0) {
                str9 = "android";
            }
            if ((i2 & 1024) != 0) {
                str10 = "501090";
            }
            return iCustomDavinciRequester.arithmetics(str, str2, str3, str4, str5, str6, str7, str8, i, str9, str10);
        }
    }
}
