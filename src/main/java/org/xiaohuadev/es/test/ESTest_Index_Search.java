package org.xiaohuadev.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

public class ESTest_Index_Search {
    public static void main(String[] args) throws Exception {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("103.184.47.2", 9200, "http"))
        );

        //查询索引
        GetIndexRequest getIndexRequest = new GetIndexRequest("user");
        GetIndexResponse IndexResponse = esClient.indices().get(getIndexRequest, RequestOptions.DEFAULT);

        System.out.println(IndexResponse.getAliases());
        System.out.println(IndexResponse.getMappings());
        System.out.println(IndexResponse.getSettings());

        esClient.close();
    }
}
