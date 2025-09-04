/*const signUpButton = document.getElementById("signUp");
const signInButton = document.getElementById("signIn");
const container = document.getElementById("container");

signUpButton.addEventListener("click", () => {
  container.classList.add("right-panel-active");
});

signInButton.addEventListener("click", () => {
  container.classList.remove("right-panel-active");
});

// Register User
document.getElementById("registerForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const data = {
    username: document.getElementById("regUsername").value,
    email: document.getElementById("regEmail").value,
    password: document.getElementById("regPassword").value,
    userphone: document.getElementById("regPhone").value,
    useraddress: document.getElementById("regAddress").value,
    role: "user"
  };

  const res = await fetch("http://localhost:8080/api/users/register", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data)
  });

  if (res.ok) {
    alert("✅ Registration Successful");
    container.classList.remove("right-panel-active");
  } else {
    alert("❌ Registration Failed");
  }
});

// Login User
document.getElementById("loginForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const data = {
    email: document.getElementById("loginEmail").value,
    password: document.getElementById("loginPassword").value
  };

  const res = await fetch("http://localhost:8080/api/users/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data)
  });

  if (res.ok) {
    const user = await res.json();
    localStorage.setItem("user", JSON.stringify(user)); // store user data
    window.location.href = "welcome.html"; // redirect
  } else {
    alert("❌ Invalid Credentials");
  }
});*/


// Register User
const res = await fetch("http://localhost:8080/demo/user/register", {
  method: "POST",
  headers: { "Content-Type": "application/json" },
  body: JSON.stringify(data)
});

// Login User
const res = await fetch("http://localhost:8080/demo/user/login", {
  method: "POST",
  headers: { "Content-Type": "application/json" },
  body: JSON.stringify(data)
});

