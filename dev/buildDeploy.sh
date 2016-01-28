#!/bin/sh

mvn package

cp target/sjp-atcm-0.1.0.war /usr/local/Cellar/wildfly-as/9.0.2.Final/libexec/standalone/deployments
