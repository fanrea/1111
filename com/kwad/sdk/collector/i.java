package com.kwad.sdk.collector;

import android.content.Context;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class i {
    public static List<AppStatusRules.Strategy> c(AppStatusRules appStatusRules) {
        if (appStatusRules == null) {
            return new ArrayList();
        }
        return appStatusRules.obtainNamedStrategyList();
    }

    public static AppStatusRules.Strategy d(AppStatusRules appStatusRules) {
        if (appStatusRules == null) {
            return AppStatusRules.Strategy.LOCAL_DEFAULT;
        }
        return appStatusRules.obtainDefaultStrategy();
    }

    public static void a(Context context, AppStatusRules.Strategy strategy, long j) {
        if (context == null || strategy == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong(b(strategy), j).apply();
    }

    public static boolean a(Context context, AppStatusRules.Strategy strategy) {
        if (context == null) {
            return false;
        }
        long j = context.getSharedPreferences("ksadsdk_pref", 0).getLong(b(strategy), -1L);
        if (j < 0) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long minLaunchIntervalWithMS = strategy.getMinLaunchIntervalWithMS();
        return minLaunchIntervalWithMS <= 0 || j + minLaunchIntervalWithMS < jCurrentTimeMillis;
    }

    private static String b(AppStatusRules.Strategy strategy) {
        return "appstatus_strategy_pref_" + (strategy.getName() == null ? "defaultStrategy" : strategy.getName());
    }
}
