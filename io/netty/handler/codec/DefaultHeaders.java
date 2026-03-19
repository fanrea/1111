package io.netty.handler.codec;

import com.alipay.sdk.m.n.a;
import com.alipay.sdk.m.p0.b;
import io.netty.handler.codec.Headers;
import io.netty.util.HashingStrategy;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TimeZone;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class DefaultHeaders<K, V, T extends Headers<K, V, T>> implements Headers<K, V, T> {
    private static final int ARRAY_SIZE_HINT_MAX = Math.min(128, Math.max(1, SystemPropertyUtil.getInt("io.netty.DefaultHeaders.arraySizeHintMax", 16)));
    static final int HASH_CODE_SEED = -1028477387;
    private final HeaderEntry<K, V>[] entries;
    private final byte hashMask;
    private final HashingStrategy<K> hashingStrategy;
    protected final HeaderEntry<K, V> head;
    private final NameValidator<K> nameValidator;
    int size;
    private final ValueConverter<V> valueConverter;

    public interface NameValidator<K> {
        public static final NameValidator NOT_NULL = new NameValidator() { // from class: io.netty.handler.codec.DefaultHeaders.NameValidator.1
            @Override // io.netty.handler.codec.DefaultHeaders.NameValidator
            public final void validateName(Object obj) {
                ObjectUtil.checkNotNull(obj, "name");
            }
        };

        void validateName(K k);
    }

    private T thisT() {
        return this;
    }

    public DefaultHeaders(ValueConverter<V> valueConverter) {
        this(HashingStrategy.JAVA_HASHER, valueConverter);
    }

    public DefaultHeaders(ValueConverter<V> valueConverter, NameValidator<K> nameValidator) {
        this(HashingStrategy.JAVA_HASHER, valueConverter, nameValidator);
    }

    public DefaultHeaders(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter) {
        this(hashingStrategy, valueConverter, NameValidator.NOT_NULL);
    }

    public DefaultHeaders(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, NameValidator<K> nameValidator) {
        this(hashingStrategy, valueConverter, nameValidator, 16);
    }

    public DefaultHeaders(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, NameValidator<K> nameValidator, int i) {
        this.valueConverter = (ValueConverter) ObjectUtil.checkNotNull(valueConverter, "valueConverter");
        this.nameValidator = (NameValidator) ObjectUtil.checkNotNull(nameValidator, "nameValidator");
        this.hashingStrategy = (HashingStrategy) ObjectUtil.checkNotNull(hashingStrategy, "nameHashingStrategy");
        this.entries = new HeaderEntry[MathUtil.findNextPositivePowerOfTwo(Math.min(i, ARRAY_SIZE_HINT_MAX))];
        this.hashMask = (byte) (this.entries.length - 1);
        this.head = new HeaderEntry<>();
    }

    @Override // io.netty.handler.codec.Headers
    public V get(K k) {
        ObjectUtil.checkNotNull(k, "name");
        int iHashCode = this.hashingStrategy.hashCode(k);
        V v = null;
        for (HeaderEntry<K, V> headerEntry = this.entries[index(iHashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == iHashCode && this.hashingStrategy.equals(k, headerEntry.key)) {
                v = headerEntry.value;
            }
        }
        return v;
    }

    @Override // io.netty.handler.codec.Headers
    public V get(K k, V v) {
        V v2 = get(k);
        return v2 == null ? v : v2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.Headers
    public V getAndRemove(K k) {
        int iHashCode = this.hashingStrategy.hashCode(k);
        return (V) remove0(iHashCode, index(iHashCode), ObjectUtil.checkNotNull(k, "name"));
    }

    @Override // io.netty.handler.codec.Headers
    public V getAndRemove(K k, V v) {
        V andRemove = getAndRemove(k);
        return andRemove == null ? v : andRemove;
    }

    @Override // io.netty.handler.codec.Headers
    public List<V> getAll(K k) {
        ObjectUtil.checkNotNull(k, "name");
        LinkedList linkedList = new LinkedList();
        int iHashCode = this.hashingStrategy.hashCode(k);
        for (HeaderEntry<K, V> headerEntry = this.entries[index(iHashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == iHashCode && this.hashingStrategy.equals(k, headerEntry.key)) {
                linkedList.addFirst(headerEntry.getValue());
            }
        }
        return linkedList;
    }

    @Override // io.netty.handler.codec.Headers
    public List<V> getAllAndRemove(K k) {
        List<V> all = getAll(k);
        remove(k);
        return all;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean contains(K k) {
        return get(k) != null;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsObject(K k, Object obj) {
        return contains(k, this.valueConverter.convertObject(ObjectUtil.checkNotNull(obj, b.d)));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsBoolean(K k, boolean z) {
        return contains(k, this.valueConverter.convertBoolean(z));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsByte(K k, byte b) {
        return contains(k, this.valueConverter.convertByte(b));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsChar(K k, char c) {
        return contains(k, this.valueConverter.convertChar(c));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsShort(K k, short s) {
        return contains(k, this.valueConverter.convertShort(s));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsInt(K k, int i) {
        return contains(k, this.valueConverter.convertInt(i));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsLong(K k, long j) {
        return contains(k, this.valueConverter.convertLong(j));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsFloat(K k, float f) {
        return contains(k, this.valueConverter.convertFloat(f));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsDouble(K k, double d) {
        return contains(k, this.valueConverter.convertDouble(d));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean containsTimeMillis(K k, long j) {
        return contains(k, this.valueConverter.convertTimeMillis(j));
    }

    @Override // io.netty.handler.codec.Headers
    public boolean contains(K k, V v) {
        return contains(k, v, HashingStrategy.JAVA_HASHER);
    }

    public final boolean contains(K k, V v, HashingStrategy<? super V> hashingStrategy) {
        ObjectUtil.checkNotNull(k, "name");
        int iHashCode = this.hashingStrategy.hashCode(k);
        for (HeaderEntry<K, V> headerEntry = this.entries[index(iHashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == iHashCode && this.hashingStrategy.equals(k, headerEntry.key) && hashingStrategy.equals(v, headerEntry.value)) {
                return true;
            }
        }
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public int size() {
        return this.size;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean isEmpty() {
        HeaderEntry<K, V> headerEntry = this.head;
        return headerEntry == headerEntry.after;
    }

    @Override // io.netty.handler.codec.Headers
    public Set<K> names() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(size());
        for (HeaderEntry<K, V> headerEntry = this.head.after; headerEntry != this.head; headerEntry = headerEntry.after) {
            linkedHashSet.add(headerEntry.getKey());
        }
        return linkedHashSet;
    }

    @Override // io.netty.handler.codec.Headers
    public T add(K k, V v) {
        this.nameValidator.validateName(k);
        ObjectUtil.checkNotNull(v, b.d);
        int iHashCode = this.hashingStrategy.hashCode(k);
        add0(iHashCode, index(iHashCode), k, v);
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T add(K k, Iterable<? extends V> iterable) {
        this.nameValidator.validateName(k);
        int iHashCode = this.hashingStrategy.hashCode(k);
        int iIndex = index(iHashCode);
        Iterator<? extends V> it = iterable.iterator();
        while (it.hasNext()) {
            add0(iHashCode, iIndex, k, it.next());
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T add(K k, V... vArr) {
        this.nameValidator.validateName(k);
        int iHashCode = this.hashingStrategy.hashCode(k);
        int iIndex = index(iHashCode);
        for (V v : vArr) {
            add0(iHashCode, iIndex, k, v);
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k, Object obj) {
        return (T) add((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertObject(ObjectUtil.checkNotNull(obj, b.d)));
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k, Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            addObject((DefaultHeaders<K, V, T>) k, it.next());
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T addObject(K k, Object... objArr) {
        for (Object obj : objArr) {
            addObject((DefaultHeaders<K, V, T>) k, obj);
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T addInt(K k, int i) {
        return (T) add((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertInt(i));
    }

    @Override // io.netty.handler.codec.Headers
    public T addLong(K k, long j) {
        return (T) add((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertLong(j));
    }

    @Override // io.netty.handler.codec.Headers
    public T addDouble(K k, double d) {
        return (T) add((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertDouble(d));
    }

    @Override // io.netty.handler.codec.Headers
    public T addTimeMillis(K k, long j) {
        return (T) add((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertTimeMillis(j));
    }

    @Override // io.netty.handler.codec.Headers
    public T addChar(K k, char c) {
        return (T) add((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertChar(c));
    }

    @Override // io.netty.handler.codec.Headers
    public T addBoolean(K k, boolean z) {
        return (T) add((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertBoolean(z));
    }

    @Override // io.netty.handler.codec.Headers
    public T addFloat(K k, float f) {
        return (T) add((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertFloat(f));
    }

    @Override // io.netty.handler.codec.Headers
    public T addByte(K k, byte b) {
        return (T) add((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertByte(b));
    }

    @Override // io.netty.handler.codec.Headers
    public T addShort(K k, short s) {
        return (T) add((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertShort(s));
    }

    @Override // io.netty.handler.codec.Headers
    public T add(Headers<? extends K, ? extends V, ?> headers) {
        if (headers == this) {
            throw new IllegalArgumentException("can't add to itself.");
        }
        addImpl(headers);
        return (T) thisT();
    }

    protected void addImpl(Headers<? extends K, ? extends V, ?> headers) {
        if (headers instanceof DefaultHeaders) {
            DefaultHeaders defaultHeaders = (DefaultHeaders) headers;
            HeaderEntry<K, V> headerEntry = defaultHeaders.head.after;
            if (defaultHeaders.hashingStrategy == this.hashingStrategy && defaultHeaders.nameValidator == this.nameValidator) {
                while (headerEntry != defaultHeaders.head) {
                    add0(headerEntry.hash, index(headerEntry.hash), headerEntry.key, headerEntry.value);
                    headerEntry = headerEntry.after;
                }
                return;
            } else {
                while (headerEntry != defaultHeaders.head) {
                    add((DefaultHeaders<K, V, T>) headerEntry.key, (K) headerEntry.value);
                    headerEntry = headerEntry.after;
                }
                return;
            }
        }
        for (Map.Entry<? extends K, ? extends V> entry : headers) {
            add((DefaultHeaders<K, V, T>) entry.getKey(), (K) entry.getValue());
        }
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k, V v) {
        this.nameValidator.validateName(k);
        ObjectUtil.checkNotNull(v, b.d);
        int iHashCode = this.hashingStrategy.hashCode(k);
        int iIndex = index(iHashCode);
        remove0(iHashCode, iIndex, k);
        add0(iHashCode, iIndex, k, v);
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k, Iterable<? extends V> iterable) {
        V next;
        this.nameValidator.validateName(k);
        ObjectUtil.checkNotNull(iterable, "values");
        int iHashCode = this.hashingStrategy.hashCode(k);
        int iIndex = index(iHashCode);
        remove0(iHashCode, iIndex, k);
        Iterator<? extends V> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            add0(iHashCode, iIndex, k, next);
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T set(K k, V... vArr) {
        this.nameValidator.validateName(k);
        ObjectUtil.checkNotNull(vArr, "values");
        int iHashCode = this.hashingStrategy.hashCode(k);
        int iIndex = index(iHashCode);
        remove0(iHashCode, iIndex, k);
        for (V v : vArr) {
            if (v == null) {
                break;
            }
            add0(iHashCode, iIndex, k, v);
        }
        return (T) thisT();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.Headers
    public T setObject(K k, Object obj) {
        ObjectUtil.checkNotNull(obj, b.d);
        return (T) set((DefaultHeaders<K, V, T>) k, (K) ObjectUtil.checkNotNull(this.valueConverter.convertObject(obj), "convertedValue"));
    }

    @Override // io.netty.handler.codec.Headers
    public T setObject(K k, Iterable<?> iterable) {
        Object next;
        this.nameValidator.validateName(k);
        int iHashCode = this.hashingStrategy.hashCode(k);
        int iIndex = index(iHashCode);
        remove0(iHashCode, iIndex, k);
        Iterator<?> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            add0(iHashCode, iIndex, k, this.valueConverter.convertObject(next));
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T setObject(K k, Object... objArr) {
        this.nameValidator.validateName(k);
        int iHashCode = this.hashingStrategy.hashCode(k);
        int iIndex = index(iHashCode);
        remove0(iHashCode, iIndex, k);
        for (Object obj : objArr) {
            if (obj == null) {
                break;
            }
            add0(iHashCode, iIndex, k, this.valueConverter.convertObject(obj));
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T setInt(K k, int i) {
        return (T) set((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertInt(i));
    }

    @Override // io.netty.handler.codec.Headers
    public T setLong(K k, long j) {
        return (T) set((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertLong(j));
    }

    @Override // io.netty.handler.codec.Headers
    public T setDouble(K k, double d) {
        return (T) set((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertDouble(d));
    }

    @Override // io.netty.handler.codec.Headers
    public T setTimeMillis(K k, long j) {
        return (T) set((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertTimeMillis(j));
    }

    @Override // io.netty.handler.codec.Headers
    public T setFloat(K k, float f) {
        return (T) set((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertFloat(f));
    }

    @Override // io.netty.handler.codec.Headers
    public T setChar(K k, char c) {
        return (T) set((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertChar(c));
    }

    @Override // io.netty.handler.codec.Headers
    public T setBoolean(K k, boolean z) {
        return (T) set((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertBoolean(z));
    }

    @Override // io.netty.handler.codec.Headers
    public T setByte(K k, byte b) {
        return (T) set((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertByte(b));
    }

    @Override // io.netty.handler.codec.Headers
    public T setShort(K k, short s) {
        return (T) set((DefaultHeaders<K, V, T>) k, (K) this.valueConverter.convertShort(s));
    }

    @Override // io.netty.handler.codec.Headers
    public T set(Headers<? extends K, ? extends V, ?> headers) {
        if (headers != this) {
            clear();
            addImpl(headers);
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public T setAll(Headers<? extends K, ? extends V, ?> headers) {
        if (headers != this) {
            Iterator<? extends K> it = headers.names().iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            addImpl(headers);
        }
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers
    public boolean remove(K k) {
        return getAndRemove(k) != null;
    }

    @Override // io.netty.handler.codec.Headers
    public T clear() {
        Arrays.fill(this.entries, (Object) null);
        HeaderEntry<K, V> headerEntry = this.head;
        headerEntry.after = headerEntry;
        headerEntry.before = headerEntry;
        this.size = 0;
        return (T) thisT();
    }

    @Override // io.netty.handler.codec.Headers, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new HeaderIterator();
    }

    @Override // io.netty.handler.codec.Headers
    public Boolean getBoolean(K k) {
        V v = get(k);
        if (v != null) {
            return Boolean.valueOf(this.valueConverter.convertToBoolean(v));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean getBoolean(K k, boolean z) {
        Boolean bool = getBoolean(k);
        return bool != null ? bool.booleanValue() : z;
    }

    @Override // io.netty.handler.codec.Headers
    public Byte getByte(K k) {
        V v = get(k);
        if (v != null) {
            return Byte.valueOf(this.valueConverter.convertToByte(v));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public byte getByte(K k, byte b) {
        Byte b2 = getByte(k);
        return b2 != null ? b2.byteValue() : b;
    }

    @Override // io.netty.handler.codec.Headers
    public Character getChar(K k) {
        V v = get(k);
        if (v != null) {
            return Character.valueOf(this.valueConverter.convertToChar(v));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public char getChar(K k, char c) {
        Character ch = getChar(k);
        return ch != null ? ch.charValue() : c;
    }

    @Override // io.netty.handler.codec.Headers
    public Short getShort(K k) {
        V v = get(k);
        if (v != null) {
            return Short.valueOf(this.valueConverter.convertToShort(v));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public short getShort(K k, short s) {
        Short sh = getShort(k);
        return sh != null ? sh.shortValue() : s;
    }

    @Override // io.netty.handler.codec.Headers
    public Integer getInt(K k) {
        V v = get(k);
        if (v != null) {
            return Integer.valueOf(this.valueConverter.convertToInt(v));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public int getInt(K k, int i) {
        Integer num = getInt(k);
        return num != null ? num.intValue() : i;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getLong(K k) {
        V v = get(k);
        if (v != null) {
            return Long.valueOf(this.valueConverter.convertToLong(v));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public long getLong(K k, long j) {
        Long l = getLong(k);
        return l != null ? l.longValue() : j;
    }

    @Override // io.netty.handler.codec.Headers
    public Float getFloat(K k) {
        V v = get(k);
        if (v != null) {
            return Float.valueOf(this.valueConverter.convertToFloat(v));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public float getFloat(K k, float f) {
        Float f2 = getFloat(k);
        return f2 != null ? f2.floatValue() : f;
    }

    @Override // io.netty.handler.codec.Headers
    public Double getDouble(K k) {
        V v = get(k);
        if (v != null) {
            return Double.valueOf(this.valueConverter.convertToDouble(v));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public double getDouble(K k, double d) {
        Double d2 = getDouble(k);
        return d2 != null ? d2.doubleValue() : d;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getTimeMillis(K k) {
        V v = get(k);
        if (v != null) {
            return Long.valueOf(this.valueConverter.convertToTimeMillis(v));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public long getTimeMillis(K k, long j) {
        Long timeMillis = getTimeMillis(k);
        return timeMillis != null ? timeMillis.longValue() : j;
    }

    @Override // io.netty.handler.codec.Headers
    public Boolean getBooleanAndRemove(K k) {
        V andRemove = getAndRemove(k);
        if (andRemove != null) {
            return Boolean.valueOf(this.valueConverter.convertToBoolean(andRemove));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public boolean getBooleanAndRemove(K k, boolean z) {
        Boolean booleanAndRemove = getBooleanAndRemove(k);
        return booleanAndRemove != null ? booleanAndRemove.booleanValue() : z;
    }

    @Override // io.netty.handler.codec.Headers
    public Byte getByteAndRemove(K k) {
        V andRemove = getAndRemove(k);
        if (andRemove != null) {
            return Byte.valueOf(this.valueConverter.convertToByte(andRemove));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public byte getByteAndRemove(K k, byte b) {
        Byte byteAndRemove = getByteAndRemove(k);
        return byteAndRemove != null ? byteAndRemove.byteValue() : b;
    }

    @Override // io.netty.handler.codec.Headers
    public Character getCharAndRemove(K k) {
        V andRemove = getAndRemove(k);
        if (andRemove == null) {
            return null;
        }
        try {
            return Character.valueOf(this.valueConverter.convertToChar(andRemove));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // io.netty.handler.codec.Headers
    public char getCharAndRemove(K k, char c) {
        Character charAndRemove = getCharAndRemove(k);
        return charAndRemove != null ? charAndRemove.charValue() : c;
    }

    @Override // io.netty.handler.codec.Headers
    public Short getShortAndRemove(K k) {
        V andRemove = getAndRemove(k);
        if (andRemove != null) {
            return Short.valueOf(this.valueConverter.convertToShort(andRemove));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public short getShortAndRemove(K k, short s) {
        Short shortAndRemove = getShortAndRemove(k);
        return shortAndRemove != null ? shortAndRemove.shortValue() : s;
    }

    @Override // io.netty.handler.codec.Headers
    public Integer getIntAndRemove(K k) {
        V andRemove = getAndRemove(k);
        if (andRemove != null) {
            return Integer.valueOf(this.valueConverter.convertToInt(andRemove));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public int getIntAndRemove(K k, int i) {
        Integer intAndRemove = getIntAndRemove(k);
        return intAndRemove != null ? intAndRemove.intValue() : i;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getLongAndRemove(K k) {
        V andRemove = getAndRemove(k);
        if (andRemove != null) {
            return Long.valueOf(this.valueConverter.convertToLong(andRemove));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public long getLongAndRemove(K k, long j) {
        Long longAndRemove = getLongAndRemove(k);
        return longAndRemove != null ? longAndRemove.longValue() : j;
    }

    @Override // io.netty.handler.codec.Headers
    public Float getFloatAndRemove(K k) {
        V andRemove = getAndRemove(k);
        if (andRemove != null) {
            return Float.valueOf(this.valueConverter.convertToFloat(andRemove));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public float getFloatAndRemove(K k, float f) {
        Float floatAndRemove = getFloatAndRemove(k);
        return floatAndRemove != null ? floatAndRemove.floatValue() : f;
    }

    @Override // io.netty.handler.codec.Headers
    public Double getDoubleAndRemove(K k) {
        V andRemove = getAndRemove(k);
        if (andRemove != null) {
            return Double.valueOf(this.valueConverter.convertToDouble(andRemove));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public double getDoubleAndRemove(K k, double d) {
        Double doubleAndRemove = getDoubleAndRemove(k);
        return doubleAndRemove != null ? doubleAndRemove.doubleValue() : d;
    }

    @Override // io.netty.handler.codec.Headers
    public Long getTimeMillisAndRemove(K k) {
        V andRemove = getAndRemove(k);
        if (andRemove != null) {
            return Long.valueOf(this.valueConverter.convertToTimeMillis(andRemove));
        }
        return null;
    }

    @Override // io.netty.handler.codec.Headers
    public long getTimeMillisAndRemove(K k, long j) {
        Long timeMillisAndRemove = getTimeMillisAndRemove(k);
        return timeMillisAndRemove != null ? timeMillisAndRemove.longValue() : j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Headers) {
            return equals((Headers) obj, HashingStrategy.JAVA_HASHER);
        }
        return false;
    }

    public int hashCode() {
        return hashCode(HashingStrategy.JAVA_HASHER);
    }

    public final boolean equals(Headers<K, V, ?> headers, HashingStrategy<V> hashingStrategy) {
        if (headers.size() != size()) {
            return false;
        }
        if (this == headers) {
            return true;
        }
        for (K k : names()) {
            List<V> all = headers.getAll(k);
            List<V> all2 = getAll(k);
            if (all.size() != all2.size()) {
                return false;
            }
            for (int i = 0; i < all.size(); i++) {
                if (!hashingStrategy.equals(all.get(i), all2.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode(HashingStrategy<V> hashingStrategy) {
        int iHashCode = HASH_CODE_SEED;
        for (K k : names()) {
            iHashCode = (iHashCode * 31) + this.hashingStrategy.hashCode(k);
            List<V> all = getAll(k);
            for (int i = 0; i < all.size(); i++) {
                iHashCode = (iHashCode * 31) + hashingStrategy.hashCode(all.get(i));
            }
        }
        return iHashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append('[');
        String str = "";
        for (K k : names()) {
            List<V> all = getAll(k);
            for (int i = 0; i < all.size(); i++) {
                sb.append(str);
                sb.append(k);
                sb.append(": ");
                sb.append(all.get(i));
            }
            str = ", ";
        }
        sb.append(']');
        return sb.toString();
    }

    protected HeaderEntry<K, V> newHeaderEntry(int i, K k, V v, HeaderEntry<K, V> headerEntry) {
        return new HeaderEntry<>(i, k, v, headerEntry, this.head);
    }

    protected ValueConverter<V> valueConverter() {
        return this.valueConverter;
    }

    private int index(int i) {
        return i & this.hashMask;
    }

    private void add0(int i, int i2, K k, V v) {
        HeaderEntry<K, V>[] headerEntryArr = this.entries;
        headerEntryArr[i2] = newHeaderEntry(i, k, v, headerEntryArr[i2]);
        this.size++;
    }

    private V remove0(int i, int i2, K k) {
        HeaderEntry<K, V> headerEntry = this.entries[i2];
        V v = null;
        if (headerEntry == null) {
            return null;
        }
        for (HeaderEntry<K, V> headerEntry2 = headerEntry.next; headerEntry2 != null; headerEntry2 = headerEntry.next) {
            if (headerEntry2.hash == i && this.hashingStrategy.equals(k, headerEntry2.key)) {
                v = headerEntry2.value;
                headerEntry.next = headerEntry2.next;
                headerEntry2.remove();
                this.size--;
            } else {
                headerEntry = headerEntry2;
            }
        }
        HeaderEntry<K, V> headerEntry3 = this.entries[i2];
        if (headerEntry3.hash == i && this.hashingStrategy.equals(k, headerEntry3.key)) {
            if (v == null) {
                v = headerEntry3.value;
            }
            this.entries[i2] = headerEntry3.next;
            headerEntry3.remove();
            this.size--;
        }
        return v;
    }

    public static final class HeaderDateFormat {
        private static final FastThreadLocal<HeaderDateFormat> dateFormatThreadLocal = new FastThreadLocal<HeaderDateFormat>() { // from class: io.netty.handler.codec.DefaultHeaders.HeaderDateFormat.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public final HeaderDateFormat initialValue() {
                return new HeaderDateFormat();
            }
        };
        private final DateFormat dateFormat1;
        private final DateFormat dateFormat2;
        private final DateFormat dateFormat3;

        static HeaderDateFormat get() {
            return dateFormatThreadLocal.get();
        }

        private HeaderDateFormat() {
            this.dateFormat1 = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
            this.dateFormat2 = new SimpleDateFormat("E, dd-MMM-yy HH:mm:ss z", Locale.ENGLISH);
            this.dateFormat3 = new SimpleDateFormat("E MMM d HH:mm:ss yyyy", Locale.ENGLISH);
            TimeZone timeZone = TimeZone.getTimeZone("GMT");
            this.dateFormat1.setTimeZone(timeZone);
            this.dateFormat2.setTimeZone(timeZone);
            this.dateFormat3.setTimeZone(timeZone);
        }

        final long parse(String str) throws ParseException {
            Date date = this.dateFormat1.parse(str);
            if (date == null) {
                date = this.dateFormat2.parse(str);
            }
            if (date == null) {
                date = this.dateFormat3.parse(str);
            }
            if (date == null) {
                throw new ParseException(str, 0);
            }
            return date.getTime();
        }
    }

    final class HeaderIterator implements Iterator<Map.Entry<K, V>> {
        private HeaderEntry<K, V> current;

        private HeaderIterator() {
            this.current = DefaultHeaders.this.head;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.current.after != DefaultHeaders.this.head;
        }

        @Override // java.util.Iterator
        public final Map.Entry<K, V> next() {
            this.current = this.current.after;
            if (this.current == DefaultHeaders.this.head) {
                throw new NoSuchElementException();
            }
            return this.current;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("read-only iterator");
        }
    }

    protected static class HeaderEntry<K, V> implements Map.Entry<K, V> {
        protected HeaderEntry<K, V> after;
        protected HeaderEntry<K, V> before;
        protected final int hash;
        protected final K key;
        protected HeaderEntry<K, V> next;
        protected V value;

        protected HeaderEntry(int i, K k) {
            this.hash = i;
            this.key = k;
        }

        HeaderEntry(int i, K k, V v, HeaderEntry<K, V> headerEntry, HeaderEntry<K, V> headerEntry2) {
            this.hash = i;
            this.key = k;
            this.value = v;
            this.next = headerEntry;
            this.after = headerEntry2;
            this.before = headerEntry2.before;
            pointNeighborsToThis();
        }

        HeaderEntry() {
            this.hash = -1;
            this.key = null;
            this.after = this;
            this.before = this;
        }

        protected final void pointNeighborsToThis() {
            this.before.after = this;
            this.after.before = this;
        }

        public final HeaderEntry<K, V> before() {
            return this.before;
        }

        public final HeaderEntry<K, V> after() {
            return this.after;
        }

        protected void remove() {
            HeaderEntry<K, V> headerEntry = this.before;
            headerEntry.after = this.after;
            this.after.before = headerEntry;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            ObjectUtil.checkNotNull(v, b.d);
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public final String toString() {
            return this.key.toString() + a.h + this.value.toString();
        }
    }
}
