package com.fendasz.moku.liulishuo.okdownload.core.breakpoint;

import android.util.SparseArray;
import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import com.fendasz.moku.liulishuo.okdownload.core.IdentifiedTask;
import com.fendasz.moku.liulishuo.okdownload.core.cause.EndCause;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class BreakpointStoreOnCache implements DownloadStore {
    public static final int FIRST_ID = 1;
    private final List<Integer> fileDirtyList;
    private final KeyToIdMap keyToIdMap;
    private final HashMap<String, String> responseFilenameMap;
    private final List<Integer> sortedOccupiedIds;
    private final SparseArray<BreakpointInfo> storedInfos;
    private final SparseArray<IdentifiedTask> unStoredTasks;

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.DownloadStore
    public BreakpointInfo getAfterCompleted(int i) {
        return null;
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        return true;
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.DownloadStore
    public void onTaskStart(int i) {
    }

    public BreakpointStoreOnCache() {
        this(new SparseArray(), new ArrayList(), new HashMap());
    }

    BreakpointStoreOnCache(SparseArray<BreakpointInfo> sparseArray, List<Integer> list, HashMap<String, String> map, SparseArray<IdentifiedTask> sparseArray2, List<Integer> list2, KeyToIdMap keyToIdMap) {
        this.unStoredTasks = sparseArray2;
        this.fileDirtyList = list;
        this.storedInfos = sparseArray;
        this.responseFilenameMap = map;
        this.sortedOccupiedIds = list2;
        this.keyToIdMap = keyToIdMap;
    }

    public BreakpointStoreOnCache(SparseArray<BreakpointInfo> sparseArray, List<Integer> list, HashMap<String, String> map) {
        this.unStoredTasks = new SparseArray<>();
        this.storedInfos = sparseArray;
        this.fileDirtyList = list;
        this.responseFilenameMap = map;
        this.keyToIdMap = new KeyToIdMap();
        int size = sparseArray.size();
        this.sortedOccupiedIds = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.sortedOccupiedIds.add(Integer.valueOf(sparseArray.valueAt(i).id));
        }
        Collections.sort(this.sortedOccupiedIds);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public BreakpointInfo get(int i) {
        return this.storedInfos.get(i);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public BreakpointInfo createAndInsert(DownloadTask downloadTask) {
        int id = downloadTask.getId();
        BreakpointInfo breakpointInfo = new BreakpointInfo(id, downloadTask.getUrl(), downloadTask.getParentFile(), downloadTask.getFilename());
        synchronized (this) {
            this.storedInfos.put(id, breakpointInfo);
            this.unStoredTasks.remove(id);
        }
        return breakpointInfo;
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(BreakpointInfo breakpointInfo, int i, long j) throws IOException {
        BreakpointInfo breakpointInfo2 = this.storedInfos.get(breakpointInfo.id);
        if (breakpointInfo != breakpointInfo2) {
            throw new IOException("Info not on store!");
        }
        breakpointInfo2.getBlock(i).increaseCurrentOffset(j);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public boolean update(BreakpointInfo breakpointInfo) {
        String filename = breakpointInfo.getFilename();
        if (breakpointInfo.isTaskOnlyProvidedParentPath() && filename != null) {
            this.responseFilenameMap.put(breakpointInfo.getUrl(), filename);
        }
        BreakpointInfo breakpointInfo2 = this.storedInfos.get(breakpointInfo.id);
        if (breakpointInfo2 == null) {
            return false;
        }
        if (breakpointInfo2 == breakpointInfo) {
            return true;
        }
        synchronized (this) {
            this.storedInfos.put(breakpointInfo.id, breakpointInfo.copy());
        }
        return true;
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.DownloadStore
    public void onTaskEnd(int i, EndCause endCause, Exception exc) {
        if (endCause == EndCause.COMPLETED) {
            remove(i);
        }
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.DownloadStore
    public boolean markFileDirty(int i) {
        if (this.fileDirtyList.contains(Integer.valueOf(i))) {
            return false;
        }
        synchronized (this.fileDirtyList) {
            if (this.fileDirtyList.contains(Integer.valueOf(i))) {
                return false;
            }
            this.fileDirtyList.add(Integer.valueOf(i));
            return true;
        }
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.DownloadStore
    public boolean markFileClear(int i) {
        boolean zRemove;
        synchronized (this.fileDirtyList) {
            zRemove = this.fileDirtyList.remove(Integer.valueOf(i));
        }
        return zRemove;
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public synchronized void remove(int i) {
        this.storedInfos.remove(i);
        if (this.unStoredTasks.get(i) == null) {
            this.sortedOccupiedIds.remove(Integer.valueOf(i));
        }
        this.keyToIdMap.remove(i);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public synchronized int findOrCreateId(DownloadTask downloadTask) {
        Integer num = this.keyToIdMap.get(downloadTask);
        if (num != null) {
            return num.intValue();
        }
        int size = this.storedInfos.size();
        for (int i = 0; i < size; i++) {
            BreakpointInfo breakpointInfoValueAt = this.storedInfos.valueAt(i);
            if (breakpointInfoValueAt != null && breakpointInfoValueAt.isSameFrom(downloadTask)) {
                return breakpointInfoValueAt.id;
            }
        }
        int size2 = this.unStoredTasks.size();
        for (int i2 = 0; i2 < size2; i2++) {
            IdentifiedTask identifiedTaskValueAt = this.unStoredTasks.valueAt(i2);
            if (identifiedTaskValueAt != null && identifiedTaskValueAt.compareIgnoreId(downloadTask)) {
                return identifiedTaskValueAt.getId();
            }
        }
        int iAllocateId = allocateId();
        this.unStoredTasks.put(iAllocateId, downloadTask.mock(iAllocateId));
        this.keyToIdMap.add(downloadTask, iAllocateId);
        return iAllocateId;
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public BreakpointInfo findAnotherInfoFromCompare(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        SparseArray<BreakpointInfo> sparseArrayClone;
        synchronized (this) {
            sparseArrayClone = this.storedInfos.clone();
        }
        int size = sparseArrayClone.size();
        for (int i = 0; i < size; i++) {
            BreakpointInfo breakpointInfoValueAt = sparseArrayClone.valueAt(i);
            if (breakpointInfoValueAt != breakpointInfo && breakpointInfoValueAt.isSameFrom(downloadTask)) {
                return breakpointInfoValueAt;
            }
        }
        return null;
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int i) {
        return this.fileDirtyList.contains(Integer.valueOf(i));
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public String getResponseFilename(String str) {
        return this.responseFilenameMap.get(str);
    }

    synchronized int allocateId() {
        int iIntValue;
        int i = 0;
        int size = 0;
        int i2 = 0;
        while (true) {
            iIntValue = 1;
            if (size >= this.sortedOccupiedIds.size()) {
                size = 0;
                break;
            }
            Integer num = this.sortedOccupiedIds.get(size);
            if (num == null) {
                i = i2 + 1;
                break;
            }
            int iIntValue2 = num.intValue();
            if (i2 != 0) {
                int i3 = i2 + 1;
                if (iIntValue2 != i3) {
                    i = i3;
                    break;
                }
                size++;
                i2 = iIntValue2;
            } else {
                if (iIntValue2 != 1) {
                    size = 0;
                    i = 1;
                    break;
                }
                size++;
                i2 = iIntValue2;
            }
        }
        if (i != 0) {
            iIntValue = i;
        } else if (!this.sortedOccupiedIds.isEmpty()) {
            List<Integer> list = this.sortedOccupiedIds;
            iIntValue = 1 + list.get(list.size() - 1).intValue();
            size = this.sortedOccupiedIds.size();
        }
        this.sortedOccupiedIds.add(size, Integer.valueOf(iIntValue));
        return iIntValue;
    }
}
