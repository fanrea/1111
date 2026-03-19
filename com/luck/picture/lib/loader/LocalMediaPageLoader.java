package com.luck.picture.lib.loader;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.entity.MediaData;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.PictureFileUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.SortUtils;
import com.luck.picture.lib.utils.ValueOf;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class LocalMediaPageLoader extends IBridgeMediaLoader {
    public LocalMediaPageLoader(Context context, SelectorConfig selectorConfig) {
        super(context, selectorConfig);
    }

    private String getSelectionArgsForAllMediaCondition(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append("media_type").append("=?").append(str3).append(" OR ").append("media_type").append("=? AND ").append(str).append(") AND ").append(str2);
        if (isWithAllQuery()) {
            return sb.toString();
        }
        return sb.append(")").append(" GROUP BY (bucket_id").toString();
    }

    private String getSelectionArgsForImageMediaCondition(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (isWithAllQuery()) {
            return sb.append("media_type").append("=?").append(str2).append(" AND ").append(str).toString();
        }
        return sb.append("(").append("media_type").append("=?").append(str2).append(") AND ").append(str).append(")").append(" GROUP BY (bucket_id").toString();
    }

    private String getSelectionArgsForVideoMediaCondition(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (isWithAllQuery()) {
            return sb.append("media_type").append("=?").append(str2).append(" AND ").append(str).toString();
        }
        return sb.append("(").append("media_type").append("=?").append(str2).append(") AND ").append(str).append(")").append(" GROUP BY (bucket_id").toString();
    }

    private String getSelectionArgsForAudioMediaCondition(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (isWithAllQuery()) {
            return sb.append("media_type").append("=?").append(str2).append(" AND ").append(str).toString();
        }
        return sb.append("(").append("media_type").append("=?").append(str2).append(") AND ").append(str).append(")").append(" GROUP BY (bucket_id").toString();
    }

    private static String[] getSelectionArgsForPageSingleMediaType(int i, long j) {
        return j == -1 ? new String[]{String.valueOf(i)} : new String[]{String.valueOf(i), ValueOf.toString(Long.valueOf(j))};
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    public String getAlbumFirstCover(long j) throws Throwable {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery = SdkVersionUtils.isR() ? getContext().getContentResolver().query(QUERY_URI, new String[]{"_id", "mime_type", "_data"}, MediaUtils.createQueryArgsBundle(getPageSelection(j), getPageSelectionArgs(j), 1, 0, getSortOrder()), null) : getContext().getContentResolver().query(QUERY_URI, new String[]{"_id", "mime_type", "_data"}, getPageSelection(j), getPageSelectionArgs(j), getSortOrder() + " limit 1 offset 0");
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        if (!cursorQuery.moveToFirst()) {
                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                                cursorQuery.close();
                            }
                            return null;
                        }
                        String realPathUri = SdkVersionUtils.isQ() ? MediaUtils.getRealPathUri(cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id")), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("mime_type"))) : cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                        return realPathUri;
                    }
                } catch (Exception e) {
                    cursor = cursorQuery;
                    e = e;
                    try {
                        e.printStackTrace();
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    cursor2 = cursorQuery;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
        return null;
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    public void loadPageMediaData(final long j, final int i, final int i2, final OnQueryDataResultListener<LocalMedia> onQueryDataResultListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<MediaData>() { // from class: com.luck.picture.lib.loader.LocalMediaPageLoader.1
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public MediaData doInBackground() {
                ArrayList<LocalMedia> arrayListLoadInAppSandboxFile;
                Cursor cursorQuery = null;
                try {
                    try {
                        boolean z = true;
                        if (SdkVersionUtils.isR()) {
                            String pageSelection = LocalMediaPageLoader.this.getPageSelection(j);
                            String[] pageSelectionArgs = LocalMediaPageLoader.this.getPageSelectionArgs(j);
                            int i3 = i2;
                            cursorQuery = LocalMediaPageLoader.this.getContext().getContentResolver().query(IBridgeMediaLoader.QUERY_URI, IBridgeMediaLoader.PROJECTION, MediaUtils.createQueryArgsBundle(pageSelection, pageSelectionArgs, i3, (i - 1) * i3, LocalMediaPageLoader.this.getSortOrder()), null);
                        } else {
                            cursorQuery = LocalMediaPageLoader.this.getContext().getContentResolver().query(IBridgeMediaLoader.QUERY_URI, IBridgeMediaLoader.PROJECTION, LocalMediaPageLoader.this.getPageSelection(j), LocalMediaPageLoader.this.getPageSelectionArgs(j), i == -1 ? LocalMediaPageLoader.this.getSortOrder() : LocalMediaPageLoader.this.getSortOrder() + " limit " + i2 + " offset " + ((i - 1) * i2));
                        }
                        if (cursorQuery == null) {
                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                                cursorQuery.close();
                            }
                            return new MediaData();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            do {
                                LocalMedia localMedia = LocalMediaPageLoader.this.parseLocalMedia(cursorQuery, false);
                                if (localMedia != null) {
                                    arrayList.add(localMedia);
                                }
                            } while (cursorQuery.moveToNext());
                        }
                        if (j == -1 && i == 1 && (arrayListLoadInAppSandboxFile = SandboxFileLoader.loadInAppSandboxFile(LocalMediaPageLoader.this.getContext(), LocalMediaPageLoader.this.getConfig().sandboxDir)) != null) {
                            arrayList.addAll(arrayListLoadInAppSandboxFile);
                            SortUtils.sortLocalMediaAddedTime(arrayList);
                        }
                        if (cursorQuery.getCount() <= 0) {
                            z = false;
                        }
                        MediaData mediaData = new MediaData(z, arrayList);
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                        return mediaData;
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.i(IBridgeMediaLoader.TAG, "loadMedia Page Data Error: " + e.getMessage());
                        MediaData mediaData2 = new MediaData();
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                        return mediaData2;
                    }
                } catch (Throwable th) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(MediaData mediaData) {
                PictureThreadUtils.cancel(this);
                OnQueryDataResultListener onQueryDataResultListener2 = onQueryDataResultListener;
                if (onQueryDataResultListener2 != null) {
                    onQueryDataResultListener2.onComplete(mediaData.data != null ? mediaData.data : new ArrayList<>(), mediaData.isHasNextMore);
                }
            }
        });
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    public void loadOnlyInAppDirAllMedia(final OnQueryAlbumListener<LocalMediaFolder> onQueryAlbumListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<LocalMediaFolder>() { // from class: com.luck.picture.lib.loader.LocalMediaPageLoader.2
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public LocalMediaFolder doInBackground() {
                return SandboxFileLoader.loadInAppSandboxFolderFile(LocalMediaPageLoader.this.getContext(), LocalMediaPageLoader.this.getConfig().sandboxDir);
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(LocalMediaFolder localMediaFolder) {
                PictureThreadUtils.cancel(this);
                OnQueryAlbumListener onQueryAlbumListener2 = onQueryAlbumListener;
                if (onQueryAlbumListener2 != null) {
                    onQueryAlbumListener2.onComplete(localMediaFolder);
                }
            }
        });
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    public void loadAllAlbum(final OnQueryAllAlbumListener<LocalMediaFolder> onQueryAllAlbumListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<List<LocalMediaFolder>>() { // from class: com.luck.picture.lib.loader.LocalMediaPageLoader.3
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public List<LocalMediaFolder> doInBackground() {
                int folderTotalNum;
                String string;
                Context context;
                int i;
                Cursor cursorQuery = LocalMediaPageLoader.this.getContext().getContentResolver().query(IBridgeMediaLoader.QUERY_URI, LocalMediaPageLoader.this.isWithAllQuery() ? IBridgeMediaLoader.PROJECTION : IBridgeMediaLoader.ALL_PROJECTION, LocalMediaPageLoader.this.getSelection(), LocalMediaPageLoader.this.getSelectionArgs(), LocalMediaPageLoader.this.getSortOrder());
                try {
                    if (cursorQuery != null) {
                        try {
                            int count = cursorQuery.getCount();
                            ArrayList<LocalMediaFolder> arrayList = new ArrayList();
                            if (count > 0) {
                                String str = "bucket_id";
                                String str2 = "mime_type";
                                if (LocalMediaPageLoader.this.isWithAllQuery()) {
                                    HashMap map = new HashMap();
                                    HashSet hashSet = new HashSet();
                                    while (cursorQuery.moveToNext()) {
                                        if (LocalMediaPageLoader.this.getConfig().isPageSyncAsCount) {
                                            LocalMedia localMedia = LocalMediaPageLoader.this.parseLocalMedia(cursorQuery, true);
                                            if (localMedia != null) {
                                                localMedia.recycle();
                                            }
                                        }
                                        long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(str));
                                        Long l = (Long) map.get(Long.valueOf(j));
                                        map.put(Long.valueOf(j), l == null ? 1L : Long.valueOf(l.longValue() + 1));
                                        if (!hashSet.contains(Long.valueOf(j))) {
                                            LocalMediaFolder localMediaFolder = new LocalMediaFolder();
                                            localMediaFolder.setBucketId(j);
                                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("bucket_display_name"));
                                            String string3 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(str2));
                                            if (map.containsKey(Long.valueOf(j))) {
                                                long jLongValue = ((Long) map.get(Long.valueOf(j))).longValue();
                                                String str3 = str;
                                                long j2 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
                                                localMediaFolder.setFolderName(string2);
                                                localMediaFolder.setFolderTotalNum(ValueOf.toInt(Long.valueOf(jLongValue)));
                                                localMediaFolder.setFirstImagePath(MediaUtils.getRealPathUri(j2, string3));
                                                localMediaFolder.setFirstMimeType(string3);
                                                arrayList.add(localMediaFolder);
                                                hashSet.add(Long.valueOf(j));
                                                str = str3;
                                                str2 = str2;
                                            }
                                        }
                                    }
                                    folderTotalNum = 0;
                                    for (LocalMediaFolder localMediaFolder2 : arrayList) {
                                        int i2 = ValueOf.toInt(map.get(Long.valueOf(localMediaFolder2.getBucketId())));
                                        localMediaFolder2.setFolderTotalNum(i2);
                                        folderTotalNum += i2;
                                    }
                                } else {
                                    String str4 = "bucket_id";
                                    String str5 = "mime_type";
                                    cursorQuery.moveToFirst();
                                    int i3 = 0;
                                    while (true) {
                                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                                        String string5 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("bucket_display_name"));
                                        String str6 = str5;
                                        String string6 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(str6));
                                        String str7 = str4;
                                        long j3 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(str7));
                                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("count"));
                                        LocalMediaFolder localMediaFolder3 = new LocalMediaFolder();
                                        localMediaFolder3.setBucketId(j3);
                                        localMediaFolder3.setFirstImagePath(string4);
                                        localMediaFolder3.setFolderName(string5);
                                        localMediaFolder3.setFirstMimeType(string6);
                                        localMediaFolder3.setFolderTotalNum(i4);
                                        arrayList.add(localMediaFolder3);
                                        i3 += i4;
                                        if (!cursorQuery.moveToNext()) {
                                            break;
                                        }
                                        str5 = str6;
                                        str4 = str7;
                                    }
                                    folderTotalNum = i3;
                                }
                                LocalMediaFolder localMediaFolder4 = new LocalMediaFolder();
                                LocalMediaFolder localMediaFolderLoadInAppSandboxFolderFile = SandboxFileLoader.loadInAppSandboxFolderFile(LocalMediaPageLoader.this.getContext(), LocalMediaPageLoader.this.getConfig().sandboxDir);
                                if (localMediaFolderLoadInAppSandboxFolderFile != null) {
                                    arrayList.add(localMediaFolderLoadInAppSandboxFolderFile);
                                    long jLastModified = new File(localMediaFolderLoadInAppSandboxFolderFile.getFirstImagePath()).lastModified();
                                    folderTotalNum += localMediaFolderLoadInAppSandboxFolderFile.getFolderTotalNum();
                                    localMediaFolder4.setData(new ArrayList<>());
                                    if (cursorQuery.moveToFirst()) {
                                        localMediaFolder4.setFirstImagePath(SdkVersionUtils.isQ() ? LocalMediaPageLoader.getFirstUri(cursorQuery) : LocalMediaPageLoader.getFirstUrl(cursorQuery));
                                        localMediaFolder4.setFirstMimeType(LocalMediaPageLoader.getFirstCoverMimeType(cursorQuery));
                                        if (jLastModified > (PictureMimeType.isContent(localMediaFolder4.getFirstImagePath()) ? new File(PictureFileUtils.getPath(LocalMediaPageLoader.this.getContext(), Uri.parse(localMediaFolder4.getFirstImagePath()))).lastModified() : new File(localMediaFolder4.getFirstImagePath()).lastModified())) {
                                            localMediaFolder4.setFirstImagePath(localMediaFolderLoadInAppSandboxFolderFile.getFirstImagePath());
                                            localMediaFolder4.setFirstMimeType(localMediaFolderLoadInAppSandboxFolderFile.getFirstMimeType());
                                        }
                                    }
                                } else if (cursorQuery.moveToFirst()) {
                                    localMediaFolder4.setFirstImagePath(SdkVersionUtils.isQ() ? LocalMediaPageLoader.getFirstUri(cursorQuery) : LocalMediaPageLoader.getFirstUrl(cursorQuery));
                                    localMediaFolder4.setFirstMimeType(LocalMediaPageLoader.getFirstCoverMimeType(cursorQuery));
                                }
                                if (folderTotalNum == 0) {
                                    return arrayList;
                                }
                                SortUtils.sortFolder(arrayList);
                                localMediaFolder4.setFolderTotalNum(folderTotalNum);
                                localMediaFolder4.setBucketId(-1L);
                                if (TextUtils.isEmpty(LocalMediaPageLoader.this.getConfig().defaultAlbumName)) {
                                    if (LocalMediaPageLoader.this.getConfig().chooseMode == SelectMimeType.ofAudio()) {
                                        context = LocalMediaPageLoader.this.getContext();
                                        i = R.string.ps_all_audio;
                                    } else {
                                        context = LocalMediaPageLoader.this.getContext();
                                        i = R.string.ps_camera_roll;
                                    }
                                    string = context.getString(i);
                                } else {
                                    string = LocalMediaPageLoader.this.getConfig().defaultAlbumName;
                                }
                                localMediaFolder4.setFolderName(string);
                                arrayList.add(0, localMediaFolder4);
                                if (LocalMediaPageLoader.this.getConfig().isSyncCover && LocalMediaPageLoader.this.getConfig().chooseMode == SelectMimeType.ofAll()) {
                                    LocalMediaPageLoader.this.synchronousFirstCover(arrayList);
                                }
                                if (cursorQuery != null && !cursorQuery.isClosed()) {
                                    cursorQuery.close();
                                }
                                return arrayList;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.i(IBridgeMediaLoader.TAG, "loadAllMedia Data Error: " + e.getMessage());
                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                            }
                        }
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                    } else if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return new ArrayList();
                } finally {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                }
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(List<LocalMediaFolder> list) {
                PictureThreadUtils.cancel(this);
                LocalMedia.destroyPool();
                OnQueryAllAlbumListener onQueryAllAlbumListener2 = onQueryAllAlbumListener;
                if (onQueryAllAlbumListener2 != null) {
                    onQueryAllAlbumListener2.onComplete(list);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void synchronousFirstCover(List<LocalMediaFolder> list) throws Throwable {
        for (int i = 0; i < list.size(); i++) {
            LocalMediaFolder localMediaFolder = list.get(i);
            if (localMediaFolder != null) {
                String albumFirstCover = getAlbumFirstCover(localMediaFolder.getBucketId());
                if (!TextUtils.isEmpty(albumFirstCover)) {
                    localMediaFolder.setFirstImagePath(albumFirstCover);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFirstUri(Cursor cursor) {
        return MediaUtils.getRealPathUri(cursor.getLong(cursor.getColumnIndexOrThrow("_id")), cursor.getString(cursor.getColumnIndexOrThrow("mime_type")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFirstCoverMimeType(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFirstUrl(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow("_data"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPageSelection(long j) {
        String durationCondition = getDurationCondition();
        String fileSizeCondition = getFileSizeCondition();
        String queryMimeCondition = getQueryMimeCondition();
        int i = getConfig().chooseMode;
        if (i == 0) {
            return getPageSelectionArgsForAllMediaCondition(j, queryMimeCondition, durationCondition, fileSizeCondition);
        }
        if (i == 1) {
            return getPageSelectionArgsForImageMediaCondition(j, queryMimeCondition, fileSizeCondition);
        }
        if (i == 2) {
            return getPageSelectionArgsForVideoMediaCondition(j, queryMimeCondition, durationCondition, fileSizeCondition);
        }
        if (i != 3) {
            return null;
        }
        return getPageSelectionArgsForAudioMediaCondition(j, queryMimeCondition, durationCondition, fileSizeCondition);
    }

    private static String getPageSelectionArgsForAllMediaCondition(long j, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append("media_type").append("=?").append(str).append(" OR ").append("media_type").append("=? AND ").append(str2).append(") AND ");
        if (j == -1) {
            return sb.append(str3).toString();
        }
        return sb.append("bucket_id").append("=? AND ").append(str3).toString();
    }

    private static String getPageSelectionArgsForImageMediaCondition(long j, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append("media_type").append("=?");
        if (j == -1) {
            return sb.append(str).append(") AND ").append(str2).toString();
        }
        return sb.append(str).append(") AND ").append("bucket_id").append("=? AND ").append(str2).toString();
    }

    private static String getPageSelectionArgsForVideoMediaCondition(long j, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append("media_type").append("=?").append(str).append(" AND ").append(str2).append(") AND ");
        if (j == -1) {
            return sb.append(str3).toString();
        }
        return sb.append("bucket_id").append("=? AND ").append(str3).toString();
    }

    private static String getPageSelectionArgsForAudioMediaCondition(long j, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append("media_type").append("=?").append(str).append(" AND ").append(str2).append(") AND ");
        if (j == -1) {
            return sb.append(str3).toString();
        }
        return sb.append("bucket_id").append("=? AND ").append(str3).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] getPageSelectionArgs(long j) {
        int i = getConfig().chooseMode;
        if (i == 0) {
            return j == -1 ? new String[]{String.valueOf(1), String.valueOf(3)} : new String[]{String.valueOf(1), String.valueOf(3), ValueOf.toString(Long.valueOf(j))};
        }
        if (i == 1) {
            return getSelectionArgsForPageSingleMediaType(1, j);
        }
        if (i == 2) {
            return getSelectionArgsForPageSingleMediaType(3, j);
        }
        if (i != 3) {
            return null;
        }
        return getSelectionArgsForPageSingleMediaType(2, j);
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    protected String getSelection() {
        String durationCondition = getDurationCondition();
        String fileSizeCondition = getFileSizeCondition();
        String queryMimeCondition = getQueryMimeCondition();
        int i = getConfig().chooseMode;
        if (i == 0) {
            return getSelectionArgsForAllMediaCondition(durationCondition, fileSizeCondition, queryMimeCondition);
        }
        if (i == 1) {
            return getSelectionArgsForImageMediaCondition(fileSizeCondition, queryMimeCondition);
        }
        if (i == 2) {
            return getSelectionArgsForVideoMediaCondition(durationCondition, queryMimeCondition);
        }
        if (i != 3) {
            return null;
        }
        return getSelectionArgsForAudioMediaCondition(durationCondition, queryMimeCondition);
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    protected String[] getSelectionArgs() {
        int i = getConfig().chooseMode;
        if (i == 0) {
            return new String[]{String.valueOf(1), String.valueOf(3)};
        }
        if (i == 1) {
            return new String[]{String.valueOf(1)};
        }
        if (i == 2) {
            return new String[]{String.valueOf(3)};
        }
        if (i != 3) {
            return null;
        }
        return new String[]{String.valueOf(2)};
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    protected String getSortOrder() {
        return TextUtils.isEmpty(getConfig().sortOrder) ? "date_modified DESC" : getConfig().sortOrder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isWithAllQuery() {
        if (SdkVersionUtils.isQ()) {
            return true;
        }
        return getConfig().isPageSyncAsCount;
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    protected LocalMedia parseLocalMedia(Cursor cursor, boolean z) throws IllegalArgumentException {
        String str;
        int i;
        long j;
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(PROJECTION[0]);
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow(PROJECTION[1]);
        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow(PROJECTION[2]);
        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow(PROJECTION[3]);
        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow(PROJECTION[4]);
        int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow(PROJECTION[5]);
        int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow(PROJECTION[6]);
        int columnIndexOrThrow8 = cursor.getColumnIndexOrThrow(PROJECTION[7]);
        int columnIndexOrThrow9 = cursor.getColumnIndexOrThrow(PROJECTION[8]);
        int columnIndexOrThrow10 = cursor.getColumnIndexOrThrow(PROJECTION[9]);
        int columnIndexOrThrow11 = cursor.getColumnIndexOrThrow(PROJECTION[10]);
        int columnIndexOrThrow12 = cursor.getColumnIndexOrThrow(PROJECTION[11]);
        long j2 = cursor.getLong(columnIndexOrThrow);
        String string = cursor.getString(columnIndexOrThrow3);
        String string2 = cursor.getString(columnIndexOrThrow2);
        String realPathUri = SdkVersionUtils.isQ() ? MediaUtils.getRealPathUri(j2, string) : string2;
        if (TextUtils.isEmpty(string)) {
            string = PictureMimeType.ofJPEG();
        }
        if (getConfig().isFilterInvalidFile) {
            if (PictureMimeType.isHasImage(string)) {
                if (!TextUtils.isEmpty(string2) && !PictureFileUtils.isImageFileExists(string2)) {
                    return null;
                }
            } else if (!PictureFileUtils.isFileExists(string2)) {
                return null;
            }
        }
        if (string.endsWith(SelectMimeType.SYSTEM_IMAGE)) {
            string = MediaUtils.getMimeTypeFromMediaUrl(string2);
            str = realPathUri;
            if (!getConfig().isGif && PictureMimeType.isHasGif(string)) {
                return null;
            }
        } else {
            str = realPathUri;
        }
        if (string.endsWith(SelectMimeType.SYSTEM_IMAGE)) {
            return null;
        }
        if (!getConfig().isWebp && string.startsWith(PictureMimeType.ofWEBP())) {
            return null;
        }
        if (!getConfig().isBmp && PictureMimeType.isHasBmp(string)) {
            return null;
        }
        int i2 = cursor.getInt(columnIndexOrThrow4);
        int i3 = cursor.getInt(columnIndexOrThrow5);
        int i4 = cursor.getInt(columnIndexOrThrow12);
        if (i4 == 90 || i4 == 270) {
            i = cursor.getInt(columnIndexOrThrow5);
            i3 = cursor.getInt(columnIndexOrThrow4);
        } else {
            i = i2;
        }
        long j3 = cursor.getLong(columnIndexOrThrow6);
        long j4 = cursor.getLong(columnIndexOrThrow7);
        String string3 = cursor.getString(columnIndexOrThrow8);
        String string4 = cursor.getString(columnIndexOrThrow9);
        long j5 = cursor.getLong(columnIndexOrThrow10);
        long j6 = cursor.getLong(columnIndexOrThrow11);
        if (TextUtils.isEmpty(string4)) {
            string4 = PictureMimeType.getUrlToFileName(string2);
        }
        if (getConfig().isFilterSizeDuration && j4 > 0 && j4 < 1024) {
            return null;
        }
        if (PictureMimeType.isHasVideo(string) || PictureMimeType.isHasAudio(string)) {
            if (getConfig().filterVideoMinSecond > 0) {
                j = j6;
                if (j3 < getConfig().filterVideoMinSecond) {
                    return null;
                }
            } else {
                j = j6;
            }
            if (getConfig().filterVideoMaxSecond > 0 && j3 > getConfig().filterVideoMaxSecond) {
                return null;
            }
            if (getConfig().isFilterSizeDuration && j3 <= 0) {
                return null;
            }
        } else {
            j = j6;
        }
        LocalMedia localMediaObtain = z ? LocalMedia.obtain() : LocalMedia.create();
        localMediaObtain.setId(j2);
        localMediaObtain.setBucketId(j5);
        localMediaObtain.setPath(str);
        localMediaObtain.setRealPath(string2);
        localMediaObtain.setFileName(string4);
        localMediaObtain.setParentFolderName(string3);
        localMediaObtain.setDuration(j3);
        localMediaObtain.setChooseModel(getConfig().chooseMode);
        localMediaObtain.setMimeType(string);
        localMediaObtain.setWidth(i);
        localMediaObtain.setHeight(i3);
        localMediaObtain.setSize(j4);
        localMediaObtain.setDateAddedTime(j);
        if (this.mConfig.onQueryFilterListener == null || !this.mConfig.onQueryFilterListener.onFilter(localMediaObtain)) {
            return localMediaObtain;
        }
        return null;
    }
}
