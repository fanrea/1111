package com.fendasz.moku.liulishuo.okdownload.core.breakpoint;

import android.database.Cursor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class BlockInfoRow {
    private final int breakpointId;
    private final long contentLength;
    private final long currentOffset;
    private final long startOffset;

    public BlockInfoRow(Cursor cursor) {
        this.breakpointId = cursor.getInt(cursor.getColumnIndex("breakpoint_id"));
        this.startOffset = cursor.getInt(cursor.getColumnIndex("start_offset"));
        this.contentLength = cursor.getInt(cursor.getColumnIndex("content_length"));
        this.currentOffset = cursor.getInt(cursor.getColumnIndex("current_offset"));
    }

    public int getBreakpointId() {
        return this.breakpointId;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public long getCurrentOffset() {
        return this.currentOffset;
    }

    public BlockInfo toInfo() {
        return new BlockInfo(this.startOffset, this.contentLength, this.currentOffset);
    }
}
