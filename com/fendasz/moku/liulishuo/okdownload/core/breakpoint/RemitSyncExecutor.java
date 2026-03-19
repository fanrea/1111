package com.fendasz.moku.liulishuo.okdownload.core.breakpoint;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.fendasz.moku.liulishuo.okdownload.core.Util;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class RemitSyncExecutor implements Handler.Callback {
    private static final String TAG = "RemitSyncExecutor";
    static final int WHAT_REMOVE_FREE_BUNCH_ID = -1;
    static final int WHAT_REMOVE_FREE_ID = -2;
    static final int WHAT_REMOVE_INFO = -3;
    static final int WHAT_SYNC_BUNCH_ID = 0;
    private final RemitAgent agent;
    private final Set<Integer> freeToDBIdList;
    private final Handler handler;

    interface RemitAgent {
        void removeInfo(int i);

        void syncCacheToDB(int i) throws IOException;

        void syncCacheToDB(List<Integer> list) throws IOException;
    }

    RemitSyncExecutor(RemitAgent remitAgent) {
        this.agent = remitAgent;
        this.freeToDBIdList = new HashSet();
        HandlerThread handlerThread = new HandlerThread("OkDownload RemitHandoverToDB");
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), this);
    }

    RemitSyncExecutor(RemitAgent remitAgent, Handler handler, Set<Integer> set) {
        this.agent = remitAgent;
        this.handler = handler;
        this.freeToDBIdList = set;
    }

    void shutdown() {
        this.handler.getLooper().quit();
    }

    boolean isFreeToDatabase(int i) {
        return this.freeToDBIdList.contains(Integer.valueOf(i));
    }

    public void postSyncInfoDelay(int i, long j) {
        this.handler.sendEmptyMessageDelayed(i, j);
    }

    public void postSync(int i) {
        this.handler.sendEmptyMessage(i);
    }

    public void postSync(List<Integer> list) {
        Message messageObtainMessage = this.handler.obtainMessage(0);
        messageObtainMessage.obj = list;
        this.handler.sendMessage(messageObtainMessage);
    }

    public void postRemoveInfo(int i) {
        Message messageObtainMessage = this.handler.obtainMessage(-3);
        messageObtainMessage.arg1 = i;
        this.handler.sendMessage(messageObtainMessage);
    }

    public void postRemoveFreeIds(List<Integer> list) {
        Message messageObtainMessage = this.handler.obtainMessage(-1);
        messageObtainMessage.obj = list;
        this.handler.sendMessage(messageObtainMessage);
    }

    public void postRemoveFreeId(int i) {
        Message messageObtainMessage = this.handler.obtainMessage(-2);
        messageObtainMessage.arg1 = i;
        this.handler.sendMessage(messageObtainMessage);
    }

    void removePostWithId(int i) {
        this.handler.removeMessages(i);
    }

    void removePostWithIds(int[] iArr) {
        for (int i : iArr) {
            this.handler.removeMessages(i);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == -3) {
            int i2 = message.arg1;
            this.freeToDBIdList.remove(Integer.valueOf(i2));
            this.agent.removeInfo(i2);
            Util.d(TAG, "remove info " + i2);
            return true;
        }
        if (i == -2) {
            int i3 = message.arg1;
            this.freeToDBIdList.remove(Integer.valueOf(i3));
            Util.d(TAG, "remove free bunch id " + i3);
            return true;
        }
        if (i == -1) {
            List list = (List) message.obj;
            this.freeToDBIdList.removeAll(list);
            Util.d(TAG, "remove free bunch ids " + list);
            return true;
        }
        if (i == 0) {
            List<Integer> list2 = (List) message.obj;
            try {
                this.agent.syncCacheToDB(list2);
                this.freeToDBIdList.addAll(list2);
                Util.d(TAG, "sync bunch info with ids: " + list2);
                return true;
            } catch (IOException unused) {
                Util.w(TAG, "sync info to db failed for ids: " + list2);
                return true;
            }
        }
        int i4 = message.what;
        try {
            this.agent.syncCacheToDB(i4);
            this.freeToDBIdList.add(Integer.valueOf(i4));
            Util.d(TAG, "sync info with id: " + i4);
            return true;
        } catch (IOException unused2) {
            Util.w(TAG, "sync cache to db failed for id: " + i4);
            return true;
        }
    }
}
