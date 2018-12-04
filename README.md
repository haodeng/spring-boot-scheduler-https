"# spring-boot-scheduler-https" 

# Create self-signed certificate 
```java
keytool -genkey -alias hao_test -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 365
Enter keystore password:
Re-enter new password:
What is your first and last name?
  [Unknown]:  Hao Deng
What is the name of your organizational unit?
  [Unknown]:  hao
What is the name of your organization?
  [Unknown]:  test
What is the name of your City or Locality?
  [Unknown]:  dk
What is the name of your State or Province?
  [Unknown]:  dk
What is the two-letter country code for this unit?
  [Unknown]:  dk
Is CN=Hao Deng, OU=hao, O=test, L=dk, ST=dk, C=dk correct?
  [no]:  yes
```

# Config application.properties
```java
server.port: 443
server.ssl.key-store: keystore.p12
server.ssl.key-store-password: changeit
server.ssl.keyStoreType: PKCS12
server.ssl.keyAlias: hao_test
```

Start springboot, it will start on 443 port. Visit https://localhost


# Enable scheduler
1. add @EnableScheduling to the application

2. Add a scheduler
```java
@Component
public class HelloScheduler {

    @Scheduled(fixedDelay = 100, initialDelay = 3000)
    public void run(){
        System.out.println("Hello");
    }
}
```
