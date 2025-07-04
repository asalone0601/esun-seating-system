## 程式碼版本控制
本專案已上傳至 GitHub，請見：[https://github.com/asalone0601/esun-seating-system]

玉山銀行員工座位系統

系統架構
前端：Vue.js

後端：Spring Boot（RESTful API）

資料庫：PostgreSQL

三層式架構：Web Server + Application Server + DB

DB DDL/DML/Stored Procedure 皆存放於 /DB 資料夾

專案目錄結構
demo/
├── DB/
│   ├── init_data.sql
│   ├── schema.sql
│   └── sp_assign,release.sql
├── src/
│   ├── api/
│   │   └── seatApi.js
│   ├── components/
│   │   └── SeatGrid.vue
│   └── main/
│       ├── java/
│       │   └── com.esunbank.demo/
│       │       ├── controller/
│       │       │   └── SeatingController.java
│       │       ├── dto/
│       │       ├── entity/
│       │       │   ├── Employee.java
│       │       │   └── SeatingChart.java
│       │       ├── repository/
│       │       │   ├── EmployeeRepository.java
│       │       │   └── SeatingChartRepository.java
│       │       ├── service/
│       │       │   ├── EmployeeService.java
│       │       │   ├── SeatingService.java
│       │       │   └── SeatingServiceImpl.java
│       │       ├── CorsConfig.java
│       │       ├── WebConfig.java
│       │       └── DemoApplication.java
│       └── resources/
│           └── application.properties
├── App.vue
├── README.md
├── pom.xml
└── ...

資料庫初始化步驟：

建立資料庫

使用 PostgreSQL 建立資料庫 esun_seating（或依 application.properties 設定）。

依序執行 SQL 檔案

進入 DB 資料夾，依序執行：

schema.sql（建立資料表）

init_data.sql（插入初始資料）

sp_assign,release.sql（建立 Stored Procedure）

確認資料庫內容

資料表：Employee、SeatingChart

初始資料與 SP 正確建立

專案啟動方式：

設定資料庫連線

編輯 src/main/resources/application.properties，確認下列設定正確：

text
spring.datasource.url=jdbc:postgresql://localhost:5432/esun_seating
spring.datasource.username=你的帳號
spring.datasource.password=你的密碼
啟動後端 Spring Boot

使用 IDE 或命令列執行：

text
mvn spring-boot:run
伺服器預設埠為 8080

啟動前端 Vue

進入前端專案資料夾（如 demo 或 frontend）

text
npm install
npm run serve
前端預設埠為 8081

瀏覽器開啟

前端：http://localhost:8081

後端 API：http://localhost:8080/api/seats/...

功能說明：

多樓層座位圖顯示（空位/已佔用/請選擇）

員工選單（可換座位、員編長度5碼）

送出即異動資料庫（支援 Transaction、Stored Procedure）

釋放座位功能

前後端分離，RESTful API 設計

防 SQL Injection（JPA/Hibernate 預設防護）、防 XSS（前端不使用 v-html）

專案交付內容

/DB 資料夾：包含 schema.sql、init_data.sql、sp_assign_release.sql

完整原始碼（前後端）

其他注意事項：

若需自動初始化資料庫，可將 SQL 檔案複製到 src/main/resources 並依 Spring Boot 官方規範命名。

若有資料庫帳號密碼不同，請在 application.properties 內調整。

如遇資料庫連線或初始化問題，請先確認 PostgreSQL 服務已啟動，資料庫已建立，SQL 檔案已依序執行。

如有任何問題，請聯絡專案負責人或參考原始需求說明文件。
