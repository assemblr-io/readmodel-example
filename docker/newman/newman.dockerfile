FROM postman/newman

WORKDIR /postman
ADD ../postman/LnD-Readmodels.postman_collection.json /postman
