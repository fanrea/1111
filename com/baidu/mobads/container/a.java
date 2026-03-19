package com.baidu.mobads.container;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends Handler {
    protected InterfaceC0117a a;

    /* renamed from: com.baidu.mobads.container.a$a, reason: collision with other inner class name */
    public interface InterfaceC0117a {
        void a(Message message);
    }

    public a(Looper looper, InterfaceC0117a interfaceC0117a) {
        super(looper);
        this.a = interfaceC0117a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.a != null) {
            this.a.a(message);
        }
    }
}
