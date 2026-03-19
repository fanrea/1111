package com.bytedance.applog.log;

import android.util.Log;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class NativeLoggerImpl extends LoggerImpl {
    private String tag;

    public NativeLoggerImpl() {
        this.tag = "NativeLoggerImpl";
    }

    public NativeLoggerImpl(String str) {
        this.tag = str;
    }

    @Override // com.bytedance.applog.log.AbstractAppLogLogger
    protected void process(int i, int i2, List<String> list, Throwable th, String str, Object... objArr) {
        LogInfo logInfoBuild = LogInfo.builder().category(i).level(i2).thread(Thread.currentThread().getName()).throwable(th).tags(getTags(list)).message(format(str, objArr)).build();
        int level = logInfoBuild.getLevel();
        if (level == 0) {
            Log.v(this.tag, logInfoBuild.toMessage(), logInfoBuild.getThrowable());
            return;
        }
        if (level == 2) {
            Log.i(this.tag, logInfoBuild.toMessage(), logInfoBuild.getThrowable());
            return;
        }
        if (level == 3) {
            Log.w(this.tag, logInfoBuild.toMessage(), logInfoBuild.getThrowable());
        } else if (level == 4 || level == 5) {
            Log.e(this.tag, logInfoBuild.toMessage(), logInfoBuild.getThrowable());
        } else {
            Log.d(this.tag, logInfoBuild.toMessage(), logInfoBuild.getThrowable());
        }
    }
}
