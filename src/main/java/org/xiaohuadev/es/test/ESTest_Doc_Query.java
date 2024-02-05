package org.xiaohuadev.es.test;

import org.apache.http.HttpHost;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;

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
        /*SearchRequest searchRequest = new SearchRequest();
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
        }*/

        //6.组合查询
        /*SearchRequest search = new SearchRequest();
        search.indices("user");

        SearchSourceBuilder SearchSourcebuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        boolQueryBuilder.must(QueryBuilders.matchQuery("age",30));
        boolQueryBuilder.must(QueryBuilders.matchQuery("sex","男"));

        SearchSourcebuilder.query(boolQueryBuilder);

        search.source(SearchSourcebuilder);
        SearchResponse response = esClient.search(search, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }*/

        /*SearchRequest searchRequest = new SearchRequest(); //1
        searchRequest.indices("user");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); //2

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder(); //3
        boolQueryBuilder.must(QueryBuilders.matchQuery("age","30")); //3

        searchSourceBuilder.query(boolQueryBuilder); //2

        searchRequest.source(searchSourceBuilder); //1

        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT); //0
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }*/

        /*SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        boolQueryBuilder.should(QueryBuilders.matchQuery("age",30));
        boolQueryBuilder.should(QueryBuilders.matchQuery("age",40));

        searchSourceBuilder.query(boolQueryBuilder);

        searchRequest.source(searchSourceBuilder);

        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }*/

        //7.范围查询
        /*SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");

        rangeQuery.gte(30);
        rangeQuery.lte(40);

        searchSourceBuilder.query(rangeQuery);

        searchRequest.source(searchSourceBuilder);

        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }*/

        //8.模糊查询
        /*SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        FuzzyQueryBuilder fuzzinessQueryBuilder = QueryBuilders //允许一个误差 因此可以搜索出张三
                .fuzzyQuery("name", "zhangsan1").fuzziness(Fuzziness.ONE);

        searchSourceBuilder.query(fuzzinessQueryBuilder);

        searchRequest.source(searchSourceBuilder);

        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }*/

        //9.高亮展示
        /*SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "zhangsan");

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='red'>");
        highlightBuilder.postTags("</font>");
        highlightBuilder.field("name"); //对name进行高亮展示

        searchSourceBuilder.highlighter(highlightBuilder);
        searchSourceBuilder.query(matchQueryBuilder);

        searchRequest.source(searchSourceBuilder);

        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
            System.out.println(hit.getHighlightFields());
        }*/

        /*SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "zhangsan");

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color:'red'>");
        highlightBuilder.postTags("</font>");
        highlightBuilder.field("name");

        searchSourceBuilder.highlighter(highlightBuilder);
        searchSourceBuilder.query(matchQueryBuilder); //添加要查询的条件

        searchRequest.source(searchSourceBuilder);

        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
            System.out.println(hit.getHighlightFields());
        }*/

        //10.聚合查询
        /*SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        MaxAggregationBuilder aggregationBuilder =
                AggregationBuilders.max("maxAge").field("age");

        searchSourceBuilder.aggregation(aggregationBuilder); //聚合操作
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }*/

        //11.分组查询(聚合)
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        TermsAggregationBuilder aggregationBuilder =
                AggregationBuilders.terms("ageTerms").field("age");

        searchSourceBuilder.aggregation(aggregationBuilder);
        searchRequest.source(searchSourceBuilder);

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
