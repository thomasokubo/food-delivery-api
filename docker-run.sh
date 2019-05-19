# !/bin/bash

docker run --name=food-db -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=pwd mysql:latest
