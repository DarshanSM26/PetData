console.log("✅ petpage.js Loaded");

const BASE_URL = "http://localhost:8080/demo/pet";

// Auto-fill owner name when modal is opened
document.addEventListener("DOMContentLoaded", () => {
  const loggedUser = JSON.parse(localStorage.getItem("loggedUser"));
  if (loggedUser) {
    document.getElementById("ownerName").value = loggedUser.username;
  }

  loadPets();

  // Handle Sell Pet form submit
  const sellPetForm = document.getElementById("sellPetForm");
  sellPetForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const loggedUser = JSON.parse(localStorage.getItem("loggedUser"));
    if (!loggedUser) {
      alert("⚠️ Please login first.");
      return;
    }

    const formData = new FormData(sellPetForm);

    const pet = {
      user: { id: loggedUser.id }, // send only userId
      name: formData.get("petName"),
      breed: formData.get("breed"),
      gender: formData.get("gender"),
      dob: formData.get("dob"),
      vaccinationDetails: formData.get("vaccinationDetails")
    };

    try {
      const res = await fetch(BASE_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(pet),
      });

      if (res.ok) {
        alert("✅ Pet added successfully!");
        sellPetForm.reset();
        document.getElementById("ownerName").value = loggedUser.username; // keep owner filled
        bootstrap.Modal.getInstance(document.getElementById("sellPetModal")).hide();
        loadPets();
      } else {
        const errText = await res.text();
        alert("❌ Failed to add pet: " + errText);
      }
    } catch (err) {
      console.error("Error:", err);
      alert("⚠️ Backend not reachable.");
    }
  });
});

// Fetch pets from backend
async function loadPets() {
  try {
    const res = await fetch(`${BASE_URL}/Feteching`);
    const pets = await res.json();

    const petsContainer = document.querySelector("#petsSection .row");
    petsContainer.innerHTML = "";

    pets.forEach((pet) => {
      const col = document.createElement("div");
      col.classList.add("col-md-4", "mb-4");

      col.innerHTML = `
        <div class="pet-card" data-pet-id="${pet.petId}" data-name="${pet.name}"
          data-breed="${pet.breed}" data-age="${pet.dob || "N/A"}"
          data-gender="${pet.gender}" data-img="pet_1.jpg">

          <img src="pet_1.jpg" class="pet-img">
          <div class="pet-title">${pet.name}</div>
          <div class="pet-breed">${pet.breed}</div>
          <button class="btn pet-card-btn btn-outline-primary w-100 explore-btn">Explore</button>
        </div>
      `;

      petsContainer.appendChild(col);
    });

    attachExploreEvents();
  } catch (err) {
    console.error("Error fetching pets:", err);
  }
}

// Attach explore modal events
function attachExploreEvents() {
  const petCards = document.querySelectorAll(".pet-card");

  petCards.forEach((card) => {
    function openModal() {
      const modalTitle = document.getElementById("petModalLabel");
      const modalImg = document.getElementById("modalPetImg");
      const modalDetails = document.getElementById("modalPetDetails");

      modalTitle.textContent = card.dataset.name;
      modalImg.src = card.dataset.img;

      const attrs = {
        Name: card.dataset.name,
        Breed: card.dataset.breed,
        DOB: card.dataset.age,
        Gender: card.dataset.gender
      };

      modalDetails.innerHTML = "";
      for (let key in attrs) {
        const li = document.createElement("li");
        li.classList.add("list-group-item");
        li.innerHTML = `<strong>${key}:</strong> ${attrs[key]}`;
        modalDetails.appendChild(li);
      }

      new bootstrap.Modal(document.getElementById("petModal")).show();
    }

    card.querySelector(".pet-img").addEventListener("click", openModal);
    card.querySelector(".explore-btn").addEventListener("click", openModal);
  });
}
