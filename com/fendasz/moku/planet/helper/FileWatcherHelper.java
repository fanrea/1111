package com.fendasz.moku.planet.helper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FileWatcherHelper {
    private static FileWatcherHelper mInstance;

    public static FileWatcherHelper getInstance() {
        FileWatcherHelper fileWatcherHelper;
        synchronized (FileWatcherHelper.class) {
            if (mInstance == null) {
                mInstance = new FileWatcherHelper();
            }
            fileWatcherHelper = mInstance;
        }
        return fileWatcherHelper;
    }
}
