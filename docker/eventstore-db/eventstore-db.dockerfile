FROM postgres:11.1-alpine

COPY ./sql/* /docker-entrypoint-initdb.d/ 