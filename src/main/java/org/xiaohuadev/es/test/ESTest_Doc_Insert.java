package org.xiaohuadev.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class ESTest_Doc_Insert {
    public static void main(String[] args) throws Exception {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("103.184.47.2", 9200, "http"))
        );

        /*//插入数据
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("user").id("1001");

        //创建User对象
        User user = new User();
        user.setName("zhangsan");
        user.setAge(30);
        user.setSex("男");

        //将User对象序列化成Json
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        indexRequest.source(userJson, XContentType.JSON);

        IndexResponse response = esClient.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(response.getResult()); //获取response的返回结果并打印*/

        //插入数据
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("user").id("1002");

        //创建User对象
        User user = new User();
        user.setName("lisi");
        user.setAge(18);
        user.setSex("男");

        //把User对象序列化为Json
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);

        indexRequest.source(userJson, XContentType.JSON);

        IndexResponse response = esClient.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(response.getResult());

        esClient.close();
    }
}
