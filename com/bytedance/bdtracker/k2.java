package com.bytedance.bdtracker;

import com.bytedance.applog.InitConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class k2 {
    public static final k2 b = new k2();
    public static final Map<InitConfig, Boolean> a = new LinkedHashMap();

    @JvmStatic
    public static final boolean a(InitConfig initConfig) {
        Intrinsics.checkParameterIsNotNull(initConfig, "config");
        Boolean bool = a.get(initConfig);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final Object b(InitConfig initConfig) {
        Intrinsics.checkParameterIsNotNull(initConfig, "config");
        Map<InitConfig, Boolean> map = a;
        Boolean bool = map.get(initConfig);
        if (bool != null) {
            return bool;
        }
        map.put(initConfig, true);
        return Unit.INSTANCE;
    }
}
