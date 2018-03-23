package net.ioage.vegetable.modules.gather.service;

import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by qihao on 2018/3/23.
 */
@Service
public class GatherServiceImpl extends GatherService{
    @Autowired
    RestTemplate restTemplate;


    @Value("${infoSource.main}")
    private String url;

    @Override
    public void getInfo() {
        Object object = restTemplate.getForObject(url,null,Object.class);
    }
}
