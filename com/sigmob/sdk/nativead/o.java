package com.sigmob.sdk.nativead;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class o extends ViewGroup {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;
    private int j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private float o;
    private int p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private final float[] v;
    private e w;
    private final a x;
    private int y;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (o.this.l) {
                b bVar = (b) v;
                int selectedIndex = -1;
                b selectedItem = o.this.getSelectedItem();
                int i = 0;
                if (o.this.t) {
                    bVar.a(!bVar.b);
                    int childCount = o.this.getChildCount();
                    while (true) {
                        if (i >= childCount) {
                            break;
                        }
                        if (o.this.b(i) == bVar) {
                            selectedIndex = i;
                            break;
                        }
                        i++;
                    }
                } else {
                    if (selectedItem != null) {
                        selectedItem.a(false);
                    }
                    bVar.a(true);
                    selectedIndex = o.this.getSelectedIndex();
                }
                if (o.this.w != null) {
                    o.this.w.onItemClick(selectedIndex, bVar.getText().toString());
                }
            }
        }
    }

    class b extends TextView {
        private boolean b;
        private final Paint c;
        private final Rect d;

        public b(Context context, CharSequence text) {
            super(context);
            this.b = false;
            Paint paint = new Paint(1);
            this.c = paint;
            this.d = new Rect();
            paint.setStyle(Paint.Style.FILL);
            setPadding(o.this.r, o.this.s, o.this.r, o.this.s);
            setLayoutParams(new c(o.this.y, -2));
            setGravity(17);
            setTextSize(0, o.this.o);
            setSingleLine(true);
            setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            setMaxEms(4);
            setText(text);
            setClickable(true);
            a();
        }

        private void a() {
            int i;
            o.this.u = false;
            if (this.b) {
                this.c.setColor(o.this.n);
                i = o.this.m;
            } else {
                this.c.setColor(o.this.k);
                i = o.this.j;
            }
            setTextColor(i);
        }

        private void b() {
            int i = this.b ? o.this.n : o.this.k;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(o.this.v);
            gradientDrawable.setColor(i);
            if (Build.VERSION.SDK_INT < 16) {
                setBackgroundDrawable(gradientDrawable);
            } else {
                setBackground(gradientDrawable);
            }
        }

        public void a(boolean select) {
            this.b = select;
            a();
        }

        @Override // android.widget.TextView
        protected boolean getDefaultEditable() {
            return false;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            if (!o.this.u) {
                b();
            }
            super.onDraw(canvas);
        }

        @Override // android.widget.TextView, android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            int action = event.getAction();
            if (action != 0) {
                if (action == 1 || (action == 2 && !this.d.contains((int) event.getX(), (int) event.getY()))) {
                }
                return super.onTouchEvent(event);
            }
            getDrawingRect(this.d);
            a();
            invalidate();
            return super.onTouchEvent(event);
        }
    }

    public static class c extends ViewGroup.LayoutParams {
        public c(int width, int height) {
            super(width, height);
        }

        public c(Context c, AttributeSet attrs) {
            super(c, attrs);
        }
    }

    static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.sigmob.sdk.nativead.o.d.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel in) {
                return new d(in);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int size) {
                return new d[size];
            }
        };
        int a;
        String[] b;
        int c;

        public d(Parcel source) {
            super(source);
            int i = source.readInt();
            this.a = i;
            String[] strArr = new String[i];
            this.b = strArr;
            source.readStringArray(strArr);
            this.c = source.readInt();
        }

        public d(Parcelable superState) {
            super(superState);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            int length = this.b.length;
            this.a = length;
            dest.writeInt(length);
            dest.writeStringArray(this.b);
            dest.writeInt(this.c);
        }
    }

    public interface e {
        void onItemClick(int position, String text);
    }

    public o(Context context) {
        this(context, null);
    }

    public o(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public o(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.a = -16777216;
        int color = Color.parseColor("#EEEEEE");
        this.b = color;
        this.c = -1;
        int color2 = Color.parseColor("#FE7E03");
        this.d = color2;
        this.u = false;
        this.v = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.x = new a();
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        int iA = (int) a(100.0f);
        if (i2 > i) {
            this.y = (i - iA) / 3;
        } else {
            this.y = (i2 - iA) / 3;
        }
        float fB = b(11.0f);
        this.e = fB;
        float fA = a(8.0f);
        this.f = fA;
        float fA2 = a(8.0f);
        this.g = fA2;
        float fA3 = a(8.0f);
        this.h = fA3;
        float fA4 = a(5.0f);
        this.i = fA4;
        this.j = -16777216;
        this.k = color;
        this.m = -1;
        this.n = color2;
        this.o = fB;
        this.p = (int) fA;
        this.q = (int) fA2;
        this.r = (int) fA3;
        this.s = (int) fA4;
        this.t = false;
        this.l = true;
    }

    private float a(float dp) {
        return TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }

    private void a(CharSequence tag) {
        b bVar = new b(getContext(), tag);
        bVar.setOnClickListener(this.x);
        addView(bVar);
    }

    private int b(float sp) {
        return (int) TypedValue.applyDimension(2, sp, getResources().getDisplayMetrics());
    }

    public int a(int position) {
        return a(position, true);
    }

    public int a(int position, boolean flag) {
        if (position >= getChildCount()) {
            return -1;
        }
        b(position).a(flag);
        return position;
    }

    public int a(String text) {
        ArrayList<String> allItemSelectedTextWithListArray = getAllItemSelectedTextWithListArray();
        if (allItemSelectedTextWithListArray == null || !allItemSelectedTextWithListArray.contains(text)) {
            return -1;
        }
        return allItemSelectedTextWithListArray.indexOf(text);
    }

    public void a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            b(i).a(true);
        }
    }

    public void a(int position, String txt) {
        if (position >= getChildCount()) {
            return;
        }
        b(position).setText(txt);
    }

    protected b b(int index) {
        if (getChildAt(index) == null) {
            return null;
        }
        return (b) getChildAt(index);
    }

    public void b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            b bVarB = b(i);
            if (bVarB != null && bVarB.b) {
                bVarB.a(false);
            }
        }
    }

    public void c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            b bVarB = b(i);
            if (bVarB != null) {
                if (bVarB.b) {
                    bVarB.a(false);
                }
                bVarB.setClickable(false);
            }
        }
    }

    public void c(int position) {
        b bVarB = b(position);
        if (bVarB == null || !bVarB.b) {
            return;
        }
        bVarB.a(false);
    }

    public boolean d(int position) {
        b bVarB = b(position);
        return bVarB != null && bVarB.b;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new c(getContext(), attrs);
    }

    public ArrayList<Integer> getAllItemSelectedIndex() {
        int childCount = getChildCount();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            if (b(i).b) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    public ArrayList<String> getAllItemSelectedTextWithListArray() {
        int childCount = getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            b bVarB = b(i);
            if (bVarB.b) {
                arrayList.add(bVarB.getText().toString());
            }
        }
        return arrayList;
    }

    public String[] getAllItemSelectedTextWithStringArray() {
        int childCount = getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childCount; i++) {
            b bVarB = b(i);
            if (bVarB.b) {
                arrayList.add(bVarB.getText().toString());
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String[] getAllItemText() {
        int childCount = getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childCount; i++) {
            arrayList.add(b(i).getText().toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public int getSelectedIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (b(i).b) {
                return i;
            }
        }
        return -1;
    }

    protected b getSelectedItem() {
        int selectedIndex = getSelectedIndex();
        if (selectedIndex == -1) {
            return null;
        }
        return b(selectedIndex);
    }

    protected String getSelectedItemText() {
        b selectedItem = getSelectedItem();
        if (selectedItem == null) {
            return null;
        }
        return selectedItem.getText().toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b2) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = (r - l) - getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = getChildCount();
        int i = paddingLeft;
        int iMax = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                if (i + measuredWidth > paddingRight) {
                    paddingTop += iMax + this.q;
                    i = paddingLeft;
                    iMax = measuredHeight;
                } else {
                    iMax = Math.max(iMax, measuredHeight);
                }
                childAt.layout(i, paddingTop, i + measuredWidth, measuredHeight + paddingTop);
                i += measuredWidth + this.p;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                int i6 = i4 + measuredWidth;
                if (i6 > size) {
                    i += i2 + this.q;
                    i3++;
                } else {
                    measuredHeight = Math.max(i2, measuredHeight);
                    measuredWidth = i6;
                }
                i4 = measuredWidth + this.p;
                i2 = measuredHeight;
            }
        }
        int paddingTop = i + i2 + getPaddingTop() + getPaddingBottom();
        int paddingLeft = i3 == 0 ? i4 + getPaddingLeft() + getPaddingRight() : size;
        if (mode != 1073741824) {
            size = paddingLeft;
        }
        if (mode2 != 1073741824) {
            size2 = paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof d)) {
            super.onRestoreInstanceState(state);
            return;
        }
        d dVar = (d) state;
        super.onRestoreInstanceState(dVar.getSuperState());
        setList(dVar.b);
        b bVarB = b(dVar.c);
        if (bVarB == null) {
            return;
        }
        bVarB.a(true);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.b = getAllItemText();
        dVar.c = getSelectedIndex();
        return dVar;
    }

    public void setIndexListItemSelected(List<Integer> positionList) {
        if (positionList == null || positionList.isEmpty()) {
            return;
        }
        if (positionList.size() > getChildCount()) {
            return;
        }
        for (int i = 0; i < positionList.size(); i++) {
            b(i).a(true);
        }
    }

    public void setList(List<String> tagList) {
        setList((String[]) tagList.toArray(new String[0]));
    }

    public void setList(String... tags) {
        removeAllViews();
        for (String str : tags) {
            a((CharSequence) str);
        }
    }

    public void setOnItemClickListener(e l) {
        this.w = l;
    }
}
