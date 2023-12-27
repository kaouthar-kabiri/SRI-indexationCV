package ensa.sri.indexationcv.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.elasticsearch.RestClientBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.URI;
import java.util.List;
@Configuration
@EnableElasticsearchRepositories(basePackages = "ensa.sri.indexationcv.repository")
@ComponentScan(basePackages = {"ensa.sri.indexationcv"})
public class RestClientConfig extends AbstractElasticsearchConfiguration {

    @Value("${elasticsearch.url}")
    private String uri;
    @Value("${elasticsearch.username}")
    private String username;
    @Value("${elasticsearch.password}")
    private String password;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(uri)
                .withBasicAuth(username, password)
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
