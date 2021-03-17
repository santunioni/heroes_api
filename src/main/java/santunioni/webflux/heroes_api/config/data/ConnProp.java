package santunioni.webflux.heroes_api.config.data;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class ConnProp {
    private static final String SIGN_IN_REGION = "east-sa-1";
    private static final String ENDPOINT_URl = "http://172.18.0.1:8000";
    private static final String ACCESS_KEY = "lala";
    private static final String SECRET_KEY = "land";

    private static final AwsClientBuilder.EndpointConfiguration
            ENDPOINT_CONFIGURATION =
            new AwsClientBuilder.EndpointConfiguration(
                    ENDPOINT_URl,
                    SIGN_IN_REGION);

    private static final AWSCredentials
            AWS_CREDENTIALS =
            new BasicAWSCredentials(
                    ACCESS_KEY,
                    SECRET_KEY);

    private static final AWSStaticCredentialsProvider
            AWS_CREDENTIALS_PROVIDER =
            new AWSStaticCredentialsProvider(AWS_CREDENTIALS);

    private static final AmazonDynamoDB
            dynamoDBClient =
            AmazonDynamoDBClientBuilder
                    .standard()
                    .withCredentials(AWS_CREDENTIALS_PROVIDER)
                    .withEndpointConfiguration(ENDPOINT_CONFIGURATION)
                    .build();

    public static final DynamoDB
            dynamoDB =
            new DynamoDB(dynamoDBClient);

    public static final String tableName = "heroes_table";
}
