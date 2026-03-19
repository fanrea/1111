package com.netease.htprotect.p024;

import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.utility.StringEncryptUtils;
import com.kuaishou.weapon.p0.t;
import com.netease.htprotect.p024.p025O8oO888.O;
import com.netease.htprotect.p024.p025O8oO888.O8;
import com.netease.htprotect.p024.p025O8oO888.oO;
import com.netease.htprotect.p024.p026Ooo.Oo0;
import com.netease.htprotect.p024.p026Ooo.o0o0;
import com.netease.htprotect.result.VResult;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/* renamed from: com.netease.htprotect.〇〇.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final String f621O8oO888 = "META-INF/MANIFEST.MF";

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static final Map f622O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final Map f623Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static final String[] f624o0o0;

    /* renamed from: com.netease.htprotect.〇〇.O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
    private static class C0687O8oO888 {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public final String f625O8oO888;

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        public final byte[] f626Ooo;

        private C0687O8oO888(String str, byte[] bArr) {
            this.f625O8oO888 = str;
            this.f626Ooo = bArr;
        }

        /* synthetic */ C0687O8oO888(String str, byte[] bArr, byte b) {
            this(str, bArr);
        }
    }

    /* renamed from: com.netease.htprotect.〇〇.O8〇oO8〇88$〇Ooo, reason: invalid class name */
    private static class Ooo {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private final long f630O8oO888;

        /* renamed from: 〇O8, reason: contains not printable characters */
        private final int f631O8;

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        private final long f632Ooo;

        /* renamed from: 〇o0〇o0, reason: contains not printable characters */
        private final long f633o0o0;

        public Ooo(long j, long j2, int i, long j3) {
            this.f630O8oO888 = j;
            this.f632Ooo = j2;
            this.f631O8 = i;
            this.f633o0o0 = j3;
        }

        /* renamed from: 〇o0〇o0, reason: contains not printable characters */
        private long m1202o0o0() {
            return this.f633o0o0;
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public final long m1203O8oO888() {
            return this.f630O8oO888;
        }

        /* renamed from: 〇O8, reason: contains not printable characters */
        public final int m1204O8() {
            return this.f631O8;
        }

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        public final long m1205Ooo() {
            return this.f632Ooo;
        }
    }

    static {
        HashMap map = new HashMap(8);
        f623Ooo = map;
        map.put("MD5", "MD5");
        map.put("SHA", StringEncryptUtils.SHA_1);
        map.put("SHA1", StringEncryptUtils.SHA_1);
        map.put(StringEncryptUtils.SHA_1, StringEncryptUtils.SHA_1);
        map.put(StringEncryptUtils.SHA_256, StringEncryptUtils.SHA_256);
        map.put("SHA-384", "SHA-384");
        map.put("SHA-512", "SHA-512");
        HashMap map2 = new HashMap(5);
        f622O8 = map2;
        map2.put("MD5", 0);
        map2.put(StringEncryptUtils.SHA_1, 0);
        map2.put(StringEncryptUtils.SHA_256, 0);
        map2.put("SHA-384", 9);
        map2.put("SHA-512", 9);
        f624o0o0 = new String[]{"SHA-512", "SHA-384", StringEncryptUtils.SHA_256, StringEncryptUtils.SHA_1};
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static Pair m1174O8oO888(byte[] bArr, Set set, VResult vResult) {
        oO oOVar = new oO(bArr);
        oO.Ooo oooM1214Ooo = oOVar.m1214Ooo();
        List<oO.Ooo> listM1213O8oO888 = oOVar.m1213O8oO888();
        HashMap map = new HashMap(listM1213O8oO888.size());
        for (oO.Ooo ooo : listM1213O8oO888) {
            String strM1219O8oO888 = ooo.m1219O8oO888();
            if (strM1219O8oO888 == null) {
                vResult.ret = 8;
                return null;
            }
            if (map.put(strM1219O8oO888, ooo) != null) {
                vResult.ret = 8;
                return null;
            }
            if (!set.contains(strM1219O8oO888)) {
                vResult.ret = 9;
                vResult.res = strM1219O8oO888;
                return null;
            }
        }
        return new Pair(oooM1214Ooo, map);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static VResult m1175O8oO888(O8 o8, int i, int i2) throws Exception {
        VResult vResult = new VResult();
        try {
            Pair pairM1241O8oO888 = Oo0.m1241O8oO888(o8);
            if (pairM1241O8oO888 == null) {
                throw new O("");
            }
            ByteBuffer byteBuffer = (ByteBuffer) pairM1241O8oO888.first;
            long jLongValue = ((Long) pairM1241O8oO888.second).longValue();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            long jM1240O8oO888 = Oo0.m1240O8oO888(byteBuffer);
            if (jM1240O8oO888 > jLongValue) {
                throw new O("");
            }
            long jM1249Ooo = Oo0.m1249Ooo(byteBuffer);
            if (jM1240O8oO888 + jM1249Ooo > jLongValue) {
                throw new O("");
            }
            Ooo ooo = new Ooo(jM1240O8oO888, jM1249Ooo, Oo0.m1247O8(byteBuffer), jLongValue);
            try {
                long jM1205Ooo = ooo.m1205Ooo();
                if (jM1205Ooo > 2147483647L) {
                    throw new Exception(String.valueOf(jM1205Ooo));
                }
                ByteBuffer byteBufferMo1199O8oO888 = o8.mo1199O8oO888(ooo.m1203O8oO888(), (int) jM1205Ooo);
                byteBufferMo1199O8oO888.order(ByteOrder.LITTLE_ENDIAN);
                int iM1204O8 = ooo.m1204O8();
                ArrayList<com.netease.htprotect.p024.p026Ooo.O8oO888> arrayList = new ArrayList(iM1204O8);
                for (int i3 = 0; i3 < iM1204O8; i3++) {
                    com.netease.htprotect.p024.p026Ooo.O8oO888 o8oO888M1225O8oO888 = com.netease.htprotect.p024.p026Ooo.O8oO888.m1225O8oO888(byteBufferMo1199O8oO888);
                    if (!o8oO888M1225O8oO888.m1231O8oO888().endsWith("/")) {
                        arrayList.add(o8oO888M1225O8oO888);
                    }
                }
                Set setM1182O8oO888 = m1182O8oO888(arrayList, vResult);
                if (vResult.ret != 0) {
                    return vResult;
                }
                HashMap map = new HashMap(1);
                ArrayList arrayList2 = new ArrayList(1);
                String strM1231O8oO888 = null;
                com.netease.htprotect.p024.p026Ooo.O8oO888 o8oO888 = null;
                for (com.netease.htprotect.p024.p026Ooo.O8oO888 o8oO8882 : arrayList) {
                    String strM1231O8oO8882 = o8oO8882.m1231O8oO888();
                    if (strM1231O8oO8882.startsWith("META-INF/")) {
                        if (f621O8oO888.equals(strM1231O8oO8882)) {
                            o8oO888 = o8oO8882;
                        } else if (strM1231O8oO8882.endsWith(".SF")) {
                            map.put(strM1231O8oO8882, o8oO8882);
                        } else if (strM1231O8oO8882.endsWith(".RSA") || strM1231O8oO8882.endsWith(".DSA") || strM1231O8oO8882.endsWith(".EC")) {
                            arrayList2.add(o8oO8882);
                        }
                    }
                }
                if (o8oO888 == null) {
                    vResult.ret = 6;
                    return vResult;
                }
                long jM1203O8oO888 = ooo.m1203O8oO888();
                try {
                    byte[] bArrM1262O8oO888 = o0o0.m1262O8oO888(o8, o8oO888, jM1203O8oO888);
                    Pair pairM1174O8oO888 = m1174O8oO888(bArrM1262O8oO888, setM1182O8oO888, vResult);
                    if (vResult.ret != 0) {
                        return vResult;
                    }
                    if (pairM1174O8oO888 == null) {
                        vResult.ret = 8;
                        return vResult;
                    }
                    oO.Ooo ooo2 = (oO.Ooo) pairM1174O8oO888.first;
                    Map map2 = (Map) pairM1174O8oO888.second;
                    Iterator it = arrayList2.iterator();
                    String str = null;
                    com.netease.htprotect.p024.p026Ooo.O8oO888 o8oO8883 = null;
                    while (it.hasNext()) {
                        strM1231O8oO888 = ((com.netease.htprotect.p024.p026Ooo.O8oO888) it.next()).m1231O8oO888();
                        int iLastIndexOf = strM1231O8oO888.lastIndexOf(46);
                        if (iLastIndexOf == -1) {
                            vResult.ret = 10;
                            return vResult;
                        }
                        str = strM1231O8oO888.substring(0, iLastIndexOf) + ".SF";
                        o8oO8883 = (com.netease.htprotect.p024.p026Ooo.O8oO888) map.get(str);
                        if (o8oO8883 == null) {
                            vResult.ret = 10;
                            return vResult;
                        }
                        if (strM1231O8oO888.endsWith(".RSA")) {
                            break;
                        }
                    }
                    if (strM1231O8oO888 == null || str == null || o8oO8883 == null) {
                        vResult.ret = 10;
                        return vResult;
                    }
                    try {
                        m1186O8oO888(o0o0.m1262O8oO888(o8, o8oO8883, jM1203O8oO888), bArrM1262O8oO888, ooo2, map2, i, i2, vResult);
                        if (vResult.ret != 0) {
                            return vResult;
                        }
                        try {
                            m1183O8oO888(o8, jM1203O8oO888, arrayList, map2, i, i2, vResult);
                            return vResult;
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } catch (Exception e2) {
                        vResult.ret = 11;
                        vResult.res = e2.toString();
                        return vResult;
                    }
                } catch (Exception e3) {
                    vResult.ret = 7;
                    vResult.res = e3.toString();
                    return vResult;
                }
            } catch (Exception unused) {
                vResult.ret = 1;
                return vResult;
            }
        } catch (Exception unused2) {
            vResult.ret = 1;
            return vResult;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static VResult m1176O8oO888(String str, int i, int i2) throws Throwable {
        VResult vResult = new VResult();
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, t.k);
                try {
                    VResult vResultM1175O8oO888 = m1175O8oO888(new com.netease.htprotect.p024.p025O8oO888.o0o0(randomAccessFile2.getChannel(), 0L, randomAccessFile2.length()), i, i2);
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused) {
                    }
                    return vResultM1175O8oO888;
                } catch (IOException e) {
                    e = e;
                    randomAccessFile = randomAccessFile2;
                    vResult.ret = 4;
                    vResult.res = e.toString();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return vResult;
                } catch (NoSuchAlgorithmException e2) {
                    e = e2;
                    randomAccessFile = randomAccessFile2;
                    vResult.ret = 3;
                    vResult.res = e.toString();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return vResult;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static Ooo m1177O8oO888(O8 o8) throws O, IOException {
        Pair pairM1241O8oO888 = Oo0.m1241O8oO888(o8);
        if (pairM1241O8oO888 == null) {
            throw new O("");
        }
        ByteBuffer byteBuffer = (ByteBuffer) pairM1241O8oO888.first;
        long jLongValue = ((Long) pairM1241O8oO888.second).longValue();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        long jM1240O8oO888 = Oo0.m1240O8oO888(byteBuffer);
        if (jM1240O8oO888 > jLongValue) {
            throw new O("");
        }
        long jM1249Ooo = Oo0.m1249Ooo(byteBuffer);
        if (jM1240O8oO888 + jM1249Ooo <= jLongValue) {
            return new Ooo(jM1240O8oO888, jM1249Ooo, Oo0.m1247O8(byteBuffer), jLongValue);
        }
        throw new O("");
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m1178O8oO888(String str) {
        return (String) f623Ooo.get(str.toUpperCase(Locale.US));
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m1179O8oO888(String str, String str2) {
        return StringEncryptUtils.SHA_1.equalsIgnoreCase(str) ? "SHA1".concat(String.valueOf(str2)) : str + str2;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static Collection m1180O8oO888(oO.Ooo ooo, String str, int i, int i2) {
        String str2;
        ArrayList arrayList = new ArrayList(1);
        byte b = 0;
        if (i < 18) {
            String strM1220O8oO888 = ooo.m1220O8oO888("Digest-Algorithms");
            if (strM1220O8oO888 == null) {
                strM1220O8oO888 = "SHA SHA1";
            }
            StringTokenizer stringTokenizer = new StringTokenizer(strM1220O8oO888);
            while (true) {
                if (!stringTokenizer.hasMoreTokens()) {
                    break;
                }
                String strNextToken = stringTokenizer.nextToken();
                String strM1220O8oO8882 = ooo.m1220O8oO888(strNextToken + str);
                if (strM1220O8oO8882 != null && (str2 = (String) f623Ooo.get(strNextToken.toUpperCase(Locale.US))) != null) {
                    Integer num = (Integer) f622O8.get(str2.toUpperCase(Locale.US));
                    if ((num != null ? num.intValue() : Integer.MAX_VALUE) <= i) {
                        arrayList.add(new C0687O8oO888(str2, Base64.decode(strM1220O8oO8882, 2), b));
                        break;
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return arrayList;
            }
        }
        if (i2 >= 18) {
            String[] strArr = f624o0o0;
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                String str3 = strArr[i3];
                String strM1220O8oO8883 = ooo.m1220O8oO888(StringEncryptUtils.SHA_1.equalsIgnoreCase(str3) ? "SHA1".concat(String.valueOf(str)) : str3 + str);
                if (strM1220O8oO8883 != null) {
                    byte[] bArrDecode = Base64.decode(strM1220O8oO8883, 2);
                    byte[] bArrM1190O8oO888 = m1190O8oO888(arrayList, str3);
                    if (bArrM1190O8oO888 == null || !Arrays.equals(bArrM1190O8oO888, bArrDecode)) {
                        arrayList.add(new C0687O8oO888(str3, bArrDecode, b));
                    }
                } else {
                    i3++;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static List m1181O8oO888(O8 o8, Ooo ooo) throws Exception {
        long jM1205Ooo = ooo.m1205Ooo();
        if (jM1205Ooo > 2147483647L) {
            throw new Exception(String.valueOf(jM1205Ooo));
        }
        ByteBuffer byteBufferMo1199O8oO888 = o8.mo1199O8oO888(ooo.m1203O8oO888(), (int) jM1205Ooo);
        byteBufferMo1199O8oO888.order(ByteOrder.LITTLE_ENDIAN);
        int iM1204O8 = ooo.m1204O8();
        ArrayList arrayList = new ArrayList(iM1204O8);
        for (int i = 0; i < iM1204O8; i++) {
            com.netease.htprotect.p024.p026Ooo.O8oO888 o8oO888M1225O8oO888 = com.netease.htprotect.p024.p026Ooo.O8oO888.m1225O8oO888(byteBufferMo1199O8oO888);
            if (!o8oO888M1225O8oO888.m1231O8oO888().endsWith("/")) {
                arrayList.add(o8oO888M1225O8oO888);
            }
        }
        return arrayList;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static Set m1182O8oO888(List list, VResult vResult) {
        HashSet hashSet = new HashSet(list.size());
        Iterator it = list.iterator();
        HashSet hashSet2 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String strM1231O8oO888 = ((com.netease.htprotect.p024.p026Ooo.O8oO888) it.next()).m1231O8oO888();
            if (!hashSet.add(strM1231O8oO888)) {
                if (hashSet2 == null) {
                    hashSet2 = new HashSet();
                }
                if (hashSet2.add(strM1231O8oO888)) {
                    vResult.ret = 5;
                    vResult.res = strM1231O8oO888;
                    break;
                }
            }
        }
        return hashSet;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m1183O8oO888(O8 o8, long j, Collection collection, Map map, int i, int i2, VResult vResult) throws NoSuchAlgorithmException {
        int i3;
        ArrayList<com.netease.htprotect.p024.p026Ooo.O8oO888> arrayList = new ArrayList(collection);
        Collections.sort(arrayList, com.netease.htprotect.p024.p026Ooo.O8oO888.f649O8oO888);
        HashSet hashSet = new HashSet(map.keySet());
        for (com.netease.htprotect.p024.p026Ooo.O8oO888 o8oO888 : arrayList) {
            String strM1231O8oO888 = o8oO888.m1231O8oO888();
            hashSet.remove(strM1231O8oO888);
            if ((strM1231O8oO888.startsWith("META-INF/") || strM1231O8oO888.endsWith("/")) ? false : true) {
                oO.Ooo ooo = (oO.Ooo) map.get(strM1231O8oO888);
                if (ooo != null) {
                    ArrayList arrayList2 = new ArrayList(m1180O8oO888(ooo, "-Digest", i, i2));
                    if (!arrayList2.isEmpty()) {
                        MessageDigest[] messageDigestArr = new MessageDigest[arrayList2.size()];
                        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                            messageDigestArr[i4] = MessageDigest.getInstance(((C0687O8oO888) arrayList2.get(i4)).f625O8oO888);
                        }
                        try {
                            o0o0.m1261O8oO888(o8, o8oO888, j, new com.netease.htprotect.p024.p025O8oO888.Oo0(messageDigestArr));
                        } catch (Exception unused) {
                            i3 = 9;
                        }
                        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                            if (!Arrays.equals(((C0687O8oO888) arrayList2.get(i5)).f626Ooo, messageDigestArr[i5].digest())) {
                                i3 = 17;
                                vResult.ret = i3;
                                vResult.res = strM1231O8oO888;
                                return;
                            }
                        }
                    }
                }
                vResult.ret = 16;
                vResult.res = strM1231O8oO888;
                return;
            }
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m1184O8oO888(oO.Ooo ooo, oO.Ooo ooo2, byte[] bArr, int i, int i2, VResult vResult) throws NoSuchAlgorithmException {
        Collection<C0687O8oO888> collectionM1180O8oO888 = m1180O8oO888(ooo, "-Digest-Manifest-Main-Attributes", i, i2);
        if (collectionM1180O8oO888.isEmpty()) {
            return;
        }
        for (C0687O8oO888 c0687O8oO888 : collectionM1180O8oO888) {
            if (!Arrays.equals(c0687O8oO888.f626Ooo, m1189O8oO888(c0687O8oO888.f625O8oO888, bArr, ooo2.m1222Ooo(), ooo2.m1221O8()))) {
                vResult.ret = 12;
                return;
            }
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m1185O8oO888(oO.Ooo ooo, boolean z, oO.Ooo ooo2, byte[] bArr, int i, int i2, VResult vResult) throws NoSuchAlgorithmException {
        String strM1219O8oO888 = ooo.m1219O8oO888();
        Collection<C0687O8oO888> collectionM1180O8oO888 = m1180O8oO888(ooo, "-Digest", i, i2);
        if (collectionM1180O8oO888.isEmpty()) {
            vResult.ret = 14;
            vResult.res = strM1219O8oO888;
            return;
        }
        int iM1222Ooo = ooo2.m1222Ooo();
        int iM1221O8 = ooo2.m1221O8();
        if (z) {
            int i3 = iM1222Ooo + iM1221O8;
            if (bArr[i3 - 1] == 10 && bArr[i3 - 2] == 10) {
                iM1221O8--;
            }
        }
        for (C0687O8oO888 c0687O8oO888 : collectionM1180O8oO888) {
            if (!Arrays.equals(c0687O8oO888.f626Ooo, m1189O8oO888(c0687O8oO888.f625O8oO888, bArr, iM1222Ooo, iM1221O8))) {
                vResult.ret = 13;
                vResult.res = ooo.m1219O8oO888();
                return;
            }
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m1186O8oO888(byte[] bArr, byte[] bArr2, oO.Ooo ooo, Map map, int i, int i2, VResult vResult) throws NoSuchAlgorithmException {
        boolean z;
        oO oOVar = new oO(bArr);
        oO.Ooo oooM1214Ooo = oOVar.m1214Ooo();
        String strM1220O8oO888 = oooM1214Ooo.m1220O8oO888("Created-By");
        boolean zContains = strM1220O8oO888 != null ? strM1220O8oO888.contains("signtool") : false;
        Collection<C0687O8oO888> collectionM1180O8oO888 = m1180O8oO888(oooM1214Ooo, zContains ? "-Digest" : "-Digest-Manifest", i, i2);
        boolean z2 = true;
        if (!collectionM1180O8oO888.isEmpty()) {
            for (C0687O8oO888 c0687O8oO888 : collectionM1180O8oO888) {
                if (!Arrays.equals(c0687O8oO888.f626Ooo, MessageDigest.getInstance(c0687O8oO888.f625O8oO888).digest(bArr2))) {
                    z2 = false;
                }
            }
            z = z2;
        } else {
            z = false;
        }
        if (!zContains) {
            Collection collectionM1180O8oO8882 = m1180O8oO888(oooM1214Ooo, "-Digest-Manifest-Main-Attributes", i, i2);
            if (!collectionM1180O8oO8882.isEmpty()) {
                Iterator it = collectionM1180O8oO8882.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C0687O8oO888 c0687O8oO8882 = (C0687O8oO888) it.next();
                    if (!Arrays.equals(c0687O8oO8882.f626Ooo, m1189O8oO888(c0687O8oO8882.f625O8oO888, bArr2, ooo.m1222Ooo(), ooo.m1221O8()))) {
                        vResult.ret = 12;
                        break;
                    }
                }
            }
        }
        if (vResult.ret != 0) {
            return;
        }
        List<oO.Ooo> listM1213O8oO888 = oOVar.m1213O8oO888();
        HashSet hashSet = new HashSet(listM1213O8oO888.size());
        for (oO.Ooo ooo2 : listM1213O8oO888) {
            String strM1219O8oO888 = ooo2.m1219O8oO888();
            if (strM1219O8oO888 == null) {
                vResult.ret = 14;
                return;
            }
            if (!hashSet.add(strM1219O8oO888)) {
                vResult.ret = 14;
            } else if (!z) {
                oO.Ooo ooo3 = (oO.Ooo) map.get(strM1219O8oO888);
                if (ooo3 == null) {
                    vResult.ret = 15;
                } else {
                    m1185O8oO888(ooo2, zContains, ooo3, bArr2, i, i2, vResult);
                }
            }
            vResult.res = strM1219O8oO888;
            return;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static boolean m1187O8oO888(oO.Ooo ooo, boolean z, byte[] bArr, int i, int i2) throws NoSuchAlgorithmException {
        Collection<C0687O8oO888> collectionM1180O8oO888 = m1180O8oO888(ooo, z ? "-Digest" : "-Digest-Manifest", i, i2);
        boolean z2 = true;
        if (!(!collectionM1180O8oO888.isEmpty())) {
            return false;
        }
        for (C0687O8oO888 c0687O8oO888 : collectionM1180O8oO888) {
            if (!Arrays.equals(c0687O8oO888.f626Ooo, MessageDigest.getInstance(c0687O8oO888.f625O8oO888).digest(bArr))) {
                z2 = false;
            }
        }
        return z2;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static byte[] m1188O8oO888(String str, byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(str).digest(bArr);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static byte[] m1189O8oO888(String str, byte[] bArr, int i, int i2) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(bArr, i, i2);
        return messageDigest.digest();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static byte[] m1190O8oO888(Collection collection, String str) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            C0687O8oO888 c0687O8oO888 = (C0687O8oO888) it.next();
            if (c0687O8oO888.f625O8oO888.equalsIgnoreCase(str)) {
                return c0687O8oO888.f626Ooo;
            }
        }
        return null;
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static MessageDigest m1191O8(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(str);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static int m1192Ooo(String str) {
        Integer num = (Integer) f622O8.get(str.toUpperCase(Locale.US));
        if (num != null) {
            return num.intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static boolean m1193o0o0(String str) {
        return (str.startsWith("META-INF/") || str.endsWith("/")) ? false : true;
    }
}
