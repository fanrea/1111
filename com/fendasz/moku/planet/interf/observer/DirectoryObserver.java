package com.fendasz.moku.planet.interf.observer;

import android.os.FileObserver;
import android.util.Log;
import com.kuaishou.socket.nano.SocketMessages;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DirectoryObserver extends FileObserver {
    private static final String TAG = "DirectoryObserver==>";
    private String directoryPath;
    private DirectoryChangeListener listener;

    public interface DirectoryChangeListener {
        void onDirectoryChanged(String str, int i, String str2);
    }

    public DirectoryObserver(String str) {
        super(str, SocketMessages.PayloadType.SC_LIVE_GIFT_OUTSIDE_MESSAGE);
        this.directoryPath = str;
    }

    public void setListener(DirectoryChangeListener directoryChangeListener) {
        this.listener = directoryChangeListener;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        Log.d(TAG, "onEvent_event=>" + i + ",path=>" + str);
        DirectoryChangeListener directoryChangeListener = this.listener;
        if (directoryChangeListener != null) {
            directoryChangeListener.onDirectoryChanged(this.directoryPath, i, str);
        }
    }
}
