package com.apm.insight.n;

import com.apm.insight.o.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class b implements j {
    protected final String a = "AAA" + System.currentTimeMillis() + "AAA";
    protected String b;
    protected boolean c;
    protected g d;
    protected r e;

    public b(String str, String str2, Map<String, String> map, boolean z) {
        this.b = str2;
        this.c = z;
    }

    @Override // com.apm.insight.n.j
    public String a() throws IOException {
        byte[] bytes = ("\r\n--" + this.a + "--\r\n").getBytes();
        if (this.c) {
            this.e.write(bytes);
            this.e.b();
            this.e.a();
            return "";
        }
        this.d.write(bytes);
        this.d.flush();
        this.d.a();
        return "";
    }

    @Override // com.apm.insight.n.j
    public void a(String str, File file, Map<String, String> map) throws IOException {
        String name = file.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(this.a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(name).append("\"");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("; ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        sb.append("\r\n").append("Content-Transfer-Encoding: binary").append("\r\n").append("\r\n");
        if (this.c) {
            this.e.write(sb.toString().getBytes());
        } else {
            this.d.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                break;
            } else if (this.c) {
                this.e.write(bArr, 0, i);
            } else {
                this.d.write(bArr, 0, i);
            }
        }
        fileInputStream.close();
        if (this.c) {
            this.e.write("\r\n".getBytes());
        } else {
            this.d.write("\r\n".getBytes());
            this.d.flush();
        }
    }

    @Override // com.apm.insight.n.j
    public void a(String str, String str2) {
        a(str, str2, false);
    }

    @Override // com.apm.insight.n.j
    public void a(String str, String str2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(this.a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(str).append("\"").append("\r\n").append("Content-Type: text/plain; charset=").append(this.b).append("\r\n").append("\r\n");
        try {
            if (this.c) {
                this.e.write(sb.toString().getBytes());
            } else {
                this.d.write(sb.toString().getBytes());
            }
        } catch (IOException unused) {
        }
        byte[] bytes = str2.getBytes();
        if (z) {
            bytes = com.apm.insight.g.h().getEncryptImpl().a(bytes);
        }
        try {
            if (this.c) {
                this.e.write(bytes);
                this.e.write("\r\n".getBytes());
            } else {
                this.d.write(bytes);
                this.d.write("\r\n".getBytes());
            }
        } catch (IOException unused2) {
        }
    }

    @Override // com.apm.insight.n.j
    public void a(String str, Map<String, String> map, j.a... aVarArr) throws Throwable {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(this.a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(str).append("\"");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("; ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
            }
        }
        sb.append("\r\n").append("Content-Transfer-Encoding: binary").append("\r\n").append("\r\n");
        if (this.c) {
            this.e.write(sb.toString().getBytes());
        } else {
            this.d.write(sb.toString().getBytes());
        }
        com.apm.insight.o.j.a(this.c ? this.e : this.d, aVarArr);
        if (this.c) {
            this.e.write("\r\n".getBytes());
        } else {
            this.d.write("\r\n".getBytes());
            this.d.flush();
        }
    }

    @Override // com.apm.insight.n.j
    public void a(String str, Map<String, String> map, File... fileArr) throws Throwable {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(this.a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(str).append("\"");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("; ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
            }
        }
        sb.append("\r\n").append("Content-Transfer-Encoding: binary").append("\r\n").append("\r\n");
        if (this.c) {
            this.e.write(sb.toString().getBytes());
        } else {
            this.d.write(sb.toString().getBytes());
        }
        com.apm.insight.o.j.a(this.c ? this.e : this.d, fileArr);
        if (this.c) {
            this.e.write("\r\n".getBytes());
        } else {
            this.d.write("\r\n".getBytes());
            this.d.flush();
        }
    }

    @Override // com.apm.insight.n.j
    public void a(String str, File... fileArr) throws Throwable {
        a(str, (Map<String, String>) null, fileArr);
    }
}
