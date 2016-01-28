#!/bin/sh

psql -a -f dev/sql/recreateDb.sql

mvn liquibase:update -P local