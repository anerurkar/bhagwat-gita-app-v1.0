# Bhagavad Gita Explorer

A complete **Bhagavad Gita reading app** with all 18 chapters and 700 shlokas, built with **Angular (frontend)** and **Spring Boot (backend)**. This app provides chapter-wise shlokas in **Sanskrit**, **English meaning**, and **guidance**, allowing users to explore, read, and reflect on the teachings of the Gita.

---

## Features

- **Complete Bhagavad Gita**: All 18 chapters, 700 shlokas.
- **Chapter-wise navigation**: Easily browse chapters and their shlokas.
- **Structured data**: Each shloka includes:
  ```json
  {
      "number": 1,
      "sanskrit": "...",
      "meaning": "...",
      "guidance": "..."
  }

Clean UI: Minimalistic and distraction-free reading experience.

Expandable: Backend JSON structure allows future AI/GenAI integration.

Tech Stack

Frontend: Angular 17

Backend: Spring Boot 3.2 (REST API)

Data: JSON format (shlokas and chapters)

Build Tool: Maven (backend), Node.js + npm (frontend)

Installation & Running
Backend

Navigate to backend folder:

cd backend


Build and run with Maven:

mvn clean install
mvn spring-boot:run


Backend will start at: http://localhost:8080

Frontend

Navigate to frontend folder:

cd frontend


Install dependencies:

npm install


Run Angular app:

ng serve


Open your browser at: http://localhost:4200

JSON Structure

Each chapter is structured as:

{
  "chapterNumber": 1,
  "chapterName": "Arjuna Vishada Yoga",
  "shlokas": [
    {
      "number": 1,
      "sanskrit": "...",
      "meaning": "...",
      "guidance": "..."
    }
  ]
}

Future Enhancements

Search & filter: Find shlokas by keywords or guidance topics.

Daily shloka notification: Send users a daily shloka and guidance.

GenAI integration: Ask questions in natural language to get Gita-based guidance.

Multi-language support: Add Hindi, Tamil, or other regional translations.
