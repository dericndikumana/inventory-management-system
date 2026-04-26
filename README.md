# Inventory Management System (IMS)

A web-based application built with Java and Spring Boot to manage company assets, track assignments to employees, and provide a clear overview of the inventory status.

##  Features

*   **Secure Authentication:** Login system for administrators using Spring Security.
*   **Dashboard:** An at-a-glance summary of all assets, including counts for available, assigned, and in-repair items.
*   **Asset Management (CRUD):**
    *   Add new assets with detailed information (device type, model, serial number, etc.).
    *   View a searchable and filterable list of all assets.
    *   Edit existing asset details.
    *   Delete assets from the inventory.
*   **Assignment Tracking:**
    *   Issue assets to employees with details like employee name, department, and purpose.
    *   View a list of all active and historical assignments.
    *   Process asset returns, updating the asset's status back to "Available".
*   **Reporting:** A dedicated section for generating inventory reports (feature to be expanded).

##  Technology Stack

*   **Backend:**
    *   Java 21
    *   Spring Boot 3
    *   Spring Security (for authentication)
    *   Spring Data JPA (for database interaction)
    *   Maven (for dependency management)
*   **Frontend:**
    *   Thymeleaf (for server-side templating)
    *   HTML5 & CSS3
*   **Database:**
    *   **Local:** MySQL
    *   **Production:** PostgreSQL (configured for deployment)

##  Prerequisites

Before you begin, ensure you have the following installed on your local machine:
*   JDK 21 (Java Development Kit)
*   Apache Maven
*   MySQL Server

##  Local Setup and Installation

Follow these steps to get the project running on your local machine.

1.  **Clone the Repository:**
    ```bash
    git clone <your-repository-url>
    cd IMS
    ```

2.  **Set Up the Database:**
    *   Make sure your MySQL server is running.
    *   Create a new database named `ims_db`.
    ```sql
    CREATE DATABASE ims_db;
    ```
    *   The application is configured to automatically create the necessary tables and populate initial data from `src/main/resources/data.sql` on the first run.

3.  **Configure Application Properties:**
    *   Open the `src/main/resources/application.properties` file.
    *   Verify that the `spring.datasource.username` and `spring.datasource.password` match your local MySQL credentials.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/ims_db
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    ```

4.  **Run the Application:**
    *   Open a terminal in the project's root directory.
    *   Use the Maven wrapper to build and run the project:
    ```bash
    ./mvnw spring-boot:run
    ```
    *   The application will start on `http://localhost:8080`.

##  Usage

*   **Access the application:** Open your web browser and navigate to `http://localhost:8080`.
*   **Login:** Use the default administrator credentials:
    *   **Username:** `24RP09739`
    *   **Password:** `24rp06926`
*   Once logged in, you will be directed to the main dashboard where you can navigate to different sections using the sidebar.

