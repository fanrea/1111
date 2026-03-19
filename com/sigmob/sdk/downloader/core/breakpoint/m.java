package com.sigmob.sdk.downloader.core.breakpoint;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class m implements Handler.Callback {
    static final int a = 0;
    static final int b = -1;
    static final int c = -2;
    static final int d = -3;
    private static final String e = "RemitSyncExecutor";
    private final Handler f;
    private final Set<Integer> g;
    private final a h;

    interface a {
        void a(List<Integer> idList) throws IOException;

        void h(int id) throws IOException;

        void i(int id);
    }

    m(a agent) {
        this.h = agent;
        this.g = new HashSet();
        HandlerThread handlerThread = new HandlerThread("FileDownload RemitHandoverToDB");
        handlerThread.start();
        this.f = new Handler(handlerThread.getLooper(), this);
    }

    m(a agent, Handler handler, Set<Integer> freeToDBIdList) {
        this.h = agent;
        this.f = handler;
        this.g = freeToDBIdList;
    }

    void a() {
        this.f.getLooper().quit();
    }

    public void a(int id, long delayMillis) {
        this.f.sendEmptyMessageDelayed(id, delayMillis);
    }

    public void a(List<Integer> idList) {
        Message messageObtainMessage = this.f.obtainMessage(0);
        messageObtainMessage.obj = idList;
        this.f.sendMessage(messageObtainMessage);
    }

    void a(int[] ids) {
        for (int i : ids) {
            this.f.removeMessages(i);
        }
    }

    boolean a(int id) {
        return this.g.contains(Integer.valueOf(id));
    }

    public void b(int id) {
        this.f.sendEmptyMessage(id);
    }

    public void b(List<Integer> idList) {
        Message messageObtainMessage = this.f.obtainMessage(-1);
        messageObtainMessage.obj = idList;
        this.f.sendMessage(messageObtainMessage);
    }

    public void c(int id) {
        Message messageObtainMessage = this.f.obtainMessage(-3);
        messageObtainMessage.arg1 = id;
        this.f.sendMessage(messageObtainMessage);
    }

    public void d(int id) {
        Message messageObtainMessage = this.f.obtainMessage(-2);
        messageObtainMessage.arg1 = id;
        this.f.sendMessage(messageObtainMessage);
    }

    void e(int id) {
        this.f.removeMessages(id);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        int i;
        StringBuilder sb;
        String str;
        StringBuilder sbAppend;
        StringBuilder sbAppend2;
        int i2 = msg.what;
        if (i2 == -3) {
            i = msg.arg1;
            this.g.remove(Integer.valueOf(i));
            this.h.i(i);
            sb = new StringBuilder();
            str = "remove info ";
        } else {
            if (i2 != -2) {
                if (i2 == -1) {
                    List list = (List) msg.obj;
                    this.g.removeAll(list);
                    sbAppend = new StringBuilder().append("remove free bunch ids ").append(list);
                    com.sigmob.sdk.downloader.core.c.b(e, sbAppend.toString());
                    return true;
                }
                if (i2 != 0) {
                    int i3 = msg.what;
                    try {
                        this.h.h(i3);
                        this.g.add(Integer.valueOf(i3));
                        com.sigmob.sdk.downloader.core.c.b(e, "sync info with id: " + i3);
                        return true;
                    } catch (IOException unused) {
                        sbAppend2 = new StringBuilder().append("sync cache to db failed for id: ").append(i3);
                    }
                } else {
                    List<Integer> list2 = (List) msg.obj;
                    try {
                        this.h.a(list2);
                        this.g.addAll(list2);
                        com.sigmob.sdk.downloader.core.c.b(e, "sync bunch info with ids: " + list2);
                        return true;
                    } catch (IOException unused2) {
                        sbAppend2 = new StringBuilder().append("sync info to db failed for ids: ").append(list2);
                    }
                }
                com.sigmob.sdk.downloader.core.c.a(e, sbAppend2.toString());
                return true;
            }
            i = msg.arg1;
            this.g.remove(Integer.valueOf(i));
            sb = new StringBuilder();
            str = "remove free bunch id ";
        }
        sbAppend = sb.append(str).append(i);
        com.sigmob.sdk.downloader.core.c.b(e, sbAppend.toString());
        return true;
    }
}
