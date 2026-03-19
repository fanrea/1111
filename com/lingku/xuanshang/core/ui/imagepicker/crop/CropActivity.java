package com.lingku.xuanshang.core.ui.imagepicker.crop;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import lkxssdk.a.a;
import lkxssdk.i0.b;
import lkxssdk.l0.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CropActivity extends BaseActivity implements View.OnClickListener {
    public ViewCrop d;
    public ImageView e;
    public ImageView f;
    public RelativeLayout g;
    public Bitmap h;
    public int i;
    public int j;
    public int k;
    public int l;
    public float m;
    public String n;
    public boolean o;

    @Override // lkxssdk.d.b
    public void a() {
        Bitmap bitmap = this.h;
        if (bitmap != null) {
            bitmap.recycle();
            this.h = null;
        }
        finish();
        overridePendingTransition(0, a.a(1, false));
    }

    @Override // lkxssdk.d.b
    public void a(Bundle bundle) {
        this.n = getIntent().getStringExtra("picPath");
        this.o = getIntent().getBooleanExtra("keepRate", false);
    }

    @Override // lkxssdk.d.b
    public void b() {
        e eVarA = e.a();
        this.g = (RelativeLayout) findViewById(eVarA.b.getResources().getIdentifier("imageRL", "id", eVarA.c));
        e eVarA2 = e.a();
        this.d = (ViewCrop) findViewById(eVarA2.b.getResources().getIdentifier("viewCrop", "id", eVarA2.c));
        e eVarA3 = e.a();
        this.e = (ImageView) findViewById(eVarA3.b.getResources().getIdentifier("fork", "id", eVarA3.c));
        e eVarA4 = e.a();
        this.f = (ImageView) findViewById(eVarA4.b.getResources().getIdentifier("ok", "id", eVarA4.c));
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    @Override // lkxssdk.d.b
    public void c() {
    }

    @Override // lkxssdk.d.b
    public void d() {
        b.a().a(21, 0, 0, "");
        a();
    }

    @Override // lkxssdk.d.b
    public void e() {
    }

    @Override // lkxssdk.d.b
    public int f() {
        e eVarA = e.a();
        return eVarA.b.getResources().getIdentifier("lkxs_aty_crop", "layout", eVarA.c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        int id = view.getId();
        e eVarA = e.a();
        if (id == eVarA.b.getResources().getIdentifier("fork", "id", eVarA.c)) {
            d();
            return;
        }
        int id2 = view.getId();
        e eVarA2 = e.a();
        if (id2 == eVarA2.b.getResources().getIdentifier("ok", "id", eVarA2.c)) {
            if (this.h == null) {
                b.a().a(23, 0, 0, "");
            } else {
                float f = this.d.getCropFrame().left - this.k;
                float f2 = this.m;
                int i = (int) (f / f2);
                int i2 = (int) ((r10.top - this.l) / f2);
                int iWidth = (int) (r10.width() / this.m);
                int iHeight = (int) (r10.height() / this.m);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.RGB_565);
                new Canvas(bitmapCreateBitmap).drawBitmap(this.h, new Rect(i, i2, i + iWidth, i2 + iHeight), new RectF(0.0f, 0.0f, iWidth, iHeight), (Paint) null);
                File file = new File(getApplicationContext().getExternalFilesDir("XSWFile").getAbsolutePath() + File.separator + "temp");
                if (!file.exists()) {
                    file.mkdirs();
                }
                b.a().a(22, 0, 0, a.a(new File(file, "pic_" + System.currentTimeMillis() + PictureMimeType.JPG).getAbsolutePath(), bitmapCreateBitmap, Bitmap.CompressFormat.JPEG));
            }
            a();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Bitmap bitmapDecodeFile;
        int attributeInt;
        Rect rect;
        super.onWindowFocusChanged(z);
        if (z && this.h == null) {
            String str = this.n;
            Bitmap bitmapCreateBitmap = null;
            if (!TextUtils.isEmpty(str)) {
                try {
                    attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                int i = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = false;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    bitmapDecodeFile = BitmapFactory.decodeFile(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    bitmapDecodeFile = null;
                }
                if (bitmapDecodeFile == null || i <= 0) {
                    bitmapCreateBitmap = bitmapDecodeFile;
                } else {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(i);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
                }
            }
            this.h = bitmapCreateBitmap;
            if (bitmapCreateBitmap == null) {
                Toast.makeText(getApplicationContext(), "获取图片失败", 0).show();
                return;
            }
            int width = bitmapCreateBitmap.getWidth();
            int height = this.h.getHeight();
            int width2 = this.g.getWidth();
            int height2 = this.g.getHeight();
            Log.e("tag", "screenW=" + width2 + ",screenH=" + height2);
            Log.e("tag", "picW=" + width + ",picH=" + height);
            if ((height2 * 1.0d) / width2 > (height * 1.0d) / width) {
                float f = (width2 * 1.0f) / width;
                this.m = f;
                int i2 = (int) (height * f);
                this.i = i2;
                this.j = width2;
                this.k = 0;
                this.l = (height2 - i2) / 2;
            } else {
                float f2 = (height2 * 1.0f) / height;
                this.m = f2;
                int i3 = (int) (width * f2);
                this.j = i3;
                this.i = height2;
                this.k = (width2 - i3) / 2;
                this.l = 0;
            }
            int i4 = this.k;
            int i5 = this.l;
            Rect rect2 = new Rect(i4, i5, this.j + i4, this.i + i5);
            if (!this.o) {
                rect = new Rect(rect2);
            } else if (this.j > this.i) {
                int i6 = this.k;
                int i7 = this.j;
                int i8 = this.i;
                int i9 = this.l;
                rect = new Rect(((i7 - i8) / 2) + i6, i9, i6 + ((i7 + i8) / 2), i8 + i9);
            } else {
                int i10 = this.k;
                int i11 = this.l;
                int i12 = this.i;
                int i13 = this.j;
                rect = new Rect(i10, ((i12 - i13) / 2) + i11, i10 + i13, i11 + ((i13 + i12) / 2));
            }
            ViewCrop viewCrop = this.d;
            boolean z2 = this.o;
            Bitmap bitmap = this.h;
            viewCrop.t = false;
            viewCrop.u = z2;
            viewCrop.f = bitmap;
            viewCrop.g = rect2;
            viewCrop.h = rect;
            viewCrop.invalidate();
        }
    }
}
