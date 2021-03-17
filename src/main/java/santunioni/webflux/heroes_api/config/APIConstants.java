package santunioni.webflux.heroes_api.config;

final class APIConstants {
    public static final String HEROES_ENDPOINT_LOCAL = "${spring.api.endpoint}";
    public static final String ENDPOINT_DYNAMO = "${amazon.dynamodb.endpoint}";
    public static final String REGION_DYNAMO = "${amazon.aws.sign_in_region}";
    protected APIConstants () {};
}
