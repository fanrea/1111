package com.kuaishou.security.kste.logic.report;

import com.google.android.material.timepicker.TimeModel;
import com.kuaishou.security.kste.logic.base.XRay;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KVGTrace {
    private static final ConcurrentHashMap errorTrace = new ConcurrentHashMap();
    private static final ConcurrentHashMap methodTrace = new ConcurrentHashMap();

    public static void pushE(int i) {
        errorTrace.put(Long.valueOf(System.currentTimeMillis()), String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i)));
    }

    public static void pushS(int i) {
        methodTrace.put(Long.valueOf(System.currentTimeMillis()), String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i)));
    }

    public static void pushSTime(int i, long j) {
        methodTrace.put(Long.valueOf(j), String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i)));
    }

    public static String shuffleE() {
        StringBuffer stringBuffer = new StringBuffer();
        ConcurrentHashMap concurrentHashMap = errorTrace;
        if (concurrentHashMap.size() != 0) {
            TreeMap treeMap = new TreeMap(concurrentHashMap);
            stringBuffer.append("***errorbt***");
            for (Map.Entry entry : treeMap.entrySet()) {
                stringBuffer.append(String.format(Locale.getDefault(), "{%s:%s}", entry.getKey(), entry.getValue()));
            }
        }
        ConcurrentHashMap concurrentHashMap2 = methodTrace;
        if (concurrentHashMap2.size() != 0) {
            TreeMap treeMap2 = new TreeMap(concurrentHashMap2);
            stringBuffer.append("****commonbt****");
            for (Map.Entry entry2 : treeMap2.entrySet()) {
                stringBuffer.append(String.format(Locale.getDefault(), "{%s:%s}", entry2.getKey(), entry2.getValue()));
            }
        }
        XRay.get().getMInitParams();
        stringBuffer.append(String.format(">>>>>sostatus[%s] preparestate[%s]<<<<<<<<<<<<", "unknown", "unknown"));
        stringBuffer.insert(0, String.format("initbegintime[%d]%s->", 0, "unknown"));
        return stringBuffer.toString();
    }
}
