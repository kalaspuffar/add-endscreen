package org.ea.obj;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 <RootObject type="Range" objectId="23643">
 <parent type="ObjectRef" value="23642"/>
 <from type="int64_t" value="0"/>
 <to type="int64_t" value="181319"/>
 <level type="int32_t" value="0"/>
 <zValue type="int32_t" value="0"/>
 </RootObject>
 */
public class Range {
    private int objectId;
    private int parentId;
    private int length;

    public Range(int objectId, int parentId, int length) {
        this.objectId = objectId;
        this.parentId = parentId;
        this.length = length;
    }

    public Element getElement(Document doc) {
        Element rootObject = doc.createElement("RootObject");
        rootObject.setAttribute("type", "Range");
        rootObject.setAttribute("objectId", Integer.toString(objectId));

        rootObject.appendChild(Util.getValueTypeElement(doc, "parent", "ObjectRef", parentId));
        rootObject.appendChild(Util.getValueTypeElement(doc, "from", "int64_t", 0));
        rootObject.appendChild(Util.getValueTypeElement(doc, "to", "int64_t", length));
        rootObject.appendChild(Util.getValueTypeElement(doc, "level", "int32_t", 0));
        rootObject.appendChild(Util.getValueTypeElement(doc, "zValue", "int32_t", 0));

        return rootObject;
    }

}
