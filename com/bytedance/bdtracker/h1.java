package com.bytedance.bdtracker;

import android.util.Log;
import com.bytedance.applog.log.ILogProcessor;
import com.bytedance.applog.log.LogInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h1 implements ILogProcessor {
    public h1(d dVar) {
        onLog(LogInfo.builder().appId(dVar.m).level(1).thread(Thread.currentThread().getName()).message(a.a("Console logger debug is:").append(dVar.G).toString()).build());
    }

    @Override // com.bytedance.applog.log.ILogProcessor
    public void onLog(LogInfo logInfo) {
        int level = logInfo.getLevel();
        if (level == 2) {
            Log.i("AppLog", logInfo.toLiteString());
            return;
        }
        if (level == 3) {
            Log.w("AppLog", logInfo.toLiteString(), logInfo.getThrowable());
        } else if (level == 4 || level == 5) {
            Log.e("AppLog", logInfo.toLiteString(), logInfo.getThrowable());
        } else {
            Log.d("AppLog", logInfo.toLiteString());
        }
    }
}
