java $JAVA_OPTS -jar lengolytics/0.0.1-SNAPSHOT --server.port=$PORT $JAR_OPTS
heroku deploy:jar -j lengolytics/0.0.1-SNAPSHOT.jar -i Procfile --app
heroku ps:scale web=1
