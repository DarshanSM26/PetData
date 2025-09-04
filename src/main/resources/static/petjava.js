const BASE_URL = "/demo/pet";
const USER_URL = "/demo/user/all";

// Load Users into dropdown
async function loadUsers() {
  try {
    const res = await fetch(USER_URL);
    if (!res.ok) throw new Error("Failed to fetch users");
    const users = await res.json();

    const userSelect = document.getElementById("userId");
    userSelect.innerHTML = '<option value="">Select Owner</option>';
    users.forEach(user => {
      const option = document.createElement("option");
      option.value = user.userid;
      option.textContent = `${user.userid} - ${user.name}`;
      userSelect.appendChild(option);
    });
  } catch (err) {
    console.error(err);
    showMessage("⚠️ Failed to load users", true);
  }
}

// Load Pets
async function loadPets() {
  try {
    const res = await fetch(BASE_URL + "/Feteching");
    if (!res.ok) throw new Error("Failed to fetch pets");
    const pets = await res.json();

    const petList = document.getElementById("petList");
    petList.innerHTML = "";

    pets.forEach(pet => {
      const div = document.createElement("div");
      div.className = "col-md-4 mb-3";
      div.innerHTML = `
        <div class="pet-card">
          <div class="pet-title">${pet.name}</div>
          <div class="pet-breed">${pet.breed}</div>
          <div>Owner ID: ${pet.user?.userid || "N/A"}</div>
          <div>DOB: ${pet.dob}</div>
          <div>Gender: ${pet.gender}</div>
          <div>Vaccination: ${pet.vaccinationDetails || "N/A"}</div>
          <button class="btn btn-danger mt-2" onclick="deletePet(${pet.petId})">Delete</button>
        </div>
      `;
      petList.appendChild(div);
    });
  } catch (err) {
    console.error(err);
    showMessage("⚠️ Failed to load pets", true);
  }
}

// Add Pet
document.getElementById("petForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const userId = document.getElementById("userId").value;
  if (!userId) return showMessage("❌ Please select an owner!", true);

  const petData = {
    name: document.getElementById("name").value,
    breed: document.getElementById("breed").value,
    gender: document.getElementById("gender").value,
    dob: document.getElementById("dob").value,
    vaccinationDetails: document.getElementById("vaccination").value,
    user: { userid: parseInt(userId) }
  };

  try {
    const res = await fetch(BASE_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(petData)
    });
    if (!res.ok) throw new Error("Failed to add pet");

    showMessage("✅ Pet added successfully!");
    document.getElementById("petForm").reset();
    loadPets();
  } catch (err) {
    console.error(err);
    showMessage("❌ Failed to add pet", true);
  }
});

// Delete Pet
async function deletePet(id) {
  if (!confirm("Are you sure?")) return;
  try {
    const res = await fetch(BASE_URL + "/" + id, { method: "DELETE" });
    if (!res.ok) throw new Error("Failed to delete pet");
    showMessage("🗑️ Pet deleted successfully!");
    loadPets();
  } catch (err) {
    console.error(err);
    showMessage("❌ Failed to delete pet", true);
  }
}

// Show success/error message
function showMessage(msg, isError = false) {
  const el = document.getElementById("message");
  el.textContent = msg;
  el.style.color = isError ? "red" : "green";
}

// Initial load
window.onload = () => {
  loadUsers();
  loadPets();
};
