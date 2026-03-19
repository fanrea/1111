package com.fendasz.moku.liulishuo.okdownload.core.breakpoint;

import android.database.sqlite.SQLiteDatabase;
import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import com.fendasz.moku.liulishuo.okdownload.OkDownload;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.RemitSyncExecutor;
import com.fendasz.moku.liulishuo.okdownload.core.cause.EndCause;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class RemitStoreOnSQLite implements RemitSyncExecutor.RemitAgent, DownloadStore {
    private static final String TAG = "RemitStoreOnSQLite";
    private final BreakpointStoreOnSQLite onSQLiteWrapper;
    private final RemitSyncToDBHelper remitHelper;
    private final BreakpointSQLiteHelper sqLiteHelper;
    private final DownloadStore sqliteCache;

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.DownloadStore
    public BreakpointInfo getAfterCompleted(int i) {
        return null;
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        return false;
    }

    RemitStoreOnSQLite(BreakpointStoreOnSQLite breakpointStoreOnSQLite) {
        this.remitHelper = new RemitSyncToDBHelper(this);
        this.onSQLiteWrapper = breakpointStoreOnSQLite;
        this.sqliteCache = breakpointStoreOnSQLite.onCache;
        this.sqLiteHelper = breakpointStoreOnSQLite.helper;
    }

    RemitStoreOnSQLite(RemitSyncToDBHelper remitSyncToDBHelper, BreakpointStoreOnSQLite breakpointStoreOnSQLite, DownloadStore downloadStore, BreakpointSQLiteHelper breakpointSQLiteHelper) {
        this.remitHelper = remitSyncToDBHelper;
        this.onSQLiteWrapper = breakpointStoreOnSQLite;
        this.sqliteCache = downloadStore;
        this.sqLiteHelper = breakpointSQLiteHelper;
    }

    public static void setRemitToDBDelayMillis(int i) {
        BreakpointStore breakpointStore = OkDownload.with().breakpointStore();
        if (!(breakpointStore instanceof RemitStoreOnSQLite)) {
            throw new IllegalStateException("The current store is " + breakpointStore + " not RemitStoreOnSQLite!");
        }
        ((RemitStoreOnSQLite) breakpointStore).remitHelper.delayMillis = Math.max(0, i);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public BreakpointInfo get(int i) {
        return this.onSQLiteWrapper.get(i);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public BreakpointInfo createAndInsert(DownloadTask downloadTask) throws IOException {
        return this.remitHelper.isNotFreeToDatabase(downloadTask.getId()) ? this.sqliteCache.createAndInsert(downloadTask) : this.onSQLiteWrapper.createAndInsert(downloadTask);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.DownloadStore
    public void onTaskStart(int i) {
        this.onSQLiteWrapper.onTaskStart(i);
        this.remitHelper.onTaskStart(i);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(BreakpointInfo breakpointInfo, int i, long j) throws IOException {
        if (this.remitHelper.isNotFreeToDatabase(breakpointInfo.getId())) {
            this.sqliteCache.onSyncToFilesystemSuccess(breakpointInfo, i, j);
        } else {
            this.onSQLiteWrapper.onSyncToFilesystemSuccess(breakpointInfo, i, j);
        }
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public boolean update(BreakpointInfo breakpointInfo) throws IOException {
        return this.remitHelper.isNotFreeToDatabase(breakpointInfo.getId()) ? this.sqliteCache.update(breakpointInfo) : this.onSQLiteWrapper.update(breakpointInfo);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.DownloadStore
    public void onTaskEnd(int i, EndCause endCause, Exception exc) {
        this.sqliteCache.onTaskEnd(i, endCause, exc);
        if (endCause == EndCause.COMPLETED) {
            this.remitHelper.discard(i);
        } else {
            this.remitHelper.endAndEnsureToDB(i);
        }
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.DownloadStore
    public boolean markFileDirty(int i) {
        return this.onSQLiteWrapper.markFileDirty(i);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.DownloadStore
    public boolean markFileClear(int i) {
        return this.onSQLiteWrapper.markFileClear(i);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public void remove(int i) {
        this.sqliteCache.remove(i);
        this.remitHelper.discard(i);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public int findOrCreateId(DownloadTask downloadTask) {
        return this.onSQLiteWrapper.findOrCreateId(downloadTask);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public BreakpointInfo findAnotherInfoFromCompare(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        return this.onSQLiteWrapper.findAnotherInfoFromCompare(downloadTask, breakpointInfo);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int i) {
        return this.onSQLiteWrapper.isFileDirty(i);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore
    public String getResponseFilename(String str) {
        return this.onSQLiteWrapper.getResponseFilename(str);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.RemitSyncExecutor.RemitAgent
    public void syncCacheToDB(List<Integer> list) throws IOException {
        SQLiteDatabase writableDatabase = this.sqLiteHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                syncCacheToDB(it.next().intValue());
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.RemitSyncExecutor.RemitAgent
    public void syncCacheToDB(int i) throws IOException {
        this.sqLiteHelper.removeInfo(i);
        BreakpointInfo breakpointInfo = this.sqliteCache.get(i);
        if (breakpointInfo == null || breakpointInfo.getFilename() == null || breakpointInfo.getTotalOffset() <= 0) {
            return;
        }
        this.sqLiteHelper.insert(breakpointInfo);
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.breakpoint.RemitSyncExecutor.RemitAgent
    public void removeInfo(int i) {
        this.sqLiteHelper.removeInfo(i);
    }
}
