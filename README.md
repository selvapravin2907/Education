# Smart Office Facility Console Application

A Java console-based application to manage a smart office facility using classic design patterns.  
The system supports conference room bookings, occupancy detection, and automates air conditioning and lighting based on real-time room usage.

---

## 🚀 Features

### Mandatory
- **Configure Office**: Set up the number of meeting rooms and their capacities.
- **Book & Cancel**: Book and cancel conference room bookings with time slots.
- **Occupancy Detection**: Use simulated sensors to track occupants in each room.
- **Auto-release Bookings**: Automatically release bookings if a room is not occupied within 5 minutes.
- **Smart Controls**: Automatically turn AC and lights on/off based on occupancy.

### Optional (can be extended)
- Room usage statistics and reporting.
- User authentication for restricted actions.
- Email/SMS notifications for booking status.

---

## 🛠️ Design Patterns Used

- **Singleton**: Office configuration and booking management.
- **Observer**: Room controllers (AC, lights) react to occupancy changes.
- **Command**: All user actions (book, cancel, add occupants, config) are handled as commands for scalability.

---

## 📁 Project Structure

```
com/smartoffice/
  SmartOfficeApp.java
  core/
    OfficeConfig.java
    MeetingRoom.java
    Booking.java
  observer/
    OccupancyObserver.java
    OccupancySubject.java
    LightController.java
    ACController.java
  command/
    Command.java
    BookRoomCommand.java
    CancelRoomCommand.java
    AddOccupantCommand.java
    ConfigRoomCommand.java
    CommandInvoker.java
  util/
    TimeUtils.java
```

---

## 🏁 Getting Started

### 1. **Clone or Download**  
Copy all files into your local directory following the structure above.

### 2. **Build**
From the `src` directory (containing `com/`), compile all files:
```sh
javac com/smartoffice/SmartOfficeApp.java com/smartoffice/command/*.java com/smartoffice/core/*.java com/smartoffice/observer/*.java com/smartoffice/util/*.java
```
Or (recommended for Windows):
```sh
dir /S /B *.java > sources.txt
javac @sources.txt
```

### 3. **Run**
```sh
java com.smartoffice.SmartOfficeApp
```

---

## 💡 Example Console Commands

| Command                                  | Description                                            |
|-------------------------------------------|--------------------------------------------------------|
| `Config room count 3`                     | Configure office with 3 meeting rooms                  |
| `Config room max capacity 1 10`           | Set Room 1 max capacity to 10                          |
| `Block room 1 09:00 60`                   | Book Room 1 at 09:00 for 60 minutes                    |
| `Add occupant 1 2`                        | Add 2 occupants to Room 1                              |
| `Cancel room 1`                           | Cancel Room 1's booking                                |
| `Add occupant 1 0`                        | Mark Room 1 as empty (release booking if needed)       |
| `status`                                  | Show status of all rooms                               |
| `exit`                                    | Exit the application                                   |

**Negative Cases:**
- Booking an already booked room: `"Room 1 is already booked during this time. Cannot book."`
- Cancelling a non-booked room: `"Room 2 is not booked. Cannot cancel booking."`
- Adding insufficient occupants: `"Room 2 occupancy insufficient to mark as occupied."`
- Non-existent room: `"Room 4 does not exist."`
- Invalid capacity: `"Invalid capacity. Please enter a valid positive number."`

---

## ✨ Extending

- Add reporting, notifications, or authentication as needed.
- For questions or improvements, open an issue or PR!

---

## 👨‍💻 Author

- **Designed for interview/educational purposes**
- Example owner: selvapravin2907

---