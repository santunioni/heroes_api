package santunioni.webflux.heroes_api.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories
public class DynamoConfig {
    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.sign_in_region}")
    private String amazonDynamoDBSignInRegion;

    @Value("${amazon.aws.access_key}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secret_key}")
    private String amazonAWSSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        var amazonDynamoDB
                = AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                amazonAWSCredentials()
                        ));
        if (!amazonDynamoDBEndpoint.isEmpty()) {
            amazonDynamoDB
                    .setEndpointConfiguration(
                            new AwsClientBuilder
                                    .EndpointConfiguration(
                                    amazonDynamoDBEndpoint,
                                    amazonDynamoDBSignInRegion));
        }
        return amazonDynamoDB.build();
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(
                amazonAWSAccessKey,
                amazonAWSSecretKey);
    }
}
