# 🧾 Student Management System — Lab Assignment 2 (Java)

## 📘 Overview
This project implements an extended **Student Management System** using advanced OOP principles.  
It demonstrates **inheritance, abstract classes, interfaces, polymorphism, and method overloading/overriding**.

The system supports:
- Adding student records
- Updating student details
- Deleting student records
- Searching by Roll Number
- Viewing all stored students

---

## 🧠 Core Concepts Used

### 🔹 Inheritance
`Student` extends the abstract class `Person`.

### 🔹 Abstract Class
- `Person` → Base class containing shared attributes (name, email)
- Requires implementation of `displayInfo()` in child class

### 🔹 Interface
`RecordActions` defines CRUD methods:
- `addStudent()`
- `deleteStudent()`
- `updateStudent()`
- `searchStudent()`
- `viewAllStudents()`

### 🔹 Polymorphism
- **Method Overriding** → `displayInfo()` redefined in `Student`
- **Method Overloading** → Multiple `displayInfo(...)` versions

### 🔹 Encapsulation
Student details hidden using private fields and controlled access.

---

## 🏗️ Class Design

### 🧩 1. Abstract Class: `Person`
**Fields**
- `name`
- `email`

**Method**
- `displayInfo()` → abstract

---

### 🧩 2. Class: `Student` (extends `Person`)
**Fields**
- `rollNo`
- `course`
- `marks`
- `grade`

**Methods**
- `displayInfo()` → override
- `displayInfo(extra)` → overload
- `calculateGrade()`

---

### 🧩 3. Interface: `RecordActions`
Defines CRUD operations:
- `addStudent()`
- `deleteStudent()`
- `updateStudent()`
- `searchStudent()`
- `viewAllStudents()`

---

### 🧩 4. Class: `StudentManager` (implements RecordActions)
Responsible for managing records:
- Stores student objects (ArrayList or HashMap)
- Prevents duplicate roll numbers
- Implements interface functions

---

## 🎓 Grade Logic (Example)
- Marks ≥ 85 → `A`
- Marks ≥ 70 → `B`
- Marks ≥ 55 → `C`
- Marks < 55 → `D`

(Adjustable as needed)

---

## 🖥️ Menu Options
