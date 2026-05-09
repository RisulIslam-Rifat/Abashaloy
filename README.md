# Abashaloy

Abashaloy is an offline Java-based desktop application designed to facilitate house rentals. It allows users to browse through available houses, view details, and share their experiences through ratings and reviews. The application is built using Java Swing for the graphical user interface.

## Features

- **User Registration**: New users can create an account by providing their username, email, phone number, and password.
- **User Login**: Secure login system for registered users.
- **House Search**: Search for houses in specific districts and areas (e.g., Dhaka - Basundhara, Mirpur).
- **House Details**: View comprehensive information about selected houses.
- **Review System**: Users can write reviews and give ratings for the houses they have rented.
- **Profile Management**: Users can view their profile information and edit their username and password.
- **Contribution Page**: Information about the project contributors.

## Technologies Used

- **Language**: Java
- **GUI Framework**: Java Swing & AWT
- **Data Storage**: File-based storage (Text files in `User Information/`, `House/`, and `Reviews/` directories).

## Project Structure

- `Start.java`: The entry point of the application.
- `Interface.java`: The initial welcome screen with Login and Sign-up options.
- `LoginForm.java` & `RegisterForm.java`: Handles user authentication and account creation.
- `HomePage.java`: The main dashboard after login, featuring house search functionality.
- `SearchPage*.java`: Displays search results for different areas.
- `HousePage*.java`: Shows detailed information about specific houses.
- `ReviewPage.java`: Allows users to view and submit reviews.
- `ProfilePage.java`: Displays user information.
- `EditPasswordUsernameGUI.java`: Interface for updating user credentials.
- `Contribution.java`: The project's contribution page.
- `House/`: Directory containing house information text files.
- `Reviews/`: Directory containing house reviews.
- `User Information/`: Directory containing user credentials (`data.txt`).
- `Photos/`: Directory containing images and icons used in the GUI.

## Setup and Running

### Prerequisites

- Java Development Kit (JDK) installed.

### Running the Application

1.  **Clone the repository** (or download the source files).
2.  **Compile the project**:
    Open your terminal/command prompt and navigate to the project root directory. Compile the `Start.java` file:
    ```bash
    javac Start.java
    ```
    *Note: Since the project has many dependencies, you might need to compile all `.java` files if they are not already compiled.*
    ```bash
    javac *.java
    ```
3.  **Run the application**:
    ```bash
    java Start
    ```

## Notes

- This application is currently designed for offline use.
- Data is stored locally in text files within the project directory.
- **Important**: Some source files (e.g., `SearchPage.java`, `ReviewPage.java`) appear to be missing from the root directory but are referenced in the code. It is highly recommended to extract the `Abashaloy.rar` file to ensure all necessary components are present before attempting to compile or run the application.
