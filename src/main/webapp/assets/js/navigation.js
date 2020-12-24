
let logout = document.getElementById("logout");

logout.addEventListener("click", async (e) => {
    logout.disabled = true;
    sessionStorage.clear();
    location.href = "index.jsp"
});

let welcome = document.getElementById("welcome-text");
welcome.innerHTML = "Welcome " + sessionStorage.getItem("name");