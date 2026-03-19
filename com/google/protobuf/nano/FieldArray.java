package com.google.protobuf.nano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class FieldArray implements Cloneable {
    private static final FieldData DELETED = new FieldData();
    private FieldData[] mData;
    private int[] mFieldNumbers;
    private boolean mGarbage;
    private int mSize;

    private int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    FieldArray() {
        this(10);
    }

    FieldArray(int i) {
        this.mGarbage = false;
        int iIdealIntArraySize = idealIntArraySize(i);
        this.mFieldNumbers = new int[iIdealIntArraySize];
        this.mData = new FieldData[iIdealIntArraySize];
        this.mSize = 0;
    }

    final FieldData get(int i) {
        int iBinarySearch = binarySearch(i);
        if (iBinarySearch < 0) {
            return null;
        }
        FieldData[] fieldDataArr = this.mData;
        if (fieldDataArr[iBinarySearch] == DELETED) {
            return null;
        }
        return fieldDataArr[iBinarySearch];
    }

    final void remove(int i) {
        int iBinarySearch = binarySearch(i);
        if (iBinarySearch >= 0) {
            FieldData[] fieldDataArr = this.mData;
            FieldData fieldData = fieldDataArr[iBinarySearch];
            FieldData fieldData2 = DELETED;
            if (fieldData != fieldData2) {
                fieldDataArr[iBinarySearch] = fieldData2;
                this.mGarbage = true;
            }
        }
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.mFieldNumbers;
        FieldData[] fieldDataArr = this.mData;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            FieldData fieldData = fieldDataArr[i3];
            if (fieldData != DELETED) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    fieldDataArr[i2] = fieldData;
                    fieldDataArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    final void put(int i, FieldData fieldData) {
        int iBinarySearch = binarySearch(i);
        if (iBinarySearch >= 0) {
            this.mData[iBinarySearch] = fieldData;
            return;
        }
        int iBinarySearch2 = iBinarySearch ^ (-1);
        if (iBinarySearch2 < this.mSize) {
            FieldData[] fieldDataArr = this.mData;
            if (fieldDataArr[iBinarySearch2] == DELETED) {
                this.mFieldNumbers[iBinarySearch2] = i;
                fieldDataArr[iBinarySearch2] = fieldData;
                return;
            }
        }
        if (this.mGarbage && this.mSize >= this.mFieldNumbers.length) {
            gc();
            iBinarySearch2 = binarySearch(i) ^ (-1);
        }
        int i2 = this.mSize;
        if (i2 >= this.mFieldNumbers.length) {
            int iIdealIntArraySize = idealIntArraySize(i2 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            FieldData[] fieldDataArr2 = new FieldData[iIdealIntArraySize];
            int[] iArr2 = this.mFieldNumbers;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            FieldData[] fieldDataArr3 = this.mData;
            System.arraycopy(fieldDataArr3, 0, fieldDataArr2, 0, fieldDataArr3.length);
            this.mFieldNumbers = iArr;
            this.mData = fieldDataArr2;
        }
        int i3 = this.mSize;
        if (i3 - iBinarySearch2 != 0) {
            int[] iArr3 = this.mFieldNumbers;
            int i4 = iBinarySearch2 + 1;
            System.arraycopy(iArr3, iBinarySearch2, iArr3, i4, i3 - iBinarySearch2);
            FieldData[] fieldDataArr4 = this.mData;
            System.arraycopy(fieldDataArr4, iBinarySearch2, fieldDataArr4, i4, this.mSize - iBinarySearch2);
        }
        this.mFieldNumbers[iBinarySearch2] = i;
        this.mData[iBinarySearch2] = fieldData;
        this.mSize++;
    }

    final int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    final FieldData dataAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.mData[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldArray)) {
            return false;
        }
        FieldArray fieldArray = (FieldArray) obj;
        return size() == fieldArray.size() && arrayEquals(this.mFieldNumbers, fieldArray.mFieldNumbers, this.mSize) && arrayEquals(this.mData, fieldArray.mData, this.mSize);
    }

    public final int hashCode() {
        if (this.mGarbage) {
            gc();
        }
        int iHashCode = 17;
        for (int i = 0; i < this.mSize; i++) {
            iHashCode = (((iHashCode * 31) + this.mFieldNumbers[i]) * 31) + this.mData[i].hashCode();
        }
        return iHashCode;
    }

    private int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    private int binarySearch(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.mFieldNumbers[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else {
                if (i5 <= i) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return i3 ^ (-1);
    }

    private boolean arrayEquals(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean arrayEquals(FieldData[] fieldDataArr, FieldData[] fieldDataArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!fieldDataArr[i2].equals(fieldDataArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final FieldArray m447clone() {
        int size = size();
        FieldArray fieldArray = new FieldArray(size);
        System.arraycopy(this.mFieldNumbers, 0, fieldArray.mFieldNumbers, 0, size);
        for (int i = 0; i < size; i++) {
            FieldData[] fieldDataArr = this.mData;
            if (fieldDataArr[i] != null) {
                fieldArray.mData[i] = fieldDataArr[i].m448clone();
            }
        }
        fieldArray.mSize = size;
        return fieldArray;
    }
}
