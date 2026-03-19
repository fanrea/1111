package com.duoyou.task.sdk.xutils.http.body;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.duoyou.task.sdk.xutils.common.Callback;
import com.duoyou.task.sdk.xutils.common.util.KeyValue;
import com.duoyou.task.sdk.xutils.http.BaseParams;
import com.duoyou.task.sdk.xutils.http.ProgressHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MultipartBody implements ProgressBody {
    private static byte[] BOUNDARY_PREFIX_BYTES = "--------7da3d81520810".getBytes();
    private static byte[] END_BYTES = "\r\n".getBytes();
    private static byte[] TWO_DASHES_BYTES = "--".getBytes();
    private byte[] boundaryPostfixBytes;
    private ProgressHandler callBackHandler;
    private String charset;
    private String contentType;
    private long current = 0;
    private List<KeyValue> multipartParams;
    private long total;

    public MultipartBody(List<KeyValue> list, String str) {
        this.charset = "UTF-8";
        this.total = 0L;
        if (!TextUtils.isEmpty(str)) {
            this.charset = str;
        }
        this.multipartParams = list;
        generateContentType();
        CounterOutputStream counterOutputStream = new CounterOutputStream();
        try {
            writeTo(counterOutputStream);
            this.total = counterOutputStream.total.get();
        } catch (IOException unused) {
            this.total = -1L;
        }
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.ProgressBody
    public void setProgressHandler(ProgressHandler progressHandler) {
        this.callBackHandler = progressHandler;
    }

    private void generateContentType() {
        String hexString = Double.toHexString(Math.random() * 65535.0d);
        this.boundaryPostfixBytes = hexString.getBytes();
        this.contentType = "multipart/form-data; boundary=" + new String(BOUNDARY_PREFIX_BYTES) + hexString;
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public long getContentLength() {
        return this.total;
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public void setContentType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.contentType = "multipart/" + str + this.contentType.substring(this.contentType.indexOf(i.b));
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public String getContentType() {
        return this.contentType;
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        ProgressHandler progressHandler = this.callBackHandler;
        if (progressHandler != null && !progressHandler.updateProgress(this.total, this.current, true)) {
            throw new Callback.CancelledException("upload stopped!");
        }
        Iterator<KeyValue> it = this.multipartParams.iterator();
        while (it.hasNext()) {
            writeEntry(outputStream, it.next());
        }
        byte[] bArr = TWO_DASHES_BYTES;
        writeLine(outputStream, bArr, BOUNDARY_PREFIX_BYTES, this.boundaryPostfixBytes, bArr);
        outputStream.flush();
        ProgressHandler progressHandler2 = this.callBackHandler;
        if (progressHandler2 != null) {
            progressHandler2.updateProgress(this.total, this.current, true);
        }
    }

    private void writeEntry(OutputStream outputStream, KeyValue keyValue) throws IOException {
        String name;
        byte[] bytes;
        String str = keyValue.key;
        Object obj = keyValue.value;
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        writeLine(outputStream, TWO_DASHES_BYTES, BOUNDARY_PREFIX_BYTES, this.boundaryPostfixBytes);
        String fileContentType = null;
        if (keyValue instanceof BaseParams.BodyItemWrapper) {
            BaseParams.BodyItemWrapper bodyItemWrapper = (BaseParams.BodyItemWrapper) keyValue;
            name = bodyItemWrapper.fileName;
            fileContentType = bodyItemWrapper.contentType;
        } else {
            name = "";
        }
        if (obj instanceof File) {
            File file = (File) obj;
            if (TextUtils.isEmpty(name)) {
                name = file.getName();
            }
            if (TextUtils.isEmpty(fileContentType)) {
                fileContentType = FileBody.getFileContentType(file);
            }
            writeLine(outputStream, buildContentDisposition(str, name, this.charset));
            writeLine(outputStream, buildContentType(obj, fileContentType, this.charset));
            writeLine(outputStream, new byte[0][]);
            writeFile(outputStream, file);
            writeLine(outputStream, new byte[0][]);
            return;
        }
        writeLine(outputStream, buildContentDisposition(str, name, this.charset));
        writeLine(outputStream, buildContentType(obj, fileContentType, this.charset));
        writeLine(outputStream, new byte[0][]);
        if (obj instanceof InputStream) {
            writeStreamAndCloseIn(outputStream, (InputStream) obj);
            writeLine(outputStream, new byte[0][]);
            return;
        }
        if (obj instanceof byte[]) {
            bytes = (byte[]) obj;
        } else {
            bytes = keyValue.getValueStrOrEmpty().getBytes(this.charset);
        }
        writeLine(outputStream, bytes);
        long length = this.current + bytes.length;
        this.current = length;
        ProgressHandler progressHandler = this.callBackHandler;
        if (progressHandler != null && !progressHandler.updateProgress(this.total, length, false)) {
            throw new Callback.CancelledException("upload stopped!");
        }
    }

    private void writeLine(OutputStream outputStream, byte[]... bArr) throws IOException {
        if (bArr != null) {
            for (byte[] bArr2 : bArr) {
                outputStream.write(bArr2);
            }
        }
        outputStream.write(END_BYTES);
    }

    private void writeFile(OutputStream outputStream, File file) {
        if (outputStream instanceof CounterOutputStream) {
            ((CounterOutputStream) outputStream).addFile(file);
        } else {
            writeStreamAndCloseIn(outputStream, new FileInputStream(file));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        throw new com.duoyou.task.sdk.xutils.common.Callback.CancelledException("upload stopped!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void writeStreamAndCloseIn(java.io.OutputStream r13, java.io.InputStream r14) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.duoyou.task.sdk.xutils.http.body.MultipartBody.CounterOutputStream
            if (r0 == 0) goto La
            com.duoyou.task.sdk.xutils.http.body.MultipartBody$CounterOutputStream r13 = (com.duoyou.task.sdk.xutils.http.body.MultipartBody.CounterOutputStream) r13
            r13.addStream(r14)
            goto L38
        La:
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L39
        Le:
            int r1 = r14.read(r0)     // Catch: java.lang.Throwable -> L39
            if (r1 < 0) goto L35
            r2 = 0
            r13.write(r0, r2, r1)     // Catch: java.lang.Throwable -> L39
            long r2 = r12.current     // Catch: java.lang.Throwable -> L39
            long r4 = (long) r1     // Catch: java.lang.Throwable -> L39
            long r9 = r2 + r4
            r12.current = r9     // Catch: java.lang.Throwable -> L39
            com.duoyou.task.sdk.xutils.http.ProgressHandler r6 = r12.callBackHandler     // Catch: java.lang.Throwable -> L39
            if (r6 == 0) goto Le
            long r7 = r12.total     // Catch: java.lang.Throwable -> L39
            r11 = 0
            boolean r1 = r6.updateProgress(r7, r9, r11)     // Catch: java.lang.Throwable -> L39
            if (r1 == 0) goto L2d
            goto Le
        L2d:
            com.duoyou.task.sdk.xutils.common.Callback$CancelledException r13 = new com.duoyou.task.sdk.xutils.common.Callback$CancelledException     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = "upload stopped!"
            r13.<init>(r0)     // Catch: java.lang.Throwable -> L39
            throw r13     // Catch: java.lang.Throwable -> L39
        L35:
            com.duoyou.task.sdk.xutils.common.util.IOUtil.closeQuietly(r14)
        L38:
            return
        L39:
            r13 = move-exception
            com.duoyou.task.sdk.xutils.common.util.IOUtil.closeQuietly(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duoyou.task.sdk.xutils.http.body.MultipartBody.writeStreamAndCloseIn(java.io.OutputStream, java.io.InputStream):void");
    }

    private static byte[] buildContentDisposition(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("Content-Disposition: form-data");
        sb.append("; name=\"").append(str.replace("\"", "\\\"")).append("\"");
        if (!TextUtils.isEmpty(str2)) {
            sb.append("; filename=\"").append(str2.replace("\"", "\\\"")).append("\"");
        }
        return sb.toString().getBytes(str3);
    }

    private static byte[] buildContentType(Object obj, String str, String str2) {
        String strReplaceFirst;
        StringBuilder sb = new StringBuilder("Content-Type: ");
        if (TextUtils.isEmpty(str)) {
            strReplaceFirst = obj instanceof String ? "text/plain; charset=" + str2 : MediaTypeUtils.APPLICATION_OCTET_STREAM;
        } else {
            strReplaceFirst = str.replaceFirst("\\/jpg$", "/jpeg");
        }
        sb.append(strReplaceFirst);
        return sb.toString().getBytes(str2);
    }

    public class CounterOutputStream extends OutputStream {
        public final AtomicLong total = new AtomicLong(0);

        public CounterOutputStream() {
        }

        public void addFile(File file) {
            if (this.total.get() == -1) {
                return;
            }
            this.total.addAndGet(file.length());
        }

        public void addStream(InputStream inputStream) {
            if (this.total.get() == -1) {
                return;
            }
            long inputStreamLength = InputStreamBody.getInputStreamLength(inputStream);
            if (inputStreamLength > 0) {
                this.total.addAndGet(inputStreamLength);
            } else {
                this.total.set(-1L);
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            if (this.total.get() == -1) {
                return;
            }
            this.total.incrementAndGet();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            if (this.total.get() == -1) {
                return;
            }
            this.total.addAndGet(bArr.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            if (this.total.get() == -1) {
                return;
            }
            this.total.addAndGet(i2);
        }
    }
}
