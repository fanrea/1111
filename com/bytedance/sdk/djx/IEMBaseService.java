package com.bytedance.sdk.djx;

import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.model.DJXUser;
import com.ss.texturerender.TextureRenderKeys;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IEMBaseService.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u000bH&J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H&J\u0018\u0010\u0012\u001a\u00020\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/djx/IEMBaseService;", "", "getSignString", "", "paySecretKey", "nonce", "time", "", "otherParams", "", "isLogin", "", "login", "", "params", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/sdk/djx/IDJXService$IDJXCallback;", "Lcom/bytedance/sdk/djx/model/DJXUser;", "logout", "sdk_api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IEMBaseService {
    String getSignString(String paySecretKey, String nonce, long time, Map<String, String> otherParams);

    boolean isLogin();

    void login(String params, IDJXService.IDJXCallback<DJXUser> callback);

    void logout(IDJXService.IDJXCallback<DJXUser> callback);
}
