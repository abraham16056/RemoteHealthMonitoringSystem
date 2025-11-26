# Remote Health Monitoring System (RHMS)

## Project Description

A Remote Health Monitoring System developed for Near East University Hospital. This system monitors vital signs of patients with chronic conditions (hypertension, diabetes, etc.) through wearable devices and sends alerts to doctors when abnormal values are detected.

## Project Structure

```
RemoteHealthMonitoringSystem/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── rhms/
│                   ├── Main.java
│                   ├── models/
│                   │   ├── VitalSign.java (Abstract)
│                   │   ├── HeartRate.java
│                   │   ├── BloodPressure.java
│                   │   ├── Temperature.java
│                   │   ├── WearableDevice.java
│                   │   ├── Patient.java
│                   │   ├── Doctor.java
│                   │   ├── Alert.java
│                   │   ├── Recommendation.java
│                   │   └── FollowUp.java
│                   └── services/
│                       ├── MonitoringService.java
│                       └── AlertService.java
└── README.md
```

## Class Diagram and Relationships

### Model Classes

1. **VitalSign** (Abstract Class)
   - Base class for all vital signs
   - Subclasses: `HeartRate`, `BloodPressure`, `Temperature`
   - Methods: `isAbnormal()`, `getValueAsString()`

2. **HeartRate** extends VitalSign
   - Heart rate (bpm)
   - Normal range: 60-100 bpm

3. **BloodPressure** extends VitalSign
   - Blood pressure (systolic/diastolic)
   - Normal: < 120/80 mmHg

4. **Temperature** extends VitalSign
   - Body temperature (°C)
   - Normal range: 36.1-37.2°C

5. **WearableDevice**
   - Wearable device information
   - Related to Patient (one-to-many)

6. **Patient**
   - Patient information
   - Relationships:
     - One or more WearableDevice
     - One or more VitalSign
     - One Doctor (assignedDoctor)

7. **Doctor**
   - Doctor information
   - Relationships:
     - One or more Patient
     - One or more Alert
   - Methods: `reviewAlert()`, `scheduleFollowUp()`

8. **Alert**
   - Alert for abnormal vital signs
   - Related to Patient and VitalSign

9. **Recommendation**
   - Doctor's recommendations
   - Related to Alert and Doctor

10. **FollowUp**
    - Follow-up appointments
    - Related to Patient and Doctor

### Service Classes

1. **MonitoringService**
   - Receives vital signs from wearable devices
   - Detects abnormal values
   - Triggers AlertService

2. **AlertService**
   - Creates alerts for abnormal vital signs
   - Sends alerts to doctors

## How to Run

### Requirements
- Java JDK 8 or higher

### Compilation and Execution

```bash
# Navigate to project directory
cd RemoteHealthMonitoringSystem

# Compile Java files
javac -d out -sourcepath src/main/java src/main/java/com/rhms/**/*.java

# Run the program
java -cp out com.rhms.Main
```

Alternatively, you can open the project in an IDE (IntelliJ IDEA, Eclipse, VS Code) and run the `Main.java` file.

## System Flow

1. **Vital Sign Recording**: Wearable devices measure patient's vital signs
2. **Data Transmission**: Vital signs are sent to MonitoringService
3. **Analysis**: MonitoringService analyzes the vital sign
4. **Alert Creation**: If abnormal value is detected, AlertService creates an alert
5. **Doctor Notification**: Alert is sent to patient's assigned doctor
6. **Review**: Doctor reviews the alert and provides recommendations
7. **Follow-up**: If needed, doctor schedules a follow-up appointment

## Example Output

When the program runs, the following scenarios are simulated:
- Normal heart rate recording
- Abnormal heart rate (tachycardia) detection and alert
- High blood pressure detection and alert
- Normal body temperature
- High fever detection and alert
- Doctor reviewing alerts and providing recommendations
- Follow-up appointment scheduling

## Design Principles

- **Inheritance**: VitalSign abstract class is extended by HeartRate, BloodPressure, and Temperature
- **Association**: Patient-Doctor, Patient-WearableDevice, Patient-VitalSign relationships
- **Encapsulation**: Private fields and public getter/setter methods in all classes
- **Polymorphism**: VitalSign subclasses implement isAbnormal() method differently

## Reflection

### Easy Parts of Implementation

1. **Class Design**: Creating classes from UML diagram and defining basic properties was relatively easy. Since each class had clear responsibilities, the code structure could be created in an understandable way.

2. **Inheritance Structure**: Creating the VitalSign abstract class and extending it with subclasses was a logical approach. This reduced code duplication and centralized common behaviors.

3. **Basic Relationships**: Implementing basic relationships like Patient-Doctor, Patient-Device using ArrayList was straightforward. Java's collection classes were very helpful in this regard.

4. **Service Layer**: Keeping MonitoringService and AlertService separate increased the system's modularity and made maintenance easier.

### Difficult Parts of Implementation

1. **Abnormal Value Detection**: Determining normal ranges for each vital sign type and detecting abnormal values required attention. Different normal ranges could exist for different age groups and health conditions, but I used general ranges for simplicity.

2. **Alert Severity Determination**: In AlertService, checking each vital sign type to determine alert severity was necessary. I had to use instanceof in this part, which is not an ideal solution. Strategy Pattern could be used for a better approach.

3. **Time Management**: Using LocalDateTime from Java 8+ would be more modern than using Date class, but Date was preferred for compatibility.

4. **Error Handling**: A real system would require more comprehensive error handling (exception handling) and validation. The current implementation has basic checks but more development is needed for production.

### Lessons Learned and Improvement Suggestions

1. **Design Patterns**: Observer Pattern (for alert notifications) and Strategy Pattern (for abnormal value detection) could be used in this project. This would make the code more flexible and extensible.

2. **Database Integration**: The current implementation works in-memory. A real system would require database integration (JDBC, JPA/Hibernate).

3. **API Layer**: The system could be opened to the outside world by adding a RESTful API. Spring Framework could be used.

4. **Testing**: Unit tests (JUnit) and integration tests should be added. Increasing test coverage improves code quality.

5. **Logging**: A professional logging framework (Log4j, SLF4J) should be used instead of System.out.println.
