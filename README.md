## About
A simple temporary file hosting. It' still on the early development stage. There's two main folders in this repository, **back** and **front**, there's a README in each folder explainig how to configure and compile each. 

After setting everything up, run:
```docker compose up```

Also, don't forget to check the ```nginx/nginx.conf``` config, after deploying it, you will need to proxy pass the API and set some limits over there; otherwise anyone will be able do flood it.

## Requirements
- Angular 15;
- Java 17;
- Mysql 8;
- Docker 23.

## Todo-list
1. ~~Use docker~~;
2. Create a script to check images that's been longer than one day on the database
