CREATE TABLE users (
id	INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL -- store hashed password
);
INSERT INTO users (username, password) VALUES ('admin', SHA2('admin123', 256));
