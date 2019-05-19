# Food Delivery API

## Installation
This app requires a MYSQL database in order to persist its data.
You can run a MYSQL docker using the script `docker-run.sh` (it may take a while until it gets up and running).

### Build
Once you have downloaded the repository, built the project with
```sh
$ mvn clean install
```

### Run
Finally, you can run the app with
```sh
$ java -jar target/food-delivery-api-0.0.1-SNAPSHOT.jar
```

