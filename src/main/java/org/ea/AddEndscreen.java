package org.ea;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class AddEndscreen {

    static String FILE_NAME = "Testing3.mepx";

    public static void main(String[] args) throws Exception {
        final ZipFile file = new ZipFile(FILE_NAME);
        System.out.println("Iterating over zip file : " + FILE_NAME);
        try {
            final Enumeration<? extends ZipEntry> entries = file.entries();
            while (entries.hasMoreElements()) {
                final ZipEntry entry = entries.nextElement();
                if(entry.getName().equalsIgnoreCase("project.xml")) {
                    readProject(file.getInputStream(entry));
                }
            }
            System.out.printf("Zip file %s extracted successfully in %s", FILE_NAME, "Bah");
        } finally {
            file.close();
        }
    }

    public static void readProject(InputStream is) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(is);

            NodeList nl = doc.getElementsByTagName("RootObject");
            for(int i=0; i<nl.getLength(); i++) {
                Element el = (Element)nl.item(i);
                System.out.println("RootObj[" + el.getAttribute("type") + "] = "+el.getAttribute("objectId"));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("working.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
