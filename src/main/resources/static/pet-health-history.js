console.log("✅ Pet Health History Loaded");

// Get petId from query string
const urlParams = new URLSearchParams(window.location.search);
const petId = urlParams.get("petId");

async function loadHealthHistory() {
  try {
    const res = await fetch(`http://localhost:8080/demo/pethealth/${petId}`);
    if (!res.ok) throw new Error("Failed to fetch health history");

    const history = await res.json();
    console.log("Pet Health History:", history);

    let html = `<ul class="list-group">`;

    history.forEach(h => {
      html += `
        <li class="list-group-item">
          <strong>Date:</strong> ${h.checkup_date} <br>
          <strong>Vet:</strong> ${h.vetName} <br>
          <strong>Weight:</strong> ${h.weight} kg <br>
          <strong>Temperature:</strong> ${h.temperature}°C <br>
          <strong>Notes:</strong> ${h.notes || "-"}
        </li>
      `;
    });

    html += `</ul>`;
    document.getElementById("historyList").innerHTML = html;

  } catch (err) {
    console.error("Error loading history:", err);
    document.getElementById("historyList").innerHTML =
      `<p style="color:red;">Error loading health history.</p>`;
  }
}

loadHealthHistory();
