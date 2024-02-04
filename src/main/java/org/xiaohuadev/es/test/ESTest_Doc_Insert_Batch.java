package org.xiaohuadev.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class ESTest_Doc_Insert_Batch {
    public static void main(String[] args) throws Exception {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("103.184.47.2", 9200, "http"))
        );

        //批量插入数据
        BulkRequest bulkRequest = new BulkRequest();
        IndexRequest data1 = new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "zhangsan", "age", 30, "sex", "男");
        IndexRequest data2 = new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "lisi", "age", 30, "sex", "女");
        IndexRequest data3 = new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "wangwu", "age", 40, "sex", "男");
        IndexRequest data4 = new IndexRequest().index("user").id("1004").source(XContentType.JSON, "name", "wangwu1", "age", 40, "sex", "女");
        IndexRequest data5 = new IndexRequest().index("user").id("1005").source(XContentType.JSON, "name", "wangwu2", "age", 50, "sex", "男");
        IndexRequest data6 = new IndexRequest().index("user").id("1006").source(XContentType.JSON, "name", "wangwu3", "age", 50, "sex", "男");

        //装入数据
        bulkRequest.add(data1);
        bulkRequest.add(data2);
        bulkRequest.add(data3);
        bulkRequest.add(data4);
        bulkRequest.add(data5);
        bulkRequest.add(data6);

        BulkResponse response = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(response.getTook()); //获取花费的时间
        System.out.println(response.getItems()); //获取响应(多个)

        esClient.close();
    }
}
