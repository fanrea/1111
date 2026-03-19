package com.kwad.framework.filedownloader.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.utils.ax;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwad.framework.filedownloader.d.b.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b[] newArray(int i) {
            return dE(i);
        }

        private static b b(Parcel parcel) {
            return new b(parcel);
        }

        private static b[] dE(int i) {
            return new b[i];
        }
    };
    private HashMap<String, List<String>> bgy;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void D(String str, String str2) {
        ax.iA(str);
        ax.iA(str2);
        if (this.bgy == null) {
            this.bgy = new HashMap<>();
        }
        List<String> arrayList = this.bgy.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.bgy.put(str, arrayList);
        }
        if (arrayList.contains(str2)) {
            return;
        }
        arrayList.add(str2);
    }

    public final void cy(String str) {
        HashMap<String, List<String>> map = this.bgy;
        if (map == null) {
            return;
        }
        map.remove(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.bgy);
    }

    public final HashMap<String, List<String>> Ou() {
        return this.bgy;
    }

    public b() {
    }

    protected b(Parcel parcel) {
        this.bgy = parcel.readHashMap(String.class.getClassLoader());
    }

    public final String toString() {
        return this.bgy.toString();
    }
}
