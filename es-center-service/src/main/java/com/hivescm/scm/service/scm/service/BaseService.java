package com.hivescm.scm.service.scm.service;

import com.hivescm.scm.service.config.RabbitMQService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:
 * @Description: 基础Service
 * @Date: 2018/4/9 14:46
 */
@Service
public class BaseService {
    private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

    private final String mqExchange = "exchange.b2b.mq";

    private final String routingKey = "queue-b2b-mq";

    @Autowired
    protected RabbitMQService rabbitMQService;

    private Map<String, String> getBaseMap() { Map baseMap = new HashMap(4);
        baseMap.put("mqExchange", "exchange.scm.mq");
        baseMap.put("routingKey", "queue-scm-mq");
        return baseMap; }

    protected Map<String, String> getGoodsERMap()
    {
        String _type = "goods";
        String _index = "release-goods-3";
        Map baseMap = getBaseMap();
        baseMap.put("_type", "goods");
        baseMap.put("_index", "release-goods-3");
        return baseMap;
    }

    protected Map<String, String> getDealerERMap() {
        String _type = "dealer";
        String _index = "release-dealer-2";
        Map baseMap = getBaseMap();
        baseMap.put("_type", "dealer");
        baseMap.put("_index", "release-dealer-2");
        return baseMap;
    }
}
