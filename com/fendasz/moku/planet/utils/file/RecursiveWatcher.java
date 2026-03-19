package com.fendasz.moku.planet.utils.file;

import com.fendasz.moku.planet.utils.Md5Utils;
import com.fendasz.moku.planet.utils.file.RecursiveFileObserver;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class RecursiveWatcher {
    private static RecursiveWatcher mInstance;
    private RecursiveFileObserver.OnFileObserverListener onFileObserverListener;
    private Map<String, String> pathMap = new HashMap();

    private RecursiveWatcher() {
    }

    public static RecursiveWatcher getInstance() {
        RecursiveWatcher recursiveWatcher;
        synchronized (RecursiveWatcher.class) {
            if (mInstance == null) {
                mInstance = new RecursiveWatcher();
            }
            recursiveWatcher = mInstance;
        }
        return recursiveWatcher;
    }

    public void watcherPath(String str) {
        String pathKey = getPathKey(str);
        if (this.pathMap.containsKey(pathKey)) {
            return;
        }
        this.pathMap.put(pathKey, str);
        new RecursiveFileObserver(str).startWatcher();
    }

    public RecursiveFileObserver.OnFileObserverListener getOnFileObserverListener() {
        return this.onFileObserverListener;
    }

    public void setOnFileObserverListener(RecursiveFileObserver.OnFileObserverListener onFileObserverListener) {
        this.onFileObserverListener = onFileObserverListener;
    }

    private static String getPathKey(String str) {
        return Md5Utils.getMD5String(str);
    }
}
