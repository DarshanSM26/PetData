// ---------------------------
// Load Navbar
// ---------------------------
async function loadNavbar() {
  try {
    const res = await fetch("/navbar.html");
    if (!res.ok) throw new Error("Failed to load navbar");

    const html = await res.text();
    document.getElementById("navbar").innerHTML = html;
  } catch (err) {
    console.error("Error loading navbar:", err);
  }
}

// ---------------------------
// Appointments Page
// ---------------------------
async function loadAppointments() {
  try {
    const res = await fetch("http://localhost:8080/demo/appointments"); // <-- adjust to your AppointmentController
    if (!res.ok) throw new Error("Failed to fetch appointments");

    const appointments = await res.json();
    let html = `<ul class="list-group">`;

    appointments.forEach(app => {
      html += `
        <li class="list-group-item">
          <strong>${app.petName}</strong> with ${app.vetName} on ${app.date}
        </li>
      `;
    });

    html += `</ul>`;
    document.getElementById("appointmentsList").innerHTML = html;
  } catch (err) {
    console.error("Error fetching appointments:", err);
    document.getElementById("appointmentsList").innerHTML =
      `<p class="text-danger">Failed to load appointments.</p>`;
  }
}

// ---------------------------
// Update Pet Health Page
// ---------------------------
async function loadPets() {
  try {
    const res = await fetch("http://localhost:8080/demo/pet/Feteching"); // PetController endpoint
    if (!res.ok) throw new Error("Failed to fetch pets");

    const pets = await res.json();
    const petSelect = document.getElementById("petId");

    pets.forEach(pet => {
      const option = document.createElement("option");
      option.value = pet.petid;   // your Pet entity field name
      option.textContent = pet.name; // display pet name
      petSelect.appendChild(option);
    });
  } catch (err) {
    console.error("Error fetching pets:", err);
  }
}

async function loadVets() {
  try {
    const res = await fetch("http://localhost:8080/demo/appointments"); // BookingController endpoint
    if (!res.ok) throw new Error("Failed to fetch vets");

    const bookings = await res.json();
    const vetSelect = document.getElementById("vetName");
    const vetSet = new Set();

    bookings.forEach(b => vetSet.add(b.vetName));

    vetSet.forEach(vet => {
      const option = document.createElement("option");
      option.value = vet;
      option.textContent = vet;
      vetSelect.appendChild(option);
    });
  } catch (err) {
    console.error("Error fetching vets:", err);
  }
}

async function submitPetHealth(e) {
  e.preventDefault();

  const petId = document.getElementById("petId").value;
  const weight = document.getElementById("weight").value;
  const temperature = document.getElementById("temperature").value;
  const notes = document.getElementById("notes").value;
  const vetName = document.getElementById("vetName").value;

  const petHealth = {
    weight,
    temperature,
    notes,
    vet_name: vetName
  };

  try {
    const res = await fetch(`http://localhost:8080/demo/pethealth/${petId}`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(petHealth)
    });

    if (!res.ok) throw new Error("Failed to save Pet Health");

    const saved = await res.json();
    alert("Pet Health saved successfully!");
    console.log(saved);
    document.getElementById("healthForm").reset();
  } catch (err) {
    console.error("Error saving Pet Health:", err);
    alert("Error saving Pet Health.");
  }
}
