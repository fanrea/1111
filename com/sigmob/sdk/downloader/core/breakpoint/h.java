package com.sigmob.sdk.downloader.core.breakpoint;

import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h implements j {
    public static final int a = 1;
    private final SparseArray<c> b;
    private final HashMap<String, String> c;
    private final k d;
    private final SparseArray<com.sigmob.sdk.downloader.core.a> e;
    private final List<Integer> f;
    private final List<Integer> g;

    public h() {
        this(new SparseArray(), new ArrayList(), new HashMap());
    }

    public h(SparseArray<c> storedInfos, List<Integer> fileDirtyList, HashMap<String, String> responseFilenameMap) {
        this.e = new SparseArray<>();
        this.b = storedInfos;
        this.g = fileDirtyList;
        this.c = responseFilenameMap;
        this.d = new k();
        int size = storedInfos.size();
        this.f = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.f.add(Integer.valueOf(storedInfos.valueAt(i).a));
        }
        Collections.sort(this.f);
    }

    h(SparseArray<c> storedInfos, List<Integer> fileDirtyList, HashMap<String, String> responseFilenameMap, SparseArray<com.sigmob.sdk.downloader.core.a> unStoredTasks, List<Integer> sortedOccupiedIds, k keyToIdMap) {
        this.e = unStoredTasks;
        this.g = fileDirtyList;
        this.b = storedInfos;
        this.c = responseFilenameMap;
        this.f = sortedOccupiedIds;
        this.d = keyToIdMap;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(int id) {
        return this.b.get(id);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f task) {
        int iC = task.c();
        c cVar = new c(iC, task.i(), task.l(), task.d());
        synchronized (this) {
            this.b.put(iC, cVar);
            this.e.remove(iC);
        }
        return cVar;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f task, c ignored) {
        SparseArray<c> sparseArrayClone;
        synchronized (this) {
            sparseArrayClone = this.b.clone();
        }
        int size = sparseArrayClone.size();
        for (int i = 0; i < size; i++) {
            c cVarValueAt = sparseArrayClone.valueAt(i);
            if (cVarValueAt != ignored && cVarValueAt.a(task)) {
                return cVarValueAt;
            }
        }
        return null;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public String a(String url) {
        return this.c.get(url);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(int id, com.sigmob.sdk.downloader.core.cause.a cause, Exception exception) {
        if (cause == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
            b(id);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(c info, int blockIndex, long increaseLength) throws IOException {
        c cVar = this.b.get(info.a);
        if (info != cVar) {
            throw new IOException("Info not on store!");
        }
        cVar.b(blockIndex).a(increaseLength);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a() {
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a(c breakpointInfo) {
        String strM = breakpointInfo.m();
        if (breakpointInfo.d() && strM != null) {
            this.c.put(breakpointInfo.l(), strM);
        }
        c cVar = this.b.get(breakpointInfo.a);
        if (cVar == null) {
            return false;
        }
        if (cVar == breakpointInfo) {
            return true;
        }
        synchronized (this) {
            this.b.put(breakpointInfo.a, breakpointInfo.p());
        }
        return true;
    }

    synchronized int b() {
        int iIntValue;
        int i = 0;
        int size = 0;
        int i2 = 0;
        while (true) {
            iIntValue = 1;
            if (size >= this.f.size()) {
                size = 0;
                break;
            }
            Integer num = this.f.get(size);
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
        } else if (!this.f.isEmpty()) {
            List<Integer> list = this.f;
            iIntValue = 1 + list.get(list.size() - 1).intValue();
            size = this.f.size();
        }
        this.f.add(size, Integer.valueOf(iIntValue));
        return iIntValue;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public synchronized int b(com.sigmob.sdk.downloader.f task) {
        Integer numA = this.d.a(task);
        if (numA != null) {
            return numA.intValue();
        }
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            c cVarValueAt = this.b.valueAt(i);
            if (cVarValueAt != null && cVarValueAt.a(task)) {
                return cVarValueAt.a;
            }
        }
        int size2 = this.e.size();
        for (int i2 = 0; i2 < size2; i2++) {
            com.sigmob.sdk.downloader.core.a aVarValueAt = this.e.valueAt(i2);
            if (aVarValueAt != null && aVarValueAt.a(task)) {
                return aVarValueAt.c();
            }
        }
        int iB = b();
        this.e.put(iB, task.d(iB));
        this.d.a(task, iB);
        return iB;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public synchronized void b(int id) {
        this.b.remove(id);
        if (this.e.get(id) == null) {
            this.f.remove(Integer.valueOf(id));
        }
        this.d.a(id);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean c(int id) {
        return this.g.contains(Integer.valueOf(id));
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void d(int id) {
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public c e(int id) {
        return null;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean f(int id) {
        if (this.g.contains(Integer.valueOf(id))) {
            return false;
        }
        synchronized (this.g) {
            if (this.g.contains(Integer.valueOf(id))) {
                return false;
            }
            this.g.add(Integer.valueOf(id));
            return true;
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean g(int id) {
        boolean zRemove;
        synchronized (this.g) {
            zRemove = this.g.remove(Integer.valueOf(id));
        }
        return zRemove;
    }
}
