# l3API

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