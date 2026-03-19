package com.pandora.ttlicense2.loader;

import com.pandora.ttlicense2.utils.IOUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DiskCache {
    private static final Map<String, String> keyMap = new HashMap();
    private final File directory;

    interface Writer {

        public interface ProgressListener {
            void update(long bytesRead, long contentLength, boolean done);
        }

        void write(File file) throws IOException;
    }

    public DiskCache(File directory) {
        this.directory = directory;
    }

    public static String fileName(String key) {
        Map<String, String> map = keyMap;
        String str = map.get(key);
        if (str != null) {
            return str;
        }
        String str2 = md5(key) + ".lic";
        map.put(key, str2);
        return str2;
    }

    public void put(String key, Writer writer) throws IOException {
        String strFileName = fileName(key);
        File file = new File(this.directory, strFileName + ".tmp");
        if (file.exists()) {
            delete(file);
        }
        this.directory.mkdirs();
        file.createNewFile();
        writer.write(file);
        if (file.exists() && file.length() > 0) {
            File file2 = new File(this.directory, strFileName);
            if (file2.exists()) {
                delete(file2);
            }
            if (!file.renameTo(file2)) {
                throw new IOException(file + " -> " + file2 + " error!");
            }
            return;
        }
        file.delete();
    }

    public File get(String key) {
        File file = new File(this.directory, fileName(key));
        if (!file.exists() || file.length() <= 0) {
            return null;
        }
        return file;
    }

    public void remove(String key) {
        delete(new File(this.directory, fileName(key)));
    }

    public void clear() {
        delete(this.directory);
    }

    public static void delete(File file) {
        File[] fileArrListFiles;
        if (file == null) {
            return;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                delete(file2);
            }
        }
        file.delete();
    }

    public static long calLength(File file) {
        if (file == null) {
            return -1L;
        }
        long jCalLength = 0;
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return 0L;
            }
            for (File file2 : fileArrListFiles) {
                jCalLength += calLength(file2);
            }
            return jCalLength;
        }
        return file.length();
    }

    public static String md5(String input) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(input.getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (Exception unused) {
            return input;
        }
    }

    public static class InputStreamWriter implements Writer {
        private final long contentLength;
        private final InputStream data;
        private final Writer.ProgressListener listener;

        public InputStreamWriter(InputStream inputStream, long contentLength, Writer.ProgressListener listener) {
            this.data = inputStream;
            this.contentLength = contentLength;
            this.listener = listener;
        }

        @Override // com.pandora.ttlicense2.loader.DiskCache.Writer
        public void write(File file) throws Throwable {
            byte[] bArr = new byte[4096];
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                long j = 0;
                while (true) {
                    try {
                        int i = this.data.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        j += i;
                        Writer.ProgressListener progressListener = this.listener;
                        if (progressListener != null) {
                            progressListener.update(j, this.contentLength, false);
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                }
                Writer.ProgressListener progressListener2 = this.listener;
                if (progressListener2 != null) {
                    progressListener2.update(j, this.contentLength, true);
                }
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static class HttpWriter implements Writer {
        volatile boolean canceled;
        private final String httpUrl;
        private final Writer.ProgressListener listener;

        public HttpWriter(String httpUrl, Writer.ProgressListener listener) {
            this.httpUrl = httpUrl;
            this.listener = listener;
        }

        @Override // com.pandora.ttlicense2.loader.DiskCache.Writer
        public void write(File file) throws Throwable {
            InputStream inputStream;
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2;
            InputStream inputStream2 = null;
            try {
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(this.httpUrl).openConnection();
                try {
                    httpURLConnection3.setConnectTimeout(10000);
                    httpURLConnection3.setReadTimeout(10000);
                    httpURLConnection3.setInstanceFollowRedirects(true);
                    httpURLConnection3.setRequestMethod("GET");
                    httpURLConnection3.setDoInput(true);
                    httpURLConnection3.setUseCaches(false);
                    int responseCode = httpURLConnection3.getResponseCode();
                    String responseMessage = httpURLConnection3.getResponseMessage();
                    Map<String, List<String>> headerFields = httpURLConnection3.getHeaderFields();
                    String strHeaderValue = IOUtils.headerValue(headerFields, "Content-Type");
                    long j = IOUtils.parseLong(IOUtils.headerValue(headerFields, "Content-Length"));
                    if (responseCode == 200) {
                        InputStream inputStream3 = httpURLConnection3.getInputStream();
                        try {
                            new InputStreamWriter(new BufferedInputStream(inputStream3) { // from class: com.pandora.ttlicense2.loader.DiskCache.HttpWriter.1
                                @Override // java.io.FilterInputStream, java.io.InputStream
                                public int read(byte[] b) throws IOException {
                                    if (HttpWriter.this.canceled) {
                                        throw new IOException("canceled when read.");
                                    }
                                    return super.read(b);
                                }
                            }, j, this.listener).write(file);
                            IOUtils.closeQuietly(inputStream3);
                            IOUtils.closeQuietly(null);
                            if (httpURLConnection3 != null) {
                                try {
                                    httpURLConnection3.disconnect();
                                    return;
                                } catch (Exception unused) {
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            httpURLConnection2 = httpURLConnection3;
                            inputStream = null;
                            inputStream2 = inputStream3;
                        }
                    } else {
                        InputStream errorStream = httpURLConnection3.getErrorStream();
                        try {
                            throw new IOException("url = " + this.httpUrl + " code = " + responseCode + " msg = " + responseMessage + " contentType = " + strHeaderValue + " errorContent = " + IOUtils.inputStream2String(errorStream));
                        } catch (Throwable th2) {
                            httpURLConnection2 = httpURLConnection3;
                            inputStream = errorStream;
                            th = th2;
                        }
                    }
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection3;
                    inputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                httpURLConnection = null;
            }
            IOUtils.closeQuietly(inputStream2);
            IOUtils.closeQuietly(inputStream);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }

        public void cancel() {
            this.canceled = true;
        }
    }
}
