package android.support.v4.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.b.c;
import android.support.v4.content.a.d;
import android.support.v4.d.f;
import android.support.v4.d.j;
import android.support.v4.d.k;
import android.support.v4.graphics.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class b {
    static final f<String, Typeface> ah = new f<>(16);
    private static final android.support.v4.b.c aR = new android.support.v4.b.c("fonts", 10, 10000);
    static final Object sLock = new Object();
    static final k<String, ArrayList<c.a<c>>> aS = new k<>();
    private static final Comparator<byte[]> aT = new Comparator<byte[]>() { // from class: android.support.v4.b.b.4
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(byte[] bArr, byte[] bArr2) {
            return d(bArr, bArr2);
        }

        private static int d(byte[] bArr, byte[] bArr2) {
            int length;
            int length2;
            if (bArr.length != bArr2.length) {
                length = bArr.length;
                length2 = bArr2.length;
            } else {
                for (int i = 0; i < bArr.length; i++) {
                    if (bArr[i] != bArr2[i]) {
                        length = bArr[i];
                        length2 = bArr2[i];
                    }
                }
                return 0;
            }
            return length - length2;
        }
    };

    static c a(Context context, android.support.v4.b.a aVar, int i) {
        try {
            a aVarA = a(context, (CancellationSignal) null, aVar);
            if (aVarA.getStatusCode() == 0) {
                Typeface typefaceA = android.support.v4.graphics.b.a(context, null, aVarA.G(), i);
                return new c(typefaceA, typefaceA != null ? 0 : -3);
            }
            return new c(null, aVarA.getStatusCode() == 1 ? -2 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new c(null, -1);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static final class c {
        final Typeface bc;
        final int mResult;

        c(Typeface typeface, int i) {
            this.bc = typeface;
            this.mResult = i;
        }
    }

    public static Typeface a(final Context context, final android.support.v4.b.a aVar, final d.a aVar2, final Handler handler, boolean z, int i, final int i2) {
        final String str = aVar.getIdentifier() + "-" + i2;
        Typeface typeface = ah.get(str);
        if (typeface != null) {
            if (aVar2 != null) {
                aVar2.a(typeface);
            }
            return typeface;
        }
        if (z && i == -1) {
            c cVarA = a(context, aVar, i2);
            if (aVar2 != null) {
                if (cVarA.mResult == 0) {
                    aVar2.a(cVarA.bc, handler);
                } else {
                    aVar2.a(cVarA.mResult, handler);
                }
            }
            return cVarA.bc;
        }
        Callable<c> callable = new Callable<c>() { // from class: android.support.v4.b.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: F, reason: merged with bridge method [inline-methods] */
            public c call() {
                c cVarA2 = b.a(context, aVar, i2);
                if (cVarA2.bc != null) {
                    b.ah.put(str, cVarA2.bc);
                }
                return cVarA2;
            }
        };
        if (z) {
            try {
                return ((c) aR.a(callable, i)).bc;
            } catch (InterruptedException unused) {
                return null;
            }
        }
        c.a<c> aVar3 = aVar2 == null ? null : new c.a<c>() { // from class: android.support.v4.b.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.support.v4.b.c.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void h(c cVar) {
                if (cVar == null) {
                    aVar2.a(1, handler);
                } else if (cVar.mResult == 0) {
                    aVar2.a(cVar.bc, handler);
                } else {
                    aVar2.a(cVar.mResult, handler);
                }
            }
        };
        synchronized (sLock) {
            if (aS.containsKey(str)) {
                if (aVar3 != null) {
                    aS.get(str).add(aVar3);
                }
                return null;
            }
            if (aVar3 != null) {
                ArrayList<c.a<c>> arrayList = new ArrayList<>();
                arrayList.add(aVar3);
                aS.put(str, arrayList);
            }
            aR.a(callable, new c.a<c>() { // from class: android.support.v4.b.b.3
                /* JADX INFO: Access modifiers changed from: private */
                @Override // android.support.v4.b.c.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void h(c cVar) {
                    synchronized (b.sLock) {
                        ArrayList<c.a<c>> arrayList2 = b.aS.get(str);
                        if (arrayList2 == null) {
                            return;
                        }
                        b.aS.remove(str);
                        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                            arrayList2.get(i3).h(cVar);
                        }
                    }
                }
            });
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    /* renamed from: android.support.v4.b.b$b, reason: collision with other inner class name */
    public static class C0004b {
        private final int S;
        private final boolean V;
        private final int X;
        private final Uri ba;
        private final int bb;

        public C0004b(Uri uri, int i, int i2, boolean z, int i3) {
            this.ba = (Uri) j.checkNotNull(uri);
            this.X = i;
            this.S = i2;
            this.V = z;
            this.bb = i3;
        }

        public final Uri getUri() {
            return this.ba;
        }

        public final int getTtcIndex() {
            return this.X;
        }

        public final int getWeight() {
            return this.S;
        }

        public final boolean isItalic() {
            return this.V;
        }

        public final int getResultCode() {
            return this.bb;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static class a {
        private final int aY;
        private final C0004b[] aZ;

        public a(int i, C0004b[] c0004bArr) {
            this.aY = i;
            this.aZ = c0004bArr;
        }

        public final int getStatusCode() {
            return this.aY;
        }

        public final C0004b[] G() {
            return this.aZ;
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, C0004b[] c0004bArr, CancellationSignal cancellationSignal) {
        HashMap map = new HashMap();
        for (C0004b c0004b : c0004bArr) {
            if (c0004b.getResultCode() == 0) {
                Uri uri = c0004b.getUri();
                if (!map.containsKey(uri)) {
                    map.put(uri, h.a(context, cancellationSignal, uri));
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }

    private static a a(Context context, CancellationSignal cancellationSignal, android.support.v4.b.a aVar) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoA = a(context.getPackageManager(), aVar, context.getResources());
        if (providerInfoA == null) {
            return new a(1, null);
        }
        return new a(0, a(context, aVar, providerInfoA.authority, null));
    }

    private static ProviderInfo a(PackageManager packageManager, android.support.v4.b.a aVar, Resources resources) throws PackageManager.NameNotFoundException {
        String providerAuthority = aVar.getProviderAuthority();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(aVar.getProviderPackage())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + aVar.getProviderPackage());
        }
        List<byte[]> listA = a(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listA, aT);
        List<List<byte[]>> listA2 = a(aVar, resources);
        for (int i = 0; i < listA2.size(); i++) {
            ArrayList arrayList = new ArrayList(listA2.get(i));
            Collections.sort(arrayList, aT);
            if (a(listA, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    private static List<List<byte[]>> a(android.support.v4.b.a aVar, Resources resources) {
        if (aVar.getCertificates() != null) {
            return aVar.getCertificates();
        }
        return android.support.v4.content.a.b.a(resources, aVar.E());
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.support.v4.b.b.C0004b[] a(android.content.Context r19, android.support.v4.b.a r20, java.lang.String r21, android.os.CancellationSignal r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.b.b.a(android.content.Context, android.support.v4.b.a, java.lang.String, android.os.CancellationSignal):android.support.v4.b.b$b[]");
    }
}
