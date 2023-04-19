#!/bin/bash

docker compose -f ./compose/docker-compose.dev.yml up -d mongodb mongodb-management
