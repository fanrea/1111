package com.duoyou.task.sdk.xutils.http.loader;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.duoyou.task.sdk.xutils.cache.DiskCacheEntity;
import com.duoyou.task.sdk.xutils.cache.DiskCacheFile;
import com.duoyou.task.sdk.xutils.cache.LruDiskCache;
import com.duoyou.task.sdk.xutils.common.Callback;
import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.common.util.ProcessLock;
import com.duoyou.task.sdk.xutils.ex.FileLockedException;
import com.duoyou.task.sdk.xutils.ex.HttpException;
import com.duoyou.task.sdk.xutils.http.ProgressHandler;
import com.duoyou.task.sdk.xutils.http.RequestParams;
import com.duoyou.task.sdk.xutils.http.request.UriRequest;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Date;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FileLoader extends Loader<File> {
    private static final int CHECK_SIZE = 512;
    private long contentLength;
    private DiskCacheFile diskCacheFile;
    private boolean isAutoRename;
    private boolean isAutoResume;
    private RequestParams params;
    private String responseFileName;
    private String saveFilePath;
    private String tempSaveFilePath;

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public Loader<File> newInstance() {
        return new FileLoader();
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public void setParams(RequestParams requestParams) {
        if (requestParams != null) {
            this.params = requestParams;
            this.isAutoResume = requestParams.isAutoResume();
            this.isAutoRename = requestParams.isAutoRename();
        }
    }

    public File load(InputStream inputStream) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            File file = new File(this.tempSaveFilePath);
            if (file.isDirectory()) {
                throw new IOException("could not create the file: " + this.tempSaveFilePath);
            }
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if ((!parentFile.exists() && !parentFile.mkdirs()) || !parentFile.isDirectory()) {
                    throw new IOException("could not create the dir: " + parentFile.getAbsolutePath());
                }
            }
            long length = file.length();
            if (this.isAutoResume && length > 0) {
                long j = length - 512;
                try {
                    if (j > 0) {
                        fileInputStream = new FileInputStream(file);
                        try {
                            if (!Arrays.equals(IOUtil.readBytes(inputStream, 0L, 512), IOUtil.readBytes(fileInputStream, j, 512))) {
                                IOUtil.closeQuietly(fileInputStream);
                                IOUtil.deleteFileOrDir(file);
                                throw new RuntimeException("need retry");
                            }
                            this.contentLength -= 512;
                            IOUtil.closeQuietly(fileInputStream);
                        } catch (Throwable th) {
                            th = th;
                            IOUtil.closeQuietly(fileInputStream);
                            throw th;
                        }
                    } else {
                        IOUtil.deleteFileOrDir(file);
                        throw new RuntimeException("need retry");
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
            }
            if (this.isAutoResume) {
                fileOutputStream = new FileOutputStream(file, true);
            } else {
                fileOutputStream = new FileOutputStream(file);
                length = 0;
            }
            long j2 = this.contentLength + length;
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
            try {
                ProgressHandler progressHandler = this.progressHandler;
                if (progressHandler != null && !progressHandler.updateProgress(j2, length, true)) {
                    throw new Callback.CancelledException("download stopped!");
                }
                byte[] bArr = new byte[4096];
                while (true) {
                    long j3 = length;
                    int i = bufferedInputStream2.read(bArr);
                    if (i != -1) {
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                            throw new IOException("parent be deleted!");
                        }
                        bufferedOutputStream2.write(bArr, 0, i);
                        length = i + j3;
                        ProgressHandler progressHandler2 = this.progressHandler;
                        if (progressHandler2 != null && !progressHandler2.updateProgress(j2, length, false)) {
                            bufferedOutputStream2.flush();
                            throw new Callback.CancelledException("download stopped!");
                        }
                    } else {
                        bufferedOutputStream2.flush();
                        DiskCacheFile diskCacheFile = this.diskCacheFile;
                        if (diskCacheFile != null) {
                            file = diskCacheFile.commit();
                        }
                        ProgressHandler progressHandler3 = this.progressHandler;
                        if (progressHandler3 != null) {
                            progressHandler3.updateProgress(j2, j3, true);
                        }
                        IOUtil.closeQuietly(bufferedInputStream2);
                        IOUtil.closeQuietly(bufferedOutputStream2);
                        return autoRename(file);
                    }
                }
            } catch (Throwable th4) {
                bufferedOutputStream = bufferedOutputStream2;
                th = th4;
                bufferedInputStream = bufferedInputStream2;
                IOUtil.closeQuietly(bufferedInputStream);
                IOUtil.closeQuietly(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public File load(UriRequest uriRequest) {
        File file;
        File fileAutoRename;
        ProcessLock processLockTryLock = null;
        try {
            try {
                String saveFilePath = this.params.getSaveFilePath();
                this.saveFilePath = saveFilePath;
                this.diskCacheFile = null;
                if (TextUtils.isEmpty(saveFilePath)) {
                    ProgressHandler progressHandler = this.progressHandler;
                    if (progressHandler != null && !progressHandler.updateProgress(0L, 0L, false)) {
                        throw new Callback.CancelledException("download stopped!");
                    }
                    initDiskCacheFile(uriRequest);
                } else {
                    this.tempSaveFilePath = this.saveFilePath + ".tmp";
                }
                ProgressHandler progressHandler2 = this.progressHandler;
                if (progressHandler2 != null && !progressHandler2.updateProgress(0L, 0L, false)) {
                    throw new Callback.CancelledException("download stopped!");
                }
                processLockTryLock = ProcessLock.tryLock(this.saveFilePath + "_lock", true);
            } catch (HttpException e) {
                if (e.getCode() == 416) {
                    DiskCacheFile diskCacheFile = this.diskCacheFile;
                    if (diskCacheFile != null) {
                        file = diskCacheFile.commit();
                    } else {
                        file = new File(this.tempSaveFilePath);
                    }
                    if (file != null && file.exists()) {
                        if (this.isAutoRename) {
                            this.responseFileName = getResponseFileName(uriRequest);
                        }
                        fileAutoRename = autoRename(file);
                    } else {
                        IOUtil.deleteFileOrDir(file);
                        throw new IllegalStateException("cache file not found" + uriRequest.getCacheKey());
                    }
                } else {
                    throw e;
                }
            }
            if (processLockTryLock == null || !processLockTryLock.isValid()) {
                throw new FileLockedException("download exists: " + this.saveFilePath);
            }
            this.params = uriRequest.getParams();
            long j = 0;
            if (this.isAutoResume) {
                File file2 = new File(this.tempSaveFilePath);
                long length = file2.length();
                if (length <= 512) {
                    IOUtil.deleteFileOrDir(file2);
                } else {
                    j = length - 512;
                }
            }
            this.params.setHeader("Range", "bytes=" + j + "-");
            ProgressHandler progressHandler3 = this.progressHandler;
            if (progressHandler3 != null && !progressHandler3.updateProgress(0L, 0L, false)) {
                throw new Callback.CancelledException("download stopped!");
            }
            uriRequest.sendRequest();
            this.contentLength = uriRequest.getContentLength();
            if (this.isAutoRename) {
                this.responseFileName = getResponseFileName(uriRequest);
            }
            if (this.isAutoResume) {
                this.isAutoResume = isSupportRange(uriRequest);
            }
            ProgressHandler progressHandler4 = this.progressHandler;
            if (progressHandler4 != null && !progressHandler4.updateProgress(0L, 0L, false)) {
                throw new Callback.CancelledException("download stopped!");
            }
            DiskCacheFile diskCacheFile2 = this.diskCacheFile;
            if (diskCacheFile2 != null) {
                try {
                    DiskCacheEntity cacheEntity = diskCacheFile2.getCacheEntity();
                    cacheEntity.setLastAccess(System.currentTimeMillis());
                    cacheEntity.setEtag(uriRequest.getETag());
                    cacheEntity.setExpires(uriRequest.getExpiration());
                    cacheEntity.setLastModify(new Date(uriRequest.getLastModified()));
                } catch (Throwable th) {
                    LogUtil.e(th.getMessage(), th);
                }
            }
            fileAutoRename = load(uriRequest.getInputStream());
            return fileAutoRename;
        } finally {
            IOUtil.closeQuietly((Closeable) null);
            IOUtil.closeQuietly(this.diskCacheFile);
        }
    }

    private void initDiskCacheFile(UriRequest uriRequest) throws IOException {
        DiskCacheEntity diskCacheEntity = new DiskCacheEntity();
        diskCacheEntity.setKey(uriRequest.getCacheKey());
        DiskCacheFile diskCacheFileCreateDiskCacheFile = LruDiskCache.getDiskCache(this.params.getCacheDirName()).createDiskCacheFile(diskCacheEntity);
        this.diskCacheFile = diskCacheFileCreateDiskCacheFile;
        if (diskCacheFileCreateDiskCacheFile != null) {
            String absolutePath = diskCacheFileCreateDiskCacheFile.getAbsolutePath();
            this.saveFilePath = absolutePath;
            this.tempSaveFilePath = absolutePath;
            this.isAutoRename = false;
            return;
        }
        throw new IOException("create cache file error:" + uriRequest.getCacheKey());
    }

    private File autoRename(File file) {
        if (this.isAutoRename && file.exists() && !TextUtils.isEmpty(this.responseFileName)) {
            File file2 = new File(file.getParent(), this.responseFileName);
            while (file2.exists()) {
                file2 = new File(file.getParent(), System.currentTimeMillis() + this.responseFileName);
            }
            return file.renameTo(file2) ? file2 : file;
        }
        if (this.saveFilePath.equals(this.tempSaveFilePath)) {
            return file;
        }
        File file3 = new File(this.saveFilePath);
        return file.renameTo(file3) ? file3 : file;
    }

    private static String getResponseFileName(UriRequest uriRequest) throws UnsupportedEncodingException {
        int iIndexOf;
        if (uriRequest == null) {
            return null;
        }
        String responseHeader = uriRequest.getResponseHeader("Content-Disposition");
        if (!TextUtils.isEmpty(responseHeader) && (iIndexOf = responseHeader.indexOf("filename=")) > 0) {
            int i = iIndexOf + 9;
            int iIndexOf2 = responseHeader.indexOf(i.b, i);
            if (iIndexOf2 < 0) {
                iIndexOf2 = responseHeader.length();
            }
            if (iIndexOf2 > i) {
                try {
                    String strDecode = URLDecoder.decode(responseHeader.substring(i, iIndexOf2), uriRequest.getParams().getCharset());
                    return (strDecode.startsWith("\"") && strDecode.endsWith("\"")) ? strDecode.substring(1, strDecode.length() - 1) : strDecode;
                } catch (UnsupportedEncodingException e) {
                    LogUtil.e(e.getMessage(), e);
                }
            }
        }
        return null;
    }

    private static boolean isSupportRange(UriRequest uriRequest) {
        if (uriRequest == null) {
            return false;
        }
        String responseHeader = uriRequest.getResponseHeader("Accept-Ranges");
        if (responseHeader != null) {
            return responseHeader.contains("bytes");
        }
        String responseHeader2 = uriRequest.getResponseHeader("Content-Range");
        return responseHeader2 != null && responseHeader2.contains("bytes");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public File loadFromCache(DiskCacheEntity diskCacheEntity) {
        return LruDiskCache.getDiskCache(this.params.getCacheDirName()).getDiskCacheFile(diskCacheEntity.getKey());
    }
}
