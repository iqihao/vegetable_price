package net.ioage.vegetable.modules.gather.service;

import javafx.beans.binding.ObjectExpression;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by qihao on 2018/3/23.
 */
@Service
public class GatherServiceImpl implements GatherService {

//    @Resource
//    private RestTemplate restTemplate;


    @Value("${infoSource.main}")
    private String url;

    private static final Logger logger = LoggerFactory.getLogger(GatherServiceImpl.class);

    @Override
    public void getInfo() {
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.getForObject(url, String.class);
    }

    @Override
    public void test() {
        try {
            Document doc = Jsoup.connect(url).get();
            Element content = doc.getElementById("ctl00_DropDownList1");
            logger.info(content.toString());
        }catch (IOException e){
            System.out.print("123");
        }
    }
}
