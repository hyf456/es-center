package com.hivescm.scm.service.config;

import com.alibaba.fastjson.JSONObject;
import com.hivescm.mq.rabbit.RabbitSessionChannel;
import com.rabbitmq.client.AMQP;
import org.elasticsearch.index.query.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.support.RabbitExceptionTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author:
 * @Description: MQ配置中心
 * @Date: 2018/4/9 14:18
 */
@Component
public class RabbitMQService {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQService.class);

    @Autowired
    private RabbitSessionChannel sessionChannel;

    public boolean saveObject(Map<String, String> baseMap, String _id, JSONObject content, boolean isContainsId) {
        JSONObject result = new JSONObject();
        result.put("action", "save");
        result.put("_index", baseMap.get("_index"));
        result.put("_type", baseMap.get("_type"));
        result.put("_id", _id);
        result.put("_content", content);
        result.put("isContainsId", Boolean.valueOf(isContainsId));
        String jsonStr = result.toJSONString();
        logger.debug("saveObject jsonStr = {}", jsonStr);
        try {
            this.sessionChannel.basicPublish((String) baseMap.get("mqExchange"), (String) baseMap.get("routingKey"), new AMQP.BasicProperties(), jsonStr
                    .getBytes());
            return true;
        } catch (IOException e) {
            throw RabbitExceptionTranslator.convertRabbitAccessException(e);
        }
    }

    public boolean saveMultiObject(Map<String, String> baseMap, List<JSONObject> objectList, boolean isContainsId) {
        JSONObject result = new JSONObject();
        result.put("action", "multi_save");
        result.put("_index", baseMap.get("_index"));
        result.put("_type", baseMap.get("_type"));
        result.put("_listContent", objectList);
        result.put("isContainsId", Boolean.valueOf(isContainsId));
        String jsonStr = result.toJSONString();
        logger.debug("saveMultiObject jsonStr = {}", jsonStr);
        try {
            this.sessionChannel.basicPublish((String) baseMap.get("mqExchange"), (String) baseMap.get("routingKey"), new AMQP.BasicProperties(), jsonStr
                    .getBytes());
            return true;
        } catch (IOException e) {
            throw RabbitExceptionTranslator.convertRabbitAccessException(e);
        }
    }

    public boolean updateObject(Map<String, String> baseMap, String _id, JSONObject content) {
        JSONObject result = new JSONObject();
        result.put("action", "update");
        result.put("_index", baseMap.get("_index"));
        result.put("_type", baseMap.get("_type"));
        result.put("_id", _id);
        result.put("_content", content);
        String jsonStr = result.toJSONString();
        logger.debug("updateObject jsonStr = {}", jsonStr);
        try {
            this.sessionChannel.basicPublish((String) baseMap.get("mqExchange"), (String) baseMap.get("routingKey"), new AMQP.BasicProperties(), jsonStr
                    .getBytes());
            return true;
        } catch (IOException e) {
            throw RabbitExceptionTranslator.convertRabbitAccessException(e);
        }
    }

    public boolean updateMultiObject(Map<String, String> baseMap, List<String> idList, JSONObject content) {
        JSONObject result = new JSONObject();
        result.put("action", "multi_update");
        result.put("_index", baseMap.get("_index"));
        result.put("_type", baseMap.get("_type"));
        result.put("_idList", idList);
        result.put("_content", content);
        String jsonStr = result.toJSONString();
        logger.debug("updateMultiObject jsonStr = {}", jsonStr);
        try {
            this.sessionChannel.basicPublish((String) baseMap.get("mqExchange"), (String) baseMap.get("routingKey"), new AMQP.BasicProperties(), jsonStr
                    .getBytes());
            return true;
        } catch (IOException e) {
            throw RabbitExceptionTranslator.convertRabbitAccessException(e);
        }
    }

    public boolean updateMultiObjectByQuery(Map<String, String> baseMap, QueryBuilder queryBuilder, JSONObject content) {
        JSONObject result = new JSONObject();
        result.put("action", "query_multi_update");
        result.put("_index", baseMap.get("_index"));
        result.put("_type", baseMap.get("_type"));
        result.put("_query", null == queryBuilder ? null : JSONObject.parseObject(queryBuilder.toString()));
        result.put("_content", content);
        String jsonStr = result.toJSONString();
        logger.debug("updateMultiObject jsonStr = {}", jsonStr);
        try {
            this.sessionChannel.basicPublish((String) baseMap.get("mqExchange"), (String) baseMap.get("routingKey"), new AMQP.BasicProperties(), jsonStr
                    .getBytes());
            return true;
        } catch (IOException e) {
            throw RabbitExceptionTranslator.convertRabbitAccessException(e);
        }
    }

    public boolean updateMultiObjectByQueryAction(Map<String, String> baseMap, QueryBuilder queryBuilder, String scriptString, Map<String, Object> params) {
        JSONObject result = new JSONObject();
        result.put("action", "query_script_update");
        result.put("_index", baseMap.get("_index"));
        result.put("_type", baseMap.get("_type"));
        result.put("_query", null == queryBuilder ? null : JSONObject.parseObject(queryBuilder.toString()));
        result.put("_script", scriptString);
        result.put("params", params);
        String jsonStr = result.toJSONString();
        logger.debug("updateMultiObject jsonStr = {}", jsonStr);
        try {
            this.sessionChannel.basicPublish((String) baseMap.get("mqExchange"), (String) baseMap.get("routingKey"), new AMQP.BasicProperties(), jsonStr
                    .getBytes());
            return true;
        } catch (IOException e) {
            throw RabbitExceptionTranslator.convertRabbitAccessException(e);
        }
    }

    public boolean deleteObjectById(Map<String, String> baseMap, String id) {
        JSONObject result = new JSONObject();
        result.put("action", "delete");
        result.put("_index", baseMap.get("_index"));
        result.put("_type", baseMap.get("_type"));
        result.put("_id", id);
        String jsonStr = result.toJSONString();
        logger.debug("deleteObjectById jsonStr = {}", jsonStr);
        try {
            this.sessionChannel.basicPublish((String) baseMap.get("mqExchange"), (String) baseMap.get("routingKey"), new AMQP.BasicProperties(), jsonStr
                    .getBytes());
            return true;
        } catch (IOException e) {
            throw RabbitExceptionTranslator.convertRabbitAccessException(e);
        }
    }

    public boolean deleteMultiObject(Map<String, String> baseMap, List<String> idList) {
        JSONObject result = new JSONObject();
        result.put("action", "multi_delete");
        result.put("_index", baseMap.get("_index"));
        result.put("_type", baseMap.get("_type"));
        result.put("_idList", idList);
        String jsonStr = result.toJSONString();
        logger.debug("deleteMultiObject jsonStr = {}", jsonStr);
        try {
            this.sessionChannel.basicPublish((String) baseMap.get("mqExchange"), (String) baseMap.get("routingKey"), new AMQP.BasicProperties(), jsonStr
                    .getBytes());
            return true;
        } catch (IOException e) {
            throw RabbitExceptionTranslator.convertRabbitAccessException(e);
        }
    }

    public boolean deleteMultiObjectByQuery(Map<String, String> baseMap, QueryBuilder queryBuilder) {
        JSONObject result = new JSONObject();
        result.put("action", "query_multi_delete");
        result.put("_index", baseMap.get("_index"));
        result.put("_type", baseMap.get("_type"));
        result.put("_query", null == queryBuilder ? null : JSONObject.parseObject(queryBuilder.toString()));
        String jsonStr = result.toJSONString();
        logger.debug("deleteMultiObject jsonStr = {}", jsonStr);
        try {
            this.sessionChannel.basicPublish((String) baseMap.get("mqExchange"), (String) baseMap.get("routingKey"), new AMQP.BasicProperties(), jsonStr
                    .getBytes());
            return true;
        } catch (IOException e) {
            throw RabbitExceptionTranslator.convertRabbitAccessException(e);
        }
    }
}
