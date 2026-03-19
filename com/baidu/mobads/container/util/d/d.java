package com.baidu.mobads.container.util.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import com.baidu.mobads.container.util.b.a;
import com.baidu.mobads.container.util.b.a.b;
import com.baidu.mobads.container.util.bw;
import com.baidu.mobads.container.util.x;
import com.luck.picture.lib.config.PictureMimeType;
import com.pandora.common.utils.Times;
import io.reactivex.annotations.SchedulerSupport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    public static final String a = "common/";
    public static final String b = "img_download/";
    public static final String c = "video_download/";
    private static final int h = 2457600;
    private static final int i = 4;
    private static final int j = 1140;
    private static final int k = 1140;
    private Context e;
    private final LruCache<String, c> f = new LruCache<>(100);
    private static volatile d d = null;
    private static final String g = d.class.getSimpleName();
    private static final com.baidu.mobads.container.util.d.b l = new com.baidu.mobads.container.util.d.e();

    /* renamed from: com.baidu.mobads.container.util.d.d$d, reason: collision with other inner class name */
    public interface InterfaceC0136d<T> extends a.c<T> {
        void a(String str, String str2, View view, int i);

        void a(String str, String str2, View view, com.baidu.mobads.container.util.d.c cVar);

        void a(String str, String str2, View view, T t);
    }

    public enum e {
        PICTURE("normal"),
        VIDEO("video"),
        COMMON("common"),
        CUSTOM(SchedulerSupport.CUSTOM);

        private final String e;

        e(String str) {
            this.e = str;
        }

        public String b() {
            return this.e;
        }

        public static e b(String str) {
            for (e eVar : values()) {
                if (eVar.e.equalsIgnoreCase(str)) {
                    return eVar;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c extends f {
        private final Context a;
        private final String b;
        private final CopyOnWriteArrayList<f> c;

        public c(Context context, String str) {
            super(null);
            this.c = new CopyOnWriteArrayList<>();
            this.a = context.getApplicationContext();
            this.b = str;
        }

        public void a(f fVar) {
            this.c.add(fVar);
        }

        public void a(InterfaceC0136d interfaceC0136d) {
            this.c.remove(interfaceC0136d);
        }

        @Override // com.baidu.mobads.container.util.d.d.f, com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, int i) {
            Iterator<f> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().a(str, str2, view, i);
            }
        }

        @Override // com.baidu.mobads.container.util.d.d.f, com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, com.baidu.mobads.container.util.d.c cVar) {
            Iterator<f> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().a(str, str2, view, cVar);
            }
            this.c.clear();
            d.a(this.a).b(str);
        }

        @Override // com.baidu.mobads.container.util.d.d.f, com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, Object obj) {
            Iterator<f> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().a(str, str2, view, obj);
            }
            this.c.clear();
            d.a(this.a).b(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class f implements InterfaceC0136d<Object> {
        private f() {
        }

        /* synthetic */ f(com.baidu.mobads.container.util.d.e eVar) {
            this();
        }

        @Override // com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, int i) {
        }

        @Override // com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, com.baidu.mobads.container.util.d.c cVar) {
        }

        @Override // com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, Object obj) {
        }

        @Override // com.baidu.mobads.container.util.b.a.c
        public Object b(File file) {
            return file;
        }

        @Override // com.baidu.mobads.container.util.b.a.c
        public <D> Object b(D d) {
            return d;
        }
    }

    public static d a(Context context) {
        if (d == null) {
            synchronized (d.class) {
                if (d == null && context != null) {
                    d = new d(context);
                }
            }
        }
        return d;
    }

    private d(Context context) {
        this.e = context.getApplicationContext();
    }

    public c a(String str) {
        return this.f.get(str);
    }

    public <T> void a(String str, c cVar) {
        this.f.put(str, cVar);
    }

    public void b(String str) {
        this.f.remove(str);
    }

    public void a() {
        com.baidu.mobads.container.util.b.a.a(this.e).a();
    }

    public static b a(Context context, String str) {
        return new b(context, str, null);
    }

    public String c(String str) {
        if (!j(str)) {
            return a(str, e.PICTURE);
        }
        return a(str, e.VIDEO);
    }

    public String a(String str, e eVar) {
        File fileB;
        com.baidu.mobads.container.util.b.a aVarA = com.baidu.mobads.container.util.b.a.a(this.e);
        if (aVarA != null && (fileB = aVarA.b(str, eVar)) != null && fileB.exists()) {
            return fileB.getAbsolutePath();
        }
        return null;
    }

    public void d(String str) {
        a(this.e, str).c();
    }

    public void a(String str, InterfaceC0136d<?> interfaceC0136d) {
        a(this.e, str).a((InterfaceC0136d) interfaceC0136d);
    }

    public Bitmap e(String str) {
        return a(this.e, str).a.a(e.PICTURE).a();
    }

    public void a(String str, com.baidu.mobads.container.util.d.a aVar) {
        a(this.e, str).a.a(e.PICTURE).a((InterfaceC0136d) aVar);
    }

    public void a(String str, boolean z, com.baidu.mobads.container.util.d.a aVar) {
        a(this.e, str).a.a(e.PICTURE).a.a(z).a((InterfaceC0136d) aVar);
    }

    public File f(String str) {
        return a(this.e, str).a.a(e.VIDEO).b();
    }

    public void a(String str, com.baidu.mobads.container.util.d.b bVar) {
        a(this.e, str).a.a(e.VIDEO).a((InterfaceC0136d) bVar);
    }

    public Bitmap a(ImageView imageView, String str) {
        return a(this.e, str).a.a(e.PICTURE).b.a(imageView, true).a();
    }

    public Bitmap b(ImageView imageView, String str) {
        return a(this.e, str).a.a(e.PICTURE).b.a(imageView, false).a();
    }

    public void a(ImageView imageView, String str, com.baidu.mobads.container.util.d.a aVar) {
        a(this.e, str).a.a(e.PICTURE).b.a(imageView, false).a((InterfaceC0136d) aVar);
    }

    public static class b {
        public final a a;
        public final C0135b b;
        public final c c;
        private final Context d;
        private final String e;
        private e f;
        private boolean g;
        private String h;
        private int i;
        private ImageView j;
        private boolean k;
        private Bitmap.CompressFormat l;
        private int m;
        private int n;
        private int o;

        /* synthetic */ b(Context context, String str, com.baidu.mobads.container.util.d.e eVar) {
            this(context, str);
        }

        private b(Context context, String str) {
            this.a = new a(this, null);
            this.f = null;
            this.g = true;
            this.h = null;
            this.i = -1;
            this.b = new C0135b(this);
            this.j = null;
            this.k = false;
            this.l = Bitmap.CompressFormat.PNG;
            this.m = -1;
            this.c = new c(this);
            this.n = 10000;
            this.o = 10000;
            this.d = context;
            this.e = str;
            if (!d.j(str) && !d.k(str) && TextUtils.isEmpty(com.baidu.mobads.container.h.a.a().a("function", com.baidu.mobads.container.h.a.a))) {
                this.g = true;
            }
        }

        public static class a {
            private final b a;

            /* synthetic */ a(b bVar, com.baidu.mobads.container.util.d.e eVar) {
                this(bVar);
            }

            private a(b bVar) {
                this.a = bVar;
            }

            public b a(String str, int i) {
                this.a.h = str;
                this.a.i = i;
                return this.a;
            }

            public b a(e eVar) {
                this.a.f = eVar;
                return this.a;
            }

            public b a(boolean z) {
                this.a.g = z;
                return this.a;
            }
        }

        /* renamed from: com.baidu.mobads.container.util.d.d$b$b, reason: collision with other inner class name */
        public static class C0135b {
            private final b a;

            C0135b(b bVar) {
                this.a = bVar;
            }

            public b a(ImageView imageView) {
                this.a.j = imageView;
                this.a.k = false;
                return this.a;
            }

            public b a(ImageView imageView, boolean z) {
                this.a.j = imageView;
                this.a.k = z;
                return this.a;
            }

            public b a(Bitmap.CompressFormat compressFormat) {
                this.a.l = compressFormat;
                return this.a;
            }

            public b a(int i) {
                this.a.m = i;
                return this.a;
            }
        }

        public static class c {
            private final b a;

            public c(b bVar) {
                this.a = bVar;
            }

            public b a(int i, int i2) {
                this.a.n = i;
                this.a.o = i2;
                return this.a;
            }
        }

        public Bitmap a() {
            return (Bitmap) b(new g(this));
        }

        public File b() {
            return (File) b(new h(this));
        }

        public void c() {
            b(d.l);
        }

        public <T> void a(InterfaceC0136d<T> interfaceC0136d) {
            if (interfaceC0136d == null) {
                b(d.l);
            } else {
                b(interfaceC0136d);
            }
        }

        private <T> T b(InterfaceC0136d<T> interfaceC0136d) {
            if (TextUtils.isEmpty(this.e)) {
                interfaceC0136d.a(this.e, this.e, (View) this.j, com.baidu.mobads.container.util.d.c.e);
                return null;
            }
            if (this.f == null) {
                if (d.j(this.e)) {
                    this.f = e.VIDEO;
                } else {
                    this.f = e.PICTURE;
                }
            }
            if (this.f != e.PICTURE || !TextUtils.isEmpty(com.baidu.mobads.container.h.a.a().a("function", com.baidu.mobads.container.h.a.a))) {
                this.g = false;
            }
            com.baidu.mobads.container.util.b.a.b bVarA = new b.a(this.e).a(this.f).b(this.g).a(this.h).a(this.i).a(this.n).b(d.d(this.e, this.f) ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : 0L).b(this.o).a();
            c cVarA = d.a(this.d).a(bVarA.d);
            if (cVarA != null) {
                a(cVarA, (InterfaceC0136d) interfaceC0136d, false);
            } else {
                c cVar = new c(this.d, bVarA.d);
                d.a(this.d).a(bVarA.d, cVar);
                a(cVar, (InterfaceC0136d) interfaceC0136d, true);
                com.baidu.mobads.container.util.b.f<?> fVarA = com.baidu.mobads.container.util.b.a.a(this.d).a(bVarA, new i(this, cVar, interfaceC0136d));
                if (fVarA != null) {
                    Object objA = a(fVarA.b(), interfaceC0136d);
                    cVar.a(bVarA.d, this.e, this.j, objA);
                    return interfaceC0136d.b((InterfaceC0136d<T>) objA);
                }
            }
            return null;
        }

        private <T> void a(c cVar, InterfaceC0136d<T> interfaceC0136d, boolean z) {
            cVar.a((f) new j(this, z, interfaceC0136d));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <T> T a(Object obj, a.c<T> cVar) {
            if (obj instanceof File) {
                return cVar.b((File) obj);
            }
            return cVar.b((a.c<T>) obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj) throws IOException {
            if (this.j != null && (obj instanceof Bitmap)) {
                Bitmap bitmap = (Bitmap) obj;
                if (!this.k) {
                    d.b(this.j, bitmap, this.e);
                } else {
                    com.baidu.mobads.container.util.h.a(new k(this, bitmap));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ImageView imageView, Bitmap bitmap, String str) throws IOException {
        Bitmap bitmapA;
        if (str.substring(str.lastIndexOf("/") + 1).toUpperCase().contains("PNG")) {
            bitmapA = bitmap;
        } else {
            bitmapA = a(a(bitmap, 100 - (b(bitmap) * 10)), c(r3));
        }
        if (bitmapA != null) {
            bitmap = bitmapA;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
                imageView.setBackgroundResource(0);
                imageView.setVisibility(0);
                return;
            }
            return;
        }
        new Handler(Looper.getMainLooper()).post(new com.baidu.mobads.container.util.d.f(imageView, bitmap));
    }

    private static class a extends FilterInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long j2 = 0;
            while (j2 < j) {
                long jSkip = this.in.skip(j - j2);
                if (jSkip == 0) {
                    if (read() < 0) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 += jSkip;
            }
            return j2;
        }
    }

    public boolean g(String str) {
        if (j(str)) {
            return b(str, e.VIDEO);
        }
        return b(str, e.PICTURE);
    }

    public boolean b(String str, e eVar) {
        return com.baidu.mobads.container.util.b.a.a(this.e).a(str, eVar);
    }

    public boolean a(String str, String str2) {
        return com.baidu.mobads.container.util.b.a.a(this.e).a(str, str2);
    }

    public int h(String str) {
        if (j(str)) {
            return com.baidu.mobads.container.util.b.a.a(this.e).d(str, e.VIDEO);
        }
        return com.baidu.mobads.container.util.b.a.a(this.e).d(str, e.PICTURE);
    }

    public void i(String str) {
        if (j(str)) {
            c(str, e.VIDEO);
        }
        c(str, e.PICTURE);
    }

    public void c(String str, e eVar) {
        com.baidu.mobads.container.util.b.a.a(this.e).c(str, eVar);
    }

    public static boolean d(String str, e eVar) {
        if (e.VIDEO.equals(eVar) && str.indexOf(".mp4") > 0) {
            return true;
        }
        return false;
    }

    public static boolean j(String str) {
        if (str.indexOf(".mp4") > 0 || str.indexOf(PictureMimeType.GIF) > 0) {
            return true;
        }
        return false;
    }

    public static boolean k(String str) {
        return str.indexOf(".json") > 0;
    }

    public long a(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        long length = randomAccessFile.length();
        randomAccessFile.close();
        return length;
    }

    public void l(String str) {
        b("_state", str);
    }

    public void b(String str, String str2) {
        try {
            if (this.e == null) {
                return;
            }
            String str3 = new SimpleDateFormat(Times.YYYY_MM_DD, Locale.getDefault()).format(new Date());
            File fileK = bw.k(this.e);
            a(new File((fileK != null ? fileK.getPath() + "/bd_tools_log/" : this.e.getFilesDir() + "/bd_tools_log/") + str3 + str), str2.getBytes());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(File file, byte[] bArr) {
        if (file != null) {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(randomAccessFile.length());
                randomAccessFile.write(bArr);
                randomAccessFile.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean a(File file, byte[] bArr, int i2, long j2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        if (randomAccessFile.length() != j2) {
            return false;
        }
        randomAccessFile.seek(randomAccessFile.length());
        randomAccessFile.write(bArr, 0, i2);
        randomAccessFile.close();
        return true;
    }

    public static int a(Bitmap bitmap) {
        if (x.a(null).a() >= 19) {
            return bitmap.getAllocationByteCount();
        }
        if (x.a(null).a() >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static int b(Bitmap bitmap) {
        int iA = a(bitmap);
        if (iA <= h) {
            return 0;
        }
        int i2 = iA / h;
        if (i2 > 4) {
            return 4;
        }
        return i2;
    }

    public static Bitmap a(Bitmap bitmap, int i2) throws IOException {
        if (i2 == 100) {
            return bitmap;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        try {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (byteArray != null) {
                return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int c(Bitmap bitmap) {
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int i2 = 1;
        while (true) {
            if (height < 1140 && width < 1140) {
                break;
            }
            i2 *= 2;
            height /= 2;
            width /= 2;
        }
        if (i2 > 4) {
            return 4;
        }
        return i2;
    }

    public static Bitmap a(Bitmap bitmap, float f2) {
        if (f2 <= 1.0f || bitmap == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float f3 = 1.0f / f2;
        matrix.postScale(f3, f3);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap b(Bitmap bitmap, int i2) {
        if (bitmap != null && d != null && d.e != null && x.a(null).a() >= 17) {
            RenderScript renderScriptCreate = RenderScript.create(d.e);
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
            Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            scriptIntrinsicBlurCreate.setRadius(i2);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
            allocationCreateTyped.copyTo(bitmap);
            renderScriptCreate.destroy();
            return bitmap;
        }
        return bitmap;
    }
}
