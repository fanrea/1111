package com.bytedance.sdk.djx.empty;

import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.IEMBaseService;
import com.bytedance.sdk.djx.model.DJXUser;
import com.ss.texturerender.TextureRenderKeys;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: EmptyBaseServiceImpl.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/djx/empty/EmptyBaseServiceImpl;", "Lcom/bytedance/sdk/djx/IEMBaseService;", "()V", "getSignString", "", "paySecretKey", "nonce", "time", "", "otherParams", "", "isLogin", "", "login", "", "params", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/sdk/djx/IDJXService$IDJXCallback;", "Lcom/bytedance/sdk/djx/model/DJXUser;", "logout", "sdk_api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class EmptyBaseServiceImpl implements IEMBaseService {
    @Override // com.bytedance.sdk.djx.IEMBaseService
    public String getSignString(String paySecretKey, String nonce, long time, Map<String, String> otherParams) {
        return null;
    }

    @Override // com.bytedance.sdk.djx.IEMBaseService
    public boolean isLogin() {
        return false;
    }

    @Override // com.bytedance.sdk.djx.IEMBaseService
    public void login(String params, IDJXService.IDJXCallback<DJXUser> callback) {
    }

    @Override // com.bytedance.sdk.djx.IEMBaseService
    public void logout(IDJXService.IDJXCallback<DJXUser> callback) {
    }
}
