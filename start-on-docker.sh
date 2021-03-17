# This script will take longer the first time you runt it because
# it will download several docker images for building the Gradle app
# into the container.

trap "docker-compose down" SIGINT

docker network create --subnet=172.197.0.0/16 heroes_api_network

./gradlew bootBuildImage --imageName=heroes_api

docker-compose up
