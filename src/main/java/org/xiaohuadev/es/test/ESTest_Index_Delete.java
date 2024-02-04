package org.xiaohuadev.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

public class ESTest_Index_Delete {
    public static void main(String[] args) throws Exception {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("103.184.47.2", 9200, "http"))
        );

        //删除索引
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("user");
        AcknowledgedResponse response = esClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);

        if (response.isAcknowledged()) System.out.println("返回结果为" + true + " 删除成功");

        esClient.close();
    }
}
