# hamster-server

```shell
docker run -p 5432:5432 --rm -ti --name hamster-server -e POSTGRES_USER=hamster_admin -e POSTGRES_PASSWORD=password -e POSTGRES_DB=hamster_db postgres:15.3
```

```shell
keytool -genkeypair -keystore src/main/resources/hamster-server.jks -keyalg RSA -keysize 2048 -validity 3650 -alias your_alias -dname "CN=Moittie Vincent, OU=fr, O=Hamster, L=PARIS, ST=FRANCE, C=FR" -storepass password -keypass password -noprompt
```