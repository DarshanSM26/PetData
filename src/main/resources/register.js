/*document.getElementById('registerForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const user = {
        username: document.getElementById('username').value,
        email: document.getElementById('email').value,
        password: document.getElementById('password').value,
        userphone: document.getElementById('userphone').value,
        useraddress: document.getElementById('useraddress').value,
        role: document.getElementById('role').value
    };
    fetch('http://localhost:8080/api/users/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(user)
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('message').textContent = 'Registration successful!';
    })
    .catch(error => {
        document.getElementById('message').textContent = 'Registration failed.';
    });
});*/


document.getElementById('registerForm').addEventListener('submit', function(e) {
    e.preventDefault();

    // Basic frontend validation example
    const username = document.getElementById('username').value.trim();
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value;
    if (username.length < 3) {
        showMessage('Username must be at least 3 characters');
        return;
    }
    if (!validateEmail(email)) {
        showMessage('Invalid email format');
        return;
    }
    if (password.length < 6) {
        showMessage('Password must be at least 6 characters');
        return;
    }

    const user = {
        username: username,
        email: email,
        password: password,
        userphone: document.getElementById('userphone').value.trim(),
        useraddress: document.getElementById('useraddress').value.trim(),
        role: document.getElementById('role').value
    };

    fetch('http://localhost:8080/api/users/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(user)
    })
    .then(async response => {
        if (!response.ok) {
            // Extract error message from backend if available
            const errorData = await response.json();
            throw new Error(errorData.message || 'Registration failed');
        }
        return response.json();
    })
    .then(data => {
        showMessage('Registration successful!', 'success');
        // Optionally reset form here: document.getElementById('registerForm').reset();
    })
    .catch(error => showMessage(error.message));

});

function showMessage(msg, type = 'error') {
    const messageDiv = document.getElementById('message');
    messageDiv.textContent = msg;
    messageDiv.style.color = (type === 'error') ? '#d32f2f' : '#388e3c';
}

function validateEmail(email) {
    // Simple regex email validation
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}

