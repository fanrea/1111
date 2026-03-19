package com.bytedance.sdk.component.an.b.d.d;

import com.bytedance.sdk.component.an.b.d.d.d;
import com.bytedance.sdk.component.utils.mq;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements com.bytedance.sdk.component.an.b {
    private long d;
    private d hc;

    public hc(File file, long j, ExecutorService executorService) {
        this.d = j;
        try {
            this.hc = d.d(file, 20210302, 1, j, executorService);
        } catch (IOException e) {
            mq.hc("LruCountDiskCache", e.toString());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.an.b
    public InputStream d(String str) {
        d dVar = this.hc;
        if (dVar == null) {
            return null;
        }
        try {
            d.b bVarD = dVar.d(str);
            if (bVarD != null) {
                return bVarD.d(0);
            }
        } catch (IOException e) {
            mq.hc("LruCountDiskCache", e.getMessage());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.an.d
    public boolean d(String str, byte[] bArr) throws Throwable {
        Closeable closeable;
        d dVar = this.hc;
        if (dVar == null || bArr == null || str == null) {
            return false;
        }
        Closeable closeable2 = null;
        d.C0270d c0270d = null;
        try {
            try {
                d.C0270d c0270dHc = dVar.hc(str);
                try {
                    if (c0270dHc == null) {
                        mq.hc("LruCountDiskCache", "save " + str + " failed for edit null");
                        com.bytedance.sdk.component.an.b.b.hc.d(null);
                        return false;
                    }
                    OutputStream outputStreamD = c0270dHc.d(0);
                    if (outputStreamD == d.b) {
                        mq.hc("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                        com.bytedance.sdk.component.an.b.b.hc.d(outputStreamD);
                        return false;
                    }
                    outputStreamD.write(bArr);
                    c0270dHc.d();
                    this.hc.d();
                    com.bytedance.sdk.component.an.b.b.hc.d(outputStreamD);
                    return true;
                } catch (IOException e) {
                    e = e;
                    closeable = null;
                    c0270d = c0270dHc;
                    try {
                        mq.hc("LruCountDiskCache", e.toString());
                        if (c0270d != null) {
                            try {
                                c0270d.hc();
                            } catch (IOException unused) {
                            }
                        }
                        com.bytedance.sdk.component.an.b.b.hc.d(closeable);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = closeable;
                        com.bytedance.sdk.component.an.b.b.hc.d(closeable2);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.bytedance.sdk.component.an.b.b.hc.d(closeable2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            closeable = null;
        }
    }

    @Override // com.bytedance.sdk.component.an.d
    /* renamed from: hc, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] d(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStreamD;
        d dVar = this.hc;
        InputStream inputStream = null;
        if (dVar == null || str == null) {
            return null;
        }
        try {
            d.b bVarD = dVar.d(str);
            if (bVarD == null) {
                com.bytedance.sdk.component.an.b.b.hc.d(null);
                com.bytedance.sdk.component.an.b.b.hc.d(null);
                return null;
            }
            inputStreamD = bVarD.d(0);
            if (inputStreamD != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException e) {
                    e = e;
                    byteArrayOutputStream = null;
                    mq.hc("LruCountDiskCache", e.toString());
                    com.bytedance.sdk.component.an.b.b.hc.d(inputStreamD);
                    com.bytedance.sdk.component.an.b.b.hc.d(byteArrayOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                    inputStream = inputStreamD;
                    com.bytedance.sdk.component.an.b.b.hc.d(inputStream);
                    com.bytedance.sdk.component.an.b.b.hc.d(byteArrayOutputStream);
                    throw th;
                }
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStreamD.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStreamD;
                        com.bytedance.sdk.component.an.b.b.hc.d(inputStream);
                        com.bytedance.sdk.component.an.b.b.hc.d(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    mq.hc("LruCountDiskCache", e.toString());
                    com.bytedance.sdk.component.an.b.b.hc.d(inputStreamD);
                    com.bytedance.sdk.component.an.b.b.hc.d(byteArrayOutputStream);
                    return null;
                }
            } else {
                byteArrayOutputStream = null;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            com.bytedance.sdk.component.an.b.b.hc.d(inputStreamD);
            com.bytedance.sdk.component.an.b.b.hc.d(byteArrayOutputStream);
            return byteArray;
        } catch (IOException e3) {
            e = e3;
            inputStreamD = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            com.bytedance.sdk.component.an.b.b.hc.d(inputStream);
            com.bytedance.sdk.component.an.b.b.hc.d(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.an.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean hc(String str) throws IOException {
        try {
            try {
                d.b bVarD = this.hc.d(str);
                boolean z = bVarD != null;
                com.bytedance.sdk.component.an.b.b.hc.d(bVarD);
                return z;
            } catch (IOException e) {
                mq.hc("LruCountDiskCache", e.getMessage());
                com.bytedance.sdk.component.an.b.b.hc.d(null);
                return false;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.an.b.b.hc.d(null);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.an.d
    public void d(double d) {
        this.hc.d((long) (this.d * d));
    }
}
