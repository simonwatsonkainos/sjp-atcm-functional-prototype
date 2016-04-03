#!/bin/sh

psql -a -f dev/sql/recreateDb.sql

mvn liquibase:dropAll -P local
mvn liquibase:update -P local