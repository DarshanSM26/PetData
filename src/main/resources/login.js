document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const user = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };
    fetch('http://localhost:8080/api/users/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(user)
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('message').textContent = 'Login successful!';
        // optionally redirect or store session here
    })
    .catch(error => {
        document.getElementById('message').textContent = 'Login failed.';
    });
});
