package org.ea.obj;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by danielp on 5/19/17.
 */
public class Util {

    public static Element getValueTypeElement(Document doc, String name, String type, int value) {
        return getValueTypeElement(doc, name, type, Integer.toString(value));
    }

    public static Element getValueTypeElement(Document doc, String name, String type, String value) {
        Element parent = doc.createElement(name);
        parent.setAttribute("type", type);
        parent.setAttribute("value", value);
        return parent;
    }
}
