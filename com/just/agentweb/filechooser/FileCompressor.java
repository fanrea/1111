package com.just.agentweb.filechooser;

import android.net.Uri;
import android.webkit.ValueCallback;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FileCompressor implements Serializable {
    private static FileCompressor sInstance;
    private FileCompressEngine mFileCompressEngine;

    public interface FileCompressEngine {
        void compressFile(String str, Uri[] uriArr, ValueCallback<Uri[]> valueCallback);
    }

    FileCompressor() {
    }

    public static final FileCompressor getInstance() {
        if (sInstance == null) {
            synchronized (FileCompressor.class) {
                if (sInstance == null) {
                    sInstance = new FileCompressor();
                }
            }
        }
        return sInstance;
    }

    public void registerFileCompressEngine(FileCompressEngine fileCompressEngine) {
        this.mFileCompressEngine = fileCompressEngine;
    }

    public void unregisterFileCompressEngine(FileCompressEngine fileCompressEngine) {
        this.mFileCompressEngine = null;
    }

    void fileCompress(String str, Uri[] uriArr, ValueCallback<Uri[]> valueCallback) {
        FileCompressEngine fileCompressEngine = this.mFileCompressEngine;
        if (fileCompressEngine == null) {
            valueCallback.onReceiveValue(uriArr);
        } else {
            fileCompressEngine.compressFile(str, uriArr, valueCallback);
        }
    }
}
