package com.luck.picture.lib.loader;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.core.location.LocationRequestCompat;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class IBridgeMediaLoader {
    protected static final String COLUMN_COUNT = "count";
    protected static final String COLUMN_DURATION = "duration";
    protected static final String DISTINCT_BUCKET_Id = "DISTINCT bucket_id";
    protected static final String GROUP_BY_BUCKET_Id = " GROUP BY (bucket_id";
    protected static final int MAX_SORT_SIZE = 60;
    protected static final String NOT_GIF = " AND (mime_type!='image/gif')";
    protected static final String ORDER_BY = "date_modified DESC";
    protected static final String TAG = "IBridgeMediaLoader";
    protected final SelectorConfig mConfig;
    private final Context mContext;
    protected static final Uri QUERY_URI = MediaStore.Files.getContentUri("external");
    protected static final String COLUMN_BUCKET_DISPLAY_NAME = "bucket_display_name";
    protected static final String COLUMN_BUCKET_ID = "bucket_id";
    protected static final String COLUMN_ORIENTATION = "orientation";
    protected static final String[] PROJECTION = {"_id", "_data", "mime_type", "width", "height", "duration", "_size", COLUMN_BUCKET_DISPLAY_NAME, "_display_name", COLUMN_BUCKET_ID, "date_added", COLUMN_ORIENTATION};
    protected static final String[] ALL_PROJECTION = {"_id", "_data", "mime_type", "width", "height", "duration", "_size", COLUMN_BUCKET_DISPLAY_NAME, "_display_name", COLUMN_BUCKET_ID, "date_added", COLUMN_ORIENTATION, "COUNT(*) AS count"};

    public abstract String getAlbumFirstCover(long j);

    protected abstract String getSelection();

    protected abstract String[] getSelectionArgs();

    protected abstract String getSortOrder();

    public abstract void loadAllAlbum(OnQueryAllAlbumListener<LocalMediaFolder> onQueryAllAlbumListener);

    public abstract void loadOnlyInAppDirAllMedia(OnQueryAlbumListener<LocalMediaFolder> onQueryAlbumListener);

    public abstract void loadPageMediaData(long j, int i, int i2, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener);

    protected abstract LocalMedia parseLocalMedia(Cursor cursor, boolean z);

    public IBridgeMediaLoader(Context context, SelectorConfig selectorConfig) {
        this.mContext = context;
        this.mConfig = selectorConfig;
    }

    protected Context getContext() {
        return this.mContext;
    }

    protected SelectorConfig getConfig() {
        return this.mConfig;
    }

    protected String getDurationCondition() {
        return String.format(Locale.CHINA, "%d <%s duration and duration <= %d", Long.valueOf(Math.max(0L, getConfig().filterVideoMinSecond)), "=", Long.valueOf(getConfig().filterVideoMaxSecond == 0 ? LocationRequestCompat.PASSIVE_INTERVAL : getConfig().filterVideoMaxSecond));
    }

    protected String getFileSizeCondition() {
        return String.format(Locale.CHINA, "%d <%s _size and _size <= %d", Long.valueOf(Math.max(0L, getConfig().filterMinFileSize)), "=", Long.valueOf(getConfig().filterMaxFileSize == 0 ? LocationRequestCompat.PASSIVE_INTERVAL : getConfig().filterMaxFileSize));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String getQueryMimeCondition() {
        /*
            r10 = this;
            com.luck.picture.lib.config.SelectorConfig r0 = r10.getConfig()
            java.util.List<java.lang.String> r0 = r0.queryOnlyList
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>(r0)
            java.util.Iterator r0 = r1.iterator()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = -1
        L15:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L9e
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L28
            goto L15
        L28:
            com.luck.picture.lib.config.SelectorConfig r5 = r10.getConfig()
            int r5 = r5.chooseMode
            int r6 = com.luck.picture.lib.config.SelectMimeType.ofVideo()
            java.lang.String r7 = "audio"
            java.lang.String r8 = "image"
            if (r5 != r6) goto L45
            boolean r5 = r4.startsWith(r8)
            if (r5 != 0) goto L15
            boolean r5 = r4.startsWith(r7)
            if (r5 == 0) goto L7a
            goto L15
        L45:
            com.luck.picture.lib.config.SelectorConfig r5 = r10.getConfig()
            int r5 = r5.chooseMode
            int r6 = com.luck.picture.lib.config.SelectMimeType.ofImage()
            java.lang.String r9 = "video"
            if (r5 != r6) goto L61
            boolean r5 = r4.startsWith(r7)
            if (r5 != 0) goto L15
            boolean r5 = r4.startsWith(r9)
            if (r5 == 0) goto L7a
            goto L15
        L61:
            com.luck.picture.lib.config.SelectorConfig r5 = r10.getConfig()
            int r5 = r5.chooseMode
            int r6 = com.luck.picture.lib.config.SelectMimeType.ofAudio()
            if (r5 != r6) goto L7a
            boolean r5 = r4.startsWith(r9)
            if (r5 != 0) goto L15
            boolean r5 = r4.startsWith(r8)
            if (r5 == 0) goto L7a
            goto L15
        L7a:
            int r3 = r3 + 1
            if (r3 != 0) goto L81
            java.lang.String r5 = " AND "
            goto L83
        L81:
            java.lang.String r5 = " OR "
        L83:
            java.lang.StringBuilder r5 = r2.append(r5)
            java.lang.String r6 = "mime_type"
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = "='"
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r5 = "'"
            r4.append(r5)
            goto L15
        L9e:
            com.luck.picture.lib.config.SelectorConfig r0 = r10.getConfig()
            int r0 = r0.chooseMode
            int r3 = com.luck.picture.lib.config.SelectMimeType.ofVideo()
            if (r0 == r3) goto Lc1
            com.luck.picture.lib.config.SelectorConfig r0 = r10.getConfig()
            boolean r0 = r0.isGif
            if (r0 != 0) goto Lc1
            java.lang.String r0 = com.luck.picture.lib.config.PictureMimeType.ofGIF()
            boolean r0 = r1.contains(r0)
            if (r0 != 0) goto Lc1
            java.lang.String r0 = " AND (mime_type!='image/gif')"
            r2.append(r0)
        Lc1:
            java.lang.String r0 = r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.loader.IBridgeMediaLoader.getQueryMimeCondition():java.lang.String");
    }
}
