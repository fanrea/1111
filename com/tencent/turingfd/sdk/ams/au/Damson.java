package com.tencent.turingfd.sdk.ams.au;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.bytedance.common.utility.StringEncryptUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Damson {
    public static final String a = Cfinally.a(Cfinally.G0);

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Damson$do, reason: invalid class name */
    public class Cdo implements ServiceConnection {
        public final /* synthetic */ AtomicReference a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Object c;

        /* compiled from: A */
        /* renamed from: com.tencent.turingfd.sdk.ams.au.Damson$do$do, reason: invalid class name and collision with other inner class name */
        public class C0807do extends Thread {
            public final /* synthetic */ IBinder a;

            public C0807do(IBinder iBinder) {
                this.a = iBinder;
            }

            /* JADX WARN: Removed duplicated region for block: B:45:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r15 = this;
                    r1 = r15
                    android.os.IBinder r0 = r1.a
                    java.lang.String r2 = com.tencent.turingfd.sdk.ams.au.Bootes.Cdo.a
                    if (r0 != 0) goto L9
                    r0 = 0
                    goto L1f
                L9:
                    java.lang.String r2 = com.tencent.turingfd.sdk.ams.au.Bootes.Cdo.a
                    android.os.IInterface r2 = r0.queryLocalInterface(r2)
                    if (r2 == 0) goto L19
                    boolean r3 = r2 instanceof com.tencent.turingfd.sdk.ams.au.Bootes
                    if (r3 == 0) goto L19
                    r0 = r2
                    com.tencent.turingfd.sdk.ams.au.Bootes r0 = (com.tencent.turingfd.sdk.ams.au.Bootes) r0
                    goto L1f
                L19:
                    com.tencent.turingfd.sdk.ams.au.Bootes$do$do r2 = new com.tencent.turingfd.sdk.ams.au.Bootes$do$do
                    r2.<init>(r0)
                    r0 = r2
                L1f:
                    r3 = 2000(0x7d0, float:2.803E-42)
                    boolean r4 = r0.e(r3)     // Catch: java.lang.Throwable -> L6a
                    if (r4 != 0) goto L2c
                    r0.c(r3)     // Catch: java.lang.Throwable -> L6a
                    r4 = 1
                    goto L2d
                L2c:
                    r4 = 0
                L2d:
                    com.tencent.turingfd.sdk.ams.au.Core r5 = r0.b(r3)     // Catch: java.lang.Throwable -> L6b
                    byte[] r5 = r5.b     // Catch: java.lang.Throwable -> L6b
                    com.tencent.turingfd.sdk.ams.au.Damson$if r5 = com.tencent.turingfd.sdk.ams.au.Damson.a(r5)     // Catch: java.lang.Throwable -> L6b
                    int r6 = r5.a     // Catch: java.lang.Throwable -> L6b
                    if (r6 == 0) goto L47
                    com.tencent.turingfd.sdk.ams.au.Damson$do r5 = com.tencent.turingfd.sdk.ams.au.Damson.Cdo.this     // Catch: java.lang.Throwable -> L6b
                    java.util.concurrent.atomic.AtomicReference r5 = r5.a     // Catch: java.lang.Throwable -> L6b
                    com.tencent.turingfd.sdk.ams.au.Codlin r6 = com.tencent.turingfd.sdk.ams.au.Codlin.a(r6, r4)     // Catch: java.lang.Throwable -> L6b
                    r5.set(r6)     // Catch: java.lang.Throwable -> L6b
                    goto L78
                L47:
                    com.tencent.turingfd.sdk.ams.au.Cumquat r5 = r5.b     // Catch: java.lang.Throwable -> L6b
                    int r11 = r0.a()     // Catch: java.lang.Throwable -> L6b
                    com.tencent.turingfd.sdk.ams.au.Damson$do r6 = com.tencent.turingfd.sdk.ams.au.Damson.Cdo.this     // Catch: java.lang.Throwable -> L6b
                    java.util.concurrent.atomic.AtomicReference r13 = r6.a     // Catch: java.lang.Throwable -> L6b
                    com.tencent.turingfd.sdk.ams.au.Codlin r14 = new com.tencent.turingfd.sdk.ams.au.Codlin     // Catch: java.lang.Throwable -> L6b
                    r6 = 0
                    r7 = 200(0xc8, float:2.8E-43)
                    long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L6b
                    com.tencent.turingfd.sdk.ams.au.Damson$do r10 = com.tencent.turingfd.sdk.ams.au.Damson.Cdo.this     // Catch: java.lang.Throwable -> L6b
                    long r2 = r10.b     // Catch: java.lang.Throwable -> L6b
                    long r8 = r8 - r2
                    java.lang.String r10 = r5.c     // Catch: java.lang.Throwable -> L6b
                    r5 = r14
                    r12 = r4
                    r5.<init>(r6, r7, r8, r10, r11, r12)     // Catch: java.lang.Throwable -> L6b
                    r13.set(r14)     // Catch: java.lang.Throwable -> L6b
                    goto L78
                L6a:
                    r4 = -1
                L6b:
                    com.tencent.turingfd.sdk.ams.au.Damson$do r2 = com.tencent.turingfd.sdk.ams.au.Damson.Cdo.this
                    java.util.concurrent.atomic.AtomicReference r2 = r2.a
                    r3 = -2003(0xfffffffffffff82d, float:NaN)
                    com.tencent.turingfd.sdk.ams.au.Codlin r3 = com.tencent.turingfd.sdk.ams.au.Codlin.a(r3, r4)
                    r2.set(r3)
                L78:
                    com.tencent.turingfd.sdk.ams.au.Damson$do r2 = com.tencent.turingfd.sdk.ams.au.Damson.Cdo.this
                    java.lang.Object r2 = r2.c
                    monitor-enter(r2)
                    com.tencent.turingfd.sdk.ams.au.Damson$do r3 = com.tencent.turingfd.sdk.ams.au.Damson.Cdo.this     // Catch: java.lang.Throwable -> L9c
                    java.lang.Object r3 = r3.c     // Catch: java.lang.Throwable -> L9c
                    r3.notify()     // Catch: java.lang.Throwable -> L9c
                    monitor-exit(r2)     // Catch: java.lang.Throwable -> L9c
                    com.tencent.turingfd.sdk.ams.au.Lemon r2 = com.tencent.turingfd.sdk.ams.au.Lemon.f
                    java.lang.String r3 = "s_t_d_ask"
                    r4 = 0
                    boolean r2 = r2.a(r3, r4)
                    if (r2 == 0) goto L9b
                    r2 = 2000(0x7d0, float:2.803E-42)
                    r0.a(r2)     // Catch: android.os.RemoteException -> L96
                    goto L9b
                L96:
                    r0 = move-exception
                    r2 = r0
                    r2.printStackTrace()
                L9b:
                    return
                L9c:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch: java.lang.Throwable -> L9c
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Damson.Cdo.C0807do.run():void");
            }
        }

        public Cdo(AtomicReference atomicReference, long j, Object obj) {
            this.a = atomicReference;
            this.b = j;
            this.c = obj;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            new C0807do(iBinder).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.a.set(Codlin.a(-2004, -3));
            synchronized (this.c) {
                this.c.notify();
            }
        }
    }

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Damson$if, reason: invalid class name */
    public static class Cif {
        public int a;
        public Cumquat b;

        public Cif(int i, Cumquat cumquat) {
            this.a = i;
            this.b = cumquat;
        }
    }

    public static Codlin a() {
        String name;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            Method method = Class.forName(Cfinally.a(Cfinally.H0)).getMethod(Cfinally.a(Cfinally.I0), new Class[0]);
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
            Provider[] providers = Security.getProviders();
            if (providers == null) {
                return Codlin.a(-1201);
            }
            int length = providers.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    name = providers[i].getName();
                    if (name != null && name.startsWith(a)) {
                        break;
                    }
                    i++;
                } else {
                    name = null;
                    break;
                }
            }
            if (TextUtils.isEmpty(name)) {
                return Codlin.a(-1202);
            }
            boolean z = name.split("\\.").length > 1;
            try {
                KeyStore keyStore = KeyStore.getInstance(name);
                keyStore.load(null);
                int iMyUid = Process.myUid();
                try {
                } catch (Throwable unused) {
                }
                if (keyStore.getCertificate("dddd" + iMyUid) == null) {
                    try {
                        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(d.a, name);
                        try {
                            try {
                                keyPairGenerator.initialize(Gemini.a("dddd" + iMyUid + Cfinally.a(Cfinally.J0), z ? 16 : 4).a(StringEncryptUtils.SHA_256).b("PSS").a());
                                try {
                                    keyPairGenerator.generateKeyPair();
                                } catch (Throwable unused2) {
                                }
                            } catch (InvalidAlgorithmParameterException unused3) {
                                return Codlin.a(-1701);
                            }
                        } catch (ClassNotFoundException unused4) {
                            return Codlin.a(-1601);
                        } catch (IllegalAccessException unused5) {
                            return Codlin.a(-1603);
                        } catch (InstantiationException unused6) {
                            return Codlin.a(-1605);
                        } catch (NoSuchMethodException unused7) {
                            return Codlin.a(-1602);
                        } catch (InvocationTargetException unused8) {
                            return Codlin.a(-1604);
                        }
                    } catch (NoSuchAlgorithmException unused9) {
                        return Codlin.a(-1501);
                    } catch (NoSuchProviderException unused10) {
                        return Codlin.a(-1502);
                    }
                }
                if (z) {
                    try {
                        return new Codlin(0, 100, System.currentTimeMillis() - jCurrentTimeMillis, new Cumquat(keyStore.getCertificateChain("dddd" + iMyUid)).c, -1, -2);
                    } catch (KeyStoreException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Key key = keyStore.getKey("dddd" + iMyUid, Cfinally.a(Cfinally.K0).toCharArray());
                        if (key != null) {
                            Cif cifA = a(key.getEncoded());
                            int i2 = cifA.a;
                            if (i2 != 0) {
                                return Codlin.a(i2);
                            }
                            Cumquat cumquat = cifA.b;
                            if (Lemon.f.a("s_t_d_entry", false)) {
                                try {
                                    keyStore.deleteEntry("dddd" + iMyUid);
                                } catch (Throwable unused11) {
                                }
                            }
                            return new Codlin(0, 100, System.currentTimeMillis() - jCurrentTimeMillis, cumquat.c, -1, -2);
                        }
                    } catch (KeyStoreException unused12) {
                        return Codlin.a(-1801);
                    } catch (NoSuchAlgorithmException unused13) {
                        return Codlin.a(-1802);
                    } catch (UnrecoverableKeyException unused14) {
                        return Codlin.a(-1803);
                    }
                }
                return Codlin.a(-1901);
            } catch (IOException unused15) {
                return Codlin.a(-1303);
            } catch (KeyStoreException unused16) {
                return Codlin.a(-1301);
            } catch (NoSuchAlgorithmException unused17) {
                return Codlin.a(-1304);
            } catch (CertificateException unused18) {
                return Codlin.a(-1302);
            }
        } catch (ClassNotFoundException unused19) {
            return Codlin.a(-1104);
        } catch (IllegalAccessException unused20) {
            return Codlin.a(-1103);
        } catch (NoSuchMethodException unused21) {
            return Codlin.a(-1102);
        } catch (InvocationTargetException unused22) {
            return Codlin.a(-1101);
        }
    }

    public static Codlin a(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent();
        intent.setAction(Cfinally.a(Cfinally.L0));
        intent.setPackage(Cfinally.a(Cfinally.M0));
        Object obj = new Object();
        AtomicReference atomicReference = new AtomicReference();
        atomicReference.set(Codlin.a(-2001, -1));
        if (context.getApplicationContext().bindService(intent, new Cdo(atomicReference, jCurrentTimeMillis, obj), 1)) {
            synchronized (obj) {
                try {
                    obj.wait(5000L);
                } catch (InterruptedException unused) {
                }
            }
        } else {
            atomicReference.set(Codlin.a(-2002, -1));
        }
        return (Codlin) atomicReference.get();
    }

    public static Cif a(byte[] bArr) {
        if (bArr == null) {
            return new Cif(-3001, null);
        }
        if (bArr.length < 4) {
            return new Cif(-3001, null);
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i += (bArr2[i2] & 255) << (i2 * 8);
        }
        if (i > 1048576) {
            return new Cif(-3003, null);
        }
        byte[] bArr3 = new byte[i];
        int i3 = i + 4;
        if (bArr.length < i3) {
            return new Cif(-3004, null);
        }
        System.arraycopy(bArr, 4, bArr3, 0, i);
        Cumquat cumquat = new Cumquat(new String(bArr3), "");
        int length = bArr.length - i3;
        if (length != 0) {
            byte[] bArr4 = new byte[length];
            System.arraycopy(bArr, i3, bArr4, 0, length);
            Base64.encodeToString(bArr4, 2);
            return new Cif(0, cumquat);
        }
        return new Cif(-3005, null);
    }
}
