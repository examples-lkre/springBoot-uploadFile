package pl.lkre;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    private final Logger LOG = LoggerFactory.getLogger("myLogger");

    public static void main(String[] args) throws IOException, ParserConfigurationException, URISyntaxException {
        Main main = new Main();
        String invoke = main.invoke();
    }

    public String invoke() throws IOException, ParserConfigurationException, URISyntaxException {
        LOG.info("----- start invoke method");

        String fileName = "test.pdf";
        URI uri = getClass().getClassLoader().getResource(fileName).toURI();
        File file = new File(uri);

        PDDocument pdf = PDDocument.load(file);
        PDFDomTree parser = new PDFDomTree();
        Document dom = parser.createDOM(pdf);

        LOG.error("----- error from invoke");
        LOG.trace("----- end invoke method");
        return "String from pl.lkre.Main class";
    }
}
