
/*console.log("✅ vet-v3.js Loaded");     it was working 1

async function loadAppointments() {
  try {
    const res = await fetch("http://localhost:8080/demo/appointments");
    if (!res.ok) throw new Error("Failed to fetch appointments");

    const appointments = await res.json();
    console.log("Appointments JSON:", appointments);

    let html = `<ul class="list-group">`;

    appointments.forEach(app => {
      const petName = app.pet?.name || "Unknown Pet";
      const petId = app.pet?.petId || 0;
      const vetName = app.vetName || "Unknown Vet";
      const date = app.date || "Unknown Date";

      html += `
        <li class="list-group-item d-flex justify-content-between align-items-center">
          <div>
            <strong>${petName}</strong>
            with <strong>${vetName}</strong> on ${date}
          </div>
          <button class="btn btn-sm btn-primary"
            onclick="openHealthForm(${petId}, '${petName}', '${vetName}', '${date}')">
            Update Health
          </button>
        </li>
      `;
    });

    html += `</ul>`;
    document.getElementById("appointmentsList").innerHTML = html;

  } catch (err) {
    console.error("❌ Error loading appointments:", err);
    document.getElementById("appointmentsList").innerHTML =
      `<p style="color:red;">Error loading appointments. See console.</p>`;
  }
}

function openHealthForm(petId, petName, vetName, date) {
  document.getElementById("petId").value = petId;
  document.getElementById("vetName").value = vetName;
  document.getElementById("appointmentDate").value = date;

  document.getElementById("petNameDisplay").innerText = petName;

  const modal = new bootstrap.Modal(document.getElementById("healthModal"));
  modal.show();
}

loadAppointments();*/



console.log("✅ vet-v3.js Loaded");   // it was workiong 2

// Load appointments from backend
async function loadAppointments() {
  try {
    const res = await fetch("http://localhost:8080/demo/appointments");
    if (!res.ok) throw new Error("Failed to fetch appointments");

    const appointments = await res.json();
    console.log("Appointments JSON:", appointments);

    let html = `<ul class="list-group">`;

    appointments.forEach(app => {
      const petName = app.pet?.name || "Unknown Pet";
      const ownerName = app.pet?.owner?.name || "Unknown Owner";
      const petId = app.pet?.petId || 0;
      const vetName = app.vetName || "Unknown Vet";
      const date = app.date || "Unknown Date";

      html += `
        <li class="list-group-item d-flex justify-content-between align-items-center">
          <div>
            <strong>${petName}</strong> (Owner: ${ownerName})
            with <strong>${vetName}</strong> on ${date}
          </div>
          <button class="btn btn-sm btn-primary"
            onclick="openHealthForm(${petId}, '${petName}', '${ownerName}', '${vetName}', '${date}')">
            Update Health
          </button>
        </li>
      `;
    });

    html += `</ul>`;
    document.getElementById("appointmentsList").innerHTML = html;

  } catch (err) {
    console.error("❌ Error loading appointments:", err);
    document.getElementById("appointmentsList").innerHTML =
      `<p style="color:red;">Error loading appointments. See console.</p>`;
  }
}

// Open health form modal
function openHealthForm(petId, petName, ownerName, vetName, date) {
  document.getElementById("petId").value = petId;
  document.getElementById("vetName").value = vetName;
  document.getElementById("appointmentDate").value = date;

  document.getElementById("petNameDisplay").innerText = petName;
  document.getElementById("ownerNameDisplay").innerText = ownerName;

  const modal = new bootstrap.Modal(document.getElementById("healthModal"));
  modal.show();
}

// ✅ Handle health form submit and send data to backend
document.getElementById("healthForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const petId = document.getElementById("petId").value;
  const vetName = document.getElementById("vetName").value;
  const appointmentDate = document.getElementById("appointmentDate").value;
  const weight = document.getElementById("weight").value;
  const temperature = document.getElementById("temperature").value;
  const notes = document.getElementById("notes").value;

  const healthData = { petId, vetName, appointmentDate, weight, temperature, notes };
  console.log("➡️ Sending Health Data:", healthData);

  try {
    const res = await fetch("http://localhost:8080/demo/pet-health", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(healthData)
    });

    if (!res.ok) throw new Error("Failed to save pet health");

    const result = await res.json();
    console.log("✅ Health Saved:", result);

    alert("✅ Pet health updated successfully!");
    const modal = bootstrap.Modal.getInstance(document.getElementById("healthModal"));
    modal.hide();

    // Optionally reload appointments
    loadAppointments();

  } catch (err) {
    console.error("❌ Error saving health:", err);
    alert("❌ Failed to update pet health. Please try again.");
  }
});

// Load appointments when page loads
loadAppointments();


