#clean the project
./gradlew clean
#build the project
./gradlew distTar

#make sure the docker compose app isn't already running and if it is - tear it down
docker compose down

#rebuild docker apps and start the api server
docker compose up
