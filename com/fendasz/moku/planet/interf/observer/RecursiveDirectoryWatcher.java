package com.fendasz.moku.planet.interf.observer;

import android.util.Log;
import com.fendasz.moku.planet.interf.observer.DirectoryObserver;
import com.fendasz.moku.planet.utils.FileUtils;
import com.fendasz.moku.planet.utils.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class RecursiveDirectoryWatcher implements DirectoryObserver.DirectoryChangeListener {
    private static final String TAG = "RecursiveDirectoryWatcher==>";
    private OnDirectoryWatcherListener onDirectoryWatcherListener;
    private ExecutorService executor = Executors.newFixedThreadPool(5);
    private List<String> watcherPathList = new ArrayList();
    private TreeMap<String, DirectoryObserver> directoryObserverMap = new TreeMap<>();

    public interface OnDirectoryWatcherListener {
        void onAcess(String str, String str2);

        void onCreate(String str, String str2);

        void onDelete(String str, String str2, int i);

        void onModify(String str, String str2);
    }

    public RecursiveDirectoryWatcher(String str) {
        try {
            initWatcher(str);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void watcher() {
        Log.d(TAG, "watcher");
        executeWatching();
    }

    private void executeWatching() {
        Log.d(TAG, "executeWatching");
        this.executor.execute(new Runnable() { // from class: com.fendasz.moku.planet.interf.observer.RecursiveDirectoryWatcher.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (RecursiveDirectoryWatcher.this.directoryObserverMap) {
                    RecursiveDirectoryWatcher.this.directoryObserverMap = new TreeMap();
                    if (RecursiveDirectoryWatcher.this.watcherPathList != null && RecursiveDirectoryWatcher.this.watcherPathList.size() > 0) {
                        Log.d(RecursiveDirectoryWatcher.TAG, "executeWatching start");
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        for (String str : RecursiveDirectoryWatcher.this.watcherPathList) {
                            DirectoryObserver directoryObserver = new DirectoryObserver(str);
                            directoryObserver.setListener(RecursiveDirectoryWatcher.this);
                            if (RecursiveDirectoryWatcher.this.directoryObserverMap != null && str != null) {
                                LogUtils.logD(RecursiveDirectoryWatcher.TAG, "executeWatching put=>" + str);
                                RecursiveDirectoryWatcher.this.directoryObserverMap.put(str, directoryObserver);
                                directoryObserver.startWatching();
                            }
                        }
                        Log.d(RecursiveDirectoryWatcher.TAG, "executeWatching end,use time=>" + (System.currentTimeMillis() - jCurrentTimeMillis));
                    }
                }
            }
        });
    }

    private void initWatcher(String str) throws IllegalAccessException {
        Log.d(TAG, "initWatcher");
        File file = new File(str);
        if (file.isFile()) {
            throw new IllegalAccessException("the directory is File,not Directory");
        }
        this.watcherPathList.add(file.getAbsolutePath());
        Iterator<File> it = FileUtils.getAllSubdirectories(str).iterator();
        while (it.hasNext()) {
            this.watcherPathList.add(it.next().getAbsolutePath());
        }
    }

    public void addWatcherPath(String str) throws IllegalAccessException {
        Log.d(TAG, "addWatcherPath");
        File file = new File(str);
        if (file.isFile()) {
            throw new IllegalAccessException("the directory is File,not Directory");
        }
        this.watcherPathList.add(file.getAbsolutePath());
        Iterator<File> it = FileUtils.getAllSubdirectories(str).iterator();
        while (it.hasNext()) {
            this.watcherPathList.add(it.next().getAbsolutePath());
        }
    }

    @Override // com.fendasz.moku.planet.interf.observer.DirectoryObserver.DirectoryChangeListener
    public void onDirectoryChanged(String str, int i, String str2) {
        Log.d(TAG, "onDirectoryChanged_path=>" + str + ",event=>" + i + ",filename=>" + str2);
        File file = new File(str);
        OnDirectoryWatcherListener onDirectoryWatcherListener = this.onDirectoryWatcherListener;
        if (onDirectoryWatcherListener != null) {
            if (i == 1) {
                onDirectoryWatcherListener.onAcess(file.getAbsolutePath(), file.getName());
                return;
            }
            if (i == 2) {
                onDirectoryWatcherListener.onModify(file.getAbsolutePath(), file.getName());
                return;
            }
            if (i == 256) {
                onDirectoryWatcherListener.onCreate(file.getAbsolutePath(), file.getName());
            } else if (i == 512 || i == 1024) {
                onDirectoryWatcherListener.onDelete(file.getAbsolutePath(), file.getName(), i);
            }
        }
    }

    public void recycle() {
        Log.d(TAG, "recycle");
        stopAllWatching();
        this.directoryObserverMap = null;
        this.onDirectoryWatcherListener = null;
        this.executor.shutdown();
    }

    public void stopAllWatching() {
        Log.d(TAG, "stopAllWatching");
        TreeMap<String, DirectoryObserver> treeMap = this.directoryObserverMap;
        if (treeMap != null) {
            Iterator<Map.Entry<String, DirectoryObserver>> it = treeMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().stopWatching();
            }
            this.directoryObserverMap.clear();
        }
    }

    public void stopWatching(String str) {
        Log.d(TAG, "stopWatching");
        if (this.directoryObserverMap != null) {
            File file = new File(str);
            DirectoryObserver directoryObserver = this.directoryObserverMap.get(file.getAbsolutePath());
            if (directoryObserver != null) {
                directoryObserver.stopWatching();
                this.directoryObserverMap.remove(file.getAbsolutePath());
            }
        }
    }

    public void setOnDirectoryWatcherListener(OnDirectoryWatcherListener onDirectoryWatcherListener) {
        this.onDirectoryWatcherListener = onDirectoryWatcherListener;
    }

    public OnDirectoryWatcherListener getOnDirectoryWatcherListener() {
        return this.onDirectoryWatcherListener;
    }
}
