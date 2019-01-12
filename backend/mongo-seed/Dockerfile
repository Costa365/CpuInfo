FROM mongo

COPY ./cpus.json /cpus.json
CMD mongoimport --host mongodb --db cpus --collection cpus --type json --drop --file /cpus.json --jsonArray
