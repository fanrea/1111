package com.qq.e.comm.plugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.IDN;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class m9 extends l9 {
    private final int e;
    private final String f;

    int a() {
        return this.e;
    }

    m9(short s, int i, int i2, int i3, String str) {
        this.a = s;
        this.b = i;
        this.c = i2;
        this.e = i3;
        this.f = str;
    }

    byte[] b() throws IOException {
        String str = this.f;
        if (str != null && str.length() != 0) {
            int i = this.b;
            if (i != 0 && i != 1 && i != 2 && i != 5) {
                throw new IOException("opCode is not valid");
            }
            int i2 = this.c;
            if (i2 != 0 && i2 != 1) {
                throw new IOException("rd is not valid");
            }
            int i3 = this.e;
            if (i3 != 1 && i3 != 28 && i3 != 5 && i3 != 16) {
                throw new IOException("recordType is not valid");
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(this.a);
            dataOutputStream.writeByte((this.b << 3) + this.c);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            for (String str2 : this.f.split("[.。．｡]")) {
                if (str2.length() <= 63) {
                    byte[] bytes = IDN.toASCII(str2).getBytes();
                    dataOutputStream.write(bytes.length);
                    dataOutputStream.write(bytes, 0, bytes.length);
                } else {
                    throw new IOException("host part is too long");
                }
            }
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(this.e);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(1);
            return byteArrayOutputStream.toByteArray();
        }
        throw new IOException("host can not empty");
    }

    m9(short s, int i, String str) {
        this(s, 0, 1, i, str);
    }
}
