# Password Validation Service

### Branches
- Main: The password validation service, use `./mvnw publish` to publish as a jar file.
- Demo: Demo web application using the service.

### Language & Framework
```
    Java JDK 17 & SpringBoot 3.1.1
```

### Develop
```
    ./mvnw install
    ./mvnw compile
```

### Test
To generate test coverage report, run
``` 
    ./mvnw verify
```
File will be generated under target/site/jacoco-resources, please open the `index.html` in browser.

### Publish
The file `password-validation-service-1.0.0-SNAPSHOT.jar` will be put under target directory.
```
    ./mvnw publish
```

### Usage
1. Put the generated jar file under ${baseDir}/local-maven-repo
2. Add dependency to pom.xml
```
<dependencies>
    <dependency>
    	<groupId>com.example</groupId>
    	<artifactId>password-validation-service</artifactId>
    	<version>1.0.0-SNAPSHOT</version>
    	<scope>system</scope>
    	<systemPath>${basedir}/local-maven-repo/password-validation-service-1.0.0-SNAPSHOT.jar</systemPath>
    </dependency>
</dependencies>
```
3. Run `./mvnw install`
4. Put the @ValidatePassword annotation on the field you want to validate 
