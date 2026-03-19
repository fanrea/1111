package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    protected SerializeBeanInfo beanInfo;
    protected final FieldSerializer[] getters;
    private volatile transient long[] hashArray;
    private volatile transient short[] hashArrayMapping;
    protected final FieldSerializer[] sortedGetters;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    static Map<String, String> createAliasMap(String... strArr) {
        HashMap map = new HashMap();
        for (String str : strArr) {
            map.put(str, str);
        }
        return map;
    }

    public Class<?> getType() {
        return this.beanInfo.beanType;
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        boolean z;
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i = 0;
        while (true) {
            FieldSerializer[] fieldSerializerArr = this.sortedGetters;
            if (i >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i]);
            i++;
        }
        if (serializeBeanInfo.fields == serializeBeanInfo.sortedFields) {
            this.getters = this.sortedGetters;
        } else {
            this.getters = new FieldSerializer[serializeBeanInfo.fields.length];
            int i2 = 0;
            while (true) {
                if (i2 >= this.getters.length) {
                    z = false;
                    break;
                }
                FieldSerializer fieldSerializer = getFieldSerializer(serializeBeanInfo.fields[i2].name);
                if (fieldSerializer == null) {
                    z = true;
                    break;
                } else {
                    this.getters[i2] = fieldSerializer;
                    i2++;
                }
            }
            if (z) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                System.arraycopy(fieldSerializerArr2, 0, this.getters, 0, fieldSerializerArr2.length);
            }
        }
        if (serializeBeanInfo.jsonType != null) {
            for (Class<? extends SerializeFilter> cls : serializeBeanInfo.jsonType.serialzeFilters()) {
                try {
                    addFilter(cls.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                }
            }
        }
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public void writeNoneASM(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0159 A[PHI: r25
  0x0159: PHI (r25v12 com.alibaba.fastjson.serializer.FieldSerializer) = 
  (r25v7 com.alibaba.fastjson.serializer.FieldSerializer)
  (r25v9 com.alibaba.fastjson.serializer.FieldSerializer)
  (r25v7 com.alibaba.fastjson.serializer.FieldSerializer)
  (r25v7 com.alibaba.fastjson.serializer.FieldSerializer)
  (r25v7 com.alibaba.fastjson.serializer.FieldSerializer)
 binds: [B:88:0x0122, B:107:0x0157, B:95:0x0139, B:80:0x010e, B:75:0x0103] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0367 A[Catch: Exception -> 0x049e, all -> 0x04fc, TryCatch #7 {Exception -> 0x049e, blocks: (B:118:0x019d, B:121:0x01a5, B:123:0x01b1, B:125:0x01c0, B:127:0x01ca, B:130:0x01d4, B:132:0x01df, B:134:0x01e3, B:137:0x01ea, B:139:0x01ee, B:140:0x01f4, B:142:0x01f9, B:144:0x0200, B:147:0x020a, B:149:0x0215, B:151:0x0219, B:154:0x0220, B:157:0x0227, B:159:0x022c, B:162:0x0234, B:164:0x023c, B:166:0x0247, B:168:0x024b, B:171:0x0252, B:173:0x0256, B:174:0x025b, B:176:0x0260, B:178:0x0267, B:179:0x026c, B:181:0x0274, B:183:0x027f, B:185:0x0283, B:188:0x028a, B:190:0x028e, B:191:0x0293, B:193:0x0298, B:195:0x029f, B:197:0x02a6, B:199:0x02aa, B:201:0x02b4, B:205:0x02bf, B:207:0x02c3, B:209:0x02cc, B:211:0x02d7, B:213:0x02dd, B:215:0x02e1, B:218:0x02ec, B:220:0x02f0, B:222:0x02f4, B:225:0x02ff, B:227:0x0303, B:229:0x0307, B:232:0x0312, B:234:0x0316, B:236:0x031a, B:239:0x0328, B:241:0x032c, B:243:0x0330, B:246:0x033d, B:248:0x0341, B:250:0x0345, B:253:0x0353, B:255:0x0357, B:257:0x035b, B:261:0x0367, B:263:0x036b, B:265:0x036f, B:268:0x037d, B:270:0x0388, B:274:0x0391, B:276:0x0397, B:333:0x0464, B:335:0x0468, B:337:0x046c, B:340:0x0476, B:342:0x047e, B:343:0x0486, B:345:0x048c, B:281:0x03a5, B:282:0x03a8, B:284:0x03ae, B:286:0x03ba, B:293:0x03d0, B:298:0x03da, B:302:0x03ef, B:305:0x03f9, B:308:0x0403, B:310:0x040b, B:311:0x0418, B:313:0x0421, B:315:0x0428, B:316:0x042c, B:318:0x0433, B:319:0x0437, B:320:0x043b, B:322:0x0440, B:323:0x0444, B:324:0x0448, B:326:0x044c, B:328:0x0450, B:331:0x045d, B:332:0x0461, B:299:0x03e5), top: B:441:0x019d }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0468 A[Catch: Exception -> 0x049e, all -> 0x04fc, TryCatch #7 {Exception -> 0x049e, blocks: (B:118:0x019d, B:121:0x01a5, B:123:0x01b1, B:125:0x01c0, B:127:0x01ca, B:130:0x01d4, B:132:0x01df, B:134:0x01e3, B:137:0x01ea, B:139:0x01ee, B:140:0x01f4, B:142:0x01f9, B:144:0x0200, B:147:0x020a, B:149:0x0215, B:151:0x0219, B:154:0x0220, B:157:0x0227, B:159:0x022c, B:162:0x0234, B:164:0x023c, B:166:0x0247, B:168:0x024b, B:171:0x0252, B:173:0x0256, B:174:0x025b, B:176:0x0260, B:178:0x0267, B:179:0x026c, B:181:0x0274, B:183:0x027f, B:185:0x0283, B:188:0x028a, B:190:0x028e, B:191:0x0293, B:193:0x0298, B:195:0x029f, B:197:0x02a6, B:199:0x02aa, B:201:0x02b4, B:205:0x02bf, B:207:0x02c3, B:209:0x02cc, B:211:0x02d7, B:213:0x02dd, B:215:0x02e1, B:218:0x02ec, B:220:0x02f0, B:222:0x02f4, B:225:0x02ff, B:227:0x0303, B:229:0x0307, B:232:0x0312, B:234:0x0316, B:236:0x031a, B:239:0x0328, B:241:0x032c, B:243:0x0330, B:246:0x033d, B:248:0x0341, B:250:0x0345, B:253:0x0353, B:255:0x0357, B:257:0x035b, B:261:0x0367, B:263:0x036b, B:265:0x036f, B:268:0x037d, B:270:0x0388, B:274:0x0391, B:276:0x0397, B:333:0x0464, B:335:0x0468, B:337:0x046c, B:340:0x0476, B:342:0x047e, B:343:0x0486, B:345:0x048c, B:281:0x03a5, B:282:0x03a8, B:284:0x03ae, B:286:0x03ba, B:293:0x03d0, B:298:0x03da, B:302:0x03ef, B:305:0x03f9, B:308:0x0403, B:310:0x040b, B:311:0x0418, B:313:0x0421, B:315:0x0428, B:316:0x042c, B:318:0x0433, B:319:0x0437, B:320:0x043b, B:322:0x0440, B:323:0x0444, B:324:0x0448, B:326:0x044c, B:328:0x0450, B:331:0x045d, B:332:0x0461, B:299:0x03e5), top: B:441:0x019d }] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x055b A[Catch: all -> 0x05e8, TRY_ENTER, TryCatch #6 {all -> 0x05e8, blocks: (B:402:0x0536, B:405:0x055b, B:413:0x05b4, B:415:0x05ba, B:416:0x05d5, B:418:0x05d9, B:422:0x05e2, B:423:0x05e7, B:407:0x0573, B:409:0x0577, B:411:0x057d, B:412:0x059b), top: B:439:0x0536 }] */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x05ba A[Catch: all -> 0x05e8, TryCatch #6 {all -> 0x05e8, blocks: (B:402:0x0536, B:405:0x055b, B:413:0x05b4, B:415:0x05ba, B:416:0x05d5, B:418:0x05d9, B:422:0x05e2, B:423:0x05e7, B:407:0x0573, B:409:0x0577, B:411:0x057d, B:412:0x059b), top: B:439:0x0536 }] */
    /* JADX WARN: Removed duplicated region for block: B:418:0x05d9 A[Catch: all -> 0x05e8, TryCatch #6 {all -> 0x05e8, blocks: (B:402:0x0536, B:405:0x055b, B:413:0x05b4, B:415:0x05ba, B:416:0x05d5, B:418:0x05d9, B:422:0x05e2, B:423:0x05e7, B:407:0x0573, B:409:0x0577, B:411:0x057d, B:412:0x059b), top: B:439:0x0536 }] */
    /* JADX WARN: Removed duplicated region for block: B:420:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x0536 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:459:0x04b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void write(com.alibaba.fastjson.serializer.JSONSerializer r34, java.lang.Object r35, java.lang.Object r36, java.lang.reflect.Type r37, int r38, boolean r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    protected void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        String name = this.beanInfo.typeName;
        if (name == null) {
            Class<?> superclass = obj.getClass();
            if (TypeUtils.isProxy(superclass)) {
                superclass = superclass.getSuperclass();
            }
            name = superclass.getName();
        }
        jSONSerializer.write(name);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i) {
        SerialContext serialContext = jSONSerializer.context;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext == null || (serialContext.features & i2) != 0 || (i & i2) != 0 || jSONSerializer.references == null || !jSONSerializer.references.containsKey(obj)) {
            return false;
        }
        jSONSerializer.writeReference(obj);
        return true;
    }

    protected boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    protected boolean isWriteAsArray(JSONSerializer jSONSerializer, int i) {
        int i2 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i2) == 0 && !jSONSerializer.out.beanToArray && (i & i2) == 0) ? false : true;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer == null) {
            throw new JSONException("field not found. " + str);
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e) {
            throw new JSONException("getFieldValue error." + str, e);
        } catch (InvocationTargetException e2) {
            throw new JSONException("getFieldValue error." + str, e2);
        }
    }

    public Object getFieldValue(Object obj, String str, long j, boolean z) {
        FieldSerializer fieldSerializer = getFieldSerializer(j);
        if (fieldSerializer == null) {
            if (z) {
                throw new JSONException("field not found. " + str);
            }
            return null;
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e) {
            throw new JSONException("getFieldValue error." + str, e);
        } catch (InvocationTargetException e2) {
            throw new JSONException("getFieldValue error." + str, e2);
        }
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.sortedGetters.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int iCompareTo = this.sortedGetters[i2].fieldInfo.name.compareTo(str);
            if (iCompareTo < 0) {
                i = i2 + 1;
            } else {
                if (iCompareTo <= 0) {
                    return this.sortedGetters[i2];
                }
                length = i2 - 1;
            }
        }
        return null;
    }

    public FieldSerializer getFieldSerializer(long j) {
        PropertyNamingStrategy[] propertyNamingStrategyArrValues;
        int iBinarySearch;
        if (this.hashArray == null) {
            propertyNamingStrategyArrValues = PropertyNamingStrategy.values();
            long[] jArr = new long[this.sortedGetters.length * propertyNamingStrategyArrValues.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr = this.sortedGetters;
                if (i >= fieldSerializerArr.length) {
                    break;
                }
                String str = fieldSerializerArr[i].fieldInfo.name;
                jArr[i2] = TypeUtils.fnv1a_64(str);
                i2++;
                for (PropertyNamingStrategy propertyNamingStrategy : propertyNamingStrategyArrValues) {
                    String strTranslate = propertyNamingStrategy.translate(str);
                    if (!str.equals(strTranslate)) {
                        jArr[i2] = TypeUtils.fnv1a_64(strTranslate);
                        i2++;
                    }
                }
                i++;
            }
            Arrays.sort(jArr, 0, i2);
            this.hashArray = new long[i2];
            System.arraycopy(jArr, 0, this.hashArray, 0, i2);
        } else {
            propertyNamingStrategyArrValues = null;
        }
        int iBinarySearch2 = Arrays.binarySearch(this.hashArray, j);
        if (iBinarySearch2 < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            if (propertyNamingStrategyArrValues == null) {
                propertyNamingStrategyArrValues = PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            int i3 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                if (i3 >= fieldSerializerArr2.length) {
                    break;
                }
                String str2 = fieldSerializerArr2[i3].fieldInfo.name;
                int iBinarySearch3 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(str2));
                if (iBinarySearch3 >= 0) {
                    sArr[iBinarySearch3] = (short) i3;
                }
                for (PropertyNamingStrategy propertyNamingStrategy2 : propertyNamingStrategyArrValues) {
                    String strTranslate2 = propertyNamingStrategy2.translate(str2);
                    if (!str2.equals(strTranslate2) && (iBinarySearch = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(strTranslate2))) >= 0) {
                        sArr[iBinarySearch] = (short) i3;
                    }
                }
                i3++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[iBinarySearch2];
        if (s != -1) {
            return this.sortedGetters[s];
        }
        return null;
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i = 0;
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                i++;
            }
        }
        return i;
    }

    public Set<String> getFieldNames(Object obj) throws Exception {
        HashSet hashSet = new HashSet();
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                hashSet.add(fieldSerializer.fieldInfo.name);
            }
        }
        return hashSet;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            boolean zIsEnabled = SerializerFeature.isEnabled(fieldSerializer.features, SerializerFeature.SkipTransientField);
            FieldInfo fieldInfo = fieldSerializer.fieldInfo;
            if (!zIsEnabled || fieldInfo == null || !fieldInfo.fieldTransient) {
                if (fieldSerializer.fieldInfo.unwrapped) {
                    Object json = JSON.toJSON(fieldSerializer.getPropertyValue(obj));
                    if (json instanceof Map) {
                        linkedHashMap.putAll((Map) json);
                    } else {
                        linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                    }
                } else {
                    linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                }
            }
        }
        return linkedHashMap;
    }

    protected BeanContext getBeanContext(int i) {
        return this.sortedGetters[i].fieldContext;
    }

    protected Type getFieldType(int i) {
        return this.sortedGetters[i].fieldInfo.fieldType;
    }

    protected char writeBefore(JSONSerializer jSONSerializer, Object obj, char c) {
        if (jSONSerializer.beforeFilters != null) {
            Iterator<BeforeFilter> it = jSONSerializer.beforeFilters.iterator();
            while (it.hasNext()) {
                c = it.next().writeBefore(jSONSerializer, obj, c);
            }
        }
        if (this.beforeFilters != null) {
            Iterator<BeforeFilter> it2 = this.beforeFilters.iterator();
            while (it2.hasNext()) {
                c = it2.next().writeBefore(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    protected char writeAfter(JSONSerializer jSONSerializer, Object obj, char c) {
        if (jSONSerializer.afterFilters != null) {
            Iterator<AfterFilter> it = jSONSerializer.afterFilters.iterator();
            while (it.hasNext()) {
                c = it.next().writeAfter(jSONSerializer, obj, c);
            }
        }
        if (this.afterFilters != null) {
            Iterator<AfterFilter> it2 = this.afterFilters.iterator();
            while (it2.hasNext()) {
                c = it2.next().writeAfter(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    protected boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        if (jSONSerializer.labelFilters != null) {
            Iterator<LabelFilter> it = jSONSerializer.labelFilters.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(str)) {
                    return false;
                }
            }
        }
        if (this.labelFilters == null) {
            return true;
        }
        Iterator<LabelFilter> it2 = this.labelFilters.iterator();
        while (it2.hasNext()) {
            if (!it2.next().apply(str)) {
                return false;
            }
        }
        return true;
    }
}
