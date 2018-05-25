package net.ioage.vegetable.modules.gather.service;

import javafx.beans.binding.ObjectExpression;
import net.ioage.vegetable.modules.gather.utils.Constant;
import net.ioage.vegetable.modules.gather.utils.TimeUtils;
import net.ioage.vegetable.modules.web.dao.PriceDao;
import net.ioage.vegetable.modules.web.model.Goods;
import net.ioage.vegetable.modules.web.model.Price;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by qihao on 2018/3/23.
 */
@Service
public class GatherServiceImpl implements GatherService {


    @Value("${infoSource.main}")
    private String url;

    private static final Logger logger = LoggerFactory.getLogger(GatherServiceImpl.class);

    @Autowired
    private PriceDao priceDao;


    @Override
    public void test() {
        try {
            Document doc = Jsoup.connect(url).get();
            maintainGoodsInfo(doc);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 抓取价格信息的主方法
     */
    private void gatherPriceInformation() {
        try {
            // 拿到web界面
            Document doc = Jsoup.connect(url).get();
            // 获取下拉框中的时间参数，并与数据库中的记录做比对
            getUnRecordedPriceDate(doc);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取某个指定日期的价格记录DOC页面
     *
     * @param doc  第一次访问得到的页面对象，为了获取到几个必要参数
     * @param date 日期，字符串
     * @return 新的doc对象
     * @throws IOException 访问异常
     */
    private Document getDocumentByDate(Document doc, String date) throws IOException {
        String viewstategenerator = doc.getElementById("__VIEWSTATEGENERATOR").attr("value");
        String eventvalidation = doc.getElementById("__EVENTVALIDATION").attr("value");
        String viewstate = doc.getElementById("__VIEWSTATE").attr("value");
        Map<String, String> request = new HashMap<>();
        request.put("__EVENTTARGET", "ctl00$DropDownList1");
        request.put("ctl00$DropDownList1", date);
        request.put("__VIEWSTATEGENERATOR", viewstategenerator);
        request.put("__EVENTVALIDATION", eventvalidation);
        request.put("__VIEWSTATE", viewstate);
        return Jsoup.connect(url).data(request).post();
    }

    /**
     * 获取尚未记录到系统中的时间
     */
    private void getUnRecordedPriceDate(Document doc) throws IOException {
        Element content = doc.getElementById("ctl00_DropDownList1");
        Elements timeOptions = content.getElementsByTag("option");
        for (Element option : timeOptions) {
            String s = option.attributes().get("value");
            logger.info("Get web datetime" + s);
            Date date = TimeUtils.sting2Date(s);
            List<Price> priceList = priceDao.getPriceByDateTime(date);
            if (!CollectionUtils.isEmpty(priceList)) {
                // 数据库中有记录 则不再记录
                logger.info("Get recorded information on date {}", s);
                break;
            } else {
                // 数据库中没有记录，访问该日期的页面，并保存数据
                logger.info("Cannot found price information on date {},insert into database now", s);
                Document insertDoc = getDocumentByDate(doc, s);
            }
        }

    }

    /**
     * 将页面中的数据保存到数据库中
     *
     * @param doc 页面对象
     */
    private void insertRecordIntoDataBase(Document doc) {

    }

    private void maintainGoodsInfo(Document doc) {
        List<Element> tbody = doc.getElementById("ctl00_GridView1").getElementsByTag("tbody").first().children();
        for (int i = 1; i < tbody.size(); i++) {
            Goods goods = new Goods();
            Element tr = tbody.get(i);

            goods.setName(tr.child(0).text());
            goods.setAssortment(tr.child(1).text());
            goods.setSpecification(tr.child(2).text());
            goods.setUnit(tr.child(3).text());
            logger.info(tr.toString());
        }

    }


}
