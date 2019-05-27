#!/bin/bash
echo "Creating data in database"
psql -U kuanto -d kuanto -a -f /scripts/init-database.sql
