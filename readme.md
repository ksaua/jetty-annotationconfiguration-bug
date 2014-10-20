1. clone it
1. run: ./gradlew war
1. run: java -jar build/libs/jetty-bug.war I

Notice that you get "Context was properly initialized!"

1. Open up src/main/java/no/saua/jettybug/EmbeddedJetty.java, comment line 30-31 and uncomment line 34
1. run: ./gradlew war
1. run: java -jar build/libs/jetty-bug.war I

Notice that you do NOT get the "Context was properly initialized!"

