# 📱 Cell Phone Records – Linked List Project

## 📖 Overview
This project implements a custom **linked list** to manage a collection of cell phone records.  
It was developed for **COMP 249 – Object-Oriented Programming II (Fall 2024)**.  

The program demonstrates:
- Creation of a `CellPhone` class with cloning and copy features.
- Implementation of a linked list (`CellList`) using an inner `CellNode` class.
- Insertion, deletion, searching, replacing, and equality-checking operations.
- Reading data from an input file (`Cell_Info.txt`) and preventing duplicate entries.
- Testing and demonstrating all features via a `CellListUtilization` driver program.

⚠️ **Note:** Built-in Java collections (`ArrayList`, `HashMap`, etc.) are not used—only custom-linked structures.

---

## 📂 Project Structure
- **CellPhone.java** – Defines the CellPhone class (`serialNum`, `brand`, `year`, `price`)
- **CellList.java** – Implements the linked list and inner `CellNode`
- **CellListUtilization.java** – Main driver class, loads file and runs program
- **Cell_Info.txt** – Input file containing sample cell phone records

---

## 🛠 Features
- **CellPhone class**
  - Parameterized constructor
  - Copy constructor (assigns new serial number)
  - `clone()` method (prompts for new serial number)
  - `toString()` and `equals()` implementations  

- **CellList class**
  - Inner class `CellNode` (deep-copyable nodes)
  - List operations:
    - `addToStart()`
    - `insertAtIndex()`
    - `deleteFromIndex()`
    - `deleteFromStart()`
    - `replaceAtIndex()`
    - `find(serialNum)` (tracks iterations)
    - `contains(serialNum)`
    - `showContents()`
    - `equals()`  

- **CellListUtilization**
  - Reads `Cell_Info.txt` and builds a `CellList`
  - Ensures no duplicate serial numbers
  - Displays list contents
  - Allows user to search by serial number
  - Tests all constructors and methods
