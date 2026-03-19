package com.baidu.mobads.container.l;

import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a implements b {
    @Override // com.baidu.mobads.container.l.b
    public void a(int i, String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("当前线程：").append(Thread.currentThread().getName()).append(";  ").append("打印消息：").append(str2).append(";  ").append("\n 调用全堆栈信息：").append(Log.getStackTraceString(new Throwable()));
        i.a(i, str, sb.toString());
    }
}
