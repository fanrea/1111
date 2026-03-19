package com.bytedance.sdk.component.an.b.d.hc;

import android.os.Build;
import com.bytedance.sdk.component.an.rf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements rf {
    private com.bytedance.sdk.component.an.b.d.b<String, byte[]> b;
    private int d;
    private int hc;

    public b(int i, int i2) {
        this.hc = i;
        this.d = i2;
        this.b = new com.bytedance.sdk.component.an.b.d.b<String, byte[]>(i) { // from class: com.bytedance.sdk.component.an.b.d.hc.b.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.an.b.d.b
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public int hc(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.bytedance.sdk.component.an.d
    public boolean d(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.b.d(str, bArr);
        return true;
    }

    @Override // com.bytedance.sdk.component.an.d
    public byte[] d(String str) {
        return this.b.d((com.bytedance.sdk.component.an.b.d.b<String, byte[]>) str);
    }

    @Override // com.bytedance.sdk.component.an.d
    public boolean hc(String str) {
        return this.b.d((com.bytedance.sdk.component.an.b.d.b<String, byte[]>) str) != null;
    }

    @Override // com.bytedance.sdk.component.an.d
    public void d(double d) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.b.d((int) (this.hc * d));
        } else {
            this.b.d();
        }
    }
}
