import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author Charley
 * @creat 2021-05-13 18:07
 */
public class dom4jTest {
    @Test
    public void test1(){
        SAXReader saxReader = new SAXReader();
        Document document;
        {
            try {
                document = saxReader.read("src/book.xml");
                System.out.println(document);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
    }

    @Test //读取xml文件，生成book类
    public void test2() throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/book.xml");
        Element root = document.getRootElement();
        List<Element> books = root.elements("book");
        for(Element book : books){
            String name = book.elementText("name");
            String price = book.elementText("price");
            String author = book.elementText("author");
            String sn = book.attributeValue("sn");
            System.out.println(new book(sn,name,Double.parseDouble(price),author));
        }

    }
}
