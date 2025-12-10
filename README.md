# l3API

![Badge](https://img.shields.io/badge/l3API-gradle-brightgreen?style=flat-square) ![Badge](https://img.shields.io/badge/l3Tool-maven-orange?style=flat-square) [![License](https://img.shields.io/badge/License-l3API-7f6be0?style=flat-square)](https://github.com/vaclavak/l3API?tab=License-1-ov-file)

l3API is a free licensing API based on springboot, it allows you to create a restapi licensing server, which you can then send requests to from your software, and validate wheter a license for your software is valid.


## Setting up the server

1. Download l3api from the [releases](https://github.com/vaclavak/l3API/releases) tab or clone the repository and build it yourself (recommended)
2. Run l3api
```
java -jar l3api.jar <secret>
```
replace "secret" with your actual secret

## Default endpoint
The default endpoint for license verification is
```
http://localhost:<port>/api/license/verify/{license}
```

If you wish to change this, i recommend to change it in the code, since there is no config system for now

## Example response

```
{"valid:" true/false}
```

You can then use this boolean value in your code

## Building from src

1. Clone the repository
```
git clone https://github.com/vaclavak/l3API.git
```

2. Build using gradle inside the l3API directory
```
gradlew build
```

## Changing the port

l3API runs on port `8080` by default, it is highly recommended to change this

You can change the port by navigating to `application.properties` in `/API/l3api/src/main/resources`

Change `8080` to the port you want

```properties
server.port=8080
```



## Example usage in a client

The `HTTPConnection` class used here can be found in the l3Lib library, more information bellow

```java
public class Main {
	
	public static void main(String[] args) {
		boolean isValid = Boolean.valueOf(HTTPConnection.getJson("http://yourdomain.com:8080/api/license/verify/" + args[0], "valid"));
		
		if(isValid) {
			System.out.println("Hello world");
		}else {
			System.out.println("Invalid license...");
		}
	}

}
```


# l3Tool

l3Tool is a tool that has additional functions for l3API



## Features
- Generating keys based on your secret
- Generating a new secure secret

## Obtaining l3Tool

Download l3Tool from the [releases](https://github.com/vaclavak/l3API/releases) tab, or build it from src (recommended)

### Generating a new secure secret
```
java -jar l3Tool.jar generateSecret
```

### Generating a new license key based on your secret
```
java -jar l3Tool.jar generate <secret>
```

If you now try your generated secret on your l3API server, it should be valid, if you launched the server with the same secret

## Building l3Tool from src

1. Clone the repo
```
git clone https://github.com/vaclavak/l3API.git
```

2. Build using maven inside the l3Tool directory
```
mvn clean package
```

The binary will be located in "target/l3Tool-`<version>`-SNAPSHOT.jar"

All contents of this repository are licensed under the [l3API](https://github.com/vaclavak/l3API?tab=License-1-ov-file) license

# L3Lib

L3Lib is a library containing licensing features from the licensing server, IPEncoding, which allows you to encode a string into a format that can then be sent to your l3API server, where you can decode it using the same library, and implement usage for it, for example setting timeouts for different ip adresses, and more features


## Adding as a dependency

You may need to be logged in with your github account in either `settings.xml` or in your `build.gradle`, since the library is published on github packages

Maven

```xml
<dependency>
  <groupId>vpp.vac.l3lib</groupId>
  <artifactId>l3api</artifactId>
  <version>VERSION</version>
</dependency>
```