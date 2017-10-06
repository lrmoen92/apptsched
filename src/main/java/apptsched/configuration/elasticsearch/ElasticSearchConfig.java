package apptsched.configuration.elasticsearch;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.util.Date;


public class ElasticSearchConfig {

    public static void main(String[] args) {

        test();

    }

    public static void test() {

        try {
            Settings settings = Settings.builder().put("client.transport.sniff", true).put("cluster.name", "myClusterName").build();
            TransportClient client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("host1"), 9300))
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("host2"), 9300));

            String json =
                    "{" +
                    "\"user\":\"kimchy\"," +
                    "\"postDate\":\"2013-01-30\"," +
                    "\"message\":\"trying out Elasticsearch\"" +
                    "}";

//            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//            searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//            searchSourceBuilder.aggregation(AggregationBuilders.terms("top_10_states").field("state").size(10));
//
//            SearchRequest searchRequest = new SearchRequest();
//            searchRequest.indices("social-*");
//            searchRequest.source(searchSourceBuilder);
//            SearchResponse searchResponse = client.search(searchRequest);

            XContentBuilder builder = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("user", "kimchy")
                    .field("postDate", new Date())
                    .field("message", "trying out Elasticsearch")
                    .endObject();

            String json2 = builder.string();

            IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
                    .setSource(json2, XContentType.JSON).get();

            response.getIndex();
            response.getType();
            response.getId();
            response.getVersion();
            RestStatus status = response.status();

            GetResponse getResponse = client.prepareGet("twitter", "tweet", "1").get();

            DeleteResponse deleteResponse = client.prepareDelete("twitter", "tweet", "1").get();

            BulkByScrollResponse bulkByScrollResponse = DeleteByQueryAction.INSTANCE.newRequestBuilder(client)
                    .filter(QueryBuilders.matchQuery("gender", "male"))
                    .source("persons")
                    .get();

            long deleted = bulkByScrollResponse.getDeleted();

            UpdateRequest updateRequest = new UpdateRequest();


            updateRequest.index("index");
            updateRequest.type("type");
            updateRequest.id("1");
            updateRequest.doc(XContentFactory.jsonBuilder()
            .startObject()
            .field("gender", "male")
            .endObject());
            client.update(updateRequest).get();

        }catch(Exception e){

        }
    }
}
