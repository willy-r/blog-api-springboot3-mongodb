# Learning Spring Boot - Spring Boot 3 + MongoDB


## Table of Contents:

🎯 [Objective](#-objective)  
🏃 [Running the project](#-running-the-project)  
📄 [Scripts](#-scripts)  
🔍 [Visualizing Data](#-visualizing-data)   
📚 [API Documentation](#-api-documentation)   
🚧 [Troubleshooting](#-troubleshooting)


---


## 🎯 Objective

This task is to learn how to create a simple REST application from scratch of a Blog site. Using Spring Boot 3 (Java) e MongoDB. The blog should have users, posts and comments in those posts.


## 🏃 Running the project

You should have a **Docker** environment with support to **Docker Compose V2**.

> ⚠️ _This project uses bash scripts to make some commands easier to run and was tested only on a Linux machine. If you are using Windows, I highly recommend you running this project inside a WSL2 distro, or using Git Bash as your terminal._

Open your terminal in the root folder and type:

```bash
./scripts/run.sh
```

This script will make sure to build your images and in subsequent runs, it will skip the installation step and directly start all containers.

To stop running containers, just type:

```bash
./scripts/stop.sh
```

and all your containers will be dropped and volumes will be removed.


## 📄 Scripts

Beyond `run.sh` and `stop.sh`, we have other helper scripts:

- `attach.sh`: Attach to a terminal inside the app container
- `attach-logs.sh`: Attach logs from all containers in current terminal
- `build.sh`: Rebuilds the images in case you changed something in the Dockerfiles
- `run-db.sh`: Run only database specific containers


## 🔍 Visualizing Data

MongoDB's service are not exposed at any port to the host machine, so you cannot connect directly to them. Please, use

- _MongoDB Database Manager_ available at [`http://localhost:8080/`](http://localhost:8080/)
    - **User**: `root`
    - **Password**: `example`


## 📚 API Documentation

All endpoints were documented using Swagger 3 for Spring Boot 3. All you have to do is open [`http://localhost:8000/docs`](http://localhost:3000/api-docs) and give it a go.


## 🚧 Troubleshooting

- Make sure you have these ports available before running the projects:
    - **`8000`**: Used by Spring Boot API
    - **`8081`**: MongoDB's Database Manager
- Make sure your Docker daemon is running!
- Make sure you are using a newer version of Docker that supports Docker Compose V2! **This project does not use `docker-compose`** (a.k.a. V1) because this version will no longer be supported from the end of June 2023.
- If you are somehow receiving `Permission denied` when trying to run any scripts, run
  ```sh
  chmod +x ./*.sh && chmod +x ./docker/*.sh
  ```
  to make sure your terminal can execute utility scripts and Spring Boot's container can execute the entrypoint script.
