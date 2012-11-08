/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import rules.Rules;

/**
 *
 * @author mh
 */
public class RulesReader {
    
    
    private final String ruleFile;
    
    private final Rules rules;

    public RulesReader(String ruleFile) {
        this.ruleFile = ruleFile;
        rules = new Rules();
    }
    
    
    
    public Rules getRules() throws IllegalStateException{
        try {
            File file = new File(ruleFile);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            //root element
            Document doc = db.parse(file);
            //all rules in document (in <rule> tags)
            NodeList rulesNodes = doc.getElementsByTagName("rule");
            
            for (int i = 0; i < rulesNodes.getLength(); i++){
                
                Node ruleNode = rulesNodes.item(i);
                
                //see if we have a tag node, at this moment we are not interested in anything else
                if (ruleNode.getNodeType() == Node.ELEMENT_NODE){
                    Element ruleElem = (Element)ruleNode;
                    //TODO - parse rule from here...
                }
                
                
                
            }
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(RulesReader.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException();
        }
        return rules;
    }
    
    
}
