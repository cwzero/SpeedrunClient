# Speedrun.com Rest API Client

This project is a client for the speedrun.com rest api.  It accesses raw data from the api using the Feign library, and saves the data as a csv file using apache commons csv.
I also use the lombok library, just for basic boilerplate reduction, it allows me to have getters and setters without having to actually write them.

How to run:
```
git clone https://github.com/cwzero/SpeedrunClient.git
cd SpeedrunClient
./gradlew run
```

Data output is in data.csv.
