package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class d extends DataSetObservable {
    static final String LOG_TAG = d.class.getSimpleName();

    /* renamed from: lk, reason: collision with root package name */
    private static final Object f709lk = new Object();
    private static final Map<String, d> ll = new HashMap();
    private final Object lm;
    private final List<a> ln;
    private final List<c> lo;
    final String lp;
    private b lq;
    private int lr;
    boolean ls;
    private boolean lt;
    private boolean lu;
    private boolean lv;
    private InterfaceC0018d lw;
    final Context mContext;
    private Intent mIntent;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public interface b {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    /* renamed from: android.support.v7.widget.d$d, reason: collision with other inner class name */
    public interface InterfaceC0018d {
        boolean cr();
    }

    public final int ci() {
        int size;
        synchronized (this.lm) {
            cl();
            size = this.ln.size();
        }
        return size;
    }

    public final ResolveInfo Q(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.lm) {
            cl();
            resolveInfo = this.ln.get(i).resolveInfo;
        }
        return resolveInfo;
    }

    public final int a(ResolveInfo resolveInfo) {
        synchronized (this.lm) {
            cl();
            List<a> list = this.ln;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public final Intent R(int i) {
        synchronized (this.lm) {
            if (this.mIntent == null) {
                return null;
            }
            cl();
            a aVar = this.ln.get(i);
            ComponentName componentName = new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.mIntent);
            intent.setComponent(componentName);
            if (this.lw != null) {
                new Intent(intent);
                if (this.lw.cr()) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final ResolveInfo cj() {
        synchronized (this.lm) {
            cl();
            if (this.ln.isEmpty()) {
                return null;
            }
            return this.ln.get(0).resolveInfo;
        }
    }

    public final void S(int i) {
        synchronized (this.lm) {
            cl();
            a aVar = this.ln.get(i);
            a aVar2 = this.ln.get(0);
            a(new c(new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.weight - aVar.weight) + 5.0f : 1.0f));
        }
    }

    private void ck() {
        if (!this.lt) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.lu) {
            this.lu = false;
            if (TextUtils.isEmpty(this.lp)) {
                return;
            }
            new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.lo), this.lp);
        }
    }

    private void cl() {
        boolean zCn = cn() | co();
        cp();
        if (zCn) {
            cm();
            notifyChanged();
        }
    }

    private boolean cm() {
        if (this.lq == null || this.mIntent == null || this.ln.isEmpty() || this.lo.isEmpty()) {
            return false;
        }
        Collections.unmodifiableList(this.lo);
        return true;
    }

    private boolean cn() {
        if (!this.lv || this.mIntent == null) {
            return false;
        }
        this.lv = false;
        this.ln.clear();
        List<ResolveInfo> listQueryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int size = listQueryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.ln.add(new a(listQueryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean co() throws IOException {
        if (!this.ls || !this.lu || TextUtils.isEmpty(this.lp)) {
            return false;
        }
        this.ls = false;
        this.lt = true;
        cq();
        return true;
    }

    private boolean a(c cVar) {
        boolean zAdd = this.lo.add(cVar);
        if (zAdd) {
            this.lu = true;
            cp();
            ck();
            cm();
            notifyChanged();
        }
        return zAdd;
    }

    private void cp() {
        int size = this.lo.size() - this.lr;
        if (size <= 0) {
            return;
        }
        this.lu = true;
        for (int i = 0; i < size; i++) {
            this.lo.remove(0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static final class c {
        public final ComponentName lx;
        public final long time;
        public final float weight;

        public c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public c(ComponentName componentName, long j, float f) {
            this.lx = componentName;
            this.time = j;
            this.weight = f;
        }

        public final int hashCode() {
            ComponentName componentName = this.lx;
            int iHashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.time;
            return ((((iHashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            ComponentName componentName = this.lx;
            if (componentName == null) {
                if (cVar.lx != null) {
                    return false;
                }
            } else if (!componentName.equals(cVar.lx)) {
                return false;
            }
            return this.time == cVar.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(cVar.weight);
        }

        public final String toString() {
            return "[; activity:" + this.lx + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + "]";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static final class a implements Comparable<a> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public a(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((a) obj).weight);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.weight) - Float.floatToIntBits(this.weight);
        }

        public final String toString() {
            return "[resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal(this.weight) + "]";
        }
    }

    private void cq() throws IOException {
        try {
            FileInputStream fileInputStreamOpenFileInput = this.mContext.openFileInput(this.lp);
            try {
                try {
                    try {
                        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                        xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, "UTF-8");
                        for (int next = 0; next != 1 && next != 2; next = xmlPullParserNewPullParser.next()) {
                        }
                        if (!"historical-records".equals(xmlPullParserNewPullParser.getName())) {
                            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                        }
                        List<c> list = this.lo;
                        list.clear();
                        while (true) {
                            int next2 = xmlPullParserNewPullParser.next();
                            if (next2 == 1) {
                                if (fileInputStreamOpenFileInput != null) {
                                    try {
                                        fileInputStreamOpenFileInput.close();
                                        return;
                                    } catch (IOException unused) {
                                        return;
                                    }
                                }
                                return;
                            }
                            if (next2 != 3 && next2 != 4) {
                                if (!"historical-record".equals(xmlPullParserNewPullParser.getName())) {
                                    throw new XmlPullParserException("Share records file not well-formed.");
                                }
                                list.add(new c(xmlPullParserNewPullParser.getAttributeValue(null, "activity"), Long.parseLong(xmlPullParserNewPullParser.getAttributeValue(null, "time")), Float.parseFloat(xmlPullParserNewPullParser.getAttributeValue(null, "weight"))));
                            }
                        }
                    } catch (IOException e2) {
                        Log.e(LOG_TAG, "Error reading historical recrod file: " + this.lp, e2);
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                } catch (XmlPullParserException e3) {
                    Log.e(LOG_TAG, "Error reading historical recrod file: " + this.lp, e3);
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException unused3) {
                        }
                    }
                }
            } catch (Throwable th) {
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    final class e extends AsyncTask<Object, Void, Void> {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Object... objArr) throws IOException {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = d.this.mContext.openFileOutput(str, 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    try {
                        try {
                            try {
                                xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                                xmlSerializerNewSerializer.startDocument("UTF-8", Boolean.TRUE);
                                xmlSerializerNewSerializer.startTag(null, "historical-records");
                                int size = list.size();
                                for (int i = 0; i < size; i++) {
                                    c cVar = (c) list.remove(0);
                                    xmlSerializerNewSerializer.startTag(null, "historical-record");
                                    xmlSerializerNewSerializer.attribute(null, "activity", cVar.lx.flattenToString());
                                    xmlSerializerNewSerializer.attribute(null, "time", String.valueOf(cVar.time));
                                    xmlSerializerNewSerializer.attribute(null, "weight", String.valueOf(cVar.weight));
                                    xmlSerializerNewSerializer.endTag(null, "historical-record");
                                }
                                xmlSerializerNewSerializer.endTag(null, "historical-records");
                                xmlSerializerNewSerializer.endDocument();
                                d.this.ls = true;
                            } catch (IllegalArgumentException e) {
                                Log.e(d.LOG_TAG, "Error writing historical record file: " + d.this.lp, e);
                                d.this.ls = true;
                                if (fileOutputStreamOpenFileOutput != null) {
                                }
                            }
                        } catch (IOException e2) {
                            Log.e(d.LOG_TAG, "Error writing historical record file: " + d.this.lp, e2);
                            d.this.ls = true;
                            if (fileOutputStreamOpenFileOutput != null) {
                            }
                        }
                    } catch (IllegalStateException e3) {
                        Log.e(d.LOG_TAG, "Error writing historical record file: " + d.this.lp, e3);
                        d.this.ls = true;
                        if (fileOutputStreamOpenFileOutput != null) {
                        }
                    }
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    d.this.ls = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                Log.e(d.LOG_TAG, "Error writing historical record file: " + str, e4);
                return null;
            }
        }
    }
}
