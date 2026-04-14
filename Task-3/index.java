function validateLogin() {
const username = document.getElementById('username').value.trim(); const password = document.getElementById('password').value;
const errBox = document.getElementById('error'); if (username === '') {
errBox.textContent = 'Username cannot be empty.'; return false;
}
if (password.length < 6) {
errBox.textContent = 'Password must be at least 6 characters.'; return false;
}
errBox.textContent = ''; return true;
}
