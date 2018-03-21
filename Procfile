java $JAVA_OPTS -jar lengolytics/0.0.1-SNAPSHOT --server.port=$PORT $JAR_OPTS
heroku deploy:jar -j lengolytics/0.0.1-SNAPSHOT.jar -i Procfile --app
heroku deploy:jar lengolytics/0.0.1-SNAPSHOT.jar -o --server.port=$PORT --app
web: java $JAVA_OPTS -Dserver.port=$PORT -jar lengolytics/0.0.1-SNAPSHOT.jar

