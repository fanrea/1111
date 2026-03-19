package com.nativekv;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NativeKV implements SharedPreferences, SharedPreferences.Editor {
    private static final int ASHMEM_MODE = 8;
    private static final int BACKUP_MODE = 16;
    private static final int CONTEXT_MODE_MULTI_PROCESS = 4;
    public static final int MULTI_PROCESS_MODE = 2;
    public static final int SINGLE_PROCESS_MODE = 1;
    private static final Set<Long> checkedHandleSet;
    private static NativeKVHandler gCallbackHandler;
    private static NativeKVContentChangeNotification gContentChangeNotify;
    private static boolean gWantLogReDirecting;
    private static final NativeKVLogLevel[] index2LogLevel;
    private static boolean isProcessModeCheckerEnabled;
    private static final EnumMap<NativeKVLogLevel, Integer> logLevel2Index;
    private static final HashMap<String, Parcelable.Creator<?>> mCreators;
    private static final EnumMap<NativeKVRecoverStrategic, Integer> recoverIndex;
    private static String rootDir;
    private final long nativeHandle;

    public interface LibLoader {
        void loadLibrary(String libName);
    }

    private native long actualSize(long handle);

    public static native long backupAllToDirectory(String dstDir);

    public static native boolean backupOneToDirectory(String mmapID, String dstDir, String rootPath);

    private static native boolean checkProcessMode(long handle);

    private native boolean containsKey(long handle, String key);

    private native long count(long handle);

    private static native long createNB(int size);

    private native boolean decodeBool(long handle, String key, boolean defaultValue);

    private native byte[] decodeBytes(long handle, String key);

    private native double decodeDouble(long handle, String key, double defaultValue);

    private native float decodeFloat(long handle, String key, float defaultValue);

    private native int decodeInt(long handle, String key, int defaultValue);

    private native long decodeLong(long handle, String key, long defaultValue);

    private native String decodeString(long handle, String key, String defaultValue);

    private native String[] decodeStringSet(long handle, String key);

    private static native void destroyNB(long pointer, int size);

    private native boolean encodeBool(long handle, String key, boolean value);

    private native boolean encodeBytes(long handle, String key, byte[] value);

    private native boolean encodeDouble(long handle, String key, double value);

    private native boolean encodeFloat(long handle, String key, float value);

    private native boolean encodeInt(long handle, String key, int value);

    private native boolean encodeLong(long handle, String key, long value);

    private native boolean encodeSet(long handle, String key, String[] value);

    private native boolean encodeString(long handle, String key, String value);

    private static native long getDefaultNativeKV(int mode, String cryptKey);

    private static native long getNativeKVWithAshmemFD(String mmapID, int fd, int metaFD, String cryptKey);

    private static native long getNativeKVWithID(String mmapID, int mode, String cryptKey, String rootPath);

    private static native long getNativeKVWithIDAndSize(String mmapID, int size, int mode, String cryptKey);

    public static native boolean isFileValid(String mmapID, String rootPath);

    private static native void jniInitialize(String rootDir2, String cacheDir, int level);

    public static native void onExit();

    public static native int pageSize();

    private native void removeValueForKey(long handle, String key);

    public static native long restoreAllFromDirectory(String srcDir);

    public static native boolean restoreOneMMKVFromDirectory(String mmapID, String srcDir, String rootPath);

    private static native void setCallbackHandler(boolean logReDirecting, boolean hasCallback);

    private static native void setLogLevel(int level);

    private static native void setWantsContentChangeNotify(boolean needsNotify);

    private native void sync(boolean sync);

    private native long totalSize(long handle);

    private native int valueSize(long handle, String key, boolean actualSize);

    public static native String version();

    private native int writeValueToNB(long handle, String key, long pointer, int size);

    public native String[] allKeys();

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(String cryptKey);

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    public native String cryptKey();

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    public native void lock();

    public native String mmapID();

    public native boolean reKey(String cryptKey);

    public native void removeValuesForKeys(String[] arrKeys);

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    static {
        EnumMap<NativeKVRecoverStrategic, Integer> enumMap = new EnumMap<>(NativeKVRecoverStrategic.class);
        recoverIndex = enumMap;
        enumMap.put((EnumMap<NativeKVRecoverStrategic, Integer>) NativeKVRecoverStrategic.OnErrorDiscard, (NativeKVRecoverStrategic) 0);
        enumMap.put((EnumMap<NativeKVRecoverStrategic, Integer>) NativeKVRecoverStrategic.OnErrorRecover, (NativeKVRecoverStrategic) 1);
        EnumMap<NativeKVLogLevel, Integer> enumMap2 = new EnumMap<>(NativeKVLogLevel.class);
        logLevel2Index = enumMap2;
        enumMap2.put((EnumMap<NativeKVLogLevel, Integer>) NativeKVLogLevel.LevelDebug, (NativeKVLogLevel) 0);
        enumMap2.put((EnumMap<NativeKVLogLevel, Integer>) NativeKVLogLevel.LevelInfo, (NativeKVLogLevel) 1);
        enumMap2.put((EnumMap<NativeKVLogLevel, Integer>) NativeKVLogLevel.LevelWarning, (NativeKVLogLevel) 2);
        enumMap2.put((EnumMap<NativeKVLogLevel, Integer>) NativeKVLogLevel.LevelError, (NativeKVLogLevel) 3);
        enumMap2.put((EnumMap<NativeKVLogLevel, Integer>) NativeKVLogLevel.LevelNone, (NativeKVLogLevel) 4);
        index2LogLevel = new NativeKVLogLevel[]{NativeKVLogLevel.LevelDebug, NativeKVLogLevel.LevelInfo, NativeKVLogLevel.LevelWarning, NativeKVLogLevel.LevelError, NativeKVLogLevel.LevelNone};
        checkedHandleSet = new HashSet();
        rootDir = null;
        isProcessModeCheckerEnabled = true;
        mCreators = new HashMap<>();
        gWantLogReDirecting = false;
    }

    public static String initialize(Context context) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", null, NativeKVLogLevel.LevelInfo);
    }

    public static String initialize(Context context, NativeKVLogLevel logLevel) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", null, logLevel);
    }

    public static String initialize(Context context, LibLoader loader) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", loader, NativeKVLogLevel.LevelInfo);
    }

    public static String initialize(Context context, LibLoader loader, NativeKVLogLevel logLevel) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", loader, logLevel);
    }

    public static String initialize(Context context, String rootDir2) {
        return initialize(context, rootDir2, null, NativeKVLogLevel.LevelInfo);
    }

    public static String initialize(Context context, String rootDir2, NativeKVLogLevel logLevel) {
        return initialize(context, rootDir2, null, logLevel);
    }

    public static String initialize(Context context, String rootDir2, LibLoader loader) {
        return initialize(context, rootDir2, loader, NativeKVLogLevel.LevelInfo);
    }

    public static String initialize(Context context, String rootDir2, LibLoader loader, NativeKVLogLevel logLevel) {
        if ((context.getApplicationInfo().flags & 2) == 0) {
            disableProcessModeChecker();
        } else {
            enableProcessModeChecker();
        }
        return doInitialize(rootDir2, context.getCacheDir().getAbsolutePath(), loader, logLevel);
    }

    private static String doInitialize(String rootDir2, String cacheDir, LibLoader loader, NativeKVLogLevel logLevel) {
        if (loader != null) {
            loader.loadLibrary("nativekv");
        } else {
            System.loadLibrary("nativekv");
        }
        jniInitialize(rootDir2, cacheDir, logLevel2Int(logLevel));
        rootDir = rootDir2;
        return rootDir2;
    }

    @Deprecated
    public static String initialize(String rootDir2) {
        return doInitialize(rootDir2, rootDir2 + "/.tmp", null, NativeKVLogLevel.LevelInfo);
    }

    @Deprecated
    public static String initialize(String rootDir2, NativeKVLogLevel logLevel) {
        return doInitialize(rootDir2, rootDir2 + "/.tmp", null, logLevel);
    }

    @Deprecated
    public static String initialize(String rootDir2, LibLoader loader) {
        return doInitialize(rootDir2, rootDir2 + "/.tmp", loader, NativeKVLogLevel.LevelInfo);
    }

    @Deprecated
    public static String initialize(String rootDir2, LibLoader loader, NativeKVLogLevel logLevel) {
        return doInitialize(rootDir2, rootDir2 + "/.tmp", loader, logLevel);
    }

    public static String getRootDir() {
        return rootDir;
    }

    /* renamed from: com.nativekv.NativeKV$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$nativekv$NativeKVLogLevel;

        static {
            int[] iArr = new int[NativeKVLogLevel.values().length];
            $SwitchMap$com$nativekv$NativeKVLogLevel = iArr;
            try {
                iArr[NativeKVLogLevel.LevelDebug.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$nativekv$NativeKVLogLevel[NativeKVLogLevel.LevelWarning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$nativekv$NativeKVLogLevel[NativeKVLogLevel.LevelError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$nativekv$NativeKVLogLevel[NativeKVLogLevel.LevelNone.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$nativekv$NativeKVLogLevel[NativeKVLogLevel.LevelInfo.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static int logLevel2Int(NativeKVLogLevel level) {
        int i = AnonymousClass1.$SwitchMap$com$nativekv$NativeKVLogLevel[level.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 2;
        }
        if (i != 3) {
            return i != 4 ? 1 : 4;
        }
        return 3;
    }

    public static void setLogLevel(NativeKVLogLevel level) {
        setLogLevel(logLevel2Int(level));
    }

    public static NativeKV nativeKVWithID(String mmapID) throws RuntimeException {
        if (rootDir == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        return checkProcessMode(getNativeKVWithID(mmapID, 1, null, null), mmapID, 1);
    }

    public static NativeKV nativeKVWithID(String mmapID, int mode) throws RuntimeException {
        if (rootDir == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        return checkProcessMode(getNativeKVWithID(mmapID, mode, null, null), mmapID, mode);
    }

    public static NativeKV nativeKVWithID(String mmapID, int mode, String cryptKey) throws RuntimeException {
        if (rootDir == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        return checkProcessMode(getNativeKVWithID(mmapID, mode, cryptKey, null), mmapID, mode);
    }

    public static NativeKV nativeKVWithID(String mmapID, String rootPath) throws RuntimeException {
        if (rootDir == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        return checkProcessMode(getNativeKVWithID(mmapID, 1, null, rootPath), mmapID, 1);
    }

    public static NativeKV nativeKVWithID(String mmapID, int mode, String cryptKey, String rootPath) throws RuntimeException {
        if (rootDir == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        return checkProcessMode(getNativeKVWithID(mmapID, mode, cryptKey, rootPath), mmapID, mode);
    }

    public static NativeKV backedUpNativeKVWithID(String mmapID, int mode, String cryptKey, String rootPath) throws RuntimeException {
        if (rootDir == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        int i = mode | 16;
        return checkProcessMode(getNativeKVWithID(mmapID, i, cryptKey, rootPath), mmapID, i);
    }

    public static NativeKV nativeKVWithAshmemID(Context context, String mmapID, int size, int mode, String cryptKey) throws RuntimeException {
        NativeKV nativeKV;
        if (rootDir == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        String processNameByPID = NativeKVContentProvider.getProcessNameByPID(context, Process.myPid());
        if (processNameByPID == null || processNameByPID.length() == 0) {
            simpleLog(NativeKVLogLevel.LevelError, "process name detect fail, try again later");
            throw new IllegalStateException("process name detect fail, try again later");
        }
        if (processNameByPID.contains(":")) {
            Uri uriContentUri = NativeKVContentProvider.contentUri(context);
            if (uriContentUri == null) {
                simpleLog(NativeKVLogLevel.LevelError, "MMKVContentProvider has invalid authority");
                throw new IllegalStateException("MMKVContentProvider has invalid authority");
            }
            simpleLog(NativeKVLogLevel.LevelInfo, "getting parcelable mmkv in process, Uri = " + uriContentUri);
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_SIZE", size);
            bundle.putInt("KEY_MODE", mode);
            if (cryptKey != null) {
                bundle.putString("KEY_CRYPT", cryptKey);
            }
            Bundle bundleCall = context.getContentResolver().call(uriContentUri, "mmkvFromAshmemID", mmapID, bundle);
            if (bundleCall != null) {
                bundleCall.setClassLoader(ParcelableNativeKV.class.getClassLoader());
                ParcelableNativeKV parcelableNativeKV = (ParcelableNativeKV) bundleCall.getParcelable("KEY");
                if (parcelableNativeKV != null && (nativeKV = parcelableNativeKV.toNativeKV()) != null) {
                    simpleLog(NativeKVLogLevel.LevelInfo, nativeKV.mmapID() + " fd = " + nativeKV.ashmemFD() + ", meta fd = " + nativeKV.ashmemMetaFD());
                    return nativeKV;
                }
            }
        }
        simpleLog(NativeKVLogLevel.LevelInfo, "getting mmkv in main process");
        long nativeKVWithIDAndSize = getNativeKVWithIDAndSize(mmapID, size, mode | 8, cryptKey);
        if (nativeKVWithIDAndSize != 0) {
            return new NativeKV(nativeKVWithIDAndSize);
        }
        throw new IllegalStateException("Fail to create an Ashmem MMKV instance [" + mmapID + "]");
    }

    public static NativeKV defaultNativeKV() throws RuntimeException {
        if (rootDir == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        return checkProcessMode(getDefaultNativeKV(1, null), "DefaultMMKV", 1);
    }

    public static NativeKV defaultNativeKV(int mode, String cryptKey) throws RuntimeException {
        if (rootDir == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        return checkProcessMode(getDefaultNativeKV(mode, cryptKey), "DefaultMMKV", mode);
    }

    private static NativeKV checkProcessMode(long handle, String mmapID, int mode) throws RuntimeException {
        String str;
        if (handle == 0) {
            throw new RuntimeException("Fail to create an MMKV instance [" + mmapID + "] in JNI");
        }
        if (!isProcessModeCheckerEnabled) {
            return new NativeKV(handle);
        }
        Set<Long> set = checkedHandleSet;
        synchronized (set) {
            if (!set.contains(Long.valueOf(handle))) {
                if (!checkProcessMode(handle)) {
                    if (mode == 1) {
                        str = "Opening a multi-process MMKV instance [" + mmapID + "] with SINGLE_PROCESS_MODE!";
                    } else {
                        str = ("Opening an MMKV instance [" + mmapID + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                    }
                    throw new IllegalArgumentException(str);
                }
                set.add(Long.valueOf(handle));
            }
        }
        return new NativeKV(handle);
    }

    public static void enableProcessModeChecker() {
        synchronized (checkedHandleSet) {
            isProcessModeCheckerEnabled = true;
        }
        Log.i("MMKV", "Enable checkProcessMode()");
    }

    public static void disableProcessModeChecker() {
        synchronized (checkedHandleSet) {
            isProcessModeCheckerEnabled = false;
        }
        Log.i("MMKV", "Disable checkProcessMode()");
    }

    public boolean encode(String key, boolean value) {
        return encodeBool(this.nativeHandle, key, value);
    }

    public boolean decodeBool(String key) {
        return decodeBool(this.nativeHandle, key, false);
    }

    public boolean decodeBool(String key, boolean defaultValue) {
        return decodeBool(this.nativeHandle, key, defaultValue);
    }

    public boolean encode(String key, int value) {
        return encodeInt(this.nativeHandle, key, value);
    }

    public int decodeInt(String key) {
        return decodeInt(this.nativeHandle, key, 0);
    }

    public int decodeInt(String key, int defaultValue) {
        return decodeInt(this.nativeHandle, key, defaultValue);
    }

    public boolean encode(String key, long value) {
        return encodeLong(this.nativeHandle, key, value);
    }

    public long decodeLong(String key) {
        return decodeLong(this.nativeHandle, key, 0L);
    }

    public long decodeLong(String key, long defaultValue) {
        return decodeLong(this.nativeHandle, key, defaultValue);
    }

    public boolean encode(String key, float value) {
        return encodeFloat(this.nativeHandle, key, value);
    }

    public float decodeFloat(String key) {
        return decodeFloat(this.nativeHandle, key, 0.0f);
    }

    public float decodeFloat(String key, float defaultValue) {
        return decodeFloat(this.nativeHandle, key, defaultValue);
    }

    public boolean encode(String key, double value) {
        return encodeDouble(this.nativeHandle, key, value);
    }

    public double decodeDouble(String key) {
        return decodeDouble(this.nativeHandle, key, 0.0d);
    }

    public double decodeDouble(String key, double defaultValue) {
        return decodeDouble(this.nativeHandle, key, defaultValue);
    }

    public boolean encode(String key, String value) {
        return encodeString(this.nativeHandle, key, value);
    }

    public String decodeString(String key) {
        return decodeString(this.nativeHandle, key, null);
    }

    public String decodeString(String key, String defaultValue) {
        return decodeString(this.nativeHandle, key, defaultValue);
    }

    public boolean encode(String key, Set<String> value) {
        return encodeSet(this.nativeHandle, key, value == null ? null : (String[]) value.toArray(new String[0]));
    }

    public Set<String> decodeStringSet(String key) {
        return decodeStringSet(key, (Set<String>) null);
    }

    public Set<String> decodeStringSet(String key, Set<String> defaultValue) {
        return decodeStringSet(key, defaultValue, HashSet.class);
    }

    public Set<String> decodeStringSet(String key, Set<String> defaultValue, Class<? extends Set> cls) throws IllegalAccessException, InstantiationException {
        String[] strArrDecodeStringSet = decodeStringSet(this.nativeHandle, key);
        if (strArrDecodeStringSet == null) {
            return defaultValue;
        }
        try {
            Set<String> setNewInstance = cls.newInstance();
            setNewInstance.addAll(Arrays.asList(strArrDecodeStringSet));
            return setNewInstance;
        } catch (IllegalAccessException | InstantiationException unused) {
            return defaultValue;
        }
    }

    public boolean encode(String key, byte[] value) {
        return encodeBytes(this.nativeHandle, key, value);
    }

    public byte[] decodeBytes(String key) {
        return decodeBytes(key, (byte[]) null);
    }

    public byte[] decodeBytes(String key, byte[] defaultValue) {
        byte[] bArrDecodeBytes = decodeBytes(this.nativeHandle, key);
        return bArrDecodeBytes != null ? bArrDecodeBytes : defaultValue;
    }

    public boolean encode(String key, Parcelable value) {
        if (value == null) {
            return encodeBytes(this.nativeHandle, key, null);
        }
        Parcel parcelObtain = Parcel.obtain();
        value.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return encodeBytes(this.nativeHandle, key, bArrMarshall);
    }

    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls) {
        return (T) decodeParcelable(str, cls, null);
    }

    public <T extends Parcelable> T decodeParcelable(String key, Class<T> tClass, T defaultValue) {
        byte[] bArrDecodeBytes;
        Parcelable.Creator<?> creator;
        if (tClass == null || (bArrDecodeBytes = decodeBytes(this.nativeHandle, key)) == null) {
            return defaultValue;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArrDecodeBytes, 0, bArrDecodeBytes.length);
        parcelObtain.setDataPosition(0);
        try {
            String string = tClass.toString();
            HashMap<String, Parcelable.Creator<?>> map = mCreators;
            synchronized (map) {
                creator = map.get(string);
                if (creator == null && (creator = (Parcelable.Creator) tClass.getField("CREATOR").get(null)) != null) {
                    map.put(string, creator);
                }
            }
            if (creator != null) {
                return (T) creator.createFromParcel(parcelObtain);
            }
            throw new Exception("Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class " + string);
        } catch (Exception e) {
            simpleLog(NativeKVLogLevel.LevelError, e.toString());
            return defaultValue;
        } finally {
            parcelObtain.recycle();
        }
    }

    public int getValueSize(String key) {
        return valueSize(this.nativeHandle, key, false);
    }

    public int getValueActualSize(String key) {
        return valueSize(this.nativeHandle, key, true);
    }

    public boolean containsKey(String key) {
        return containsKey(this.nativeHandle, key);
    }

    public long count() {
        return count(this.nativeHandle);
    }

    public long totalSize() {
        return totalSize(this.nativeHandle);
    }

    public long actualSize() {
        return actualSize(this.nativeHandle);
    }

    public void removeValueForKey(String key) {
        removeValueForKey(this.nativeHandle, key);
    }

    public void sync() {
        sync(true);
    }

    public void async() {
        sync(false);
    }

    public static boolean isFileValid(String mmapID) {
        return isFileValid(mmapID, null);
    }

    public int importFromSharedPreferences(SharedPreferences preferences) {
        Map<String, ?> all = preferences.getAll();
        if (all == null || all.size() <= 0) {
            return 0;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null) {
                if (value instanceof Boolean) {
                    encodeBool(this.nativeHandle, key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    encodeInt(this.nativeHandle, key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    encodeLong(this.nativeHandle, key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    encodeFloat(this.nativeHandle, key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    encodeDouble(this.nativeHandle, key, ((Double) value).doubleValue());
                } else if (value instanceof String) {
                    encodeString(this.nativeHandle, key, (String) value);
                } else if (value instanceof Set) {
                    encode(key, (Set<String>) value);
                } else {
                    simpleLog(NativeKVLogLevel.LevelError, "unknown type: " + value.getClass());
                }
            }
        }
        return all.size();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public String getString(String key, String defValue) {
        return decodeString(this.nativeHandle, key, defValue);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String key, String value) {
        encodeString(this.nativeHandle, key, value);
        return this;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String key, Set<String> defValues) {
        return decodeStringSet(key, defValues);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String key, Set<String> values) {
        encode(key, values);
        return this;
    }

    public SharedPreferences.Editor putBytes(String key, byte[] bytes) {
        encode(key, bytes);
        return this;
    }

    public byte[] getBytes(String key, byte[] defValue) {
        return decodeBytes(key, defValue);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String key, int defValue) {
        return decodeInt(this.nativeHandle, key, defValue);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String key, int value) {
        encodeInt(this.nativeHandle, key, value);
        return this;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String key, long defValue) {
        return decodeLong(this.nativeHandle, key, defValue);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String key, long value) {
        encodeLong(this.nativeHandle, key, value);
        return this;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String key, float defValue) {
        return decodeFloat(this.nativeHandle, key, defValue);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String key, float value) {
        encodeFloat(this.nativeHandle, key, value);
        return this;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String key, boolean defValue) {
        return decodeBool(this.nativeHandle, key, defValue);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String key, boolean value) {
        encodeBool(this.nativeHandle, key, value);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String key) {
        removeValueForKey(key);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public void apply() {
        sync(false);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String key) {
        return containsKey(key);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    public static NativeKV nativeKVWithAshmemFD(String mmapID, int fd, int metaFD, String cryptKey) throws RuntimeException {
        long nativeKVWithAshmemFD = getNativeKVWithAshmemFD(mmapID, fd, metaFD, cryptKey);
        if (nativeKVWithAshmemFD == 0) {
            throw new RuntimeException("Fail to create an ashmem MMKV instance [" + mmapID + "] in JNI");
        }
        return new NativeKV(nativeKVWithAshmemFD);
    }

    public static NativeBuffer createNativeBuffer(int size) {
        long jCreateNB = createNB(size);
        if (jCreateNB <= 0) {
            return null;
        }
        return new NativeBuffer(jCreateNB, size);
    }

    public static void destroyNativeBuffer(NativeBuffer buffer) {
        destroyNB(buffer.pointer, buffer.size);
    }

    public int writeValueToNativeBuffer(String key, NativeBuffer buffer) {
        return writeValueToNB(this.nativeHandle, key, buffer.pointer, buffer.size);
    }

    public static void registerHandler(NativeKVHandler handler) {
        gCallbackHandler = handler;
        if (handler.wantLogRedirecting()) {
            setCallbackHandler(true, true);
            gWantLogReDirecting = true;
        } else {
            setCallbackHandler(false, true);
            gWantLogReDirecting = false;
        }
    }

    public static void unregisterHandler() {
        gCallbackHandler = null;
        setCallbackHandler(false, false);
        gWantLogReDirecting = false;
    }

    private static int onNativeKVCRCCheckFail(String mmapID) {
        NativeKVRecoverStrategic nativeKVRecoverStrategicOnMMKVCRCCheckFail = NativeKVRecoverStrategic.OnErrorDiscard;
        NativeKVHandler nativeKVHandler = gCallbackHandler;
        if (nativeKVHandler != null) {
            nativeKVRecoverStrategicOnMMKVCRCCheckFail = nativeKVHandler.onMMKVCRCCheckFail(mmapID);
        }
        simpleLog(NativeKVLogLevel.LevelInfo, "Recover strategic for " + mmapID + " is " + nativeKVRecoverStrategicOnMMKVCRCCheckFail);
        Integer num = recoverIndex.get(nativeKVRecoverStrategicOnMMKVCRCCheckFail);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onNativeKVFileLengthError(String mmapID) {
        NativeKVRecoverStrategic nativeKVRecoverStrategicOnMMKVFileLengthError = NativeKVRecoverStrategic.OnErrorDiscard;
        NativeKVHandler nativeKVHandler = gCallbackHandler;
        if (nativeKVHandler != null) {
            nativeKVRecoverStrategicOnMMKVFileLengthError = nativeKVHandler.onMMKVFileLengthError(mmapID);
        }
        simpleLog(NativeKVLogLevel.LevelInfo, "Recover strategic for " + mmapID + " is " + nativeKVRecoverStrategicOnMMKVFileLengthError);
        Integer num = recoverIndex.get(nativeKVRecoverStrategicOnMMKVFileLengthError);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static void nativekvLogImp(int level, String file, int line, String function, String message) {
        NativeKVHandler nativeKVHandler = gCallbackHandler;
        if (nativeKVHandler != null && gWantLogReDirecting) {
            nativeKVHandler.mmkvLog(index2LogLevel[level], file, line, function, message);
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$nativekv$NativeKVLogLevel[index2LogLevel[level].ordinal()];
        if (i == 1) {
            Log.d("MMKV", message);
            return;
        }
        if (i == 2) {
            Log.w("MMKV", message);
        } else if (i == 3) {
            Log.e("MMKV", message);
        } else {
            if (i != 5) {
                return;
            }
            Log.i("MMKV", message);
        }
    }

    private static void simpleLog(NativeKVLogLevel level, String message) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[r0.length - 1];
        Integer num = logLevel2Index.get(level);
        nativekvLogImp(num == null ? 0 : num.intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), message);
    }

    public static void registerContentChangeNotify(NativeKVContentChangeNotification notify) {
        gContentChangeNotify = notify;
        setWantsContentChangeNotify(notify != null);
    }

    public static void unregisterContentChangeNotify() {
        gContentChangeNotify = null;
        setWantsContentChangeNotify(false);
    }

    private static void onContentChangedByOuterProcess(String mmapID) {
        NativeKVContentChangeNotification nativeKVContentChangeNotification = gContentChangeNotify;
        if (nativeKVContentChangeNotification != null) {
            nativeKVContentChangeNotification.onContentChangedByOuterProcess(mmapID);
        }
    }

    private NativeKV(long handle) {
        this.nativeHandle = handle;
    }
}
