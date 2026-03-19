package io.netty.util.internal.chmv8;

import androidx.core.location.LocationRequestCompat;
import com.alipay.sdk.m.n.a;
import com.alipay.sdk.m.p0.b;
import com.kwai.video.player.KsMediaMeta;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ConcurrentHashMapV8<K, V> implements Serializable, ConcurrentMap<K, V> {
    private static final long ABASE;
    private static final int ASHIFT;
    private static final long BASECOUNT;
    private static final long CELLSBUSY;
    private static final long CELLVALUE;
    private static final int DEFAULT_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int HASH_BITS = Integer.MAX_VALUE;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int MIN_TRANSFER_STRIDE = 16;
    static final int MIN_TREEIFY_CAPACITY = 64;
    static final int MOVED = -1;
    static final int RESERVED = -3;
    static final int SEED_INCREMENT = 1640531527;
    private static final long SIZECTL;
    private static final long TRANSFERINDEX;
    private static final long TRANSFERORIGIN;
    static final int TREEBIN = -2;
    static final int TREEIFY_THRESHOLD = 8;
    private static final Unsafe U;
    static final int UNTREEIFY_THRESHOLD = 6;
    private static final long serialVersionUID = 7249069246763182397L;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;
    private volatile transient CounterCell[] counterCells;
    private transient EntrySetView<K, V> entrySet;
    private transient KeySetView<K, V> keySet;
    private volatile transient Node<K, V>[] nextTable;
    private volatile transient int sizeCtl;
    volatile transient Node<K, V>[] table;
    private volatile transient int transferIndex;
    private volatile transient int transferOrigin;
    private transient ValuesView<K, V> values;
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("segments", Segment[].class), new ObjectStreamField("segmentMask", Integer.TYPE), new ObjectStreamField("segmentShift", Integer.TYPE)};
    static final AtomicInteger counterHashCodeGenerator = new AtomicInteger();

    public interface Action<A> {
        void apply(A a);
    }

    public interface BiAction<A, B> {
        void apply(A a, B b);
    }

    public interface BiFun<A, B, T> {
        T apply(A a, B b);
    }

    public interface ConcurrentHashMapSpliterator<T> {
        long estimateSize();

        void forEachRemaining(Action<? super T> action);

        boolean tryAdvance(Action<? super T> action);

        ConcurrentHashMapSpliterator<T> trySplit();
    }

    public interface DoubleByDoubleToDouble {
        double apply(double d, double d2);
    }

    public interface Fun<A, T> {
        T apply(A a);
    }

    public interface IntByIntToInt {
        int apply(int i, int i2);
    }

    public interface LongByLongToLong {
        long apply(long j, long j2);
    }

    public interface ObjectByObjectToDouble<A, B> {
        double apply(A a, B b);
    }

    public interface ObjectByObjectToInt<A, B> {
        int apply(A a, B b);
    }

    public interface ObjectByObjectToLong<A, B> {
        long apply(A a, B b);
    }

    public interface ObjectToDouble<A> {
        double apply(A a);
    }

    public interface ObjectToInt<A> {
        int apply(A a);
    }

    public interface ObjectToLong<A> {
        long apply(A a);
    }

    static final int spread(int i) {
        return (i ^ (i >>> 16)) & Integer.MAX_VALUE;
    }

    private static final int tableSizeFor(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = i6 | (i6 >>> 16);
        if (i7 < 0) {
            return 1;
        }
        if (i7 >= 1073741824) {
            return 1073741824;
        }
        return i7 + 1;
    }

    static {
        try {
            U = getUnsafe();
            SIZECTL = U.objectFieldOffset(ConcurrentHashMapV8.class.getDeclaredField("sizeCtl"));
            TRANSFERINDEX = U.objectFieldOffset(ConcurrentHashMapV8.class.getDeclaredField("transferIndex"));
            TRANSFERORIGIN = U.objectFieldOffset(ConcurrentHashMapV8.class.getDeclaredField("transferOrigin"));
            BASECOUNT = U.objectFieldOffset(ConcurrentHashMapV8.class.getDeclaredField("baseCount"));
            CELLSBUSY = U.objectFieldOffset(ConcurrentHashMapV8.class.getDeclaredField("cellsBusy"));
            CELLVALUE = U.objectFieldOffset(CounterCell.class.getDeclaredField(b.d));
            ABASE = U.arrayBaseOffset(Node[].class);
            int iArrayIndexScale = U.arrayIndexScale(Node[].class);
            if (((iArrayIndexScale - 1) & iArrayIndexScale) != 0) {
                throw new Error("data type scale not a power of two");
            }
            ASHIFT = 31 - Integer.numberOfLeadingZeros(iArrayIndexScale);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        volatile Node<K, V> next;
        volatile V val;

        Node(int i, K k, V v, Node<K, V> node) {
            this.hash = i;
            this.key = k;
            this.val = v;
            this.next = node;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.val;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.key.hashCode() ^ this.val.hashCode();
        }

        public final String toString() {
            return this.key + "=" + this.val;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (value = entry.getValue()) == null) {
                return false;
            }
            K k = this.key;
            if (key != k && !key.equals(k)) {
                return false;
            }
            V v = this.val;
            return value == v || value.equals(v);
        }

        Node<K, V> find(int i, Object obj) {
            K k;
            if (obj == null) {
                return null;
            }
            Node<K, V> node = this;
            do {
                if (node.hash == i && ((k = node.key) == obj || (k != null && obj.equals(k)))) {
                    return node;
                }
                node = node.next;
            } while (node != null);
            return null;
        }
    }

    static Class<?> comparableClassFor(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls == String.class) {
            return cls;
        }
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null) {
            return null;
        }
        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                    return cls;
                }
            }
        }
        return null;
    }

    static int compareComparables(Class<?> cls, Object obj, Object obj2) {
        if (obj2 == null || obj2.getClass() != cls) {
            return 0;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    static final <K, V> Node<K, V> tabAt(Node<K, V>[] nodeArr, int i) {
        return (Node) U.getObjectVolatile(nodeArr, (i << ASHIFT) + ABASE);
    }

    static final <K, V> boolean casTabAt(Node<K, V>[] nodeArr, int i, Node<K, V> node, Node<K, V> node2) {
        return U.compareAndSwapObject(nodeArr, ABASE + (i << ASHIFT), node, node2);
    }

    static final <K, V> void setTabAt(Node<K, V>[] nodeArr, int i, Node<K, V> node) {
        U.putObjectVolatile(nodeArr, (i << ASHIFT) + ABASE, node);
    }

    public ConcurrentHashMapV8() {
    }

    public ConcurrentHashMapV8(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.sizeCtl = i >= 536870912 ? 1073741824 : tableSizeFor(i + (i >>> 1) + 1);
    }

    public ConcurrentHashMapV8(Map<? extends K, ? extends V> map) {
        this.sizeCtl = 16;
        putAll(map);
    }

    public ConcurrentHashMapV8(int i, float f) {
        this(i, f, 1);
    }

    public ConcurrentHashMapV8(int i, float f, int i2) {
        if (f <= 0.0f || i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        double d = (i < i2 ? i2 : i) / f;
        Double.isNaN(d);
        long j = (long) (d + 1.0d);
        this.sizeCtl = j >= 1073741824 ? 1073741824 : tableSizeFor((int) j);
    }

    @Override // java.util.Map
    public int size() {
        long jSumCount = sumCount();
        if (jSumCount < 0) {
            return 0;
        }
        if (jSumCount > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jSumCount;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return sumCount() <= 0;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        int length;
        Node<K, V> nodeTabAt;
        K k;
        int iSpread = spread(obj.hashCode());
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null && (length = nodeArr.length) > 0 && (nodeTabAt = tabAt(nodeArr, (length - 1) & iSpread)) != null) {
            int i = nodeTabAt.hash;
            if (i == iSpread) {
                K k2 = nodeTabAt.key;
                if (k2 == obj || (k2 != null && obj.equals(k2))) {
                    return nodeTabAt.val;
                }
            } else if (i < 0) {
                Node<K, V> nodeFind = nodeTabAt.find(iSpread, obj);
                if (nodeFind != null) {
                    return nodeFind.val;
                }
                return null;
            }
            while (true) {
                nodeTabAt = nodeTabAt.next;
                if (nodeTabAt == null) {
                    break;
                }
                if (nodeTabAt.hash == iSpread && ((k = nodeTabAt.key) == obj || (k != null && obj.equals(k)))) {
                    break;
                }
            }
            return nodeTabAt.val;
        }
        return null;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> nodeAdvance = traverser.advance();
                if (nodeAdvance == null) {
                    break;
                }
                V v = nodeAdvance.val;
                if (v == obj) {
                    return true;
                }
                if (v != null && obj.equals(v)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        return putVal(k, v, false);
    }

    final V putVal(K k, V v, boolean z) {
        V v2;
        K k2;
        if (k == null || v == null) {
            throw new NullPointerException();
        }
        int iSpread = spread(k.hashCode());
        int i = 0;
        Node<K, V>[] nodeArrInitTable = this.table;
        while (true) {
            if (nodeArrInitTable != null) {
                int length = nodeArrInitTable.length;
                if (length != 0) {
                    int i2 = (length - 1) & iSpread;
                    Node<K, V> nodeTabAt = tabAt(nodeArrInitTable, i2);
                    if (nodeTabAt == null) {
                        if (casTabAt(nodeArrInitTable, i2, null, new Node(iSpread, k, v, null))) {
                            break;
                        }
                    } else {
                        int i3 = nodeTabAt.hash;
                        if (i3 == -1) {
                            nodeArrInitTable = helpTransfer(nodeArrInitTable, nodeTabAt);
                        } else {
                            synchronized (nodeTabAt) {
                                if (tabAt(nodeArrInitTable, i2) == nodeTabAt) {
                                    if (i3 >= 0) {
                                        Node<K, V> node = nodeTabAt;
                                        int i4 = 1;
                                        while (true) {
                                            if (node.hash == iSpread && ((k2 = node.key) == k || (k2 != null && k.equals(k2)))) {
                                                break;
                                            }
                                            Node<K, V> node2 = node.next;
                                            if (node2 == null) {
                                                node.next = new Node<>(iSpread, k, v, null);
                                                v2 = null;
                                                break;
                                            }
                                            i4++;
                                            node = node2;
                                        }
                                        v2 = node.val;
                                        if (!z) {
                                            node.val = v;
                                        }
                                        i = i4;
                                    } else if (nodeTabAt instanceof TreeBin) {
                                        i = 2;
                                        TreeNode<K, V> treeNodePutTreeVal = ((TreeBin) nodeTabAt).putTreeVal(iSpread, k, v);
                                        if (treeNodePutTreeVal != null) {
                                            v2 = treeNodePutTreeVal.val;
                                            if (!z) {
                                                treeNodePutTreeVal.val = v;
                                            }
                                        }
                                    }
                                }
                                v2 = null;
                            }
                            if (i != 0) {
                                if (i >= 8) {
                                    treeifyBin(nodeArrInitTable, i2);
                                }
                                if (v2 != null) {
                                    return v2;
                                }
                            }
                        }
                    }
                }
            }
            nodeArrInitTable = initTable();
        }
        addCount(1L, i);
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        tryPresize(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            putVal(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return replaceNode(obj, null, null);
    }

    final V replaceNode(Object obj, V v, Object obj2) {
        int length;
        int i;
        Node<K, V> nodeTabAt;
        boolean z;
        V v2;
        TreeNode<K, V> treeNodeFindTreeNode;
        K k;
        int iSpread = spread(obj.hashCode());
        Node<K, V>[] nodeArrHelpTransfer = this.table;
        while (true) {
            if (nodeArrHelpTransfer == null || (length = nodeArrHelpTransfer.length) == 0 || (nodeTabAt = tabAt(nodeArrHelpTransfer, (i = (length - 1) & iSpread))) == null) {
                break;
            }
            int i2 = nodeTabAt.hash;
            if (i2 == -1) {
                nodeArrHelpTransfer = helpTransfer(nodeArrHelpTransfer, nodeTabAt);
            } else {
                synchronized (nodeTabAt) {
                    z = true;
                    if (tabAt(nodeArrHelpTransfer, i) == nodeTabAt) {
                        if (i2 >= 0) {
                            Node<K, V> node = null;
                            Node<K, V> node2 = nodeTabAt;
                            while (true) {
                                if (node2.hash == iSpread && ((k = node2.key) == obj || (k != null && obj.equals(k)))) {
                                    break;
                                }
                                Node<K, V> node3 = node2.next;
                                if (node3 == null) {
                                    break;
                                }
                                node = node2;
                                node2 = node3;
                            }
                            v2 = node2.val;
                            if (obj2 != null && obj2 != v2 && (v2 == null || !obj2.equals(v2))) {
                                v2 = null;
                            } else if (v != null) {
                                node2.val = v;
                            } else if (node != null) {
                                node.next = node2.next;
                            } else {
                                setTabAt(nodeArrHelpTransfer, i, node2.next);
                            }
                        } else if (nodeTabAt instanceof TreeBin) {
                            TreeBin treeBin = (TreeBin) nodeTabAt;
                            TreeNode<K, V> treeNode = treeBin.root;
                            if (treeNode != null && (treeNodeFindTreeNode = treeNode.findTreeNode(iSpread, obj, null)) != null) {
                                v2 = treeNodeFindTreeNode.val;
                                if (obj2 == null || obj2 == v2 || (v2 != null && obj2.equals(v2))) {
                                    if (v != null) {
                                        treeNodeFindTreeNode.val = v;
                                    } else if (treeBin.removeTreeNode(treeNodeFindTreeNode)) {
                                        setTabAt(nodeArrHelpTransfer, i, untreeify(treeBin.first));
                                    }
                                }
                            }
                            v2 = null;
                        }
                    }
                    v2 = null;
                    z = false;
                }
                if (z) {
                    if (v2 != null) {
                        if (v == null) {
                            addCount(-1L, -1);
                        }
                        return v2;
                    }
                }
            }
        }
        return null;
    }

    @Override // java.util.Map
    public void clear() {
        Node<K, V> nodeTabAt;
        Node<K, V> node;
        Node<K, V>[] nodeArrHelpTransfer = this.table;
        long j = 0;
        loop0: while (true) {
            int i = 0;
            while (nodeArrHelpTransfer != null && i < nodeArrHelpTransfer.length) {
                nodeTabAt = tabAt(nodeArrHelpTransfer, i);
                if (nodeTabAt == null) {
                    i++;
                } else {
                    int i2 = nodeTabAt.hash;
                    if (i2 == -1) {
                        break;
                    }
                    synchronized (nodeTabAt) {
                        if (tabAt(nodeArrHelpTransfer, i) == nodeTabAt) {
                            if (i2 >= 0) {
                                node = nodeTabAt;
                            } else {
                                node = nodeTabAt instanceof TreeBin ? ((TreeBin) nodeTabAt).first : null;
                            }
                            while (node != null) {
                                j--;
                                node = node.next;
                            }
                            setTabAt(nodeArrHelpTransfer, i, null);
                            i++;
                        }
                    }
                }
            }
            nodeArrHelpTransfer = helpTransfer(nodeArrHelpTransfer, nodeTabAt);
        }
        if (j != 0) {
            addCount(j, -1);
        }
    }

    @Override // java.util.Map
    public KeySetView<K, V> keySet() {
        KeySetView<K, V> keySetView = this.keySet;
        if (keySetView != null) {
            return keySetView;
        }
        KeySetView<K, V> keySetView2 = new KeySetView<>(this, null);
        this.keySet = keySetView2;
        return keySetView2;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        ValuesView<K, V> valuesView = this.values;
        if (valuesView != null) {
            return valuesView;
        }
        ValuesView<K, V> valuesView2 = new ValuesView<>(this);
        this.values = valuesView2;
        return valuesView2;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        EntrySetView<K, V> entrySetView = this.entrySet;
        if (entrySetView != null) {
            return entrySetView;
        }
        EntrySetView<K, V> entrySetView2 = new EntrySetView<>(this);
        this.entrySet = entrySetView2;
        return entrySetView2;
    }

    @Override // java.util.Map
    public int hashCode() {
        Node<K, V>[] nodeArr = this.table;
        int iHashCode = 0;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> nodeAdvance = traverser.advance();
                if (nodeAdvance == null) {
                    break;
                }
                iHashCode += nodeAdvance.val.hashCode() ^ nodeAdvance.key.hashCode();
            }
        }
        return iHashCode;
    }

    public String toString() {
        Node<K, V>[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        Traverser traverser = new Traverser(nodeArr, length, 0, length);
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Node<K, V> nodeAdvance = traverser.advance();
        if (nodeAdvance != null) {
            while (true) {
                Object obj = nodeAdvance.key;
                Object obj2 = nodeAdvance.val;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append(a.h);
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                nodeAdvance = traverser.advance();
                if (nodeAdvance == null) {
                    break;
                }
                sb.append(StringUtil.COMMA);
                sb.append(' ');
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        V value;
        V v;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        Node<K, V>[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        Traverser traverser = new Traverser(nodeArr, length, 0, length);
        while (true) {
            Node<K, V> nodeAdvance = traverser.advance();
            if (nodeAdvance != null) {
                V v2 = nodeAdvance.val;
                Object obj2 = map.get(nodeAdvance.key);
                if (obj2 == null || (obj2 != v2 && !obj2.equals(v2))) {
                    break;
                }
            } else {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    K key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (v = get(key)) == null || (value != v && !value.equals(v))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    static class Segment<K, V> extends ReentrantLock implements Serializable {
        private static final long serialVersionUID = 2249069246763182397L;
        final float loadFactor;

        Segment(float f) {
            this.loadFactor = f;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Segment[] segmentArr = new Segment[16];
        for (int i = 0; i < 16; i++) {
            segmentArr[i] = new Segment(0.75f);
        }
        objectOutputStream.putFields().put("segments", segmentArr);
        objectOutputStream.putFields().put("segmentShift", 28);
        objectOutputStream.putFields().put("segmentMask", 15);
        objectOutputStream.writeFields();
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> nodeAdvance = traverser.advance();
                if (nodeAdvance == null) {
                    break;
                }
                objectOutputStream.writeObject(nodeAdvance.key);
                objectOutputStream.writeObject(nodeAdvance.val);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        long j;
        int iTableSizeFor;
        boolean z;
        K k;
        long j2;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j3 = 0;
        long j4 = 0;
        Node<K, V> node = null;
        while (true) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            j = 1;
            if (object == null || object2 == null) {
                break;
            }
            j4++;
            node = new Node<>(spread(object.hashCode()), object, object2, node);
        }
        if (j4 == 0) {
            this.sizeCtl = 0;
            return;
        }
        if (j4 >= KsMediaMeta.AV_CH_STEREO_LEFT) {
            iTableSizeFor = 1073741824;
        } else {
            int i = (int) j4;
            iTableSizeFor = tableSizeFor(i + (i >>> 1) + 1);
        }
        Node<K, V>[] nodeArr = new Node[iTableSizeFor];
        int i2 = iTableSizeFor - 1;
        while (node != null) {
            Node<K, V> node2 = node.next;
            int i3 = node.hash;
            int i4 = i3 & i2;
            Node<K, V> nodeTabAt = tabAt(nodeArr, i4);
            if (nodeTabAt == null) {
                z = true;
            } else {
                K k2 = node.key;
                if (nodeTabAt.hash >= 0) {
                    int i5 = 0;
                    for (Node<K, V> node3 = nodeTabAt; node3 != null; node3 = node3.next) {
                        if (node3.hash == i3 && ((k = node3.key) == k2 || (k != null && k2.equals(k)))) {
                            z = false;
                            break;
                        }
                        i5++;
                    }
                    z = true;
                    if (z && i5 >= 8) {
                        j3++;
                        node.next = nodeTabAt;
                        Node<K, V> node4 = node;
                        TreeNode<K, V> treeNode = null;
                        TreeNode<K, V> treeNode2 = null;
                        while (node4 != null) {
                            long j5 = j3;
                            TreeNode<K, V> treeNode3 = new TreeNode<>(node4.hash, node4.key, node4.val, null, null);
                            treeNode3.prev = treeNode2;
                            if (treeNode2 == null) {
                                treeNode = treeNode3;
                            } else {
                                treeNode2.next = treeNode3;
                            }
                            node4 = node4.next;
                            treeNode2 = treeNode3;
                            j3 = j5;
                        }
                        setTabAt(nodeArr, i4, new TreeBin(treeNode));
                    }
                } else if (((TreeBin) nodeTabAt).putTreeVal(i3, k2, node.val) == null) {
                    j3 += j;
                }
                z = false;
            }
            if (z) {
                j2 = 1;
                j3++;
                node.next = nodeTabAt;
                setTabAt(nodeArr, i4, node);
            } else {
                j2 = 1;
            }
            j = j2;
            node = node2;
        }
        this.table = nodeArr;
        this.sizeCtl = iTableSizeFor - (iTableSizeFor >>> 2);
        this.baseCount = j3;
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V putIfAbsent(K k, V v) {
        return putVal(k, v, true);
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public boolean remove(Object obj, Object obj2) {
        if (obj != null) {
            return (obj2 == null || replaceNode(obj, null, obj2) == null) ? false : true;
        }
        throw new NullPointerException();
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public boolean replace(K k, V v, V v2) {
        if (k == null || v == null || v2 == null) {
            throw new NullPointerException();
        }
        return replaceNode(k, v2, v) != null;
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V replace(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException();
        }
        return replaceNode(k, v, null);
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V getOrDefault(Object obj, V v) {
        V v2 = get(obj);
        return v2 == null ? v : v2;
    }

    public void forEach(BiAction<? super K, ? super V> biAction) {
        if (biAction == null) {
            throw new NullPointerException();
        }
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr == null) {
            return;
        }
        Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
        while (true) {
            Node<K, V> nodeAdvance = traverser.advance();
            if (nodeAdvance == null) {
                return;
            } else {
                biAction.apply(nodeAdvance.key, nodeAdvance.val);
            }
        }
    }

    public void replaceAll(BiFun<? super K, ? super V, ? extends V> biFun) {
        if (biFun == null) {
            throw new NullPointerException();
        }
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr == null) {
            return;
        }
        Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
        while (true) {
            Node<K, V> nodeAdvance = traverser.advance();
            if (nodeAdvance == null) {
                return;
            }
            V v = nodeAdvance.val;
            K k = nodeAdvance.key;
            do {
                V vApply = biFun.apply(k, v);
                if (vApply == null) {
                    throw new NullPointerException();
                }
                if (replaceNode(k, vApply, v) == null) {
                    v = get(k);
                }
            } while (v != null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0073, code lost:
    
        r8 = false;
        r11 = r5;
        r5 = r4.val;
        r4 = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V computeIfAbsent(K r13, io.netty.util.internal.chmv8.ConcurrentHashMapV8.Fun<? super K, ? extends V> r14) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ConcurrentHashMapV8.computeIfAbsent(java.lang.Object, io.netty.util.internal.chmv8.ConcurrentHashMapV8$Fun):java.lang.Object");
    }

    public V computeIfPresent(K k, BiFun<? super K, ? super V, ? extends V> biFun) {
        TreeNode<K, V> treeNodeFindTreeNode;
        K k2;
        if (k == null || biFun == null) {
            throw new NullPointerException();
        }
        int iSpread = spread(k.hashCode());
        Node<K, V>[] nodeArrInitTable = this.table;
        int i = 0;
        V vApply = null;
        int i2 = 0;
        while (true) {
            if (nodeArrInitTable != null) {
                int length = nodeArrInitTable.length;
                if (length != 0) {
                    int i3 = (length - 1) & iSpread;
                    Node<K, V> nodeTabAt = tabAt(nodeArrInitTable, i3);
                    if (nodeTabAt != null) {
                        int i4 = nodeTabAt.hash;
                        if (i4 == -1) {
                            nodeArrInitTable = helpTransfer(nodeArrInitTable, nodeTabAt);
                        } else {
                            synchronized (nodeTabAt) {
                                if (tabAt(nodeArrInitTable, i3) == nodeTabAt) {
                                    if (i4 >= 0) {
                                        Node<K, V> node = null;
                                        Node<K, V> node2 = nodeTabAt;
                                        int i5 = 1;
                                        while (true) {
                                            if (node2.hash == iSpread && ((k2 = node2.key) == k || (k2 != null && k.equals(k2)))) {
                                                break;
                                            }
                                            Node<K, V> node3 = node2.next;
                                            if (node3 == null) {
                                                break;
                                            }
                                            i5++;
                                            node = node2;
                                            node2 = node3;
                                        }
                                        vApply = biFun.apply(k, node2.val);
                                        if (vApply != null) {
                                            node2.val = vApply;
                                        } else {
                                            Node<K, V> node4 = node2.next;
                                            if (node != null) {
                                                node.next = node4;
                                                i = -1;
                                            } else {
                                                setTabAt(nodeArrInitTable, i3, node4);
                                                i2 = i5;
                                                i = -1;
                                            }
                                        }
                                        i2 = i5;
                                    } else if (nodeTabAt instanceof TreeBin) {
                                        i2 = 2;
                                        TreeBin treeBin = (TreeBin) nodeTabAt;
                                        TreeNode<K, V> treeNode = treeBin.root;
                                        if (treeNode != null && (treeNodeFindTreeNode = treeNode.findTreeNode(iSpread, k, null)) != null) {
                                            vApply = biFun.apply(k, treeNodeFindTreeNode.val);
                                            if (vApply != null) {
                                                treeNodeFindTreeNode.val = vApply;
                                            } else {
                                                if (treeBin.removeTreeNode(treeNodeFindTreeNode)) {
                                                    setTabAt(nodeArrInitTable, i3, untreeify(treeBin.first));
                                                }
                                                i = -1;
                                            }
                                        }
                                    }
                                }
                            }
                            if (i2 != 0) {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
            nodeArrInitTable = initTable();
        }
        if (i != 0) {
            addCount(i, i2);
        }
        return vApply;
    }

    public V compute(K k, BiFun<? super K, ? super V, ? extends V> biFun) {
        int i;
        Node node;
        V vApply;
        K k2;
        if (k == null || biFun == null) {
            throw new NullPointerException();
        }
        int iSpread = spread(k.hashCode());
        Node<K, V>[] nodeArrInitTable = this.table;
        int i2 = 0;
        V v = null;
        int i3 = 0;
        while (true) {
            if (nodeArrInitTable != null) {
                int length = nodeArrInitTable.length;
                if (length != 0) {
                    int i4 = (length - 1) & iSpread;
                    Node<K, V> nodeTabAt = tabAt(nodeArrInitTable, i4);
                    if (nodeTabAt == null) {
                        ReservationNode reservationNode = new ReservationNode();
                        synchronized (reservationNode) {
                            if (casTabAt(nodeArrInitTable, i4, null, reservationNode)) {
                                try {
                                    V vApply2 = biFun.apply(k, null);
                                    if (vApply2 != null) {
                                        node = new Node(iSpread, k, vApply2, null);
                                        i = 1;
                                    } else {
                                        i = i3;
                                        node = null;
                                    }
                                    setTabAt(nodeArrInitTable, i4, node);
                                    i3 = i;
                                    v = vApply2;
                                    i2 = 1;
                                } finally {
                                }
                            }
                        }
                        if (i2 != 0) {
                            break;
                        }
                    } else {
                        int i5 = nodeTabAt.hash;
                        if (i5 == -1) {
                            nodeArrInitTable = helpTransfer(nodeArrInitTable, nodeTabAt);
                        } else {
                            synchronized (nodeTabAt) {
                                if (tabAt(nodeArrInitTable, i4) == nodeTabAt) {
                                    if (i5 >= 0) {
                                        Node<K, V> node2 = null;
                                        Node<K, V> node3 = nodeTabAt;
                                        int i6 = 1;
                                        while (true) {
                                            if (node3.hash == iSpread && ((k2 = node3.key) == k || (k2 != null && k.equals(k2)))) {
                                                break;
                                            }
                                            Node<K, V> node4 = node3.next;
                                            if (node4 == null) {
                                                V vApply3 = biFun.apply(k, null);
                                                if (vApply3 != null) {
                                                    node3.next = new Node<>(iSpread, k, vApply3, null);
                                                    i2 = i6;
                                                    v = vApply3;
                                                } else {
                                                    vApply = vApply3;
                                                }
                                            } else {
                                                i6++;
                                                node2 = node3;
                                                node3 = node4;
                                            }
                                        }
                                        vApply = biFun.apply(k, node3.val);
                                        if (vApply != null) {
                                            node3.val = vApply;
                                        } else {
                                            Node<K, V> node5 = node3.next;
                                            if (node2 != null) {
                                                node2.next = node5;
                                                i3 = -1;
                                            } else {
                                                setTabAt(nodeArrInitTable, i4, node5);
                                                i2 = i6;
                                                v = vApply;
                                                i3 = -1;
                                            }
                                        }
                                        i2 = i6;
                                        v = vApply;
                                    } else if (nodeTabAt instanceof TreeBin) {
                                        TreeBin treeBin = (TreeBin) nodeTabAt;
                                        TreeNode<K, V> treeNode = treeBin.root;
                                        TreeNode<K, V> treeNodeFindTreeNode = treeNode != null ? treeNode.findTreeNode(iSpread, k, null) : null;
                                        V vApply4 = biFun.apply(k, treeNodeFindTreeNode == null ? null : treeNodeFindTreeNode.val);
                                        if (vApply4 != null) {
                                            if (treeNodeFindTreeNode != null) {
                                                treeNodeFindTreeNode.val = vApply4;
                                            } else {
                                                treeBin.putTreeVal(iSpread, k, vApply4);
                                                v = vApply4;
                                                i2 = 1;
                                                i3 = 1;
                                            }
                                        } else if (treeNodeFindTreeNode != null) {
                                            if (treeBin.removeTreeNode(treeNodeFindTreeNode)) {
                                                setTabAt(nodeArrInitTable, i4, untreeify(treeBin.first));
                                            }
                                            v = vApply4;
                                            i2 = 1;
                                            i3 = -1;
                                        }
                                        v = vApply4;
                                        i2 = 1;
                                    }
                                }
                            }
                            if (i2 != 0) {
                                if (i2 >= 8) {
                                    treeifyBin(nodeArrInitTable, i4);
                                }
                            }
                        }
                    }
                }
            }
            nodeArrInitTable = initTable();
        }
        if (i3 != 0) {
            addCount(i3, i2);
        }
        return v;
    }

    public V merge(K k, V v, BiFun<? super V, ? super V, ? extends V> biFun) {
        int i;
        V vApply;
        K k2;
        if (k == null || v == null || biFun == null) {
            throw new NullPointerException();
        }
        int iSpread = spread(k.hashCode());
        Node<K, V>[] nodeArrInitTable = this.table;
        int i2 = 0;
        V v2 = null;
        int i3 = 0;
        while (true) {
            if (nodeArrInitTable != null) {
                int length = nodeArrInitTable.length;
                if (length != 0) {
                    int i4 = (length - 1) & iSpread;
                    Node<K, V> nodeTabAt = tabAt(nodeArrInitTable, i4);
                    i = 1;
                    if (nodeTabAt == null) {
                        if (casTabAt(nodeArrInitTable, i4, null, new Node(iSpread, k, v, null))) {
                            vApply = v;
                            break;
                        }
                    } else {
                        int i5 = nodeTabAt.hash;
                        if (i5 == -1) {
                            nodeArrInitTable = helpTransfer(nodeArrInitTable, nodeTabAt);
                        } else {
                            synchronized (nodeTabAt) {
                                if (tabAt(nodeArrInitTable, i4) == nodeTabAt) {
                                    if (i5 >= 0) {
                                        Node<K, V> node = null;
                                        Node<K, V> node2 = nodeTabAt;
                                        int i6 = 1;
                                        while (true) {
                                            if (node2.hash == iSpread && ((k2 = node2.key) == k || (k2 != null && k.equals(k2)))) {
                                                break;
                                            }
                                            Node<K, V> node3 = node2.next;
                                            if (node3 == null) {
                                                node2.next = new Node<>(iSpread, k, v, null);
                                                vApply = v;
                                                i2 = i6;
                                                break;
                                            }
                                            i6++;
                                            node = node2;
                                            node2 = node3;
                                        }
                                        V vApply2 = biFun.apply(node2.val, v);
                                        if (vApply2 != null) {
                                            node2.val = vApply2;
                                            i2 = i6;
                                            vApply = vApply2;
                                            i = i3;
                                        } else {
                                            Node<K, V> node4 = node2.next;
                                            if (node != null) {
                                                node.next = node4;
                                            } else {
                                                setTabAt(nodeArrInitTable, i4, node4);
                                            }
                                            i2 = i6;
                                            vApply = vApply2;
                                            i = -1;
                                        }
                                    } else if (nodeTabAt instanceof TreeBin) {
                                        i2 = 2;
                                        TreeBin treeBin = (TreeBin) nodeTabAt;
                                        TreeNode<K, V> treeNode = treeBin.root;
                                        TreeNode<K, V> treeNodeFindTreeNode = treeNode == null ? null : treeNode.findTreeNode(iSpread, k, null);
                                        vApply = treeNodeFindTreeNode == null ? v : biFun.apply(treeNodeFindTreeNode.val, v);
                                        if (vApply != null) {
                                            if (treeNodeFindTreeNode != null) {
                                                treeNodeFindTreeNode.val = vApply;
                                            } else {
                                                treeBin.putTreeVal(iSpread, k, vApply);
                                            }
                                        } else if (treeNodeFindTreeNode != null) {
                                            if (treeBin.removeTreeNode(treeNodeFindTreeNode)) {
                                                setTabAt(nodeArrInitTable, i4, untreeify(treeBin.first));
                                            }
                                            i = -1;
                                        }
                                        i = i3;
                                    }
                                }
                                i = i3;
                                vApply = v2;
                            }
                            if (i2 == 0) {
                                i3 = i;
                                v2 = vApply;
                            } else if (i2 >= 8) {
                                treeifyBin(nodeArrInitTable, i4);
                            }
                        }
                    }
                }
            }
            nodeArrInitTable = initTable();
        }
        if (i != 0) {
            addCount(i, i2);
        }
        return vApply;
    }

    @Deprecated
    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    public Enumeration<K> keys() {
        Node<K, V>[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        return new KeyIterator(nodeArr, length, 0, length, this);
    }

    public Enumeration<V> elements() {
        Node<K, V>[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        return new ValueIterator(nodeArr, length, 0, length, this);
    }

    public long mappingCount() {
        long jSumCount = sumCount();
        if (jSumCount < 0) {
            return 0L;
        }
        return jSumCount;
    }

    public static <K> KeySetView<K, Boolean> newKeySet() {
        return new KeySetView<>(new ConcurrentHashMapV8(), Boolean.TRUE);
    }

    public static <K> KeySetView<K, Boolean> newKeySet(int i) {
        return new KeySetView<>(new ConcurrentHashMapV8(i), Boolean.TRUE);
    }

    public KeySetView<K, V> keySet(V v) {
        if (v == null) {
            throw new NullPointerException();
        }
        return new KeySetView<>(this, v);
    }

    static final class ForwardingNode<K, V> extends Node<K, V> {
        final Node<K, V>[] nextTable;

        ForwardingNode(Node<K, V>[] nodeArr) {
            super(-1, null, null, null);
            this.nextTable = nodeArr;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.Node
        final Node<K, V> find(int i, Object obj) {
            int length;
            Node<K, V> nodeTabAt;
            K k;
            Node<K, V>[] nodeArr = this.nextTable;
            loop0: while (obj != null && nodeArr != null && (length = nodeArr.length) != 0 && (nodeTabAt = ConcurrentHashMapV8.tabAt(nodeArr, (length - 1) & i)) != null) {
                do {
                    int i2 = nodeTabAt.hash;
                    if (i2 == i && ((k = nodeTabAt.key) == obj || (k != null && obj.equals(k)))) {
                        return nodeTabAt;
                    }
                    if (i2 < 0) {
                        if (nodeTabAt instanceof ForwardingNode) {
                            nodeArr = ((ForwardingNode) nodeTabAt).nextTable;
                        } else {
                            return nodeTabAt.find(i, obj);
                        }
                    } else {
                        nodeTabAt = nodeTabAt.next;
                    }
                } while (nodeTabAt != null);
            }
            return null;
        }
    }

    static final class ReservationNode<K, V> extends Node<K, V> {
        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.Node
        final Node<K, V> find(int i, Object obj) {
            return null;
        }

        ReservationNode() {
            super(-3, null, null, null);
        }
    }

    private final Node<K, V>[] initTable() {
        while (true) {
            Node<K, V>[] nodeArr = this.table;
            if (nodeArr != null && nodeArr.length != 0) {
                return nodeArr;
            }
            int i = this.sizeCtl;
            if (i < 0) {
                Thread.yield();
            } else if (U.compareAndSwapInt(this, SIZECTL, i, -1)) {
                try {
                    Node<K, V>[] nodeArr2 = this.table;
                    if (nodeArr2 == null || nodeArr2.length == 0) {
                        int i2 = i > 0 ? i : 16;
                        Node<K, V>[] nodeArr3 = new Node[i2];
                        this.table = nodeArr3;
                        i = i2 - (i2 >>> 2);
                        nodeArr2 = nodeArr3;
                    }
                    this.sizeCtl = i;
                    return nodeArr2;
                } catch (Throwable th) {
                    this.sizeCtl = i;
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void addCount(long r20, int r22) {
        /*
            r19 = this;
            r8 = r19
            r9 = r22
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$CounterCell[] r10 = r8.counterCells
            if (r10 != 0) goto L19
            sun.misc.Unsafe r0 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.U
            long r2 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.BASECOUNT
            long r4 = r8.baseCount
            long r11 = r4 + r20
            r1 = r19
            r6 = r11
            boolean r0 = r0.compareAndSwapLong(r1, r2, r4, r6)
            if (r0 != 0) goto L49
        L19:
            io.netty.util.internal.InternalThreadLocalMap r1 = io.netty.util.internal.InternalThreadLocalMap.get()
            io.netty.util.internal.IntegerHolder r4 = r1.counterHashCode()
            r0 = 1
            if (r4 == 0) goto L93
            if (r10 == 0) goto L93
            int r2 = r10.length
            int r2 = r2 - r0
            if (r2 < 0) goto L93
            int r3 = r4.value
            r2 = r2 & r3
            r12 = r10[r2]
            if (r12 == 0) goto L93
            sun.misc.Unsafe r11 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.U
            long r13 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.CELLVALUE
            long r2 = r12.value
            long r17 = r2 + r20
            r15 = r2
            boolean r2 = r11.compareAndSwapLong(r12, r13, r15, r17)
            if (r2 != 0) goto L42
            r5 = r2
            goto L94
        L42:
            if (r9 > r0) goto L45
            return
        L45:
            long r11 = r19.sumCount()
        L49:
            if (r9 < 0) goto L92
        L4b:
            int r4 = r8.sizeCtl
            long r0 = (long) r4
            int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r2 < 0) goto L92
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node<K, V>[] r6 = r8.table
            if (r6 == 0) goto L92
            int r0 = r6.length
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 >= r1) goto L92
            if (r4 >= 0) goto L7c
            r0 = -1
            if (r4 == r0) goto L92
            int r0 = r8.transferIndex
            int r1 = r8.transferOrigin
            if (r0 <= r1) goto L92
            io.netty.util.internal.chmv8.ConcurrentHashMapV8$Node<K, V>[] r7 = r8.nextTable
            if (r7 == 0) goto L92
            sun.misc.Unsafe r0 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.U
            long r2 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.SIZECTL
            int r5 = r4 + (-1)
            r1 = r19
            boolean r0 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r0 == 0) goto L8d
            r8.transfer(r6, r7)
            goto L8d
        L7c:
            sun.misc.Unsafe r0 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.U
            long r2 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.SIZECTL
            r5 = -2
            r1 = r19
            boolean r0 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r0 == 0) goto L8d
            r0 = 0
            r8.transfer(r6, r0)
        L8d:
            long r11 = r19.sumCount()
            goto L4b
        L92:
            return
        L93:
            r5 = 1
        L94:
            r0 = r19
            r2 = r20
            r0.fullAddCount(r1, r2, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ConcurrentHashMapV8.addCount(long, int):void");
    }

    final Node<K, V>[] helpTransfer(Node<K, V>[] nodeArr, Node<K, V> node) {
        Node<K, V>[] nodeArr2;
        int i;
        if ((node instanceof ForwardingNode) && (nodeArr2 = ((ForwardingNode) node).nextTable) != null) {
            if (nodeArr2 == this.nextTable && nodeArr == this.table && this.transferIndex > this.transferOrigin && (i = this.sizeCtl) < -1 && U.compareAndSwapInt(this, SIZECTL, i, i - 1)) {
                transfer(nodeArr, nodeArr2);
            }
            return nodeArr2;
        }
        return this.table;
    }

    private final void tryPresize(int i) {
        int length;
        int iTableSizeFor = i >= 536870912 ? 1073741824 : tableSizeFor(i + (i >>> 1) + 1);
        while (true) {
            int i2 = this.sizeCtl;
            if (i2 < 0) {
                return;
            }
            Node<K, V>[] nodeArr = this.table;
            if (nodeArr == null || (length = nodeArr.length) == 0) {
                int i3 = i2 > iTableSizeFor ? i2 : iTableSizeFor;
                if (U.compareAndSwapInt(this, SIZECTL, i2, -1)) {
                    try {
                        if (this.table == nodeArr) {
                            this.table = new Node[i3];
                            i2 = i3 - (i3 >>> 2);
                        }
                    } finally {
                        this.sizeCtl = i2;
                    }
                } else {
                    continue;
                }
            } else {
                if (iTableSizeFor <= i2 || length >= 1073741824) {
                    return;
                }
                if (nodeArr == this.table && U.compareAndSwapInt(this, SIZECTL, i2, -2)) {
                    transfer(nodeArr, null);
                }
            }
        }
    }

    private final void transfer(Node<K, V>[] nodeArr, Node<K, V>[] nodeArr2) {
        Node<K, V>[] nodeArr3;
        int i;
        Unsafe unsafe;
        long j;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        ForwardingNode forwardingNode;
        Node treeBin;
        Node treeBin2;
        Node<K, V> node;
        Node<K, V> node2;
        ConcurrentHashMapV8<K, V> concurrentHashMapV8 = this;
        Node<K, V>[] nodeArr4 = nodeArr;
        int length = nodeArr4.length;
        int i7 = NCPU;
        int i8 = i7 > 1 ? (length >>> 3) / i7 : length;
        int i9 = i8 < 16 ? 16 : i8;
        if (nodeArr2 == null) {
            try {
                Node<K, V>[] nodeArr5 = new Node[length << 1];
                concurrentHashMapV8.nextTable = nodeArr5;
                concurrentHashMapV8.transferOrigin = length;
                concurrentHashMapV8.transferIndex = length;
                ForwardingNode forwardingNode2 = new ForwardingNode(nodeArr4);
                int i10 = length;
                while (i10 > 0) {
                    int i11 = i10 > i9 ? i10 - i9 : 0;
                    for (int i12 = i11; i12 < i10; i12++) {
                        nodeArr5[i12] = forwardingNode2;
                    }
                    for (int i13 = length + i11; i13 < length + i10; i13++) {
                        nodeArr5[i13] = forwardingNode2;
                    }
                    U.putOrderedInt(concurrentHashMapV8, TRANSFERORIGIN, i11);
                    i10 = i11;
                }
                nodeArr3 = nodeArr5;
            } catch (Throwable unused) {
                concurrentHashMapV8.sizeCtl = Integer.MAX_VALUE;
                return;
            }
        } else {
            nodeArr3 = nodeArr2;
        }
        int length2 = nodeArr3.length;
        ForwardingNode forwardingNode3 = new ForwardingNode(nodeArr3);
        int i14 = -1;
        int i15 = 0;
        int i16 = 0;
        boolean z = true;
        boolean z2 = false;
        while (true) {
            if (z) {
                int i17 = i15 - 1;
                if (i17 >= i16 || z2) {
                    i15 = i17;
                    i16 = i16;
                    z = false;
                } else {
                    int i18 = concurrentHashMapV8.transferIndex;
                    if (i18 <= concurrentHashMapV8.transferOrigin) {
                        i15 = -1;
                    } else {
                        Unsafe unsafe2 = U;
                        long j2 = TRANSFERINDEX;
                        int i19 = i18 > i9 ? i18 - i9 : 0;
                        i = i16;
                        if (unsafe2.compareAndSwapInt(this, j2, i18, i19)) {
                            i15 = i18 - 1;
                            i16 = i19;
                        } else {
                            i15 = i17;
                            i16 = i;
                        }
                    }
                    z = false;
                }
            } else {
                i = i16;
                Node<K, V> node3 = null;
                if (i15 < 0 || i15 >= length || (i4 = i15 + length) >= length2) {
                    int i20 = i9;
                    int i21 = length2;
                    ForwardingNode forwardingNode4 = forwardingNode3;
                    if (z2) {
                        this.nextTable = null;
                        this.table = nodeArr3;
                        this.sizeCtl = (length << 1) - (length >>> 1);
                        return;
                    }
                    do {
                        unsafe = U;
                        j = SIZECTL;
                        i2 = this.sizeCtl;
                        i3 = i2 + 1;
                    } while (!unsafe.compareAndSwapInt(this, j, i2, i3));
                    if (i3 != -1) {
                        return;
                    }
                    forwardingNode3 = forwardingNode4;
                    i15 = length;
                    concurrentHashMapV8 = this;
                    i16 = i;
                    i9 = i20;
                    length2 = i21;
                    i14 = -1;
                    z = true;
                    z2 = true;
                } else {
                    Node<K, V> nodeTabAt = tabAt(nodeArr4, i15);
                    if (nodeTabAt == null) {
                        if (casTabAt(nodeArr4, i15, null, forwardingNode3)) {
                            setTabAt(nodeArr3, i15, null);
                            setTabAt(nodeArr3, i4, null);
                        } else {
                            i16 = i;
                        }
                    } else {
                        int i22 = nodeTabAt.hash;
                        if (i22 != i14) {
                            synchronized (nodeTabAt) {
                                if (tabAt(nodeArr4, i15) == nodeTabAt) {
                                    if (i22 >= 0) {
                                        int i23 = i22 & length;
                                        Node<K, V> node4 = nodeTabAt;
                                        for (Node<K, V> node5 = nodeTabAt.next; node5 != null; node5 = node5.next) {
                                            int i24 = node5.hash & length;
                                            if (i24 != i23) {
                                                node4 = node5;
                                                i23 = i24;
                                            }
                                        }
                                        if (i23 == 0) {
                                            node = null;
                                            node3 = node4;
                                        } else {
                                            node = node4;
                                        }
                                        Node<K, V> node6 = node;
                                        Node<K, V> node7 = node3;
                                        Node<K, V> node8 = nodeTabAt;
                                        while (node8 != node4) {
                                            int i25 = node8.hash;
                                            K k = node8.key;
                                            int i26 = i9;
                                            V v = node8.val;
                                            if ((i25 & length) == 0) {
                                                node2 = node4;
                                                node7 = new Node<>(i25, k, v, node7);
                                            } else {
                                                node2 = node4;
                                                node6 = new Node<>(i25, k, v, node6);
                                            }
                                            node8 = node8.next;
                                            node4 = node2;
                                            i9 = i26;
                                        }
                                        i5 = i9;
                                        setTabAt(nodeArr3, i15, node7);
                                        setTabAt(nodeArr3, i4, node6);
                                        setTabAt(nodeArr4, i15, forwardingNode3);
                                        i6 = length2;
                                        forwardingNode = forwardingNode3;
                                    } else {
                                        i5 = i9;
                                        if (nodeTabAt instanceof TreeBin) {
                                            TreeBin treeBin3 = (TreeBin) nodeTabAt;
                                            Node node9 = treeBin3.first;
                                            TreeNode<K, V> treeNode = null;
                                            TreeNode<K, V> treeNode2 = null;
                                            TreeNode<K, V> treeNode3 = null;
                                            int i27 = 0;
                                            TreeNode<K, V> treeNode4 = null;
                                            int i28 = 0;
                                            while (node9 != null) {
                                                int i29 = length2;
                                                int i30 = node9.hash;
                                                ForwardingNode forwardingNode5 = forwardingNode3;
                                                TreeNode<K, V> treeNode5 = new TreeNode<>(i30, node9.key, node9.val, null, null);
                                                if ((i30 & length) == 0) {
                                                    treeNode5.prev = treeNode4;
                                                    if (treeNode4 == null) {
                                                        treeNode = treeNode5;
                                                    } else {
                                                        treeNode4.next = treeNode5;
                                                    }
                                                    i28++;
                                                    treeNode4 = treeNode5;
                                                } else {
                                                    treeNode5.prev = treeNode3;
                                                    if (treeNode3 == null) {
                                                        treeNode2 = treeNode5;
                                                    } else {
                                                        treeNode3.next = treeNode5;
                                                    }
                                                    i27++;
                                                    treeNode3 = treeNode5;
                                                }
                                                node9 = node9.next;
                                                length2 = i29;
                                                forwardingNode3 = forwardingNode5;
                                            }
                                            i6 = length2;
                                            ForwardingNode forwardingNode6 = forwardingNode3;
                                            if (i28 <= 6) {
                                                treeBin = untreeify(treeNode);
                                            } else {
                                                treeBin = i27 != 0 ? new TreeBin(treeNode) : treeBin3;
                                            }
                                            if (i27 <= 6) {
                                                treeBin2 = untreeify(treeNode2);
                                            } else {
                                                treeBin2 = i28 != 0 ? new TreeBin(treeNode2) : treeBin3;
                                            }
                                            setTabAt(nodeArr3, i15, treeBin);
                                            setTabAt(nodeArr3, i4, treeBin2);
                                            nodeArr4 = nodeArr;
                                            forwardingNode = forwardingNode6;
                                            setTabAt(nodeArr4, i15, forwardingNode);
                                        }
                                    }
                                    z = true;
                                } else {
                                    i5 = i9;
                                }
                                i6 = length2;
                                forwardingNode = forwardingNode3;
                            }
                            i14 = -1;
                            forwardingNode3 = forwardingNode;
                            i16 = i;
                            i9 = i5;
                            length2 = i6;
                            concurrentHashMapV8 = this;
                        }
                    }
                    i16 = i;
                    z = true;
                }
            }
        }
    }

    private final void treeifyBin(Node<K, V>[] nodeArr, int i) {
        int i2;
        if (nodeArr != null) {
            TreeNode<K, V> treeNode = null;
            if (nodeArr.length < 64) {
                if (nodeArr == this.table && (i2 = this.sizeCtl) >= 0 && U.compareAndSwapInt(this, SIZECTL, i2, -2)) {
                    transfer(nodeArr, null);
                    return;
                }
                return;
            }
            Node<K, V> nodeTabAt = tabAt(nodeArr, i);
            if (nodeTabAt == null || nodeTabAt.hash < 0) {
                return;
            }
            synchronized (nodeTabAt) {
                if (tabAt(nodeArr, i) == nodeTabAt) {
                    Node<K, V> node = nodeTabAt;
                    TreeNode<K, V> treeNode2 = null;
                    while (node != null) {
                        TreeNode<K, V> treeNode3 = new TreeNode<>(node.hash, node.key, node.val, null, null);
                        treeNode3.prev = treeNode2;
                        if (treeNode2 == null) {
                            treeNode = treeNode3;
                        } else {
                            treeNode2.next = treeNode3;
                        }
                        node = node.next;
                        treeNode2 = treeNode3;
                    }
                    setTabAt(nodeArr, i, new TreeBin(treeNode));
                }
            }
        }
    }

    static <K, V> Node<K, V> untreeify(Node<K, V> node) {
        Node<K, V> node2 = null;
        Node<K, V> node3 = null;
        while (node != null) {
            Node<K, V> node4 = new Node<>(node.hash, node.key, node.val, null);
            if (node3 == null) {
                node2 = node4;
            } else {
                node3.next = node4;
            }
            node = node.next;
            node3 = node4;
        }
        return node2;
    }

    static final class TreeNode<K, V> extends Node<K, V> {
        TreeNode<K, V> left;
        TreeNode<K, V> parent;
        TreeNode<K, V> prev;
        boolean red;
        TreeNode<K, V> right;

        TreeNode(int i, K k, V v, Node<K, V> node, TreeNode<K, V> treeNode) {
            super(i, k, v, node);
            this.parent = treeNode;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.Node
        final Node<K, V> find(int i, Object obj) {
            return findTreeNode(i, obj, null);
        }

        final TreeNode<K, V> findTreeNode(int i, Object obj, Class<?> cls) {
            int iCompareComparables;
            TreeNode<K, V> treeNodeFindTreeNode;
            if (obj == null) {
                return null;
            }
            Class<?> clsComparableClassFor = cls;
            TreeNode<K, V> treeNode = this;
            do {
                TreeNode<K, V> treeNode2 = treeNode.left;
                TreeNode<K, V> treeNode3 = treeNode.right;
                int i2 = treeNode.hash;
                if (i2 <= i) {
                    if (i2 >= i) {
                        K k = treeNode.key;
                        if (k == obj || (k != null && obj.equals(k))) {
                            return treeNode;
                        }
                        if (treeNode2 == null && treeNode3 == null) {
                            return null;
                        }
                        if ((clsComparableClassFor == null && (clsComparableClassFor = ConcurrentHashMapV8.comparableClassFor(obj)) == null) || (iCompareComparables = ConcurrentHashMapV8.compareComparables(clsComparableClassFor, obj, k)) == 0) {
                            if (treeNode2 != null) {
                                if (treeNode3 != null && (treeNodeFindTreeNode = treeNode3.findTreeNode(i, obj, clsComparableClassFor)) != null) {
                                    return treeNodeFindTreeNode;
                                }
                            }
                        } else if (iCompareComparables >= 0) {
                            treeNode2 = treeNode3;
                        }
                        treeNode = treeNode2;
                    }
                    treeNode = treeNode3;
                } else {
                    treeNode = treeNode2;
                }
            } while (treeNode != null);
            return null;
        }
    }

    static final class TreeBin<K, V> extends Node<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long LOCKSTATE;
        static final int READER = 4;
        private static final Unsafe U;
        static final int WAITER = 2;
        static final int WRITER = 1;
        volatile TreeNode<K, V> first;
        volatile int lockState;
        TreeNode<K, V> root;
        volatile Thread waiter;

        static {
            try {
                U = ConcurrentHashMapV8.getUnsafe();
                LOCKSTATE = U.objectFieldOffset(TreeBin.class.getDeclaredField("lockState"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        TreeBin(TreeNode<K, V> treeNode) {
            int iCompareComparables;
            super(-2, null, null, null);
            this.first = treeNode;
            TreeNode<K, V> treeNode2 = null;
            while (treeNode != null) {
                TreeNode<K, V> treeNode3 = (TreeNode) treeNode.next;
                treeNode.right = null;
                treeNode.left = null;
                if (treeNode2 == null) {
                    treeNode.parent = null;
                    treeNode.red = false;
                } else {
                    K k = treeNode.key;
                    int i = treeNode.hash;
                    Class<?> clsComparableClassFor = null;
                    TreeNode<K, V> treeNode4 = treeNode2;
                    while (true) {
                        int i2 = treeNode4.hash;
                        if (i2 > i) {
                            iCompareComparables = -1;
                        } else if (i2 < i) {
                            iCompareComparables = 1;
                        } else {
                            iCompareComparables = (clsComparableClassFor == null && (clsComparableClassFor = ConcurrentHashMapV8.comparableClassFor(k)) == null) ? 0 : ConcurrentHashMapV8.compareComparables(clsComparableClassFor, k, treeNode4.key);
                        }
                        TreeNode<K, V> treeNode5 = iCompareComparables <= 0 ? treeNode4.left : treeNode4.right;
                        if (treeNode5 == null) {
                            break;
                        } else {
                            treeNode4 = treeNode5;
                        }
                    }
                    treeNode.parent = treeNode4;
                    if (iCompareComparables <= 0) {
                        treeNode4.left = treeNode;
                    } else {
                        treeNode4.right = treeNode;
                    }
                    treeNode = balanceInsertion(treeNode2, treeNode);
                }
                treeNode2 = treeNode;
                treeNode = treeNode3;
            }
            this.root = treeNode2;
        }

        private final void lockRoot() {
            if (U.compareAndSwapInt(this, LOCKSTATE, 0, 1)) {
                return;
            }
            contendedLock();
        }

        private final void unlockRoot() {
            this.lockState = 0;
        }

        private final void contendedLock() {
            boolean z = false;
            while (true) {
                int i = this.lockState;
                if ((i & 1) == 0) {
                    if (U.compareAndSwapInt(this, LOCKSTATE, i, 1)) {
                        break;
                    }
                } else if ((i & 2) == 0) {
                    if (U.compareAndSwapInt(this, LOCKSTATE, i, i | 2)) {
                        this.waiter = Thread.currentThread();
                        z = true;
                    }
                } else if (z) {
                    LockSupport.park(this);
                }
            }
            if (z) {
                this.waiter = null;
            }
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.Node
        final Node<K, V> find(int i, Object obj) {
            Unsafe unsafe;
            long j;
            int i2;
            Thread thread;
            K k;
            TreeNode<K, V> treeNodeFindTreeNode = null;
            if (obj != null) {
                for (Node<K, V> node = this.first; node != null; node = node.next) {
                    int i3 = this.lockState;
                    if ((i3 & 3) != 0) {
                        if (node.hash == i && ((k = node.key) == obj || (k != null && obj.equals(k)))) {
                            return node;
                        }
                    } else if (U.compareAndSwapInt(this, LOCKSTATE, i3, i3 + 4)) {
                        try {
                            TreeNode<K, V> treeNode = this.root;
                            if (treeNode != null) {
                                treeNodeFindTreeNode = treeNode.findTreeNode(i, obj, null);
                            }
                            do {
                                unsafe = U;
                                j = LOCKSTATE;
                                i2 = this.lockState;
                            } while (!unsafe.compareAndSwapInt(this, j, i2, i2 - 4));
                            if (i2 == 6 && (thread = this.waiter) != null) {
                                LockSupport.unpark(thread);
                            }
                            return treeNodeFindTreeNode;
                        } finally {
                        }
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x0089, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0092, code lost:
        
            return r0;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x008f A[LOOP:0: B:3:0x0004->B:51:0x008f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x005a A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final io.netty.util.internal.chmv8.ConcurrentHashMapV8.TreeNode<K, V> putTreeVal(int r13, K r14, V r15) {
            /*
                r12 = this;
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V> r0 = r12.root
                r1 = 0
                r2 = r1
            L4:
                if (r0 != 0) goto L17
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode r0 = new io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode
                r7 = 0
                r8 = 0
                r3 = r0
                r4 = r13
                r5 = r14
                r6 = r15
                r3.<init>(r4, r5, r6, r7, r8)
                r12.root = r0
                r12.first = r0
                goto L89
            L17:
                int r3 = r0.hash
                r4 = -1
                r8 = 1
                if (r3 <= r13) goto L1f
            L1d:
                r9 = -1
                goto L51
            L1f:
                if (r3 >= r13) goto L23
            L21:
                r9 = 1
                goto L51
            L23:
                K r3 = r0.key
                if (r3 == r14) goto L92
                if (r3 == 0) goto L31
                boolean r5 = r14.equals(r3)
                if (r5 == 0) goto L31
                goto L92
            L31:
                if (r2 != 0) goto L39
                java.lang.Class r2 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.comparableClassFor(r14)
                if (r2 == 0) goto L3f
            L39:
                int r3 = io.netty.util.internal.chmv8.ConcurrentHashMapV8.compareComparables(r2, r14, r3)
                if (r3 != 0) goto L50
            L3f:
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V> r3 = r0.left
                if (r3 != 0) goto L44
                goto L21
            L44:
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V> r3 = r0.right
                if (r3 == 0) goto L1d
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode r3 = r3.findTreeNode(r13, r14, r2)
                if (r3 != 0) goto L4f
                goto L1d
            L4f:
                return r3
            L50:
                r9 = r3
            L51:
                if (r9 >= 0) goto L56
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V> r3 = r0.left
                goto L58
            L56:
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V> r3 = r0.right
            L58:
                if (r3 != 0) goto L8f
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V> r10 = r12.first
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode r11 = new io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode
                r2 = r11
                r3 = r13
                r4 = r14
                r5 = r15
                r6 = r10
                r7 = r0
                r2.<init>(r3, r4, r5, r6, r7)
                r12.first = r11
                if (r10 == 0) goto L6d
                r10.prev = r11
            L6d:
                if (r9 >= 0) goto L72
                r0.left = r11
                goto L74
            L72:
                r0.right = r11
            L74:
                boolean r13 = r0.red
                if (r13 != 0) goto L7b
                r11.red = r8
                goto L89
            L7b:
                r12.lockRoot()
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V> r13 = r12.root     // Catch: java.lang.Throwable -> L8a
                io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode r13 = balanceInsertion(r13, r11)     // Catch: java.lang.Throwable -> L8a
                r12.root = r13     // Catch: java.lang.Throwable -> L8a
                r12.unlockRoot()
            L89:
                return r1
            L8a:
                r13 = move-exception
                r12.unlockRoot()
                throw r13
            L8f:
                r0 = r3
                goto L4
            L92:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ConcurrentHashMapV8.TreeBin.putTreeVal(int, java.lang.Object, java.lang.Object):io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode");
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x008a A[PHI: r0
  0x008a: PHI (r0v4 io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V>) = 
  (r0v3 io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V>)
  (r0v12 io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode<K, V>)
 binds: [B:53:0x0086, B:49:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final boolean removeTreeNode(io.netty.util.internal.chmv8.ConcurrentHashMapV8.TreeNode<K, V> r10) {
            /*
                Method dump skipped, instructions count: 207
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ConcurrentHashMapV8.TreeBin.removeTreeNode(io.netty.util.internal.chmv8.ConcurrentHashMapV8$TreeNode):boolean");
        }

        static <K, V> TreeNode<K, V> rotateLeft(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            TreeNode<K, V> treeNode3;
            if (treeNode2 != null && (treeNode3 = treeNode2.right) != null) {
                TreeNode<K, V> treeNode4 = treeNode3.left;
                treeNode2.right = treeNode4;
                if (treeNode4 != null) {
                    treeNode4.parent = treeNode2;
                }
                TreeNode<K, V> treeNode5 = treeNode2.parent;
                treeNode3.parent = treeNode5;
                if (treeNode5 == null) {
                    treeNode3.red = false;
                    treeNode = treeNode3;
                } else if (treeNode5.left == treeNode2) {
                    treeNode5.left = treeNode3;
                } else {
                    treeNode5.right = treeNode3;
                }
                treeNode3.left = treeNode2;
                treeNode2.parent = treeNode3;
            }
            return treeNode;
        }

        static <K, V> TreeNode<K, V> rotateRight(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            TreeNode<K, V> treeNode3;
            if (treeNode2 != null && (treeNode3 = treeNode2.left) != null) {
                TreeNode<K, V> treeNode4 = treeNode3.right;
                treeNode2.left = treeNode4;
                if (treeNode4 != null) {
                    treeNode4.parent = treeNode2;
                }
                TreeNode<K, V> treeNode5 = treeNode2.parent;
                treeNode3.parent = treeNode5;
                if (treeNode5 == null) {
                    treeNode3.red = false;
                    treeNode = treeNode3;
                } else if (treeNode5.right == treeNode2) {
                    treeNode5.right = treeNode3;
                } else {
                    treeNode5.left = treeNode3;
                }
                treeNode3.right = treeNode2;
                treeNode2.parent = treeNode3;
            }
            return treeNode;
        }

        static <K, V> TreeNode<K, V> balanceInsertion(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            TreeNode<K, V> treeNode3;
            TreeNode<K, V> treeNode4;
            TreeNode<K, V> treeNode5;
            treeNode2.red = true;
            while (true) {
                TreeNode<K, V> treeNode6 = treeNode2.parent;
                if (treeNode6 == null) {
                    treeNode2.red = false;
                    return treeNode2;
                }
                if (!treeNode6.red || (treeNode3 = treeNode6.parent) == null) {
                    break;
                }
                TreeNode<K, V> treeNode7 = treeNode3.left;
                if (treeNode6 == treeNode7) {
                    TreeNode<K, V> treeNode8 = treeNode3.right;
                    if (treeNode8 != null && treeNode8.red) {
                        treeNode8.red = false;
                        treeNode6.red = false;
                        treeNode3.red = true;
                        treeNode2 = treeNode3;
                    } else {
                        if (treeNode2 == treeNode6.right) {
                            treeNode = rotateLeft(treeNode, treeNode6);
                            treeNode5 = treeNode6.parent;
                            treeNode3 = treeNode5 == null ? null : treeNode5.parent;
                        } else {
                            treeNode6 = treeNode2;
                            treeNode5 = treeNode6;
                        }
                        if (treeNode5 != null) {
                            treeNode5.red = false;
                            if (treeNode3 != null) {
                                treeNode3.red = true;
                                treeNode = rotateRight(treeNode, treeNode3);
                            }
                        }
                        treeNode2 = treeNode6;
                    }
                } else if (treeNode7 != null && treeNode7.red) {
                    treeNode7.red = false;
                    treeNode6.red = false;
                    treeNode3.red = true;
                    treeNode2 = treeNode3;
                } else {
                    if (treeNode2 == treeNode6.left) {
                        treeNode = rotateRight(treeNode, treeNode6);
                        treeNode4 = treeNode6.parent;
                        treeNode3 = treeNode4 == null ? null : treeNode4.parent;
                    } else {
                        treeNode6 = treeNode2;
                        treeNode4 = treeNode6;
                    }
                    if (treeNode4 != null) {
                        treeNode4.red = false;
                        if (treeNode3 != null) {
                            treeNode3.red = true;
                            treeNode = rotateLeft(treeNode, treeNode3);
                        }
                    }
                    treeNode2 = treeNode6;
                }
            }
            return treeNode;
        }

        static <K, V> TreeNode<K, V> balanceDeletion(TreeNode<K, V> treeNode, TreeNode<K, V> treeNode2) {
            while (treeNode2 != null && treeNode2 != treeNode) {
                TreeNode<K, V> treeNode3 = treeNode2.parent;
                if (treeNode3 == null) {
                    treeNode2.red = false;
                    return treeNode2;
                }
                if (treeNode2.red) {
                    treeNode2.red = false;
                    return treeNode;
                }
                TreeNode<K, V> treeNode4 = treeNode3.left;
                if (treeNode4 == treeNode2) {
                    TreeNode<K, V> treeNode5 = treeNode3.right;
                    if (treeNode5 != null && treeNode5.red) {
                        treeNode5.red = false;
                        treeNode3.red = true;
                        treeNode = rotateLeft(treeNode, treeNode3);
                        treeNode3 = treeNode2.parent;
                        treeNode5 = treeNode3 == null ? null : treeNode3.right;
                    }
                    if (treeNode5 != null) {
                        TreeNode<K, V> treeNode6 = treeNode5.left;
                        TreeNode<K, V> treeNode7 = treeNode5.right;
                        if ((treeNode7 == null || !treeNode7.red) && (treeNode6 == null || !treeNode6.red)) {
                            treeNode5.red = true;
                        } else {
                            if (treeNode7 == null || !treeNode7.red) {
                                if (treeNode6 != null) {
                                    treeNode6.red = false;
                                }
                                treeNode5.red = true;
                                treeNode = rotateRight(treeNode, treeNode5);
                                treeNode3 = treeNode2.parent;
                                treeNode5 = treeNode3 != null ? treeNode3.right : null;
                            }
                            if (treeNode5 != null) {
                                treeNode5.red = treeNode3 == null ? false : treeNode3.red;
                                TreeNode<K, V> treeNode8 = treeNode5.right;
                                if (treeNode8 != null) {
                                    treeNode8.red = false;
                                }
                            }
                            if (treeNode3 != null) {
                                treeNode3.red = false;
                                treeNode = rotateLeft(treeNode, treeNode3);
                            }
                            treeNode2 = treeNode;
                        }
                    }
                    treeNode2 = treeNode3;
                } else {
                    if (treeNode4 != null && treeNode4.red) {
                        treeNode4.red = false;
                        treeNode3.red = true;
                        treeNode = rotateRight(treeNode, treeNode3);
                        treeNode3 = treeNode2.parent;
                        treeNode4 = treeNode3 == null ? null : treeNode3.left;
                    }
                    if (treeNode4 != null) {
                        TreeNode<K, V> treeNode9 = treeNode4.left;
                        TreeNode<K, V> treeNode10 = treeNode4.right;
                        if ((treeNode9 == null || !treeNode9.red) && (treeNode10 == null || !treeNode10.red)) {
                            treeNode4.red = true;
                        } else {
                            if (treeNode9 == null || !treeNode9.red) {
                                if (treeNode10 != null) {
                                    treeNode10.red = false;
                                }
                                treeNode4.red = true;
                                treeNode = rotateLeft(treeNode, treeNode4);
                                treeNode3 = treeNode2.parent;
                                treeNode4 = treeNode3 != null ? treeNode3.left : null;
                            }
                            if (treeNode4 != null) {
                                treeNode4.red = treeNode3 == null ? false : treeNode3.red;
                                TreeNode<K, V> treeNode11 = treeNode4.left;
                                if (treeNode11 != null) {
                                    treeNode11.red = false;
                                }
                            }
                            if (treeNode3 != null) {
                                treeNode3.red = false;
                                treeNode = rotateRight(treeNode, treeNode3);
                            }
                            treeNode2 = treeNode;
                        }
                    }
                    treeNode2 = treeNode3;
                }
            }
            return treeNode;
        }

        static <K, V> boolean checkInvariants(TreeNode<K, V> treeNode) {
            TreeNode<K, V> treeNode2 = treeNode.parent;
            TreeNode<K, V> treeNode3 = treeNode.left;
            TreeNode<K, V> treeNode4 = treeNode.right;
            TreeNode<K, V> treeNode5 = treeNode.prev;
            TreeNode treeNode6 = (TreeNode) treeNode.next;
            if (treeNode5 != null && treeNode5.next != treeNode) {
                return false;
            }
            if (treeNode6 != null && treeNode6.prev != treeNode) {
                return false;
            }
            if (treeNode2 != null && treeNode != treeNode2.left && treeNode != treeNode2.right) {
                return false;
            }
            if (treeNode3 != null && (treeNode3.parent != treeNode || treeNode3.hash > treeNode.hash)) {
                return false;
            }
            if (treeNode4 != null && (treeNode4.parent != treeNode || treeNode4.hash < treeNode.hash)) {
                return false;
            }
            if (treeNode.red && treeNode3 != null && treeNode3.red && treeNode4 != null && treeNode4.red) {
                return false;
            }
            if (treeNode3 == null || checkInvariants(treeNode3)) {
                return treeNode4 == null || checkInvariants(treeNode4);
            }
            return false;
        }
    }

    static class Traverser<K, V> {
        int baseIndex;
        int baseLimit;
        final int baseSize;
        int index;
        Node<K, V> next = null;
        Node<K, V>[] tab;

        Traverser(Node<K, V>[] nodeArr, int i, int i2, int i3) {
            this.tab = nodeArr;
            this.baseSize = i;
            this.index = i2;
            this.baseIndex = i2;
            this.baseLimit = i3;
        }

        final Node<K, V> advance() {
            Node<K, V>[] nodeArr;
            int length;
            int i;
            Node<K, V> nodeTabAt = this.next;
            if (nodeTabAt != null) {
                nodeTabAt = nodeTabAt.next;
            }
            while (nodeTabAt == null) {
                if (this.baseIndex >= this.baseLimit || (nodeArr = this.tab) == null || (length = nodeArr.length) <= (i = this.index) || i < 0) {
                    this.next = null;
                    return null;
                }
                nodeTabAt = ConcurrentHashMapV8.tabAt(nodeArr, i);
                if (nodeTabAt != null && nodeTabAt.hash < 0) {
                    if (nodeTabAt instanceof ForwardingNode) {
                        this.tab = ((ForwardingNode) nodeTabAt).nextTable;
                        nodeTabAt = null;
                    } else {
                        nodeTabAt = nodeTabAt instanceof TreeBin ? ((TreeBin) nodeTabAt).first : null;
                    }
                }
                int i2 = this.index + this.baseSize;
                this.index = i2;
                if (i2 >= length) {
                    int i3 = this.baseIndex + 1;
                    this.baseIndex = i3;
                    this.index = i3;
                }
            }
            this.next = nodeTabAt;
            return nodeTabAt;
        }
    }

    static class BaseIterator<K, V> extends Traverser<K, V> {
        Node<K, V> lastReturned;
        final ConcurrentHashMapV8<K, V> map;

        BaseIterator(Node<K, V>[] nodeArr, int i, int i2, int i3, ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            super(nodeArr, i, i2, i3);
            this.map = concurrentHashMapV8;
            advance();
        }

        public final boolean hasNext() {
            return this.next != null;
        }

        public final boolean hasMoreElements() {
            return this.next != null;
        }

        public final void remove() {
            Node<K, V> node = this.lastReturned;
            if (node == null) {
                throw new IllegalStateException();
            }
            this.lastReturned = null;
            this.map.replaceNode(node.key, null, null);
        }
    }

    static final class KeyIterator<K, V> extends BaseIterator<K, V> implements Enumeration<K>, Iterator<K> {
        KeyIterator(Node<K, V>[] nodeArr, int i, int i2, int i3, ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            super(nodeArr, i, i2, i3, concurrentHashMapV8);
        }

        @Override // java.util.Iterator
        public final K next() {
            Node<K, V> node = this.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            K k = node.key;
            this.lastReturned = node;
            advance();
            return k;
        }

        @Override // java.util.Enumeration
        public final K nextElement() {
            return next();
        }
    }

    static final class ValueIterator<K, V> extends BaseIterator<K, V> implements Enumeration<V>, Iterator<V> {
        ValueIterator(Node<K, V>[] nodeArr, int i, int i2, int i3, ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            super(nodeArr, i, i2, i3, concurrentHashMapV8);
        }

        @Override // java.util.Iterator
        public final V next() {
            Node<K, V> node = this.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            V v = node.val;
            this.lastReturned = node;
            advance();
            return v;
        }

        @Override // java.util.Enumeration
        public final V nextElement() {
            return next();
        }
    }

    static final class EntryIterator<K, V> extends BaseIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        EntryIterator(Node<K, V>[] nodeArr, int i, int i2, int i3, ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            super(nodeArr, i, i2, i3, concurrentHashMapV8);
        }

        @Override // java.util.Iterator
        public final Map.Entry<K, V> next() {
            Node<K, V> node = this.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            K k = node.key;
            V v = node.val;
            this.lastReturned = node;
            advance();
            return new MapEntry(k, v, this.map);
        }
    }

    static final class MapEntry<K, V> implements Map.Entry<K, V> {
        final K key;
        final ConcurrentHashMapV8<K, V> map;
        V val;

        MapEntry(K k, V v, ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            this.key = k;
            this.val = v;
            this.map = concurrentHashMapV8;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.val;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.key.hashCode() ^ this.val.hashCode();
        }

        public final String toString() {
            return this.key + "=" + this.val;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (value = entry.getValue()) == null) {
                return false;
            }
            K k = this.key;
            if (key != k && !key.equals(k)) {
                return false;
            }
            V v = this.val;
            return value == v || value.equals(v);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            if (v == null) {
                throw new NullPointerException();
            }
            V v2 = this.val;
            this.val = v;
            this.map.put(this.key, v);
            return v2;
        }
    }

    static final class KeySpliterator<K, V> extends Traverser<K, V> implements ConcurrentHashMapSpliterator<K> {
        long est;

        KeySpliterator(Node<K, V>[] nodeArr, int i, int i2, int i3, long j) {
            super(nodeArr, i, i2, i3);
            this.est = j;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public final ConcurrentHashMapSpliterator<K> trySplit() {
            int i = this.baseIndex;
            int i2 = this.baseLimit;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            Node<K, V>[] nodeArr = this.tab;
            int i4 = this.baseSize;
            this.baseLimit = i3;
            long j = this.est >>> 1;
            this.est = j;
            return new KeySpliterator(nodeArr, i4, i3, i2, j);
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public final void forEachRemaining(Action<? super K> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    return;
                } else {
                    action.apply(nodeAdvance.key);
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public final boolean tryAdvance(Action<? super K> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V> nodeAdvance = advance();
            if (nodeAdvance == null) {
                return false;
            }
            action.apply(nodeAdvance.key);
            return true;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public final long estimateSize() {
            return this.est;
        }
    }

    static final class ValueSpliterator<K, V> extends Traverser<K, V> implements ConcurrentHashMapSpliterator<V> {
        long est;

        ValueSpliterator(Node<K, V>[] nodeArr, int i, int i2, int i3, long j) {
            super(nodeArr, i, i2, i3);
            this.est = j;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public final ConcurrentHashMapSpliterator<V> trySplit() {
            int i = this.baseIndex;
            int i2 = this.baseLimit;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            Node<K, V>[] nodeArr = this.tab;
            int i4 = this.baseSize;
            this.baseLimit = i3;
            long j = this.est >>> 1;
            this.est = j;
            return new ValueSpliterator(nodeArr, i4, i3, i2, j);
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public final void forEachRemaining(Action<? super V> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    return;
                } else {
                    action.apply(nodeAdvance.val);
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public final boolean tryAdvance(Action<? super V> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V> nodeAdvance = advance();
            if (nodeAdvance == null) {
                return false;
            }
            action.apply(nodeAdvance.val);
            return true;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public final long estimateSize() {
            return this.est;
        }
    }

    static final class EntrySpliterator<K, V> extends Traverser<K, V> implements ConcurrentHashMapSpliterator<Map.Entry<K, V>> {
        long est;
        final ConcurrentHashMapV8<K, V> map;

        EntrySpliterator(Node<K, V>[] nodeArr, int i, int i2, int i3, long j, ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            super(nodeArr, i, i2, i3);
            this.map = concurrentHashMapV8;
            this.est = j;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public final ConcurrentHashMapSpliterator<Map.Entry<K, V>> trySplit() {
            int i = this.baseIndex;
            int i2 = this.baseLimit;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            Node<K, V>[] nodeArr = this.tab;
            int i4 = this.baseSize;
            this.baseLimit = i3;
            long j = this.est >>> 1;
            this.est = j;
            return new EntrySpliterator(nodeArr, i4, i3, i2, j, this.map);
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public final void forEachRemaining(Action<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    return;
                } else {
                    action.apply(new MapEntry(nodeAdvance.key, nodeAdvance.val, this.map));
                }
            }
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public final boolean tryAdvance(Action<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V> nodeAdvance = advance();
            if (nodeAdvance == null) {
                return false;
            }
            action.apply(new MapEntry(nodeAdvance.key, nodeAdvance.val, this.map));
            return true;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.ConcurrentHashMapSpliterator
        public final long estimateSize() {
            return this.est;
        }
    }

    final int batchFor(long j) {
        if (j == LocationRequestCompat.PASSIVE_INTERVAL) {
            return 0;
        }
        long jSumCount = sumCount();
        if (jSumCount <= 1 || jSumCount < j) {
            return 0;
        }
        int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism() << 2;
        if (j > 0) {
            long j2 = jSumCount / j;
            if (j2 < commonPoolParallelism) {
                return (int) j2;
            }
        }
        return commonPoolParallelism;
    }

    public void forEach(long j, BiAction<? super K, ? super V> biAction) {
        if (biAction == null) {
            throw new NullPointerException();
        }
        new ForEachMappingTask(null, batchFor(j), 0, 0, this.table, biAction).invoke();
    }

    public <U> void forEach(long j, BiFun<? super K, ? super V, ? extends U> biFun, Action<? super U> action) {
        if (biFun == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedMappingTask(null, batchFor(j), 0, 0, this.table, biFun, action).invoke();
    }

    public <U> U search(long j, BiFun<? super K, ? super V, ? extends U> biFun) {
        if (biFun == null) {
            throw new NullPointerException();
        }
        return new SearchMappingsTask(null, batchFor(j), 0, 0, this.table, biFun, new AtomicReference()).invoke();
    }

    public <U> U reduce(long j, BiFun<? super K, ? super V, ? extends U> biFun, BiFun<? super U, ? super U, ? extends U> biFun2) {
        if (biFun == null || biFun2 == null) {
            throw new NullPointerException();
        }
        return new MapReduceMappingsTask(null, batchFor(j), 0, 0, this.table, null, biFun, biFun2).invoke();
    }

    public double reduceToDouble(long j, ObjectByObjectToDouble<? super K, ? super V> objectByObjectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
        if (objectByObjectToDouble == null || doubleByDoubleToDouble == null) {
            throw new NullPointerException();
        }
        return new MapReduceMappingsToDoubleTask(null, batchFor(j), 0, 0, this.table, null, objectByObjectToDouble, d, doubleByDoubleToDouble).invoke().doubleValue();
    }

    public long reduceToLong(long j, ObjectByObjectToLong<? super K, ? super V> objectByObjectToLong, long j2, LongByLongToLong longByLongToLong) {
        if (objectByObjectToLong == null || longByLongToLong == null) {
            throw new NullPointerException();
        }
        return new MapReduceMappingsToLongTask(null, batchFor(j), 0, 0, this.table, null, objectByObjectToLong, j2, longByLongToLong).invoke().longValue();
    }

    public int reduceToInt(long j, ObjectByObjectToInt<? super K, ? super V> objectByObjectToInt, int i, IntByIntToInt intByIntToInt) {
        if (objectByObjectToInt == null || intByIntToInt == null) {
            throw new NullPointerException();
        }
        return new MapReduceMappingsToIntTask(null, batchFor(j), 0, 0, this.table, null, objectByObjectToInt, i, intByIntToInt).invoke().intValue();
    }

    public void forEachKey(long j, Action<? super K> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachKeyTask(null, batchFor(j), 0, 0, this.table, action).invoke();
    }

    public <U> void forEachKey(long j, Fun<? super K, ? extends U> fun, Action<? super U> action) {
        if (fun == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedKeyTask(null, batchFor(j), 0, 0, this.table, fun, action).invoke();
    }

    public <U> U searchKeys(long j, Fun<? super K, ? extends U> fun) {
        if (fun == null) {
            throw new NullPointerException();
        }
        return new SearchKeysTask(null, batchFor(j), 0, 0, this.table, fun, new AtomicReference()).invoke();
    }

    public K reduceKeys(long j, BiFun<? super K, ? super K, ? extends K> biFun) {
        if (biFun == null) {
            throw new NullPointerException();
        }
        return new ReduceKeysTask(null, batchFor(j), 0, 0, this.table, null, biFun).invoke();
    }

    public <U> U reduceKeys(long j, Fun<? super K, ? extends U> fun, BiFun<? super U, ? super U, ? extends U> biFun) {
        if (fun == null || biFun == null) {
            throw new NullPointerException();
        }
        return new MapReduceKeysTask(null, batchFor(j), 0, 0, this.table, null, fun, biFun).invoke();
    }

    public double reduceKeysToDouble(long j, ObjectToDouble<? super K> objectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
        if (objectToDouble == null || doubleByDoubleToDouble == null) {
            throw new NullPointerException();
        }
        return new MapReduceKeysToDoubleTask(null, batchFor(j), 0, 0, this.table, null, objectToDouble, d, doubleByDoubleToDouble).invoke().doubleValue();
    }

    public long reduceKeysToLong(long j, ObjectToLong<? super K> objectToLong, long j2, LongByLongToLong longByLongToLong) {
        if (objectToLong == null || longByLongToLong == null) {
            throw new NullPointerException();
        }
        return new MapReduceKeysToLongTask(null, batchFor(j), 0, 0, this.table, null, objectToLong, j2, longByLongToLong).invoke().longValue();
    }

    public int reduceKeysToInt(long j, ObjectToInt<? super K> objectToInt, int i, IntByIntToInt intByIntToInt) {
        if (objectToInt == null || intByIntToInt == null) {
            throw new NullPointerException();
        }
        return new MapReduceKeysToIntTask(null, batchFor(j), 0, 0, this.table, null, objectToInt, i, intByIntToInt).invoke().intValue();
    }

    public void forEachValue(long j, Action<? super V> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachValueTask(null, batchFor(j), 0, 0, this.table, action).invoke();
    }

    public <U> void forEachValue(long j, Fun<? super V, ? extends U> fun, Action<? super U> action) {
        if (fun == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedValueTask(null, batchFor(j), 0, 0, this.table, fun, action).invoke();
    }

    public <U> U searchValues(long j, Fun<? super V, ? extends U> fun) {
        if (fun == null) {
            throw new NullPointerException();
        }
        return new SearchValuesTask(null, batchFor(j), 0, 0, this.table, fun, new AtomicReference()).invoke();
    }

    public V reduceValues(long j, BiFun<? super V, ? super V, ? extends V> biFun) {
        if (biFun == null) {
            throw new NullPointerException();
        }
        return new ReduceValuesTask(null, batchFor(j), 0, 0, this.table, null, biFun).invoke();
    }

    public <U> U reduceValues(long j, Fun<? super V, ? extends U> fun, BiFun<? super U, ? super U, ? extends U> biFun) {
        if (fun == null || biFun == null) {
            throw new NullPointerException();
        }
        return new MapReduceValuesTask(null, batchFor(j), 0, 0, this.table, null, fun, biFun).invoke();
    }

    public double reduceValuesToDouble(long j, ObjectToDouble<? super V> objectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
        if (objectToDouble == null || doubleByDoubleToDouble == null) {
            throw new NullPointerException();
        }
        return new MapReduceValuesToDoubleTask(null, batchFor(j), 0, 0, this.table, null, objectToDouble, d, doubleByDoubleToDouble).invoke().doubleValue();
    }

    public long reduceValuesToLong(long j, ObjectToLong<? super V> objectToLong, long j2, LongByLongToLong longByLongToLong) {
        if (objectToLong == null || longByLongToLong == null) {
            throw new NullPointerException();
        }
        return new MapReduceValuesToLongTask(null, batchFor(j), 0, 0, this.table, null, objectToLong, j2, longByLongToLong).invoke().longValue();
    }

    public int reduceValuesToInt(long j, ObjectToInt<? super V> objectToInt, int i, IntByIntToInt intByIntToInt) {
        if (objectToInt == null || intByIntToInt == null) {
            throw new NullPointerException();
        }
        return new MapReduceValuesToIntTask(null, batchFor(j), 0, 0, this.table, null, objectToInt, i, intByIntToInt).invoke().intValue();
    }

    public void forEachEntry(long j, Action<? super Map.Entry<K, V>> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachEntryTask(null, batchFor(j), 0, 0, this.table, action).invoke();
    }

    public <U> void forEachEntry(long j, Fun<Map.Entry<K, V>, ? extends U> fun, Action<? super U> action) {
        if (fun == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedEntryTask(null, batchFor(j), 0, 0, this.table, fun, action).invoke();
    }

    public <U> U searchEntries(long j, Fun<Map.Entry<K, V>, ? extends U> fun) {
        if (fun == null) {
            throw new NullPointerException();
        }
        return new SearchEntriesTask(null, batchFor(j), 0, 0, this.table, fun, new AtomicReference()).invoke();
    }

    public Map.Entry<K, V> reduceEntries(long j, BiFun<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> biFun) {
        if (biFun == null) {
            throw new NullPointerException();
        }
        return new ReduceEntriesTask(null, batchFor(j), 0, 0, this.table, null, biFun).invoke();
    }

    public <U> U reduceEntries(long j, Fun<Map.Entry<K, V>, ? extends U> fun, BiFun<? super U, ? super U, ? extends U> biFun) {
        if (fun == null || biFun == null) {
            throw new NullPointerException();
        }
        return new MapReduceEntriesTask(null, batchFor(j), 0, 0, this.table, null, fun, biFun).invoke();
    }

    public double reduceEntriesToDouble(long j, ObjectToDouble<Map.Entry<K, V>> objectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
        if (objectToDouble == null || doubleByDoubleToDouble == null) {
            throw new NullPointerException();
        }
        return new MapReduceEntriesToDoubleTask(null, batchFor(j), 0, 0, this.table, null, objectToDouble, d, doubleByDoubleToDouble).invoke().doubleValue();
    }

    public long reduceEntriesToLong(long j, ObjectToLong<Map.Entry<K, V>> objectToLong, long j2, LongByLongToLong longByLongToLong) {
        if (objectToLong == null || longByLongToLong == null) {
            throw new NullPointerException();
        }
        return new MapReduceEntriesToLongTask(null, batchFor(j), 0, 0, this.table, null, objectToLong, j2, longByLongToLong).invoke().longValue();
    }

    public int reduceEntriesToInt(long j, ObjectToInt<Map.Entry<K, V>> objectToInt, int i, IntByIntToInt intByIntToInt) {
        if (objectToInt == null || intByIntToInt == null) {
            throw new NullPointerException();
        }
        return new MapReduceEntriesToIntTask(null, batchFor(j), 0, 0, this.table, null, objectToInt, i, intByIntToInt).invoke().intValue();
    }

    static abstract class CollectionView<K, V, E> implements Serializable, Collection<E> {
        private static final String oomeMsg = "Required array size too large";
        private static final long serialVersionUID = 7249069246763182397L;
        final ConcurrentHashMapV8<K, V> map;

        @Override // java.util.Collection
        public abstract boolean contains(Object obj);

        @Override // java.util.Collection, java.lang.Iterable
        public abstract Iterator<E> iterator();

        @Override // java.util.Collection
        public abstract boolean remove(Object obj);

        CollectionView(ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            this.map = concurrentHashMapV8;
        }

        public ConcurrentHashMapV8<K, V> getMap() {
            return this.map;
        }

        @Override // java.util.Collection
        public final void clear() {
            this.map.clear();
        }

        @Override // java.util.Collection
        public final int size() {
            return this.map.size();
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            long jMappingCount = this.map.mappingCount();
            if (jMappingCount > 2147483639) {
                throw new OutOfMemoryError(oomeMsg);
            }
            int i = (int) jMappingCount;
            Object[] objArrCopyOf = new Object[i];
            int i2 = 0;
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (i2 == i) {
                    int i3 = ConcurrentHashMapV8.MAX_ARRAY_SIZE;
                    if (i >= ConcurrentHashMapV8.MAX_ARRAY_SIZE) {
                        throw new OutOfMemoryError(oomeMsg);
                    }
                    if (i < 1073741819) {
                        i3 = (i >>> 1) + 1 + i;
                    }
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                    i = i3;
                }
                objArrCopyOf[i2] = next;
                i2++;
            }
            return i2 == i ? objArrCopyOf : Arrays.copyOf(objArrCopyOf, i2);
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            long jMappingCount = this.map.mappingCount();
            if (jMappingCount > 2147483639) {
                throw new OutOfMemoryError(oomeMsg);
            }
            int i = (int) jMappingCount;
            Object[] objArr = tArr.length >= i ? tArr : (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
            int length = objArr.length;
            int i2 = 0;
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (i2 == length) {
                    int i3 = ConcurrentHashMapV8.MAX_ARRAY_SIZE;
                    if (length >= ConcurrentHashMapV8.MAX_ARRAY_SIZE) {
                        throw new OutOfMemoryError(oomeMsg);
                    }
                    if (length < 1073741819) {
                        i3 = (length >>> 1) + 1 + length;
                    }
                    objArr = (T[]) Arrays.copyOf(objArr, i3);
                    length = i3;
                }
                objArr[i2] = next;
                i2++;
            }
            if (tArr != objArr || i2 >= length) {
                return i2 == length ? (T[]) objArr : (T[]) Arrays.copyOf(objArr, i2);
            }
            objArr[i2] = null;
            return (T[]) objArr;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            Iterator<E> it = iterator();
            if (it.hasNext()) {
                while (true) {
                    Object next = it.next();
                    if (next == this) {
                        next = "(this Collection)";
                    }
                    sb.append(next);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(StringUtil.COMMA);
                    sb.append(' ');
                }
            }
            sb.append(']');
            return sb.toString();
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            if (collection == this) {
                return true;
            }
            for (Object obj : collection) {
                if (obj == null || !contains(obj)) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            Iterator<E> it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            Iterator<E> it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
    }

    public static class KeySetView<K, V> extends CollectionView<K, V, K> implements Serializable, Set<K> {
        private static final long serialVersionUID = 7249069246763182397L;
        private final V value;

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView
        public /* bridge */ /* synthetic */ ConcurrentHashMapV8 getMap() {
            return super.getMap();
        }

        KeySetView(ConcurrentHashMapV8<K, V> concurrentHashMapV8, V v) {
            super(concurrentHashMapV8);
            this.value = v;
        }

        public V getMappedValue() {
            return this.value;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection
        public boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection
        public boolean remove(Object obj) {
            return this.map.remove(obj) != null;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            ConcurrentHashMapV8<K, V> concurrentHashMapV8 = this.map;
            Node<K, V>[] nodeArr = concurrentHashMapV8.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new KeyIterator(nodeArr, length, 0, length, concurrentHashMapV8);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(K k) {
            V v = this.value;
            if (v != null) {
                return this.map.putVal(k, v, true) == null;
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends K> collection) {
            V v = this.value;
            if (v == null) {
                throw new UnsupportedOperationException();
            }
            Iterator<? extends K> it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (this.map.putVal(it.next(), v, true) == null) {
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            Iterator<K> it = iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                iHashCode += it.next().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            Set set = (Set) obj;
            if (set != this) {
                return containsAll(set) && set.containsAll(this);
            }
            return true;
        }

        public ConcurrentHashMapSpliterator<K> spliterator166() {
            ConcurrentHashMapV8<K, V> concurrentHashMapV8 = this.map;
            long jSumCount = concurrentHashMapV8.sumCount();
            Node<K, V>[] nodeArr = concurrentHashMapV8.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new KeySpliterator(nodeArr, length, 0, length, jSumCount >= 0 ? jSumCount : 0L);
        }

        public void forEach(Action<? super K> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return;
            }
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> nodeAdvance = traverser.advance();
                if (nodeAdvance == null) {
                    return;
                } else {
                    action.apply(nodeAdvance.key);
                }
            }
        }
    }

    static final class ValuesView<K, V> extends CollectionView<K, V, V> implements Serializable, Collection<V> {
        private static final long serialVersionUID = 2249069246763182397L;

        ValuesView(ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            super(concurrentHashMapV8);
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection
        public final boolean contains(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection
        public final boolean remove(Object obj) {
            if (obj == null) {
                return false;
            }
            Iterator<V> it = iterator();
            while (it.hasNext()) {
                if (obj.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            ConcurrentHashMapV8<K, V> concurrentHashMapV8 = this.map;
            Node<K, V>[] nodeArr = concurrentHashMapV8.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new ValueIterator(nodeArr, length, 0, length, concurrentHashMapV8);
        }

        @Override // java.util.Collection
        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final ConcurrentHashMapSpliterator<V> spliterator166() {
            ConcurrentHashMapV8<K, V> concurrentHashMapV8 = this.map;
            long jSumCount = concurrentHashMapV8.sumCount();
            Node<K, V>[] nodeArr = concurrentHashMapV8.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new ValueSpliterator(nodeArr, length, 0, length, jSumCount >= 0 ? jSumCount : 0L);
        }

        public final void forEach(Action<? super V> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return;
            }
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> nodeAdvance = traverser.advance();
                if (nodeAdvance == null) {
                    return;
                } else {
                    action.apply(nodeAdvance.val);
                }
            }
        }
    }

    static final class EntrySetView<K, V> extends CollectionView<K, V, Map.Entry<K, V>> implements Serializable, Set<Map.Entry<K, V>> {
        private static final long serialVersionUID = 2249069246763182397L;

        EntrySetView(ConcurrentHashMapV8<K, V> concurrentHashMapV8) {
            super(concurrentHashMapV8);
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection
        public final boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            V v;
            Object value;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (v = this.map.get(key)) == null || (value = entry.getValue()) == null) {
                return false;
            }
            return value == v || value.equals(v);
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection
        public final boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && this.map.remove(key, value);
        }

        @Override // io.netty.util.internal.chmv8.ConcurrentHashMapV8.CollectionView, java.util.Collection, java.lang.Iterable
        public final Iterator<Map.Entry<K, V>> iterator() {
            ConcurrentHashMapV8<K, V> concurrentHashMapV8 = this.map;
            Node<K, V>[] nodeArr = concurrentHashMapV8.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new EntryIterator(nodeArr, length, 0, length, concurrentHashMapV8);
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean add(Map.Entry<K, V> entry) {
            return this.map.putVal(entry.getKey(), entry.getValue(), false) == null;
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            Iterator<? extends Map.Entry<K, V>> it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (add((Map.Entry) it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            Node<K, V>[] nodeArr = this.map.table;
            int iHashCode = 0;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node<K, V> nodeAdvance = traverser.advance();
                    if (nodeAdvance == null) {
                        break;
                    }
                    iHashCode += nodeAdvance.hashCode();
                }
            }
            return iHashCode;
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            Set set = (Set) obj;
            if (set != this) {
                return containsAll(set) && set.containsAll(this);
            }
            return true;
        }

        public final ConcurrentHashMapSpliterator<Map.Entry<K, V>> spliterator166() {
            ConcurrentHashMapV8<K, V> concurrentHashMapV8 = this.map;
            long jSumCount = concurrentHashMapV8.sumCount();
            Node<K, V>[] nodeArr = concurrentHashMapV8.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new EntrySpliterator(nodeArr, length, 0, length, jSumCount >= 0 ? jSumCount : 0L, concurrentHashMapV8);
        }

        public final void forEach(Action<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return;
            }
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> nodeAdvance = traverser.advance();
                if (nodeAdvance == null) {
                    return;
                } else {
                    action.apply(new MapEntry(nodeAdvance.key, nodeAdvance.val, this.map));
                }
            }
        }
    }

    static abstract class BulkTask<K, V, R> extends CountedCompleter<R> {
        int baseIndex;
        int baseLimit;
        final int baseSize;
        int batch;
        int index;
        Node<K, V> next;
        Node<K, V>[] tab;

        BulkTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr) {
            super(bulkTask);
            this.batch = i;
            this.baseIndex = i2;
            this.index = i2;
            this.tab = nodeArr;
            if (nodeArr == null) {
                this.baseLimit = 0;
                this.baseSize = 0;
            } else if (bulkTask == null) {
                int length = nodeArr.length;
                this.baseLimit = length;
                this.baseSize = length;
            } else {
                this.baseLimit = i3;
                this.baseSize = bulkTask.baseSize;
            }
        }

        final Node<K, V> advance() {
            Node<K, V>[] nodeArr;
            int length;
            int i;
            Node<K, V> nodeTabAt = this.next;
            if (nodeTabAt != null) {
                nodeTabAt = nodeTabAt.next;
            }
            while (nodeTabAt == null) {
                if (this.baseIndex >= this.baseLimit || (nodeArr = this.tab) == null || (length = nodeArr.length) <= (i = this.index) || i < 0) {
                    this.next = null;
                    return null;
                }
                nodeTabAt = ConcurrentHashMapV8.tabAt(nodeArr, i);
                if (nodeTabAt != null && nodeTabAt.hash < 0) {
                    if (nodeTabAt instanceof ForwardingNode) {
                        this.tab = ((ForwardingNode) nodeTabAt).nextTable;
                        nodeTabAt = null;
                    } else {
                        nodeTabAt = nodeTabAt instanceof TreeBin ? ((TreeBin) nodeTabAt).first : null;
                    }
                }
                int i2 = this.index + this.baseSize;
                this.index = i2;
                if (i2 >= length) {
                    int i3 = this.baseIndex + 1;
                    this.baseIndex = i3;
                    this.index = i3;
                }
            }
            this.next = nodeTabAt;
            return nodeTabAt;
        }
    }

    static final class ForEachKeyTask<K, V> extends BulkTask<K, V, Void> {
        final Action<? super K> action;

        ForEachKeyTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Action<? super K> action) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.action = action;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            Action<? super K> action = this.action;
            if (action == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachKeyTask(this, i4, i3, i2, this.tab, action).fork();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance != null) {
                    action.apply(nodeAdvance.key);
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    static final class ForEachValueTask<K, V> extends BulkTask<K, V, Void> {
        final Action<? super V> action;

        ForEachValueTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Action<? super V> action) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.action = action;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            Action<? super V> action = this.action;
            if (action == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachValueTask(this, i4, i3, i2, this.tab, action).fork();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance != null) {
                    action.apply(nodeAdvance.val);
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    static final class ForEachEntryTask<K, V> extends BulkTask<K, V, Void> {
        final Action<? super Map.Entry<K, V>> action;

        ForEachEntryTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Action<? super Map.Entry<K, V>> action) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.action = action;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            Action<? super Map.Entry<K, V>> action = this.action;
            if (action == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachEntryTask(this, i4, i3, i2, this.tab, action).fork();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance != null) {
                    action.apply(nodeAdvance);
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    static final class ForEachMappingTask<K, V> extends BulkTask<K, V, Void> {
        final BiAction<? super K, ? super V> action;

        ForEachMappingTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, BiAction<? super K, ? super V> biAction) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.action = biAction;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiAction<? super K, ? super V> biAction = this.action;
            if (biAction == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachMappingTask(this, i4, i3, i2, this.tab, biAction).fork();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance != null) {
                    biAction.apply(nodeAdvance.key, nodeAdvance.val);
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    static final class ForEachTransformedKeyTask<K, V, U> extends BulkTask<K, V, Void> {
        final Action<? super U> action;
        final Fun<? super K, ? extends U> transformer;

        ForEachTransformedKeyTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Fun<? super K, ? extends U> fun, Action<? super U> action) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.transformer = fun;
            this.action = action;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            Action<? super U> action;
            Fun<? super K, ? extends U> fun = this.transformer;
            if (fun == null || (action = this.action) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachTransformedKeyTask(this, i4, i3, i2, this.tab, fun, action).fork();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance != null) {
                    U uApply = fun.apply(nodeAdvance.key);
                    if (uApply != null) {
                        action.apply(uApply);
                    }
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    static final class ForEachTransformedValueTask<K, V, U> extends BulkTask<K, V, Void> {
        final Action<? super U> action;
        final Fun<? super V, ? extends U> transformer;

        ForEachTransformedValueTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Fun<? super V, ? extends U> fun, Action<? super U> action) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.transformer = fun;
            this.action = action;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            Action<? super U> action;
            Fun<? super V, ? extends U> fun = this.transformer;
            if (fun == null || (action = this.action) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachTransformedValueTask(this, i4, i3, i2, this.tab, fun, action).fork();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance != null) {
                    U uApply = fun.apply(nodeAdvance.val);
                    if (uApply != null) {
                        action.apply(uApply);
                    }
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    static final class ForEachTransformedEntryTask<K, V, U> extends BulkTask<K, V, Void> {
        final Action<? super U> action;
        final Fun<Map.Entry<K, V>, ? extends U> transformer;

        ForEachTransformedEntryTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Fun<Map.Entry<K, V>, ? extends U> fun, Action<? super U> action) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.transformer = fun;
            this.action = action;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            Action<? super U> action;
            Fun<Map.Entry<K, V>, ? extends U> fun = this.transformer;
            if (fun == null || (action = this.action) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachTransformedEntryTask(this, i4, i3, i2, this.tab, fun, action).fork();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance != null) {
                    U uApply = fun.apply(nodeAdvance);
                    if (uApply != null) {
                        action.apply(uApply);
                    }
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    static final class ForEachTransformedMappingTask<K, V, U> extends BulkTask<K, V, Void> {
        final Action<? super U> action;
        final BiFun<? super K, ? super V, ? extends U> transformer;

        ForEachTransformedMappingTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, BiFun<? super K, ? super V, ? extends U> biFun, Action<? super U> action) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.transformer = biFun;
            this.action = action;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            Action<? super U> action;
            BiFun<? super K, ? super V, ? extends U> biFun = this.transformer;
            if (biFun == null || (action = this.action) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new ForEachTransformedMappingTask(this, i4, i3, i2, this.tab, biFun, action).fork();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance != null) {
                    U uApply = biFun.apply(nodeAdvance.key, nodeAdvance.val);
                    if (uApply != null) {
                        action.apply(uApply);
                    }
                } else {
                    propagateCompletion();
                    return;
                }
            }
        }
    }

    static final class SearchKeysTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Fun<? super K, ? extends U> searchFunction;

        SearchKeysTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Fun<? super K, ? extends U> fun, AtomicReference<U> atomicReference) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.searchFunction = fun;
            this.result = atomicReference;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            AtomicReference<U> atomicReference;
            Fun<? super K, ? extends U> fun = this.searchFunction;
            if (fun == null || (atomicReference = this.result) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                if (atomicReference.get() != null) {
                    return;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new SearchKeysTask(this, i4, i3, i2, this.tab, fun, atomicReference).fork();
            }
            while (atomicReference.get() == null) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    propagateCompletion();
                    return;
                }
                U uApply = fun.apply(nodeAdvance.key);
                if (uApply != null) {
                    if (atomicReference.compareAndSet(null, uApply)) {
                        quietlyCompleteRoot();
                        return;
                    }
                    return;
                }
            }
        }
    }

    static final class SearchValuesTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Fun<? super V, ? extends U> searchFunction;

        SearchValuesTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Fun<? super V, ? extends U> fun, AtomicReference<U> atomicReference) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.searchFunction = fun;
            this.result = atomicReference;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            AtomicReference<U> atomicReference;
            Fun<? super V, ? extends U> fun = this.searchFunction;
            if (fun == null || (atomicReference = this.result) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                if (atomicReference.get() != null) {
                    return;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new SearchValuesTask(this, i4, i3, i2, this.tab, fun, atomicReference).fork();
            }
            while (atomicReference.get() == null) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    propagateCompletion();
                    return;
                }
                U uApply = fun.apply(nodeAdvance.val);
                if (uApply != null) {
                    if (atomicReference.compareAndSet(null, uApply)) {
                        quietlyCompleteRoot();
                        return;
                    }
                    return;
                }
            }
        }
    }

    static final class SearchEntriesTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Fun<Map.Entry<K, V>, ? extends U> searchFunction;

        SearchEntriesTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, Fun<Map.Entry<K, V>, ? extends U> fun, AtomicReference<U> atomicReference) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.searchFunction = fun;
            this.result = atomicReference;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            AtomicReference<U> atomicReference;
            Fun<Map.Entry<K, V>, ? extends U> fun = this.searchFunction;
            if (fun == null || (atomicReference = this.result) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                if (atomicReference.get() != null) {
                    return;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new SearchEntriesTask(this, i4, i3, i2, this.tab, fun, atomicReference).fork();
            }
            while (atomicReference.get() == null) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    propagateCompletion();
                    return;
                }
                U uApply = fun.apply(nodeAdvance);
                if (uApply != null) {
                    if (atomicReference.compareAndSet(null, uApply)) {
                        quietlyCompleteRoot();
                        return;
                    }
                    return;
                }
            }
        }
    }

    static final class SearchMappingsTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final BiFun<? super K, ? super V, ? extends U> searchFunction;

        SearchMappingsTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, BiFun<? super K, ? super V, ? extends U> biFun, AtomicReference<U> atomicReference) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.searchFunction = biFun;
            this.result = atomicReference;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            AtomicReference<U> atomicReference;
            BiFun<? super K, ? super V, ? extends U> biFun = this.searchFunction;
            if (biFun == null || (atomicReference = this.result) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                if (atomicReference.get() != null) {
                    return;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                new SearchMappingsTask(this, i4, i3, i2, this.tab, biFun, atomicReference).fork();
            }
            while (atomicReference.get() == null) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    propagateCompletion();
                    return;
                }
                U uApply = biFun.apply(nodeAdvance.key, nodeAdvance.val);
                if (uApply != null) {
                    if (atomicReference.compareAndSet(null, uApply)) {
                        quietlyCompleteRoot();
                        return;
                    }
                    return;
                }
            }
        }
    }

    static final class ReduceKeysTask<K, V> extends BulkTask<K, V, K> {
        ReduceKeysTask<K, V> nextRight;
        final BiFun<? super K, ? super K, ? extends K> reducer;
        K result;
        ReduceKeysTask<K, V> rights;

        ReduceKeysTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, ReduceKeysTask<K, V> reduceKeysTask, BiFun<? super K, ? super K, ? extends K> biFun) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = reduceKeysTask;
            this.reducer = biFun;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final K getRawResult() {
            return this.result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiFun<? super K, ? super K, ? extends K> biFun = this.reducer;
            if (biFun != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int i2 = this.baseLimit;
                    int i3 = (i2 + i) >>> 1;
                    if (i3 <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i4 = this.batch >>> 1;
                    this.batch = i4;
                    this.baseLimit = i3;
                    ReduceKeysTask<K, V> reduceKeysTask = new ReduceKeysTask<>(this, i4, i3, i2, this.tab, this.rights, biFun);
                    this.rights = reduceKeysTask;
                    reduceKeysTask.fork();
                }
                Object obj = (K) null;
                while (true) {
                    Node<K, V> nodeAdvance = advance();
                    if (nodeAdvance == null) {
                        break;
                    }
                    Object obj2 = (K) nodeAdvance.key;
                    if (obj == null) {
                        obj = (K) obj2;
                    } else if (obj2 != null) {
                        obj = (K) biFun.apply(obj, obj2);
                    }
                }
                this.result = (K) obj;
                for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                    ReduceKeysTask reduceKeysTask2 = (ReduceKeysTask) countedCompleterFirstComplete;
                    ReduceKeysTask<K, V> reduceKeysTask3 = reduceKeysTask2.rights;
                    while (reduceKeysTask3 != null) {
                        K kApply = reduceKeysTask3.result;
                        if (kApply != null) {
                            Object obj3 = (K) reduceKeysTask2.result;
                            if (obj3 != null) {
                                kApply = biFun.apply(obj3, kApply);
                            }
                            reduceKeysTask2.result = (K) kApply;
                        }
                        reduceKeysTask3 = reduceKeysTask3.nextRight;
                        reduceKeysTask2.rights = reduceKeysTask3;
                    }
                }
            }
        }
    }

    static final class ReduceValuesTask<K, V> extends BulkTask<K, V, V> {
        ReduceValuesTask<K, V> nextRight;
        final BiFun<? super V, ? super V, ? extends V> reducer;
        V result;
        ReduceValuesTask<K, V> rights;

        ReduceValuesTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, ReduceValuesTask<K, V> reduceValuesTask, BiFun<? super V, ? super V, ? extends V> biFun) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = reduceValuesTask;
            this.reducer = biFun;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final V getRawResult() {
            return this.result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiFun<? super V, ? super V, ? extends V> biFun = this.reducer;
            if (biFun != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int i2 = this.baseLimit;
                    int i3 = (i2 + i) >>> 1;
                    if (i3 <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i4 = this.batch >>> 1;
                    this.batch = i4;
                    this.baseLimit = i3;
                    ReduceValuesTask<K, V> reduceValuesTask = new ReduceValuesTask<>(this, i4, i3, i2, this.tab, this.rights, biFun);
                    this.rights = reduceValuesTask;
                    reduceValuesTask.fork();
                }
                Object obj = (V) null;
                while (true) {
                    Node<K, V> nodeAdvance = advance();
                    if (nodeAdvance == null) {
                        break;
                    }
                    Object obj2 = (V) nodeAdvance.val;
                    obj = obj == null ? (V) obj2 : (V) biFun.apply(obj, obj2);
                }
                this.result = (V) obj;
                for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                    ReduceValuesTask reduceValuesTask2 = (ReduceValuesTask) countedCompleterFirstComplete;
                    ReduceValuesTask<K, V> reduceValuesTask3 = reduceValuesTask2.rights;
                    while (reduceValuesTask3 != null) {
                        V vApply = reduceValuesTask3.result;
                        if (vApply != null) {
                            Object obj3 = (V) reduceValuesTask2.result;
                            if (obj3 != null) {
                                vApply = biFun.apply(obj3, vApply);
                            }
                            reduceValuesTask2.result = (V) vApply;
                        }
                        reduceValuesTask3 = reduceValuesTask3.nextRight;
                        reduceValuesTask2.rights = reduceValuesTask3;
                    }
                }
            }
        }
    }

    static final class ReduceEntriesTask<K, V> extends BulkTask<K, V, Map.Entry<K, V>> {
        ReduceEntriesTask<K, V> nextRight;
        final BiFun<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> reducer;
        Map.Entry<K, V> result;
        ReduceEntriesTask<K, V> rights;

        ReduceEntriesTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, ReduceEntriesTask<K, V> reduceEntriesTask, BiFun<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> biFun) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = reduceEntriesTask;
            this.reducer = biFun;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Map.Entry<K, V> getRawResult() {
            return this.result;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiFun<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> biFun = this.reducer;
            if (biFun != null) {
                int i = this.baseIndex;
                while (this.batch > 0) {
                    int i2 = this.baseLimit;
                    int i3 = (i2 + i) >>> 1;
                    if (i3 <= i) {
                        break;
                    }
                    addToPendingCount(1);
                    int i4 = this.batch >>> 1;
                    this.batch = i4;
                    this.baseLimit = i3;
                    ReduceEntriesTask<K, V> reduceEntriesTask = new ReduceEntriesTask<>(this, i4, i3, i2, this.tab, this.rights, biFun);
                    this.rights = reduceEntriesTask;
                    reduceEntriesTask.fork();
                }
                Map.Entry<K, V> entryApply = null;
                while (true) {
                    Node<K, V> nodeAdvance = advance();
                    if (nodeAdvance == null) {
                        break;
                    } else {
                        entryApply = entryApply == null ? nodeAdvance : biFun.apply(entryApply, nodeAdvance);
                    }
                }
                this.result = entryApply;
                for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                    ReduceEntriesTask reduceEntriesTask2 = (ReduceEntriesTask) countedCompleterFirstComplete;
                    ReduceEntriesTask<K, V> reduceEntriesTask3 = reduceEntriesTask2.rights;
                    while (reduceEntriesTask3 != null) {
                        Map.Entry<K, V> entryApply2 = reduceEntriesTask3.result;
                        if (entryApply2 != null) {
                            Map.Entry<K, V> entry = reduceEntriesTask2.result;
                            if (entry != null) {
                                entryApply2 = biFun.apply(entry, entryApply2);
                            }
                            reduceEntriesTask2.result = entryApply2;
                        }
                        reduceEntriesTask3 = reduceEntriesTask3.nextRight;
                        reduceEntriesTask2.rights = reduceEntriesTask3;
                    }
                }
            }
        }
    }

    static final class MapReduceKeysTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceKeysTask<K, V, U> nextRight;
        final BiFun<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceKeysTask<K, V, U> rights;
        final Fun<? super K, ? extends U> transformer;

        MapReduceKeysTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceKeysTask<K, V, U> mapReduceKeysTask, Fun<? super K, ? extends U> fun, BiFun<? super U, ? super U, ? extends U> biFun) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceKeysTask;
            this.transformer = fun;
            this.reducer = biFun;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiFun<? super U, ? super U, ? extends U> biFun;
            Fun<? super K, ? extends U> fun = this.transformer;
            if (fun == null || (biFun = this.reducer) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceKeysTask<K, V, U> mapReduceKeysTask = new MapReduceKeysTask<>(this, i4, i3, i2, this.tab, this.rights, fun, biFun);
                this.rights = mapReduceKeysTask;
                mapReduceKeysTask.fork();
            }
            Object obj = (U) null;
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                }
                Object obj2 = (U) fun.apply((K) nodeAdvance.key);
                if (obj2 != null) {
                    if (obj != null) {
                        obj2 = (U) biFun.apply(obj, obj2);
                    }
                    obj = (U) obj2;
                }
            }
            this.result = (U) obj;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceKeysTask mapReduceKeysTask2 = (MapReduceKeysTask) countedCompleterFirstComplete;
                MapReduceKeysTask<K, V, U> mapReduceKeysTask3 = mapReduceKeysTask2.rights;
                while (mapReduceKeysTask3 != null) {
                    U uApply = mapReduceKeysTask3.result;
                    if (uApply != null) {
                        Object obj3 = (U) mapReduceKeysTask2.result;
                        if (obj3 != null) {
                            uApply = biFun.apply(obj3, uApply);
                        }
                        mapReduceKeysTask2.result = (U) uApply;
                    }
                    mapReduceKeysTask3 = mapReduceKeysTask3.nextRight;
                    mapReduceKeysTask2.rights = mapReduceKeysTask3;
                }
            }
        }
    }

    static final class MapReduceValuesTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceValuesTask<K, V, U> nextRight;
        final BiFun<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceValuesTask<K, V, U> rights;
        final Fun<? super V, ? extends U> transformer;

        MapReduceValuesTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceValuesTask<K, V, U> mapReduceValuesTask, Fun<? super V, ? extends U> fun, BiFun<? super U, ? super U, ? extends U> biFun) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceValuesTask;
            this.transformer = fun;
            this.reducer = biFun;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiFun<? super U, ? super U, ? extends U> biFun;
            Fun<? super V, ? extends U> fun = this.transformer;
            if (fun == null || (biFun = this.reducer) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceValuesTask<K, V, U> mapReduceValuesTask = new MapReduceValuesTask<>(this, i4, i3, i2, this.tab, this.rights, fun, biFun);
                this.rights = mapReduceValuesTask;
                mapReduceValuesTask.fork();
            }
            Object obj = (U) null;
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                }
                Object obj2 = (U) fun.apply((V) nodeAdvance.val);
                if (obj2 != null) {
                    if (obj != null) {
                        obj2 = (U) biFun.apply(obj, obj2);
                    }
                    obj = (U) obj2;
                }
            }
            this.result = (U) obj;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceValuesTask mapReduceValuesTask2 = (MapReduceValuesTask) countedCompleterFirstComplete;
                MapReduceValuesTask<K, V, U> mapReduceValuesTask3 = mapReduceValuesTask2.rights;
                while (mapReduceValuesTask3 != null) {
                    U uApply = mapReduceValuesTask3.result;
                    if (uApply != null) {
                        Object obj3 = (U) mapReduceValuesTask2.result;
                        if (obj3 != null) {
                            uApply = biFun.apply(obj3, uApply);
                        }
                        mapReduceValuesTask2.result = (U) uApply;
                    }
                    mapReduceValuesTask3 = mapReduceValuesTask3.nextRight;
                    mapReduceValuesTask2.rights = mapReduceValuesTask3;
                }
            }
        }
    }

    static final class MapReduceEntriesTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceEntriesTask<K, V, U> nextRight;
        final BiFun<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceEntriesTask<K, V, U> rights;
        final Fun<Map.Entry<K, V>, ? extends U> transformer;

        MapReduceEntriesTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceEntriesTask<K, V, U> mapReduceEntriesTask, Fun<Map.Entry<K, V>, ? extends U> fun, BiFun<? super U, ? super U, ? extends U> biFun) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceEntriesTask;
            this.transformer = fun;
            this.reducer = biFun;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiFun<? super U, ? super U, ? extends U> biFun;
            Fun<Map.Entry<K, V>, ? extends U> fun = this.transformer;
            if (fun == null || (biFun = this.reducer) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceEntriesTask<K, V, U> mapReduceEntriesTask = new MapReduceEntriesTask<>(this, i4, i3, i2, this.tab, this.rights, fun, biFun);
                this.rights = mapReduceEntriesTask;
                mapReduceEntriesTask.fork();
            }
            Object obj = (U) null;
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                }
                Object obj2 = (U) fun.apply(nodeAdvance);
                if (obj2 != null) {
                    if (obj != null) {
                        obj2 = (U) biFun.apply(obj, obj2);
                    }
                    obj = (U) obj2;
                }
            }
            this.result = (U) obj;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceEntriesTask mapReduceEntriesTask2 = (MapReduceEntriesTask) countedCompleterFirstComplete;
                MapReduceEntriesTask<K, V, U> mapReduceEntriesTask3 = mapReduceEntriesTask2.rights;
                while (mapReduceEntriesTask3 != null) {
                    U uApply = mapReduceEntriesTask3.result;
                    if (uApply != null) {
                        Object obj3 = (U) mapReduceEntriesTask2.result;
                        if (obj3 != null) {
                            uApply = biFun.apply(obj3, uApply);
                        }
                        mapReduceEntriesTask2.result = (U) uApply;
                    }
                    mapReduceEntriesTask3 = mapReduceEntriesTask3.nextRight;
                    mapReduceEntriesTask2.rights = mapReduceEntriesTask3;
                }
            }
        }
    }

    static final class MapReduceMappingsTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceMappingsTask<K, V, U> nextRight;
        final BiFun<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceMappingsTask<K, V, U> rights;
        final BiFun<? super K, ? super V, ? extends U> transformer;

        MapReduceMappingsTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceMappingsTask<K, V, U> mapReduceMappingsTask, BiFun<? super K, ? super V, ? extends U> biFun, BiFun<? super U, ? super U, ? extends U> biFun2) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceMappingsTask;
            this.transformer = biFun;
            this.reducer = biFun2;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            BiFun<? super U, ? super U, ? extends U> biFun;
            BiFun<? super K, ? super V, ? extends U> biFun2 = this.transformer;
            if (biFun2 == null || (biFun = this.reducer) == null) {
                return;
            }
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceMappingsTask<K, V, U> mapReduceMappingsTask = new MapReduceMappingsTask<>(this, i4, i3, i2, this.tab, this.rights, biFun2, biFun);
                this.rights = mapReduceMappingsTask;
                mapReduceMappingsTask.fork();
            }
            Object obj = (U) null;
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                }
                Object obj2 = (U) biFun2.apply((K) nodeAdvance.key, (V) nodeAdvance.val);
                if (obj2 != null) {
                    if (obj != null) {
                        obj2 = (U) biFun.apply(obj, obj2);
                    }
                    obj = (U) obj2;
                }
            }
            this.result = (U) obj;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceMappingsTask mapReduceMappingsTask2 = (MapReduceMappingsTask) countedCompleterFirstComplete;
                MapReduceMappingsTask<K, V, U> mapReduceMappingsTask3 = mapReduceMappingsTask2.rights;
                while (mapReduceMappingsTask3 != null) {
                    U uApply = mapReduceMappingsTask3.result;
                    if (uApply != null) {
                        Object obj3 = (U) mapReduceMappingsTask2.result;
                        if (obj3 != null) {
                            uApply = biFun.apply(obj3, uApply);
                        }
                        mapReduceMappingsTask2.result = (U) uApply;
                    }
                    mapReduceMappingsTask3 = mapReduceMappingsTask3.nextRight;
                    mapReduceMappingsTask2.rights = mapReduceMappingsTask3;
                }
            }
        }
    }

    static final class MapReduceKeysToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceKeysToDoubleTask<K, V> nextRight;
        final DoubleByDoubleToDouble reducer;
        double result;
        MapReduceKeysToDoubleTask<K, V> rights;
        final ObjectToDouble<? super K> transformer;

        MapReduceKeysToDoubleTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceKeysToDoubleTask<K, V> mapReduceKeysToDoubleTask, ObjectToDouble<? super K> objectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceKeysToDoubleTask;
            this.transformer = objectToDouble;
            this.basis = d;
            this.reducer = doubleByDoubleToDouble;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            DoubleByDoubleToDouble doubleByDoubleToDouble;
            ObjectToDouble<? super K> objectToDouble = this.transformer;
            if (objectToDouble == null || (doubleByDoubleToDouble = this.reducer) == null) {
                return;
            }
            double dApply = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceKeysToDoubleTask<K, V> mapReduceKeysToDoubleTask = new MapReduceKeysToDoubleTask<>(this, i4, i3, i2, this.tab, this.rights, objectToDouble, dApply, doubleByDoubleToDouble);
                this.rights = mapReduceKeysToDoubleTask;
                mapReduceKeysToDoubleTask.fork();
                objectToDouble = objectToDouble;
                i = i;
            }
            ObjectToDouble<? super K> objectToDouble2 = objectToDouble;
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                } else {
                    dApply = doubleByDoubleToDouble.apply(dApply, objectToDouble2.apply(nodeAdvance.key));
                }
            }
            this.result = dApply;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceKeysToDoubleTask mapReduceKeysToDoubleTask2 = (MapReduceKeysToDoubleTask) countedCompleterFirstComplete;
                MapReduceKeysToDoubleTask<K, V> mapReduceKeysToDoubleTask3 = mapReduceKeysToDoubleTask2.rights;
                while (mapReduceKeysToDoubleTask3 != null) {
                    mapReduceKeysToDoubleTask2.result = doubleByDoubleToDouble.apply(mapReduceKeysToDoubleTask2.result, mapReduceKeysToDoubleTask3.result);
                    mapReduceKeysToDoubleTask3 = mapReduceKeysToDoubleTask3.nextRight;
                    mapReduceKeysToDoubleTask2.rights = mapReduceKeysToDoubleTask3;
                }
            }
        }
    }

    static final class MapReduceValuesToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceValuesToDoubleTask<K, V> nextRight;
        final DoubleByDoubleToDouble reducer;
        double result;
        MapReduceValuesToDoubleTask<K, V> rights;
        final ObjectToDouble<? super V> transformer;

        MapReduceValuesToDoubleTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceValuesToDoubleTask<K, V> mapReduceValuesToDoubleTask, ObjectToDouble<? super V> objectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceValuesToDoubleTask;
            this.transformer = objectToDouble;
            this.basis = d;
            this.reducer = doubleByDoubleToDouble;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            DoubleByDoubleToDouble doubleByDoubleToDouble;
            ObjectToDouble<? super V> objectToDouble = this.transformer;
            if (objectToDouble == null || (doubleByDoubleToDouble = this.reducer) == null) {
                return;
            }
            double dApply = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceValuesToDoubleTask<K, V> mapReduceValuesToDoubleTask = new MapReduceValuesToDoubleTask<>(this, i4, i3, i2, this.tab, this.rights, objectToDouble, dApply, doubleByDoubleToDouble);
                this.rights = mapReduceValuesToDoubleTask;
                mapReduceValuesToDoubleTask.fork();
                objectToDouble = objectToDouble;
                i = i;
            }
            ObjectToDouble<? super V> objectToDouble2 = objectToDouble;
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                } else {
                    dApply = doubleByDoubleToDouble.apply(dApply, objectToDouble2.apply(nodeAdvance.val));
                }
            }
            this.result = dApply;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceValuesToDoubleTask mapReduceValuesToDoubleTask2 = (MapReduceValuesToDoubleTask) countedCompleterFirstComplete;
                MapReduceValuesToDoubleTask<K, V> mapReduceValuesToDoubleTask3 = mapReduceValuesToDoubleTask2.rights;
                while (mapReduceValuesToDoubleTask3 != null) {
                    mapReduceValuesToDoubleTask2.result = doubleByDoubleToDouble.apply(mapReduceValuesToDoubleTask2.result, mapReduceValuesToDoubleTask3.result);
                    mapReduceValuesToDoubleTask3 = mapReduceValuesToDoubleTask3.nextRight;
                    mapReduceValuesToDoubleTask2.rights = mapReduceValuesToDoubleTask3;
                }
            }
        }
    }

    static final class MapReduceEntriesToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceEntriesToDoubleTask<K, V> nextRight;
        final DoubleByDoubleToDouble reducer;
        double result;
        MapReduceEntriesToDoubleTask<K, V> rights;
        final ObjectToDouble<Map.Entry<K, V>> transformer;

        MapReduceEntriesToDoubleTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceEntriesToDoubleTask<K, V> mapReduceEntriesToDoubleTask, ObjectToDouble<Map.Entry<K, V>> objectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceEntriesToDoubleTask;
            this.transformer = objectToDouble;
            this.basis = d;
            this.reducer = doubleByDoubleToDouble;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            DoubleByDoubleToDouble doubleByDoubleToDouble;
            ObjectToDouble<Map.Entry<K, V>> objectToDouble = this.transformer;
            if (objectToDouble == null || (doubleByDoubleToDouble = this.reducer) == null) {
                return;
            }
            double dApply = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceEntriesToDoubleTask<K, V> mapReduceEntriesToDoubleTask = new MapReduceEntriesToDoubleTask<>(this, i4, i3, i2, this.tab, this.rights, objectToDouble, dApply, doubleByDoubleToDouble);
                this.rights = mapReduceEntriesToDoubleTask;
                mapReduceEntriesToDoubleTask.fork();
                objectToDouble = objectToDouble;
                i = i;
            }
            ObjectToDouble<Map.Entry<K, V>> objectToDouble2 = objectToDouble;
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                } else {
                    dApply = doubleByDoubleToDouble.apply(dApply, objectToDouble2.apply(nodeAdvance));
                }
            }
            this.result = dApply;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceEntriesToDoubleTask mapReduceEntriesToDoubleTask2 = (MapReduceEntriesToDoubleTask) countedCompleterFirstComplete;
                MapReduceEntriesToDoubleTask<K, V> mapReduceEntriesToDoubleTask3 = mapReduceEntriesToDoubleTask2.rights;
                while (mapReduceEntriesToDoubleTask3 != null) {
                    mapReduceEntriesToDoubleTask2.result = doubleByDoubleToDouble.apply(mapReduceEntriesToDoubleTask2.result, mapReduceEntriesToDoubleTask3.result);
                    mapReduceEntriesToDoubleTask3 = mapReduceEntriesToDoubleTask3.nextRight;
                    mapReduceEntriesToDoubleTask2.rights = mapReduceEntriesToDoubleTask3;
                }
            }
        }
    }

    static final class MapReduceMappingsToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceMappingsToDoubleTask<K, V> nextRight;
        final DoubleByDoubleToDouble reducer;
        double result;
        MapReduceMappingsToDoubleTask<K, V> rights;
        final ObjectByObjectToDouble<? super K, ? super V> transformer;

        MapReduceMappingsToDoubleTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceMappingsToDoubleTask<K, V> mapReduceMappingsToDoubleTask, ObjectByObjectToDouble<? super K, ? super V> objectByObjectToDouble, double d, DoubleByDoubleToDouble doubleByDoubleToDouble) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceMappingsToDoubleTask;
            this.transformer = objectByObjectToDouble;
            this.basis = d;
            this.reducer = doubleByDoubleToDouble;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            DoubleByDoubleToDouble doubleByDoubleToDouble;
            ObjectByObjectToDouble<? super K, ? super V> objectByObjectToDouble = this.transformer;
            if (objectByObjectToDouble == null || (doubleByDoubleToDouble = this.reducer) == null) {
                return;
            }
            double dApply = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceMappingsToDoubleTask<K, V> mapReduceMappingsToDoubleTask = new MapReduceMappingsToDoubleTask<>(this, i4, i3, i2, this.tab, this.rights, objectByObjectToDouble, dApply, doubleByDoubleToDouble);
                this.rights = mapReduceMappingsToDoubleTask;
                mapReduceMappingsToDoubleTask.fork();
                objectByObjectToDouble = objectByObjectToDouble;
                i = i;
            }
            ObjectByObjectToDouble<? super K, ? super V> objectByObjectToDouble2 = objectByObjectToDouble;
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                } else {
                    dApply = doubleByDoubleToDouble.apply(dApply, objectByObjectToDouble2.apply(nodeAdvance.key, nodeAdvance.val));
                }
            }
            this.result = dApply;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceMappingsToDoubleTask mapReduceMappingsToDoubleTask2 = (MapReduceMappingsToDoubleTask) countedCompleterFirstComplete;
                MapReduceMappingsToDoubleTask<K, V> mapReduceMappingsToDoubleTask3 = mapReduceMappingsToDoubleTask2.rights;
                while (mapReduceMappingsToDoubleTask3 != null) {
                    mapReduceMappingsToDoubleTask2.result = doubleByDoubleToDouble.apply(mapReduceMappingsToDoubleTask2.result, mapReduceMappingsToDoubleTask3.result);
                    mapReduceMappingsToDoubleTask3 = mapReduceMappingsToDoubleTask3.nextRight;
                    mapReduceMappingsToDoubleTask2.rights = mapReduceMappingsToDoubleTask3;
                }
            }
        }
    }

    static final class MapReduceKeysToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceKeysToLongTask<K, V> nextRight;
        final LongByLongToLong reducer;
        long result;
        MapReduceKeysToLongTask<K, V> rights;
        final ObjectToLong<? super K> transformer;

        MapReduceKeysToLongTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceKeysToLongTask<K, V> mapReduceKeysToLongTask, ObjectToLong<? super K> objectToLong, long j, LongByLongToLong longByLongToLong) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceKeysToLongTask;
            this.transformer = objectToLong;
            this.basis = j;
            this.reducer = longByLongToLong;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            LongByLongToLong longByLongToLong;
            ObjectToLong<? super K> objectToLong = this.transformer;
            if (objectToLong == null || (longByLongToLong = this.reducer) == null) {
                return;
            }
            long jApply = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceKeysToLongTask<K, V> mapReduceKeysToLongTask = new MapReduceKeysToLongTask<>(this, i4, i3, i2, this.tab, this.rights, objectToLong, jApply, longByLongToLong);
                this.rights = mapReduceKeysToLongTask;
                mapReduceKeysToLongTask.fork();
                objectToLong = objectToLong;
                i = i;
            }
            ObjectToLong<? super K> objectToLong2 = objectToLong;
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                } else {
                    jApply = longByLongToLong.apply(jApply, objectToLong2.apply(nodeAdvance.key));
                }
            }
            this.result = jApply;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceKeysToLongTask mapReduceKeysToLongTask2 = (MapReduceKeysToLongTask) countedCompleterFirstComplete;
                MapReduceKeysToLongTask<K, V> mapReduceKeysToLongTask3 = mapReduceKeysToLongTask2.rights;
                while (mapReduceKeysToLongTask3 != null) {
                    mapReduceKeysToLongTask2.result = longByLongToLong.apply(mapReduceKeysToLongTask2.result, mapReduceKeysToLongTask3.result);
                    mapReduceKeysToLongTask3 = mapReduceKeysToLongTask3.nextRight;
                    mapReduceKeysToLongTask2.rights = mapReduceKeysToLongTask3;
                }
            }
        }
    }

    static final class MapReduceValuesToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceValuesToLongTask<K, V> nextRight;
        final LongByLongToLong reducer;
        long result;
        MapReduceValuesToLongTask<K, V> rights;
        final ObjectToLong<? super V> transformer;

        MapReduceValuesToLongTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceValuesToLongTask<K, V> mapReduceValuesToLongTask, ObjectToLong<? super V> objectToLong, long j, LongByLongToLong longByLongToLong) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceValuesToLongTask;
            this.transformer = objectToLong;
            this.basis = j;
            this.reducer = longByLongToLong;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            LongByLongToLong longByLongToLong;
            ObjectToLong<? super V> objectToLong = this.transformer;
            if (objectToLong == null || (longByLongToLong = this.reducer) == null) {
                return;
            }
            long jApply = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceValuesToLongTask<K, V> mapReduceValuesToLongTask = new MapReduceValuesToLongTask<>(this, i4, i3, i2, this.tab, this.rights, objectToLong, jApply, longByLongToLong);
                this.rights = mapReduceValuesToLongTask;
                mapReduceValuesToLongTask.fork();
                objectToLong = objectToLong;
                i = i;
            }
            ObjectToLong<? super V> objectToLong2 = objectToLong;
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                } else {
                    jApply = longByLongToLong.apply(jApply, objectToLong2.apply(nodeAdvance.val));
                }
            }
            this.result = jApply;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceValuesToLongTask mapReduceValuesToLongTask2 = (MapReduceValuesToLongTask) countedCompleterFirstComplete;
                MapReduceValuesToLongTask<K, V> mapReduceValuesToLongTask3 = mapReduceValuesToLongTask2.rights;
                while (mapReduceValuesToLongTask3 != null) {
                    mapReduceValuesToLongTask2.result = longByLongToLong.apply(mapReduceValuesToLongTask2.result, mapReduceValuesToLongTask3.result);
                    mapReduceValuesToLongTask3 = mapReduceValuesToLongTask3.nextRight;
                    mapReduceValuesToLongTask2.rights = mapReduceValuesToLongTask3;
                }
            }
        }
    }

    static final class MapReduceEntriesToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceEntriesToLongTask<K, V> nextRight;
        final LongByLongToLong reducer;
        long result;
        MapReduceEntriesToLongTask<K, V> rights;
        final ObjectToLong<Map.Entry<K, V>> transformer;

        MapReduceEntriesToLongTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceEntriesToLongTask<K, V> mapReduceEntriesToLongTask, ObjectToLong<Map.Entry<K, V>> objectToLong, long j, LongByLongToLong longByLongToLong) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceEntriesToLongTask;
            this.transformer = objectToLong;
            this.basis = j;
            this.reducer = longByLongToLong;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            LongByLongToLong longByLongToLong;
            ObjectToLong<Map.Entry<K, V>> objectToLong = this.transformer;
            if (objectToLong == null || (longByLongToLong = this.reducer) == null) {
                return;
            }
            long jApply = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceEntriesToLongTask<K, V> mapReduceEntriesToLongTask = new MapReduceEntriesToLongTask<>(this, i4, i3, i2, this.tab, this.rights, objectToLong, jApply, longByLongToLong);
                this.rights = mapReduceEntriesToLongTask;
                mapReduceEntriesToLongTask.fork();
                objectToLong = objectToLong;
                i = i;
            }
            ObjectToLong<Map.Entry<K, V>> objectToLong2 = objectToLong;
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                } else {
                    jApply = longByLongToLong.apply(jApply, objectToLong2.apply(nodeAdvance));
                }
            }
            this.result = jApply;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceEntriesToLongTask mapReduceEntriesToLongTask2 = (MapReduceEntriesToLongTask) countedCompleterFirstComplete;
                MapReduceEntriesToLongTask<K, V> mapReduceEntriesToLongTask3 = mapReduceEntriesToLongTask2.rights;
                while (mapReduceEntriesToLongTask3 != null) {
                    mapReduceEntriesToLongTask2.result = longByLongToLong.apply(mapReduceEntriesToLongTask2.result, mapReduceEntriesToLongTask3.result);
                    mapReduceEntriesToLongTask3 = mapReduceEntriesToLongTask3.nextRight;
                    mapReduceEntriesToLongTask2.rights = mapReduceEntriesToLongTask3;
                }
            }
        }
    }

    static final class MapReduceMappingsToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceMappingsToLongTask<K, V> nextRight;
        final LongByLongToLong reducer;
        long result;
        MapReduceMappingsToLongTask<K, V> rights;
        final ObjectByObjectToLong<? super K, ? super V> transformer;

        MapReduceMappingsToLongTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceMappingsToLongTask<K, V> mapReduceMappingsToLongTask, ObjectByObjectToLong<? super K, ? super V> objectByObjectToLong, long j, LongByLongToLong longByLongToLong) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceMappingsToLongTask;
            this.transformer = objectByObjectToLong;
            this.basis = j;
            this.reducer = longByLongToLong;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            LongByLongToLong longByLongToLong;
            ObjectByObjectToLong<? super K, ? super V> objectByObjectToLong = this.transformer;
            if (objectByObjectToLong == null || (longByLongToLong = this.reducer) == null) {
                return;
            }
            long jApply = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceMappingsToLongTask<K, V> mapReduceMappingsToLongTask = new MapReduceMappingsToLongTask<>(this, i4, i3, i2, this.tab, this.rights, objectByObjectToLong, jApply, longByLongToLong);
                this.rights = mapReduceMappingsToLongTask;
                mapReduceMappingsToLongTask.fork();
                objectByObjectToLong = objectByObjectToLong;
                i = i;
            }
            ObjectByObjectToLong<? super K, ? super V> objectByObjectToLong2 = objectByObjectToLong;
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                } else {
                    jApply = longByLongToLong.apply(jApply, objectByObjectToLong2.apply(nodeAdvance.key, nodeAdvance.val));
                }
            }
            this.result = jApply;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceMappingsToLongTask mapReduceMappingsToLongTask2 = (MapReduceMappingsToLongTask) countedCompleterFirstComplete;
                MapReduceMappingsToLongTask<K, V> mapReduceMappingsToLongTask3 = mapReduceMappingsToLongTask2.rights;
                while (mapReduceMappingsToLongTask3 != null) {
                    mapReduceMappingsToLongTask2.result = longByLongToLong.apply(mapReduceMappingsToLongTask2.result, mapReduceMappingsToLongTask3.result);
                    mapReduceMappingsToLongTask3 = mapReduceMappingsToLongTask3.nextRight;
                    mapReduceMappingsToLongTask2.rights = mapReduceMappingsToLongTask3;
                }
            }
        }
    }

    static final class MapReduceKeysToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceKeysToIntTask<K, V> nextRight;
        final IntByIntToInt reducer;
        int result;
        MapReduceKeysToIntTask<K, V> rights;
        final ObjectToInt<? super K> transformer;

        MapReduceKeysToIntTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceKeysToIntTask<K, V> mapReduceKeysToIntTask, ObjectToInt<? super K> objectToInt, int i4, IntByIntToInt intByIntToInt) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceKeysToIntTask;
            this.transformer = objectToInt;
            this.basis = i4;
            this.reducer = intByIntToInt;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            IntByIntToInt intByIntToInt;
            ObjectToInt<? super K> objectToInt = this.transformer;
            if (objectToInt == null || (intByIntToInt = this.reducer) == null) {
                return;
            }
            int iApply = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceKeysToIntTask<K, V> mapReduceKeysToIntTask = new MapReduceKeysToIntTask<>(this, i4, i3, i2, this.tab, this.rights, objectToInt, iApply, intByIntToInt);
                this.rights = mapReduceKeysToIntTask;
                mapReduceKeysToIntTask.fork();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                } else {
                    iApply = intByIntToInt.apply(iApply, objectToInt.apply(nodeAdvance.key));
                }
            }
            this.result = iApply;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceKeysToIntTask mapReduceKeysToIntTask2 = (MapReduceKeysToIntTask) countedCompleterFirstComplete;
                MapReduceKeysToIntTask<K, V> mapReduceKeysToIntTask3 = mapReduceKeysToIntTask2.rights;
                while (mapReduceKeysToIntTask3 != null) {
                    mapReduceKeysToIntTask2.result = intByIntToInt.apply(mapReduceKeysToIntTask2.result, mapReduceKeysToIntTask3.result);
                    mapReduceKeysToIntTask3 = mapReduceKeysToIntTask3.nextRight;
                    mapReduceKeysToIntTask2.rights = mapReduceKeysToIntTask3;
                }
            }
        }
    }

    static final class MapReduceValuesToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceValuesToIntTask<K, V> nextRight;
        final IntByIntToInt reducer;
        int result;
        MapReduceValuesToIntTask<K, V> rights;
        final ObjectToInt<? super V> transformer;

        MapReduceValuesToIntTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceValuesToIntTask<K, V> mapReduceValuesToIntTask, ObjectToInt<? super V> objectToInt, int i4, IntByIntToInt intByIntToInt) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceValuesToIntTask;
            this.transformer = objectToInt;
            this.basis = i4;
            this.reducer = intByIntToInt;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            IntByIntToInt intByIntToInt;
            ObjectToInt<? super V> objectToInt = this.transformer;
            if (objectToInt == null || (intByIntToInt = this.reducer) == null) {
                return;
            }
            int iApply = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceValuesToIntTask<K, V> mapReduceValuesToIntTask = new MapReduceValuesToIntTask<>(this, i4, i3, i2, this.tab, this.rights, objectToInt, iApply, intByIntToInt);
                this.rights = mapReduceValuesToIntTask;
                mapReduceValuesToIntTask.fork();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                } else {
                    iApply = intByIntToInt.apply(iApply, objectToInt.apply(nodeAdvance.val));
                }
            }
            this.result = iApply;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceValuesToIntTask mapReduceValuesToIntTask2 = (MapReduceValuesToIntTask) countedCompleterFirstComplete;
                MapReduceValuesToIntTask<K, V> mapReduceValuesToIntTask3 = mapReduceValuesToIntTask2.rights;
                while (mapReduceValuesToIntTask3 != null) {
                    mapReduceValuesToIntTask2.result = intByIntToInt.apply(mapReduceValuesToIntTask2.result, mapReduceValuesToIntTask3.result);
                    mapReduceValuesToIntTask3 = mapReduceValuesToIntTask3.nextRight;
                    mapReduceValuesToIntTask2.rights = mapReduceValuesToIntTask3;
                }
            }
        }
    }

    static final class MapReduceEntriesToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceEntriesToIntTask<K, V> nextRight;
        final IntByIntToInt reducer;
        int result;
        MapReduceEntriesToIntTask<K, V> rights;
        final ObjectToInt<Map.Entry<K, V>> transformer;

        MapReduceEntriesToIntTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceEntriesToIntTask<K, V> mapReduceEntriesToIntTask, ObjectToInt<Map.Entry<K, V>> objectToInt, int i4, IntByIntToInt intByIntToInt) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceEntriesToIntTask;
            this.transformer = objectToInt;
            this.basis = i4;
            this.reducer = intByIntToInt;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            IntByIntToInt intByIntToInt;
            ObjectToInt<Map.Entry<K, V>> objectToInt = this.transformer;
            if (objectToInt == null || (intByIntToInt = this.reducer) == null) {
                return;
            }
            int iApply = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceEntriesToIntTask<K, V> mapReduceEntriesToIntTask = new MapReduceEntriesToIntTask<>(this, i4, i3, i2, this.tab, this.rights, objectToInt, iApply, intByIntToInt);
                this.rights = mapReduceEntriesToIntTask;
                mapReduceEntriesToIntTask.fork();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                } else {
                    iApply = intByIntToInt.apply(iApply, objectToInt.apply(nodeAdvance));
                }
            }
            this.result = iApply;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceEntriesToIntTask mapReduceEntriesToIntTask2 = (MapReduceEntriesToIntTask) countedCompleterFirstComplete;
                MapReduceEntriesToIntTask<K, V> mapReduceEntriesToIntTask3 = mapReduceEntriesToIntTask2.rights;
                while (mapReduceEntriesToIntTask3 != null) {
                    mapReduceEntriesToIntTask2.result = intByIntToInt.apply(mapReduceEntriesToIntTask2.result, mapReduceEntriesToIntTask3.result);
                    mapReduceEntriesToIntTask3 = mapReduceEntriesToIntTask3.nextRight;
                    mapReduceEntriesToIntTask2.rights = mapReduceEntriesToIntTask3;
                }
            }
        }
    }

    static final class MapReduceMappingsToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceMappingsToIntTask<K, V> nextRight;
        final IntByIntToInt reducer;
        int result;
        MapReduceMappingsToIntTask<K, V> rights;
        final ObjectByObjectToInt<? super K, ? super V> transformer;

        MapReduceMappingsToIntTask(BulkTask<K, V, ?> bulkTask, int i, int i2, int i3, Node<K, V>[] nodeArr, MapReduceMappingsToIntTask<K, V> mapReduceMappingsToIntTask, ObjectByObjectToInt<? super K, ? super V> objectByObjectToInt, int i4, IntByIntToInt intByIntToInt) {
            super(bulkTask, i, i2, i3, nodeArr);
            this.nextRight = mapReduceMappingsToIntTask;
            this.transformer = objectByObjectToInt;
            this.basis = i4;
            this.reducer = intByIntToInt;
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter, io.netty.util.internal.chmv8.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        @Override // io.netty.util.internal.chmv8.CountedCompleter
        public final void compute() {
            IntByIntToInt intByIntToInt;
            ObjectByObjectToInt<? super K, ? super V> objectByObjectToInt = this.transformer;
            if (objectByObjectToInt == null || (intByIntToInt = this.reducer) == null) {
                return;
            }
            int iApply = this.basis;
            int i = this.baseIndex;
            while (this.batch > 0) {
                int i2 = this.baseLimit;
                int i3 = (i2 + i) >>> 1;
                if (i3 <= i) {
                    break;
                }
                addToPendingCount(1);
                int i4 = this.batch >>> 1;
                this.batch = i4;
                this.baseLimit = i3;
                MapReduceMappingsToIntTask<K, V> mapReduceMappingsToIntTask = new MapReduceMappingsToIntTask<>(this, i4, i3, i2, this.tab, this.rights, objectByObjectToInt, iApply, intByIntToInt);
                this.rights = mapReduceMappingsToIntTask;
                mapReduceMappingsToIntTask.fork();
            }
            while (true) {
                Node<K, V> nodeAdvance = advance();
                if (nodeAdvance == null) {
                    break;
                } else {
                    iApply = intByIntToInt.apply(iApply, objectByObjectToInt.apply(nodeAdvance.key, nodeAdvance.val));
                }
            }
            this.result = iApply;
            for (CountedCompleter<?> countedCompleterFirstComplete = firstComplete(); countedCompleterFirstComplete != null; countedCompleterFirstComplete = countedCompleterFirstComplete.nextComplete()) {
                MapReduceMappingsToIntTask mapReduceMappingsToIntTask2 = (MapReduceMappingsToIntTask) countedCompleterFirstComplete;
                MapReduceMappingsToIntTask<K, V> mapReduceMappingsToIntTask3 = mapReduceMappingsToIntTask2.rights;
                while (mapReduceMappingsToIntTask3 != null) {
                    mapReduceMappingsToIntTask2.result = intByIntToInt.apply(mapReduceMappingsToIntTask2.result, mapReduceMappingsToIntTask3.result);
                    mapReduceMappingsToIntTask3 = mapReduceMappingsToIntTask3.nextRight;
                    mapReduceMappingsToIntTask2.rights = mapReduceMappingsToIntTask3;
                }
            }
        }
    }

    static final class CounterCell {
        volatile long p0;
        volatile long p1;
        volatile long p2;
        volatile long p3;
        volatile long p4;
        volatile long p5;
        volatile long p6;
        volatile long q0;
        volatile long q1;
        volatile long q2;
        volatile long q3;
        volatile long q4;
        volatile long q5;
        volatile long q6;
        volatile long value;

        CounterCell(long j) {
            this.value = j;
        }
    }

    static final class CounterHashCode {
        int code;

        CounterHashCode() {
        }
    }

    final long sumCount() {
        CounterCell[] counterCellArr = this.counterCells;
        long j = this.baseCount;
        if (counterCellArr != null) {
            for (CounterCell counterCell : counterCellArr) {
                if (counterCell != null) {
                    j += counterCell.value;
                }
            }
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ab, code lost:
    
        if (r25.counterCells != r7) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ad, code lost:
    
        r1 = new io.netty.util.internal.chmv8.ConcurrentHashMapV8.CounterCell[r8 << 1];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b2, code lost:
    
        if (r2 >= r8) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b4, code lost:
    
        r1[r2] = r7[r2];
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bb, code lost:
    
        r25.counterCells = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x002a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0118 A[EDGE_INSN: B:93:0x0118->B:85:0x0118 BREAK  A[LOOP:0: B:10:0x0028->B:60:0x00bd, LOOP_LABEL: LOOP:0: B:10:0x0028->B:60:0x00bd], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void fullAddCount(io.netty.util.internal.InternalThreadLocalMap r26, long r27, io.netty.util.internal.IntegerHolder r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ConcurrentHashMapV8.fullAddCount(io.netty.util.internal.InternalThreadLocalMap, long, io.netty.util.internal.IntegerHolder, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: io.netty.util.internal.chmv8.ConcurrentHashMapV8.1
                    @Override // java.security.PrivilegedExceptionAction
                    public final Unsafe run() throws IllegalAccessException, IllegalArgumentException {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
        } catch (PrivilegedActionException e) {
            throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }
    }
}
