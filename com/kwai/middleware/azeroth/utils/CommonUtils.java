package com.kwai.middleware.azeroth.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class CommonUtils {
    public static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());
    private static final Pattern PATTERN_DIGITS = Pattern.compile("\\d+");
}
