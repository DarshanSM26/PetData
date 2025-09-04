console.log("✅ vet-v2.js Loaded");

async function loadAppointments() {
  try {
    const res = await fetch("http://localhost:8080/demo/appointments");
    if (!res.ok) throw new Error("Failed to fetch appointments");

    const appointments = await res.json();
    console.log("Appointments JSON:", appointments);

    let html = `<ul class="list-group">`;

    appointments.forEach(app => {
      // Show only pet name
      const petName = app.pet?.name || "Unknown Pet";

      console.log("Pet Name Extracted:", petName);

      html += `
        <li class="list-group-item">
          <strong>Pet:</strong> ${petName}
        </li>
      `;
    });

    html += `</ul>`;
    document.getElementById("appointmentsList").innerHTML = html;

  } catch (err) {
    console.error("Error loading appointments:", err);
  }
}

loadAppointments();
