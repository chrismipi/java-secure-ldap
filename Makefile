build:
	mvn clean package

run: build
	java -jar ./target/ldap-1.0-SNAPSHOT.jar -Djavax.net.ssl.keyStore="./keystore.jks" -Djavax.net.ssl.keyStorePassword=password
