#!/usr/bin/env bash

echo "Helper kstream image"

echo "docker build -t $IMAGE -f 'tools/Dockerfile' ."

docker build -t $IMAGE -f "tools/Dockerfile" .

if $PUSH_IMAGE; then
  echo "docker push $IMAGE"
  docker push $IMAGE
fi
