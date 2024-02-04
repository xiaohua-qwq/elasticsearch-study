package org.xiaohuadev.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ESTest_Doc_Delete {
    public static void main(String[] args) throws Exception {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("103.184.47.2", 9200, "http"))
        );

        //删除文档(一条数据)
        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.index("user").id("1001");
        DeleteResponse response = esClient.delete(deleteRequest, RequestOptions.DEFAULT);

        System.out.println(response.toString());

        esClient.close();
    }
}
