
# Employee Task & Performance Intelligence Platform

This is a production-grade workforce management platform that enables managers to assign tasks, monitor team productivity, and generate AI-driven performance insights.

The system goes beyond traditional employee management by providing **predictive analytics**, **workload intelligence**, and **risk detection** powered by Machine Learning.

---

# 📌 Problem Statement

Modern teams struggle with:

* Lack of visibility into employee workload
* Subjective performance reviews
* Late discovery of task delays
* Poor task distribution
* No early burnout detection

We solve these problems using **data-driven insights and ML predictions**.

---

# 🎯 Key Features

## 👨‍💼 Manager Module

* Profile management
* Attendance monitoring
* Workspace (Room) management
* Task creation and assignment
* Leave request approval/rejection
* Broadcast messages to workspace
* Employee performance view
* **AI-powered Manager Dashboard ⭐**

---

## 👩‍💻 Employee Module

* Profile management
* View assigned tasks
* Update task status
* Apply for leave
* View workspace hierarchy
* Receive notifications
* Exit workspace

---

# ⭐ Manager Dashboard (Intelligence Hub)

The Manager Dashboard is the **central decision-making screen** that provides real-time and predictive insights.

## 🔥 Dashboard Capabilities

### 📊 KPI Summary

* Total employees
* Active tasks
* Overdue tasks
* Average performance score

---

### 🧭 Team Workload Heatmap

Shows capacity utilization for each employee.

**Formula:**

```
workload % = assigned_task_hours / weekly_capacity_hours
```

**Benefits:**

* Detect overloaded employees
* Balance work distribution
* Improve planning

---

### 🚨 Delay Risk Prediction (ML)

Predicts probability of task delay.

**Example Output:**

```
Payment API → 78% risk
Mobile UI → 64% risk
```

**Model Inputs:**

* Task complexity
* Employee workload
* Historical delay rate
* Task age

---

### 🔥 Overloaded Employees Panel

Flags employees whose workload exceeds capacity.

**Rule (v1):**

```
if workload > 100% → overloaded
```

---

### 📈 Task Completion Trend

Weekly productivity visualization showing:

* Tasks completed per week
* Team velocity
* Performance trend

---

### ⚠️ Burnout Risk Detection

Identifies employees at risk of burnout.

**Signals Used:**

* Sustained high workload
* Increasing delay rate
* Excess active tasks

**Risk Levels:**

* LOW
* MEDIUM
* HIGH

---

# 🏗️ System Architecture

## Backend

* Spring Boot 3
* Spring Security + JWT
* Spring Data JPA
* PostgreSQL
* Redis (caching)
* Scheduler for analytics

## Frontend

* Angular
* Angular Material
* ngx-charts / ECharts
* Responsive dashboard UI

## ML/AI Layer

* Python FastAPI microservice
* scikit-learn / XGBoost
* Feature engineering pipeline
* Model versioning

---

# 🗄️ Core Database Entities

* employees
* workspaces
* workspace_members
* tasks
* task_status_history
* task_predictions
* employee_performance_daily
* notifications
* leave_requests

---

# 🔄 Task Lifecycle

```
CREATED → ASSIGNED → IN_PROGRESS → BLOCKED → COMPLETED → REJECTED
```

Derived state: **OVERDUE**

---

# 📡 Key API Endpoints

## Dashboard

```
GET /api/dashboard/summary
GET /api/dashboard/workload
GET /api/dashboard/delay-risks
GET /api/dashboard/burnout
GET /api/dashboard/completion-trend
```

## Tasks

```
POST /api/tasks
PUT /api/tasks/{id}/status
GET /api/tasks/assigned
```

## Leave

```
POST /api/leave/apply
PUT /api/leave/{id}/review
```

---

# 🧠 Machine Learning Components

* Task delay prediction
* Employee performance scoring
* Workload forecasting
* Burnout detection
* (Planned) Smart task assignment

---

# 🚀 Getting Started

## Prerequisites

* Java 17+
* Node.js 18+
* PostgreSQL
* Python 3.10+ (for ML service)
* Docker (optional but recommended)

---

## Backend Setup

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

---

## Frontend Setup

```bash
cd frontend
npm install
ng serve
```

---

## ML Service (Optional)

```bash
cd ml-service
pip install -r requirements.txt
uvicorn app:app --reload
```

---

# 📊 Future Enhancements

* Explainable AI panel
* Smart task auto-assignment
* What-if workload simulator
* Multi-tenant SaaS support
* Real-time WebSocket updates
* Kubernetes deployment

---

# 🏆 Why This Project Stands Out

✅ Predictive workforce analytics
✅ ML-powered risk detection
✅ Production-grade architecture
✅ Real-world scalability
✅ Microservice-ready design
✅ Enterprise dashboard

---

# 📄 License

MIT License

---

# 👤 Author

**Akash Adhya**

---

⭐ If you found this project useful, consider giving it a star!
