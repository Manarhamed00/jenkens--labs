# 3-Tier Application with Flask, MySQL, and Metabase

## 📌 Project Overview
This project is a **3-tier application** that consists of:
- **Backend**: A Flask API that receives and processes CSV files, then stores data in MySQL.
- **Database**: A MySQL 5.7 database container for storing data.
- **Power BI (Metabase)**: A Metabase container for data visualization.

The entire setup is containerized using **Docker Compose**.

---
## 🏗️ Project Structure
```
3tier-app/
│── backend/          # Flask application
│   │── app.py        # Main application file
│   │── requirements.txt # Python dependencies
│   │── Dockerfile    # Dockerfile for backend
│
│── database/         # MySQL container setup
│   │── Dockerfile    # Dockerfile for database
│
│── powerbi/          # Metabase for visualization
│   │── Dockerfile    # Dockerfile for Metabase
│
│── docker-compose.yml # Orchestration file for services
│── Jenkinsfile       # CI/CD pipeline configuration
```

---
## 🖥️ Backend - Flask API
### 🔹 Features
- **Receives CSV files** via HTTP POST requests.
- **Parses CSV** using `pandas`.
- **Stores data** in MySQL using `mysql-connector-python`.

### 🔹 Dependencies
The backend requires the following Python packages (found in `requirements.txt`):
```txt
Flask
pandas
pymysql
mysql-connector-python
```

### 🔹 API Endpoint
- **`POST /upload`**
  - Accepts a CSV file (`file` in form-data).
  - Reads and inserts data into MySQL.
  - Returns a success message or an error.

Example request using `curl`:
```bash
curl -X POST -F "file=@data.csv" http://localhost:5000/upload
```

---
## 🗄️ Database - MySQL
### 🔹 Configuration (Dockerfile)
```dockerfile
FROM mysql:5.7
ENV MYSQL_ROOT_PASSWORD=rootpassword
ENV MYSQL_DATABASE=mydatabase
EXPOSE 3306
```
This sets up a MySQL container with the database `mydatabase`.

---
## 📊 Power BI (Metabase)
### 🔹 Configuration (Dockerfile)
```dockerfile
FROM metabase/metabase:latest
ENV MB_JETTY_PORT=8081
EXPOSE 8081
CMD ["java", "-jar", "/app/metabase.jar"]
```
Metabase runs on **port 8081**, allowing users to visualize stored data.

---
## 🚀 Running the Project
### 🔹 Using Docker Compose
To start all services, run:
```bash
docker-compose up -d
```
This will:
1. Start the **MySQL database**.
2. Start the **Flask backend**.
3. Start **Metabase** for visualization.

### 🔹 Stopping Services
```bash
docker-compose down
```

---
##  Pipeline - Jenkinsfil

pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/YourRepo/3tier-app.git'  // استبدل بالرابط الفعلي
            }
        }

        stage('Build and Run Containers') {
            steps {
                sh 'docker-compose up -d --build'
            }
        }

        stage('Clean Up') {
            steps {
                sh 'docker-compose down'
            }
        }
    }
}

```

---
## 📝 Notes
- Ensure Docker and Jenkins are installed before running the pipeline.
- Modify `.env` to configure database credentials if necessary.
- Flask backend expects the MySQL service to be named `database` in `docker-compose.yml`.

### 🎯 Next Steps



---

