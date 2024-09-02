#!/bin/bash
# Uncomment this if all the modules are not built
./build-all.sh 
cd ../modules/flowable-ui
mvn clean install -DskipTests
