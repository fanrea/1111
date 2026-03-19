package com.bytedance.sdk.djx.core.init;

import com.bytedance.sdk.djx.IDJXCave;
import com.bytedance.sdk.djx.core.init.helper.PLTHelper;
import com.bytedance.sdk.djx.net.req.k.UAInterceptor;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.utils.DeviceUtils;
import com.bytedance.sdk.djx.utils.debug.DebugInfo;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXCaveImpl implements IDJXCave {
    public static DJXCaveImpl getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final DJXCaveImpl instance = new DJXCaveImpl();

        private InnerHolder() {
        }
    }

    @Override // com.bytedance.sdk.djx.IDJXCave
    public String a() {
        return DebugInfo.aa("did:" + DeviceUtils.getDid() + "\ntoken:" + TokenHelper.getInstance().getToken() + "\nuser_id:" + TokenHelper.getInstance().getUserId() + "\nuser_type:" + TokenHelper.getInstance().getUserType() + "\nvod:" + PLTHelper.getInstance().getVodVersion() + "\n");
    }

    @Override // com.bytedance.sdk.djx.IDJXCave
    public void b(Map<String, String> map) {
        UAInterceptor.DEFAULT().setHeader(map);
    }
}
