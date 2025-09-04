console.log("✅ JS Loaded from:", document.currentScript.src);

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

  // show values in modal
  document.getElementById("petNameDisplay").innerText = petName;

  const modal = new bootstrap.Modal(document.getElementById("healthModal"));
  modal.show();
}

/*document.getElementById("healthForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const petId = document.getElementById("petId").value;
  const vetName = document.getElementById("vetName").value;
  const date = document.getElementById("appointmentDate").value;
  const weight = document.getElementById("weight").value;
  const temperature = document.getElementById("temperature").value;
  const notes = document.getElementById("notes").value;

  const petHealth = { vetName, checkup_date: date, weight, temperature, notes };

  try {
    const res = await fetch(`http://localhost:8080/demo/pethealth/${petId}`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(petHealth)
    });

    if (!res.ok) throw new Error("Failed to save health");

    alert("✅ Pet health saved!");
    document.getElementById("healthForm").reset();
    bootstrap.Modal.getInstance(document.getElementById("healthModal")).hide();
  } catch (err) {
    console.error("❌ Error saving health:", err);
    alert("Error saving health record.");
  }
});*/

document.getElementById("healthForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const petId = document.getElementById("petId").value;
  const vetName = document.getElementById("vetName").value;
  const date = document.getElementById("appointmentDate").value;
  const weight = document.getElementById("weight").value;
  const temperature = document.getElementById("temperature").value;
  const notes = document.getElementById("notes").value;

  const petHealth = { vetName, checkup_date: date, weight, temperature, notes };

  try {
    const res = await fetch(`http://localhost:8080/demo/pethealth/${petId}`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(petHealth)
    });

    const result = await res.json().catch(() => null); // Try to parse JSON
    console.log("Save Health Response:", res.status, result);

    if (!res.ok) throw new Error("Failed to save health");

    // ✅ If saved successfully → go to health history page
    window.location.href = `pet-health-history.html?petId=${petId}`;

  } catch (err) {
    console.error("Error saving health:", err);
    alert("Error saving health record.");
  }
});


// load on page load
loadAppointments();
