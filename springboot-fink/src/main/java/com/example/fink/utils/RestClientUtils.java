package com.example.fink.utils;

import com.example.fink.pojo.Location;

import org.apache.http.HttpHost;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.script.mustache.SearchTemplateRequest;
import org.elasticsearch.script.mustache.SearchTemplateResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/5 2:13 下午
 * @Version : 1.0
 * @Description :Too
 **/

public class RestClientUtils {

    private RestHighLevelClient client = null;

    public RestClientUtils() {
        if (client == null){
            synchronized (RestHighLevelClient.class){
                if (client == null){
                    client = getClient();
                }
            }
        }
    }

    private RestHighLevelClient getClient(){
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("192.168.199.128", 9200, "http"),
                        new HttpHost("192.168.199.128", 9201, "http")));

        return client;
    }

    public void closeClient(){
        try {
            if (client != null){
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*------------------------------------------------ search Api 多条件查询 start ----------------------------------------------*/
    /**
     * 查询模板
     * @throws Exception
     */
    public List<Location> searchTemplate(String indexName, String JsonStr, Map<String, Object> scriptParams) throws Exception{
        //Inline Templates
        SearchTemplateRequest request = new SearchTemplateRequest();
        request.setRequest(new SearchRequest(indexName));
        request.setScriptType(ScriptType.INLINE);
        request.setScript(JsonStr);

        request.setScriptParams(scriptParams);

        //Synchronous Execution
        SearchTemplateResponse response = client.searchTemplate(request, RequestOptions.DEFAULT);

        //SearchTemplate Response
        SearchResponse searchResponse = response.getResponse();
        //Retrieving SearchHits 获取结果数据
        SearchHits hits = searchResponse.getHits();
        TotalHits totalHits = hits.getTotalHits();
        float maxScore = hits.getMaxScore();
        System.out.println("totalHits: " + totalHits);
        System.out.println("maxScore: " + maxScore);
        System.out.println("------------------------------------------");
        SearchHit[] searchHits = hits.getHits();
        /*for (SearchHit hit : searchHits) {
            // do something with the SearchHit
            String index = hit.getIndex();
            String type = hit.getType();
            String id = hit.getId();
            float score = hit.getScore();
            String sourceAsString = hit.getSourceAsString();
            System.out.println("index: " + index);
            System.out.println("type: " + type);
            System.out.println("id: " + id);
            System.out.println("score: " + score);
            System.out.println(sourceAsString);
            System.out.println("------------------------------------------");
        }*/
        //得到aggregations下内容
        ArrayList<Location> locations = new ArrayList<>();
        Aggregations aggregations = searchResponse.getAggregations();
        if(aggregations!=null){
            Map<String, Aggregation> aggregationMap = aggregations.getAsMap();
            Terms companyAggregation = (Terms) aggregationMap.get("group_by_jing");
            List<? extends Terms.Bucket> buckets = companyAggregation.getBuckets();
            for(Terms.Bucket bk:buckets){
                Location location = new Location();
                Object key = bk.getKey();
                long docCount = bk.getDocCount();
                System.out.println("key: "+key.toString());
                System.out.println("doc_count: "+docCount);
                String jingdu = key.toString().split("#split#")[0];
                String substring_jing = jingdu.substring(1, jingdu.length() - 1);
                location.setJing(Double.parseDouble(substring_jing));
                String weidu = key.toString().split("#split#")[1];
                String substring_wei = weidu.substring(1, weidu.length() - 1);
                location.setWei(Double.parseDouble(substring_wei));
                location.setCount((int)docCount);

                locations.add(location);
            }
        }
        return locations;
    }

}
