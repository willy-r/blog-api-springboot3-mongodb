# Learning Spring Boot - Spring Boot 3 + MongoDB


## Table of Contents:

🏃 [Running the project](#-running-the-project)  
📄 [Scripts](#-scripts)


---


## 🏃 Running the project

You should have a **Docker** environment with support to **Docker Compose V2**.

_This project uses bash scripts to make some commands easier to run and was tested only on a Linux machine. If you are using Windows, I highly recommend you running this project inside a WSL2 distro, or using Git Bash as your terminal._

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
