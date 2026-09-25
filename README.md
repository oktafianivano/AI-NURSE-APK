# 🩺 AI-NURSE — Smart Triage & Nursing Care System

> A desktop-based medical application integrating AI-powered emergency triage, JavaFX interface, and Indonesia's official nursing diagnosis standards (SDKI & SIKI).

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![JavaFX](https://img.shields.io/badge/JavaFX-21-blue?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Laragon-blue?style=for-the-badge&logo=mysql)
![Groq API](https://img.shields.io/badge/AI-Groq%20gpt--oss--120b-red?style=for-the-badge)

---

## ✨ Key Features

- **🤖 AI-Powered Emergency Triage**: Automatically classifies patient urgency into Red, Yellow, or Green status using LLM (`openai/gpt-oss-120b` via Groq).
- **👥 Dual Point-of-View (POV)**: Separated workflows and UI for Patient registration and Nurse management dashboard.
- **📚 Integrated SDKI & SIKI**: Standardized medical logging aligned with Indonesian Nursing Care Standards.
- **💬 AI Clinical Assistant**: Real-time clinical query assistance for nurses in emergency rooms.

---

## 🛠️ Tech Stack

| Component | Technology / Library |
| :--- | :--- |
| **Language** | Java 21 |
| **GUI Framework**| JavaFX |
| **Database** | MySQL (Laragon / Localhost) |
| **AI Integration**| Groq Cloud API (`openai/gpt-oss-120b`) |
| **JSON Parser** | `org.json` |
| **PDF Export** | iTextPDF |

---

## 🚀 Quick Start & Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/USERNAME_LU/AI-NURSE-APK.git
   cd AI-NURSE-APK
   ```

2. **Import Database**
   Jalankan MySQL (Laragon), lalu import `database/db_nurse (2).sql` melalui phpMyAdmin atau CLI:
   ```bash
   mysql -u root -p < "database/db_nurse (2).sql"
   ```
  >Kredensial demo bawaan (ganti di `src/main/java/com/project/ainurse/utils/DatabaseConfig.java`):
   | Username | Password |
   | :--- | :--- |
   | `dita` | `dita123` |
   | `vano` | `vano123` |

3. **Masukkan Groq API Key**
   Edit `src/main/java/com/project/ainurse/utils/geminiservice.java` dan ganti nilai `API_KEY`:
   ```java
   private static final String API_KEY = "CREATE_API_BY_YOUR_OWN";
   ```
   > Repository ini sengaja **tidak** menyimpan API key. Ambil key gratis di [console.groq.com](https://console.groq.com/keys).

4. **Jalankan Aplikasi**
   ```bash
   mvnw clean javafx:run
   ```
   Atau buka di IntelliJ IDEA lalu jalankan kelas `com.project.ainurse.Launcher`.

---

## 📸 Preview

| Home | Checking Status |
| :---: | :---: |
| ![Home](screenshots/Home.png) | ![Checking Status](screenshots/Checking%20Status.png) |

| Main Dashboard | Statistik |
| :---: | :---: |
| ![Main Dashboard](screenshots/Main%20Dashboard.png) | ![Statistik](screenshots/Statistik.png) |

![AI Chat](screenshots/AI%20Chat.png)