package com.sdl.swagger.util;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * @author sundonglin
 * @date 2019/10/24 11:17
 */
public class XmlUtil {


    public static Document parseXmlToDocument(String xml) {
        Document doc = null;
        if (xml != null && !xml.equals("")) {
            StringReader sr = new StringReader(xml);
            InputSource is = new InputSource(sr);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            try {
                builder = factory.newDocumentBuilder();
                doc = builder.parse(is);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return doc;
    }

    public static String getContentFromXml(String xml, String NodeName, int index) {
        String value = "";
        try {
            Document doc = XmlUtil.parseXmlToDocument(xml);
            if (doc != null) {
                Node node = doc.getElementsByTagName(NodeName).item(index);
                if (node != null) {
                    value = node.getFirstChild().getTextContent();
                }
            }
        } catch (Exception e) {
            return null;
        }
        return value;
    }
}
