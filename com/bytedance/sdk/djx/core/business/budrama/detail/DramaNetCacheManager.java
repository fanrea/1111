package com.bytedance.sdk.djx.core.business.budrama.detail;

import android.os.SystemClock;
import android.util.Base64;
import com.alipay.sdk.m.p0.b;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.model.DJXEpisodeStatus;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.net.io.BufferedSink;
import com.bytedance.sdk.djx.net.io.BufferedSource;
import com.bytedance.sdk.djx.net.io.Okio;
import com.bytedance.sdk.djx.net.io.Sink;
import com.bytedance.sdk.djx.net.k3.internal.Util;
import com.bytedance.sdk.djx.net.k3.internal.io.FileSystem;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.utils.AES;
import com.bytedance.sdk.djx.utils.Encrypt;
import com.bytedance.sdk.djx.utils.FileUtil;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.thread.TTExecutor;
import com.bytedance.sdk.djx.utils.thread.TTRunnable;
import com.ss.texturerender.TextureRenderKeys;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DramaNetCacheManager.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\n\u001d\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020 J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\bH\u0002J\u001e\u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\b2\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0002J\b\u0010,\u001a\u00020\rH\u0002J\u0016\u0010-\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\bJ\u0006\u0010.\u001a\u00020 J\u0018\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\bJ\n\u00101\u001a\u0004\u0018\u00010\u0010H\u0002J\n\u00102\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u00103\u001a\u00020 H\u0002J\b\u00104\u001a\u00020 H\u0002J\u001a\u00105\u001a\u00020 2\b\u00106\u001a\u0004\u0018\u00010\u00042\u0006\u00107\u001a\u00020\u0004H\u0002J\b\u00108\u001a\u00020 H\u0002J\u0012\u00109\u001a\u00020 2\b\u00106\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020\u0013H\u0002J\u000e\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u000200J\b\u0010>\u001a\u00020 H\u0002J\u001c\u0010?\u001a\u00020 2\u0006\u0010=\u001a\u0002002\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AJ\u0010\u0010C\u001a\u00020 2\u0006\u0010=\u001a\u000200H\u0002J\b\u0010D\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e¨\u0006E"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/budrama/detail/DramaNetCacheManager;", "", "()V", "DRAMA_CACHE_FILE", "", "TAG", "TRACK_CACHE_FILE", "TRACK_HISTORY_MAX_SIZE", "", "cleanupRunnable", "com/bytedance/sdk/djx/core/business/budrama/detail/DramaNetCacheManager$cleanupRunnable$1", "Lcom/bytedance/sdk/djx/core/business/budrama/detail/DramaNetCacheManager$cleanupRunnable$1;", "directory", "Ljava/io/File;", "dramaCacheFile", "dramaCacheWriter", "Lcom/bytedance/sdk/djx/net/io/BufferedSink;", "dramaDetailListCache", "", "Lcom/bytedance/sdk/djx/core/business/budrama/detail/DramaDetailCacheItem;", "expiredTimeSeconds", "initialized", "", "maxSize", "trackCacheFile", "trackCacheWriter", "trackDetailSetCache", "", "updateDramaCacheRunnable", "com/bytedance/sdk/djx/core/business/budrama/detail/DramaNetCacheManager$updateDramaCacheRunnable$1", "Lcom/bytedance/sdk/djx/core/business/budrama/detail/DramaNetCacheManager$updateDramaCacheRunnable$1;", "buildDirectory", "", "cleanCache", "getCacheIndex", "dramaId", "", "index", "getDramaDetailLoadFromCacheTask", "Lcom/bytedance/sdk/djx/core/business/budrama/detail/DramaDetailLoadFromCacheTask;", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/sdk/djx/core/business/budrama/detail/IDramaDetailLoadFromCacheCallback;", "getDramaIdFromCacheIndex", "cacheIndex", "getUserDirectory", "inHistory", "initialize", "loadFromCache", "Lcom/bytedance/sdk/djx/model/DramaDetail;", "newDramaCacheWriter", "newTrackCacheWriter", "processDramaCache", "readDramaCache", "readDramaCacheLine", "line", "aesKey", "readTrackCache", "readTrackCacheLine", "removeEntry", "toEvict", "saveDramaDetail", DramaNetCacheManager.DRAMA_CACHE_FILE, "trimToSize", "updateDramaDetail", "episodeList", "", "Lcom/bytedance/sdk/djx/model/DJXEpisodeStatus;", "writeDetailHistoryCache", "writeDramaCache", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DramaNetCacheManager {
    private static final String DRAMA_CACHE_FILE = "detail";
    public static final String TAG = "DramaNetCacheManager";
    private static final String TRACK_CACHE_FILE = "track";
    private static final int TRACK_HISTORY_MAX_SIZE = 10000;
    private static final DramaNetCacheManager$cleanupRunnable$1 cleanupRunnable;
    private static File directory;
    private static File dramaCacheFile;
    private static BufferedSink dramaCacheWriter;
    private static Map<String, DramaDetailCacheItem> dramaDetailListCache;
    private static boolean initialized;
    private static File trackCacheFile;
    private static BufferedSink trackCacheWriter;
    private static Set<String> trackDetailSetCache;
    private static final DramaNetCacheManager$updateDramaCacheRunnable$1 updateDramaCacheRunnable;
    public static final DramaNetCacheManager INSTANCE = new DramaNetCacheManager();
    private static int maxSize = SettingData.getInstance().getDramaCacheMaxSize();
    private static int expiredTimeSeconds = SettingData.getInstance().getDramaCacheExpireTime();

    private DramaNetCacheManager() {
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager$cleanupRunnable$1] */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager$updateDramaCacheRunnable$1] */
    static {
        Map<String, DramaDetailCacheItem> mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap(0, 0.75f, true));
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap, "synchronizedMap(LinkedHa…cheItem>(0, 0.75f, true))");
        dramaDetailListCache = mapSynchronizedMap;
        Set<String> setSynchronizedSet = Collections.synchronizedSet(new LinkedHashSet());
        Intrinsics.checkNotNullExpressionValue(setSynchronizedSet, "synchronizedSet(LinkedHashSet())");
        trackDetailSetCache = setSynchronizedSet;
        cleanupRunnable = new TTRunnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager$cleanupRunnable$1
            public void run() {
                synchronized (this) {
                    try {
                        DramaNetCacheManager.INSTANCE.trimToSize();
                    } catch (Exception unused) {
                        LG.e(DramaNetCacheManager.TAG, "trimToSize fail");
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
        updateDramaCacheRunnable = new TTRunnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager$updateDramaCacheRunnable$1
            public void run() {
                synchronized (this) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        DramaNetCacheManager.INSTANCE.writeDramaCache();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    LG.d(DramaNetCacheManager.TAG, "writeDramaCache: " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ", size: " + DramaNetCacheManager.dramaDetailListCache.size());
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
    }

    public final synchronized void initialize() throws IOException {
        if (initialized) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        buildDirectory();
        File file = dramaCacheFile;
        boolean z = false;
        if (file != null && file.exists()) {
            z = true;
        }
        if (z) {
            try {
                readDramaCache();
                readTrackCache();
                processDramaCache();
                initialized = true;
                LG.d(TAG, "initialize: " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ", size: " + dramaDetailListCache.size());
                return;
            } catch (Exception unused) {
                cleanCache();
                LG.e(TAG, "The cache is corrupted, attempt to delete the contents of the directory.");
            }
        }
        initialized = true;
    }

    private final void buildDirectory() {
        directory = getUserDirectory();
        dramaCacheFile = new File(directory, DRAMA_CACHE_FILE);
        trackCacheFile = new File(directory, TRACK_CACHE_FILE);
    }

    private final File getUserDirectory() {
        File file = new File(FileUtil.getDramaCache(InnerManager.getContext()), TokenHelper.getInstance().getUserId());
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Throwable unused) {
        }
        return file;
    }

    private final void readTrackCache() throws IOException {
        File file = trackCacheFile;
        boolean z = false;
        if (file != null && file.exists()) {
            z = true;
        }
        if (!z) {
            LG.i(TAG, "trackCacheFile not exists");
            return;
        }
        BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(trackCacheFile));
        Intrinsics.checkNotNullExpressionValue(bufferedSourceBuffer, "buffer(Okio.source(trackCacheFile))");
        while (true) {
            try {
                try {
                    readTrackCacheLine(bufferedSourceBuffer.readUtf8LineStrict());
                } catch (EOFException unused) {
                    return;
                } catch (Exception unused2) {
                    cleanCache();
                    return;
                }
            } finally {
                Util.closeQuietly(bufferedSourceBuffer);
            }
        }
    }

    private final void readTrackCacheLine(String line) {
        if (line == null) {
            return;
        }
        trackDetailSetCache.add(line);
    }

    private final BufferedSink newDramaCacheWriter() throws FileNotFoundException {
        File file = dramaCacheFile;
        boolean z = false;
        if (file != null && file.exists()) {
            z = true;
        }
        if (!z) {
            buildDirectory();
        }
        Sink sink = Okio.sink(dramaCacheFile);
        Intrinsics.checkNotNullExpressionValue(sink, "sink(dramaCacheFile)");
        return Okio.buffer(sink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BufferedSink newTrackCacheWriter() throws FileNotFoundException {
        File file = trackCacheFile;
        boolean z = false;
        if (file != null && file.exists()) {
            z = true;
        }
        if (!z) {
            buildDirectory();
        }
        Sink sinkAppendingSink = Okio.appendingSink(trackCacheFile);
        Intrinsics.checkNotNullExpressionValue(sinkAppendingSink, "appendingSink(trackCacheFile)");
        return Okio.buffer(sinkAppendingSink);
    }

    private final void processDramaCache() {
        synchronized (dramaDetailListCache) {
            for (Map.Entry<String, DramaDetailCacheItem> entry : dramaDetailListCache.entrySet()) {
                if (entry.getValue().getWriteTimeSeconds() + expiredTimeSeconds < TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())) {
                    INSTANCE.removeEntry(entry.getValue());
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void readDramaCacheLine(String line, String aesKey) throws JSONException {
        byte[] bArrDecrypt = AES.decrypt(Base64.decode(line, 2), aesKey);
        Intrinsics.checkNotNullExpressionValue(bArrDecrypt, "decrypt(enbytes, aesKey)");
        JSONObject jSONObject = new JSONObject(new String(bArrDecrypt, Charsets.UTF_8));
        String string = jSONObject.getString("key");
        DramaDetailCacheItem fromJSONObject = DramaDetailCacheItem.INSTANCE.parseFromJSONObject(new JSONObject(jSONObject.getString(b.d)));
        Map<String, DramaDetailCacheItem> map = dramaDetailListCache;
        Intrinsics.checkNotNullExpressionValue(string, "key");
        map.put(string, fromJSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeDramaCache() throws IOException {
        BufferedSink bufferedSinkWriteUtf8;
        BufferedSink bufferedSinkWriteUtf82;
        dramaCacheWriter = newDramaCacheWriter();
        String strSalt = Encrypt.salt(8);
        BufferedSink bufferedSink = dramaCacheWriter;
        if (bufferedSink != null && (bufferedSinkWriteUtf82 = bufferedSink.writeUtf8(strSalt)) != null) {
            bufferedSinkWriteUtf82.writeByte(10);
        }
        String strBuildAesKey = Encrypt.buildAesKey(strSalt);
        synchronized (dramaDetailListCache) {
            for (Map.Entry<String, DramaDetailCacheItem> entry : dramaDetailListCache.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", entry.getKey());
                jSONObject.put(b.d, entry.getValue().toJSONObject());
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                byte[] bArrEncrypt = AES.encrypt(bytes, strBuildAesKey);
                Intrinsics.checkNotNullExpressionValue(bArrEncrypt, "encrypt(jsonBytesUTF8, key)");
                String strEncodeToString = Base64.encodeToString(bArrEncrypt, 2);
                BufferedSink bufferedSink2 = dramaCacheWriter;
                if (bufferedSink2 != null && (bufferedSinkWriteUtf8 = bufferedSink2.writeUtf8(strEncodeToString)) != null) {
                    bufferedSinkWriteUtf8.writeByte(10);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        BufferedSink bufferedSink3 = dramaCacheWriter;
        if (bufferedSink3 != null) {
            bufferedSink3.flush();
        }
        BufferedSink bufferedSink4 = dramaCacheWriter;
        if (bufferedSink4 == null) {
            return;
        }
        bufferedSink4.close();
    }

    private final void readDramaCache() throws IOException {
        File file = dramaCacheFile;
        boolean z = false;
        if (file != null && file.exists()) {
            z = true;
        }
        if (!z) {
            LG.i(TAG, "dramaCacheFile not exists");
            return;
        }
        BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(dramaCacheFile));
        Intrinsics.checkNotNullExpressionValue(bufferedSourceBuffer, "buffer(Okio.source(dramaCacheFile))");
        String strBuildAesKey = Encrypt.buildAesKey(bufferedSourceBuffer.readUtf8LineStrict());
        while (true) {
            try {
                try {
                    String utf8LineStrict = bufferedSourceBuffer.readUtf8LineStrict();
                    Intrinsics.checkNotNullExpressionValue(strBuildAesKey, "aesKey");
                    readDramaCacheLine(utf8LineStrict, strBuildAesKey);
                } catch (EOFException unused) {
                    return;
                } catch (Exception unused2) {
                    cleanCache();
                    return;
                }
            } finally {
                Util.closeQuietly(bufferedSourceBuffer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trimToSize() {
        synchronized (dramaDetailListCache) {
            while (dramaDetailListCache.size() > maxSize) {
                INSTANCE.removeEntry(dramaDetailListCache.values().iterator().next());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void removeEntry(DramaDetailCacheItem toEvict) {
        dramaDetailListCache.remove(getCacheIndex(toEvict.getDramaDetail().getDrama().id, toEvict.getDramaDetail().getIndex()));
    }

    public final DramaDetailLoadFromCacheTask getDramaDetailLoadFromCacheTask(long dramaId, int index, IDramaDetailLoadFromCacheCallback callback) {
        Intrinsics.checkNotNullParameter(callback, TextureRenderKeys.KEY_IS_CALLBACK);
        return new DramaDetailLoadFromCacheTask(dramaId, index, callback);
    }

    public final DramaDetail loadFromCache(long dramaId, int index) throws IOException {
        if (!initialized) {
            initialize();
        }
        DramaDetailCacheItem dramaDetailCacheItem = dramaDetailListCache.get(getCacheIndex(dramaId, index));
        if (dramaDetailCacheItem == null) {
            return null;
        }
        if (dramaDetailCacheItem.getWriteTimeSeconds() + expiredTimeSeconds < TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())) {
            removeEntry(dramaDetailCacheItem);
            return null;
        }
        Drama drama = dramaDetailCacheItem.getDramaDetail().getDrama();
        if (drama != null) {
            drama.episodeStatusList = CollectionsKt.listOf(new DJXEpisodeStatus(index, false));
        }
        return dramaDetailCacheItem.getDramaDetail();
    }

    public final void saveDramaDetail(DramaDetail detail) throws IOException {
        Intrinsics.checkNotNullParameter(detail, DRAMA_CACHE_FILE);
        if (!initialized) {
            initialize();
        }
        int size = dramaDetailListCache.size();
        dramaDetailListCache.put(getCacheIndex(detail.getDrama().id, detail.getIndex()), new DramaDetailCacheItem(detail, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
        boolean z = dramaDetailListCache.size() != size;
        if (dramaDetailListCache.size() > maxSize) {
            TTExecutor.get().executeDefaultTask(cleanupRunnable);
        }
        if (z) {
            TTExecutor.get().executeDefaultTask(updateDramaCacheRunnable);
            writeDetailHistoryCache(detail);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCacheIndex(long dramaId, int index) {
        return new StringBuilder().append(dramaId).append(SignatureImpl.SEP).append(index).toString();
    }

    private final String getDramaIdFromCacheIndex(String cacheIndex) {
        return (String) StringsKt.split$default((CharSequence) cacheIndex, new String[]{"-"}, false, 0, 6, (Object) null).get(0);
    }

    private final void writeDetailHistoryCache(final DramaDetail detail) {
        TTExecutor.get().executeDefaultTask(new TTRunnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.writeDetailHistoryCache.1
            /* JADX WARN: Removed duplicated region for block: B:24:0x006c A[Catch: Exception -> 0x00a9, TryCatch #0 {Exception -> 0x00a9, blocks: (B:2:0x0000, B:4:0x0029, B:11:0x0041, B:14:0x0048, B:15:0x004b, B:7:0x0038, B:16:0x0056, B:18:0x005c, B:25:0x0077, B:32:0x009e, B:35:0x00a5, B:28:0x007e, B:31:0x0099, B:21:0x0064, B:24:0x006c), top: B:40:0x0000 }] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r5 = this;
                    java.util.Set r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$getTrackDetailSetCache$p()     // Catch: java.lang.Exception -> La9
                    com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager r1 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.INSTANCE     // Catch: java.lang.Exception -> La9
                    com.bytedance.sdk.djx.model.DramaDetail r2 = r1     // Catch: java.lang.Exception -> La9
                    com.bytedance.sdk.djx.model.Drama r2 = r2.getDrama()     // Catch: java.lang.Exception -> La9
                    long r2 = r2.id     // Catch: java.lang.Exception -> La9
                    com.bytedance.sdk.djx.model.DramaDetail r4 = r1     // Catch: java.lang.Exception -> La9
                    int r4 = r4.getIndex()     // Catch: java.lang.Exception -> La9
                    java.lang.String r1 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$getCacheIndex(r1, r2, r4)     // Catch: java.lang.Exception -> La9
                    r0.add(r1)     // Catch: java.lang.Exception -> La9
                    java.util.Set r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$getTrackDetailSetCache$p()     // Catch: java.lang.Exception -> La9
                    int r0 = r0.size()     // Catch: java.lang.Exception -> La9
                    r1 = 10000(0x2710, float:1.4013E-41)
                    r2 = 1
                    r3 = 0
                    if (r0 <= r1) goto L56
                    java.util.Set r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$getTrackDetailSetCache$p()     // Catch: java.lang.Exception -> La9
                    r0.clear()     // Catch: java.lang.Exception -> La9
                    java.io.File r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$getTrackCacheFile$p()     // Catch: java.lang.Exception -> La9
                    if (r0 != 0) goto L38
                L36:
                    r0 = r3
                    goto L3f
                L38:
                    boolean r0 = r0.exists()     // Catch: java.lang.Exception -> La9
                    if (r0 != r2) goto L36
                    r0 = r2
                L3f:
                    if (r0 == 0) goto L4b
                    java.io.File r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$getTrackCacheFile$p()     // Catch: java.lang.Exception -> La9
                    if (r0 != 0) goto L48
                    goto L4b
                L48:
                    r0.delete()     // Catch: java.lang.Exception -> La9
                L4b:
                    com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.INSTANCE     // Catch: java.lang.Exception -> La9
                    com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.INSTANCE     // Catch: java.lang.Exception -> La9
                    com.bytedance.sdk.djx.net.io.BufferedSink r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$newTrackCacheWriter(r0)     // Catch: java.lang.Exception -> La9
                    com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$setTrackCacheWriter$p(r0)     // Catch: java.lang.Exception -> La9
                L56:
                    com.bytedance.sdk.djx.net.io.BufferedSink r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$getTrackCacheWriter$p()     // Catch: java.lang.Exception -> La9
                    if (r0 == 0) goto L6c
                    java.io.File r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$getTrackCacheFile$p()     // Catch: java.lang.Exception -> La9
                    if (r0 != 0) goto L64
                L62:
                    r2 = r3
                    goto L6a
                L64:
                    boolean r0 = r0.exists()     // Catch: java.lang.Exception -> La9
                    if (r0 != r2) goto L62
                L6a:
                    if (r2 != 0) goto L77
                L6c:
                    com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.INSTANCE     // Catch: java.lang.Exception -> La9
                    com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.INSTANCE     // Catch: java.lang.Exception -> La9
                    com.bytedance.sdk.djx.net.io.BufferedSink r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$newTrackCacheWriter(r0)     // Catch: java.lang.Exception -> La9
                    com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$setTrackCacheWriter$p(r0)     // Catch: java.lang.Exception -> La9
                L77:
                    com.bytedance.sdk.djx.net.io.BufferedSink r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$getTrackCacheWriter$p()     // Catch: java.lang.Exception -> La9
                    if (r0 != 0) goto L7e
                    goto L9e
                L7e:
                    com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager r1 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.INSTANCE     // Catch: java.lang.Exception -> La9
                    com.bytedance.sdk.djx.model.DramaDetail r2 = r1     // Catch: java.lang.Exception -> La9
                    com.bytedance.sdk.djx.model.Drama r2 = r2.getDrama()     // Catch: java.lang.Exception -> La9
                    long r2 = r2.id     // Catch: java.lang.Exception -> La9
                    com.bytedance.sdk.djx.model.DramaDetail r4 = r1     // Catch: java.lang.Exception -> La9
                    int r4 = r4.getIndex()     // Catch: java.lang.Exception -> La9
                    java.lang.String r1 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$getCacheIndex(r1, r2, r4)     // Catch: java.lang.Exception -> La9
                    com.bytedance.sdk.djx.net.io.BufferedSink r0 = r0.writeUtf8(r1)     // Catch: java.lang.Exception -> La9
                    if (r0 != 0) goto L99
                    goto L9e
                L99:
                    r1 = 10
                    r0.writeByte(r1)     // Catch: java.lang.Exception -> La9
                L9e:
                    com.bytedance.sdk.djx.net.io.BufferedSink r0 = com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.access$getTrackCacheWriter$p()     // Catch: java.lang.Exception -> La9
                    if (r0 != 0) goto La5
                    goto Lad
                La5:
                    r0.flush()     // Catch: java.lang.Exception -> La9
                    goto Lad
                La9:
                    r0 = move-exception
                    r0.printStackTrace()
                Lad:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.business.budrama.detail.DramaNetCacheManager.AnonymousClass1.run():void");
            }
        });
    }

    public final void cleanCache() throws IOException {
        FileSystem.SYSTEM.deleteContents(directory);
    }

    public final boolean inHistory(long dramaId, int index) {
        return trackDetailSetCache.contains(getCacheIndex(dramaId, index));
    }

    public final void updateDramaDetail(DramaDetail detail, List<DJXEpisodeStatus> episodeList) throws IOException {
        Intrinsics.checkNotNullParameter(detail, DRAMA_CACHE_FILE);
        Intrinsics.checkNotNullParameter(episodeList, "episodeList");
        if (!initialized) {
            initialize();
        }
        dramaDetailListCache.put(getCacheIndex(detail.getDrama().id, detail.getIndex()), new DramaDetailCacheItem(detail, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
        int size = dramaDetailListCache.size();
        for (DJXEpisodeStatus dJXEpisodeStatus : episodeList) {
            Map<String, DramaDetailCacheItem> map = dramaDetailListCache;
            DramaNetCacheManager dramaNetCacheManager = INSTANCE;
            DramaDetailCacheItem dramaDetailCacheItem = map.get(dramaNetCacheManager.getCacheIndex(detail.getDrama().id, dJXEpisodeStatus.getIndex()));
            if (dramaDetailCacheItem != null && dJXEpisodeStatus.isLocked()) {
                dramaNetCacheManager.removeEntry(dramaDetailCacheItem);
            }
        }
        if (dramaDetailListCache.size() != size) {
            TTExecutor.get().executeDefaultTask(updateDramaCacheRunnable);
        }
    }
}
