package com.bytedance.common.utility.device;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class SystemPropertiesProxy {
    SystemPropertiesProxy() {
    }

    public String get(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }
}
