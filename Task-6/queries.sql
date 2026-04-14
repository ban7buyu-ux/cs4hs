CREATE TABLE audit_log (
log_id	INT AUTO_INCREMENT PRIMARY KEY,
action	VARCHAR(10), student_id INT,
log_time DATETIME DEFAULT NOW()
);
-- Trigger on INSERT DELIMITER $$
CREATE TRIGGER after_student_insert AFTER INSERT ON students
FOR EACH ROW BEGIN
INSERT INTO audit_log (action, student_id) VALUES ('INSERT', NEW.id);
END$$
-- Trigger on UPDATE
CREATE TRIGGER after_student_update AFTER UPDATE ON students
FOR EACH ROW BEGIN
INSERT INTO audit_log (action, student_id) VALUES ('UPDATE', NEW.id);
END$$ DELIMITER ;
-- View: daily activity report
 
CREATE VIEW daily_activity AS
SELECT DATE(log_time) AS activity_date, action, COUNT(*) AS total_actions
FROM audit_log
GROUP BY DATE(log_time), action; SELECT * FROM daily_activity;
