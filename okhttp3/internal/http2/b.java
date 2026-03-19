package okhttp3.internal.http2;

import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.util.FeedSurveyManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class b {
    static final okhttp3.internal.http2.a[] Bv = {new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Br, ""), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bo, "GET"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bo, "POST"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bp, "/"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bp, "/index.html"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bq, com.alipay.sdk.m.l.a.r), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bq, "https"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bn, "200"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bn, "204"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bn, "206"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bn, "304"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bn, "400"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bn, "404"), new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bn, "500"), new okhttp3.internal.http2.a("accept-charset", ""), new okhttp3.internal.http2.a("accept-encoding", "gzip, deflate"), new okhttp3.internal.http2.a("accept-language", ""), new okhttp3.internal.http2.a("accept-ranges", ""), new okhttp3.internal.http2.a("accept", ""), new okhttp3.internal.http2.a("access-control-allow-origin", ""), new okhttp3.internal.http2.a(FeedSurveyManager.KEY_AGE, ""), new okhttp3.internal.http2.a("allow", ""), new okhttp3.internal.http2.a("authorization", ""), new okhttp3.internal.http2.a("cache-control", ""), new okhttp3.internal.http2.a("content-disposition", ""), new okhttp3.internal.http2.a("content-encoding", ""), new okhttp3.internal.http2.a("content-language", ""), new okhttp3.internal.http2.a("content-length", ""), new okhttp3.internal.http2.a("content-location", ""), new okhttp3.internal.http2.a("content-range", ""), new okhttp3.internal.http2.a(com.alipay.sdk.m.p.e.f, ""), new okhttp3.internal.http2.a("cookie", ""), new okhttp3.internal.http2.a("date", ""), new okhttp3.internal.http2.a("etag", ""), new okhttp3.internal.http2.a("expect", ""), new okhttp3.internal.http2.a("expires", ""), new okhttp3.internal.http2.a("from", ""), new okhttp3.internal.http2.a("host", ""), new okhttp3.internal.http2.a("if-match", ""), new okhttp3.internal.http2.a("if-modified-since", ""), new okhttp3.internal.http2.a("if-none-match", ""), new okhttp3.internal.http2.a("if-range", ""), new okhttp3.internal.http2.a("if-unmodified-since", ""), new okhttp3.internal.http2.a("last-modified", ""), new okhttp3.internal.http2.a("link", ""), new okhttp3.internal.http2.a("location", ""), new okhttp3.internal.http2.a("max-forwards", ""), new okhttp3.internal.http2.a("proxy-authenticate", ""), new okhttp3.internal.http2.a("proxy-authorization", ""), new okhttp3.internal.http2.a("range", ""), new okhttp3.internal.http2.a(Config.LAUNCH_REFERER, ""), new okhttp3.internal.http2.a("refresh", ""), new okhttp3.internal.http2.a("retry-after", ""), new okhttp3.internal.http2.a("server", ""), new okhttp3.internal.http2.a("set-cookie", ""), new okhttp3.internal.http2.a("strict-transport-security", ""), new okhttp3.internal.http2.a("transfer-encoding", ""), new okhttp3.internal.http2.a("user-agent", ""), new okhttp3.internal.http2.a("vary", ""), new okhttp3.internal.http2.a("via", ""), new okhttp3.internal.http2.a("www-authenticate", "")};
    static final Map<ByteString, Integer> Bw = gI();

    static final class a {
        okhttp3.internal.http2.a[] BA;
        int BB;
        int BC;
        int BD;
        private final List<okhttp3.internal.http2.a> Bx;
        private final int By;
        private int Bz;
        private final BufferedSource source;

        a(int i, Source source) {
            this(4096, 4096, source);
        }

        private a(int i, int i2, Source source) {
            this.Bx = new ArrayList();
            this.BA = new okhttp3.internal.http2.a[8];
            this.BB = this.BA.length - 1;
            this.BC = 0;
            this.BD = 0;
            this.By = i;
            this.Bz = i2;
            this.source = Okio.buffer(source);
        }

        private void gJ() {
            int i = this.Bz;
            int i2 = this.BD;
            if (i < i2) {
                if (i == 0) {
                    gK();
                } else {
                    bu(i2 - i);
                }
            }
        }

        private void gK() {
            Arrays.fill(this.BA, (Object) null);
            this.BB = this.BA.length - 1;
            this.BC = 0;
            this.BD = 0;
        }

        private int bu(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.BA.length;
                while (true) {
                    length--;
                    if (length < this.BB || i <= 0) {
                        break;
                    }
                    i -= this.BA[length].Bu;
                    this.BD -= this.BA[length].Bu;
                    this.BC--;
                    i2++;
                }
                okhttp3.internal.http2.a[] aVarArr = this.BA;
                int i3 = this.BB;
                System.arraycopy(aVarArr, i3 + 1, aVarArr, i3 + 1 + i2, this.BC);
                this.BB += i2;
            }
            return i2;
        }

        final void gL() throws IOException {
            while (!this.source.exhausted()) {
                int i = this.source.readByte() & 255;
                if (i == 128) {
                    throw new IOException("index == 0");
                }
                if ((i & 128) == 128) {
                    bv(V(i, 127) - 1);
                } else if (i == 64) {
                    gO();
                } else if ((i & 64) == 64) {
                    by(V(i, 63) - 1);
                } else if ((i & 32) == 32) {
                    this.Bz = V(i, 31);
                    int i2 = this.Bz;
                    if (i2 < 0 || i2 > this.By) {
                        throw new IOException("Invalid dynamic table size update " + this.Bz);
                    }
                    gJ();
                } else if (i == 16 || i == 0) {
                    gN();
                } else {
                    bx(V(i, 15) - 1);
                }
            }
        }

        public final List<okhttp3.internal.http2.a> gM() {
            ArrayList arrayList = new ArrayList(this.Bx);
            this.Bx.clear();
            return arrayList;
        }

        private void bv(int i) throws IOException {
            if (bA(i)) {
                this.Bx.add(b.Bv[i]);
                return;
            }
            int iBw = bw(i - b.Bv.length);
            if (iBw >= 0) {
                okhttp3.internal.http2.a[] aVarArr = this.BA;
                if (iBw <= aVarArr.length - 1) {
                    this.Bx.add(aVarArr[iBw]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int bw(int i) {
            return this.BB + 1 + i;
        }

        private void bx(int i) {
            this.Bx.add(new okhttp3.internal.http2.a(bz(i), gQ()));
        }

        private void gN() throws IOException {
            this.Bx.add(new okhttp3.internal.http2.a(b.a(gQ()), gQ()));
        }

        private void by(int i) {
            a(-1, new okhttp3.internal.http2.a(bz(i), gQ()));
        }

        private void gO() {
            a(-1, new okhttp3.internal.http2.a(b.a(gQ()), gQ()));
        }

        private ByteString bz(int i) {
            if (bA(i)) {
                return b.Bv[i].Bs;
            }
            return this.BA[bw(i - b.Bv.length)].Bs;
        }

        private static boolean bA(int i) {
            return i >= 0 && i <= b.Bv.length - 1;
        }

        private void a(int i, okhttp3.internal.http2.a aVar) {
            this.Bx.add(aVar);
            int i2 = aVar.Bu;
            int i3 = this.Bz;
            if (i2 > i3) {
                gK();
                return;
            }
            bu((this.BD + i2) - i3);
            int i4 = this.BC + 1;
            okhttp3.internal.http2.a[] aVarArr = this.BA;
            if (i4 > aVarArr.length) {
                okhttp3.internal.http2.a[] aVarArr2 = new okhttp3.internal.http2.a[aVarArr.length * 2];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.BB = this.BA.length - 1;
                this.BA = aVarArr2;
            }
            int i5 = this.BB;
            this.BB = i5 - 1;
            this.BA[i5] = aVar;
            this.BC++;
            this.BD += i2;
        }

        private int gP() {
            return this.source.readByte() & 255;
        }

        private int V(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iGP = gP();
                if ((iGP & 128) == 0) {
                    return i2 + (iGP << i4);
                }
                i2 += (iGP & 127) << i4;
                i4 += 7;
            }
        }

        private ByteString gQ() {
            int iGP = gP();
            boolean z = (iGP & 128) == 128;
            int iV = V(iGP, 127);
            if (z) {
                return ByteString.of(i.hd().decode(this.source.readByteArray(iV)));
            }
            return this.source.readByteString(iV);
        }
    }

    private static Map<ByteString, Integer> gI() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(Bv.length);
        int i = 0;
        while (true) {
            okhttp3.internal.http2.a[] aVarArr = Bv;
            if (i < aVarArr.length) {
                if (!linkedHashMap.containsKey(aVarArr[i].Bs)) {
                    linkedHashMap.put(Bv[i].Bs, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.b$b, reason: collision with other inner class name */
    static final class C0855b {
        okhttp3.internal.http2.a[] BA;
        int BB;
        int BC;
        int BD;
        private final Buffer BE;
        private final boolean BF;
        private int BG;
        private boolean BH;
        int By;
        int Bz;

        C0855b(Buffer buffer) {
            this(4096, true, buffer);
        }

        private C0855b(int i, boolean z, Buffer buffer) {
            this.BG = Integer.MAX_VALUE;
            this.BA = new okhttp3.internal.http2.a[8];
            this.BB = this.BA.length - 1;
            this.BC = 0;
            this.BD = 0;
            this.By = 4096;
            this.Bz = 4096;
            this.BF = true;
            this.BE = buffer;
        }

        private void gK() {
            Arrays.fill(this.BA, (Object) null);
            this.BB = this.BA.length - 1;
            this.BC = 0;
            this.BD = 0;
        }

        private int bu(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.BA.length;
                while (true) {
                    length--;
                    if (length < this.BB || i <= 0) {
                        break;
                    }
                    i -= this.BA[length].Bu;
                    this.BD -= this.BA[length].Bu;
                    this.BC--;
                    i2++;
                }
                okhttp3.internal.http2.a[] aVarArr = this.BA;
                int i3 = this.BB;
                System.arraycopy(aVarArr, i3 + 1, aVarArr, i3 + 1 + i2, this.BC);
                okhttp3.internal.http2.a[] aVarArr2 = this.BA;
                int i4 = this.BB;
                Arrays.fill(aVarArr2, i4 + 1, i4 + 1 + i2, (Object) null);
                this.BB += i2;
            }
            return i2;
        }

        private void a(okhttp3.internal.http2.a aVar) {
            int i = aVar.Bu;
            int i2 = this.Bz;
            if (i > i2) {
                gK();
                return;
            }
            bu((this.BD + i) - i2);
            int i3 = this.BC + 1;
            okhttp3.internal.http2.a[] aVarArr = this.BA;
            if (i3 > aVarArr.length) {
                okhttp3.internal.http2.a[] aVarArr2 = new okhttp3.internal.http2.a[aVarArr.length * 2];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.BB = this.BA.length - 1;
                this.BA = aVarArr2;
            }
            int i4 = this.BB;
            this.BB = i4 - 1;
            this.BA[i4] = aVar;
            this.BC++;
            this.BD += i;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final void i(java.util.List<okhttp3.internal.http2.a> r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 238
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.b.C0855b.i(java.util.List):void");
        }

        private void j(int i, int i2, int i3) {
            if (i < i2) {
                this.BE.writeByte(i | i3);
                return;
            }
            this.BE.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.BE.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.BE.writeByte(i4);
        }

        private void b(ByteString byteString) throws IOException {
            if (this.BF) {
                i.hd();
                if (i.c(byteString) < byteString.size()) {
                    Buffer buffer = new Buffer();
                    i.hd();
                    i.a(byteString, buffer);
                    ByteString byteString2 = buffer.readByteString();
                    j(byteString2.size(), 127, 128);
                    this.BE.write(byteString2);
                    return;
                }
            }
            j(byteString.size(), 127, 0);
            this.BE.write(byteString);
        }

        final void bB(int i) {
            this.By = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.Bz;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.BG = Math.min(this.BG, iMin);
            }
            this.BH = true;
            this.Bz = iMin;
            gJ();
        }

        private void gJ() {
            int i = this.Bz;
            int i2 = this.BD;
            if (i < i2) {
                if (i == 0) {
                    gK();
                } else {
                    bu(i2 - i);
                }
            }
        }
    }

    static ByteString a(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b = byteString.getByte(i);
            if (b >= 65 && b <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
