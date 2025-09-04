console.log("✅ login.js loaded");

const USER_URL = "http://localhost:8080/api/user/all";

document.getElementById("loginForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const email = document.getElementById("email").value.trim();
  const password = document.getElementById("password").value.trim();
  const msg = document.getElementById("loginMessage");

  try {
    const res = await fetch(USER_URL);
    const users = await res.json();

    const user = users.find(u => u.email === email && u.password === password);
    if (!user) {
      msg.textContent = "❌ Invalid email or password.";
      msg.classList.add("text-danger");
      return;
    }

    localStorage.setItem("loggedUser", JSON.stringify(user));
    msg.textContent = `✅ Welcome ${user.username}! Redirecting...`;
    msg.classList.remove("text-danger");
    msg.classList.add("text-success");

    setTimeout(() => {
      window.location.href = "pet.html";
    }, 1200);
  } catch (err) {
    console.error("Login error:", err);
    msg.textContent = "⚠️ Login failed. Check console.";
    msg.classList.add("text-danger");
  }
});