/*
console.log("✅ vet-v3.js Loaded");    3working

async function loadAppointments() {
  try {
    const res = await fetch("http://localhost:8080/demo/appointments");
    if (!res.ok) throw new Error("Failed to fetch appointments");

    const appointments = await res.json();
    console.log("Appointments JSON:", appointments);

    let html = `<ul class="list-group">`;

    appointments.forEach(app => {
      const petName = app.pet?.name || "Unknown Pet";
      const petId = app.pet?.petId || 0;
      const vetName = app.vetName || "Unknown Vet";
      const date = app.date || "Unknown Date";

      html += `
        <li class="list-group-item d-flex justify-content-between align-items-center">
          <div>
            <strong>${petName}</strong>
            with <strong>${vetName}</strong> on ${date}
          </div>
          <button class="btn btn-sm btn-primary"
            onclick="openHealthForm(${petId}, '${petName}', '${vetName}', '${date}')">
            Update Health
          </button>
        </li>
      `;
    });

    html += `</ul>`;
    document.getElementById("appointmentsList").innerHTML = html;

  } catch (err) {
    console.error("❌ Error loading appointments:", err);
    document.getElementById("appointmentsList").innerHTML =
      `<p style="color:red;">Error loading appointments. See console.</p>`;
  }
}

function openHealthForm(petId, petName, vetName, date) {
  document.getElementById("petId").value = petId;
  document.getElementById("vetName").value = vetName;
  document.getElementById("appointmentDate").value = date;

  document.getElementById("petNameDisplay").innerText = petName;

  const modal = new bootstrap.Modal(document.getElementById("healthModal"));
  modal.show();
}

loadAppointments();

// ✅ ADD THIS PART BELOW loadAppointments
document.getElementById("healthForm").addEventListener("submit", (e) => {
  e.preventDefault();

  const petName = document.getElementById("petNameDisplay").innerText;
  const weight = document.getElementById("weight").value;
  const temperature = document.getElementById("temperature").value;
  const notes = document.getElementById("notes").value;

  // Save data locally to show on next page
  const petHealth = { petName, weight, temperature, notes };
  localStorage.setItem("lastHealth", JSON.stringify(petHealth));

  // Redirect to summary page
  window.location.href = "pet-health-history.html";
});
*/

/*
const API_BASE = "http://localhost:8080";  // your backend base URL

// Load Appointments
document.addEventListener("DOMContentLoaded", () => {
    fetch(`${API_BASE}/demo/appointments`)
        .then(res => res.json())
        .then(data => renderAppointments(data))
        .catch(err => console.error("Error fetching appointments:", err));

    // handle save health
    document.getElementById("healthForm").addEventListener("submit", saveHealth);
});

// Render appointments list
function renderAppointments(appointments) {
    const listDiv = document.getElementById("appointmentsList");
    listDiv.innerHTML = "";

    if (!appointments || appointments.length === 0) {
        listDiv.innerHTML = "<p>No appointments found.</p>";
        return;
    }

    appointments.forEach(app => {
        const card = document.createElement("div");
        card.className = "card p-3 mb-2";

        card.innerHTML = `
            <p><strong>Pet:</strong> ${app.petName}</p>
            <p><strong>Owner:</strong> ${app.ownerName}</p>
            <p><strong>Date:</strong> ${app.date}</p>
            <p><strong>Vet:</strong> ${app.vetName}</p>
            <button class="btn btn-primary btn-sm" onclick="openHealthModal(${app.petId}, '${app.petName}', '${app.ownerName}', '${app.vetName}', '${app.date}')">
                Update Health
            </button>
            <button class="btn btn-secondary btn-sm ms-2" onclick="viewHealth(${app.petId})">
                View Health Summary
            </button>
        `;
        listDiv.appendChild(card);
    });
}

// Open health form modal
function openHealthModal(petId, petName, ownerName, vetName, date) {
    document.getElementById("petId").value = petId;
    document.getElementById("vetName").value = vetName;
    document.getElementById("appointmentDate").value = date;
    document.getElementById("petNameDisplay").innerText = petName;
    document.getElementById("ownerNameDisplay").innerText = ownerName;

    const modal = new bootstrap.Modal(document.getElementById("healthModal"));
    modal.show();
}

// Save Pet Health
function saveHealth(e) {
    e.preventDefault();

    const petId = document.getElementById("petId").value;
    const healthData = {
        vetName: document.getElementById("vetName").value,
        appointmentDate: document.getElementById("appointmentDate").value,
        weight: document.getElementById("weight").value,
        temperature: document.getElementById("temperature").value,
        notes: document.getElementById("notes").value
    };

    fetch(`${API_BASE}/demo/pet-health/${petId}`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(healthData)
    })
        .then(res => {
            if (!res.ok) throw new Error("Failed to save health");
            return res.json();
        })
        .then(() => {
            alert("✅ Pet health updated successfully!");
            document.getElementById("healthForm").reset();
            bootstrap.Modal.getInstance(document.getElementById("healthModal")).hide();
        })
        .catch(err => {
            console.error(err);
            alert("❌ Failed to update pet health. Please try again.");
        });
}

// View Pet Health Summary (redirects to summary.html)
function viewHealth(petId) {
    window.location.href = `summary.html?petId=${petId}`;
}*/

