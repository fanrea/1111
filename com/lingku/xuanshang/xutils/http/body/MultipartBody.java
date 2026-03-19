package com.lingku.xuanshang.xutils.http.body;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.lingku.xuanshang.xutils.common.Callback;
import com.lingku.xuanshang.xutils.common.util.KeyValue;
import com.lingku.xuanshang.xutils.http.BaseParams;
import com.lingku.xuanshang.xutils.http.ProgressHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class MultipartBody implements ProgressBody {
    public static byte[] a = "--------7da3d81520810".getBytes();
    public static byte[] b = "\r\n".getBytes();
    public static byte[] c = "--".getBytes();
    public byte[] d;
    public String e;
    public String f;
    public List<KeyValue> g;
    public long h;
    public long i = 0;
    public ProgressHandler j;

    public class a extends OutputStream {
        public final AtomicLong a = new AtomicLong(0);

        public a(MultipartBody multipartBody) {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            if (this.a.get() == -1) {
                return;
            }
            this.a.incrementAndGet();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            if (this.a.get() == -1) {
                return;
            }
            this.a.addAndGet(bArr.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            if (this.a.get() == -1) {
                return;
            }
            this.a.addAndGet(i2);
        }
    }

    public MultipartBody(List<KeyValue> list, String str) {
        this.f = "UTF-8";
        this.h = 0L;
        if (!TextUtils.isEmpty(str)) {
            this.f = str;
        }
        this.g = list;
        a();
        a aVar = new a(this);
        try {
            writeTo(aVar);
            this.h = aVar.a.get();
        } catch (IOException unused) {
            this.h = -1L;
        }
    }

    public static byte[] a(Object obj, String str, String str2) {
        StringBuilder sb = new StringBuilder("Content-Type: ");
        sb.append(TextUtils.isEmpty(str) ? obj instanceof String ? "text/plain; charset=" + str2 : MediaTypeUtils.APPLICATION_OCTET_STREAM : str.replaceFirst("\\/jpg$", "/jpeg"));
        return sb.toString().getBytes(str2);
    }

    public static byte[] a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("Content-Disposition: form-data");
        sb.append("; name=\"").append(str.replace("\"", "\\\"")).append("\"");
        if (!TextUtils.isEmpty(str2)) {
            sb.append("; filename=\"").append(str2.replace("\"", "\\\"")).append("\"");
        }
        return sb.toString().getBytes(str3);
    }

    public final void a() {
        String hexString = Double.toHexString(Math.random() * 65535.0d);
        this.d = hexString.getBytes();
        this.e = "multipart/form-data; boundary=" + new String(a) + hexString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
    
        throw new com.lingku.xuanshang.xutils.common.Callback.CancelledException("upload stopped!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.io.OutputStream r13, java.io.InputStream r14) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.lingku.xuanshang.xutils.http.body.MultipartBody.a
            if (r0 == 0) goto L27
            com.lingku.xuanshang.xutils.http.body.MultipartBody$a r13 = (com.lingku.xuanshang.xutils.http.body.MultipartBody.a) r13
            java.util.concurrent.atomic.AtomicLong r0 = r13.a
            long r0 = r0.get()
            r2 = -1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L13
            goto L56
        L13:
            long r0 = com.lingku.xuanshang.xutils.http.body.InputStreamBody.getInputStreamLength(r14)
            r4 = 0
            int r14 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            java.util.concurrent.atomic.AtomicLong r13 = r13.a
            if (r14 <= 0) goto L23
            r13.addAndGet(r0)
            goto L56
        L23:
            r13.set(r2)
            goto L56
        L27:
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L57
        L2b:
            int r1 = r14.read(r0)     // Catch: java.lang.Throwable -> L57
            if (r1 < 0) goto L53
            r2 = 0
            r13.write(r0, r2, r1)     // Catch: java.lang.Throwable -> L57
            long r2 = r12.i     // Catch: java.lang.Throwable -> L57
            long r4 = (long) r1     // Catch: java.lang.Throwable -> L57
            long r9 = r2 + r4
            r12.i = r9     // Catch: java.lang.Throwable -> L57
            com.lingku.xuanshang.xutils.http.ProgressHandler r6 = r12.j     // Catch: java.lang.Throwable -> L57
            if (r6 == 0) goto L2b
            long r7 = r12.h     // Catch: java.lang.Throwable -> L57
            r11 = 0
            boolean r1 = r6.updateProgress(r7, r9, r11)     // Catch: java.lang.Throwable -> L57
            if (r1 == 0) goto L4a
            goto L2b
        L4a:
            com.lingku.xuanshang.xutils.common.Callback$CancelledException r13 = new com.lingku.xuanshang.xutils.common.Callback$CancelledException     // Catch: java.lang.Throwable -> L57
            java.lang.String r0 = "upload stopped!"
            r13.<init>(r0)     // Catch: java.lang.Throwable -> L57
            throw r13     // Catch: java.lang.Throwable -> L57
        L53:
            com.lingku.xuanshang.xutils.common.util.IOUtil.closeQuietly(r14)
        L56:
            return
        L57:
            r13 = move-exception
            com.lingku.xuanshang.xutils.common.util.IOUtil.closeQuietly(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.xutils.http.body.MultipartBody.a(java.io.OutputStream, java.io.InputStream):void");
    }

    public final void a(OutputStream outputStream, byte[]... bArr) throws IOException {
        for (byte[] bArr2 : bArr) {
            outputStream.write(bArr2);
        }
        outputStream.write(b);
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public long getContentLength() {
        return this.h;
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public String getContentType() {
        return this.e;
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public void setContentType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e = "multipart/" + str + this.e.substring(this.e.indexOf(i.b));
    }

    @Override // com.lingku.xuanshang.xutils.http.body.ProgressBody
    public void setProgressHandler(ProgressHandler progressHandler) {
        this.j = progressHandler;
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        String name;
        ProgressHandler progressHandler = this.j;
        if (progressHandler != null && !progressHandler.updateProgress(this.h, this.i, true)) {
            throw new Callback.CancelledException("upload stopped!");
        }
        for (KeyValue keyValue : this.g) {
            String str = keyValue.key;
            Object obj = keyValue.value;
            if (!TextUtils.isEmpty(str) && obj != null) {
                a(outputStream, c, a, this.d);
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
                    a(outputStream, a(str, name, this.f));
                    a(outputStream, a(obj, fileContentType, this.f));
                    a(outputStream, new byte[0][]);
                    if (outputStream instanceof a) {
                        a aVar = (a) outputStream;
                        if (aVar.a.get() != -1) {
                            aVar.a.addAndGet(file.length());
                        }
                    } else {
                        a(outputStream, new FileInputStream(file));
                    }
                    a(outputStream, new byte[0][]);
                } else {
                    a(outputStream, a(str, name, this.f));
                    a(outputStream, a(obj, fileContentType, this.f));
                    a(outputStream, new byte[0][]);
                    if (obj instanceof InputStream) {
                        a(outputStream, (InputStream) obj);
                        a(outputStream, new byte[0][]);
                    } else {
                        a(outputStream, obj instanceof byte[] ? (byte[]) obj : keyValue.getValueStrOrEmpty().getBytes(this.f));
                        long length = this.i + r8.length;
                        this.i = length;
                        ProgressHandler progressHandler2 = this.j;
                        if (progressHandler2 != null && !progressHandler2.updateProgress(this.h, length, false)) {
                            throw new Callback.CancelledException("upload stopped!");
                        }
                    }
                }
            }
        }
        byte[] bArr = c;
        a(outputStream, bArr, a, this.d, bArr);
        outputStream.flush();
        ProgressHandler progressHandler3 = this.j;
        if (progressHandler3 != null) {
            progressHandler3.updateProgress(this.h, this.i, true);
        }
    }
}
