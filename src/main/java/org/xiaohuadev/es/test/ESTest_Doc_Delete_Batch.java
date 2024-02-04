package org.xiaohuadev.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class ESTest_Doc_Delete_Batch {
    public static void main(String[] args) throws Exception {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("103.184.47.2", 9200, "http"))
        );

        //批量删除数据
        BulkRequest bulkRequest = new BulkRequest();
        DeleteRequest data1 = new DeleteRequest().index("user").id("1001");
        DeleteRequest data2 = new DeleteRequest().index("user").id("1003");

        //装入要删除的数据
        bulkRequest.add(data1);
        bulkRequest.add(data2);

        BulkResponse response = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(response.getTook()); //获取花费的时间
        System.out.println(response.getItems()); //获取响应(多个)

        esClient.close();
    }
}
