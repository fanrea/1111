package com.fendasz.moku.liulishuo.okdownload.core.breakpoint;

import android.util.SparseArray;
import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KeyToIdMap {
    private final SparseArray<String> idToKeyMap;
    private final HashMap<String, Integer> keyToIdMap;

    KeyToIdMap() {
        this(new HashMap(), new SparseArray());
    }

    KeyToIdMap(HashMap<String, Integer> map, SparseArray<String> sparseArray) {
        this.keyToIdMap = map;
        this.idToKeyMap = sparseArray;
    }

    public Integer get(DownloadTask downloadTask) {
        Integer num = this.keyToIdMap.get(generateKey(downloadTask));
        if (num != null) {
            return num;
        }
        return null;
    }

    public void remove(int i) {
        String str = this.idToKeyMap.get(i);
        if (str != null) {
            this.keyToIdMap.remove(str);
            this.idToKeyMap.remove(i);
        }
    }

    public void add(DownloadTask downloadTask, int i) {
        String strGenerateKey = generateKey(downloadTask);
        this.keyToIdMap.put(strGenerateKey, Integer.valueOf(i));
        this.idToKeyMap.put(i, strGenerateKey);
    }

    String generateKey(DownloadTask downloadTask) {
        return downloadTask.getUrl() + downloadTask.getUri() + downloadTask.getFilename();
    }
}
