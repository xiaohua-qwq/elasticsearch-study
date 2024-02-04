package org.xiaohuadev.es.test;

import org.apache.http.HttpHost;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

public class ESTest_Doc_Query {
    public static void main(String[] args) throws Exception {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("103.184.47.2", 9200, "http"))
        );

        //1.全量查询
        /*SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));

        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();

        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }*/

        //2.条件查询
        /*SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age", 30)));

        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }*/

        //3.分页查询
        /*SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        SearchSourceBuilder search = new SearchSourceBuilder().query(QueryBuilders.termQuery("age", 30));
        search.from(0); //从第0个开始
        search.size(1); //每页显示一个

        searchRequest.source(search);

        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }*/

        //4.结果排序
        /*SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        query.sort("age", SortOrder.DESC);

        searchRequest.source(query);

        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }*/

        //5.排除字段
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        String[] exclude = {}; //排除哪些字段
        String[] include = {"name"}; //包含哪些字段
        query.fetchSource(include, exclude);

        searchRequest.source(query);

        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        esClient.close();
    }
}
