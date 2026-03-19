package com.sigmob.sdk.downloader.core.breakpoint;

import android.database.Cursor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    private final int a;
    private final long b;
    private final long c;
    private final long d;

    public b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("breakpoint_id");
        this.a = columnIndex >= 0 ? cursor.getInt(columnIndex) : 0;
        this.b = cursor.getColumnIndex("start_offset") >= 0 ? cursor.getInt(r0) : 0L;
        this.c = cursor.getColumnIndex("content_length") >= 0 ? cursor.getInt(r0) : 0L;
        this.d = cursor.getColumnIndex("current_offset") >= 0 ? cursor.getInt(r0) : 0L;
    }

    public int a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public a e() {
        return new a(this.b, this.c, this.d);
    }
}
