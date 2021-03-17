# This script will take time the first time you runt it because
# it will download several docker images for building the Gradle app
# into the container.

docker run -d \
-p 8000:8000 \
-h DynamoDB-Heroes \
-v /home/dynamodblocal/data \
-w /home/dynamodblocal \
-t amazon/dynamodb-local:latest \
-jar DynamoDBLocal.jar -sharedDb -optimizeDbBeforeStartup -dbPath ./data \

./gradlew bootBuildImage --imageName=heroes_api

docker run \
-e "SPRING_PROFILES_ACTIVE=dev" \
-h APP-Heroes \
-p 8080:8080 \
-t heroes_api
