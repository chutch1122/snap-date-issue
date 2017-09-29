#!/usr/bin/env bash

echo "Building Snap Pack"

DATE=`date '+%Y%m%d.%H%M'`

mvn clean install -e -DVERSION=1 -Dsl_build=${DATE}
