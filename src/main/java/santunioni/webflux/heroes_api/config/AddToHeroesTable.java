package santunioni.webflux.heroes_api.config;


import java.util.Collections;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;


public class AddToHeroesTable {

    public static void main(String[] args) throws Exception {

        System.out.println(APIConstans.);

        var dynamoDB = new DynamoDB(
                new DynamoConfig()
                        .amazonDynamoDB()
        );

        String tableName = "heroes_table";

        try {
            System.out.println("Criando tabela, aguarde...");
            Table table = dynamoDB.createTable(
                    tableName,
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
