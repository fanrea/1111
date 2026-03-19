package com.nativekv;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface NativeKVHandler {
    void mmkvLog(NativeKVLogLevel level, String file, int line, String function, String message);

    NativeKVRecoverStrategic onMMKVCRCCheckFail(String mmapID);

    NativeKVRecoverStrategic onMMKVFileLengthError(String mmapID);

    boolean wantLogRedirecting();
}
