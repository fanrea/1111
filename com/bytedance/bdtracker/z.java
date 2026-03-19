package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.applog.encryptor.IEncryptorType;
import com.bytedance.mpaas.IEncryptor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class z implements IEncryptorType, IEncryptor {
    public final IEncryptor a;
    public final String b;

    public z(IEncryptor iEncryptor, String str) {
        this.a = iEncryptor;
        this.b = str;
    }

    @Override // com.bytedance.mpaas.IEncryptor
    public byte[] encrypt(byte[] bArr, int i) {
        IEncryptor iEncryptor = this.a;
        return iEncryptor == null ? bArr : iEncryptor.encrypt(bArr, i);
    }

    @Override // com.bytedance.applog.encryptor.IEncryptorType
    public String encryptorType() {
        return TextUtils.isEmpty(this.b) ? "a" : this.b;
    }
}
