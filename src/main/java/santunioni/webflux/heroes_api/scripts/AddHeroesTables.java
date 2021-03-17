package santunioni.webflux.heroes_api.scripts;


import java.util.Collections;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import santunioni.webflux.heroes_api.config.DynamoConfig;
import santunioni.webflux.heroes_api.config.data.ConnProp;


public class AddHeroesTables {

    public static void main(String[] args) throws Exception {

        var dynamoDB = ConnProp.dynamoDB;

        try {
            System.out.println("Criando tabela, aguarde...");
            Table table = dynamoDB.createTable(
                    ConnProp.tableName,
                    Collections.singletonList(
                            new KeySchemaElement("id", KeyType.HASH)),
                    Collections.singletonList(
                            new AttributeDefinition("id", ScalarAttributeType.S)),
                    new ProvisionedThroughput(5L, 5L));
            table.waitForActive();
            System.out.println("Successo " + table.getDescription().getTableStatus());

        } catch (Exception e) {
            System.err.println("Não foi possível criar a tabela");
            System.err.println(e.getMessage());
        }

    }

}
