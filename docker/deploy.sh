CONTAINER_ID=$(sudo docker ps -q --filter "publish=8080-8080")

if [ ! -z "$CONTAINER_ID" ]; then
  sudo docker stop $CONTAINER_ID
  sudo docker rm $CONTAINER_ID
fi

sudo docker pull $DOCKERHUB_USERNAME/$DOCKER_IMAGE_TAG_NAME:latest
sudo docker run -d -p 8080:8080 \
    -e DB_USERNAME=$DB_USERNAME \
    -e DB_PASSWORD=$DB_PASSWORD \
    -e DB_URL=$DB_URL
    $DOCKERHUB_USERNAME/$DOCKER_IMAGE_TAG_NAME:latest