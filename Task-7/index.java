function isValidEmail(email) {
return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}
function isNotEmpty(val) { return val.trim() !== ''; }
// Keypress validation document.getElementById('email')
.addEventListener('keyup', function() {
const msg = document.getElementById('emailMsg'); msg.textContent = isValidEmail(this.value)
? '✓ Valid email' : '✗ Invalid email format'; msg.style.color = isValidEmail(this.value) ? 'green' : 'red';
});
// Mouse hover highlight
document.querySelectorAll('input, textarea').forEach(el => { el.addEventListener('mouseenter', () => el.style.borderColor = '#4f8ef7'); el.addEventListener('mouseleave', () => el.style.borderColor = '#ccc');
});
// Double-click submit confirmation document.getElementById('submitBtn')
.addEventListener('dblclick', function() {
if (isNotEmpty(document.getElementById('name').value)) { alert('Feedback submitted successfully! Thank you.');
} else {
 
alert('Please fill all required fields.');
}
});

