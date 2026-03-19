package com.lingku.xuanshang.xutils.http.loader;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.lingku.xuanshang.xutils.cache.DiskCacheEntity;
import com.lingku.xuanshang.xutils.cache.DiskCacheFile;
import com.lingku.xuanshang.xutils.cache.LruDiskCache;
import com.lingku.xuanshang.xutils.common.Callback;
import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.common.util.ProcessLock;
import com.lingku.xuanshang.xutils.ex.FileLockedException;
import com.lingku.xuanshang.xutils.ex.HttpException;
import com.lingku.xuanshang.xutils.http.ProgressHandler;
import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.http.request.UriRequest;
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

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class FileLoader extends Loader<File> {
    public RequestParams a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;
    public long f;
    public String g;
    public DiskCacheFile h;

    public static String a(UriRequest uriRequest) throws UnsupportedEncodingException {
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

    public final File a(File file) {
        if (this.e && file.exists() && !TextUtils.isEmpty(this.g)) {
            File file2 = new File(file.getParent(), this.g);
            while (file2.exists()) {
                file2 = new File(file.getParent(), System.currentTimeMillis() + this.g);
            }
            return file.renameTo(file2) ? file2 : file;
        }
        if (this.c.equals(this.b)) {
            return file;
        }
        File file3 = new File(this.c);
        return file.renameTo(file3) ? file3 : file;
    }

    public final void b(UriRequest uriRequest) throws IOException {
        DiskCacheEntity diskCacheEntity = new DiskCacheEntity();
        diskCacheEntity.setKey(uriRequest.getCacheKey());
        DiskCacheFile diskCacheFileCreateDiskCacheFile = LruDiskCache.getDiskCache(this.a.getCacheDirName()).createDiskCacheFile(diskCacheEntity);
        this.h = diskCacheFileCreateDiskCacheFile;
        if (diskCacheFileCreateDiskCacheFile == null) {
            throw new IOException("create cache file error:" + uriRequest.getCacheKey());
        }
        String absolutePath = diskCacheFileCreateDiskCacheFile.getAbsolutePath();
        this.c = absolutePath;
        this.b = absolutePath;
        this.e = false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public File load(UriRequest uriRequest) {
        File fileA;
        boolean zContains;
        ProcessLock processLockTryLock = null;
        try {
            try {
                String saveFilePath = this.a.getSaveFilePath();
                this.c = saveFilePath;
                this.h = null;
                if (TextUtils.isEmpty(saveFilePath)) {
                    ProgressHandler progressHandler = this.progressHandler;
                    if (progressHandler != null && !progressHandler.updateProgress(0L, 0L, false)) {
                        throw new Callback.CancelledException("download stopped!");
                    }
                    b(uriRequest);
                } else {
                    this.b = this.c + ".tmp";
                }
                ProgressHandler progressHandler2 = this.progressHandler;
                if (progressHandler2 != null && !progressHandler2.updateProgress(0L, 0L, false)) {
                    throw new Callback.CancelledException("download stopped!");
                }
                zContains = true;
                processLockTryLock = ProcessLock.tryLock(this.c + "_lock", true);
            } catch (HttpException e) {
                if (e.getCode() != 416) {
                    throw e;
                }
                DiskCacheFile diskCacheFile = this.h;
                File fileCommit = diskCacheFile != null ? diskCacheFile.commit() : new File(this.b);
                if (fileCommit == null || !fileCommit.exists()) {
                    IOUtil.deleteFileOrDir(fileCommit);
                    throw new IllegalStateException("cache file not found" + uriRequest.getCacheKey());
                }
                if (this.e) {
                    this.g = a(uriRequest);
                }
                fileA = a(fileCommit);
            }
            if (processLockTryLock == null || !processLockTryLock.isValid()) {
                throw new FileLockedException("download exists: " + this.c);
            }
            this.a = uriRequest.getParams();
            long j = 0;
            if (this.d) {
                File file = new File(this.b);
                long length = file.length();
                if (length <= 512) {
                    IOUtil.deleteFileOrDir(file);
                } else {
                    j = length - 512;
                }
            }
            this.a.setHeader("Range", "bytes=" + j + "-");
            ProgressHandler progressHandler3 = this.progressHandler;
            if (progressHandler3 != null && !progressHandler3.updateProgress(0L, 0L, false)) {
                throw new Callback.CancelledException("download stopped!");
            }
            uriRequest.sendRequest();
            this.f = uriRequest.getContentLength();
            if (this.e) {
                this.g = a(uriRequest);
            }
            if (this.d) {
                String responseHeader = uriRequest.getResponseHeader("Accept-Ranges");
                if (responseHeader != null) {
                    zContains = responseHeader.contains("bytes");
                } else {
                    String responseHeader2 = uriRequest.getResponseHeader("Content-Range");
                    if (responseHeader2 == null || !responseHeader2.contains("bytes")) {
                        zContains = false;
                    }
                }
                this.d = zContains;
            }
            ProgressHandler progressHandler4 = this.progressHandler;
            if (progressHandler4 != null && !progressHandler4.updateProgress(0L, 0L, false)) {
                throw new Callback.CancelledException("download stopped!");
            }
            DiskCacheFile diskCacheFile2 = this.h;
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
            fileA = load(uriRequest.getInputStream());
            return fileA;
        } finally {
            IOUtil.closeQuietly((Closeable) null);
            IOUtil.closeQuietly(this.h);
        }
    }

    public File load(InputStream inputStream) throws Throwable {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        FileInputStream fileInputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            File file = new File(this.b);
            if (file.isDirectory()) {
                throw new IOException("could not create the file: " + this.b);
            }
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if ((!parentFile.exists() && !parentFile.mkdirs()) || !parentFile.isDirectory()) {
                    throw new IOException("could not create the dir: " + parentFile.getAbsolutePath());
                }
            }
            long length = file.length();
            if (this.d && length > 0) {
                long j = length - 512;
                try {
                    if (j <= 0) {
                        IOUtil.deleteFileOrDir(file);
                        throw new RuntimeException("need retry");
                    }
                    fileInputStream = new FileInputStream(file);
                    try {
                        if (!Arrays.equals(IOUtil.readBytes(inputStream, 0L, 512), IOUtil.readBytes(fileInputStream, j, 512))) {
                            IOUtil.closeQuietly(fileInputStream);
                            IOUtil.deleteFileOrDir(file);
                            throw new RuntimeException("need retry");
                        }
                        this.f -= 512;
                        IOUtil.closeQuietly(fileInputStream);
                    } catch (Throwable th) {
                        th = th;
                        IOUtil.closeQuietly(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
            }
            if (this.d) {
                fileOutputStream = new FileOutputStream(file, true);
            } else {
                fileOutputStream = new FileOutputStream(file);
                length = 0;
            }
            long j2 = this.f + length;
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(fileOutputStream);
                try {
                    ProgressHandler progressHandler = this.progressHandler;
                    if (progressHandler != null) {
                        bufferedOutputStream = bufferedOutputStream3;
                        try {
                            if (!progressHandler.updateProgress(j2, length, true)) {
                                throw new Callback.CancelledException("download stopped!");
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedOutputStream2 = bufferedOutputStream;
                            IOUtil.closeQuietly(bufferedInputStream);
                            IOUtil.closeQuietly(bufferedOutputStream2);
                            throw th;
                        }
                    } else {
                        bufferedOutputStream = bufferedOutputStream3;
                    }
                    byte[] bArr = new byte[4096];
                    while (true) {
                        long j3 = length;
                        int i = bufferedInputStream.read(bArr);
                        if (i == -1) {
                            bufferedOutputStream.flush();
                            DiskCacheFile diskCacheFile = this.h;
                            if (diskCacheFile != null) {
                                file = diskCacheFile.commit();
                            }
                            ProgressHandler progressHandler2 = this.progressHandler;
                            if (progressHandler2 != null) {
                                progressHandler2.updateProgress(j2, j3, true);
                            }
                            IOUtil.closeQuietly(bufferedInputStream);
                            IOUtil.closeQuietly(bufferedOutputStream);
                            return a(file);
                        }
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                            throw new IOException("parent be deleted!");
                        }
                        bufferedOutputStream.write(bArr, 0, i);
                        length = i + j3;
                        ProgressHandler progressHandler3 = this.progressHandler;
                        if (progressHandler3 != null && !progressHandler3.updateProgress(j2, length, false)) {
                            bufferedOutputStream.flush();
                            throw new Callback.CancelledException("download stopped!");
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedOutputStream = bufferedOutputStream3;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public File loadFromCache(DiskCacheEntity diskCacheEntity) {
        return LruDiskCache.getDiskCache(this.a.getCacheDirName()).getDiskCacheFile(diskCacheEntity.getKey());
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Loader<File> newInstance() {
        return new FileLoader();
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public void setParams(RequestParams requestParams) {
        if (requestParams != null) {
            this.a = requestParams;
            this.d = requestParams.isAutoResume();
            this.e = requestParams.isAutoRename();
        }
    }
}
