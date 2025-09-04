// Example data - you would fetch real data from your backend API
const users = [
  { id: 1, username: "vetadmin", email: "admin@vetpawtner.com", role: "admin" },
  { id: 2, username: "user1", email: "user1@mail.com", role: "user" },
  { id: 3, username: "user2", email: "user2@mail.com", role: "user" },
];

document.addEventListener("DOMContentLoaded", function() {
  // Fill recent users table
  const tbody = document.getElementById("userTableBody");
  tbody.innerHTML = users.map(user =>
    `<tr>
      <td>${user.id}</td>
      <td>${user.username}</td>
      <td>${user.email}</td>
      <td>${user.role}</td>
    </tr>`
  ).join("");
  // Example stats
  document.getElementById("userCount").textContent = users.length;
  document.getElementById("petCount").textContent = "52";
  document.getElementById("apptCount").textContent = "15";
  document.getElementById("reportCount").textContent = "4";
});
